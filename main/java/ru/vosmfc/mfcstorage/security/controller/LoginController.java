package ru.vosmfc.mfcstorage.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vosmfc.mfcstorage.security.domain.User;
import ru.vosmfc.mfcstorage.security.dto.LoginDto;
import ru.vosmfc.mfcstorage.security.jwt.JwtProvider;
import ru.vosmfc.mfcstorage.security.service.user.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final JwtProvider jwtProvider;

    public LoginController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping
    public ResponseEntity<?> login(@Valid @RequestBody LoginDto loginDto) {
        User user = userService.findByUserNameAndPassword(loginDto.getUserName(), loginDto.getPassword());

        if (!user.isActive()) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        String token = jwtProvider.generateToken(user.getUserName());

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                .build();
    }

}
