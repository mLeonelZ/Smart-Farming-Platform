CREATE TABLE fazenda (
                         id_fazenda BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(150) NOT NULL,
                         localizacao VARCHAR(255),
                         area_total DOUBLE PRECISION NOT NULL,
                         id_usuario BIGINT NOT NULL,

                         CONSTRAINT fk_fazenda_usuario
                             FOREIGN KEY (id_usuario)
                                 REFERENCES usuario (id_usuario)
);