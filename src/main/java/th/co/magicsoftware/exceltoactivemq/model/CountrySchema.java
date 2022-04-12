package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;
import java.util.Map;

public class CountrySchema {

    private String code;
    private String description;



    public CountrySchema() {
        super();
    }

    public CountrySchema(String code) {
        this.code = code;
    }

    public CountrySchema(String code, String description) {
        super();
        this.code = code;
        this.description = description;
    }
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
        String countryCodeValidate = validateProperties.get("model.validation.country.on");
        String countryCodeRegex = validateProperties.get("model.validation.country.regex");

        if(countryCodeValidate.equals("true")) {
            if(!this.code.matches(countryCodeRegex)) {
                message.add("ERROR: "+parentfield+"code Data wrong format [n3Code] ");
            }
        }

        return message;
    }

    @Override
    public String toString() {
        return "CountrySchema [code=" + code + ", description=" + description + "]";
    }
}
