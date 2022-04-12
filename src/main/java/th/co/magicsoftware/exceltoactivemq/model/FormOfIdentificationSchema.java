package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;
import java.util.Map;

public class FormOfIdentificationSchema {
    private FormOfIdentificationTypeSchema type;
    private String number;

    public FormOfIdentificationTypeSchema getType() {
        return type;
    }
    public void setType(FormOfIdentificationTypeSchema type) {
        this.type = type;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.type == null) {
            message.add("Error: Invalid field "+parentfield+"type");
        }
        if(this.number == null) {
            message.add("Error: Invalid field "+parentfield+"number");
        }
        return message;
    }

    @Override
    public String toString() {
        return "FormOfIdentification [type=" + type + ", number=" + number + "]";
    }
}
