package azo.developer.springauthenticationdemo;

import azo.developer.springauthenticationdemo.entity.AuthoritiesEntity;
import azo.developer.springauthenticationdemo.entity.UsersEntity;
import azo.developer.springauthenticationdemo.repository.AuthoritiesRepository;
import azo.developer.springauthenticationdemo.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;

@RequiredArgsConstructor
@Component
public class DatabasePopulater implements CommandLineRunner {

    private final UsersRepository usersRepository;
    private final AuthoritiesRepository authoritiesRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(String... args) throws Exception {
        AuthoritiesEntity authorityRead = AuthoritiesEntity.builder()
                .authority("PERMISSION_READ")
                .build();

        AuthoritiesEntity authorityWrite = AuthoritiesEntity.builder()
                .authority("PERMISSION_WRITE")
                .build();

        authoritiesRepository.saveAll(Arrays.asList(authorityRead, authorityWrite));

        UsersEntity usersAdmin = UsersEntity.builder()
                .username("admin")
                .password(bCryptPasswordEncoder.encode("pass"))
                .authorities(Arrays.asList(authorityRead, authorityWrite))
                .enabled(1)
                .build();

        UsersEntity usersUser = UsersEntity.builder()
                .username("user")
                .password(bCryptPasswordEncoder.encode("pass"))
                .authorities(Collections.singletonList(authorityRead))
                .enabled(1)
                .build();

        usersRepository.saveAll(Arrays.asList(usersAdmin, usersUser));
    }
}
