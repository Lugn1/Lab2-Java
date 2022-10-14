package Laboration2;

import java.util.Scanner;

 //TODO on startup read from file

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       FileWriter.createProductList();

        Main menu = new Main();
        menu.runMenu();


    }

    public static void printMainMenu(){     // TODO egen meny klass
        System.out.println("""
                \t\tWelcome to the store
                --------------------------------------
                1. Show a list of all products
                2. Add a new product
                3. Manage product
                4. Search for products
                5. Filter products by price KANSKE????
                6. SAVE TO FILE
                e. Save and exit

                Enter menu option number and press enter: \r""");
    }
    private void runMenu() {

        while (true) {
            printMainMenu();
                char userChoice = scanner.next().charAt(0);
            switch (userChoice) {
                case '1' -> ProductManager.printAllProducts();
                case '2' -> ProductManager.createNewProduct();
                case '3' -> ProductManager.manageProductMenu();
                case '4' -> ProductManager.searchProducts();
                case '5' -> ProductManager.searchProductsByPrice();
                case '6' -> FileWriter.saveProductsToFile();
                case 'e' -> {
                    FileWriter.saveProductsToFile();
                    System.out.println("Shutting down...");
                    System.exit(0);
                }
                default -> System.out.println("Not an valid option, try again.\n");
            }
            }
        }
}

