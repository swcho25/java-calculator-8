package calculator.service;

public class CheckerService {
    public int checkNumber (String input, int sum) {
        try {
            int number = Integer.parseInt(input);

            // 양수가 아닌 경우
            if(number <= 0) {
                throw new IllegalArgumentException("입력된 수가 양수가 아닙니다.");
            }
            // 오버플로우가 발생하는 경우
            if(sum > Integer.MAX_VALUE-number) {
                throw new IllegalArgumentException("숫자 크기가 입력 가능한 범위를 초과했습니다.");
            }

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }
}
