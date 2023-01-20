package lt.tehcin.myProject.api.dto;

import lt.tehcin.myProject.model.Record;

import java.util.Objects;

public class CommentDto {

    private String author;

    private String comment;

    private Record record;

    public CommentDto() {
    }

    public CommentDto(String author, String comment, Record record) {
        this.author = author;
        this.comment = comment;
        this.record = record;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDto that = (CommentDto) o;
        return Objects.equals(author, that.author) && Objects.equals(comment, that.comment) && Objects.equals(record, that.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, comment, record);
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                ", record=" + record +
                '}';
    }
}
