package crew.milo.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StoryRequest {
    @Getter
    @NoArgsConstructor
    public static class StartStoryRequest {
        @Schema(description = "사용자 ID", examples = "ABABABAB")
        @NotBlank
        private String userId;
    }

    @Getter
    @NoArgsConstructor
    public static class ChoiceStoryRequest {
        @Schema(description = "사용자 ID", examples = "ABABABAB", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        private String userId;
        @Schema(description = "선택지 ID", examples = "ABABABAB", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        private String choiceId;
    }

    @Getter
    @NoArgsConstructor
    public static class EndStoryRequest {
        @Schema(description = "사용자 ID", examples = "ABABABAB", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        private String userId;
    }
}
