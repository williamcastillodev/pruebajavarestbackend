package com.pruebaBackend.springboot.rest.utils;

public class MiExcepcion extends Exception {
	private static final long serialVersionUID = 1L;

	public MiExcepcion(String mensaje) {
		super(mensaje);
	}
}
