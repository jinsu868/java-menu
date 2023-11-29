package menu.error;

public enum ErrorCode {
    INVALID_COACHES_SIZE("유효하지 않은 코치 숫자가 입력됐습니다."),
    INVALID_COACH_NAME_SIZE("코치 이름 수가 유효하지 않습니다."),
    DUPLICATE_DISLIKE_MENU_NAME("싫어하는 음식에 중복된 값이 들어왔습니다."),
    INVALID_DISLIKE_MENU_SIZE("싫어하는 음식의 수는 0~2만 가능합니다."),
    INVALID_MENU_INPUT("없는 메뉴를 입력했습니다.");


    private static final String MESSAGE_FORMAT = "[ERROR] %s";

    private String message;

    private ErrorCode(String message) {
        this.message = String.format(MESSAGE_FORMAT, message);
    }

    public String getMessage() {
        return message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
