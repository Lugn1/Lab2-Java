package Laboration2;

import java.util.Objects;

public class Product {

    private String categoryName;
    private String productName;
    private double price;
    private String trademark;
    private String EAN;
    private int storageAmount;

    public Product(String categoryName, String productName, double price, String trademark,
                   String EAN, int storageAmount) {
        this.categoryName = categoryName;
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
        return price == product.price && storageAmount == product.storageAmount && Objects.equals(categoryName, product.categoryName) && Objects.equals(productName, product.productName) && Objects.equals(trademark, product.trademark) && Objects.equals(EAN, product.EAN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, productName, price, trademark, EAN, storageAmount);
    }

    @Override
    public String toString() {
        return "[CATEGORY]: " + categoryName +
                " [PRODUCT]: " + productName  +
                " [PRICE]: " + price +
                " [STOCK]: " + storageAmount +
                " [TRADEMARK]: " + trademark +
                " [EAN]: " + EAN + "\n-------------------------------------------------" +
                "-------------------------------------------------------------------";
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
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

    public void setCategory(String categoryName) {
        this.categoryName = categoryName;
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

    public String getCategoryName() {
        return categoryName;
    }
}
