package pl.example.equipy.components.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class UserService {
    
	@Autowired
    private UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDto);
    }


    List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
    
    List<UserDto> findByLastName(String lastName) {
        return userRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
    
    UserDto save(UserDto user) {
        Optional<User> userByPesel = userRepository.findByPesel(user.getPesel());
        userByPesel.ifPresent(u -> {
            throw new DuplicatePeselException();
        });
        return mapAndSaveUser(user);
    }

    UserDto update(UserDto user) {
        Optional<User> userByPesel = userRepository.findByPesel(user.getPesel());
        userByPesel.ifPresent(u -> {
            if(!u.getId().equals(user.getId()))
                throw new DuplicatePeselException();
        });
        return mapAndSaveUser(user);
    }

    private UserDto mapAndSaveUser(UserDto user) {
        User userEntity = UserMapper.toEntity(user);
        User savedUser = userRepository.save(userEntity);
        return UserMapper.toDto(savedUser);
    }
    
    List<UserAssignmentDto> getUserAssignments(Long userId) {
        return userRepository.findById(userId)
                .map(User::getAssignments)
                .orElseThrow(UserNotFoundException::new)
                .stream()
                .map(UserAssignmentMapper::toDto)
                .collect(Collectors.toList());
    }
    
}