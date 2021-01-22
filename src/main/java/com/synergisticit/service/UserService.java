package com.synergisticit.service;

import com.synergisticit.domain.User;

public interface UserService {

    User save(User user);
    User findByUsername(String username);
}
