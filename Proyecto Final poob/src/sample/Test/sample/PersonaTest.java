package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    void getName() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        String r1=persona.getName();
        assertEquals("Diego",r1);
    }

    @Test
    void getLastName() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        String r2= persona.getLastName();
        assertEquals("Prieto",r2);
    }

    @Test
    void getAge() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        int r=persona.getAge();
        assertEquals(25,r);
    }

    @Test
    void getSector() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        String r=persona.getSector();
        assertEquals("Manzanares",r);
    }

    @Test
    void getContacto() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        String r= persona.getContacto();
        assertEquals("3142259844",r);
    }

    @Test
    void getAfiliacion() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        String r =persona.getAfiliacion();
        assertEquals("Activa",r);
    }

    @Test
    void getEntidad() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        String r= persona.getEntidad();
        assertEquals("FamiSanar",r);
    }

    @Test
    void getEstrato() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        String r=persona.getEstrato();
        assertEquals("5",r);
    }

    @Test
    void getSangre() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        String r=persona.getSangre();
        assertEquals("A+",r);
    }

    @Test
    void setAge() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        persona.setAge("14");
        int r= persona.getAge();
        assertEquals(14,r);
    }

    @Test
    void setContacto() throws Exception {
        Persona persona=new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar");
        persona.setContacto("3103252121");
        String r= persona.getContacto();
        assertEquals("3103252121",r);
    }
}