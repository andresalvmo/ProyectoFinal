package sample;

import javafx.collections.FXCollections;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonaServices implements IPersonaServices {

    private IPersonaPersistance personaPersistence;
    private IExport export;
    private List<Persona> personas;

    public PersonaServices() {
        this.personas = FXCollections.observableArrayList();
        try {
            this.personaPersistence = new PersonaPersistance();
            this.export = new Export();
            //this.personas.addAll(this.personaPersistence.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Persona> getAll() {
        return this.personas;
    }

    @Override
    public Persona getById(UUID id) {
        return null;
    }

    @Override
    public Persona insert(Persona persona) {
        personas.add(persona);
        return persona;
    }

    @Override
    public void delete(List<Persona> personasToDelete) {

        personasToDelete.forEach(this.personas::remove);
    }

    @Override
    public void export() throws Exception {
        List<Exportable> e = new ArrayList<>();
        this.personas.stream().forEach(p -> e.add(p));
        this.export.export(e, Exportable.CSV);
    }

    @Override
    public List<Persona> importPersonas(File file) throws Exception {
        List<Persona> importedPersonas = new ArrayList<>();
        List<String> read = this.personaPersistence.importPersonas(file);

        for (String line : read) {
            String[] tokens = line.split(Exportable.CSV.toString());
            for (String i:tokens)
            {
                System.out.print(i);
            }

            Persona persona = new Persona(tokens[0], tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8]);
            importedPersonas.add(persona);
            this.insert(persona);
        }

        return importedPersonas;
    }
}

