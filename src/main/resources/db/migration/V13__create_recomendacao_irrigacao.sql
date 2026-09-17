CREATE TABLE recomendacao_irrigacao (
                                        id_recomendacao BIGSERIAL PRIMARY KEY,
                                        id_talhao BIGINT NOT NULL,
                                        id_previsao BIGINT,
                                        data_hora TIMESTAMP NOT NULL,
                                        volume_recomendado_mm DOUBLE PRECISION NOT NULL,
                                        justificativa VARCHAR(500),

                                        CONSTRAINT fk_recomendacao_talhao
                                            FOREIGN KEY (id_talhao)
                                                REFERENCES talhao (id_talhao),

                                        CONSTRAINT fk_recomendacao_previsao
                                            FOREIGN KEY (id_previsao)
                                                REFERENCES previsao_tempo (id_previsao)
);