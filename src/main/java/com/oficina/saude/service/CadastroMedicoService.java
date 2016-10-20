package com.oficina.saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.Medico;
import com.oficina.saude.repository.Medicos;

@Service
public class CadastroMedicoService {
	
	@Autowired
	Medicos medicos;
	
	public void salvar(Medico medico){
		this.medicos.save(medico);
	}

}
