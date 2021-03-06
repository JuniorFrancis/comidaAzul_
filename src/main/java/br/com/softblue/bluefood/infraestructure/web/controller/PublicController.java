package br.com.softblue.bluefood.infraestructure.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.softblue.bluefood.application.ClienteService;
import br.com.softblue.bluefood.application.ValidationException;
import br.com.softblue.bluefood.domain.cliente.Cliente;


import org.springframework.ui.Model;
import org.springframework.validation.Errors;

@Controller
@RequestMapping(path = "/public")
public class PublicController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(path= "/cliente/new")
	public String CadastroCliente(Model model)
	{
		model.addAttribute("cliente", new Cliente());
		ControllerHelper.setEditMode(model, false);
		
		
		return "cliente-cadastro";
	}
	
	
	@PostMapping(path = "/cliente/save")
	public String saveCliente(
			@ModelAttribute("cliente") @Valid Cliente cliente,
			Errors errors,
			Model model)
	{
		if(!errors.hasErrors())
		{
			try{
				clienteService.saveCliente(cliente);
				model.addAttribute("msg", "Cliente cadastrado com sucesso!");
			}catch (ValidationException e)
			{
				errors.rejectValue("email", null, e.getMessage());
			}
		}
		ControllerHelper.setEditMode(model, true);
		return "cliente-cadastro";
		
	}
	
}
