package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.error.ErrorCode;

public class InputView {
    private static String COACH_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static String COMMA = ",";
    private static int COACH_MIN_SIZE = 2;
    private static int COACH_MAX_SIZE = 5;

    public List<String> readCoaches() {
        System.out.println(COACH_INPUT_MESSAGE);
        String[] input = Console.readLine().split(COMMA);
        return convertCoaches(input);
    }

    private List<String> convertCoaches(String[] input) {
        return Arrays.stream(input)
                .map(coach -> coach.trim())
                .collect(Collectors.toList());
    }


}
