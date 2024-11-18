package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class listaController {

    @FXML
    private TextArea listac;
    private Stage stage;
    private Scene scene;
    private Parent root;
    /*
    public void settext(ArrayList<giocatore> g) 
    {
    	listac.setText(g.get(0).nome+" "+g.get(0).costo+"/n");
    	for(int k=1;k<g.size();k++)
    	{
    		listac.setText(listac.getText()+g.get(k).nome+" "+g.get(k).costo+"/n");
    	}
    	
    }*/
    @FXML
    public void switchToScene1(ActionEvent event)  {
		
		try
		{
				FXMLLoader loader= new FXMLLoader(getClass().getResource("giocatori.fxml"));
				 root = (Parent)loader.load();
				 //giocatoriController gc= loader.getController();
				 //gc.pass(lettera.getValue());
				  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				  
				  scene = new Scene(root);
				  stage.setScene(scene);
				  stage.show();
			
		}
		catch(IOException|NullPointerException e1)
		{
			System.out.println("Inserire valori validi per ruolo e lettera");
		}
		
		
    }
}
