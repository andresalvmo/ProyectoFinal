package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReportScene{

    private Stage stage;
    private Scene scene;
    private GridPane gridPane;
    private Label Activos;
    private Label Inactivos;
    private Label ActivosMayorEstrato;
    private Label InactivosMayorEstrato;
    private Label EntidadMenosAfiliados;
    private Label EntidadMayorAfiliados;
    private int activos;
    private int inactivos;
    private List<Integer> activosEstrato;
    private List<Integer> inactivosEstrato;
    private int activosMayorEstrato;
    private int inactivosMayorEstrato;
    private List<String> Entidades;
    private List<Integer> EntidadesCount;
    private String MayorEntidades;
    private String MenorEntidades;




    private IPersonaServices personaServices;


    public ReportScene(IPersonaServices personaServices)  {
        this.personaServices=personaServices;
        stage = new Stage();
        behavior();
        setUp();


        stage.setTitle("Reporte");
        stage.setScene(scene);
        stage.show();

    }

    private void setUp() {
        setUpLabels();
        VBox VBoxe = new VBox();
        VBoxe.setPadding(new Insets(10, 10, 10, 10));
        VBoxe.setSpacing(10);
        VBoxe.getChildren().addAll(Activos,Inactivos,ActivosMayorEstrato,InactivosMayorEstrato,EntidadMayorAfiliados,EntidadMenosAfiliados);

        scene = new Scene(VBoxe, 380, 180);
    }

    private void setUpLabels()
    {
        Activos=new Label("Número de Activos: "+Integer.toString(activos));
        Activos.setMinWidth(30);

        Inactivos=new Label("Número de Inactivos: "+Integer.toString(inactivos));
        Inactivos.setMinWidth(30);

        ActivosMayorEstrato=new Label("Estrato con mayor número de activos: "+Integer.toString(activosMayorEstrato));
        ActivosMayorEstrato.setMinWidth(30);

        InactivosMayorEstrato=new Label("Estrato con mayor número de inactivos: "+Integer.toString(inactivosMayorEstrato) );
        InactivosMayorEstrato.setMinWidth(30);

        EntidadMayorAfiliados=new Label("Entidad con mayor número de afiliados: "+MayorEntidades);
        EntidadMayorAfiliados.setMinWidth(30);

        EntidadMenosAfiliados=new Label("Entidad con menor número de afiliados: "+MenorEntidades);
        EntidadMenosAfiliados.setMinWidth(30);

    }

    public void get()
    {
        activos=0;
        inactivos=0;

        List<Persona> personas=this.personaServices.getAll();
        for(Persona p:personas)
        {
            if("Activa".equals(p.getAfiliacion()))
            {
                activos+=1;
            }
            else if("Inactivo".equals(p.getAfiliacion()))
            {
                inactivos+=1;
            }
        }
    }

    public void getEntidad()
    {
        Entidades=new ArrayList<String>();
        EntidadesCount=new ArrayList<Integer>();

        EntidadesCount.add(0);
        EntidadesCount.add(0);
        EntidadesCount.add(0);
        EntidadesCount.add(0);

        Entidades.add("MediMas");
        Entidades.add("Saludcoop");
        Entidades.add("Nueva EPS");
        Entidades.add("FamiSanar");
        List<Persona> personas=this.personaServices.getAll();

        for(Persona p:personas)
            {
                if(Entidades.get(0).equals(p.getEntidad()))
                {
                    EntidadesCount.set(0, EntidadesCount.get(0) + 1);
                }
                else if(Entidades.get(1).equals(p.getEntidad()))
                {
                    EntidadesCount.set(1, EntidadesCount.get(1) + 1);
                }
                else if(Entidades.get(2).equals(p.getEntidad()))
                {
                    EntidadesCount.set(2, EntidadesCount.get(2) + 1);
                }

                else if(Entidades.get(3).equals(p.getEntidad()))
                {
                    EntidadesCount.set(3, EntidadesCount.get(3) + 1);
                }

            }
        MayorEntidades=Entidades.get(EntidadesCount.indexOf(Collections.max(EntidadesCount)));
        MenorEntidades=Entidades.get(EntidadesCount.indexOf(Collections.min(EntidadesCount)));

    }

    public void getEstrato()
    {
        activosEstrato=new ArrayList<Integer>();
        inactivosEstrato=new ArrayList<Integer>();

        activosEstrato.add(0);
        activosEstrato.add(0);
        activosEstrato.add(0);
        activosEstrato.add(0);
        activosEstrato.add(0);
        activosEstrato.add(0);

        inactivosEstrato.add(0);
        inactivosEstrato.add(0);
        inactivosEstrato.add(0);
        inactivosEstrato.add(0);
        inactivosEstrato.add(0);
        inactivosEstrato.add(0);


        List<Persona> personas=this.personaServices.getAll();
        for(Persona p:personas)
        {
            if("Activa".equals(p.getAfiliacion())) {
                if ("1".equals(p.getEstrato())) {
                    activosEstrato.set(0, activosEstrato.get(0) + 1);
                } else if ("2".equals(p.getEstrato())) {
                    activosEstrato.set(1, activosEstrato.get(1) + 1);
                } else if ("3".equals(p.getEstrato())) {
                    activosEstrato.set(2, activosEstrato.get(2) + 1);
                } else if ("4".equals(p.getEstrato())) {
                    activosEstrato.set(3, activosEstrato.get(3) + 1);
                } else if ("5".equals(p.getEstrato())) {
                    activosEstrato.set(4, activosEstrato.get(4) + 1);
                } else if ("6".equals(p.getEstrato())) {
                    activosEstrato.set(5, activosEstrato.get(5) + 1);
                }
            }

            else if("Inactivo".equals(p.getAfiliacion()))
            {
                if ("1".equals(p.getEstrato())) {
                    inactivosEstrato.set(0, inactivosEstrato.get(0) + 1);
                } else if ("2".equals(p.getEstrato())) {
                    inactivosEstrato.set(1, inactivosEstrato.get(1) + 1);
                } else if ("3".equals(p.getEstrato())) {
                    inactivosEstrato.set(2, inactivosEstrato.get(2) + 1);
                } else if ("4".equals(p.getEstrato())) {
                    inactivosEstrato.set(3, inactivosEstrato.get(3) + 1);
                } else if ("5".equals(p.getEstrato())) {
                    inactivosEstrato.set(4, inactivosEstrato.get(4) + 1);
                } else if ("6".equals(p.getEstrato())) {
                    inactivosEstrato.set(5, inactivosEstrato.get(5) + 1);
                }
            }


        }

        activosMayorEstrato=activosEstrato.indexOf(Collections.max(activosEstrato))+1;
        inactivosMayorEstrato=inactivosEstrato.indexOf(Collections.max(inactivosEstrato))+1;




    }

    private void behavior()
    {
        this.personaServices=personaServices;
        get();
        getEstrato();
        getEntidad();

    }

}
