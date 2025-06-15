package crew.milo.theme;

import crew.milo.common.BaseTimeEntity;
import crew.milo.common.util.UuidUtils;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "themes")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Theme extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theme_id")
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuid;

    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @Column(nullable = true, length = 255)
    private String description;

    @Column(name = "is_active")
    private Boolean isActive = true;

    private Theme(String name, String description) {
        this.uuid = UuidUtils.randomUuidV7();
        this.name = name;
        this.description = description;
    }

    public static Theme create(String name, String description) {
        return new Theme(name, description);
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void activate() {
        this.isActive = true;
    }

    public boolean isActive() {
        return Boolean.TRUE.equals(isActive);
    }
} 