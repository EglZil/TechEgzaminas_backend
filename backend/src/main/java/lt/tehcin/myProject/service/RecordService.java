package lt.tehcin.myProject.service;

import lt.tehcin.myProject.dao.RecordRepository;
import lt.tehcin.myProject.model.Record;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class RecordService {

    private final RecordRepository recordRepository;

    //    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> getAll() {
        return recordRepository.findAll();
    }

    public Optional<Record> getById(Long id) {
        return recordRepository.findById(id);
    }

    public boolean deleteById(Long id) {
        try {
            recordRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException exception) {
            return false;
        }
    }

    //    public Record create(Record record) {
//            return recordRepository.save(record);
//    }

    public Record create(Record record) {
        List<Record> records = this.getAll();
        String name = record.getName().toLowerCase();
        boolean exists = false;
//        Record exists = records.stream().filter(r -> r.getName().toLowerCase().equals(name)).findFirst().orElseThrow();

        for(Record recorded : records) {
            if(recorded.getName().toLowerCase().equals(name)) {
                throw new IllegalArgumentException();
            }
        }
        return recordRepository.save(record);
    }

    public Record replaceRecord(Long id, Record record) {
        record.setId(id);
        return recordRepository.save(record);
    }

    public Record updateRecord(Long id, Record record) {
        var existingRecord = recordRepository.findById(id).orElseThrow();

        existingRecord.setName(record.getName());
        existingRecord.setDescription(record.getDescription());

        return recordRepository.save(existingRecord);
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
