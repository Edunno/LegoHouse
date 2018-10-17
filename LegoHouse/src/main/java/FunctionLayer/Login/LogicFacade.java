package FunctionLayer.Login;

import DB.DataMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {
    

    public static User login( String email, String password ) throws LoginSampleException {
        DataMapper dm = new DataMapper();
        return dm.getUserInfo( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = null;
        DataMapper dm = new DataMapper();
        boolean x = dm.insertUser(email,password);
        if(x){
            user = dm.getUserInfo(email, password);
        }
        else {
            user = new User("User not created", false);
        }
        return user;
    }

}
