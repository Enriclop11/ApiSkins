package com.enriclop.apiskins;

import com.enriclop.apiskins.modelo.Skin;
import com.enriclop.apiskins.reporistorio.ISkinRepository;
import com.enriclop.apiskins.servicio.SkinService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiSkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSkinsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(SkinService skinService) {
		return args -> {
			InsertarSkins(skinService);
		};
	}

	public void InsertarSkins(SkinService skinService) {
		File file = new File("skins.json");

		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Skin[] skins = objectMapper.readValue(file, Skin[].class);

			System.out.println(Arrays.toString(skins));

			skinService.saveSkins(Arrays.asList(skins));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
