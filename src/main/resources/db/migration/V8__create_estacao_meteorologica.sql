CREATE TABLE estacao_meteorologica (
                                       id_dispositivo BIGINT PRIMARY KEY,
                                       modelo VARCHAR(100),
                                       frequencia_coleta INTEGER,

                                       CONSTRAINT fk_estacao_dispositivo
                                           FOREIGN KEY (id_dispositivo)
                                               REFERENCES dispositivo (id_dispositivo)
                                               ON DELETE CASCADE
);