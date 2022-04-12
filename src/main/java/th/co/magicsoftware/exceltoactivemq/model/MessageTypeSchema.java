package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;

public class MessageTypeSchema {
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
    public List<String> validate(List<String> message, String parentfield){

        if(this.code == null) {
            message.add("Error: Invalid field "+parentfield+"code");
        }

        return message;
    }
    @Override
    public String toString() {
        return "MessageTypeSchema [code=" + code + ", description=" + description + "]";
    }
}
