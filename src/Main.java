import java.util.Scanner;

 //TODO on startup read from file

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main menu = new Main();
        menu.runMenu();

        System.out.println("Shutting down...");
    }

    public static void printMainMenu(){
        System.out.println("""
                \t\tWelcome to the store
                --------------------------------------
                1. Show all categories
                2. Add new category
                3. Show all products
                4. Search for products
                5. Manage stock balance
                0. Exit program

                Enter menu option number and press enter: \r""");
    }
    private void runMenu() {

        boolean flag = true;

        while (flag) {
            printMainMenu();
                char userChoice = scanner.next().charAt(0);
                scanner.nextLine();
                switch (userChoice) {
                    case '1':
                        CategoryManager.printAllCategories();
                        pressEnterToContinue();
                        break;
                    case '2':
                        CategoryManager.createNewCategory();
                        break;
                    case '3':
                        ProductManager.printAllProducts();
                        break;
                    case '4':
                        ProductManager.searchProducts();
                        break;
                    case '5':
                        ProductManager.changeStorageAmount();
                        break;
                    case '6':
                        //CategoryManager.readCategories();
                        break;
                    case '0':
                        flag = false;
                        break;
                    default:
                        System.out.println("Not an valid option, try again.\n");
                }
            }
        }

    public static void pressEnterToContinue() {
        System.out.println("Press \"ENTER\" to continue..");
        scanner.nextLine();
    }

}

