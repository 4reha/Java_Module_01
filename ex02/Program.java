public class Program {
    public static void main(String[] args) {
        UserArrayList users = new UserArrayList();
        users.addUser(new User("John"));
        users.addUser(new User("Bob"));
        users.addUser(new User("Alice"));
        users.addUser(new User("Tom"));
        users.addUser(new User("Sam"));
        users.addUser(new User("Jack"));
        System.out.println(users.getUsersCount());
        try {
            System.out.println(users.getUserById(2));
            System.out.println(users.getUserById(-1));
        } catch (UserArrayList.UserNotFoundException e) {
            System.err.println(e.getMessage());
        }
        try
        {
            System.out.println(users.getUserByIndex(2));
            System.out.println(users.getUserByIndex(65));
        }
        catch (IndexOutOfBoundsException e)
        {
            System.err.println(e.getMessage());
        }
    }
}
