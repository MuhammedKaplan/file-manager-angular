package com.fileExplorer.user.authentication;


import com.fileExplorer.user.model.User;
import com.fileExplorer.user.model.UserDTO;
import com.fileExplorer.user.model.UserMapperImpl;
import com.fileExplorer.user.services.UserService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class AuthenticationResource {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationResource.class);

    private final UserService userService;

    private final UserMapperImpl userMapperImpl;

    private final AuthenticationService authenticateService;

    @GetMapping()
    public ResponseEntity<UserDTO> login(){

        User user = userService.findByUsername(
                SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getName());

        User loggedInUser = userService.findUserForLogin(user.getId());

        return ResponseEntity.ok(userMapperImpl.toDTO(user));
    }
}
