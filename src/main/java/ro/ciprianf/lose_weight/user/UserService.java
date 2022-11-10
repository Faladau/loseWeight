package ro.ciprianf.lose_weight.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository,
                       ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserDto createUser(UserDto userDto) {
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found"));
    }
}
