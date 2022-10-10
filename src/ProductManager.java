import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ProductManager {

    public static Scanner scanner = new Scanner(System.in);
    private static List<Product> allProductsList = new ArrayList<>(readProductsFromFile());

    public static List<Product> readProductsFromFile() {        // TODO READ FROM FILE
        return List.of(
                new Product(new Category("FRUIT"), "BANANA", 8, "DOLE",
                        1234, 45),
                new Product(new Category("DAIRY"), "MILK", 20, "ARLA",
                        4312, 50),
                new Product(new Category("CANDY"), "CHOCOLATE", 25, "MARABOU",
                        3541, 89),
                new Product(new Category("BREAD"), "WHITE TOAST", 35, "TIPTOP",
                        5143, 25));
    }

    public static void printAllProducts() {

        System.out.println("ALL PRODUCTS");
        System.out.println("---------------");
        allProductsList.stream().map(Product::toString)
                .sorted()
                .forEach(System.out::println);

    }

    public static void printAllCategoriesAndProducts() {

        System.out.println("Enter the category name: ");
        String userSearch = scanner.nextLine().toUpperCase();


        Main.pressEnterToContinue();


    }


    public static void changeStorageAmount() {      // TODO INPUT VALIDATION, crashar med bokstäver

        printStorageAmount();

        System.out.println("0:\tBack to main menu.");
        System.out.println("Choose product and press \"ENTER\"");

        int userChoice = scanner.nextInt();
        scanner.nextLine();

        if (userChoice != 0) {
            setNewStorageAmount(userChoice);
        }
    }


    private static void setNewStorageAmount(int userChoice) {

        switch (userChoice) {
            case 1:
                System.out.println("1: " + allProductsList.get(0).getProductName()
                        + " " + allProductsList.get(0).getStorageAmount() + "x");
                newStorageAmount(userChoice);
                break;
            case 2:
                System.out.println("2: " + allProductsList.get(1).getProductName()
                        + " " + allProductsList.get(1).getStorageAmount() + "x");
                newStorageAmount(userChoice);
                break;
            case 3:
                System.out.println("3: " + allProductsList.get(2).getProductName()
                        + " " + allProductsList.get(2).getStorageAmount() + "x");
                newStorageAmount(userChoice);
                break;
            case 4:
                System.out.println("4: " + allProductsList.get(3).getProductName()
                        + " " + allProductsList.get(3).getStorageAmount() + "x");
                newStorageAmount(userChoice);
                break;
            case 0:
                break;
            default:
                changeStorageAmount();
        }
    }

    private static void printStorageAmount() {
        for (int i = 0; i < allProductsList.size(); i++) {
            System.out.print("\n" + (i + 1) + ":\t");
            System.out.print(allProductsList.get(i).getProductName() + ": "
                    + allProductsList.get(i).getStorageAmount() + "x.");
        }
        System.out.println();
    }

    private static void newStorageAmount(int input) {       // TODO INPUT VALIDATION crashar med bokstäver
        System.out.println("Enter new amount: ");
        allProductsList.get(input - 1).setStorageAmount(scanner.nextInt());
        changeStorageAmount();
    }

    public static void searchProducts() {
        System.out.println("Searching...");
    }
}


