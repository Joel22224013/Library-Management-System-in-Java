import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Inheriting the addBook method from Library class through the library object and passing a parameter ,Book.
        library.addBook(new Book("Good morning Holy Spirit", "Benny Hinn", "Religion"));
        library.addBook(new Book("welcome Holy Spirit", "Benny Hinn", "Religion"));
        library.addBook(new Book("In Pursuit of Purpose", "Myles Munroe", "Religion"));
        library.addBook(new Book("Life of Pi", "Yann Mantel", "Fiction"));
        library.addBook(new Book("Maus","Art Spiegelman","Novel"));


        Borrower borrower = new Borrower("Joel Ansah");

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add New Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search for Books");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Borrowed Books");
            System.out.println("7. Most Popular Books");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter book's details to add into the system.");
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    library.addBook(new Book(title, author, genre));
                    System.out.println("you have successfully added "+ title +" book to the library!");
                    break;

                case 2:
                    System.out.println("This is a list of all the books we have in the library.\n");
                    System.out.println();
                    library.displayBooks();
                    break;

                case 3:

                    // Prompt user to enter a search query
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();

                    // Get the list of books that match the query
                    List<Book> matchingBooks = library.searchBooks(query);

                    // Check if there are any books matching the query
                    if (matchingBooks.isEmpty()) {
                        System.out.println("No books found matching your query.");
                    } else {
                        // Print out each book in the matchingBooks list
                        for (Book book : matchingBooks) {
                            System.out.println(book);
                        }
                    }

                    break;

                case 4:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    for (Book book : library.searchBooks(borrowTitle)) {
                        if (library.borrowBook(borrower, book)) {
                            System.out.println(borrower.getName() +" borrowed " + book.getTitle());
                        } else {
                            System.out.println("Book is not available.");
                        }
                    }
                    break;

                case 5:
                    System.out.print("Enter book title to return book: ");
                    String returnTitle = scanner.nextLine();
                    for (Book book : borrower.getBorrowedBooks()) {
                        if (book.getTitle().equalsIgnoreCase(returnTitle)) {
                            library.returnBook(borrower, book);
                            System.out.println("You have returned: " + book.getTitle() );
                            break;
                        }
//                        else{System.out.println("This book was not borrowed!");}
                    }
                    break;

                case 6:
                    System.out.println("Borrowed Books: " + borrower.getBorrowedBooks()+"\n");
                    break;

                case 7:
                    System.out.println("Most Popular Books:");
                    for (Book book : library.getMostPopularBooks()) {
                        System.out.println(book);
                    }
                    break;

                case 8:
                    System.out.println("Exiting the library management system...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}