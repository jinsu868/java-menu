package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import constant.MenuCategory;
import java.util.ArrayList;
import java.util.List;

public class Recommend {
    private List<String> categories;

    public Recommend(List<String> categories) {
        this.categories = categories;
    }

    public List<String> recommendMenu(Coach coach) {
        List<String> recommendMenu = new ArrayList<>();
        int recommendCount = 0;
        while (recommendCount < 5) {
            String category = categories.get(recommendCount);
            List<String> menus = MenuCategory.getMenuByCategory(category);
            String menu = Randoms.shuffle(menus).get(0);
            if (recommendMenu.contains(menu) || coach.isDislikeMenu(menu)) {
                continue;
            }
            recommendCount++;
            recommendMenu.add(menu);
        }
        return recommendMenu;
    }
}
