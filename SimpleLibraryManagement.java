import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookID;
    String title;
    String author;
    boolean isAvailable;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public void displayBookInfo() {
        System.out.println("Book ID: " + bookID + ", Title: " + title + ", Author: " + author + 
                           ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            book.displayBookInfo();
        }
    }

    public void borrowBook(int bookID) {
        for (Book book : books) {
            if (book.bookID == bookID) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("You borrowed: " + book.title);
                    return;
                } else {
                    System.out.println("Book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book ID not found.");
    }

    public void returnBook(int bookID) {
        for (Book book : books) {
            if (book.bookID == bookID) {
                if (!book.isAvailable) {
                    book.isAvailable = true;
                    System.out.println("You returned: " + book.title);
                    return;
                } else {
                    System.out.println("This book was not borrowed.");
                    return;
                }
            }
        }
        System.out.println("Book ID not found.");
    }
}

public class SimpleLibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Add sample books
        library.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to borrow: ");
                    int borrowID = scanner.nextInt();
                    library.borrowBook(borrowID);
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    int returnID = scanner.nextInt();
                    library.returnBook(returnID);
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
