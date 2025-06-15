package crew.milo.user;

import lombok.Getter;

@Getter
public class UserException extends RuntimeException {
    private final UserErrorCode userErrorCode;

    public UserException(final UserErrorCode userErrorCode, String message) {
        super(message);
        this.userErrorCode = userErrorCode;
    }

    public static class UserNotFoundException extends UserException {
        public UserNotFoundException(
                final UserErrorCode errorCode,
                final String message
        ) {
            super(errorCode, message);
        }
    }
}
