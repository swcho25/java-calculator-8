package calculator.service;

public class CalculatorService {
    private final ValidatorService validator;
    private final SplitterService splitter;
    private final CheckerService checker;

    public CalculatorService() {
        this.validator = new ValidatorService();
        this.splitter = new SplitterService();
        this.checker = new CheckerService();
    }

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
