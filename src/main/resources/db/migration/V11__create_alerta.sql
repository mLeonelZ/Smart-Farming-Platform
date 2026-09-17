CREATE TABLE alerta (
                        id_alerta BIGSERIAL PRIMARY KEY,
                        id_regra BIGINT NOT NULL,
                        id_talhao BIGINT NOT NULL,
                        id_leitura BIGINT,
                        tipo VARCHAR(100) NOT NULL,
                        nivel_severidade VARCHAR(50) NOT NULL,
                        data_hora TIMESTAMP NOT NULL,
                        mensagem VARCHAR(500) NOT NULL,
                        status VARCHAR(50) NOT NULL,

                        CONSTRAINT fk_alerta_regra
                            FOREIGN KEY (id_regra)
                                REFERENCES regra_alerta (id_regra),

                        CONSTRAINT fk_alerta_talhao
                            FOREIGN KEY (id_talhao)
                                REFERENCES talhao (id_talhao),

                        CONSTRAINT fk_alerta_leitura
                            FOREIGN KEY (id_leitura)
                                REFERENCES leitura (id_leitura)
);