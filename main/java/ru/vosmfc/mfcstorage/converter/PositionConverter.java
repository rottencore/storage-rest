package ru.vosmfc.mfcstorage.converter;

import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.domain.Position;
import ru.vosmfc.mfcstorage.dto.PositionDto;

@Component
public class PositionConverter {

    public Position fromPositionDtoToPosition(PositionDto positionDto) {
        return new Position(positionDto.getPositionName());
    }

    public PositionDto fromPositionToPositionDto(Position position) {
        return new PositionDto(position.getId(), position.getPositionName());
    }

}
