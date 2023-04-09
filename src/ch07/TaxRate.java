package ch07;

import java.util.Arrays;
import java.util.Map;

public class TaxRate {
    private static String[] employees = {"유수완", "홍길동"};
    private static double[] basePays = {400, 300};

    // 직원의 급여를 계산한다
    public static void main(String[] args) {
        String name = "유수완";

        // 1. 사용자로부터 소득세율을 입력받는다.
        double taxRate = getTaxRate();

        // 2. 직원의 급여를 계산한다
        double pay = calculatePayFor(name, taxRate);

        // 3. 양식에 맞게 결과를 출력한다.
        System.out.println(describeResult(name, pay));
    }

    private static double getTaxRate() {
        // 1. '세율을 입력하세요:' 라는 문장을 화면에 출력한다.
        // 2. 키보드를 통해 세율을 입력받는다 (생략)
        System.out.println("세율을 입력하세요 : ");
        return 3.3;
    }

    private static double calculatePayFor(String name, double taxRate) {
        // 1. 전역 변수에 저장된 직원의 기본급 정보를 얻는다.
        int index = Arrays.asList(employees).indexOf(name);
        double basePay = basePays[index];
        // 2. 급여를 계산한다.
        return basePay - (basePay * taxRate);
    }

    private static String describeResult(String name, double pay) {
        return "이름 : " + name + ", 급여 :" + pay;
    }

}
