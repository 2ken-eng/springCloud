package ken.commons;

/**
 * Create By C on 2021-03-31
 */
public class User {


    private Integer id;
    private  String UserNmae;
    private String UserPassword;
    private String sex;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", UserNmae='" + UserNmae + '\'' +
                ", UserPassword='" + UserPassword + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNmae() {
        return UserNmae;
    }

    public void setUserNmae(String userNmae) {
        UserNmae = userNmae;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
