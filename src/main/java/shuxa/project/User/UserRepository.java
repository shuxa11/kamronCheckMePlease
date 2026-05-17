package shuxa.project.User;

import shuxa.project.Exceptions.*;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<Long, User> storage = new HashMap<>();

    public void save(User user){
        if (storage.containsKey(user.getId())){
            throw new DuplicateUserException("This user already exists");
        }
        storage.put(user.getId(), user);
    }

    public User findById(Long id){
        User user = storage.get(id);
        if(user == null){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

}
