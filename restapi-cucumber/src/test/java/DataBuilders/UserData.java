package DataBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import models.User;
import models.Result;
import models._meta;
import models.RateLimit;

public class UserData {

  // public static Result addUser=null;
  //  Result addUser = new Result()
    public Result createUserPayload(String first_name, String last_name, String gender, String status) {

        int randomNum = ThreadLocalRandom.current().nextInt(1, 10000 + 1);
        Result addUser = new Result();
        addUser.setFirst_name(first_name+randomNum);
        addUser.setLast_name(last_name);
        addUser.setGender(gender);
        addUser.setEmail(first_name+randomNum+"@gmail.com");
        System.out.println(addUser.getEmail());
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
