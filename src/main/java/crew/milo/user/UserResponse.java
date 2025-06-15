package crew.milo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.UUID;

public class UserResponse {
    @AllArgsConstructor
    @Getter
    public static class UserInfoResponse {
        private final Long userId;
        private final UUID userUuid;
        private final boolean isActive;
        private final OffsetDateTime createdAt;

        public static UserInfoResponse from(final User user) {
            return new UserInfoResponse(
                user.getId(),
                user.getUuid(),
                user.getIsActive(),
                user.getCreatedAt()
            );
        }
    }

    @AllArgsConstructor
    @Getter
    public static class CreateUserResponse {
        @Schema(name = "사용자 UUID", example = "018f4a5e-7c8d-7a1b-8c9d-0e1f2a3b4c60")
        private final String uuid;
        private final OffsetDateTime createdAt;

        public static CreateUserResponse from(final UserInfoResponse userInfo) {
            return new CreateUserResponse(
                userInfo.getUserUuid().toString(),
                userInfo.getCreatedAt()
            );
        }
    }
}
