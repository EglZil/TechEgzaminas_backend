package lt.tehcin.myProject.api;

import lt.tehcin.myProject.api.dto.BookStoreEntityDto;
import lt.tehcin.myProject.api.dto.mapper.BookStoreMapper;
import lt.tehcin.myProject.model.BookStore;
import lt.tehcin.myProject.service.BookStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/bookStores")
public class BookStoreController {

    public Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookStoreService bookStoreService;

    public BookStoreController(BookStoreService bookStoreService) {
        this.bookStoreService = bookStoreService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<BookStoreEntityDto> getBookStores() {
        return bookStoreService.getAll().stream().map(BookStoreMapper::toBookStoreEntityDto).collect(toList());
    }

    @GetMapping(value = "/{bookStoreId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BookStore> getBook(@PathVariable Long bookStoreId) {
        var bookStoreOptional = bookStoreService.getById(bookStoreId);

        var responseEntity = bookStoreOptional.map(bookStore -> ok(bookStore)).orElseGet(() -> ResponseEntity.notFound().build());

        return responseEntity;
    }
}
