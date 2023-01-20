package lt.tehcin.myProject.api;

import lt.tehcin.myProject.api.dto.CommentDto;
import lt.tehcin.myProject.api.dto.CommentEntityDto;
import lt.tehcin.myProject.api.dto.mapper.CommentMapper;
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
@RequestMapping("/api/v1/comment")
public class CommentController {

    public Logger logger = LoggerFactory.getLogger(CommentController.class);

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<CommentEntityDto> getComments() {
        return commentService.getAll().stream().map(CommentMapper::toCommentEntityDto).collect(toList());
    }

//    @GetMapping(value = "/{recordId}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Record> getRecord(@PathVariable Long recordId) {
//        var recordOptional = commentRepository.getById(recordId);
//
//        var responseEntity = recordOptional.map(record -> ok(record)).orElseGet(()-> ResponseEntity.notFound().build());
//
//        return responseEntity;
//    }

//    @DeleteMapping("/{recordId}")
//    public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId) {
//        boolean deleted = commentRepository.deleteById(recordId);
//
//        if(deleted) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
        var createdComment = commentService.create(toComment(commentDto));
        return ok(toCommentDto(createdComment));
    }

//    @PutMapping("{recordId}")
//    public ResponseEntity<RecordDto> replaceRecord(@PathVariable Long recordId, @RequestBody RecordDto recordDto) {
//        var updatedRecord = commentRepository.replaceRecord(recordId, toRecord(recordDto));
//        return ok(toRecordDto(updatedRecord));
//    }
//
//    @PatchMapping("{recordId}")
//    public ResponseEntity<RecordDto> updateRecord(@PathVariable Long recordId, @RequestBody RecordDto recordDto) {
//        var updatedRecord = commentRepository.updateRecord(recordId, toRecord(recordDto));
//        return ok(toRecordDto(updatedRecord));
//    }

}
