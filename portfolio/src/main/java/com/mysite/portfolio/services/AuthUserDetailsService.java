package com.mysite.portfolio.services;

import com.mysite.portfolio.models.AuthorizedUser;
import com.mysite.portfolio.repositories.AuthUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private final AuthUserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthorizedUser> user = userRepo.findByUserName(username);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(username);
        } else {
            return User.builder()
                    .username(user.get().getUserName())
                    .password(user.get().getPassword())
                    .disabled(!user.get().isActive())
                    .build();
        }
    }
}