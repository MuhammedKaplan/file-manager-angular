package com.fileExplorer.user.services;


import com.fileExplorer.user.model.User;
import com.fileExplorer.user.model.UserDTO;
import com.fileExplorer.user.model.UserMapperImpl;
import com.fileExplorer.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapperImpl userMapper;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUserForLogin(String id) {

        if (userRepository.findById(id).isPresent()) {

            User loggedInUser = userRepository.findById(id).get();

            return loggedInUser;
        }
        return null;
    }

    public UserDTO addUser(UserDTO userDTO) {
        User result = userRepository.save(userMapper.toEntity(userDTO));
        return userMapper.toDTO(result);
    }
}
