package th.co.magicsoftware.exceltoactivemq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBodySchema {

    private String transactionReferenceNumber;
    private String billPayReferenceNumber1;
    private String billPayReferenceNumber2;
    private AccountSchema account;
    private CustomerSchema customer;
    private AccountSchema destinationAccount;
    private CustomerSchema destinationCustomer;
    private BigDecimal amount;
    private BigDecimal ledgerBalance;
    private BigDecimal fee;
    private String promptPayNumber;
    private String promptPayType;
    private CompanySchema company;
    private LimitAmountSchema limitAmount;
    private String email;
    private String phoneNumber;
    private BranchSchema branch;

    public List<String> validate(List<String> message, String parentField,Map<String,String> validateProperties){

        /**
         *  To Do Validate
         */

        return message;
    }

}
