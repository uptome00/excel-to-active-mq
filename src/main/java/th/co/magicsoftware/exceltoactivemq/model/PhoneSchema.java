package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;
import java.util.Map;

public class PhoneSchema {
    private PhoneTypeSchema type;
    private String number;
    private String extension;

    public PhoneTypeSchema getType() {
        return type;
    }
    public void setType(PhoneTypeSchema type) {
        this.type = type;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }

    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.number == null) {
            message.add("Error: Invalid field "+parentfield+"code");
        }if(this.type == null) {
            message.add("Error: Invalid field "+parentfield+"type");
        }

        return message;
    }

    @Override
    public String toString() {
        return "PhoneSchema [type=" + type + ", number=" + number + ", extension=" + extension + "]";
    }

}
