package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class TransactionTypeSchema {


    @NonNull
    private String code;
    private String description;
    @NonNull
    private String drCr;


    public List<String> validate(List<String> message, String parentfield){

        if(this.code == null) {
            message.add("Error: Invalid field "+parentfield+"code");
        }

        return message;
    }

}
