import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> userList = new ArrayList<>();
    public void saveUser(User user){
        userList.add(user);
    }
    public void showAllUser(){
        userList.forEach(user -> System.out.println(user));
    }
    public User findBySsn(long ssn){
        for(User  user : userList){
            if (user.getSSN() == ssn){
                return user;
            }
        }
        return null;
    }
    public boolean deleteByUserSsn(long ssn){
        User user = findBySsn(ssn);
        if(user != null){
            userList.remove(user);
            return true;
        }
        return false;
    }
}
