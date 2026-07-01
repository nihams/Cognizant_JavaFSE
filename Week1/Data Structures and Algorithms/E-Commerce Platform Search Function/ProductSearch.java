import java.util.Arrays;
import java.util.Comparator;

public class ProductSearch {

    // LINEAR SEARCH
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.getProductId() == targetId) {
                return p;
            }
        }
        return null; // not found
    }

    // BINARY SEARCH
    public static Product binarySearch(Product[] sortedProducts, int targetId) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return sortedProducts[mid];
            } else if (midId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(105, "Wireless Mouse", "Electronics"),
                new Product(102, "Bluetooth Speaker", "Electronics"),
                new Product(110, "Office Chair", "Furniture"),
                new Product(101, "Notebook", "Stationery"),
                new Product(108, "Desk Lamp", "Furniture"),
                new Product(103, "Water Bottle", "Kitchen")
        };

        System.out.println("=== Linear Search (Unsorted Array) ===");
        int searchId = 108;
        long start = System.nanoTime();
        Product result1 = linearSearch(products, searchId);
        long end = System.nanoTime();
        System.out.println("Searching for ID " + searchId + ": " + result1);
        System.out.println("Time taken: " + (end - start) + " ns\n");

        System.out.println("=== Binary Search (Sorted Array) ===");
        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        System.out.println("Sorted products by ID:");
        for (Product p : sortedProducts) {
            System.out.println("  " + p);
        }

        start = System.nanoTime();
        Product result2 = binarySearch(sortedProducts, searchId);
        end = System.nanoTime();
        System.out.println("\nSearching for ID " + searchId + ": " + result2);
        System.out.println("Time taken: " + (end - start) + " ns");

        System.out.println("\n=== Searching for Non-Existent Product (ID 999) ===");
        System.out.println("Linear Search result: " + linearSearch(products, 999));
        System.out.println("Binary Search result: " + binarySearch(sortedProducts, 999));
    }
}
