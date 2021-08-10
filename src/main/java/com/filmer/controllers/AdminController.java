package com.filmer.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.filmer.entities.Pelicula;
import com.filmer.service.IPeliculaService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IPeliculaService peliculasSevice;

	@GetMapping("/peli-form")
	public String peliForm(Model model) {
		model.addAttribute("pelicula", new Pelicula());
		return "admin/peliForm";
	}

	@PostMapping("/save-pelicula")
	public String savePeli(@RequestParam(name = "file", required = false) MultipartFile portada, Pelicula pelicula,
			RedirectAttributes redirect) {

		if (!portada.isEmpty()) {
			String ruta = "D:\\Rahamsis\\Programas\\Spring Boot\\Proyectos con Spring\\workspace-sts-4-4.11.0.RELEASE\\filmer\\portadas";
			String nombreUnico = UUID.randomUUID() + " " + portada.getOriginalFilename();

			try {
				byte[] bytes = portada.getBytes();
				Path rutaAbsoluta = Paths.get(ruta + "//" + nombreUnico);
				Files.write(rutaAbsoluta, bytes);
				pelicula.setPortada(nombreUnico);

				peliculasSevice.Save(pelicula);
				redirect.addFlashAttribute("PeliculaGuardada", "Pelicula Guardada");
				redirect.addFlashAttribute("PeliParaActor", pelicula);

			} catch (Exception e) {
				e.getCause().getMessage();
			}
		}

		return "redirect:/actors/actors-form";
	}

}
