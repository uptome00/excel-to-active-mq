package th.co.magicsoftware.exceltoactivemq.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class RequestHeaderSchema {

    public enum REQUEST_HEADER_TYPE {
        MONETARY_TRANSACTION, LOGIN_TRANSACTION, SERVICE_ACCOUNT, SERVICE_CUSTOMER
    }

    protected String transactionNumber;
    private String sessionId;
    protected String tenantId;
    @NonNull
    protected String applicationCode;
    @NonNull
    protected String dataChannelCode;
    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
    protected Date transactionDatetime;
    protected String timeZone;
    protected UserSchema user;
    @NonNull
    protected TransactionTypeSchema transactionType;
    @NonNull
    protected ResponseStatusSchema responseStatus;


}
