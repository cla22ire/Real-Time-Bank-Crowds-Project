/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banks;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.InputStream;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image ;
import javafx.scene.image.ImageView;
/**
 *
 * @author User
 */
public class Banks extends JApplet {
    
    private static final int JFXPANEL_WIDTH_INT = 490;
    private static final int JFXPANEL_HEIGHT_INT = 500;
    private static JFXPanel fxContainer;
    public static int function=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{

        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (Exception e) {
                }
                
                JFrame frame = new JFrame("Real-Time Banks Crowds");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JApplet applet = new Banks();
                applet.init();
                
                frame.setContentPane(applet.getContentPane());
                
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                applet.start();
            }
        });
       
    }
    
    @Override
    public void init() {
        fxContainer = new JFXPanel();
        fxContainer.setPreferredSize(new Dimension(JFXPANEL_WIDTH_INT, JFXPANEL_HEIGHT_INT));
        add(fxContainer, BorderLayout.CENTER);
        // create JavaFX scene
        Platform.runLater(new Runnable() {
            
            @Override
            public void run() {
                createScene();
                
            }
        });
    }
    
    private void createScene()  {
        
GridPane grid = new GridPane();
grid.setMinSize(500, 1000);
grid.setPadding(new Insets(40, 40, 10, 20));
grid.setVgap(10);
grid.setHgap(-225);
grid.setStyle("-fx-background-color: #ffffff;");
 try{
InputStream inStream = this.getClass().getClassLoader().getResourceAsStream("logo.jpg");
 Image image = new Image(inStream);
grid.add(new ImageView(image), 0, 0);
 }
 catch (Exception e){
     
 }


        Text bank = new Text("Bank Name:");
        Text city = new Text("City:");
        //Scene scene = new Scene(root, 400, 300, Color.WHITE);

// Lists
        ComboBox<String> bankNamesList = new ComboBox<String>();
        bankNamesList.setMaxWidth(400);
        bankNamesList.getItems().addAll("AlRajhiBank","AlEnmaBank");
        bankNamesList.setValue("Bank Name");
        ComboBox<String> cityList = new ComboBox<String>();
        cityList.getItems().addAll("Riyadh","Jeddah","Makkah");
        cityList.setMaxWidth(200);
        cityList.setValue("City");
 //grid.add(cmb, 2, 0);
 
// Lists2
grid.add(bank, 2, 5);
grid.add(bankNamesList, 1, 5);
grid.add(city, 2, 6);
grid.add(cityList, 1, 6);


        Button btn = new Button();
        btn.setText("Check Crowds");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                // Lists3

                System.out.println(""+ bankNamesList.getValue() +"\n"+cityList.getValue());
                try{
               PlaceInfo p = new PlaceInfo(bankNamesList.getValue(),cityList.getValue());
               function=1;
                
                }
                catch(Exception e){ 
                }
            }
        });
         Button btn2 = new Button();
        btn2.setText("Get Lowest Crowd");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event2) {
                // Lists4

                System.out.println(""+bankNamesList.getValue()+"\n"+cityList.getValue());
                try{
               function=2;
               LowestCrwodBranch2 l = new LowestCrwodBranch2(bankNamesList.getValue(),cityList.getValue());
                
                }
                catch(Exception e){ 
                }
            }
        });
        
        
grid.add(btn, 2, 7); 
grid.add(btn2, 1, 7); 

fxContainer.setScene(new Scene(grid));
	fxContainer.show();
        
        
    }
    
}