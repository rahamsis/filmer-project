package com.filmer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.filmer.entities.Actor;
import com.filmer.entities.Pelicula;
import com.filmer.service.IActorService;

@Controller
@RequestMapping("/actors")
@SessionAttributes("PeliParaActor")
public class ActorController {
	
	@Autowired
	private IActorService actorService;

	@GetMapping("/actors-form")
	public String actorsForm (Actor actor, Model model, @ModelAttribute("PeliParaActor")Pelicula pelicula)  {
		model.addAttribute("actor", new Actor());
		model.addAttribute("film", pelicula);
		return "admin/actorsForm";
	}
	
	@PostMapping("/save-Actor")
	public String saveActor(Actor actor, RedirectAttributes redirect, Model model, @ModelAttribute("PeliParaActor")Pelicula pelicula) {
		
		actorService.saveActor(actor);
		redirect.addFlashAttribute("actorGuardado", "Actor guardado con éxito");
		return "redirect:/actors/actors-form";
	}
	
}
