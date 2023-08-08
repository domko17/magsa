package sk.tuke.magsa.tools.metamodel;

public enum Type {
    INTEGER, REAL, STRING;

    @Override
    public String toString() {
        switch (this.ordinal()) {
            case 0:
                return "Integer";
            case 1:
                return "Real";
            case 2:
                return "String";
            default:
                return null;
        }
    }
}
