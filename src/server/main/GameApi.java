import static spark.Spark.*;
import spark.Filter;

public class GameApi {
    public static void main(String[] args) {
        after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

        get("/hello", (req, res) -> "Hello World");
    }
}