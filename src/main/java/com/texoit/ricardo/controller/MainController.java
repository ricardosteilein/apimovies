package com.texoit.ricardo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.ricardo.dto.ProducerMinMaxPrizesDTO;
import com.texoit.ricardo.service.ProducerService;



@RestController
@RequestMapping("producer")
public class MainController {
	
	Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ProducerService producerService;
	
	@GetMapping("awards-interval")
	public ResponseEntity<ProducerMinMaxPrizesDTO> getMaxAndMinPrizes() {
		
		// Método para listar maiores e menores prazos
		ProducerMinMaxPrizesDTO dto = producerService.getMaxAndMinPrizes();
		
		HttpStatus status = HttpStatus.OK;
		// retorna o conteúdo e status 200
		if ( dto.getMax().isEmpty() && dto.getMin().isEmpty() ) {
			// Caso não tenha valores retorna o status http 204 - sem conteúdo
			status = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<ProducerMinMaxPrizesDTO>(dto, status);
	}

}
