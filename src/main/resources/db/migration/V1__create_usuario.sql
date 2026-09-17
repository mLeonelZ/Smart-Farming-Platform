CREATE TABLE usuario (
                         id_usuario BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(150) NOT NULL,
                         email VARCHAR(150) NOT NULL UNIQUE,
                         senha_hash VARCHAR(255) NOT NULL,
                         perfil VARCHAR(50) NOT NULL
);