public class Program {
    private static int userIds = 0;

    private static int getNextId() {
        return userIds++;
    }

    public static void main(String[] args) {
        User john = new User(getNextId(), "John", 1000);
        User matt = new User(getNextId(), "matt");
        matt.setBalance(100);
        System.out.println(john);
        System.out.println(matt);
        Transaction transaction0 = new Transaction(matt, john, 600, Category.DEBITS);
        Transaction transaction1 = new Transaction(matt, john, 600, Category.CREDITS);
        System.out.println(transaction0);
        System.out.println(transaction1);
        System.out.println(john);
        System.out.println(matt);
    }
}