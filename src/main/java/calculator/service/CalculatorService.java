package calculator.service;

/**
 * 입력받은 문자열을 검증하고 분리한 후 합계를 계산하는 서비스 클래스입니다.
 * validator, splitter, checker를 조합하여 계산을 수행합니다.
 */
public class CalculatorService {
    private final ValidatorService validator;
    private final SplitterService splitter;
    private final CheckerService checker;

    /** CalculatorService 클래스 기본 생성자입니다. */
    public CalculatorService() {
        this.validator = new ValidatorService();
        this.splitter = new SplitterService();
        this.checker = new CheckerService();
    }

    /**
     * 입력 받은 문자열을 계산하여 결과를 반환합니다.
     * @param input 사용자 입력 문자열
     * @return 분리된 모든 수의 합
     */
    public int calculate(String input) {

        validator.checkInput(input);

        String[] inputs = splitter.splitInput(input);

        int sum = 0;
        for(String s: inputs) {
            int num = checker.checkNumber(s, sum);
            sum += num;
        }
        return sum;
    }
}
