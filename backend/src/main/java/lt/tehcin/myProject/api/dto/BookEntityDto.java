package lt.tehcin.myProject.api.dto;

import lt.tehcin.myProject.model.BookStore;
import lt.tehcin.myProject.model.BookType;

import java.util.Objects;

public class BookEntityDto extends BookDto {

    private Long id;

    public BookEntityDto() {
    }

    public BookEntityDto(String author, String name, String description, Long id, BookType bookType, BookStore bookStore) {
        super(author, name, description, bookType, bookStore);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookEntityDto that = (BookEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "BookEntityDto{" +
                "id=" + id +
                '}';
    }
}
