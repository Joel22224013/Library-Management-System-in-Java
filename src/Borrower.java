
    import java.util.ArrayList;
import java.util.List;

    public class Borrower {
        private String name;
        private final List<Book> borrowedBooks;

        public Borrower(String name) {
            this.name = name;
            this.borrowedBooks = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public List<Book> getBorrowedBooks() {
            return borrowedBooks;
        }

        public void borrowBook(Book book) {
            borrowedBooks.add(book);
        }

        public void returnBook(Book book) {
            borrowedBooks.remove(book);
        }

        @Override
        public String toString() {
            return "Borrower's details {" +
                    " name: " + name  +
                    ", borrowedBooks :" + borrowedBooks +
                    " }";
        }
    }

