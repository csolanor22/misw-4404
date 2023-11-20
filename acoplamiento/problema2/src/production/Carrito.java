package production;

import java.util.ArrayList;

public class Carrito {
    private ArrayList<Producto> productos;
    
    public Carrito() {
		this.productos = new ArrayList<Producto>();
	}

	public void addProducto(Producto producto) {
    	this.productos.add(producto);
    }

	public ArrayList<Producto> getProductos() {
		return productos;
	}
	
	public double calcularPrecio() {
    	double precio = 0;
        for (Producto producto : productos) {
            precio += producto.getPrecio();
        }
        return precio;
    }
}
