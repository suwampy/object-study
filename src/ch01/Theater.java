package ch01;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    // 관람객을 맞이할 수 있도록
    public void enter(Audience audience) {
        /**
         * refactor: 다음과 같은 코드가 작성된다면
         * Theather는 관람객이 가방을 들고 있고 판매원이 매표소에서만 티켓을 판매한다는
         * 지나치게 세부적인 사실에 의존해서 동작하게 됨
         * => theater가 audience와 ticketseller에 관해 너무 세세한 부분까지 알지 못하도록 정보를 차단하자
         * => theather가 원하는 것은 관람객이 소극장에 입장하는 것뿐
         * => 관람객(Audience)과 판매원(Theater)을 자율적인 존재로 만들자
         * 1. TicketOffice에 접근하는 모든 코드를 TicketSeller 내부로 숨기자
         * */
//        if (audience.getBag().hasInvitation()) {
//            // 초대장이 있다면 -> 이벤트에 당첨된 관람객
//            // 판매원에게서 받은 티켓을 관람객의 가방 안에 넣어준다.
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().setTicket(ticket);
//        } else {
//            // 초대장이 없다면 -> 티켓을 판매해야 한다.
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketOffice.plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }
        // 초대장이 있는지
        ticketSeller.sellTo(audience);
    }
}
