package Laboration2;

import java.util.*;


public class ProductManager {

    public static Scanner scanner = new Scanner(System.in);
    private static List<Product> allProductsList = new ArrayList<>();

//    public static List<Laboration2.Product> readProductsFromFile() {        // TODO READ FROM FILE
//
//        return List.of(
//                new Laboration2.Product(new Laboration2.Category("FRUIT"), "BANANA", 8, "DOLE",
//                        1234, 45),
//                new Laboration2.Product(new Laboration2.Category("DAIRY"), "MILK", 20, "ARLA",
//                        4312, 50),
//                new Laboration2.Product(new Laboration2.Category("CANDY"), "CHOCOLATE", 25, "MARABOU",
//                        3541, 89),
//                new Laboration2.Product(new Laboration2.Category("BREAD"), "WHITE TOAST", 35, "TIPTOP",
//                        5143, 25),
//                new Laboration2.Product(new Laboration2.Category("FRUIT"), "PEAR", 35, "RANDOM",
//                        6543, 25),
//                new Laboration2.Product(new Laboration2.Category("DAIRY"), "CHEESE", 35, "GET",
//                        2222, 25),
//                new Laboration2.Product(new Laboration2.Category("CANDY"), "LOLLIPOP", 35, "CRUSH",
//                        1111, 25),
//                new Laboration2.Product(new Laboration2.Category("FRUIT"), "APPLE", 8, "APPLEZ",
//                        1231, 76));
//    }

    public static void printAllProducts() {
        scanner.nextLine();
        System.out.println("ALL PRODUCTS");
        System.out.println("---------------");
        allProductsList.stream().map(Product::toString)
                .sorted()
                .forEach(System.out::println);

    }

    public static void manageProductMenu() {

        System.out.println("---- PRODUCT MANAGER ----");
        System.out.println("""
                1. Manage a product's stock NOT USED
                2. Change a product's category NOT USED
                3. Remove a product from storage""");


        System.out.println("What do you want to do?");
        char optionChoice = scanner.next().charAt(0);

        if (optionChoice == '1')
            System.out.println("MANAGING STOCK,,");
            //manageProductMenu();
        else if (optionChoice == '2')
            changeProductCategory();
        else if (optionChoice == '3')
            removeProduct();
        else
            System.out.println("Not an option.");

       // manageProductOptions(optionChoice);


    }


    private static void removeProduct() {
        printProducts();
        scanner.nextLine();
        System.out.println("Enter the product you want to manage: ");
        String userProductChoice = scanner.nextLine().toUpperCase();

        try {
        Product removeChosenProduct = allProductsList.stream()
                .filter(product -> product.getProductName().equals(userProductChoice))
                .reduce((product, product2) -> product2).get();

        allProductsList.remove(removeChosenProduct);
            System.out.println(userProductChoice + " was successfully removed from storage.");
            Main.pressEnterToContinue();
            scanner.nextLine();

        } catch (Exception e) {
            System.out.println("No such product. Redirecting back to menu.");
        }


    }

    private static void changeProductCategory() {

    }

    public static void changeStorageAmount(String userProductChoice) {      // TODO INPUT VALIDATION, crashar med bokstäver

        allProductsList.stream().map(Product::getProductName)
                        .equals(userProductChoice);


        System.out.println("0:\tBack to main menu.");
        System.out.println("Choose product and press \"ENTER\", OR enter 0 to get back to menu.");

        }


    private static void printProducts() {
        allProductsList.stream().map(Product::getProductName)
                .sorted()
                .forEach(System.out::println);
    }

    private static void newStorageAmount(int input) {       // TODO INPUT VALIDATION crashar med bokstäver
        System.out.println("Enter new amount: ");
        allProductsList.get(input).setStorageAmount(scanner.nextInt());

        //changeStorageAmount();
    }

    public static void searchProducts() {
        System.out.println("--- SEARCH FOR PRODUCT ---");
        System.out.println("Enter category or product:");
        String userInput = scanner.nextLine().toUpperCase();

        ProductManager.allProductsList.stream()
                .filter(product -> Category.getCategoryName().equals(userInput)
                                                || product.getProductName().equals(userInput))
                .forEach(System.out::println);

    }

    public static void createNewProduct() {
        String category, productName, trademark, EAN;
        int amount, price;


        System.out.println("Enter product category: ");
        category = scanner.nextLine().toUpperCase();
        System.out.println("Enter product name: ");
        productName = scanner.nextLine().toUpperCase();
        System.out.println("Enter product trademark: ");
        trademark = scanner.nextLine().toUpperCase();
        System.out.println("Enter product price: ");
        price = scanner.nextInt();
        System.out.println("Enter amount: ");
        amount = scanner.nextInt();
        System.out.println("Enter product EAN code: ");
        EAN = scanner.nextLine();

        allProductsList.add(new Product(new Category(category),productName,price,trademark,EAN, amount));
    }

    public static void searchProductsByPrice() {

        System.out.println("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();

        allProductsList.stream()
                .filter(productPrice -> productPrice.getPrice() <= maxPrice && productPrice.getPrice() >= minPrice)
                .forEach(System.out::println);
    }
}


