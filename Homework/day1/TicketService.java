package Homework.day1;

import java.util.*;

public class TicketService {
    private final Map<Long, Ticket> ticketDb = new HashMap<>();

    //ticket=staus,type

    /**
     * getAvailableTickets 함수 구현
     * TODO 1: Stream API를 사용하여 특정 등급(TicketType)의 '예매 가능' 티켓 목록을 ResponseDTO로 변환하여 반환하세요.
     * (.collect(Collectors.toList()) 사용) or toList() 사용
     */
    public List<TicketResponse> getAvailableTickets(TicketType type) {
        return ticketDb.values().stream()
                .filter(ticket -> ticket.getType() == type)
                .filter(ticket -> ticket.getStatus().isReady())
                .map(TicketResponse::new)
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
    public TicketResponse reserve(ReservationRequest request) {
        Ticket ticket = Optional.ofNullable(ticketDb.get(request.getId())).orElseThrow(() -> new TicketBusinessException(TicketErrorCode.TICKET_NOT_FOUND));

        if (!ticket.getStatus().isReady()) {
            throw new TicketBusinessException(TicketErrorCode.ALREADY_RESERVED);
        }

        ticket.reserve();
        return new TicketResponse(ticket);
    }


    /**
     * calculateRevenue 함수 구현
     * TODO 3: 매출 계산 (Stream 활용)
     * RESERVED 상태인 티켓들의 calculateTotalPrice() 합계를 구하세요.
     */

    public float calculateRevenue(ReservationRequest request){
        return ticketDb.values().stream()
                .filter(ticket -> ticket.getStatus()==TicketStatus.RESERVED)
                .mapToLong(ticket-> (long) ticket.getType().calculateTotalPrice())
                .sum();
    }

    ArrayList<Integer> array=new ArrayList<>();
}
