package crew.milo.story;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

    @Query("SELECT s FROM Story s WHERE s.theme.id = :themeId AND s.isActive = true ORDER BY s.id")
    List<Story> findAllActiveByTheme(Long themeId);
}