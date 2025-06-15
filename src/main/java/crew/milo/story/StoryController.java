package crew.milo.story;

import crew.milo.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static crew.milo.domain.StoryRequest.StartStoryRequest;
import static crew.milo.domain.StoryRequest.ChoiceStoryRequest;
import static crew.milo.domain.StoryRequest.EndStoryRequest;
import static crew.milo.story.StoryResponse.StartStoryResponse;
import static crew.milo.story.StoryResponse.ChoiceStoryResponse;
import static crew.milo.story.StoryResponse.EndStoryResponse;

@Tag(name = "10002. 스토리", description = "스토리 API")
@RestController
public class StoryController {

    private final StoryService storyService;

    public StoryController(final StoryService storyService) {
        this.storyService = Objects.requireNonNull(storyService);
    }

    @Operation(summary = "스토리 조회", description = "테마에 속한 스토리를 조회합니다.")
    @GetMapping("/v1/themes/{uuid}/stories")
    public ResponseEntity<ApiResponse<List<StoryResponse.StoryInfoResponse>>> getStories(
            @PathVariable @Parameter(description = "테마 UUID", example = "018f4a5e-7c8d-7a1b-8c9d-0e1f2a3b4c60") UUID uuid
    ) {
        return ResponseEntity.ok(ApiResponse.success(storyService.getStories(uuid)));
    }

    @Operation(summary = "스토리 조회", description = "테마에 속한 스토리를 조회합니다.")
    @GetMapping("/v1/themes/{uuid}/stories/start")
    public ResponseEntity<StartStoryResponse> startStory(
            @PathVariable @Parameter(description = "게임 ID", example = "1001") Long gameId,
            @Valid @RequestBody StartStoryRequest request
    ) {
        return ResponseEntity.ok(new StartStoryResponse());
    }

    @Operation(summary = "스토리 선택", description = "게임 플레이중에 스토리를 선택합니다.")
    @PostMapping("/v1/games/{gameId}/stories/choices")
    public ResponseEntity<ChoiceStoryResponse> choiceStory(
            @PathVariable @Parameter(description = "게임 ID", example = "1001") Long gameId,
            @Valid @RequestBody ChoiceStoryRequest request
    ) {
        return ResponseEntity.ok(new ChoiceStoryResponse());
    }

    @Operation(summary = "스토리 종료", description = "스토리를 종료합니다.")
    @PostMapping("/v1/games/{gameId}/stories/end")
    public ResponseEntity<EndStoryResponse> endStory(
            @PathVariable @Parameter(description = "게임 ID", example = "1001") Long gameId,
            @Valid @RequestBody EndStoryRequest request
    ) {
        return ResponseEntity.ok(new EndStoryResponse());
    }
}