package calculator;

import calculator.controller.CalculatorController;

/** 프로그램 실행의 진입점 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CalculatorController calculator = new CalculatorController();
        calculator.run();
    }
}
