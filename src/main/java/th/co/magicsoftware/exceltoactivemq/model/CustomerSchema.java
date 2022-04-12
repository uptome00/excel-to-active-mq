package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomerSchema {

    @NonNull
    private String customerNumber;
    private String fullName;

    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.customerNumber == null) {
            message.add("Error: Invalid field "+parentfield+"customerNumber");
        }

        if(this.fullName == null) {
            message.add("Error: Invalid field "+parentfield+"fullName");
        }

        return message;
    }

}
