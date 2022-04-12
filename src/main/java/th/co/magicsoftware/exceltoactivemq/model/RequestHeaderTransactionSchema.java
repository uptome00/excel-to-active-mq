package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestHeaderTransactionSchema extends RequestHeaderSchema {

    public enum REQUEST_HEADER_TYPE {
        MONETARY_TRANSACTION, LOGIN_TRANSACTION, SERVICE_ACCOUNT, SERVICE_CUSTOMER
    }

    private REQUEST_HEADER_TYPE type;


    public List<String> validate(List<String> message, String parentField, Map<String,String> validateProperties){

        if(this.transactionNumber == null) {
            message.add("ERROR: Invalid field "+parentField+"requestId");
        }
        if(this.tenantId == null) {
            message.add("ERROR: Invalid field "+parentField+"tenantId");
        }
        if(this.type == null) {
            message.add("ERROR: Invalid field "+parentField+"type");
        }else {
            if(!(this.type.name().equals("MONETARY_TRANSACTION") |
                    this.type.name().equals("LOGIN_TRANSACTION") |
                    this.type.name().equals("SERVICE_ACCOUNT") |
                    this.type.name().equals("SERVICE_CUSTOMER"))
            ){
                message.add("ERROR: "+parentField+"type[" + type + "] Data is not supported.");
            }
        }
        if(this.applicationCode == null) {
            message.add("ERROR: Invalid field "+parentField+"applicationCode");
        }
        if(this.dataChannelCode == null) {
            message.add("ERROR: Invalid field "+parentField+"dataChannelCode");
        }
        if(this.transactionDatetime == null) {
            message.add("ERROR: Invalid field "+parentField+"transactionDatetime");
        }
        if(this.user != null) {
            message = this.user.validate(message, parentField+"user.");
        }
        if(this.transactionType == null) {
            message.add("ERROR: Invalid field "+transactionType+"transactionDatetime");
        }else {
            message = this.transactionType.validate(message, parentField+"transactionType.");
        }
        return message;
    }
}
