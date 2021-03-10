package com.pruebaBackend.springboot.rest.dservicios;

import java.util.List;

import com.pruebaBackend.springboot.rest.entidades.Cliente;

public interface IClienteServicio {
	public List<Cliente> consultarTodo();

	public Cliente guardar(Cliente cliente);

	public Cliente buscarId(Long id);

	public void eliminar(Long id);
}
