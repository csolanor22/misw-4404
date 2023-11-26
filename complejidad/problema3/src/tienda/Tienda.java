package tienda;


public class Tienda {
	
	
    public static void main(String[] args){
        Tienda tienda = new Tienda();
        Producto libro1 = new Producto("libro1", 20000);
        Producto libro2 = new Producto("libro2", 30000);

        Producto[] productos = {libro1, libro2};

        Cliente cliente1 = new Cliente("Jose");
        Cliente cliente2 = new ClientePremium("Juan");
        Cliente cliente3 = new ClienteVIP("Pedro");

        tienda.imprimirRecibo(productos, cliente1);
        tienda.imprimirRecibo(productos, cliente2);
        tienda.imprimirRecibo(productos, cliente3);
    }

    public void imprimirRecibo(Producto[] productos, Cliente cliente){
        int total = this.getTotal(productos);
        total = cliente.applyDiscount(total);
        System.out.println("Total para " + cliente.getNombre() + ": " + total);
    }
    
    public int getTotal (Producto[] productos) {
    	int total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }
}
