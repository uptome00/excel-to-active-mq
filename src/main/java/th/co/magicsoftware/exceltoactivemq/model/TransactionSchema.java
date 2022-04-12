package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TransactionSchema {

    @NonNull
    private RequestHeaderTransactionSchema requestHeader;
    private RequestBodySchema requestBody;


    public List<String> validate(List<String> message, String parentField, Map<String,String> validateProperties){

        if(this.requestHeader == null) {
            message.add("Invalid field requestHeader");
        }else {
            message = this.requestHeader.validate(message,"requestHeader.",validateProperties);

            if(this.requestHeader.getType() == RequestHeaderTransactionSchema.REQUEST_HEADER_TYPE.MONETARY_TRANSACTION) {
                if(this.requestBody == null) {
                    message.add("ERROR: Invalid field requestBody.");
                }
            }
        }

        if(this.requestBody != null) {
            message = this.requestBody.validate(message,"requestBody.",validateProperties);
        }else {
            //message = this.applicationFormBody.validate(message);
        }



        return message;
    }
}
