package sample;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IPersonaPersistance {
    void save(Persona persona) throws IOException;

    List<Persona> read(String path) throws IOException, ClassNotFoundException;

    List<String> importPersonas(File file) throws Exception;


}
