package crew.milo.user;

import crew.milo.common.BaseTimeEntity;
import crew.milo.common.util.UuidUtils;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuid;

    @Column(name = "is_active")
    private Boolean isActive = true;

    public User(final UUID uuid) {
        this.uuid = uuid;
    }

    public static User create() {
        return new User(UuidUtils.randomUuidV7());
    }
}
