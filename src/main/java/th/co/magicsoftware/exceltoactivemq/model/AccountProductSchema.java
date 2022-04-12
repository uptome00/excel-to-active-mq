package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class AccountProductSchema {

    @NonNull
    private String code;
    private String description;

    public List<String> validate(List<String> message, String parentfield, Map<String,String> validateProperties){

        if(this.code == null) {
            message.add("Error: Invalid field "+parentfield+"code");
        }

        return message;
    }

}
