package pe.edu.upc.practica01.entity;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String lastName;
    
    public Cliente(){    	
    }
    public Cliente(int id, String name, String lastName){
    	this.id = id;
    	this.name = name;
    	this.lastName = lastName;
    }

    public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}

