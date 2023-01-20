package lt.tehcin.myProject.api;

import lt.tehcin.myProject.api.dto.RecordDto;
import lt.tehcin.myProject.api.dto.RecordEntityDto;
import lt.tehcin.myProject.api.dto.mapper.RecordMapper;
import lt.tehcin.myProject.model.Record;
import lt.tehcin.myProject.service.RecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.tehcin.myProject.api.dto.mapper.RecordMapper.toRecord;
import static lt.tehcin.myProject.api.dto.mapper.RecordMapper.toRecordDto;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@Validated
@RequestMapping("/api/v1/records")
public class RecordController {

    public Logger logger = LoggerFactory.getLogger(RecordController.class);

    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RecordEntityDto> getRecords() {
        return recordService.getAllByDate().stream().map(RecordMapper::toRecordEntityDto).collect(toList());

    }

    @GetMapping(value = "/{recordId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Record> getRecord(@PathVariable Long recordId) {
        var recordOptional = recordService.getById(recordId);

        var responseEntity = recordOptional.map(record -> ok(record)).orElseGet(()-> ResponseEntity.notFound().build());

        return responseEntity;
    }

    @DeleteMapping("/{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId) {
        boolean deleted = recordService.deleteById(recordId);

        if(deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RecordDto> createRecord(@Valid @RequestBody RecordDto recordDto) {
        var createdRecord = recordService.create(toRecord(recordDto));

        return ok(toRecordDto(createdRecord));
    }

    @PutMapping("{recordId}")
    public ResponseEntity<RecordDto> replaceRecord(@PathVariable Long recordId, @RequestBody RecordDto recordDto) {
        var updatedRecord = recordService.replaceRecord(recordId, toRecord(recordDto));
        return ok(toRecordDto(updatedRecord));
    }

    @PatchMapping("{recordId}")
    public ResponseEntity<RecordDto> updateRecord(@PathVariable Long recordId, @RequestBody RecordDto recordDto) {
        var updatedRecord = recordService.updateRecord(recordId, toRecord(recordDto));
        return ok(toRecordDto(updatedRecord));
    }

}
