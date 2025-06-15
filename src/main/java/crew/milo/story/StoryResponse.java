package crew.milo.story;

import crew.milo.theme.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public class StoryResponse {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class StoryInfoResponse {
        @Schema(description = "스토리 UUID", examples = "018f4a5e-7c8a-7a1b-8c9d-0e1f2a3b4c5d")
        private UUID uuid;
        @Schema(description = "유형 종류")
        private Category category;
        @Schema(description = "사용자 수", examples = "5")
        private int userCount;
        @Schema(description = "스토리 생성 시간", examples = "2025-03-12T10:15:30Z")
        private OffsetDateTime createdAt;

        public static StoryInfoResponse from(final Story story, final int userCount) {
            return new StoryInfoResponse(
                    story.getUuid(),
                    Category.STORY,
                    userCount,
                    story.getCreatedAt()
            );
        }
    }

    @Getter
    @NoArgsConstructor
    public static class StartStoryResponse {
        @Schema(description = "스토리 내용", examples = "음산한 새벽, 그늘진 골목에서 쓰러진 피해자와 그 주변에 흩어진 증거들이 조사관의 시선을 사로잡았다. (스토리 내용)")
        private String content;
        @Schema(description = "선택지 목록")
        private List<ChoiceResponse> choices;
    }

    @Getter
    @NoArgsConstructor
    public static class ChoiceStoryResponse {
        @Schema(description = "스토리 내용", examples = "음산한 새벽, 그늘진 골목에서 쓰러진 피해자와 그 주변에 흩어진 증거들이 조사관의 시선을 사로잡았다. (스토리 내용)")
        private String story;
        @Schema(description = "선택지 목록")
        private List<ChoiceResponse> choices;
    }

    @Getter
    @NoArgsConstructor
    public static class EndStoryResponse {
        @Schema(description = "스토리 요약", examples = "도시의 으슥한 골목에서 발견된, 손에 이상한 실타래가 감긴 피해자의 사건은 결국 조사관의 어린 시절 친구였던 유명 인형극 예술가의 범행으로 밝혀졌다. (스토리 요약)")
        private String story;
    }

    @Getter
    @NoArgsConstructor
    public static class ChoiceResponse {
        @Schema(description = "선택지 ID", examples = "ABABABAB")
        private String choiceId;
        @Schema(description = "선택지 내용", examples = "피해자의 손에 감긴 특이한 실타래가 조사관의 관심을 끌었다. (선택지 내용)")
        private String content;
    }
}
