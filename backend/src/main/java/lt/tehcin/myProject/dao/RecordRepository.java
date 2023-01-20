package lt.tehcin.myProject.dao;

import lt.tehcin.myProject.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {

//    @Query(value="SELECT r FROM Record r ORDER BY r.dateCreated desc")
    List<Record> findAllByOrderByCreatedDateDesc();

}
