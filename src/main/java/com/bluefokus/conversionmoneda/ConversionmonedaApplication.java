package com.bluefokus.conversionmoneda;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class ConversionmonedaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConversionmonedaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initDatabase(ConnectionFactory cf) {
		return (args) ->
				Flux.from(cf.create())
						.flatMap(c ->
								Flux.from(c.createBatch()
												.add("""
              						CREATE TABLE moneda (id_moneda INT AUTO_INCREMENT PRIMARY KEY,
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
														      
														      CREATE TABLE conversion (
														          id_conversion INT AUTO_INCREMENT PRIMARY KEY,
														          monto_origen DECIMAL(18, 2),
														          monto_convertido DECIMAL(18, 2),
														          id_tipo_cambio INT REFERENCES tipo_cambio(id_tipo_cambio)
														      );
														      INSERT INTO moneda (codigo, nombre, simbolo) VALUES ('PEN', 'Sol peruano', 'S/.');
														      INSERT INTO moneda (codigo, nombre, simbolo) VALUES ('USD', 'Dólar estadounidense', '$');
														      INSERT INTO moneda (codigo, nombre, simbolo) VALUES ('EUR', 'Euro', '€');
														      
														      
														      INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (1, 2, 0.287, '2024-02-26');
														      INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (1, 3, 0.244, '2024-02-26');
														      INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (2, 1, 3.485, '2024-02-26');
														      INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (2, 3, 0.851, '2024-02-26');
														      INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (3, 1, 4.098, '2024-02-26');
														      INSERT INTO tipo_cambio (id_moneda_origen, id_moneda_destino, valor, fecha) VALUES (3, 2, 1.175, '2024-02-26');
														      
														""")
												.execute())
										.doFinally((st) -> c.close())
						)
						.log()
						.blockLast();
	}

}
