package crew.milo.theme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    
    @Query("SELECT t FROM Theme t WHERE t.isActive = true ORDER BY t.createdAt DESC")
    List<Theme> findAllActiveThemes();
} 