

package in.mahabhujal.mahabhujal.model;

public class Users {
    //private int id;
    String email;
    String username,first_name,last_name;
    String password;

    public Users(String email, String username, String first_name, String last_name, String password) {
        this.email = email;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



