INSERT INTO themes (uuid, name, description, is_active) VALUES
(UUID_TO_BIN('018f4a5e-7c8a-7a1b-8c9d-0e1f2a3b4c5d'), 'Fantasy Adventure', 'A magical journey through enchanted lands.', TRUE),
(UUID_TO_BIN('018f4a5e-7c8b-7a1b-8c9d-0e1f2a3b4c5e'), 'Space Odyssey', 'An epic quest across the galaxies.', TRUE),
(UUID_TO_BIN('018f4a5e-7c8c-7a1b-8c9d-0e1f2a3b4c5f'), 'Mystery Mansion', 'Unravel the secrets of a haunted mansion.', TRUE);

INSERT INTO users (uuid, is_active) VALUES
(UUID_TO_BIN('018f4a5e-7c8d-7a1b-8c9d-0e1f2a3b4c60'), TRUE);

-- 스토리 데이터
INSERT INTO stories (theme_id, uuid, name, description, is_active)
VALUES
(1, UUID_TO_BIN('018f4a5e-7c90-7a1b-8c9d-0e1f2a3b4c70'), 'The Crystal Forest', 'Explore a mystical forest of living crystals.', TRUE),
(1, UUID_TO_BIN('018f4a5e-7c91-7a1b-8c9d-0e1f2a3b4c71'), 'Dragon’s Lair', 'Face the ancient dragon beneath the mountains.', TRUE),

(2, UUID_TO_BIN('018f4a5e-7c92-7a1b-8c9d-0e1f2a3b4c72'), 'Nebula Chase', 'A high-speed chase through a collapsing nebula.', TRUE),
(2, UUID_TO_BIN('018f4a5e-7c93-7a1b-8c9d-0e1f2a3b4c73'), 'Galactic Diplomacy', 'Negotiate peace among warring star systems.', TRUE),

(3, UUID_TO_BIN('018f4a5e-7c94-7a1b-8c9d-0e1f2a3b4c74'), 'The Locked Room', 'Solve the murder in a room sealed from inside.', TRUE),
(3, UUID_TO_BIN('018f4a5e-7c95-7a1b-8c9d-0e1f2a3b4c75'), 'Vanishing Portrait', 'Investigate a haunted painting that changes nightly.', TRUE);
