package lt.tehcin.myProject.service;

import lt.tehcin.myProject.dao.CommentRepository;
import lt.tehcin.myProject.dao.RecordRepository;
import lt.tehcin.myProject.model.Comment;
import lt.tehcin.myProject.model.Record;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final RecordRepository recordRepository;

    //    @Autowired
    public CommentService(CommentRepository commentRepository,
                          RecordRepository recordRepository) {
        this.commentRepository = commentRepository;
        this.recordRepository = recordRepository;
    }

    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getById(Long id) {
        return commentRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            commentRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment replaceComment(Long id, Comment comment) {
        comment.setId(id);
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment comment) {
        var existingComment = commentRepository.findById(id).orElseThrow();

        existingComment.setAuthor(comment.getAuthor());
        existingComment.setComment(comment.getComment());

        return commentRepository.save(existingComment);
    }

    public Comment addRecordToComment(Long commentId, Long recordId) {
        var existingComment = commentRepository.findById(commentId)
                .orElseThrow();

        var existingRecord = recordRepository.findById(recordId).orElseThrow();

        existingComment.setRecord(existingRecord);

        return commentRepository.save(existingComment);
    }

//    @PostConstruct
//    public void loadInitialBooks() {
//        var initialBooksToLoad = List.of(
//                new BookDto("Sabaliauskaite", "Silva Rerum", "knyga", BookType.ROMANCE, null),
//                new BookDto("Orvel", "Animal Farm", "good book", BookType.FANTASY, null)
//        );
//
//        initialBooksToLoad.stream().map(BookMapper::toBook).forEach(bookRepository::save);
//    }
}
