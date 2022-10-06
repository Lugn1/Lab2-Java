import java.util.Scanner;

public class Main {

    Category fruit = new Category("Fruit");

    Product banana = new Product("Fruit", "Banana", 5);
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // TODO On startup: Read information from file

        boolean flag = true;

        System.out.println("---- Welcome to the shop ------" +
                "\n1. Browse categories" +
                "\n2. Create new category" +
                "\n3. Manage inventory balance" +
                "\n4. Search for products" +
                "\nEnter menu option number and press enter: \r");

        while (flag) {
            try {
                int userChoice = scanner.nextInt();
                flag = false;
                switch (userChoice) {
                    case 1:
                        System.out.println("Browsing...");
                        break;
                    case 2:
                        System.out.println("Creating category...");
                        break;
                    case 3:
                        System.out.println("Managing inventory balance....");
                        break;
                    case 4:
                        System.out.println("Searching for products...");
                        break;
                    default:
                        flag = true;
                        System.out.println("Not an option, try again: ");
                }
            }catch (Exception e){
                System.out.println("Not an option, try again:");
                scanner.nextLine();
                flag = true;
            }
        }
    }
}

