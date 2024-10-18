
package com.dswii.proyecto.User;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponse updateUser(UserRequest userRequest) {

        if (userRequest.getId() == null) {
            throw new IllegalArgumentException("El ID del usuario es requerido.");
        }
        User user = User.builder()
                .id(userRequest.id)
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.lastname)
                .phone(userRequest.getPhone())
                .role(Role.USER)
                .build();

        userRepository.updateUser(user.id, user.firstname, user.lastname, user.phone);
        return new UserResponse("El usuario se registró satisfactoriamente");
    }

    public UserDTO getUser(Integer id) {
        User user= userRepository.findById(id).orElse(null);

        if (user!=null)
        {
            UserDTO userDTO = UserDTO.builder()
                    .id(user.id)
                    .username(user.username)
                    .firstname(user.firstname)
                    .lastname(user.lastname)
                    .phone(user.phone)
                    .build();
            return userDTO;
        }
        return null;
    }
}
