package Laboration2;

import java.util.Objects;

public class Category {
    private static String categoryName;

    Category(String category) {
        this.categoryName = category;
    }


    public static String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return categoryName;
    }

    public String category() {
        return categoryName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Category) obj;
        return Objects.equals(this.categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }

}
