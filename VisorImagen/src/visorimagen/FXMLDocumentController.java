/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visorimagen;

import com.jfoenix.controls.JFXButton;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.StrokeType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Jose Pablo Bermudez
 */
public class FXMLDocumentController implements Initializable {

    private FileChooser fileChooser;
    static public File filePath1;
    @FXML
    private AnchorPane root;
    @FXML
    private Button button;
    @FXML
    private Label Titulo;
    @FXML
    private AnchorPane root1;

    @FXML
    private void handleButtonAction(ActionEvent event) throws FileNotFoundException, IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Txt");
        //Para que se ponga en el directorio de documentos del usuario apenas lo abra
        String userDirectoryString = System.getProperty("user.home") + "\\Documents";
        File userDirectory = new File(userDirectoryString);

        if (!userDirectory.canRead()) {
            userDirectory = new File("c:/");
        }

        fileChooser.setInitialDirectory(userDirectory);
        this.filePath1 = fileChooser.showOpenDialog(stage);
        /*
         *   posiciones iniciales de la imagen a leer
         */
        int x = 0;
        int y = 0;
        /*
         *    filePath1 contiene la dirección seleccionada por el usuario
         *    y se valida porque si no se cae si el usuario no selecciona un archivo
         */
        if (filePath1 != null) {
            File f = new File(filePath1.toString());
            FileReader fr = new FileReader(f);   //crea el objeto File Reader 
            BufferedReader br = new BufferedReader(fr);  //creación del objeto BufferedReader
            int c = 0;
            while ((c = br.read()) != -1) //Leer caracter por caracter
            {
                //se convierte de integer a caracter
                char character = (char) c;
                /*
                 *  Dependiendo de que caracter nos encontremos dibuja un color diferente de rectangulo
                 *  de debe de ajustar el tamaño de los rectangulos dependiendo del tamaño de la matriz de texto
                 */
                if (c == 'F') {
                    javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(x, y, 20, 20);
                    rec.setStrokeType(StrokeType.OUTSIDE);
                    rec.setStroke(Paint.valueOf("gray"));
                    rec.setStrokeWidth(0.1);
                    rec.setFill(Paint.valueOf("gray"));
                    root1.getChildren().add(rec);
                    x += 20;
                }
                if (c == '1') {
                    javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(x, y, 20, 20);
                    rec.setStrokeType(StrokeType.OUTSIDE);
                    rec.setStroke(Paint.valueOf("BLUE"));
                    rec.setStrokeWidth(0.1);
                    rec.setFill(Paint.valueOf("BLUE"));
                    root1.getChildren().add(rec);
                    x += 20;
                }
                if (c == '2') {
                    javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(x, y, 20, 20);
                    rec.setStrokeType(StrokeType.OUTSIDE);
                    rec.setStroke(Paint.valueOf("GREEN"));
                    rec.setStrokeWidth(0.1);
                    rec.setFill(Paint.valueOf("GREEN"));
                    root1.getChildren().add(rec);
                    x += 20;
                }
                if (c == '4') {
                    javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(x, y, 20, 20);
                    rec.setStrokeType(StrokeType.OUTSIDE);
                    rec.setStroke(Paint.valueOf("RED"));
                    rec.setStrokeWidth(0.1);
                    rec.setFill(Paint.valueOf("RED"));
                    root1.getChildren().add(rec);
                    x += 20;
                }
                if (c == '5') {
                    javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(x, y, 20, 20);
                    rec.setStrokeType(StrokeType.OUTSIDE);
                    rec.setStroke(Paint.valueOf("PURPLE"));
                    rec.setStrokeWidth(0.1);
                    rec.setFill(Paint.valueOf("PURPLE"));
                    root1.getChildren().add(rec);
                    x += 20;
                }
                if (c == '6') {
                    javafx.scene.shape.Rectangle rec = new javafx.scene.shape.Rectangle(x, y, 20, 20);
                    rec.setStrokeType(StrokeType.OUTSIDE);
                    rec.setStroke(Paint.valueOf("BROWN"));
                    rec.setStrokeWidth(0.1);
                    rec.setFill(Paint.valueOf("BROWN"));
                    root1.getChildren().add(rec);
                    x += 20;
                }
                if (c == '@') {
                    y += 20;
                    x = 0;
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(1);
    }

}
