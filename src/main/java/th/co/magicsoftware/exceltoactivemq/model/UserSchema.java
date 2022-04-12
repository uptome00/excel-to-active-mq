package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserSchema {

    @NonNull
    private String name;
    private String typeCode;


    public List<String> validate(List<String> message, String parentField){

        if(this.typeCode == null) {
            message.add("Invalid field "+parentField+"uniqueKey");
        }else {
            if(!(this.typeCode.equals("CUSTOMER") |
                    this.typeCode.equals("EMPLOYEE") )
            ) {
                message.add("ERROR: "+parentField+"type[" + typeCode + "] Data is not supported.");
            }
        }
        if(this.name == null) {
            message.add("Invalid field "+parentField+"userName");
        }

        return message;
    }

}
