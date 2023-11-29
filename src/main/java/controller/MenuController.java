package controller;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Coach;
import menu.domain.DislikeMenu;
import menu.view.InputView;
import menu.view.OutputView;

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
