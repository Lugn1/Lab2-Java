import java.util.Arrays;
import java.util.Objects;

public class Category {
    private String categoryName;
    private String TESTSTRING;

    public Category(String categoryName) {
        this.categoryName = getCategoryName();
    }

    public String getCategoryName() {
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

    @Override
    public String toString() {
        return "Category[" +
                "categoryName=" + categoryName + ']';
    }


}
