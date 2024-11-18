package application;

import java.util.ArrayList;
import java.util.Comparator;


import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;


public class MainSceneController implements Initializable{
	public static char role;
    @FXML
    private ChoiceBox<Character> lettera;
    @FXML
    private RadioButton a;

    @FXML
    private RadioButton c;
    @FXML
    private RadioButton p;

    @FXML
    private RadioButton d;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    static char l;
    static int[] budget= {500,500,500,500,500,500,500,500,500,500,500};
    static int[][]giocatori= {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
    static ArrayList <giocatore> portieri;
    static ArrayList <giocatore> difensori;
    static ArrayList <giocatore> centrocampisti;
    static ArrayList <giocatore> attaccanti;
    static ArrayList<Integer> red;
    static ArrayList<Integer> yellow;
    static ArrayList<Integer> green;

	    @FXML
	    void changec(ActionEvent event) {
	    	role='c';
	    }
	    @FXML
	    void changea(ActionEvent event) {
	    	role='a';
	    }

	    @FXML
	    void changed(ActionEvent event) {
	    	role='d';
	    }
	    

	    @FXML
	    void changep(ActionEvent event) {
	    	role='p';
	    }
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			lettera.getItems().addAll('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
			readfromfile();
			System.out.println("ciao");
		}
		@FXML	
		public void switchToScene1(ActionEvent event) throws IOException  {
			
			//try
			//{
					
					l=lettera.getValue();
					FXMLLoader loader= new FXMLLoader(getClass().getResource("giocatori.fxml"));
					 root = (Parent)loader.load();
					 //giocatoriController gc= loader.getController();
					 //gc.pass(lettera.getValue());
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
				
			//}
			//catch(IOException|NullPointerException e1)
			//{
				//System.out.println("Inserire valori validi per ruolo e lettera");
			//}
			
			
 }
		public void readfromfile() 
	    {
			portieri=new ArrayList<>();
			centrocampisti=new ArrayList<>();
			difensori=new ArrayList<>();
			attaccanti=new ArrayList<>();
			red=new ArrayList<>();
			yellow=new ArrayList<>();
			green=new ArrayList<>();
			int rosso=0;
			int giallo=0;
			int verde=0;
			giocatore aux=new giocatore();
	    	int i=0;
	    	int j=0;
	    	int first=0;
	    	try 
	    	{
	    	      File myObj = new File("calciatori.txt");
	    	      Scanner myReader = new Scanner(myObj);
	    	      while (myReader.hasNext()) 
	    	      {
	    	    	  
	    	        String data = myReader.next();
	    	        if(data.equals("P"))
	    	        {
	    	        	portieri.add(new giocatore(aux));
	    	        	j=0;
	    	        }
	    	        else if (data.equals("D"))
	    	        {
	    	        	difensori.add(new giocatore(aux));
	    	        		
	    	        	if(j==0) 
	    	        	{
	    	        		if(aux.importanza.equals("rosso"))
    	        			{
    	        				rosso--;
    	        				red.add(rosso);
    	        				yellow.add(giallo);
    	    	        		green.add(verde);
    	        				rosso=1;
    	        				giallo=0;
    	        				verde=0;
    	        			}
    	        		if(aux.importanza.equals("giallo"))
    	        		{
	        				giallo--;
	        				red.add(rosso);
	        				yellow.add(giallo);
	    	        		green.add(verde);
	        				giallo=1;
	        				rosso=0;
	        				verde=0;
	        			}
    	        		if(aux.importanza.equals("verde"))
    	        		{
	        				verde--;
	        				red.add(rosso);
	        				yellow.add(giallo);
	    	        		green.add(verde);
	        				verde=1;
	        				giallo=0;
	        				rosso=0;
    	        		}
	    	        	j=1;
	    	        }
	    	        	
	    	        }
	    	        else if(data.equals("C"))
	    	        {
	    	        	centrocampisti.add(new giocatore(aux));
	    	        	if(j==1)
	    	        	{
	    	        		if(aux.importanza.equals("rosso"))
	    	        			{
	    	        				rosso--;
	    	        				red.add(rosso);
	    	        				yellow.add(giallo);
	    	    	        		green.add(verde);
	    	        				rosso=1;
	    	        				giallo=0;
	    	        				verde=0;
	    	        			}
	    	        		if(aux.importanza.equals("giallo"))
	    	        		{
    	        				giallo--;
    	        				red.add(rosso);
    	        				yellow.add(giallo);
    	    	        		green.add(verde);
    	        				giallo=1;
    	        				rosso=0;
    	        				verde=0;
    	        			}
	    	        		if(aux.importanza.equals("verde"))
	    	        		{
    	        				verde--;
    	        				red.add(rosso);
    	        				yellow.add(giallo);
    	    	        		green.add(verde);
    	        				verde=1;
    	        				giallo=0;
    	        				rosso=0;
	    	        		}
	    	        		j=2;
	    	        	}
	    	        		    	        
	    	        }
	    	        else if(data.equals("A"))
	    	        {
	    	        	attaccanti.add(new giocatore(aux));
	    	        	if(j==2) {
	    	        		if(aux.importanza.equals("rosso"))
    	        			{
    	        				rosso--;
    	        				red.add(rosso);
    	        				yellow.add(giallo);
    	    	        		green.add(verde);
    	        				rosso=1;
    	        				giallo=0;
    	        				verde=0;
    	        			}
    	        		if(aux.importanza.equals("giallo"))
    	        		{
	        				giallo--;
	        				red.add(rosso);
	        				yellow.add(giallo);
	    	        		green.add(verde);
	        				giallo=1;
	        				rosso=0;
	        				verde=0;
	        			}
    	        		if(aux.importanza.equals("verde"))
    	        		{
	        				verde--;
	        				red.add(rosso);
	        				yellow.add(giallo);
	    	        		green.add(verde);
	        				verde=1;
	        				giallo=0;
	        				rosso=0;
    	        		}
	    	        		j=3;
	    	        	}
	    	        }
	    	    	else if(data.equals("rosso") || data.equals("verde")|| data.equals("giallo"))
	    	    	 {
	    	    	    	aux.importanza=data;
	    	    	    	if(data.equals("rosso"))
	    	    	    	{
	    	    	    		rosso++;
	    	    	    	}
	    	    	    		
	    	    	    	if(data.equals("verde"))
	    	    	    		{
	    	    	    		verde++;
	    	    	    		}
	    	    	    	if(data.equals("giallo"))
	    	    	    		{
	    	    	    			giallo++;
	    	    	    		}
	    	    	 }
	    	    	       else if(checkint(data)!=0)
	    	    	 {
	    	    	    	   aux.costo=checkint(data);
	    	    	 }else 
	    	    	 {
	    	    		 aux.nome=data;
	    	    		
	    	    	 }	    	
	    	        		
	    	    }
	    	      myReader.close();
	    	      red.add(rosso);
	        		yellow.add(giallo);
	        		green.add(verde);
	        		
	    	      
	    	}catch (FileNotFoundException e) {
	    	      System.out.println("An error occurred.");
	    	      e.printStackTrace();
	    	    }
	    	
	    }
	    	
		public int checkint(String data) {
			 int i;
		    	try {
				    i= Integer.parseInt(data);
				    return i;
				} catch (NumberFormatException e) {
				    return 0;
				}
		}
}