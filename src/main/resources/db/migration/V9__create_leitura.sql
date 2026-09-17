CREATE TABLE leitura (
                         id_leitura BIGSERIAL PRIMARY KEY,
                         id_dispositivo BIGINT NOT NULL,
                         valor DOUBLE PRECISION NOT NULL,
                         data_hora TIMESTAMP NOT NULL,
                         origem_simulada BOOLEAN NOT NULL DEFAULT FALSE,

                         CONSTRAINT fk_leitura_dispositivo
                             FOREIGN KEY (id_dispositivo)
                                 REFERENCES dispositivo (id_dispositivo)
);

CREATE INDEX idx_leitura_dispositivo_data
    ON leitura (id_dispositivo, data_hora);