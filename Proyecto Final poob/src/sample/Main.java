package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private Scene scene;
    private TableView<Persona> personasTable;
    private Label Name;
    private Label lastName;
    private Label age;
    private Label afiliacion;
    private Label sector;
    private Label contacto;
    private Label estrato;
    private Label sangre;
    private Label entidad;

    private TextField nameInput;
    private TextField lastNameInput;
    private TextField ageInput;
    private TextField afiliacionInput;
    private TextField sectorInput;
    private TextField contactoInput;
    private TextField sangreInput;
    private TextField entidadInput;
    private TextField estratoInput;


    private Button Info;
    private Button deletePersona;
    private Button openReport;
    private Button add;


    private Button Bimport;
    private Button Export;

    // Logic Properties
    private IPersonaServices personaServices;

    // Menu


    @Override
    public void start(Stage primaryStage) throws Exception{
        setUp();
        behavior(primaryStage);

        primaryStage.setTitle("Sabana Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void behavior(Stage stage) throws Exception {
        this.personaServices = new PersonaServices();
        this.personaServices.insert(new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844","5","A+","FamiSanar"));
        this.personaServices.insert(new Persona("Andres", "Alvarado", "23", "Activa", "Rosal","3002455244","4","AB-","MediMas"));
        this.personaServices.insert(new Persona("Andre", "Alva", "23", "Inactivo", "Rosal","3002455244","4","A-","Nueva EPS"));
        this.personaServices.insert(new Persona("Andi", "Arado", "23", "Inactivo", "Rosal","3002455244","4","B-","Saludcoop"));
        //this.personaServices.insert(new Persona("Diego", "Prieto", "25", "Activa", "Manzanares","3142259844"));

        personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());

        Info.setOnAction(e->{
            Persona p = personasTable.getSelectionModel().getSelectedItem();
            Name.setText("Nombre:  " + p.getName());
            lastName.setText("Apellido: "+p.getLastName());
            age.setText("Edad: "+ Integer.toString(p.getAge()));
            afiliacion.setText("Afiliación: " + p.getAfiliacion());
            sector.setText("Sector: "+p.getSector());
            contacto.setText("Contacto: "+p.getContacto());
            estrato.setText("Estrato: "+p.getEstrato());
            entidad.setText("Entidad: "+p.getEntidad());
            sangre.setText("Tipo de sangre: "+p.getSangre());
        });



        deletePersona.setOnAction(e -> {

            this.personaServices.delete(personasTable.getSelectionModel().getSelectedItems());
        });

        Export.setOnAction(e -> {
            try {
                this.personaServices.export();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        Bimport.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select personas file");
            File file = fileChooser.showOpenDialog(stage);
            if (file == null) {
                System.out.println("No file");
            } else {
                try {
                    this.personaServices.importPersonas(file);
                    this.personaServices.getAll().stream().forEach(p -> System.out.println(p));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        add.setOnAction(e ->{
            try {
                Persona p=new Persona(nameInput.getText(),lastNameInput.getText(),ageInput.getText(),afiliacionInput.getText(),sectorInput.getText(),contactoInput.getText(),estratoInput.getText(),sangreInput.getText(),entidadInput.getText());

                this.personaServices.insert(p);

                nameInput.clear();
                lastNameInput.clear();
                ageInput.clear();
                afiliacionInput.clear();
                sectorInput.clear();
                contactoInput.clear();
                estratoInput.clear();
                sangreInput.clear();
                entidadInput.clear();





            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        openReport.setOnAction(e->
        {
           new ReportScene(personaServices);
        });


    }

    private void setUp()
    {   setupTable();
        setUpCrud();
        setupInputs();
        setupMenu();




        VBox VBoxe = new VBox();
        VBoxe.setPadding(new Insets(10, 10, 10, 10));
        VBoxe.setSpacing(10);
        VBoxe.getChildren().addAll(Name,lastName,age,sangre,afiliacion,entidad,sector,estrato,contacto);

        HBox hBox2 = new HBox();
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.setSpacing(10);
        hBox2.getChildren().addAll(personasTable,VBoxe);


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(Info,deletePersona,openReport,Bimport,Export,add);

        HBox h=new HBox();
        h.setPadding(new Insets(10, 10, 10, 10));
        h.setSpacing(10);
        h.getChildren().addAll(nameInput,lastNameInput,ageInput,afiliacionInput,sectorInput);

        HBox h2=new HBox();
        h2.setPadding(new Insets(10, 10, 10, 10));
        h2.setSpacing(10);
        h2.getChildren().addAll(contactoInput,estratoInput,sangreInput,entidadInput);


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(hBox2,h,h2, hBox);

        scene = new Scene(layout, 600, 500);

    }

    private void setUpCrud() {
        Name= new Label("Nombre:");
        Name.setMinWidth(30);

       lastName = new Label("Apellido:");
        lastName.setMinWidth(30);

        age= new Label("Edad:");
        age.setMinWidth(30);

        afiliacion= new Label("Afiliacion:");
        afiliacion.setMinWidth(30);

        sector= new Label("Sector:");
        sector.setMinWidth(30);

        contacto= new Label("Contacto:");
        contacto.setMinWidth(30);

        estrato=new Label("Estrato: ");
        estrato.setMinWidth(30);

        entidad=new Label("Entidad: ");
        entidad.setMinWidth(30);

        sangre=new Label("Tipo de Sangre: ");
        sangre.setMinWidth(30);


        Info = new Button("Info");
        Info.setMinWidth(30);

        add=new Button("Add");
        add.setMinWidth(30);

        deletePersona = new Button("Delete");
        deletePersona.setMinWidth(30);

        openReport = new Button("Open Report");
        openReport.setMinWidth(90);

        Bimport=new Button("import");
        Bimport.setMinWidth(30);

        Export=new Button("Export");
        Export.setMinWidth(30);
    }

    private void setupTable() {
        //Name column
        TableColumn<Persona, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMaxWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Name column
        TableColumn<Persona, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setMaxWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //Name column
        TableColumn<Persona, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setMaxWidth(200);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Persona, String> affiliationColumn = new TableColumn<>("Afiliacion");
        affiliationColumn.setMaxWidth(200);
        affiliationColumn.setCellValueFactory(new PropertyValueFactory<>("afiliacion"));

        TableColumn<Persona, String> SectorColumn = new TableColumn<>("Sector");
        SectorColumn.setMaxWidth(200);
        SectorColumn.setCellValueFactory(new PropertyValueFactory<>("sector"));

        TableColumn<Persona, String> contactColumn = new TableColumn<>("Contacto");
        contactColumn.setMaxWidth(200);
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contacto"));

        TableColumn<Persona, String> estratoColumn = new TableColumn<>("Estrato");
        estratoColumn.setMaxWidth(200);
        estratoColumn.setCellValueFactory(new PropertyValueFactory<>("estrato"));

        TableColumn<Persona, String> sangreColumn = new TableColumn<>("Sangre");
        sangreColumn.setMaxWidth(200);
        sangreColumn.setCellValueFactory(new PropertyValueFactory<>("sangre"));

        TableColumn<Persona, String> entidadColumn = new TableColumn<>("Entidad");
        entidadColumn.setMaxWidth(200);
        entidadColumn.setCellValueFactory(new PropertyValueFactory<>("entidad"));



        SectorColumn.setVisible(false);
        contactColumn.setVisible(false);
        ageColumn.setVisible(false);
        estratoColumn.setVisible(false);
        sangreColumn.setVisible(false);

        //Table
        personasTable = new TableView<>();
        personasTable.getColumns().addAll(nameColumn, lastNameColumn, ageColumn,affiliationColumn,SectorColumn,contactColumn,estratoColumn,sangreColumn,entidadColumn);
    }

    private void setupInputs() {
        nameInput = new TextField();
        nameInput.setPromptText("Nombre");
        nameInput.setMinWidth(30);

        lastNameInput = new TextField();
        lastNameInput.setPromptText("Apellido");
        lastNameInput.setMinWidth(30);

        ageInput = new TextField();
        ageInput.setPromptText("Edad");
        ageInput.setMinWidth(30);

        sectorInput=new TextField();
        sectorInput.setPromptText("Sector");
        sectorInput.setMinWidth(30);

        contactoInput=new TextField();
        contactoInput.setPromptText("Contacto");
        contactoInput.setMinWidth(30);

        sangreInput=new TextField();
        sangreInput.setPromptText("Sangre");
        sangreInput.setMinWidth(30);

        entidadInput=new TextField();
        entidadInput.setPromptText("Entidad");
        entidadInput.setMinWidth(30);

        estratoInput=new TextField();
        estratoInput.setPromptText("Estrato");
        estratoInput.setMinWidth(30);

        afiliacionInput=new TextField();
        afiliacionInput.setPromptText("Afiliacion");
        afiliacionInput.setMinWidth(30);
    }

   

    public static void main(String[] args) {
        launch(args);
    }
}
