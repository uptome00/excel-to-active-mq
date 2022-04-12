package th.co.magicsoftware.exceltoactivemq.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import th.co.magicsoftware.exceltoactivemq.model.TransactionSchema;

import java.io.Serializable;

/**
 *
 * @author AJ Catambay of Bridging Code
 *
 */
@RestController
public class QueueController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody TransactionSchema transactionSchema) {
        try {
//            IntStream.range(0,2).forEach( t -> {
//                asyncService.sendQueue(transactionSchema);
//            });
            sendQueue(transactionSchema);
            return new ResponseEntity<>("sent.",HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void sendQueue(TransactionSchema transactionSchema) throws JsonProcessingException {
        long Start = System.currentTimeMillis();
        jmsTemplate.send("cfrm_gsb_mobile",session -> {
            ObjectMapper objectMapper = new ObjectMapper();
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
