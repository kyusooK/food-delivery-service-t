package fooddeliveryservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class ProvideSupportCommandCommand {

    private UUID orderId;
    private String supportMessage;
}
