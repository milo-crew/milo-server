package crew.milo.theme;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    THEME("테마"),
    STORY("스토리"),
    ;

    private final String description;

    @JsonValue
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
