package pe.edu.upc.practica01.controller;

import java.util.ArrayList;

import pe.edu.upc.practica01.entity.Cliente;

public class MainController {

	public static MainController instance = null;
	
	public ArrayList<Cliente> lstClientes;
		
	public static MainController getInstance() {
		if (instance == null) {
			instance = new MainController();
		}
		return instance;
	}

	public MainController() {
		this.lstClientes = new ArrayList<Cliente>();
		this.lstClientes.add( new Cliente(1, "Isaac", "Abensur","calle 123"));
		this.lstClientes.add( new Cliente(2, "Cesar", "Pillhuaman","av 321"));
		this.lstClientes.add( new Cliente(3, "Juan", "Perez","pasaje 123"));
		this.lstClientes.add( new Cliente(4, "Richard", "Stallman","jiron 999"));
		this.lstClientes.add( new Cliente(5, "Linus", "Torvalds","elm street "));
		this.lstClientes.add( new Cliente(6, "Kent", "Beck","tdd street"));
		
	}

	public String obtenerDatos(){		
		return "";
	}
		
}
