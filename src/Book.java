public class Book {
    private String title;
    private String author;
    private String genre;
    private boolean available;
    private int borrowCount;

//    constructors to allow easy setting of attributes
    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
        this.borrowCount = 0;
    }

    public String getTitle() {
        return title;}
    public String getAuthor() {
        return author;
    }
    public String getGenre() {
        return genre;
    }

    public boolean isAvailable() {return available;}

    public void borrow() {
        if (available) {
            available = false;
            borrowCount++;
        }}
        public int getBorrowCount() {return borrowCount;
        }
     public void returnBook() {available = true;}

//    toString() converts an object into a human-readable string
    @Override
    public String toString() {
        return "Book's details {" +
                "Title : " + title +
                ", Author : " + author +
                ", Genre : " + genre +
                ", Availability : " + available +
                ", BorrowCount : " + borrowCount +
                '}';
    }
}
