package menu.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final static String INTRO_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final static String RESULT_INTRO_MESSAGE =
            "메뉴 추천 결과입니다.\n[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private final static String RECOMMEND_RESULT_MESSAGE =  "추천을 완료했습니다.";
    private final static String CATEGORY = "카테고리";
    private final static String DELIMITER = " | ";
    private final static String PREFIX = "[ ";
    private final static String SUFFIX = " ]";

    public void printIntroMessage() {
        System.out.println(INTRO_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printRecommendResult(List<String> menus, String name) {
        System.out.println(makePrintForm(menus, name));
    }

    public void printResultIntroMessage() {
        System.out.println(RESULT_INTRO_MESSAGE);
    }

    public void printResultCategoriesMessage(List<String> categories) {
        System.out.println(makePrintForm(categories, CATEGORY));
    }

    public void printRecommendResultMessage() {
        System.out.println(RECOMMEND_RESULT_MESSAGE);
    }
    private String makePrintForm(List<String> elements, String name) {
        List<String> result = new ArrayList<>();
        result.add(name);
        for (String element : elements) {
            result.add(element);
        }
        return result.stream()
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }
}
