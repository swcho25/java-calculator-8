package calculator.service;

import java.util.regex.Pattern;

public class SplitterService {
    public String[] splitInput(String input) {
        String customDelimiter = "";
        String inputs = input;

        if (input.startsWith("//")) {
            // "\n"만 사용하면 엔터값으로 인식하기 때문에 "\n"을 문자 자체로 인식하기 위해 "\\n" 사용
            int delimiterIndex = input.indexOf("\\n");
            if(delimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 선언 형식이 잘못되었습니다.");
            }
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
}
