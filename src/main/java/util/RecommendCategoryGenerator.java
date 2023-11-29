package util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.MenuCategory;


public class RecommendCategoryGenerator {
    private static final int MIN = 1;
    private static final int MAX = 5;
    public static String generate() {
        return MenuCategory.getCategoryById(Randoms.pickNumberInRange(MIN, MAX));
    }
}
