package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Exportable implements Serializable {
    private String name;
    private String lastName;
    private int age;
    private String afiliacion;
    private String sector;
    private String contacto;
    private String estrato;
    private String sangre;
    private String entidad;

    public Persona(String name,String lastName, String age,String afiliacion,String sector, String contacto,String estrato,String sangre,String entidad ) throws Exception {
        this.name=name;
        this.lastName=lastName;
        this.afiliacion=afiliacion;
        this.sector=sector;
        this.setAge(age);
        this.setContacto(contacto);
        this.estrato=estrato;
        this.sangre=sangre;
        this.entidad=entidad;


    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSector() {
        return sector;
    }

    public String getContacto() {
        return contacto;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public String getEntidad() {
        return entidad;
    }

    public String getEstrato() {
        return estrato;
    }

    public String getSangre(){
        return sangre;
    }

    public void setAge(String ageI) throws Exception {
        try {
            int age = Integer.parseInt(ageI);
            this.age = age;
        } catch (NumberFormatException er) {
            throw new Exception("Debe ser un número");
        }

    }

    public void setContacto(String contactoI) {
        this.contacto = contactoI;



    }


    @Override
    public List<String> toListString() {
        List<String> result = new ArrayList<>();
        result.add(this.name);
        result.add(this.lastName);
        result.add(Integer.toString(this.age));
        result.add(this.afiliacion);
        result.add(this.sector);
        result.add(this.contacto);

        result.add(this.estrato);
        result.add(this.sangre);
        result.add(this.entidad);
        return result;
    }

    @Override
    public String getHeader() {
        return "name,LastName,afiliacion,sector,contacto,age,estrato,sangre,entidad";
    }
}
