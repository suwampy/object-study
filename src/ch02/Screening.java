package ch02;

import java.time.LocalDateTime;

// 상영 : 실제로 관객들이 영화를 관람하는 사건을 표현. 사용자가 실제로 예매하는 대상
public class Screening {
    private Movie movie; // 상영할 영화
    private int sequence; // 순번
    private LocalDateTime whenScreened; // 상영 시작 시간

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    // 상영 시작 시간을 반환
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    // 순번의 일치 여부를 검사
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    // 기본 요금을 반환
    public Money getMovieFee() {
        return movie.getFee();
    }

    /**
     * 영화를 예매한 후 예매 정보를 담고 있는 Reservation의 인스턴스를 생성해서 반환
     * - customer : 예매자에 대한 정보
     * - audienceCount : 인원 수
     * */
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    /**
     * 요금을 계산하는 메서드
     **/
    private Money calculateFee(int audienceCount) {
        // Screening이 Movie의 내부 구현에 대한 어떤 지식도 없이 전송할 메시지를 결정했음
        // Movie의 구현을 고려하지 않고, 필요한 메시지를 결정하면 Moive의 내부 구현을 깔끔하게 캡슐화 할 수 있음
        // Screening과 Movie를 연결하는 유일한 연결 고리는 메시지 뿐
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    /**
     * 상영 시간 정보
     * */
    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

}
