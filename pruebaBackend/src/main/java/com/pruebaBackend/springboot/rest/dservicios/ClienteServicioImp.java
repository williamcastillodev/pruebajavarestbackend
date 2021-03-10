package com.pruebaBackend.springboot.rest.dservicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pruebaBackend.springboot.rest.daos.IClienteDao;
import com.pruebaBackend.springboot.rest.entidades.Cliente;

@Service
public class ClienteServicioImp implements IClienteServicio {
	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> consultarTodo() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente guardar(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarId(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		clienteDao.deleteById(id);
	}

	@Transactional
	public List<Cliente> procesarClientes(List<Cliente> clientes) throws Exception {
		for (Cliente cli : clientes) {
			if (cli == null || cli.getId() == null) {
				continue;
			}
			Cliente tc = buscarId(cli.getId());
			if (tc == null || tc.isProcesado()) {
				continue;
			}
			tc.setProcesado(true);
			guardar(tc);
		}
		return consultarTodo();
	}
}
