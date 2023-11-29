package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.domain.Coach;
import menu.domain.DislikeMenu;
import menu.domain.Recommend;
import menu.view.InputView;
import menu.view.OutputView;
import util.RecommendCategoryGenerator;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printIntroMessage();
        List<Coach> coaches = getCoaches();
        setDislikeMenu(coaches);
        recommendMenus(coaches);
        outputView.printRecommendResultMessage();
    }

    private void recommendMenus(List<Coach> coaches) {
        outputView.printResultIntroMessage();
        List<String> recommendCategories = getRecommendCategories();
        for (Coach coach : coaches) {
            Recommend recommend = new Recommend(recommendCategories);
            List<String> menus = recommend.recommendMenu(coach);
            outputView.printRecommendResult(menus, coach.getName());
        }
    }

    private List<String> getRecommendCategories() {
        int recommendCount = 0;
        List<String> categories = new ArrayList<>();
        Map<String, Integer> categoryCounter = new HashMap<>();
        while (recommendCount < 5) {
            String category = RecommendCategoryGenerator.generate();
            if (categoryCounter.containsKey(category) && categoryCounter.get(category) >= 2) {
                continue;
            }
            if (categoryCounter.containsKey(category)) {
                categoryCounter.put(category, categoryCounter.get(category) + 1);
                categories.add(category);
                recommendCount++;
                continue;
            }
            categoryCounter.put(category, 1);
            recommendCount++;
            categories.add(category);
        }
        outputView.printResultCategoriesMessage(categories);
        return categories;
    }

    private List<Coach> getCoaches() {
        while (true) {
            try {
                List<String> coachNames = inputView.readCoaches();
                return convertCoaches(coachNames);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Coach> convertCoaches(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {
            coaches.add(new Coach(name));
        }
        return coaches;
    }

    private void setDislikeMenu(List<Coach> coaches) {
        for (Coach coach : coaches) {
            coach.updateDislikeMenu(getDislikeMenu(coach.getName()));
        }
    }

    private DislikeMenu getDislikeMenu(String coachName) {
        while (true) {
            try {
                List<String> disLikeMenuNames = inputView.readDislikeMenu(coachName);
                return new DislikeMenu(disLikeMenuNames);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
