package pl.test.projectforsignup.models;

import javax.persistence.*;


@Entity
@Table
public class UserClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private final String userName;
    private final String password;
    private final UserRoles userRoles;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public UserClass(String userName, String password, UserRoles userRoles) {
        this.userName = userName;
        this.password = password;
        this.userRoles = userRoles;


    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userRoles=" + userRoles +
                '}';
    }
}
