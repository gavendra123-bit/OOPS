    // Custom Exception
    class BookNotAvailableException extends Exception {
        public BookNotAvailableException(String message) {
            super(message);
        }
    }

    // Book Class
    class Book {
        private String title;
        private boolean isIssued;

        public Book(String title) {
            this.title = title;
            this.isIssued = false;
        }

        public void issueBook() throws BookNotAvailableException {
            if (isIssued) {
                throw new BookNotAvailableException("Sorry! Book '" + title + "' is already issued.");
            }
            isIssued = true;
            System.out.println("Book issued: " + title);
        }

        public void returnBook() {
            isIssued = false;
            System.out.println("Book returned: " + title);
        }

        public String getTitle() {
            return title;
        }
    }

    // Main Class
    public class LibrarySystem {
        public static void main(String[] args) {
            Book book1 = new Book("Java Programming");
            Book book2 = new Book("Data Structures");

            try {
                book1.issueBook();  // पहली बार issue होगा
                book1.issueBook();  // दूसरी बार issue करने पर exception

            } catch (BookNotAvailableException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }

            book1.returnBook(); // Book वापस कर दी गई

            try {
                book2.issueBook(); // दूसरी book issue
            } catch (BookNotAvailableException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    }

