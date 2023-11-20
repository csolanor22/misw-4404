package production;

public class Cajero {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        Producto producto1 = new Producto("Producto 1", 1000);
        Producto producto2 = new Producto("Producto 2", 2000);
        Producto producto3 = new Producto("Producto 3", 3000);

        inventario.addProducto(producto1.getNombre(), producto1);
        inventario.addProducto(producto2.getNombre(), producto2);
        inventario.addProducto(producto3.getNombre(), producto3);

        Carrito carrito = new Carrito();

        carrito.addProducto(producto1);
        carrito.addProducto(producto2);
        
        System.out.println("El precio total es: " + carrito.calcularPrecio());
        
        inventario.actualizarInventario(carrito);

    }


}
