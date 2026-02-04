package Homework.day2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TicketService {
    private final Map<Long, TicketEntity> db = new HashMap<>();

    /**
     * getAvailableTickets 함수 구현
     * TODO 1: Stream API를 사용하여 특정 등급(TicketType)의 '예매 가능' 티켓 목록을 ResponseDTO로 변환하여 반환하세요.
     * (.collect(Collectors.toList()) 사용) or toList() 사용
     */

    public List<ResponseDTO> getAvailableTickets(TicketType type) {
        return db.values().stream()
                .filter(t -> t.getType() == type)
                .filter(TicketEntity::isReady)
                .map(ResponseDTO::new)
                .toList();
    }


    /**
     * reserve 함수 구현
     * TODO 2: 예매 로직을 구현하세요. (Optional & Custom Exception)
     * 1. 티켓 존재 여부 확인 -> 없으면 TicketBusinessException(적합한 ticket error code)
     * 2. 예매 가능 상태 확인 -> 아니면 TicketBusinessException(적합한 ticket error code)
     * 3. 상태 변경 (Happy Path)
     * response dto 로 반환 할 것
     */
    public ResponseDTO reserve(Long id) {
        TicketEntity entity = Optional.ofNullable(db.get(id)).orElseThrow(() -> new TicketException(TicketErrorCode.NOT_FOUND));

        if (!entity.isReady()) {
            throw new TicketException(TicketErrorCode.ALREADY_RESERVED);
        }

        entity.reserve();

        return new ResponseDTO(entity);

    }

    /**
     * calculateRevenue 함수 구현
     * TODO 3: 매출 계산 (Stream 활용)
     * RESERVED 상태인 티켓들의 calculateTotalPrice() 합계를 구하세요.
     */

    public double calculateRevenue() {
        return db.values().stream()
                .filter(t -> t.getStatus()==TicketStatus.RESERVED)
                .mapToDouble(t -> t.getType().calc())
                .sum();
    }
}
