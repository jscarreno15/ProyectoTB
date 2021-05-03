package edu.curso.java.proyecto.trackbug.service;

public class TareaException extends Exception {

	public TareaException(String message) {
		super(message);
	}
	
	public TareaException(String message , Throwable errorBase) {
		super(message, errorBase);
	}
}
