DROP TABLE IF EXISTS api_usage_stats;
DROP TABLE IF EXISTS endings;
DROP TABLE IF EXISTS choices;
DROP TABLE IF EXISTS game_sessions;
DROP TABLE IF EXISTS stories;
DROP TABLE IF EXISTS themes;
DROP TABLE IF EXISTS users;

-- 사용자 테이블
CREATE TABLE IF NOT EXISTS users (
    user_id    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '사용자 ID',
    uuid       BINARY(16) NOT NULL UNIQUE COMMENT '사용자 UUID',
    is_active  BOOLEAN  DEFAULT TRUE COMMENT '활성화 여부',
    created_at DATETIME DEFAULT NOW() COMMENT '생성 일시',
    updated_at DATETIME DEFAULT NOW() ON UPDATE NOW() COMMENT '수정 일시'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT '사용자 테이블';

-- 테마 테이블
CREATE TABLE IF NOT EXISTS themes (
    theme_id    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '테마 ID',
    uuid        BINARY(16) NOT NULL UNIQUE COMMENT '테마 UUID',
    name        VARCHAR(100) NOT NULL UNIQUE COMMENT '테마 이름',
    description VARCHAR(255) COMMENT '테마 설명',
    is_active   BOOLEAN  DEFAULT TRUE COMMENT '활성화 여부',
    created_at  DATETIME DEFAULT NOW() COMMENT '생성 일시',
    updated_at  DATETIME DEFAULT NOW() COMMENT '수정 일시'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT '테마 정보 테이블';

-- 스토리 테이블
CREATE TABLE IF NOT EXISTS stories (
    story_id    BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '스토리 ID',
    theme_id    BIGINT       NOT NULL,
    uuid        BINARY(16)   NOT NULL UNIQUE COMMENT '스토리 UUID',
    name        VARCHAR(200) NOT NULL,
    description VARCHAR(255) COMMENT '스토리 설명',
    is_active   BOOLEAN  DEFAULT TRUE,
    created_at  DATETIME DEFAULT NOW() COMMENT '생성 일시',
    updated_at  DATETIME DEFAULT NOW() ON UPDATE NOW() COMMENT '수정 일시'
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT '스토리 정보 테이블';

-- 게임 세션 테이블
CREATE TABLE IF NOT EXISTS game_sessions
(
    id                   BIGINT AUTO_INCREMENT PRIMARY KEY,
    session_uuid         VARCHAR(36) NOT NULL UNIQUE,
    story_id             BIGINT      NOT NULL,
    nickname             VARCHAR(50) NOT NULL,
    status               ENUM ('IN_PROGRESS', 'COMPLETED', 'ABANDONED') DEFAULT 'IN_PROGRESS',
    current_choice_count INT                                            DEFAULT 0,
    created_at           DATETIME                                      DEFAULT NOW(),
    updated_at           DATETIME                                      DEFAULT NOW() ON UPDATE NOW()
);

-- 선택 기록 테이블
CREATE TABLE IF NOT EXISTS choices
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    session_id      BIGINT NOT NULL,
    choice_order    INT    NOT NULL,
    situation_text  TEXT   NOT NULL,
    choice_options  JSON   NOT NULL,
    selected_option INT    NOT NULL,
    result_text     TEXT,
    created_at      DATETIME DEFAULT NOW()
);

-- 엔딩 테이블
CREATE TABLE IF NOT EXISTS endings
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    session_id     BIGINT NOT NULL UNIQUE,
    story_summary  TEXT   NOT NULL,
    still_cut_urls JSON   NOT NULL,
    created_at     DATETIME DEFAULT NOW()
);

-- 캐시 통계 테이블 (비용 모니터링용)
CREATE TABLE IF NOT EXISTS api_usage_stats
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    api_type    ENUM ('CHAT', 'IMAGE') NOT NULL,
    tokens_used INT,
    cost_usd    DECIMAL(10, 4),
    cache_hit   BOOLEAN   DEFAULT FALSE,
    created_at  DATETIME DEFAULT NOW()
);
