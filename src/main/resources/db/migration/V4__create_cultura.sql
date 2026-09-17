CREATE TABLE cultura (
                         id_cultura BIGSERIAL PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         tipo_plantio VARCHAR(100),
                         ciclo_dias INTEGER
);