package sk.tuke.magsa.tools.parser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import sk.tuke.magsa.tools.metamodel.Entity;
import sk.tuke.magsa.tools.metamodel.Model;
import sk.tuke.magsa.tools.metamodel.Property;
import sk.tuke.magsa.tools.metamodel.Type;

import javax.sound.sampled.Port;
import java.util.Arrays;


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

    private Entity parse(String name, Reader reader) throws ParserException, IOException {
        if(reader.ready()) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            HashSet<Property> properties = new HashSet<>();
            String line;
            int lineNumber = 0;

            while ((line = bufferedReader.readLine()) != null) {
                lineNumber++;
                if (line.charAt(0) != '#') {
                    if (properties.contains(parseLine(line))) {
                        System.out.println("Duplicate property on the line " + lineNumber);
                    } else {
                        properties.add(parseLine(line));
                    }
                }
            }


            reader.close();
            return new Entity(name, properties.toArray(new Property[properties.size()]));
        }

        return null;
    }

    private Property parseLine(String line) throws ParserException {
        String[] command = line.split(String.valueOf(SEPARATOR));
        String propertyName = command[0].trim();
        Type type = Type.STRING;

        if (command.length == 2){
            String typeName = command[1].trim();
            if (typeName == "integer") {
                type = Type.INTEGER;
            }

            if (typeName == "real") {
                type = Type.REAL;
            }
        }

        return new Property(propertyName, type);
    }
}
