package crew.milo.theme;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ThemeResponse {

    @Getter
    @NoArgsConstructor
    public static class ThemeSearchResponse {
        @Schema(description = "전체 테마 개수", examples = "10")
        private int totalCount;
        @Schema(description = "테마 목록")
        private List<ThemeInfoResponse> themas = new ArrayList<>();
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ThemeInfoResponse {
        @Schema(description = "테마 UUID", examples = "018f4a5e-7c8a-7a1b-8c9d-0e1f2a3b4c5d")
        private UUID uuid;
        @Schema(description = "유형 종류")
        private Category category;
        @Schema(description = "사용자 수", examples = "5")
        private int userCount;
        @Schema(description = "테마 생성 시간", examples = "2025-03-12T10:15:30Z")
        private OffsetDateTime createdAt;

        public static ThemeInfoResponse from(final Theme theme, final int userCount) {
            return new ThemeInfoResponse(
                    theme.getUuid(),
                    Category.THEME,
                    userCount,
                    theme.getCreatedAt()
            );
        }
    }
}
