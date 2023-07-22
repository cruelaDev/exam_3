package org.example.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.common.Service;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService implements Service<User, UUID> {
    private final UserRepository userRepository = UserRepository.getInstance();
    private static final UserService userService = new UserService();

    @Override
    public User findById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void remove(UUID uuid) {
        userRepository.delete(uuid);
    }

    @Override
    public User add(User user) {
        List<User> users = getAll();
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                return null;
            }
        }
        return userRepository.add(user);
    }

    public static UserService getInstance() {
        return userService;
    }

    public User signIn(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user != null) {
            return user;
        }
        return null;
    }
}
