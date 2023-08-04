package sk.tuke.magsa.tools.metamodel;

public class Property implements Named {

    private final String name;

    
    public Property(String name) {
        this.name = name;       
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
