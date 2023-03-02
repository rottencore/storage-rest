package ru.vosmfc.mfcstorage.security.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.vosmfc.mfcstorage.security.domain.User;
import ru.vosmfc.mfcstorage.security.dto.UserDto;

@Component
public class UserConverter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserConverter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public User fromUserDtoToUser(UserDto userDto) {
        if (userDto.getSurName() != null) {
            return new User(
                    userDto.getUserName(),
                    passwordEncoder.encode(userDto.getPassword()),
                    userDto.getFirstName(),
                    userDto.getSurName(),
                    userDto.getLastName(),
                    userDto.getEmail(),
                    userDto.isActive(),
                    userDto.getUserRole()
            );
        }

        return new User(
                userDto.getUserName(),
                passwordEncoder.encode(userDto.getPassword()),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.isActive(),
                userDto.getUserRole()
        );
    }

    public UserDto fromUserToUserDto(User user) {
        if (user.getUserName() != null) {
            return new UserDto(
                    user.getId(),
                    user.getUserName(),
                    user.getPassword(),
                    user.getFirstName(),
                    user.getSurName(),
                    user.getLastName(),
                    user.getEmail(),
                    user.isActive(),
                    user.getUserRole()
            );
        }

        return new UserDto(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.isActive(),
                user.getUserRole()
        );
    }

}
