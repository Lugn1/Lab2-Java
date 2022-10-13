package Laboration2;

import java.util.Objects;

public class Product {

    private Category category;
    private String productName;
    private int price;
    private String trademark;
    private String EAN;
    private int storageAmount;

    public Product(Category category, String productName, int price, String trademark,
                   String EAN, int storageAmount) {
        this.category = category;
        this.productName = productName;
        this.price = price;
        this.trademark = trademark;
        this.EAN = EAN;
        this.storageAmount = storageAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && storageAmount == product.storageAmount && Objects.equals(category, product.category) && Objects.equals(productName, product.productName) && Objects.equals(trademark, product.trademark) && Objects.equals(EAN, product.EAN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, productName, price, trademark, EAN, storageAmount);
    }

    @Override
    public String toString() {
        return "[CATEGORY]: " + category +
                " [PRODUCT]: '" + productName + '\'' +
                " [PRICE]: " + price +
                " [STOCK]: '" + storageAmount + '\'' +
                " [TRADEMARK]: " + trademark +
                " [EAN]: " + EAN + "\n-------------------------------------------------" +
                "-------------------------------------------------------------------";
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
    public String getTrademark() {
        return trademark;
    }
    public String getEAN() {
        return EAN;
    }
    public int getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(int storageAmount) {
        this.storageAmount = storageAmount;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    public void setEAN(String EAN) {
        this.EAN = EAN;
    }

    public Category getCategory() {
        return category;
    }
}
