import java.util.Scanner;

public class UrlShortenerDemo {
    public static void main(String[] args) {
        // Create an instance of the UrlShortener class
        UrlShortener urlShortener = new UrlShortener();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a URL
        System.out.print("Enter a URL to encode: ");
        String originalUrl = scanner.nextLine();
        System.out.println("Original URL: " + originalUrl);

        // Encode the URL and print the JSON response
        JSONObject encodedJson = urlShortener.encode(originalUrl);
        System.out.println("Encoded JSON: " + encodedJson.toString());

        // Extract the tinyUrl from the JSON response
        String tinyUrlString = encodedJson.getString("tinyUrl");

        // Decode the tinyUrl and print the JSON response
        System.out.println("Tiny URL: " + tinyUrlString);
        JSONObject decodedJson = urlShortener.decode(tinyUrlString);
        System.out.println("Decoded JSON: " + decodedJson.toString());

        // Close the Scanner
        scanner.close();
    }
}
