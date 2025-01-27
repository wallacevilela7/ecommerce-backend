package wvs.ecommerceapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wvs.ecommerceapi.controller.dto.CreateUserDto;
import wvs.ecommerceapi.service.UserService;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDto data) {
        var user = userService.createUser(data);
        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).build();
    }
}
