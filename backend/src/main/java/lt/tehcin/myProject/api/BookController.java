package lt.tehcin.myProject.api;

import lt.tehcin.myProject.api.dto.BookDto;
import lt.tehcin.myProject.api.dto.BookEntityDto;
import lt.tehcin.myProject.api.dto.mapper.BookMapper;
import lt.tehcin.myProject.model.Book;
import lt.tehcin.myProject.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.tehcin.myProject.api.dto.mapper.BookMapper.toBook;
import static lt.tehcin.myProject.api.dto.mapper.BookMapper.toBookDto;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    public Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<BookEntityDto> getBooks() {
        return bookService.getAll().stream().map(BookMapper::toBookEntityDto).collect(toList());
    }

    @GetMapping(value = "/{bookId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Book> getBook(@PathVariable Long bookId) {
        var bookOptional = bookService.getById(bookId);

        var responseEntity = bookOptional.map(book -> ok(book)).orElseGet(()-> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        boolean deleted = bookService.deleteById(bookId);

        if(deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        var createdBook = bookService.create(toBook(bookDto));
        return ok(toBookDto(createdBook));
    }

    @PutMapping("{bookId}")
    public ResponseEntity<BookDto> replaceBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        var updatedBook = bookService.replaceBook(bookId, toBook(bookDto));
        return ok(toBookDto(updatedBook));
    }

    @PatchMapping("{bookId}")
    public ResponseEntity<BookDto> updateBook(@PathVariable Long bookId, @RequestBody BookDto bookDto) {
        var updatedBook = bookService.updateBook(bookId, toBook(bookDto));
        return ok(toBookDto(updatedBook));
    }

    @PostMapping("/{bookId}/addBookStore")
    @ResponseBody
    public Book addBookToBookStore(@PathVariable Long bookId, @RequestParam Long bookStoreId) {
        return bookService.addBookStoreToBook(bookId, bookStoreId);
    }

}
