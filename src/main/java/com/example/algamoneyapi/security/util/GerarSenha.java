package com.example.algamoneyapi.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GerarSenha {
	
	public static void main(String[] args) {
		String encoded = new BCryptPasswordEncoder().encode("maria");
		System.out.println(encoded);
	}

}
