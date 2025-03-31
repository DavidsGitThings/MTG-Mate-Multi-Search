import java.io.IOException;

public class OpenGoogleTab {
    public static void openGoogleInChrome() {
        String url = "https://www.google.com.au";
        String os = System.getProperty("os.name").toLowerCase();

        try {
            if (os.contains("win")) {
                // Windows: Open Chrome using cmd
                new ProcessBuilder("cmd", "/c", "start chrome --new-window " + url).start();
            } else if (os.contains("mac")) {
                // macOS: Open Chrome explicitly
                new ProcessBuilder("open", "-a", "Google Chrome", url).start();
            } else if (os.contains("nix") || os.contains("nux")) {
                // Linux: Open Chrome (assuming it's installed as google-chrome)
                new ProcessBuilder("google-chrome", "--new-window", url).start();
            } else {
                System.out.println("Unsupported OS");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        openGoogleInChrome();
    }
}
