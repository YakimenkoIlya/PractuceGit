package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Book> books;

    public Catalog() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public class Book {
        private String title;
        private String author;
        private BookHistory history;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.history = new BookHistory();
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public BookHistory getHistory() {
            return history;
        }
    }

    public class BookHistory {
        private List<HistoryEntry> historyEntries;

        public BookHistory() {
            this.historyEntries = new ArrayList<>();
        }

        public void addHistoryEntry(String readerName, LocalDate dateTaken, LocalDate dateReturned) {
            historyEntries.add(new HistoryEntry(readerName, dateTaken, dateReturned));
        }

        public List<HistoryEntry> getHistoryEntries() {
            return historyEntries;
        }
    }

    public class HistoryEntry {
        private String readerName;
        private LocalDate dateTaken;
        private LocalDate dateReturned;

        public HistoryEntry(String readerName, LocalDate dateTaken, LocalDate dateReturned) {
            this.readerName = readerName;
            this.dateTaken = dateTaken;
            this.dateReturned = dateReturned;
        }

        public String getReaderName() {
            return readerName;
        }

        public LocalDate getDateTaken() {
            return dateTaken;
        }

        public LocalDate getDateReturned() {
            return dateReturned;
        }
    }

    public static void exercise() {
        Catalog catalog = new Catalog();
        Catalog.Book book = catalog.new Book("Book Title", "Author Name");
        Catalog.BookHistory history = book.getHistory();
        history.addHistoryEntry("Reader", LocalDate.of(2023, 10, 1), LocalDate.of(2023, 10, 15));
        history.addHistoryEntry("Reader1", LocalDate.of(2023, 11, 3), null);
        history.addHistoryEntry("Reader2", LocalDate.of(2022, 8, 9), LocalDate.of(2022, 10, 20));
        history.addHistoryEntry("Reader3", LocalDate.of(2021, 1, 10), LocalDate.of(2021, 5, 5));
        history.addHistoryEntry("Reader4", LocalDate.of(2020, 3, 28), null);

        List<Catalog.HistoryEntry> entries = history.getHistoryEntries();
        for (Catalog.HistoryEntry entry : entries) {
            System.out.println("Читатель: " + entry.getReaderName() + ", Дата взятия: " + entry.getDateTaken() +
                    ", Дата возвращения: " + entry.getDateReturned());
        }
    }
}

