package pe.edu.upc.practica01.entity;

import java.io.Serializable;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String lastName;
    private String address;
    private boolean estadoVisita;
    
    
    
    public boolean getEstadoVisita() {
		return estadoVisita;
	}
	public void setEstadoVisita(boolean estadoVisita) {
		this.estadoVisita = estadoVisita;
	}
	
	public String getPhone()
    {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	private String phone;
    private String field;
    
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Cliente(){    	
    }
	
	
    public Cliente(int id, String name, String lastName, String address,
			String phone, String field, boolean estado) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.field = field;
		this.estadoVisita = estado;
	}
	public Cliente(int id, String name, String lastName, String address){
    	this.id = id;
    	this.name = name;
    	this.lastName = lastName;
    	this.address = address;
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
    
    public String getNombreCompleto(){
    	return this.getName() + " " + this.getLastName();
    }

}

