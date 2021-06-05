package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.MessageFormat;

public class TipodeSangreScene {

    private Stage stage;
    private Scene scene;
    private Label Menssage;

    public TipodeSangreScene()
    {
        stage = new Stage();
        setUp();


        stage.setTitle("Tipo de sangre");
        stage.setScene(scene);
        stage.show();
    }
    public void setUp()
    {
        Menssage=new Label("Debe ser un tipo de sangre válido: A+,A-, B+, B-, O+, O-, AB+, AB-");
        Menssage.setMinWidth(30);

        VBox VBoxe = new VBox();
        VBoxe.setPadding(new Insets(10, 10, 10, 10));
        VBoxe.setSpacing(10);
        VBoxe.getChildren().addAll(Menssage);

        scene = new Scene(VBoxe, 380, 80);


    }


}
