package lt.tehcin.myProject.api.dto.mapper;

import lt.tehcin.myProject.api.dto.CommentDto;
import lt.tehcin.myProject.api.dto.CommentEntityDto;
import lt.tehcin.myProject.model.Comment;

public class CommentMapper {

    public static CommentDto toCommentDto(Comment comment) {
        var commentDto = new CommentDto();

        commentDto.setAuthor(comment.getAuthor());
        commentDto.setComment(comment.getComment());

        return commentDto;
    }

    public static CommentEntityDto toCommentEntityDto(Comment comment) {
        var commentEntityDto = new CommentEntityDto();

        commentEntityDto.setId(comment.getId());
        commentEntityDto.setAuthor(comment.getAuthor());
        commentEntityDto.setComment(comment.getComment());

        return commentEntityDto;
    }

    public static Comment toComment(CommentDto commentDto) {
        var comment = new Comment();

        comment.setAuthor(commentDto.getAuthor());
        comment.setComment(commentDto.getComment());

        return comment;
    }

    public static Comment toCommentFromEntityDto(CommentEntityDto commentEntityDto) {
        var comment = new Comment();

        comment.setId(commentEntityDto.getId());
        comment.setAuthor(commentEntityDto.getAuthor());
        comment.setComment(commentEntityDto.getComment());

        return comment;
    }
}
