CREATE TABLE regra_alerta (
                              id_regra BIGSERIAL PRIMARY KEY,
                              tipo_evento VARCHAR(100) NOT NULL,
                              condicao_limite DOUBLE PRECISION NOT NULL,
                              descricao VARCHAR(255)
);