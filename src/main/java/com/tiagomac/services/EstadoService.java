package com.tiagomac.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagomac.domain.Estado;
import com.tiagomac.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	public List<Estado> findAll(){
		return repo.findAllByOrderByNome();
	}

}
