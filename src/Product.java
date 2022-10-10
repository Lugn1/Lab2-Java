public class Product {

    private final Category category;
    private String productName;
    private int price;
    private String trademark;
    private int EAN;
    private int storageAmount;

    public Product(Category category, String productName, int price, String trademark, int EAN, int storageAmount) {
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.trademark = trademark;
        this.EAN = EAN;
        this.storageAmount = storageAmount;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Product{" +
                "category=" + category +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", trademark='" + trademark + '\'' +
                ", EAN=" + EAN +
                ", storageAmount=" + storageAmount +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTrademark() {
        return trademark;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public int getEAN() {
        return EAN;
    }

    public void setEAN(int EAN) {
        this.EAN = EAN;
    }

    public int getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(int storageAmount) {
        this.storageAmount = storageAmount;
    }

    public Category getCategory() {
        return category;
    }
}
