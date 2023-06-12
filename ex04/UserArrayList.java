import java.util.Arrays;

public class UserArrayList implements UserList {

    private User[] users = new User[10];
    private int size = 0;
    private int capacity = 10;

    @Override
    public void addUser(User user) {
        if (size == capacity) {
            capacity += capacity / 2;
            User[] newUsers = new User[capacity];
            for (int i = 0; i < size; i++) {
                newUsers[i] = users[i];
            }
            users = newUsers;
        }
        users[size] = user;
        size++;
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        throw new UserNotFoundException();

    }

    @Override
    public User getUserByIndex(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Out of bound");
        }
        return users[index];
    }

    @Override
    public int getUsersCount() {
        return size;
    }

    public static class UserNotFoundException extends Exception {
        public UserNotFoundException() {
            super("User not found");
        }
    }

    @Override
    public String toString() {
        return "UserArrayList{" +
                "\nusers=" + Arrays.toString(users) +
                ", \nsize=" + size +
                ", \ncapacity=" + capacity +
                "\n}";
    }
}
