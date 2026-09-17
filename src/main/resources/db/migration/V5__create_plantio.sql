CREATE TABLE plantio (
                         id_plantio BIGSERIAL PRIMARY KEY,
                         id_talhao BIGINT NOT NULL,
                         id_cultura BIGINT NOT NULL,
                         data_plantio DATE NOT NULL,
                         data_colheita_prevista DATE,
                         status VARCHAR(50) NOT NULL,

                         CONSTRAINT fk_plantio_talhao
                             FOREIGN KEY (id_talhao)
                                 REFERENCES talhao (id_talhao),

                         CONSTRAINT fk_plantio_cultura
                             FOREIGN KEY (id_cultura)
                                 REFERENCES cultura (id_cultura)
);