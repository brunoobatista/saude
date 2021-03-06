package com.oficina.saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oficina.saude.model.Consulta;
import com.oficina.saude.model.PedidoMedicamento;
import com.oficina.saude.repository.Consultas;
import com.oficina.saude.repository.Receitas;
import com.oficina.saude.service.CadastroPedidosMedicamentosService;
import com.oficina.saude.service.CadastroReceitaService;

@Controller
public class PedidoMedicamentoController {

	@Autowired
	private CadastroPedidosMedicamentosService pedidosMedicamentosService;
	
	@Autowired
	private Receitas receitas;
	
	@Autowired
	private CadastroReceitaService receitaService;
	
	@Autowired
	private Consultas consultas;
	
	@RequestMapping(value="produtos/novoPedido", method=RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> novoPedido(@RequestBody PedidoMedicamento pedidoMedicamento){
		if(!receitas.exists(pedidoMedicamento.getReceita().getCodigo())){
			Consulta cons1 = consultas.findOne(new Long(1));
			Consulta cons = new Consulta();
			cons.setProntuario(cons1.getProntuario());
			cons.setMedico(cons1.getMedico());
			cons.setId(pedidoMedicamento.getReceita().getConsulta().getId());
			consultas.save(cons);
			receitaService.salvar(pedidoMedicamento.getReceita());
		}
		PedidoMedicamento ret = pedidosMedicamentosService.salvar(pedidoMedicamento);
		return ResponseEntity.ok(ret);
		}
	
}
