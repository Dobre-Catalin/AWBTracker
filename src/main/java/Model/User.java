package Model;
enum Permissions {
    VIEWONLY,
    SENDER,
    RECEIVER,
    PARCELADMIN,
    USERADMIN
}

public class User {
    String email;
    String password;
    Permissions permissions;

    public User(String email, String password, int permissions) {
        this.email = email;
        this.password = password;
        this.permissions = permissions;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Boolean isAdmin(){
        if 
    }
}
