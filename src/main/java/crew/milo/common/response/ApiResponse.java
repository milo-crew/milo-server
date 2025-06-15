package crew.milo.common.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final ResultType resultType;
    private final ErrorResponse error;
    private final T success;

    private ApiResponse(ResultType resultType, ErrorResponse error, T success) {
        this.resultType = resultType;
        this.error = error;
        this.success = success;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResultType.SUCCESS, null, data);
    }

    public static <T> ApiResponse<T> fail(ErrorResponse error) {
        return new ApiResponse<>(ResultType.FAIL, error, null);
    }

    public enum ResultType {
        SUCCESS, FAIL
    }
} 