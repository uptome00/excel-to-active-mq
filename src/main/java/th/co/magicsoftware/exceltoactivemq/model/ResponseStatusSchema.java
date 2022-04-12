package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseStatusSchema {

    @NonNull
    private String code;
    private String description;


    public List<String> validate(List<String> message, String parentfield){

        if(this.code == null) {
            message.add("Error: Invalid field "+parentfield+"code");
        }

        return message;
    }

}
