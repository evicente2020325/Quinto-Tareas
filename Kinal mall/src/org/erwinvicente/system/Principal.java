package org.erwinvicente.system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import org.erwinvicente.controller.AdministracionController;
import org.erwinvicente.controller.AutorController;
import org.erwinvicente.controller.MenuPrincipalController;


/**
 *
 * @author esteb
 */


public class Principal extends Application{
    private Stage escenarioPrincipal;
    private Scene escena;
    private final String PAQUETE_VIEW = "/org/erwinvicente/view/";
    private final String PAQUETE_IMAGES = "org/erwinvicente/resouce/images/";
    private final String PAQUETE_CSS = "org/erwinvicente/resouce/css/";
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.escenarioPrincipal = stage;
        stage.getIcons().add(new Image(PAQUETE_IMAGES+"iconoMall.jpg"));
        mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal () {
        try {
                   MenuPrincipalController menuController = (MenuPrincipalController)cambiarEscena("MenuPrincipalView.fxml", 890, 500);
                   menuController.setEscenarioPrincipal(this);
        }        catch (IOException e) {
            System.out.println("Se produjo un error al mostrar la vista del menu principal");
            e.printStackTrace();
            
        }   
    }
    public void mostrarAutor () {
        try {
            AutorController autorController = (AutorController) cambiarEscena("AutorView.fxml", 600, 400);
            autorController.setEscenarioPrincipal(this);
        } catch (IOException e){
            System.out.println("Se produjo un error al mostrar la vista autor");
            e.printStackTrace();
        }
        
    }
    public Initializable cambiarEscena(String fxml,int ancho, int alto) throws IOException{
        Initializable resultado = null;
        
        FXMLLoader cargadorFXML = new FXMLLoader();
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VIEW + fxml));
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VIEW + fxml);
        escena = new Scene((AnchorPane)cargadorFXML.load(archivo), ancho, alto);
        escena.getStylesheets().add(PAQUETE_CSS + "estiloKinalMall.css");
        
        this.escenarioPrincipal.setScene(escena);
        this.escenarioPrincipal.show();
        this.escenarioPrincipal.sizeToScene();
        this.escenarioPrincipal.setResizable(false);
        resultado = (Initializable) cargadorFXML.getController();
        return resultado; 
    }
    public void mostrarAdministracion(){
        try {
          AdministracionController adminController = (AdministracionController)cambiarEscena("AdministracionView.fxml", 890, 500);
          adminController.setEscenarioPrincipal(this);
        }catch (Exception e){
            System.out.println("Se produjo un erro al mostrar la vista administracion");
            e.printStackTrace();
            
        }
    
            }
    
}
