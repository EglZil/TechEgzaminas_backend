package lt.tehcin.myProject.service;

import lt.tehcin.myProject.api.dto.BookDto;
import lt.tehcin.myProject.api.dto.mapper.BookMapper;
import lt.tehcin.myProject.dao.BookRepository;
import lt.tehcin.myProject.dao.BookStoreRepository;
import lt.tehcin.myProject.model.Book;
import lt.tehcin.myProject.model.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;

    //    @Autowired
    public BookService(BookRepository bookRepository,
                       BookStoreRepository bookStoreRepository) {
        this.bookRepository = bookRepository;
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            bookRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book replaceBook(Long id, Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        var existingBook = bookRepository.findById(id).orElseThrow();

        existingBook.setName(book.getName());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setDescription(book.getDescription());
        existingBook.setBookType(book.getBookType());
        existingBook.setBookStore(book.getBookStore());

        return bookRepository.save(existingBook);
    }

    public Book addBookStoreToBook(Long bookId, Long bookStoreId) {
        var existingBook = bookRepository.findById(bookId)
                .orElseThrow();

        var existingBookStore = bookStoreRepository.findById(bookStoreId).orElseThrow();

        existingBook.setBookStore(existingBookStore);

        return bookRepository.save(existingBook);
    }

//    @PostConstruct
//    public void loadInitialBooks() {
//        var initialBooksToLoad = List.of(
//                new BookDto("Sabaliauskaite", "Silva Rerum", "knyga", BookType.ROMANCE, null),
//                new BookDto("Orvel", "Animal Farm", "good book", BookType.FANTASY, null)
//        );
//
//        initialBooksToLoad.stream().map(BookMapper::toBook).forEach(bookRepository::save);
//    }
}
