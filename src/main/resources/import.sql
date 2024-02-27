-- Inserts para la tabla 'moneda'
INSERT INTO moneda (codigo, nombre, simbolo) VALUES ('PEN', 'Sol peruano', 'S/.');
INSERT INTO moneda (codigo, nombre, simbolo) VALUES ('USD', 'Dólar estadounidense', '$');
INSERT INTO moneda (codigo, nombre, simbolo) VALUES ('EUR', 'Euro', '€');


-- Inserts para la tabla 'tipo_cambio'
INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (1, 2, 0.287, '2024-02-26');
INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (1, 3, 0.244, '2024-02-26');
INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (2, 1, 3.485, '2024-02-26');
INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (2, 3, 0.851, '2024-02-26');
INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (3, 1, 4.098, '2024-02-26');
INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (3, 2, 1.175, '2024-02-26');
