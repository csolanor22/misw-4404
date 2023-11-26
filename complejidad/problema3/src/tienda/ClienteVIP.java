package tienda;

public class ClienteVIP extends Cliente{

	public ClienteVIP(String nombre) {
		super(nombre);
	}
	
	public int applyDiscount(int total) {
		return total *= 0.8;
	}

}
