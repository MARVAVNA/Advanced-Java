public class Test {
    public static void main(String[] args) {
        User user = new User("login13", "pass111", 2000, true);
        user.setCar(new Car("BMW"));
        UserService.serializeUser(user);

        User user2 = UserService.deserializeUser();
        System.out.println(user2);

    }
}

