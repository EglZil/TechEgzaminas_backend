package lt.tehcin.myProject.api.dto;

import java.util.Objects;

public class RecordEntityDto extends RecordDto {

    private Long id;

    public RecordEntityDto() {
    }

    public RecordEntityDto(String name, String description, Long id) {
        super(name, description);
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
        RecordEntityDto that = (RecordEntityDto) o;
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
