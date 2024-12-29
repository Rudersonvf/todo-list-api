package br.com.ruderson.todo_list.controllers;

import br.com.ruderson.todo_list.dto.UserDTO;
import br.com.ruderson.todo_list.dto.UserResponseDTO;
import br.com.ruderson.todo_list.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserDTO request){
        UserResponseDTO response = userService.insert(request);
        return ResponseEntity
                .created(URI.create("/users/" + response.id()))
                .body(response);
    }
}
