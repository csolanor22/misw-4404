package refactoring.problema3;

import refactoring.problema3.Product;
import refactoring.problema3.Sale;
import refactoring.problema3.Order;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Inventory {

    public static void main(String[] args) {
        String csvFileProducts = "./data/products.csv";
        String csvFileSales = "./data/sales.csv";
        String csvFileOrders = "./data/orders.csv";

        System.out.println(csvFileProducts);

        Store store = new Store();

        store.setProductsFromCsv(csvFileProducts);
        store.setSalesFromCsv(csvFileSales);
        store.setOrdersFromCsv(csvFileOrders);

        store.updateInventory();

        System.out.println(store.printInventory());
    }
}
