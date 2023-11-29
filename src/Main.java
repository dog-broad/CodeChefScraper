import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> usernames = new ArrayList<>();

        System.out.println("Enter number of usernames: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        System.out.println("Enter usernames: ");
        for (int i = 0; i < num; i++) {
            usernames.add(scanner.next());
        }

        // Lock the user input
        scanner.close();

        // Print a loading message
        System.out.println("Loading...");

        List<CodeChefScraper.UserData> userDataList = CodeChefScraperTester.scrapeUserDataList(usernames);

        for (CodeChefScraper.UserData userData : userDataList) {
            System.out.println("User: " + userData.getUser());
            System.out.println(userData.getRatingNumber());
            System.out.println(userData.getPracticeProblems());
        }
    }
}
