package util;

import camp.nextstep.edu.missionutils.Randoms;
import constant.MenuCategory;
import java.util.Arrays;
import java.util.List;

public class RecommendCategoryGenerator {
    public static String generate() {
        return MenuCategory.getCategoryById(Randoms.pickNumberInRange(1, 5));
    }
}
