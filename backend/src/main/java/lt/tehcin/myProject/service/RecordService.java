package lt.tehcin.myProject.service;

import lt.tehcin.myProject.dao.RecordRepository;
import lt.tehcin.myProject.exception.RecordValidationException;
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

    public List<Record> getAllByDate() {
        return recordRepository.findAllByOrderByCreatedDateDesc();
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

    public Record create(Record record) {
        List<Record> records = this.getAll();
        String name = record.getName().toLowerCase();

        for(Record recorded : records) {
            if(recorded.getName().toLowerCase().equals(name)) {
                throw new RecordValidationException();
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


}
