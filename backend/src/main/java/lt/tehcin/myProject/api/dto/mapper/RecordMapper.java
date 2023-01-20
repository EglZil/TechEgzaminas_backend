package lt.tehcin.myProject.api.dto.mapper;

import lt.tehcin.myProject.api.dto.RecordDto;
import lt.tehcin.myProject.api.dto.RecordEntityDto;
import lt.tehcin.myProject.model.Record;

public class RecordMapper {

        public static RecordDto toRecordDto(Record record) {
            var recordDto = new RecordDto();

            recordDto.setName(record.getName());
            recordDto.setDescription(record.getDescription());

            return recordDto;
        }

        public static RecordEntityDto toRecordEntityDto(Record record) {
            var recordEntityDto = new RecordEntityDto();

            recordEntityDto.setId(record.getId());
            recordEntityDto.setName(record.getName());
            recordEntityDto.setDescription(record.getDescription());

            return recordEntityDto;
        }

        public static Record toRecord(RecordDto recordDto) {
            var record = new Record();

            record.setName(recordDto.getName());
            record.setDescription(recordDto.getDescription());

            return record;
        }

        public static Record toRecordFromEntityDto(RecordEntityDto bookEntityDto) {
            var record = new Record();

            record.setId(bookEntityDto.getId());
            record.setName(bookEntityDto.getName());
            record.setDescription(bookEntityDto.getDescription());

            return record;
        }

}
