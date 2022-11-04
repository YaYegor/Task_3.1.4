INSERT INTO roles(name) VALUES ('ROLE_USER'),
                               ('ROLE_ADMIN') ON CONFLICT DO NOTHING;

INSERT INTO users(email, surname, password, name) VALUES ('user@mail.ru', 'userov', '$2a$12$7pIopZ3eKtdMaicIbedBwOmagM4/XmElKhwvaj6uIEDtWeq6tWTRi', 'user'),
                                                       ('admin@mail.ru', 'adminov', '$2a$12$QLMRL99R4vJDDttsSGFRR.0e60HUllQrCfltfUrfbQy2J4hX2MRqW', 'admin') ON CONFLICT DO NOTHING;

INSERT INTO users_roles VALUES (1, 1),
                               (2, 1),
                               (2, 2) ON CONFLICT DO NOTHING;