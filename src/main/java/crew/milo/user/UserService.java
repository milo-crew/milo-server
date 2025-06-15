package crew.milo.user;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = Objects.requireNonNull(userRepository);
    }

    @Transactional
    public UserResponse.UserInfoResponse createUser() {
        final User user = userRepository.save(User.create());
        return UserResponse.UserInfoResponse.from(user);
    }

    public UserResponse.UserInfoResponse getUser(final UUID uuid) {
        final User user = userRepository.findByUuid(uuid)
                .orElseThrow(() -> new UserException.UserNotFoundException(UserErrorCode.USER_NOT_FOUND, "존재하지 않는 사용자입니다. uuid = " + uuid));
        return UserResponse.UserInfoResponse.from(user);
    }
}
