package Laboration2;

import java.util.*;

import static Laboration2.FileWriter.productList;

public class ProductManager {

    public static Scanner scanner = new Scanner(System.in);

    public static void manageProductMenu() {
        printProductsName();
        String userProductChoice = chooseProduct();

        System.out.println("-- PRODUCT MANAGER OF " + userProductChoice + " --");
        System.out.println("""
                1. Change inventory balance
                2. Change the category
                3. Change the name
                4. Change price
                R. Remove from inventory (Cannot be undone)
                E. Back to menu.""");

        System.out.println("What do you want to do?");
        char optionChoice = scanner.next().charAt(0);
        switch (optionChoice) {
            case '1' -> newStorageAmount(userProductChoice);
            case '2' -> changeProductCategory(userProductChoice);
            case '3' -> changeProductName(userProductChoice);
            case '4' -> changeProductPrice(userProductChoice);
            case 'r', 'R' -> removeProduct(userProductChoice);
            case 'e', 'E' -> scanner.nextLine();
            default -> System.out.println("Not an option.");
        }
    }

    private static void removeProduct(String userProductChoice) {

        try {
            Product removeChosenProduct = productList.stream()
                    .filter(product -> product.getProductName().contains(userProductChoice))
                    .reduce((product, product2) -> product2).get();

            productList.remove(removeChosenProduct);
            System.out.println(userProductChoice + " was successfully removed from storage.");

        } catch (Exception e) {
            System.out.println("No such product. Redirecting back to main menu.");
        }


    }

    private static void changeProductName(String userProductChoice) {
        scanner.nextLine();
        System.out.println("Enter the new name for " + userProductChoice + ":");
        String newName = scanner.nextLine().toUpperCase();

        try {
            productList.stream().filter(product -> product.getProductName().equals(userProductChoice))
                    .forEach(product -> product.setProductName(newName));
            System.out.println("Product name successfully updated.");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }

    private static void changeProductCategory(String userProductChoice) {
        scanner.nextLine();
        System.out.println("Enter the new category for " + userProductChoice + ":");
        String newCategory = scanner.nextLine().toUpperCase();

        try {
            productList.stream().filter(product -> product.getProductName().equals(userProductChoice))
                    .forEach(product -> product.setCategory(newCategory));
            System.out.println("Category successfully updated.");
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }

    }

    private static void changeProductPrice(String userProductChoice) {

        System.out.println("Enter the new price for " + userProductChoice + ":");
        if (scanner.hasNextDouble()) {
            double newPrice = scanner.nextDouble();

            try {
                productList.stream().filter(product -> product.getProductName().equals(userProductChoice))
                        .forEach(product -> product.setPrice(newPrice));
                System.out.println("Price updated.");
            } catch (Exception e) {
                System.out.println("No such product.");
            }
        } else System.out.println("Invalid input.");

        scanner.nextLine();
    }

    private static void newStorageAmount(String userProductChoice) {
        System.out.println("Enter the new inventory balance for " + userProductChoice + ":");

        if (scanner.hasNextInt()) {
            int newStorageAmount = scanner.nextInt();
            try {
                productList.stream().filter(product -> product.getProductName().equals(userProductChoice))
                        .forEach(product -> product.setStorageAmount(newStorageAmount));
                System.out.println("Storage amount successfully updated.");
            } catch (Exception e){
                System.out.println("Something went wrong.");
            }

        } else System.out.println("Invalid input.");

        scanner.nextLine();
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
            System.out.println("Enter product price: ");
            price = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter amount: ");
            amount = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter product EAN code: ");
            EAN = scanner.nextLine().toUpperCase();

            FileWriter.addProductToFile(new Product(categoryName, productName, price, trademark, EAN, amount));


        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        }
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

    private static String chooseProduct() {
        System.out.println("Enter the product you want to manage: ");
        return scanner.nextLine().toUpperCase();
    }

    public static void printAllProducts() {
        System.out.println("ALL PRODUCTS");
        System.out.println("---------------");
        productList.stream().map(Product::toString)
                .sorted()
                .forEach(System.out::println);
    }

    private static void printProductsName() {
        System.out.println("PRODUCTS:\n---------");
        productList.stream().map(Product::getProductName)
                .sorted()
                .forEach(System.out::println);
    }

    public static void pressEnterToContinue() {
        System.out.println("Press \"ENTER\" to continue..");
        scanner.nextLine();
    }

}


