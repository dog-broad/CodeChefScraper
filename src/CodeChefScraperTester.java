import java.util.ArrayList;
import java.util.List;

public class CodeChefScraperTester {
    public static List<CodeChefScraper.UserData> scrapeUserDataList(List<String> usernames) {
        // Generate a list of user data
        List<CodeChefScraper.UserData> userDataList = new ArrayList<>();
        // Iterate over usernames, scrape user data, and add it to the list
        for (String username : usernames) {
            CodeChefScraper.UserData userData = CodeChefScraper.scrapeUserData(username);
            // Make sure the user data was found
            if (userData != null) {
                userDataList.add(userData);
            }
        }
        if (userDataList.isEmpty()) {
            System.out.println("No user data found.");
        }
        return userDataList;
    }
}
