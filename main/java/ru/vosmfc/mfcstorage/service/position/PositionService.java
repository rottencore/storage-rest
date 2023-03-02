package ru.vosmfc.mfcstorage.service.position;

import ru.vosmfc.mfcstorage.dto.PositionDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;

import java.util.List;

public interface PositionService {

    void savePosition(PositionDto positionDto) throws ObjectAlreadyExistException;

    List<PositionDto> findAllPositions();

}
