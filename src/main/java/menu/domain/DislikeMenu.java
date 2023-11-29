package menu.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.error.ErrorCode;

public class DislikeMenu {
    private List<String> names;

    public DislikeMenu(List<String> names) {
        validateDuplication(names);
        this.names = names;
    }

    private void validateDuplication(List<String> names) {
        Set<String> nameChecker = new HashSet<>();
        if (nameChecker.contains(names)) {
            throw ErrorCode.DUPLICATE_DISLIKE_MENU_NAME.getException();
        }
    }
}
