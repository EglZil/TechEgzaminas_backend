package lt.tehcin.myProject.api.dto.mapper;

import lt.tehcin.myProject.api.dto.BookDto;
import lt.tehcin.myProject.api.dto.BookEntityDto;
import lt.tehcin.myProject.api.dto.BookStoreDto;
import lt.tehcin.myProject.api.dto.BookStoreEntityDto;
import lt.tehcin.myProject.model.Book;
import lt.tehcin.myProject.model.BookStore;

public class BookStoreMapper {

    public static BookStoreDto toBookStoreDto(BookStore bookStore) {
        var bookStoreDto = new BookStoreDto();

        bookStoreDto.setName(bookStore.getName());

        return bookStoreDto;
    }

    public static BookStoreEntityDto toBookStoreEntityDto(BookStore bookStore) {
        var bookStoreEntityDto = new BookStoreEntityDto();

        bookStoreEntityDto.setId(bookStore.getId());
        bookStoreEntityDto.setName(bookStore.getName());

        return bookStoreEntityDto;
    }

    public static BookStore toBookStore(BookStoreDto bookStoreDto) {
        var bookStore = new BookStore();

        bookStore.setName(bookStoreDto.getName());

        return bookStore;
    }

    public static BookStore toBookStoreFromEntityDto(BookStoreEntityDto bookStoreEntityDto) {
        var bookStore = new BookStore();

        bookStore.setId(bookStoreEntityDto.getId());
        bookStore.setName(bookStoreEntityDto.getName());

        return bookStore;
    }

}
