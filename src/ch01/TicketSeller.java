package ch01;

// 판매원 : 매표소에서 초대장을 ㅣ티켓으로 교환해 주거나 티켓을 판매하는 역할 수행
public class TicketSeller {
    // 자신이 일하는 매표소
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    /**
     * 외부에서 ticketOffice에 직접 접근할 수 없도록 막음
     * ticketOffice에 대한 접근은 오직 TicketSeller 안에만 존재하게 됨
     * TicketSeller는 ticketOffice에서 티켓을 꺼내거나 판매 요금을 적립하는 일을 스스로 수행할 수밖에 없음
     * */
//    public TicketOffice getTicketOffice() {
//        return ticketOffice;
//    }

    public void sellTo(Audience audience) {
        /**
         * 2. Audience 캡슐화 개선
         * */
        // ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
        ticketOffice.sellTicketTo(audience);
        /**
         * 4. ticketOffice의 자율권을 찾아주자
         * */
        //
        // if (audience.getBag().hasInvitation()) {
            // 초대장이 있다면 -> 이벤트에 당첨된 관람객
            // 판매원에게서 받은 티켓을 관람객의 가방 안에 넣어준다.
            //Ticket ticket = ticketOffice.getTicket();
        //     audience.getBag().setTicket(ticket);
        //} else {
            // 초대장이 없다면 -> 티켓을 판매해야 한다.
        //    Ticket ticket = ticketOffice.getTicket();
        //     audience.getBag().minusAmount(ticket.getFee());
        //    ticketOffice.plusAmount(ticket.getFee());
        //    audience.getBag().setTicket(ticket);
        //}
    }
}
