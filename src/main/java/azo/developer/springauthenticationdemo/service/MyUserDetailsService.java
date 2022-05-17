package azo.developer.springauthenticationdemo.service;

import azo.developer.springauthenticationdemo.model.MyUserDetails;
import azo.developer.springauthenticationdemo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(usersRepository.findById(username).orElseThrow(IllegalArgumentException::new));
    }
}
