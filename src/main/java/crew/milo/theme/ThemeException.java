package crew.milo.theme;

import lombok.Getter;

@Getter
public class ThemeException extends RuntimeException {
    private final ThemeErrorCode errorCode;

    public ThemeException(ThemeErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public static class ThemeNotFoundException extends ThemeException {
        public ThemeNotFoundException(final ThemeErrorCode errorCode, String message) {
            super(errorCode, message);
        }
    }
}
