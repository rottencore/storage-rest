package ru.vosmfc.mfcstorage.service.recipient;

import ru.vosmfc.mfcstorage.dto.RecipientDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;

import java.util.List;

public interface RecipientService {

    void saveRecipient(RecipientDto recipientDto) throws ObjectAlreadyExistException;

    void updateRecipient(Long id, RecipientDto recipientDto) throws ObjectAlreadyExistException, ObjectNotFoundException;

    List<RecipientDto> findAllRecipients();

}
