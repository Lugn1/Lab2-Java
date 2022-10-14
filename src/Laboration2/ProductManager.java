package Laboration2;

import java.util.*;
import static Laboration2.FileWriter.productList;
public class ProductManager {

    public static Scanner scanner = new Scanner(System.in);

    public static void printAllProducts() {
        System.out.println("ALL PRODUCTS");
        System.out.println("---------------");
        productList.stream().map(Product::toString)
                .sorted()
                .forEach(System.out::println);

    }

    public static void manageProductMenu() {

        System.out.println("---- PRODUCT MANAGER ----");
        System.out.println("""
                1. Manage a product's stock NOT USED
                2. Change a product's category NOT USED
                3. Change a product's name 
                4. Remove a product from storage""");


        System.out.println("What do you want to do?");
        char optionChoice = scanner.next().charAt(0);

        if (optionChoice == '1')
            System.out.println("MANAGING STOCK,,");
            //manageProductMenu();
        else if (optionChoice == '2')
            changeProductCategory();
        else if (optionChoice == '3')
            changeProductName();
        else if (optionChoice == '4')
            removeProduct();
        else
            System.out.println("Not an option.");

       // manageProductOptions(optionChoice);


    }

    private static void changeProductName() {
    }

    private static void removeProduct() {
        printProducts();
        String userProductChoice = chooseProduct();

        try {
        Product removeChosenProduct = productList.stream()
                .filter(product -> product.getProductName().equals(userProductChoice))
                .reduce((product, product2) -> product2).get();

            productList.remove(removeChosenProduct);
            System.out.println(userProductChoice + " was successfully removed from storage.");
            pressEnterToContinue();


        } catch (Exception e) {
            System.out.println("No such product. Redirecting back to main menu.");
        }


    }

    private static String chooseProduct() {
        scanner.nextLine();
        System.out.println("Enter the product you want to manage: ");
        return scanner.nextLine().toUpperCase();
    }

    private static void changeProductCategory() {
        

    }

    public static void changeStorageAmount(String userProductChoice) {      // TODO INPUT VALIDATION, crashar med bokstäver

        productList.stream().map(Product::getProductName)
                        .equals(userProductChoice);


        System.out.println("0:\tBack to main menu.");
        System.out.println("Choose product and press \"ENTER\", OR enter 0 to get back to menu.");

        }


    private static void printProducts() {
        productList.stream().map(Product::getProductName)
                .sorted()
                .forEach(System.out::println);
    }

    private static void newStorageAmount(int input) {       // TODO INPUT VALIDATION crashar med bokstäver
        System.out.println("Enter new amount: ");
        productList.get(input).setStorageAmount(scanner.nextInt());

        //changeStorageAmount();
    }

    public static void searchProducts() {
        System.out.println("--- SEARCH FOR PRODUCT ---");
        System.out.println("Enter category or product:");
        String userInput = scanner.nextLine().toUpperCase();


        System.out.println("RESULTS: ");
        productList.stream()
        .filter(products -> products.getCategoryName().equals(userInput)
                                                || products.getProductName().contains(userInput))
                .forEach(System.out::println);

        pressEnterToContinue();

    }

    public static void createNewProduct() {
        String categoryName, productName, trademark, EAN;
        int amount;
        double price;

        try {
            System.out.println("Enter product category: ");
            categoryName = scanner.nextLine().toUpperCase();
            System.out.println("Enter product name: ");
            productName = scanner.nextLine().toUpperCase();
            System.out.println("Enter product trademark: ");
            trademark = scanner.nextLine().toUpperCase();
            System.out.println("Enter product EAN code: ");
            EAN = scanner.nextLine().toUpperCase();
            System.out.println("Enter product price: ");
            price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter amount: ");
            amount = scanner.nextInt();
            scanner.nextLine();

            FileWriter.addProductToFile(new Product(categoryName, productName, price, trademark, EAN, amount));


        } catch (InputMismatchException e){
            System.out.println("Invalid input.");
        }

        // addProductToFile()
    }

    public static void searchProductsByPrice() {

        System.out.println("Enter minimum price: ");
        int minPrice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter maximum price: ");
        int maxPrice = scanner.nextInt();
        scanner.nextLine();

        productList.stream()
                .filter(productPrice -> productPrice.getPrice() <= maxPrice && productPrice.getPrice() >= minPrice)
                .sorted(Comparator.comparing((Product::getProductName)))
                .forEach(System.out::println);
    }

    public static void pressEnterToContinue() {
        System.out.println("Press \"ENTER\" to continue..");
        scanner.nextLine();
    }
}


