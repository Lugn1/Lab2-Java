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

    private static List<Product> productList = new ArrayList<>();



    public static void printFileAsStream(){

        try(Stream<String> lines = Files.lines(productsTxtPath)) {         // Try with i stället för vanliga try catch som metoden under
            lines.forEach(System.out::println);
        } catch (IOException e){
            System.out.println("IN CATCH BLOCK");
            throw new RuntimeException(e);
        }
    }

    protected static void createProductList(){
        try(Stream<String> lines = Files.lines(productsTxtPath)) {
            productList = lines.skip(1)
                    .map(FileWriter::createProductFromFile)
                    .collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    protected static Product createProductFromFile(String line){
        String[] product = pattern.split(line);
        return new Product(new Category(product[0]),
                product[1],
                Integer.parseInt(product[2]),
                product[3],
                product[4],
                Integer.parseInt(product[5]));
    }
    // CONSTRUCTOR: public Laboration2.Product(Laboration2.Category category, String productName, int price, String trademark, String EAN, int storageAmount)


    private static void productRow(Product product, List<String> productList) {
        productList.add(String.join(",",
                Category.getCategoryName(),
                product.getProductName(),
                String.valueOf(product.getPrice()),
                product.getTrademark(),
                String.valueOf(product.getEAN()),
                String.valueOf(product.getStorageAmount())));
    }



}