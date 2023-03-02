package ru.vosmfc.mfcstorage.service.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.PositionConverter;
import ru.vosmfc.mfcstorage.domain.Position;
import ru.vosmfc.mfcstorage.dto.PositionDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.repository.PositionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private final PositionRepository positionRepository;

    @Autowired
    private final PositionConverter positionConverter;

    public PositionServiceImpl(PositionRepository positionRepository, PositionConverter positionConverter) {
        this.positionRepository = positionRepository;
        this.positionConverter = positionConverter;
    }


    @Override
    public void savePosition(PositionDto positionDto) throws ObjectAlreadyExistException {
        try {
            positionRepository.save(positionConverter.fromPositionDtoToPosition(positionDto));
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("Position with position name " + positionDto.getPositionName() + " already exist.");
        }
    }

    @Override
    public List<PositionDto> findAllPositions() {
        List<PositionDto> positionDtoList = new ArrayList<>();
        List<Position> positions = positionRepository.findAll();

        for (Position position : positions) {
            positionDtoList.add(positionConverter.fromPositionToPositionDto(position));
        }

        return positionDtoList;
    }

}
