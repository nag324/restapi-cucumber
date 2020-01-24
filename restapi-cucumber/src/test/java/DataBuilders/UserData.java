package DataBuilders;

import java.util.ArrayList;
import java.util.List;

import models.User;
import models.Result;
import models._meta;
import models.RateLimit;

public class UserData {
    public Result createUserPayload(String first_name, String last_name, String gender, String email, String status) {
        Result addUser = new Result();
        addUser.setFirst_name(first_name);
        addUser.setLast_name(last_name);
        addUser.setGender(gender);
        addUser.setEmail(email);
        addUser.setStatus(status);

        return addUser;

    }

    public Result updateUserPayload(String first_name) {
        Result updateUser = new Result();
        updateUser.setFirst_name(first_name);

        return updateUser;

    }

    public String deleteUserPayload(String userId) {
        return userId;


    }


}
