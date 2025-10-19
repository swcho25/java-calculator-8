package calculator.service;

/** 입력된 문자열을 검증하는 클래스 */
public class ValidatorService {

    /**
     * 입력된 문자열을 검증합니다.
     * @param input 입력된 문자열
     * @throws IllegalArgumentException 문자열이 정상 입력되지 않았을 때 예외 발생
     */
    public void checkInput(String input) {
        // 입력 요청 시 값이 입력되지 않은 경우
        if(input==null) {
            throw new IllegalArgumentException("입력 값이 비어있습니다.");
        }
        // 입력된 문자열에 구분자가 존재하지 않는 경우
        boolean hasCommon = input.contains(",")||input.contains(":");
        boolean hasCustom = input.startsWith("//");
        if(!hasCommon && !hasCustom) {
            throw new IllegalArgumentException("구분자가 존재하지 않습니다.");
        }
        // 입력된 문자열에 구분자만 작성된 경우
        if(input.matches("^[^0-9]+$")) {
            throw new IllegalArgumentException("숫자가 입력되지 않았습니다.");
        }
    }
}
