package com.registro.usuarios.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.model.Evaluator;
import com.registro.usuarios.service.IEvaluatorService;
import com.registro.usuarios.service.IRegisterService;

@Controller
public class HomeController {
	
	@Autowired
	private IRegisterService registerService;
	
	@Autowired
	private IEvaluatorService evaluatorService;

	@RequestMapping(value = { "/home", "/" })
	public String listarRegisters(Model model,Principal principal) {
		Evaluator evaluator = evaluatorService.findByCode(principal.getName());
		model.addAttribute("titulo","Registrar Postulante");
		model.addAttribute("registers", registerService.findMyRegisters(evaluator));
		return "home";
	}
}
