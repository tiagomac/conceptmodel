package com.tiagomac.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiagomac.dto.CredenciaisDTO;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	private JWTUtil jwtUtil;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			// vai tentar pegar os dados que vieram na requisição e converter para CredenciaisDTO.class
			CredenciaisDTO creds = new ObjectMapper().readValue(req.getInputStream(), CredenciaisDTO.class);
			// pegando os dados vai instanciar o authToken
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getSenha(), new ArrayList<>());
			Authentication auth = authenticationManager.authenticate(authToken);
			return auth;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// aqui geramos um token e acrescentamos na resposta da requisição.
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
			HttpServletResponse res,
			FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		res.addHeader("Authorization",  "Bearer " + token);

	}

}
