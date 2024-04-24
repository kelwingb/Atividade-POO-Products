public class Product {
    private String name;
    private Double price;

    public Product() {

    }
    public Product(String nome, Double preco) {
        this.name = nome;
        this.price = preco;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String priceTag(){
        return name;
    }
}