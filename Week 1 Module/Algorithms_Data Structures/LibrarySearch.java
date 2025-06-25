import java.util.Arrays;

class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }
}

public class LibrarySearch {
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books)
            if (b.title.equalsIgnoreCase(title)) return b;
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "C Programming", "Dennis Ritchie"),
            new Book(2, "Java Fundamentals", "James Gosling"),
            new Book(3, "Python Basics", "Guido van Rossum"),
            new Book(4, "Data Structures", "Mark Allen Weiss")
        };

        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));

        String searchTitle = "Python Basics";

        Book result1 = linearSearch(books, searchTitle);
        if (result1 != null)
            System.out.println("Linear: " + result1.bookId + " " + result1.title + " " + result1.author);
        else
            System.out.println("Linear: Not found");

        Book result2 = binarySearch(books, searchTitle);
        if (result2 != null)
            System.out.println("Binary: " + result2.bookId + " " + result2.title + " " + result2.author);
        else
            System.out.println("Binary: Not found");
    }
}
