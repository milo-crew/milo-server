package crew.milo.story;

import crew.milo.common.BaseTimeEntity;
import crew.milo.theme.Theme;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Entity
@Table(name = "stories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Story extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "story_id")
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuid;

    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @Column(nullable = true, length = 255)
    private String description;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

} 