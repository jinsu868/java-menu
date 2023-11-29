package menu.domain;

import java.util.ArrayList;
import menu.error.ErrorCode;

public class Coach {
    private static final int MIN_COACH_NAME_SIZE = 2;
    private static final int MAX_COACH_NAME_SIZE = 4;

    private String name;
    private DislikeMenu dislikeMenu;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        initDislikeMenu();
    }

    public String getName() {
        return name;
    }

    private void initDislikeMenu() {
        dislikeMenu = new DislikeMenu(new ArrayList<>());
    }

    public void updateDislikeMenu(DislikeMenu dislikeMenu) {
        this.dislikeMenu = dislikeMenu;
    }

    private void validateName(String name) {
        if (name.length() < MIN_COACH_NAME_SIZE || name.length() > MAX_COACH_NAME_SIZE) {
            throw ErrorCode.INVALID_COACH_NAME_SIZE.getException();
        }
    }

}
