public class ImportedProduct extends Product {
    private Double customsFee;

    public ImportedProduct(Double customsFee) {
        this.customsFee = customsFee;
    }

    public ImportedProduct(String nome, Double preco, Double customsFee) {
        super(nome, preco);
        this.customsFee = customsFee;
    }  
    
    public Double getCustomsFee() {
        return customsFee;
    }

    public double CustomsFeeAdd () {
        return customsFee + getPrice();
    }

    @Override
    public String priceTag() {
        return super.priceTag() + " Price: $" + CustomsFeeAdd() +" (Customs fee: $ " + String.format("%.2f", getCustomsFee()) + ")";
    }
}
