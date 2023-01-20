package lt.tehcin.myProject.api.dto;

import java.util.Objects;

public class RecordDto {

    private String name;

    private String description;

    public RecordDto() {
    }

    public RecordDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordDto recordDto = (RecordDto) o;
        return Objects.equals(name, recordDto.name) && Objects.equals(description, recordDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return "RecordDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
