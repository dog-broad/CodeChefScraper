import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeChefScraper {

    // A simple class to store user data
    public static class UserData {

        private final String user;
        private final int ratingNumber;
        private final int practiceProblems;

        public UserData(String user, int ratingNumber, int practiceProblems) {
            this.user = user;
            this.ratingNumber = ratingNumber;
            this.practiceProblems = practiceProblems;
        }

        public int getRatingNumber() {
            return ratingNumber;
        }

        public int getPracticeProblems() {
            return practiceProblems;
        }

        public String getUser() {
            return user;
        }
    }

    public static UserData scrapeUserData(String username) {
        // Create a URL
        String url = "https://www.codechef.com/users/" + username;

        // Connect to the URL
        try {
            // jsoup is a Java library for parsing HTML
            Document doc = Jsoup.connect(url).get();

            // Get the rating number and practice problems
            Element ratingNumberElement = doc.selectFirst(".rating-header .rating-number");
            Element practiceProblemElement = doc.selectFirst("section.problems-solved h3:contains(Practice Problems)");

            // Other Elements can also be used by finding their class or id, above ones were just examples through css selectors

            // Get the rating number
            int ratingNumber = 0;
            if (ratingNumberElement != null) {
                String ratingNumberText = ratingNumberElement.text();
                ratingNumber = Integer.parseInt(ratingNumberText);
            }

            // Get the number of practice problems
            int practiceProblems = 0;
            if (practiceProblemElement != null) {
                String practiceProblemText = practiceProblemElement.text();
                // Text is of the form "Practice Problem: (x)"
                // Extract the number (x) from the text
                Pattern pattern = Pattern.compile("\\((\\d+)\\)");
                Matcher matcher = pattern.matcher(practiceProblemText);
                if (matcher.find()) {
                    String count = matcher.group(1);
                    practiceProblems = Integer.parseInt(count);
                }
            }

            // Return the user data by generating a new UserData object
            return new UserData(username, ratingNumber, practiceProblems);

        } catch (IOException | NumberFormatException e) {
            // Display a simple error message
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}
