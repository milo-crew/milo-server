package crew.milo.theme;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ThemeErrorCode {
    THEME_NOT_FOUND(200001, "존재하지 않는 테마입니다."),
    ;

    private final int code;
    private final String message;
}
