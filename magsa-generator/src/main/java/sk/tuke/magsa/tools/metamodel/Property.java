package sk.tuke.magsa.tools.metamodel;

public class Property implements Named {

    private final String name;
    private final Type type;

    
    public Property(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
