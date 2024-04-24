import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        var entrada = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        int number;
        char typeProduct;
        String name, date;
        double price, customsFee;
        SimpleDateFormat dataHora = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("|Enter the desired product number: |");
        number = entrada.nextInt();

        for (int i = 0; i < number; i++) {
            System.out.println("Product # "+ (i + 1) + "Data");

            System.out.println("Enter a common, used, or imported product (C - Common / U - Used / I - Imported)");
            typeProduct = entrada.next().toUpperCase().charAt(0);
            entrada.nextLine();
            System.out.println("Enter the name of the product: ");
            name = entrada.nextLine();
            System.out.println("Enter the price of the Product: ");
            price = entrada.nextDouble();

            if (typeProduct == 'I') {
                System.out.print("Customs fee: ");
                customsFee = entrada.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));

            } else if (typeProduct == 'U') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String dateStr = entrada.next();
                Date manufactureDate = dataHora.parse(dateStr, new ParsePosition(0));
                products.add(new UsedProduct(name, price, manufactureDate));

            } else {
                products.add(new Product(name, price));
            }
        }

        System.out.println("|Price tags: |");
        for(Product product: products) {
            if (product instanceof ImportedProduct) {
                double totalPrice = product.getPrice() + ((ImportedProduct) product).getCustomsFee();
                System.out.println(product.getName() + " - $" + String.format("%.2f", totalPrice));
            } else {
                System.out.println(product.getName() + " - $" + String.format("%.2f", product.getPrice()));
            }
        }
        
        entrada.close();

    }
}