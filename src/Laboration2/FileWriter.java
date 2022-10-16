package Laboration2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWriter {

    private final static Pattern pattern = Pattern.compile(",");
    private final static Path productsTxtPath = Path.of("src\\Laboration2\\resources", "products.txt");

    static List<Product> productList = new ArrayList<>();

    protected static void createProductList() {
        try (Stream<String> lines = Files.lines(productsTxtPath)) {
            productList = lines.map(FileWriter::createProductFromFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Product createProductFromFile(String line) {
        String[] product = pattern.split(line);
        return new Product(product[0],
                product[1],
                Double.parseDouble(product[2]),
                product[3],
                product[4],
                Integer.parseInt(product[5]));
    }

    public static void addProductToFile(Product newProduct) {
        productList.add(newProduct);
    }

    public static void saveProductsToFile() {
        List<String> productsLines = new ArrayList<>();
        productList.forEach(product -> productRow(product, productsLines));

        try {
            Files.write(productsTxtPath, productsLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static void productRow(Product product, List<String> productList) {
        productList.add(String.join(",",
                product.getCategoryName(),
                product.getProductName(),
                String.valueOf(product.getPrice()),
                product.getTrademark(),
                String.valueOf(product.getEAN()),
                String.valueOf(product.getStorageAmount())));
    }
}