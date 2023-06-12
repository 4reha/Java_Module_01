public class Program {
    public static void main(String[] args) {
        UserArrayList users = new UserArrayList();
        users.addUser(new User("Mike", 100, 1));
        users.addUser(new User("John", 200, 2));
        users.addUser(new User("Bob", 300, 3));

        try {
            Transaction transaction0 = new Transaction(users.getUserById(1),
                    users.getUserById(2), 50, Transaction.category.CREDITS);
            transaction0.execute();
            System.out.println(users);
            Transaction[] transactions = users.getUserById(1).getTransactions();
            for (Transaction transaction : transactions) {
                System.out.println(transaction);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
