package sk.tuke.magsa.tools.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;

public class LineParser {
    private static final char SEPARATOR = ':';

    public Model parseDir(File dir) throws ParserException {
        if (!dir.isDirectory()) {
            throw new ParserException(dir + " is not a directory");
        }

        List<Entity> entities = new ArrayList<Entity>();
        for (File file : dir.listFiles()) {
            entities.add(parse(file));
        }
        return new Model(entities.toArray(new Entity[]{}));
    }

    public Entity parse(File file) throws ParserException {
        try {
            Reader reader = new FileReader(file);
            String name = file.getName();
            name = name.substring(0, name.lastIndexOf('.'));
            return parse(name, reader);
        } catch (IOException e) {
            throw new ParserException("Cannot open file " + file, e);
        }
    }

    private Entity parse(String name, Reader reader) throws ParserException {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private Property parseLine(String line) throws ParserException {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
