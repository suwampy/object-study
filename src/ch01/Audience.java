package ch01;

// 관람객
public class Audience {
    // 관람객은 소지품을 보관하기 위해 가방을 소지할 수 있다.
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    // public Bag getBag() {
    //    return bag;
    // }

    /**
     * 해당 메소드를 통해 Audience는 자신의 가방 안에 초대장이 들어있는지를 스스로 확인할 수 있다
     * 외부의 제3자가 자신의 가방을 열어보도록 허용하지 않음
     * Audience가 Bag를 직접 처리하기 떄문에 외부에서는 더이상 Audience가 Bag을 소유하고 있다는 사실을 알 필요가 없음
     * */
    /**
     * 3. Audience 캡슐화 개선
     * - 관람객(Audience)의 역할: 가방에 초대장이 들어있는지를 확인한다
     * - Bag를 자율적인 존재로 변경
     * - 가방이 비어있는지 아닌지 확인하는 역할을 Bag에게 위임
     * */
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
//        if (bag.hasInvitation()) {
//            bag.setTicket(ticket);
//            return 0L;
//        } else {
//            bag.setTicket(ticket);
//            bag.minusAmount(ticket.getFee());
//            return ticket.getFee();
//        }
    }
}
