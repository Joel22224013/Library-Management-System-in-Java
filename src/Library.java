import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Library {
    private int NumberofBooks=0;
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();

    }

    public void addBook(Book book) {
        books.add(book);
        NumberofBooks++;
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);

        }
        System.out.println("The number of books in the library are: "+ NumberofBooks);

    }

    public List<Book> searchBooks(String query) {

//        declaring a variable named results that will store the list of books that match the query
        List<Book> results = new ArrayList<>();

//        iterates through the book and gets results based on conditions.
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase()) ||
                    book.getGenre().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    public boolean borrowBook(Borrower borrower, Book book) {
        if (book.isAvailable()) {
            book.borrow();
            borrower.borrowBook(book);
            return true;
        }
        return false;
    }

    public void returnBook(Borrower borrower, Book book) {
        book.returnBook();
        borrower.returnBook(book);
    }

    public List<Book> getMostPopularBooks() {
        //creates a copy of the book list without the original one being modified while sorting.
        List<Book> sortedBooks = new ArrayList<>(books);
        Collections.sort(sortedBooks, Comparator.comparingInt(Book::getBorrowCount).reversed());
        return sortedBooks.subList(0, Math.min(5, sortedBooks.size()));
    }
}


//Converts all of the characters in this String to lower case using the rules of the default locale.
// This method is equivalent to toLowerCase(Locale. getDefault())

//Collections.sort(sortedBooks, ... ): This sorts the sortedBooks list according to the comparator provided.
//Comparator.comparingInt(Book::getBorrowCount).reversed()); This compares the list of books based on their borrowcount in ascending order by default
//reversed () coverts it to descending order
