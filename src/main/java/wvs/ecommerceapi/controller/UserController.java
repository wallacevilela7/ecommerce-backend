package wvs.ecommerceapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wvs.ecommerceapi.controller.dto.CreateUserDto;
import wvs.ecommerceapi.entity.UserEntity;
import wvs.ecommerceapi.service.UserService;

import java.net.URI;
import java.util.UUID;

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

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> findUserById(@PathVariable UUID userId) {
        var user = userService.findUserById(userId);
        return user.isPresent() ?
                ResponseEntity.ok(user.get()) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserEntity> deleteUserById(@PathVariable UUID userId) {
        boolean deleted = userService.deleteUserById(userId);
        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

}
