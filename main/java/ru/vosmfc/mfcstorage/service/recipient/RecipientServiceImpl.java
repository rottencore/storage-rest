package ru.vosmfc.mfcstorage.service.recipient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.converter.RecipientConverter;
import ru.vosmfc.mfcstorage.domain.Recipient;
import ru.vosmfc.mfcstorage.dto.RecipientDto;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.repository.RecipientRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipientServiceImpl implements RecipientService {

    @Autowired
    private final RecipientRepository recipientRepository;

    @Autowired
    private final RecipientConverter recipientConverter;

    public RecipientServiceImpl(RecipientRepository recipientRepository, RecipientConverter recipientConverter) {
        this.recipientRepository = recipientRepository;
        this.recipientConverter = recipientConverter;
    }


    @Override
    public void saveRecipient(RecipientDto recipientDto) throws ObjectAlreadyExistException {
        try {
            recipientRepository.save(recipientConverter.fromRecipientDtoToRecipient(recipientDto));
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("Recipient with phone number " + recipientDto.getPhoneNumber() + " already exist.");
        }
    }

    @Override
    public void updateRecipient(Long id, RecipientDto recipientDto) throws ObjectAlreadyExistException, ObjectNotFoundException {
        Recipient recipient = recipientRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Recipient with id" + id + " not found."));

        recipient.setLastName(recipient.getLastName());
        recipient.setFirstName(recipientDto.getFirstName());
        recipient.setSurName(recipientDto.getSurName());
        recipient.setPhoneNumber(recipientDto.getPhoneNumber());
        recipient.setDepartment(recipientDto.getDepartment());
        recipient.setPosition(recipientDto.getPosition());

        try {
            recipientRepository.save(recipient);
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("Recipient with phone number " + recipientDto.getPhoneNumber() + " already exist.");
        }
    }

    @Override
    public List<RecipientDto> findAllRecipients() {
        List<RecipientDto> recipientDtoList = new ArrayList<>();
        List<Recipient> recipients = recipientRepository.findAll();

        for (Recipient recipient : recipients) {
            recipientDtoList.add(recipientConverter.fromRecipientTORecipientDto(recipient));
        }

        return recipientDtoList;
    }

}
