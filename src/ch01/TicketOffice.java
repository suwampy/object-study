package ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 매표소
 * 매표소에는 초대장을 티켓으로 교환하거나 구매해야 한다.
 * 따라서 매표소에는 관람객에게 판매할 티켓과 티켓의 판매 금액이 보관돼 있어야 한다.
 * */
public class TicketOffice {
    private Long amount; // 판매 금액
    private List<Ticket> tickets = new ArrayList<>(); // 판매하거나 교환해 줄 티켓의 목록

    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    // 티켓을 판매
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    public Ticket getTicket() {
        return tickets.remove(0);
    }

    // 판매 금액을 더하거나 차감하는 메서드
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
