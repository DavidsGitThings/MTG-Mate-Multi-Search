import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class MultiSearchTabCreator {

    public static void openMultipleTabs(List<String> queries) {
        if (queries == null || queries.isEmpty()) {
            System.out.println("No queries provided.");
            return;
        }

        for (String query : queries) {
            openTab(query);
        }
    }

    private static void openTab(String query) {
        try {
            // Manually replace spaces with '%20' for proper encoding
            String encodedQuery = query.replace(" ", "%20");

            // Construct the final URL with the correctly encoded query
            String url = "https://www.mtgmate.com.au/cards/" + encodedQuery;

            // Open the URL in the default web browser
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("Desktop browsing is not supported on this system.");
            }
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error opening tab for query: " + query);
            e.printStackTrace();
        }
    }
}
