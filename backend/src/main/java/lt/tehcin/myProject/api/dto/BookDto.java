package lt.tehcin.myProject.api.dto;

import lt.tehcin.myProject.model.BookStore;
import lt.tehcin.myProject.model.BookType;

import java.util.Objects;

public class BookDto {

    private String author;

    private String name;

    private String description;

    private BookType bookType;

    private BookStore bookStore;

    public BookDto() {
    }

    public BookDto(String author, String name, String description, BookType bookType, BookStore bookStore) {
        this.author = author;
        this.name = name;
        this.description = description;
        this.bookType = bookType;
        this.bookStore = bookStore;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public BookStore getBookStore() {
        return bookStore;
    }

    public void setBookStore(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(author, bookDto.author) && Objects.equals(name, bookDto.name) && Objects.equals(description, bookDto.description) && bookType == bookDto.bookType && Objects.equals(bookStore, bookDto.bookStore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, name, description, bookType, bookStore);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", bookType=" + bookType +
                ", bookStore=" + bookStore +
                '}';
    }
}
