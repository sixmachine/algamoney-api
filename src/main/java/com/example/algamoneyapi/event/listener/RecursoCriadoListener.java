package com.example.algamoneyapi.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.algamoneyapi.event.RecursoCriadoEvent;

public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvent event) {

		HttpServletResponse response = event.getResponse();
		Long codigo = event.getCodigo();
		adicionarHeaderLocation(response, codigo);
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long codigo) {
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{codigo}")
				.buildAndExpand(codigo)
				.toUri();
		response.setHeader("Location", location.toASCIIString());
	}

}
