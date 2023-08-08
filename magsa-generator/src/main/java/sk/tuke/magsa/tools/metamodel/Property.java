package sk.tuke.magsa.tools.metamodel;

import java.util.Objects;

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

    public Type getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Property))
            return false;

        Property that = (Property) obj;

        if (Objects.equals(name, that.name) && type == that.type) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash = 31 * hash + (type == null ? 0 : type.hashCode());

        return hash;
    }
}
