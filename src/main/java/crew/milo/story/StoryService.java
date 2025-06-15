package crew.milo.story;

import crew.milo.theme.Theme;
import crew.milo.theme.ThemeErrorCode;
import crew.milo.theme.ThemeException;
import crew.milo.theme.ThemeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class StoryService {
    
    private final ThemeRepository themeRepository;
    private final StoryRepository storyRepository;

    public StoryService(final ThemeRepository themeRepository, StoryRepository storyRepository) {
        this.themeRepository = themeRepository;
        this.storyRepository = storyRepository;
    }

    public List<StoryResponse.StoryInfoResponse> getStories(final UUID uuid) {
        final Theme theme = themeRepository.findByUuid(uuid)
                .orElseThrow(() -> new ThemeException.ThemeNotFoundException(ThemeErrorCode.THEME_NOT_FOUND, "테마를 찾을 수 없습니다." + uuid));

        return storyRepository.findAllActiveByTheme(theme.getId())
                .stream()
                .map(story -> StoryResponse.StoryInfoResponse.from(story, 0))
                .toList();
    }
}