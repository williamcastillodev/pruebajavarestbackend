package com.pruebaBackend.springboot.rest.utils;

public class Utilidades {
	public static boolean textovacio(String texto) throws Exception {
		if (texto == null || texto.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static void cargarErrorRespuesta(ClienteJson res, String mensajeError) throws Exception {
		res.setRespuesta(ClienteJson.ResERROR);
		res.setMensaje(mensajeError);
	}
}
