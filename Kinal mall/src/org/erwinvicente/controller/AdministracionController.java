/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.erwinvicente.controller;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.erwinvicente.system.Principal;
/**
 *
 * @author esteb
 */
public class AdministracionController implements Initializable {
    
    private Principal escenarioPrincipal;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }

    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    @FXML
    private void mostrarVistaMenuPrincipal(javafx.scene.input.MouseEvent event) {
        this.escenarioPrincipal.mostrarMenuPrincipal();
    }

     
}
