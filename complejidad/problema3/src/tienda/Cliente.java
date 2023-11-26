package tienda;


public class Cliente {
    private String nombre; 

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
	public int applyDiscount(int total) {
		return total *= 1;
	}

}
