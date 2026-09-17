CREATE TABLE talhao (
                        id_talhao BIGSERIAL PRIMARY KEY,
                        identificacao VARCHAR(100) NOT NULL,
                        area_hectares DOUBLE PRECISION NOT NULL,
                        geometria VARCHAR(255),
                        id_fazenda BIGINT NOT NULL,

                        CONSTRAINT fk_talhao_fazenda
                            FOREIGN KEY (id_fazenda)
                                REFERENCES fazenda (id_fazenda)
);