package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.error.ErrorCode;

public class InputView {
    private static final String COACH_INPUT_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String COMMA = ",";
    private static final String DISLIKE_MENU_INPUT_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 5;

    public List<String> readCoaches() {
        System.out.println(COACH_INPUT_MESSAGE);
        String input = Console.readLine();
        List<String> coachNames = convertCoaches(input);
        validateCoachLength(coachNames);
        return coachNames;
    }

    public List<String> readDislikeMenu(String coachName) {
        System.out.println(String.format(DISLIKE_MENU_INPUT_MESSAGE, coachName));
        String input = Console.readLine();
        return convertDislikeMenu(input);
    }

    private List<String> convertDislikeMenu(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private List<String> convertCoaches(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void validateCoachLength(List<String> coachNames) {
        if (coachNames.size() < MIN_SIZE || coachNames.size() > MAX_SIZE) {
            throw ErrorCode.INVALID_COACHES_SIZE.getException();
        }
    }
}
