package com.pruebaBackend.springboot.rest.utils;

import java.io.Serializable;
import java.util.List;

import com.pruebaBackend.springboot.rest.entidades.Cliente;

public class ClienteJson implements Serializable {
	public static final String ResOK = "OK";
	public static final String ResERROR = "ERROR";

	public ClienteJson() {
		super();
		this.respuesta = ResOK;
	}

	private String respuesta;
	private String mensaje;
	private Cliente cliente;
	private List<Cliente> clientes;

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
