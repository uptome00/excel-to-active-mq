package th.co.magicsoftware.exceltoactivemq.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.magicsoftware.exceltoactivemq.model.RequestHeaderSchema;
import th.co.magicsoftware.exceltoactivemq.model.RequestHeaderTransactionSchema;
import th.co.magicsoftware.exceltoactivemq.model.TransactionSchema;
import th.co.magicsoftware.exceltoactivemq.repository.ExcelRepository;
import th.co.magicsoftware.exceltoactivemq.service.ExcelService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@RestController
@Controller
@Slf4j
@Data
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void allCase(String path, String sheetName) throws  IOException  {
        excelService = new ExcelService(path);
        int lastRow = excelService.getLastRowNumber(sheetName);
        IntStream.rangeClosed(3,lastRow).forEach(round -> {
            Map<String,Object> map = excelService.mapData(sheetName,1,2,round);
            try {
                sendQueue(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }

    public void selectCase(String path, String sheetName, String caseNumber) throws  IOException {
        excelService = new ExcelService(path);
        List<Integer> caseNumberLenght  = excelService.getCaseNumberLenght(sheetName, caseNumber);
        ExcelRepository excelRepository = new ExcelRepository(path);
        int sheetIndex = excelRepository.getSheetIndexBySheetName(sheetName);
        XSSFSheet sheet = excelRepository.getSheetBySheetIndex(sheetIndex);
        IntStream.rangeClosed(caseNumberLenght.get(0),caseNumberLenght.get(1)).forEach(round -> {
            Map<String,Object> map = excelService.mapData(sheetName,1,2 ,round);
            try {
                sendQueue(map);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
    }


    @GetMapping("/print")
    public void print() throws IOException {
        String path = "D:/Ratchanon/project/spring/svn/trunk/excel-to-active-mq/src/main/resources/excelfile/testObject.xlsx";
        String sheetName = "sheet1";
        String caseNumber = "SIT-ORM-BRH003-002";
        selectCase(path,sheetName,caseNumber);
//        allCase(path,sheetName);
    }




    public void sendQueue(Object map) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTransaction = objectMapper.writeValueAsString(map);
        TransactionSchema transactionSchema = objectMapper.readValue(jsonTransaction,TransactionSchema.class);
        long Start = System.currentTimeMillis();
        jmsTemplate.send("cfrm_gsb_mobile",session -> {
            String json = null;
            try {
                json = objectMapper.writeValueAsString(transactionSchema);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return session.createTextMessage(json);
        });
        long End = System.currentTimeMillis();
        System.out.println("total time: "+ (End-Start) + "/ Thred Name: " + Thread.currentThread().getId());
    }
}