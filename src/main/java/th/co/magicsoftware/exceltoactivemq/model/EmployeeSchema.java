package th.co.magicsoftware.exceltoactivemq.model;

import java.util.List;

public class EmployeeSchema {

    private String uniqueKey;
    private String number;
    private String firstName;
    private String lastName;


    public EmployeeSchema() {
        super();
    }
    public EmployeeSchema(String uniqueKey, String number, String firstName, String lastName) {
        super();
        this.uniqueKey = uniqueKey;
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getUniqueKey() {
        return uniqueKey;
    }
    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> validate(List<String> message, String parentField){

        if(this.uniqueKey == null) {
            message.add("Invalid field "+parentField+"uniqueKey");
        }
        if(this.number == null) {
            message.add("Invalid field "+parentField+"number");
        }

        return message;
    }
    @Override
    public String toString() {
        return "EmployeeSchema [number=" + number + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
