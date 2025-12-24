package functionalprogrammingtemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FunctionalProgrammingTemplate {

    public static void main(String[] args) {
        
        // ArrayList of Invoices
        
        List<Invoice> invoices = List.of(
        new Invoice(83,"Electric sander", 7, 57.98),
        new Invoice(24,"Power saw", 18, 99.99),
        new Invoice(7,"Sledge hammer", 11, 21.50),
        new Invoice(77,"Hammer", 76, 11.99),
        new Invoice(39,"Lawn mower", 3, 79.50),
        new Invoice(68,"Screw driver", 106, 6.99),
        new Invoice(56,"Jig saw", 21, 11.00),
        new Invoice(3,"Wrench", 34, 7.50));
        
        // Display Table of Invoices with Invoice toString()
        // Print Table Header

        System.out.println("Part number\tPart description\tQuantity\tPrice per item\tValue");
        invoices.stream()
            .forEach(System.out::print);
        
        // Use streams to sort Invoice object by partDecsription, then display the results.

        System.out.println("\nInvoices sorted by Part description");
        System.out.println("Part number\tPart description\tQuantity\tPrice per item\tValue");
        invoices.stream()
            .sorted(Comparator.comparing(Invoice::getPartDescription))
            .forEach(System.out::print);
        
        // Use streams to sort Invoice object by price, then display the results.

        System.out.println("\nInvoices sorted by Price");
        System.out.println("Part number\tPart description\tQuantity\tPrice per item\tValue");
        invoices.stream()
            .sorted(Comparator.comparing(Invoice::getPricePerItem))
            .forEach(System.out::print);
        
        // Use streams to map each Invoice to its partDescription and quantity, then display the results.

        System.out.println("\nPart Description and Quantity for each Invoice");
        System.out.println("Part description\tQuantity");
        invoices.stream().sorted(Comparator.comparing(Invoice::getQuantity))
            .map(invoice -> String.format("%-20s\t%d\n", invoice.getPartDescription(), invoice.getQuantity()))
            .forEach(System.out::print);
             
    }
    
}
