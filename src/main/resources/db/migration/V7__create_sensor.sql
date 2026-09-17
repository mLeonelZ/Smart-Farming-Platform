CREATE TABLE sensor (
                        id_dispositivo BIGINT PRIMARY KEY,
                        tipo_sensor VARCHAR(100) NOT NULL,
                        unidade_medida VARCHAR(50) NOT NULL,

                        CONSTRAINT fk_sensor_dispositivo
                            FOREIGN KEY (id_dispositivo)
                                REFERENCES dispositivo (id_dispositivo)
                                ON DELETE CASCADE
);