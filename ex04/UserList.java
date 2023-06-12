public interface UserList {
    void addUser(User user);

    User getUserById(int id) throws UserArrayList.UserNotFoundException;

    User getUserByIndex(int index);

    int getUsersCount();

}
