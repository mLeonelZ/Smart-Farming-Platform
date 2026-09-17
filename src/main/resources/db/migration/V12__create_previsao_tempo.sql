CREATE TABLE previsao_tempo (
                                id_previsao BIGSERIAL PRIMARY KEY,
                                id_fazenda BIGINT NOT NULL,
                                data_previsao DATE NOT NULL,
                                temperatura_prevista DOUBLE PRECISION,
                                precipitacao_prevista DOUBLE PRECISION,
                                fonte_api VARCHAR(100),

                                CONSTRAINT fk_previsao_fazenda
                                    FOREIGN KEY (id_fazenda)
                                        REFERENCES fazenda (id_fazenda)
);

CREATE INDEX idx_previsao_fazenda_data
    ON previsao_tempo (id_fazenda, data_previsao);