package edu.curso.java.proyecto.trackbug.service;

public class ProyectoException extends Exception{

	public ProyectoException(String message) {
		super(message);
	}
	
	public ProyectoException(String message , Throwable errorBase) {
		super(message, errorBase);
	}
}
