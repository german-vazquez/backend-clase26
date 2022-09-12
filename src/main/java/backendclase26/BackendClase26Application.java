package backendclase26;

import backendclase26.bd.BD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendClase26Application {

	public static void main(String[] args) {
		BD.crearTablas();
		SpringApplication.run(BackendClase26Application.class, args);
	}

}
