package lt.tehcin.myProject.service;

import lt.tehcin.myProject.api.dto.BookStoreDto;
import lt.tehcin.myProject.api.dto.mapper.BookStoreMapper;
import lt.tehcin.myProject.dao.BookStoreRepository;
import lt.tehcin.myProject.model.Book;
import lt.tehcin.myProject.model.BookStore;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    //    @Autowired
    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    public List<BookStore> getAll() {
        return bookStoreRepository.findAll();
    }

    public Optional<BookStore> getById(Long id) {
        return bookStoreRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            bookStoreRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public BookStore create(BookStore bookStore) {
        return bookStoreRepository.save(bookStore);
    }

    public BookStore replaceBookStore(Long id, BookStore bookStore) {
        bookStore.setId(id);
        return bookStoreRepository.save(bookStore);
    }

    public BookStore updateBook(Long id, Book book) {
        var existingBookStore = bookStoreRepository.findById(id).orElseThrow();

        existingBookStore.setName(book.getName());

        return bookStoreRepository.save(existingBookStore);
    }

    @PostConstruct
    public void loadInitialBooks() {
        var initialBookStoreToLoad = List.of(
                new BookStoreDto("Pegasas"),
                new BookStoreDto("Knygos.lt")
        );

        initialBookStoreToLoad.stream().map(BookStoreMapper::toBookStore).forEach(bookStoreRepository::save);
    }
}
