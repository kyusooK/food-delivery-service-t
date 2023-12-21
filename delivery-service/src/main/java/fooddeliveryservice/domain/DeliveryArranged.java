package fooddeliveryservice.domain;

import fooddeliveryservice.domain.*;
import fooddeliveryservice.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class DeliveryArranged extends AbstractEvent {

    private Long deliveryId;

    public DeliveryArranged(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryArranged() {
        super();
    }
}
//>>> DDD / Domain Event
