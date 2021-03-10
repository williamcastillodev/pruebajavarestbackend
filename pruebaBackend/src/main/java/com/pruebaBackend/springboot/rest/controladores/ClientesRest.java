package com.pruebaBackend.springboot.rest.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaBackend.springboot.rest.dservicios.ClienteServicioImp;
import com.pruebaBackend.springboot.rest.entidades.Cliente;
import com.pruebaBackend.springboot.rest.utils.ClienteJson;
import com.pruebaBackend.springboot.rest.utils.MiExcepcion;
import com.pruebaBackend.springboot.rest.utils.Utilidades;

@RestController

@CrossOrigin(origins = { "http://localhost:8888" })
@RequestMapping("/api")
public class ClientesRest {
	@Autowired
	private ClienteServicioImp cliservicio;

	@GetMapping("/clientes")
	public ClienteJson consultar() throws Exception {
		ClienteJson res = new ClienteJson();
		try {
			res.setClientes(cliservicio.consultarTodo());
		} catch (Exception e) {
			Utilidades.cargarErrorRespuesta(res, e.getMessage());
		}
		return res;
	}

	@PostMapping("/clientes")
	public ClienteJson crear(@RequestBody(required = false) ClienteJson clientejson) throws Exception {
		ClienteJson res = new ClienteJson();
		try {
			if (clientejson == null || clientejson.getCliente() == null) {
				throw new MiExcepcion("Parámetros no válidos");
			}
			Cliente cliente = clientejson.getCliente();
			if (Utilidades.textovacio(cliente.getNombre())) {
				throw new MiExcepcion("Nombre cliente Requerido");
			}
			if (Utilidades.textovacio(cliente.getApellido())) {
				throw new MiExcepcion("Apellido cliente Requerido");
			}
			res.setCliente(cliservicio.guardar(cliente));
		} catch (MiExcepcion e) {
			Utilidades.cargarErrorRespuesta(res, e.getMessage());
		}
		return res;
	}

	@PostMapping("/clientes/procesar")
	public ClienteJson procesar(@RequestBody(required = false) ClienteJson clientejson) throws Exception {
		ClienteJson res = new ClienteJson();
		try {
			if (clientejson == null || clientejson.getClientes() == null) {
				throw new MiExcepcion("Parámetros no válidos");
			}
			res.setClientes(cliservicio.procesarClientes(clientejson.getClientes()));
		} catch (MiExcepcion e) {
			Utilidades.cargarErrorRespuesta(res, e.getMessage());
		}
		return res;
	}

}
