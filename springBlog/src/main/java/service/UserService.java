package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import model.Role;
import model.User;
import repository.RoleRepository;
import repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
	
	@Autowired
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    
    public UserService(
        UserRepository userRepository,
        RoleRepository roleRepository,
        BCryptPasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user, Set<String> roleNames) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set user roles
        Set<Role> roles = new HashSet<>();
        for (String roleName : roleNames) {
            Role role = roleRepository.findByName(roleName);
            if (role != null) {
                roles.add(role);
            }
        }
        user.setRoles(roles);

        return userRepository.save(user);
    }

    // Add more user-related service methods (e.g., getUserById, getUserByUsername, etc.)
}
