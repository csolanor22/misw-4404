package production;


// import hashmap
import java.util.HashMap;

public class Inventario {
	
    private HashMap<String, Producto> productos;

    public Inventario(){
        this.productos = new HashMap<String, Producto>();
    }
    
    public void addProducto(String name, Producto producto) {
    	this.productos.put(name, producto);
    }

    public void actualizarInventario(Carrito carrito) {
        for (Producto producto : carrito.getProductos()) {
            this.productos.remove(producto.getNombre());
        }
    }


}
