package lt.tehcin.myProject.api.dto.mapper;

import lt.tehcin.myProject.api.dto.BookDto;
import lt.tehcin.myProject.api.dto.BookEntityDto;
import lt.tehcin.myProject.model.Book;

public class BookMapper {

    public static BookDto toBookDto(Book book) {
        var bookDto = new BookDto();

        bookDto.setAuthor(book.getAuthor());
        bookDto.setName(book.getName());
        bookDto.setDescription(book.getDescription());
        bookDto.setBookType(book.getBookType());
        bookDto.setBookStore(book.getBookStore());

        return bookDto;
    }

    public static BookEntityDto toBookEntityDto(Book book) {
        var bookEntityDto = new BookEntityDto();

        bookEntityDto.setId(book.getId());
        bookEntityDto.setAuthor(book.getAuthor());
        bookEntityDto.setName(book.getName());
        bookEntityDto.setDescription(book.getDescription());
        bookEntityDto.setBookType(book.getBookType());
        bookEntityDto.setBookStore(book.getBookStore());

        return bookEntityDto;
    }

    public static Book toBook(BookDto bookDto) {
        var book = new Book();

        book.setAuthor(bookDto.getAuthor());
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setBookType(bookDto.getBookType());
        book.setBookStore(bookDto.getBookStore());

        return book;
    }

    public static Book toBookFromEntityDto(BookEntityDto bookEntityDto) {
        var book = new Book();

        book.setId(bookEntityDto.getId());
        book.setAuthor(bookEntityDto.getAuthor());
        book.setName(bookEntityDto.getName());
        book.setDescription(bookEntityDto.getDescription());
        book.setBookType(bookEntityDto.getBookType());
        book.setBookStore(bookEntityDto.getBookStore());

        return book;
    }

}
