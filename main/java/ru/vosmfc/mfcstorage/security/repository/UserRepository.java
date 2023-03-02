package ru.vosmfc.mfcstorage.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vosmfc.mfcstorage.security.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUserName(String userName);

}
