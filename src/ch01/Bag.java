package ch01;

public class Bag {
    private Long amount;            // 현금
    private Invitation invitation;  // 초대장
    private Ticket ticket;          // 티켓

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
    /**
     * 이벤트에 당첨된 관람객의 가방 안에는 현금과 초대장이 들어있지만,
     * 이벤트에 당첨되지 않은 관람객의 가방 안에는 초대장이 들어있지 않을 것
     * => 가방의 상태: 현금+초대장 or 현금
     * => 이 제약을 강제할 수 있도록 생성자를 추가
    * */
    // 초대장 없이 현금만 보관
    public Bag(long amount) {
        this(null, amount);
    }

    // 현금과 초대장을 함께 보관
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    // 초대장의 보유 여부를 판단
    private boolean hasInvitation() {
        return invitation != null;
    }

    // 티켓의 소유를 판단
    public boolean hasTicket() {    // 티켓 소유 했는지
        return ticket != null;
    }

    // 초대장을 티켓으로 교환
    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // 현금을 증가시키거나 감소시킴
    private void minusAmount(Long amount) {
        this.amount -= amount;
    }
    public void plusAmount(Long amount) {
        this.amount += amount;
    }


}
