import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> usernames = new ArrayList<>();

        System.out.println("Enter usernames (separated by spaces):");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            usernames.add(sc.nextLine());
        }

        List<CodeChefScraper.UserData> userDataList = CodeChefScraperTester.scrapeUserDataList(usernames);

        for (CodeChefScraper.UserData userData : userDataList) {
            System.out.println("User: " + userData.getUser());
            System.out.println(userData.getRatingNumber());
            System.out.println(userData.getPracticeProblems());
        }
    }
}
