package ec.com.dinersclub.bff.services.models;

import java.util.UUID;

public class CreateTarjetaCommand {
	
	private UUID id;
    private String nombre;
    
    public CreateTarjetaCommand(UUID id, String nombre) {
    	this.setId(id);
    	this.setNombre(nombre);
    }
    
    public CreateTarjetaCommand() {}
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
