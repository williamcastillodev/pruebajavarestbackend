package com.pruebaBackend.springboot.rest.daos;

import org.springframework.data.repository.CrudRepository;

import com.pruebaBackend.springboot.rest.entidades.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
