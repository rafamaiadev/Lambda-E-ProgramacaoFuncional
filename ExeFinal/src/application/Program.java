package application;

import entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Program {
    public static void main(String[] args) {
        String path = "c:\\temp\\produtos.csv";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();

            List<Product> list = new ArrayList<>();

            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            Double sum = list.stream().map(Product::getPrice).reduce(0.0, Double::sum);
            Double media = sum / list.size();

            System.out.println("Average price: " + String.format("%.2f", media));
            list.stream()
                    .filter(p -> p.getPrice() < media)
                    .sorted(Comparator.comparing(Product::getName).reversed())
                    .forEach(p -> System.out.println(p.getName()));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
