package fooddeliveryservice.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceOrderCommandCommand {

    private List<FoodItem> foodItems;
    private int quantity;
    private String specialRequests;
}
