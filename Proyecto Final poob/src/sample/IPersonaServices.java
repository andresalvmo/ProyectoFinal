package sample;

import java.io.File;
import java.util.List;
import java.util.UUID;

public interface IPersonaServices {

    List<Persona> getAll();

    Persona getById(UUID id);

    public Persona insert(Persona persona);

    void delete(List<Persona> personas);

    void export() throws Exception;

    void exportconstantemente() throws Exception;

    List<Persona> importPersonas(File file) throws Exception;

}
