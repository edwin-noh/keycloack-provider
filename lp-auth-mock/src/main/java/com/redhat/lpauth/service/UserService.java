package com.redhat.lpauth.service;

import com.redhat.lpauth.dto.AuthDTO;
import com.redhat.lpauth.model.User;
import com.redhat.lpauth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserById(long id) throws AuthenticationException {
        Optional<User> result = userRepository.findById(id);
        User user = result.get();
        return new AuthDTO(user);
    }

}
