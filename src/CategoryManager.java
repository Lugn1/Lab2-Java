
import java.util.*;

public class CategoryManager {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Category> allCategories = new ArrayList<>(readCategoriesFromFile());


    public static List<Category> readCategoriesFromFile(){      // TODO READ FROM FILE
        return List.of(
                new Category("FRUIT"),
                new Category("DAIRY"),
                new Category("CANDY"),
                new Category("BREAD"));

    }

    public static void printAllCategories(){

        System.out.println("ALL CATEGORIES");
        System.out.println("---------------");
        allCategories.stream()
                .map(Category::getCategoryName)
                .sorted()
                .forEach(System.out::println);

    }

    public static void createNewCategory(){ //Category category
        System.out.println("Enter the name of the new category: ");
            allCategories.add(new Category(scanner.nextLine().toUpperCase()));

            // TODO SAVE TO FILE
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
