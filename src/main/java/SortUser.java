import java.util.*;

public class SortUser implements Comparator<User> {

    public int compare (User a, User b)
    {
        return a.userId - b.userId;
    }
}
