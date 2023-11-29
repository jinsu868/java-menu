package menu.domain;

import menu.error.ErrorCode;

public class Coach {
    private static final int MIN_COACH_NAME_SIZE = 2;
    private static final int MAX_COACH_NAME_SIZE = 4;

    private String name;
    private DislikeMenu dislikeMenu;

    public Coach(String name, DislikeMenu dislikeMenu) {
        validateName(name);
        this.name = name;
        this.dislikeMenu = dislikeMenu;
    }

    private void validateName(String name) {
        if (name.length() < MIN_COACH_NAME_SIZE || name.length() > MAX_COACH_NAME_SIZE) {
            throw ErrorCode.INVALID_COACHES_SIZE.getException();
        }
    }

}
