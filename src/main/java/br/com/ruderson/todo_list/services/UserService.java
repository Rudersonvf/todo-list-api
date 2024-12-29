package br.com.ruderson.todo_list.services;

import br.com.ruderson.todo_list.config.AuthorizationServerConfig;
import br.com.ruderson.todo_list.config.ResourceServerConfig;
import br.com.ruderson.todo_list.dto.UserDTO;
import br.com.ruderson.todo_list.dto.UserResponseDTO;
import br.com.ruderson.todo_list.entities.Role;
import br.com.ruderson.todo_list.entities.User;
import br.com.ruderson.todo_list.projections.UserDetailsProjection;
import br.com.ruderson.todo_list.repositories.RoleRepository;
import br.com.ruderson.todo_list.repositories.UserRepository;
import br.com.ruderson.todo_list.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsProjection> result = userRepository.searchUserAndRolesByEmail(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        User user = new User();
        user.setEmail(username);
        user.setPassword(result.getFirst().getPassword());
        for (UserDetailsProjection projection : result) {
            user.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }
        return user;
    }

    public UserResponseDTO insert(UserDTO dto) {
        User entity = new User();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));

        Role role = roleRepository.findByAuthority("ROLE_USER");
        if (role == null) {
            throw new ResourceNotFoundException("Role 'ROLE_USER' not found on database.");
        }
        entity.addRole(role);

        entity = userRepository.save(entity);

        return new UserResponseDTO(entity.getId(), entity.getName(), entity.getEmail());
    }

    protected User authenticated() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
            return userRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("Username not found"));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Invalid user");
        }
    }
}