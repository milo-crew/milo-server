package crew.milo.common.response;

import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class ErrorResponse {
    private final int code;
    private final String reason;
    private final OffsetDateTime timestamp;

    public ErrorResponse(int code, String reason, OffsetDateTime timestamp) {
        this.code = code;
        this.reason = reason;
        this.timestamp = timestamp;
    }
} 