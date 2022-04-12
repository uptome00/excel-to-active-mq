package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class AccountSchema {

    @NonNull
    private String accountNumber;
    private String accountName;
    private AccountProductSchema accountProduct;
    @NonNull
    private FinancialInstitutionSchema financialInstitution;



    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.accountNumber == null) {
            message.add("Error: Invalid field "+parentfield+"accountNumber");
        }
        if(this.financialInstitution == null) {
            message.add("Error: Invalid field "+parentfield+"financialInstitution");
        }else {
            message = this.financialInstitution.validate(message, parentfield, validateProperties);
        }

        return message;
    }

}
