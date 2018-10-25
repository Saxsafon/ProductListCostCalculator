package pack;

public class Product {
    private String productName;
    Money price;

    public Product(String productName, Money price) {
        this.productName = productName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                '}';
    }


}