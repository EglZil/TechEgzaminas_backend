package lt.tehcin.myProject.api;

import lt.tehcin.myProject.api.dto.CommentDto;
import lt.tehcin.myProject.api.dto.CommentEntityDto;
import lt.tehcin.myProject.api.dto.mapper.CommentMapper;
import lt.tehcin.myProject.model.Comment;
import lt.tehcin.myProject.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.tehcin.myProject.api.dto.mapper.CommentMapper.toComment;
import static lt.tehcin.myProject.api.dto.mapper.CommentMapper.toCommentDto;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/records/")
public class CommentController {

    public Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(value="comments", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CommentEntityDto> getComments() {
        return commentService.getAll().stream().map(CommentMapper::toCommentEntityDto).collect(toList());
    }

    @GetMapping(value = "comment/{commentId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Comment> getComment(@PathVariable Long commentId) {
        var commentOptional = commentService.getById(commentId);

        var responseEntity = commentOptional.map(comment -> ok(comment)).orElseGet(()-> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @PostMapping(value="comments", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
        var createdComment = commentService.create(toComment(commentDto));
        return ok(toCommentDto(createdComment));
    }

    @GetMapping(value="comments/{recordId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CommentEntityDto> getCommentsByRecordId(@PathVariable Long recordId) {
        return commentService.getAllByRecordId(recordId).stream().map(CommentMapper::toCommentEntityDto).collect(toList());
    }

    @DeleteMapping(value="comment/{commentId}")
    public ResponseEntity<Boolean> deleteComment(@PathVariable Long commentId) {
        var isDeleted = commentService.deleteById(commentId);
        return ok(isDeleted);
    }

}
