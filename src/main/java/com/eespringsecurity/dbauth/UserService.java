package com.eespringsecurity.dbauth;

import java.util.Optional;

public interface UserService {
    Optional<ApplicationUser> getApplicationUserBy(String userName);
}
