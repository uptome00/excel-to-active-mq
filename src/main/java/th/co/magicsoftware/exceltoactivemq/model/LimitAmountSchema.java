package th.co.magicsoftware.exceltoactivemq.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class LimitAmountSchema {

    @NonNull
    private String transactionCategoryCode;
    @NonNull
    private BigDecimal limitAmount;

}
