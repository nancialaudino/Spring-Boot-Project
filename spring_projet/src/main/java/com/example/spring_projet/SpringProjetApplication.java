package com.example.spring_projet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProjetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjetApplication.class, args);
	}

}




/*
| Método | URL                                                                      | Observações                     |
| ------ | ------------------------------------------------------------------------ | ------------------------------- |
| GET    | [http://localhost:8080/clients](http://localhost:8080/clients)           | Lista todos os clientes         |
| GET    | [http://localhost:8080/clients/{id}](http://localhost:8080/clients/{id}) | Mostra detalhes de um cliente   |
| POST   | [http://localhost:8080/clients](http://localhost:8080/clients)           | Adiciona cliente (JSON no body) |
| PUT    | [http://localhost:8080/clients](http://localhost:8080/clients)           | Atualiza cliente (JSON no body) |
| DELETE | [http://localhost:8080/clients/{id}](http://localhost:8080/clients/{id}) | Remove cliente                  |

 */
