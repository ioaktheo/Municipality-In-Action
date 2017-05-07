/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipality;

import database.DbLinker;
import database.Event;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ThePs
 */
public class EventFXMLController implements Initializable {

    @FXML
    Button submitButton;
    @FXML
    Button backButton;
    @FXML
    TextField titleArea;
    @FXML
    TextField locationArea;
    @FXML
    TextField typeArea;
    @FXML
    TextArea descriptionArea;

    /*------ Database Connection -------*/
    DbLinker connectivity;
    /*------ Event details -------*/
    Event saveEvent;

    @FXML
    public void sumbitEvent(ActionEvent event) {
        saveEvent.setTitle(titleArea.getText().trim());
        saveEvent.setEventLocation(locationArea.getText().trim());
        saveEvent.setType(typeArea.getText().trim());
        saveEvent.setDescription(descriptionArea.getText().trim());
        
        if (!"".equals(saveEvent.getTitle().trim())){
        try {
            String query = "INSERT INTO events" + "(title,event_type,location,description)" + "VALUES('" + saveEvent.getTitle() + "','" + saveEvent.getType() + "','" + saveEvent.getEventLocation() + "','" + saveEvent.getDescription() + "')";
            connectivity.getSt().executeUpdate(query);
            System.out.println("successfull insert \n");
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        }else{
            titleArea.requestFocus();
        }
    }
    
    @FXML
    public void goBack(ActionEvent event) throws IOException{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connectivity = new DbLinker();
        saveEvent = new Event();
    }

}
