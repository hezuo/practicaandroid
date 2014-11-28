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
		this.lstClientes.add( new Cliente(1, "Isaac", "Abensur","calle 123","4564646","Developer"));
		this.lstClientes.add( new Cliente(2, "Cesar", "Pillhuaman","av 321","33333","Senior Developer"));
		this.lstClientes.add( new Cliente(3, "Juan", "Perez","pasaje 123","777","Analista"));
		this.lstClientes.add( new Cliente(4, "Richard", "Stallman","jiron 999","88888","Free Software Evangelist"));
		this.lstClientes.add( new Cliente(5, "Linus", "Torvalds","elm street ","11111222","Linux Developer"));
		this.lstClientes.add( new Cliente(6, "Kent", "Beck","tdd street","33333","TDD Developer"));
		
	}

	public String obtenerDatos(){		
		return "";
	}
		
}
