package th.co.magicsoftware.exceltoactivemq.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class NetIncomeRangeSchema {
    private String code;
    private BigDecimal minimumAmount;
    private BigDecimal maximumAmount;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public BigDecimal getMinimumAmount() {
        return minimumAmount;
    }
    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }
    public BigDecimal getMaximumAmount() {
        return maximumAmount;
    }
    public void setMaximumAmount(BigDecimal maximumAmount) {
        this.maximumAmount = maximumAmount;
    }
    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.code == null) {
            message.add("Error: Invalid field "+parentfield+"code");
        }

        return message;
    }
    @Override
    public String toString() {
        return "IncomeRangeSchema [code=" + code + ", minimumAmount=" + minimumAmount + ", maximumAmount="
                + maximumAmount + "]";
    }
}
