import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/result", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/result.vtl");

            LetterReplacer myReplacer = new LetterReplacer();
            String userInputString = request.queryParams("user-entry").trim();
            String outputString = myReplacer.letterReplace(userInputString);

            model.put("user-input-string", userInputString);
            model.put("output-string", outputString);

            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


    }
}
