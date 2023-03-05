package com.example.userservice.rest;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.RequestUser;
import com.example.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserRestController {

    @Value("${greeting.message:defaultMessage}")
    private String greetingMessage;

    private final UserService userService;

    private final Environment env;

    @GetMapping("/health-check")
    public String status() {
        return String.format("It's Working in User Service"
                + ", port(local.server.port) = " + env.getProperty("local.server.port")
                + ", port(server.port) = " + env.getProperty("server.port")
                + ", token secret = " + env.getProperty("token.secret")
                + ", token expiration time = " + env.getProperty("token.expiration_time"));
    }

    @GetMapping("/welcome")
    public String welcome() {
        return this.greetingMessage;
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody RequestUser user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(user, UserDto.class);

        UserDto savedUser = this.userService.createUser(userDto);

        ResponseUser response = modelMapper.map(savedUser, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers() {
        Iterable<UserEntity> userByAll = this.userService.getUserByAll();

        List<ResponseUser> users = new ArrayList<>();
        userByAll.forEach(v -> {
            users.add(new ModelMapper().map(v, ResponseUser.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable String userId) {
        UserDto userByUserId = this.userService.getUserByUserId(userId);

        ResponseUser rv = new ModelMapper().map(userByUserId, ResponseUser.class);

        return ResponseEntity.status(HttpStatus.OK).body(rv);
    }


}
