package lt.tehcin.myProject.dao;

import lt.tehcin.myProject.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findCommentsByRecordId(Long recordId);
}
