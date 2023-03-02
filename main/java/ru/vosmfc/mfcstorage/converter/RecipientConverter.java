package ru.vosmfc.mfcstorage.converter;

import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.domain.Recipient;
import ru.vosmfc.mfcstorage.dto.RecipientDto;

@Component
public class RecipientConverter {

    public Recipient fromRecipientDtoToRecipient(RecipientDto recipientDto) {
        if (recipientDto.getSurName() != null) {
            return new Recipient(
                    recipientDto.getLastName(),
                    recipientDto.getFirstName(),
                    recipientDto.getSurName(),
                    recipientDto.getPhoneNumber(),
                    recipientDto.getDepartment(),
                    recipientDto.getPosition()
            );
        }

        return new Recipient(
                recipientDto.getLastName(),
                recipientDto.getFirstName(),
                recipientDto.getPhoneNumber(),
                recipientDto.getDepartment(),
                recipientDto.getPosition()
        );
    }

    public RecipientDto fromRecipientTORecipientDto(Recipient recipient) {
        if (recipient.getSurName() != null) {
            return new RecipientDto(
                    recipient.getId(),
                    recipient.getLastName(),
                    recipient.getFirstName(),
                    recipient.getSurName(),
                    recipient.getPhoneNumber(),
                    recipient.getDepartment(),
                    recipient.getPosition()
            );
        }

        return new RecipientDto(
                recipient.getId(),
                recipient.getLastName(),
                recipient.getFirstName(),
                recipient.getPhoneNumber(),
                recipient.getDepartment(),
                recipient.getPosition()
        );
    }

}
