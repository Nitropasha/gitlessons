package lamda;
interface Database {
    User create(String name, String password);
}
class User {
    public String name, password;

   public  String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

}

public class Links {
    public static void main(String[] args) {
        Database database = User::new;
        User user = database.create("Simon", "root");
        System.out.printf("Name: %s%nPassword: %s%n", user.getName(), user.getPassword());
    }
}
