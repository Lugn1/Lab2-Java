
public class Product extends Category {

    private String productName;
    private int storageAmount;

    public Product(String categoryName, String productName, int storageAmount) {
        super(categoryName);
        this.productName = productName;
        this.storageAmount = storageAmount;
    }
}
