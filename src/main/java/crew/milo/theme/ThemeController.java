package crew.milo.theme;

import crew.milo.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Tag(name = "10001. 테마", description = "테마 API")
@RestController
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(final ThemeService themeService) {
        this.themeService = Objects.requireNonNull(themeService);
    }

    // @ParameterObject @Parameter(description = "페이지 정보")
    @Operation(
            summary = "테마 조회",
            description = "사용 가능한 테마 목록을 조회합니다."
    )
    @GetMapping("/v1/themes")
    public ResponseEntity<ApiResponse<List<ThemeResponse.ThemeInfoResponse>>> getThemes() {
        return ResponseEntity.ok().body(ApiResponse.success(themeService.getThemes()));
    }
}
