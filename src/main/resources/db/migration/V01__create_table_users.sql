CREATE TABLE User(
 id              BIGINT(50) PRIMARY KEY AUTO_INCREMENT,
 email                VARCHAR(130) NOT NULL UNIQUE,
 password             VARCHAR(280),
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (email,password) VALUES ('admin@admin.com','$2a$10$Y/hdSxxan79Rws1VqyHWk.L5zpC4lnGkYv0DEoFv/KNVgBVEmJsea');