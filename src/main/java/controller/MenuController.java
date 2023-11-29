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
        List<String> coachNames = getCoachNames();
        List<Coach> coaches = getCoaches(coachNames);
    }

    private List<String> getCoachNames() {
        while (true) {
            try {
                return inputView.readCoaches();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Coach> getCoaches(List<String> coachNames) {
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {
            DislikeMenu dislikeMenu = getDislikeMenu(name);
            coaches.add(new Coach(name, dislikeMenu));
        }
        return coaches;
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
