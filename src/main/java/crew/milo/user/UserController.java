package crew.milo.user;

import crew.milo.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.UUID;

@Tag(name = "20001. 사용자", description = "사용자 API")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = Objects.requireNonNull(userService);
    }

    @Operation(summary = "사용자 조회", description = "사용자 정보를 조회합니다.")
    @GetMapping("/v1/users/{uuid}")
    public ResponseEntity<ApiResponse<UserResponse.UserInfoResponse>> getUser(
            @PathVariable @Parameter(description = "사용자 UUID", example = "018f4a5e-7c8d-7a1b-8c9d-0e1f2a3b4c60") UUID uuid
    ) {
        final UserResponse.UserInfoResponse userInfo = userService.getUser(uuid);
        return ResponseEntity.ok(ApiResponse.success(userInfo));
    }

    @Operation(summary = "사용자 생성", description = "스토리를 선택한 사용자를 생성합니다.")
    @PostMapping("/v1/users")
    public ResponseEntity<ApiResponse<UserResponse.CreateUserResponse>> createUser() {
        final UserResponse.UserInfoResponse userInfo = userService.createUser();
        return ResponseEntity
                .created(URI.create("/v1/users/" + userInfo.getUserUuid()))
                .body(ApiResponse.success(UserResponse.CreateUserResponse.from(userInfo)));
    }
}
