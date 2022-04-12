package th.co.magicsoftware.exceltoactivemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import th.co.magicsoftware.exceltoactivemq.model.RequestHeaderTransactionSchema;
import th.co.magicsoftware.exceltoactivemq.model.TransactionSchema;

@Component
public class ApplicationRunnerBean implements ApplicationRunner {

    @Autowired
    ExcelController excelController;

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        String path = "D:/Ratchanon/project/spring/ExcelToJson/resource/test.xlsx";
        String sheetName = "sheet1";
        String caseNumber = "SIT-ORM-BRH003-001";



//        excelController.selectCase(path,sheetName,caseNumber);
//		excelController.allCase(path, sheetName);
//		excelController.selectCase(path,sheetName,caseNumber);
    }
}
