/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awa.pkg08;

import awa.pkg08.Repas;
import java.time.DayOfWeek;
import java.time.LocalDate;
 
import javafx.application.Application;
import javafx.collections.FXCollections;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author etudiant
 */
public class AWA08 extends Application {
    
    
    
    public TextArea textAreaPAF= new TextArea();
    
    
         private Callback<DatePicker, DateCell> getDayCellFactory() {
 
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
 
            @Override
            public DateCell call(final DatePicker date) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
 
                        LocalDate lendemain = LocalDate.now().plusDays(1);
                        if (empty||item.compareTo(lendemain)<0){
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        return dayCellFactory;
    }

    public void start(Stage primaryStage) throws Exception {
        

        
        GridPane root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(25);
        root.setVgap(15);

        Label Evaluer = new Label("Veuillez noter le repas :");
        Label nbCouvert = new Label("Nombre de couverts :");
        Label Note= new Label("Note :");
       

        ToggleGroup radio = new ToggleGroup();
        
        RadioButton matin = new RadioButton();
       
        matin.setText("Matin");
        
        matin.setToggleGroup(radio);
       
        RadioButton soir = new RadioButton();
       
        soir.setText("Soir");
        
        soir.setToggleGroup(radio);
       
        
        
        Spinner<Integer> nbCouvertSpinner = new Spinner<Integer>();
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory( 0 ,5, 2);
        valueFactory.setValue(3);
        
        nbCouvertSpinner.setValueFactory(valueFactory);
        
        
        
      
       
        
        
        CheckBox cBio = new CheckBox("Bio");
        cBio.setIndeterminate(false);

        CheckBox cVegan = new CheckBox("Vegan");
        cBio.setIndeterminate(false);
        
        
        
        
        String specialite[] = 
                   { "Mexicaine", "Allemande", "Asiatique", 
                                    "Française", "Autre" }; 
  
        // Create a combo box 
        ComboBox combo_box = 
                     new ComboBox(FXCollections 
                                 .observableArrayList(specialite)); 
  
        
        
        
        Button Valider = new Button("Valider");
        Button Annuler = new Button("Annuler");
        Annuler.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                textAreaPAF.setText("");
//                note0.setSelected(true);
            }
        });
        Valider.setOnAction(new EventHandler<ActionEvent>() {
           
           
            @Override
            public void handle(ActionEvent event) {
//                EvaluationRepas leRepas= new EvaluationRepas(Integer.parseInt(radio.getSelectedToggle().getUserData().toString().trim()),TACom.getText());
                Alert dlgNok = new Alert (Alert.AlertType.INFORMATION);
                dlgNok.setTitle("Comfirmation");
                dlgNok.setHeaderText("Vous avez bien evalué votre repas");
//                dlgNok.setContentText("Note:"+leRepas.getNote()+" Commentaire:"+leRepas.getCommentaire());
                dlgNok.showAndWait();
            }
               
               
        });
       
 
        GridPane.setHalignment(Evaluer, HPos.RIGHT);
        root.add(Evaluer, 0, 0);
        GridPane.setHalignment(nbCouvert, HPos.LEFT);
        root.add(nbCouvert, 0, 1);
        root.add(textAreaPAF, 0,2,6,1);


        root.add(matin, 0, 3);
        root.add(soir, 1, 3);

        root.add(nbCouvertSpinner, 1, 1);
        
        root.add(cBio, 0 , 4);
        root.add(cVegan, 1 , 4);
        
        root.add(combo_box, 0,5);
        
        root.add(Valider, 1, 6);
        root.add(Annuler, 0, 6);
        Scene scene = new Scene(root, 600, 300);
        primaryStage.setTitle("AWA_08");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 /**private Callback<DatePicker, DateCell> getDayCellFactory() {
 
        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
 
            @Override
            public DateCell call(final DatePicker datePicker) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
 
                        
                        // Disable Monday, Tueday, Wednesday.
                        LocalDate today = LocalDate.now();
                                
                        if (empty || item.compareTo(today) < 0) //
 {
                            setDisable(true);
                            setStyle("-fx-background-color: #ffc0cb;");
                        }
                    }
                };
            }
        };
        return dayCellFactory;
    }
 
    @Override
    public void start(Stage stage) {
 
        DatePicker datePicker = new DatePicker();
        datePicker.setValue(LocalDate.now());
        datePicker.setShowWeekNumbers(true);
  
        // Factory to create Cell of DatePicker
        Callback<DatePicker, DateCell> dayCellFactory= this.getDayCellFactory();
        datePicker.setDayCellFactory(dayCellFactory);
 
        
        FlowPane root = new FlowPane();
        root.getChildren().add(datePicker);
        root.setPadding(new Insets(10));
 
        stage.setTitle("test");
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
}
* 
*/
