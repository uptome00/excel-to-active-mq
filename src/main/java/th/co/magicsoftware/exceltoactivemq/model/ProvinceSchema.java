package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;
import java.util.Map;

public class ProvinceSchema {
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
        return "ProvinceSchema [code=" + code + ", description=" + description + "]";
    }

}
