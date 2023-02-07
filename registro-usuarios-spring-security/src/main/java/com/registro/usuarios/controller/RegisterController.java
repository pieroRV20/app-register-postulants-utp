package com.registro.usuarios.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.registro.usuarios.model.Degree;
import com.registro.usuarios.model.Postulant;
import com.registro.usuarios.model.Register;
import com.registro.usuarios.model.Status;
import com.registro.usuarios.service.IDegreeService;
import com.registro.usuarios.service.IRegisterService;
import com.registro.usuarios.service.IStatusService;

@Controller
public class RegisterController {

	//Dependencias
	@Autowired
	private IRegisterService registerService;

	@Autowired
	private IDegreeService degreeService;
	
	@Autowired
	private IStatusService statusService;

	@RequestMapping(value = "/list-register")
	public String listarRegisters(Model model) {
		model.addAttribute("titulo","Registrar Postulante");
		model.addAttribute("registers", registerService.findAll());
		return "list-register";
	}
	
	@RequestMapping(value = "/postulant-register")
	public String create(Map<String, Object> model) {
		Postulant postulant = new Postulant();
		List<Degree> degrees = degreeService.findAll();

		model.put("postulant", postulant);
		model.put("degrees", degrees);

		return "form-postulant";
	}

	@RequestMapping(value = "/postulant-register", method = RequestMethod.POST)
	public String save(@Valid Postulant postulant, BindingResult result, Model model, Principal principal,RedirectAttributes flash) {
		
		if(result.hasErrors()) {
			List<Degree> degrees = degreeService.findAll();

			model.addAttribute("postulant", postulant);
			model.addAttribute("degrees", degrees);
			return "form-postulant";
		}
		registerService.saveIntern(postulant, principal.getName());

		return "redirect:/list-register";
	}
	
	
	@RequestMapping(value="/delete/{id}")
	public String delete(@PathVariable(value="id") Long id,Map<String,Object> model,Principal principal,RedirectAttributes flash) {
		
		Register register = registerService.findOne(id);
		
		if(register.getEvaluator() == null) {
			flash.addFlashAttribute("info","Ustes no es evaluador de este registro");
			return "redirect:/list-register";
		}
		
		if (register.getEvaluator().getCode()!=null && id>0) {
			if(register.getEvaluator().getCode().equals(principal.getName())) {
				registerService.delete(id);
				flash.addFlashAttribute("success","Registro eliminado con exito");
			}	
			return "redirect:/list-register";
		}else {
			flash.addFlashAttribute("info","Ustes no es evaluador de este registro");
			return "redirect:/list-register";
		}

	}
	
	@RequestMapping(value="/assign/{id}")
	public String assign (@PathVariable(value="id") Long id,Principal principal,Model model,RedirectAttributes flash) {
		Register register = registerService.findOne(id);
		
		if(register.getEvaluator()==null) {
				registerService.assignRegister(principal.getName(),register);
		}
		
		
		flash.addFlashAttribute("info","Este registro ya tiene evaluador o ya lo tienes asignado");
		return "redirect:/list-register";
	}
	
	@RequestMapping(value="/evaluation/{id}")
	public String evaluate (@PathVariable(value="id") Long id,Principal principal,Model model,RedirectAttributes flash) {
		Register register = registerService.findOne(id);
		
		if(register.getEvaluator() == null) {
			flash.addFlashAttribute("info","Ustes no es evaluador de este registro");
			return "redirect:/list-register";
		}
		
		if (register.getEvaluator().getCode()!=null) {
			if(register.getEvaluator().getCode().equals(principal.getName())) {
				model.addAttribute("register",register);
				model.addAttribute("origin",register.getOrigin());
				model.addAttribute("statuses",statusService.findAll());
				return "form-eval";
			}			
		}else {
			flash.addFlashAttribute("info","Ustes no es evaluador de este registro");
			return "redirect:/list-register";
		}

		return "redirect:/list-register";
	}
	
	@RequestMapping(value = "/register-evaluate/{idStatus}/{idRegister}")
	public String saveEvaluation(@PathVariable(value="idRegister") Long idReg,@PathVariable(value="idStatus") Integer idSta, Model model, Principal principal,RedirectAttributes flash) {

		Status status = statusService.findById(idSta);
		Register register = registerService.findOne(idReg);
		register.setStatus(status);
		registerService.save(register);
		return "redirect:/list-register";
	}
	
	
}
