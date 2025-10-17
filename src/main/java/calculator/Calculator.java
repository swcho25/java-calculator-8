package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {
    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
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
}