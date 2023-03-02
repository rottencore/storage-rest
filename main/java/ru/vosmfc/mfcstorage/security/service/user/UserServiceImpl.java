package ru.vosmfc.mfcstorage.security.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.vosmfc.mfcstorage.exception.ObjectAlreadyExistException;
import ru.vosmfc.mfcstorage.exception.ObjectNotFoundException;
import ru.vosmfc.mfcstorage.security.converter.UserConverter;
import ru.vosmfc.mfcstorage.security.domain.User;
import ru.vosmfc.mfcstorage.security.dto.UserDto;
import ru.vosmfc.mfcstorage.security.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserConverter userConverter;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) throws ObjectAlreadyExistException {
        try {
            userRepository.save(userConverter.fromUserDtoToUser(userDto));
        }
        catch (Exception exception) {
            throw new ObjectAlreadyExistException("User with username " + userDto.getUserName() + " already exist");
        }
    }

    @Override
    public void updateUser(Long id, UserDto userDto) throws ObjectNotFoundException, ObjectAlreadyExistException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id" + id + " not found."));

        user.setFirstName(userDto.getFirstName());
        user.setSurName(userDto.getSurName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserRole(userDto.getUserRole());
        user.setActive(userDto.isActive());
        user.setEmail(userDto.getEmail());

        try {
            userRepository.save(user);
        } catch (Exception exception) {
            throw new ObjectAlreadyExistException("User with email " + userDto.getEmail() + " already exist.");
        }
    }

    @Override
    public void lockUser(Long id) throws ObjectNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found."));

        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public UserDto findUserById(Long id) throws ObjectNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("User with id " + id + " not found."));

        return userConverter.fromUserToUserDto(user);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findUserByUserName(userName);
    }

    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        User user = findByUserName(userName);

        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> users = userRepository.findAll();

        for (User user : users) {
            userDtoList.add(userConverter.fromUserToUserDto(user));
        }

        return userDtoList;
    }
}
