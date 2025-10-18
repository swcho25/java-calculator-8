package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {
    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        checkInput(input);

        String[] inputs = splitInput(input);
        int result = calculateInput(inputs);
        System.out.println("결과: " + result);
    }

    private String[] splitInput(String input) {
        String customDelimiter = "";
        String inputs = input;

        if (input.startsWith("//")) {
            // "\n"만 사용하면 엔터값으로 인식하기 때문에 "\n"을 문자 자체로 인식하기 위해 "\\n" 사용
            int delimiterIndex = input.indexOf("\\n");
            // quote() -> .이나 ;와 같은 예약어와 같이 특별한 의미를 갖는 문자를 일반 문자로 인식하게 함
            customDelimiter = Pattern.quote(input.substring(2, delimiterIndex));
            inputs = input.substring(delimiterIndex + 2);
        }

        String delimiter = ",|:";
        if (!customDelimiter.isEmpty()) {
            delimiter += "|" + customDelimiter;
        }

        return inputs.split(delimiter);
    }

    private int calculateInput(String[] inputs) {
        int sum = 0;
        for(String input: inputs) {
            sum += Integer.parseInt(input);
        }
        return sum;
    }

    private void checkInput(String input) {
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
        // 입력된 문자열에 구분자가 비정상적으로 입력된 경우
        if(hasCustom) {
            if(!input.contains("\n")){
                throw new IllegalArgumentException("커스텀 구분자 선언 형식이 잘못되었습니다.");
            }
        }
    }
}