package lt.tehcin.myProject.api.dto;

import java.util.Objects;

public class BookStoreEntityDto extends BookStoreDto{

    private Long id;

    public BookStoreEntityDto() {
    }

    public BookStoreEntityDto(String name, Long id) {
        super(name);
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
        BookStoreEntityDto that = (BookStoreEntityDto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
