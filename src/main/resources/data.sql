INSERT INTO themes (uuid, name, description, is_active) VALUES
(UUID_TO_BIN('018f4a5e-7c8a-7a1b-8c9d-0e1f2a3b4c5d'), 'Fantasy Adventure', 'A magical journey through enchanted lands.', TRUE),
(UUID_TO_BIN('018f4a5e-7c8b-7a1b-8c9d-0e1f2a3b4c5e'), 'Space Odyssey', 'An epic quest across the galaxies.', TRUE),
(UUID_TO_BIN('018f4a5e-7c8c-7a1b-8c9d-0e1f2a3b4c5f'), 'Mystery Mansion', 'Unravel the secrets of a haunted mansion.', TRUE);

INSERT INTO users (uuid, is_active) VALUES
(UUID_TO_BIN('018f4a5e-7c8d-7a1b-8c9d-0e1f2a3b4c60'), TRUE);