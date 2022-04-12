package th.co.magicsoftware.exceltoactivemq.model;


import java.util.List;


public class DeviceSchema {

    private String uniqueKey;
    private String terminalId;
    private String name;
    private String type;
    private FinancialInstitutionSchema financialInstitution;


    public DeviceSchema() {
        super();
    }

    public DeviceSchema(String uniqueKey, String terminalId, String name, String type) {
        this.uniqueKey = uniqueKey;
        this.terminalId = terminalId;
        this.name = name;
        this.type = type;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public FinancialInstitutionSchema getFinancialInstitution() {
        return financialInstitution;
    }

    public void setFinancialInstitution(FinancialInstitutionSchema financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public List<String> validate(List<String> message, String parentField){

        if(this.uniqueKey == null) {
            message.add("Invalid field "+parentField+"device.uniqueKey");
        }
        if(this.terminalId == null) {
            message.add("Invalid field "+parentField+"device.terminalId");
        }
        if(this.type == null) {
            message.add("Invalid field "+parentField+"device.type");
        }else {
            if(!(this.type.equals("COMPUTER") |
                    this.type.equals("WEB") |
                    this.type.equals("ATM") |
                    this.type.equals("MOBILE"))
            ) {
                message.add("ERROR: "+parentField+"device.type[" + type + "] Data is not supported.");
            }
        }
        return message;
    }

    @Override
    public String toString() {
        return "DeviceSchema [terminalId=" + terminalId + ", name=" + name + ", type=" + type + "]";
    }

}
