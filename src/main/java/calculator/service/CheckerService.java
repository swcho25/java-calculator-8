package calculator.service;

/** 구분자로 구분된 문자들이 정상 값인지 확인하는 클래스 */
public class CheckerService {

    /**
     * 구분자로 구분된 문자들을 확인한 후 검증이 완료되면 Integer로 형변환 후 반환합니다.
     * @param input 구분된 문자
     * @param sum 계산기에서 계산되고 있는 합계 값
     * @return 검증 완료된 문자를 Integer로 형변환 해 반환
     * @throws IllegalArgumentException 잘못된 형식의 문자인 경우
     */
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
