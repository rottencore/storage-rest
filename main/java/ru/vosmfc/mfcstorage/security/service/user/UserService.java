package ru.vosmfc.mfcstorage.security.service.user;

import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.security.domain.User;
import ru.vosmfc.mfcstorage.security.dto.UserDto;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto) throws ObjectAlreadyExistException;

    void updateUser(Long id, UserDto userDto) throws ObjectNotFoundException, ObjectAlreadyExistException;

    void lockUser(Long id) throws ObjectNotFoundException;

    UserDto findUserById(Long id) throws ObjectNotFoundException;

    User findByUserName(String userName);

    User findByUserNameAndPassword(String userName, String password);

    List<UserDto> findAllUsers();

}
