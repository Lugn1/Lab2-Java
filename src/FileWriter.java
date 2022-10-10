import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWriter {

    private static Path productTextFilePath = Path.of("resources", "products.txt");

    private static List<Product> productList = new ArrayList<>();

    protected static void createProductList() {
        try {
            Stream<String> rows = Files.lines(productTextFilePath);
        } catch (IOException e) {
            System.out.println("In catch block!!"); //TODO ta bort testet
            e.printStackTrace();

        }
    }
}