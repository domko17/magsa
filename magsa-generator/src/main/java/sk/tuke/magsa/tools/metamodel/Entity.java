package sk.tuke.magsa.tools.metamodel;

import java.util.Arrays;

public class Entity implements Named {
   
    private final String name;

    private final Property[] properties;

   
    public Entity(String name, Property[] properties) {
        this.name = name;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public Property[] getProperties() {
        return properties;
    }
   
    @Override
    public String toString() {
        return "entity " + name + " " + Arrays.toString(properties);
    }
}
