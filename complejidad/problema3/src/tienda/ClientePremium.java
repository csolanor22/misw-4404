package tienda;

public class ClientePremium extends Cliente{

	public ClientePremium(String nombre) {
		super(nombre);
	}
	
	public int applyDiscount(int total) {
		return total *= 0.9;
	}

}
