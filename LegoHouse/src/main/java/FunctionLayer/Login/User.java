package FunctionLayer.Login;

/**
 * The purpose of User is to...
 * @author kasper
 */
public class User {

    public User( String email, boolean admin ) {
        this.email = email;
        this.admin = admin;
    }
    
    private String email;
    private String password; // Should be hashed and secured
    private boolean admin;

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin( boolean role ) {
        this.admin = role;
    }
}
