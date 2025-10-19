package calculator.view;

import camp.nextstep.edu.missionutils.Console;

/** 입력을 담당하는 View 클래스 */
public class InputView {

    /** Console을 통해 사용자로부터 값을 입력 받음 */
    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
