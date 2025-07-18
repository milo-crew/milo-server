package crew.milo.theme;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public List<ThemeResponse.ThemeInfoResponse> getThemes() {
        return themeRepository.findAllActiveThemes()
                .stream()
                .map(theme -> ThemeResponse.ThemeInfoResponse.from(theme, 10))
                .toList();
    }
}
