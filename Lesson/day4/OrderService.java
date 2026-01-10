package Lesson.day4;

import java.util.HashMap;
import java.util.logging.Logger;

public class OrderService {

    HashMap<Long, OrderEntity> repo = new HashMap<>();
    Long id = 1L;


    public void registerOrder(OrderRequest request) {
        OrderEntity entity = new OrderEntity(id, request, 1200, 100);
        repo.put(id++, entity);
    }

    public OrderResponse getReceipt(Long id) {
        OrderEntity entity = repo.get(id);

        String status;

        if (entity.isReady()) {
            status = "준비완료";
        } else {
            status = "준비중";
        }

        return new OrderResponse(
                entity.getMenuName(),
                entity.getQuantity(),
                entity.getQuantity() * entity.getPrice(),
                status
        );
    }

    public void completeOreder(Long id) {
        OrderEntity entity = repo.get(id);

        entity.complete();

        repo.put(id, entity);
    }


}
