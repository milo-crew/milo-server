package crew.milo.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode {
    USER_NOT_FOUND(100001, "존재하지 않는 사용자입니다."),
    ;

    private final int code;
    private final String message;


}
