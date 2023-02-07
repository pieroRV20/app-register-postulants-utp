package com.registro.usuarios.controller;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
	@GetMapping(value="/login")
	public String login(Model model, Principal principal,RedirectAttributes flash) {
		if(principal !=null) {
			return "redirect:/";
		}
		return "login";
	}
	
	@PostMapping(value="/login")
	public String index(Model model, Principal principal,RedirectAttributes flash) {
		return "redirec:/";
	}
	
	@GetMapping("/logout")
	public String logout() {
		SecurityContextHolder.getContext().setAuthentication(null);
		return "redirect:/login";
	}
}
