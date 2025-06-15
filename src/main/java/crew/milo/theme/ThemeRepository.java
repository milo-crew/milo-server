package crew.milo.theme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    
    @Query("SELECT t FROM Theme t WHERE t.isActive = true ORDER BY t.id")
    List<Theme> findAllActiveThemes();

    Optional<Theme> findByUuid(UUID uuid);
}