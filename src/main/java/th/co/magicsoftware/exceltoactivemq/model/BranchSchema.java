package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class BranchSchema {

    @NonNull
    private String code;
    private String name;


    public List<String> validate(List<String> message, String parentfield){

        if(this.code == null) {
            message.add("Wrror: Invalid field "+parentfield+"code");
        }

        return message;
    }
}
