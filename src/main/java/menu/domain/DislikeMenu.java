package menu.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.error.ErrorCode;

public class DislikeMenu {
    private static final int MIN_SIZE = 0;
    private static final int MAX_SIZE = 2;

    private List<String> names;

    public DislikeMenu(List<String> names) {
        validateLength(names);
        validateDuplication(names);
        this.names = names;
    }

    private void validateDuplication(List<String> names) {
        Set<String> nameChecker = new HashSet<>();
        if (nameChecker.contains(names)) {
            throw ErrorCode.DUPLICATE_DISLIKE_MENU_NAME.getException();
        }
    }

    private void validateLength(List<String> names) {
        if (names.size() < MIN_SIZE || names.size() > MAX_SIZE) {
            throw ErrorCode.INVALID_DISLIKE_MENU_SIZE.getException();
        }
    }
}
