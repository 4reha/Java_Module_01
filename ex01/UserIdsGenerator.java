public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private int lastGeneratedId;

    private UserIdsGenerator() {
        // Private constructor to prevent direct instantiation
        lastGeneratedId = 0;
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null) {
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    public int generateId() {
        lastGeneratedId++;
        return lastGeneratedId;
    }
}
