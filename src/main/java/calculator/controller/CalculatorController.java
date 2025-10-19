package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

/** 계산기 프로그램을 제어하는 컨트롤러 클래스 */
public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorService();

    /** 입력 받은 값을 calculatorService에 전달 후 결과를 출력 */
    public void run() {
        String input = InputView.readInput();
        int result = calculatorService.calculate(input);
        OutputView.printResult(result);
    }

}
