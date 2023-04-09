package ch05;


import java.time.LocalDateTime;

public class Screening {
    /**
     * 1. 영화를 예매할 책임을 맡는다
     * 2. Reservation 인스턴스를 생성할 책임을 수행해야한다
     * 3. 예메에 대한 정보 전문가인 동시에 Rservation의 창조자이다.
     * */

    private Movie movie;                    // '가격을 계산하라' 메시지 전송을 위한 참조
    private int sequence;                   // 상영 순번
    private LocalDateTime whenScreened;     // 상영 시간
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }


    private Money calculateFee(int audienceCount) {
        // movie의 내부 구현에 대한 지식 필요 없음 -> 캡슐화
        // 메시지만 결정
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
