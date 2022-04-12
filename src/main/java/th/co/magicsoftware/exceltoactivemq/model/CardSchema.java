package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;
import java.util.Map;

public class CardSchema {
    private String cardNumber;
    private CardProductSchema cardProduct;
    private FinancialInstitutionSchema financialInstitution;


    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public CardProductSchema getCardProduct() {
        return cardProduct;
    }
    public void setCardProduct(CardProductSchema cardProduct) {
        this.cardProduct = cardProduct;
    }
    public FinancialInstitutionSchema getFinancialInstitution() {
        return financialInstitution;
    }
    public void setFinancialInstitution(FinancialInstitutionSchema financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.cardNumber == null) {
            message.add("Error: Invalid field "+parentfield+"cardNumber");
        }
        if(this.cardProduct != null) {
            message = this.cardProduct.validate(message, parentfield, validateProperties);
        }
        if(this.financialInstitution != null) {
            message = this.financialInstitution.validate(message, parentfield, validateProperties);
        }

        return message;
    }

}
