import java.util.*;

public class SortUser implements Comparator<User> {

//        public int compare(User a, User b)
//    {
//        try {
//            List<String> result = Files.readAllLines(Paths.get("src/main/resources/UserDatabase.txt"));
//            List<String>[] arr = new List[]{result};
////            Sorts arr[] in ascending order
//            Arrays.sort(new List[]{result});
//            System.out.printf("Modified arr[] : \n%s\n\n",
//                    Arrays.toString(new List[]{result}));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return 1;
//    }

    public int compare (User a, User b)
    {
//        return a.login - b.login;
        return 1;
    }

//    public int compare(User a, User b)
//    {
//        return a.login - b.login;
//    }
}
