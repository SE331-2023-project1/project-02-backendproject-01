package se331.project.projectTwoCompo.security.user;

import jakarta.transaction.Transactional;

public interface UserService {
    User save(User user);

    @Transactional
    User findByUsername(String username);
}