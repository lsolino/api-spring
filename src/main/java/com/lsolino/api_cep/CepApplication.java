package com.lsolino.api_cep;

import com.lsolino.api_cep.model.Cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootApplication
public class CepApplication {

	public static void main(String[] args) {
		SpringApplication.run(CepApplication.class, args);

		//viacep.com.br/ws/28051180/json/
		//viacep.com.br/ws/28030335/json/

		UriComponents uri_cep_iff = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("viacep.com.br")
				.path("ws/28030130/json/")
				.build();	
		
		UriComponents uri_cep_candido = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("viacep.com.br")
				.path("ws/28030335/json/")
				.build();	

		RestTemplate template = new RestTemplate();
		ResponseEntity<Cep> entity_cep_iff = template.getForEntity(uri_cep_iff.toUriString(), Cep.class);
		ResponseEntity<Cep> entity_cep_candido = template.getForEntity(uri_cep_candido.toUriString(), Cep.class);

		System.out.println("---------------------------------------------------------------- ");
		System.out.println("IFF: ");
		System.out.println("Cep: " + entity_cep_iff.getBody().getCep() + "\n" +
											 "Rua: " + entity_cep_iff.getBody().getLogradouro() + "\n" +
											 "Bairro: " + entity_cep_iff.getBody().getBairro() + "\n" +
											 "Cidade: " + entity_cep_iff.getBody().getLocalidade() + "/" + 
											 entity_cep_iff.getBody().getUf());

		
    System.out.println("---------------------------------------------------------------- ");
		System.out.println("CÂNDIDO: ");
		System.out.println("Cep: " + entity_cep_candido.getBody().getCep() + "\n" +
											 "Rua: " + entity_cep_candido.getBody().getLogradouro() + "\n" +
											 "Bairro: " + entity_cep_candido.getBody().getBairro() + "\n" +
											 "Cidade: " + entity_cep_candido.getBody().getLocalidade() + "/" + 
											 entity_cep_candido.getBody().getUf());
	}

}
