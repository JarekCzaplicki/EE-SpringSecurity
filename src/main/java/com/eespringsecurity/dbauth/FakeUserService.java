package com.eespringsecurity.dbauth;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.eespringsecurity.security.ApplicationUserRole.*;


@Service("fake")
public class FakeUserService implements UserService {
    private final PasswordEncoder passwordEncoder;

    public FakeUserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> getApplicationUserBy(String userName) {
        return getApplicationUsers()
                .stream()
                .filter(user -> user.getUsername().equals(userName))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(
                        passwordEncoder.encode("123456"),
                        "student",
                        STUDENT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        passwordEncoder.encode("123456"),
                        "old",
                        OLD_STUDENT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        passwordEncoder.encode("123456"),
                        "admin",
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        passwordEncoder.encode("123456"),
                        "verbs",
                        HTTP_VERBS.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );
    }
}
