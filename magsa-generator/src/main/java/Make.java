import java.io.File;

import sk.tuke.magsa.tools.generator.CollectionTemplateGenerator;
import sk.tuke.magsa.tools.metamodel.*;
import sk.tuke.magsa.tools.parser.*;
import sk.tuke.magsa.generator.*;

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

        /* Generator - database script */
//        new DatabaseScriptGenerator(model).generate();

        /* Generators -  entity, dao interface, dao implementation */
        new CollectionTemplateGenerator<Entity>(model, "entity_class", model.getEntities()).generate();
        new CollectionTemplateGenerator<Entity>(model, "dao_interface", model.getEntities()).generate();
        new CollectionTemplateGenerator<Entity>(model, "dao_impl", model.getEntities()).generate();

    }
}
