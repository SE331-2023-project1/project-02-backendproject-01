package se331.project.projectTwoCompo.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}