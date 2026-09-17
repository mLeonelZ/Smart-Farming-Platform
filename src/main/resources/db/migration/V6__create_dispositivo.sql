CREATE TABLE dispositivo (
                             id_dispositivo BIGSERIAL PRIMARY KEY,
                             codigo_identificacao VARCHAR(100) NOT NULL UNIQUE,
                             tipo_dispositivo VARCHAR(50) NOT NULL,
                             data_instalacao DATE,
                             status VARCHAR(50) NOT NULL,
                             id_talhao BIGINT NOT NULL,

                             CONSTRAINT fk_dispositivo_talhao
                                 FOREIGN KEY (id_talhao)
                                     REFERENCES talhao (id_talhao)
);