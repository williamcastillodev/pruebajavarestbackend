package com.pruebaFrontend.springboot.web.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/app", "", "/" })
public class IndexControlador {
	@GetMapping({ "/index", "/", "", "clientes" })
	public String index(Model model) {
		return "clientes/consulta";
	}

	@GetMapping({ "/registro" })
	public String registro(Model model) {
		return "clientes/registro";
	}
}
