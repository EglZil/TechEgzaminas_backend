package lt.tehcin.myProject.api.dto;

import java.util.Objects;

public class BookStoreDto {

    private String name;

    public BookStoreDto() {
    }

    public BookStoreDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookStoreDto that = (BookStoreDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "BookStoreDto{" +
                ", name='" + name + '\'' +
                '}';
    }
}
