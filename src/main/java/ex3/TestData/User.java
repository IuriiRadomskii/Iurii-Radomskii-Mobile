package ex3.TestData;

public class User {

    private String email;
    private String userName;
    private String password;

    public User(String email, String name, String password) {
        this.email = email;
        this.userName = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
