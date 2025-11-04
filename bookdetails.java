
    import java.util.Scanner;

class Books {
    String name;
    String author;
    int price;
    int numPages;

    // Constructor
    Books(String name, String author, int price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    // toString method to display details
    public String toString() {
        return "Book Name: " + name + "\n" +
               "Author Name: " + author + "\n" +
               "Price: " + price + "\n" +
               "Number of Pages: " + numPages + "\n";
    }
}

public class bookdetails {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Enter number of books: ");
        int n = s.nextInt();
        s.nextLine(); // consume newline

        Books[] b = new Books[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1) + ":");

            System.out.print("Enter Book Name: ");
            String name = s.nextLine();

            System.out.print("Enter Author Name: ");
            String author = s.nextLine();

            System.out.print("Enter Book Price: ");
            int price = s.nextInt();

            System.out.print("Enter Number of Pages: ");
            int numPages = s.nextInt();
            s.nextLine(); // consume newline

            b[i] = new Books(name, author, price, numPages);
        }

        System.out.println("\n--- Book Details ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Book " + (i + 1) + " details are:\n" + b[i]);
        }

        s.close();
    }
}
