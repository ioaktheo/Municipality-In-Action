/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipality;

import database.Problem;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author ThePs
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label problemsLabel;
    @FXML
    private ListView problems;
    @FXML
    ObservableList<String> items = FXCollections.observableArrayList();
    @FXML
    TextArea textArea;
    @FXML
    Label titleLabel;
    @FXML
    Label roadLabel;
    @FXML
    Label streetLabel;
    @FXML
    Button eventButton;
    @FXML
    Label selectLabel;
    @FXML
    Button exitButton;

    Problem problem = new Problem();

    private Connection connection;
    private Statement statement;
    private ResultSet result;

    @FXML
    public void catchSelection(MouseEvent event) {
        if (!textArea.isVisible()) {
            textArea.setVisible(true);
            titleLabel.setVisible(true);
            roadLabel.setVisible(true);
            streetLabel.setVisible(true);
            selectLabel.setVisible(false);
        }

        textArea.clear();

        String currentItem = problems.getSelectionModel().getSelectedItem().toString();

        try {
            String query = "select * from problem where title like '" + currentItem + "'";
            result = statement.executeQuery(query);

            while (result.next()) {
                textArea.setText(result.getString("description"));
                titleLabel.setText(result.getString("title"));
                roadLabel.setText(result.getString("road"));
                streetLabel.setText(result.getString("street_number"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    public void refreshList(ActionEvent event) throws IOException {
        if (textArea.isVisible()) {
            textArea.setVisible(false);
            titleLabel.setVisible(false);
            roadLabel.setVisible(false);
            streetLabel.setVisible(false);
            selectLabel.setVisible(true);
        }
        problems.getItems().clear();

        try {
            String query = "select * from problem";
            result = statement.executeQuery(query);

            while (result.next()) {
                String description = result.getString("title");
                items.add(description);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @FXML
    public void newEvent(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("EventFXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    public void newAnnouncement(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("AnnouncementFXML.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
    
    @FXML
    public void ExitApplication(ActionEvent event){
        System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/community", "monty", "some_pass");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }

        try {
            String query = "select * from problem";
            result = statement.executeQuery(query);

            while (result.next()) {
                String description = result.getString("title");
                items.add(description);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        problems.setItems(items);
    }

}
