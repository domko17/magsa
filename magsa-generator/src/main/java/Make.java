import java.io.File;

import sk.tuke.magsa.tools.metamodel.*;
import sk.tuke.magsa.tools.parser.*;

public class Make {
    public static void main(String[] args) throws Exception {
        /* Model - object representation of input sentences */
        Model model;

        /* External language - single line parser parses the content of model directory in the project */
        File dir = new File("model/entities");
        LineParser parser = new LineParser();
        model = parser.parseDir(dir);

        /* Print the model */
        System.out.println(model);
    }
}
