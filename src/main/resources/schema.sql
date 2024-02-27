CREATE TABLE moneda (
    id_moneda INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(10),
    nombre VARCHAR(20),
    simbolo VARCHAR(5)
);

CREATE TABLE tipo_cambio (
    id_tipo_cambio INT AUTO_INCREMENT PRIMARY KEY,
    id_moneda_origen INT REFERENCES moneda(id_moneda),
    id_moneda_destino INT REFERENCES moneda(id_moneda),
    valor DECIMAL(18, 6),
    fecha DATE
);

CREATE TABLE monto_conversion (
    id_conversion INT AUTO_INCREMENT PRIMARY KEY,
    monto_origen DECIMAL(18, 2),
    monto_convertido DECIMAL(18, 2),
    id_tipo_cambio INT REFERENCES tipo_cambio(id_tipo_cambio)
);
