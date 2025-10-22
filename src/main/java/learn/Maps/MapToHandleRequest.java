package learn.Maps;

public class MapToHandleRequest {

    // private static final String LOG_FILE_PATH =
    // "src/main/resources/Files/spring_boot_style_log_with_request_method.txt";

    public static void main(String[] args) {
        // BufferedReader reader;
        // try {
        // reader = new BufferedReader(new FileReader(LOG_FILE_PATH));
        // String line;
        // while ((line = reader.readLine()) != null) {
        // break;
        // }
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        String str = "2025-10-15 22:23:53.895  INFO com.example.service.FoodService - method:POST | request:/api/speech/gas | statusCode:400";
        int methodIndex = str.indexOf("method:");
        int requestIndex = str.indexOf("request");
        int statusIndex = str.indexOf("statusCode");
        System.out.println(str.substring(methodIndex, requestIndex));
        System.out.println(str.substring(requestIndex, statusIndex));
        System.out.println(str.substring(statusIndex, str.length()));

    }
}
