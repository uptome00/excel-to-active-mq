package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class CompanySchema {

    @NonNull
    private String code;
    private String name;

}
