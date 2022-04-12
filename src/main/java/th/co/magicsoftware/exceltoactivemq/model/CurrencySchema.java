package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;
import java.util.Map;

public class CurrencySchema {

    public CurrencySchema() {
    }

    public CurrencySchema(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.code == null) {
            message.add("Error: Invalid field "+parentfield+"code");
        }

        return message;
    }
    @Override
    public String toString() {
        return "CurrencySchema [code=" + code + ", description=" + description + "]";
    }
}
