package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class giocatoriController implements Initializable
{
    @FXML
   // private ChoiceBox<Character> lettera;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private MainSceneController m;
   // private String[] importanza;
   // private String[] nome;
    private int[] costo;
    private int rosso=0;
    private int giallo=0;
    private int verde=0;
    private int [] compratig= {0,0,0};
    private int iniziale;
    private int finale;
    private ArrayList<giocatore> calciatori;
    private ArrayList<allenatore> allenatori;
    private ArrayList<giocatore> lista;
    private int colore;
    static int aux2=0;
    @FXML
    private Button verdi;

    @FXML
    private Button rossi;
    @FXML
    private Button gialli;
    @FXML
    private Label comprati;

    @FXML
    private Button comprato;

    @FXML
    private Button conferma;

    @FXML
    private Label giocatori_rimasti;

    @FXML
    private Label importanza;

    @FXML
    private Button indietro;

    @FXML
    private ChoiceBox<Character> lettera;
    
    @FXML
    private ChoiceBox<String> allenatore;

    @FXML
    private Label milioni;
    
    @FXML
    private Label nome;

    @FXML
    private Button saltato;
    
    @FXML
    private TextField price;
    
    @FXML
    private TextField price2;
    @FXML
    private Label prezzo;
    
    static int budget=1000;
    
    private char l;
    
    private Character[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    @FXML
    public void setCalciatore(ActionEvent e)
    {
       l=lettera.getValue();
       trovacalciatore();
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
    @FXML
    public void compra()
    {
    	int aux=checkint(price.getText());
    	if(aux==0)
    	{
    		System.out.println("Inserisci prezzo");
    	}	
    	else 
    	{
    		budget=budget-aux;
        	milioni.setText(String.valueOf(budget));
        	if(calciatori.get(iniziale).importanza.equals("verde"))
    		{
    			compratig[2]++;
    		}
    		else if(calciatori.get(iniziale).importanza.equals("giallo"))
    		{
    			compratig[1]++;
    		}
    		else 
    		{
    			compratig[0]++;
    		}
        	comprati.setText("hai "+compratig[0]+" giocatori rossi "+compratig[1]+" giocatori gialli "+compratig[2]+" giocatori verdi");
        	price.setText("");
        	avanti();
    	}
    		
    }
    @FXML
    public void scarta()
    {
    	avanti();
    }

    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			lettera.getItems().addAll(alphabet);
			allenatore.getItems().addAll("ciky","Michele","Stino","Gianfranco","Mitolo","Raffaele","Gabriel","Vence","Paolo","Claudio","Ciocia");
			milioni.setText(String.valueOf(budget));
			if(MainSceneController.role=='p')
			{
				calciatori=MainSceneController.portieri;
				rosso=MainSceneController.red.get(0);
				giallo=MainSceneController.yellow.get(0);
				verde=MainSceneController.green.get(0);
			}
			else if(MainSceneController.role=='d')
			{
				calciatori=MainSceneController.difensori;
				rosso=MainSceneController.red.get(1);
				giallo=MainSceneController.yellow.get(1);
				verde=MainSceneController.green.get(1);
			}
			else if(MainSceneController.role=='c')
			{
				calciatori=MainSceneController.centrocampisti;
				rosso=MainSceneController.red.get(2);
				giallo=MainSceneController.yellow.get(2);
				verde=MainSceneController.green.get(2);
			}
			else if(MainSceneController.role=='a')
			{
				
				calciatori=MainSceneController.attaccanti;
				rosso=MainSceneController.red.get(3);
				giallo=MainSceneController.yellow.get(3);
				verde=MainSceneController.green.get(3);
			}
			l=MainSceneController.l;
			giocatori_rimasti.setText("Ti rimangono "+rosso+" giocatori rossi "+giallo+" giocatori gialli "+verde+"giocatori verdi");
		/*	for(int i=0;i<calciatori.size();i++)
			{
				System.out.println(calciatori.get(i).nome);
			}
			*/	
			trovacalciatore();
				
		}
    void trovacalciatore()
    {
    	int i=0;
    	while(i<calciatori.size() && calciatori.get(i).nome.startsWith(String.valueOf(l))==false)
    	{
    		i++;
    	}
    	if(i<calciatori.size())
    	{
    		iniziale=i;
    		nome.setText(calciatori.get(iniziale).nome);
    		importanza.setText(calciatori.get(iniziale).importanza);
    		prezzo.setText(String.valueOf(calciatori.get(iniziale).costo));
    		calciatori.get(iniziale).visto=true;
    	}
    		
    	else 
    	{
    		iniziale=-1;
    		nome.setText("Non ci sono giocatori con questo nome");
    	}
    	
    }
    void pass(char aux)
    {
    	l=aux;
    }
    public void avanti()
    {
    	if(nome.getText().equals("FINITI,cerca un altra lettera"))
		{
			System.out.println("coglione svegliatiiii");
		}
    	else
    	{
    		if(calciatori.get(iniziale).importanza.equals("verde"))
    		{
    			verde--;
    		}
    		else if(calciatori.get(iniziale).importanza.equals("giallo"))
    		{
    			giallo--;
    		}
    		else 
    		{
    			rosso--;
    		}
    		giocatori_rimasti.setText("Ti rimangono "+rosso+" giocatori rossi "+giallo+" giocatori gialli "+verde+" giocatori verdi");
    	
    		/*if(iniziale+1==calciatori.size() || calciatori.get(iniziale+1).nome.startsWith(String.valueOf(l))==false)//questa è la parte da mettere per il fantacalcio di dario
    		{
    			nome.setText("FINITI,cerca un altra lettera");
    			int i=0;
        		System.out.println(alphabet.length);
        		while(i<alphabet.length)
        			{
        				if(alphabet[i]==l)
        				{
        					while(i+1<alphabet.length)
        						{
        						alphabet[i]=alphabet[i+1];
        						i++;
        						}
        				}
        				i++;
        			}
        		Character[] array2 = Arrays.copyOfRange(alphabet, 0, i-1);
        		lettera.getItems().clear();
        		lettera.getItems().addAll(array2);
        		alphabet=array2;
    		}*/
    		if(iniziale+1==calciatori.size())//questa parte è stata messa per il vezapp
			{
				iniziale=0;
				nome.setText(calciatori.get(iniziale).nome);
	    		importanza.setText(calciatori.get(iniziale).importanza);
	    		prezzo.setText(String.valueOf(calciatori.get(iniziale).costo));
	    		calciatori.get(iniziale).visto=true;
			}
    		
    		else
    		{
    			if(calciatori.get(iniziale+1).visto)
        		{
        			System.out.println("Cambia ruolo");
        		}
    			//if(calciatori.get(iniziale+1).nome.startsWith(String.valueOf(l)))
    	    	//{
    			else //questo è l else per dario
    			{
    	    		nome.setText(calciatori.get(iniziale+1).nome);
    	    		importanza.setText(calciatori.get(iniziale+1).importanza);
    	    		prezzo.setText(String.valueOf(calciatori.get(iniziale+1).costo));
    	    		calciatori.get(iniziale).visto=true;
    	    		iniziale++;
    			}
    	    	//}
    	    	//else 
    	    		//{
    	    			//nome.setText("FINITI,cerca un altra lettera");
    	        	/*	int i=0;
    	        		System.out.println(alphabet.length);
    	        		while(i<alphabet.length)
    	        			{
    	        				if(alphabet[i]==l)
    	        				{
    	        					while(i+1<alphabet.length)
    	        						{
    	        						alphabet[i]=alphabet[i+1];
    	        						i++;
    	        						}
    	        				}
    	        				i++;
    	        			}
    	        		Character[] array2 = Arrays.copyOfRange(alphabet, 0, i-1);
    	        		lettera.getItems().clear();
    	        		lettera.getItems().addAll(array2);
    	        		alphabet=array2;
    	    			*/
    	    			
    	    		//}
    		}
    	
    		
    	}
    	
    		
    }
    @FXML
    public void switchToScene1(ActionEvent event) throws IOException 
    {
			
				FXMLLoader loader= new FXMLLoader(getClass().getResource("MainScene.fxml"));
				 root = (Parent)loader.load();
				  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				  
				  scene = new Scene(root);
				  stage.setScene(scene);
				  stage.show();
		
		
   /* for(int i=0;i<calciatori.size();i++)
	{
		System.out.println(calciatori.get(i).nome);
	}
	*/
    }
    @FXML
    public void panoramica()
    {
    	System.out.println("Ignazio Michele Claudio Gabriel Ciocia Mitolo Gianfranco Stino Raffaele Paolo Vincenzo");
    	for (int i=0;i<MainSceneController.budget.length;i++)
    	{
    		System.out.print(MainSceneController.budget[i]+" ");
    		System.out.print(MainSceneController.giocatori[i][aux2]+"   ");
    	}
    	
    }
    @FXML
    public void rosso()
    {
    	int i=0;
    	int j=0;
    	List<Character> list=lettera.getItems();
    	lista=null;
    	lista=new ArrayList<>();
    	while(i<calciatori.size())
    	{
    		j=0;
    		while(j<list.size())
    		{
    			if(calciatori.get(i).nome.startsWith(String.valueOf(list.get(j))) && calciatori.get(i).importanza.equals("rosso") && calciatori.get(i).visto==false)
    			{
    				lista.add(calciatori.get(i));
    			}
    			j++;
    		}
    		i++;
    	}
    	Collections.sort(lista,new SortbyValue() );
    	System.out.println();
    		for(int k=0;k<lista.size();k++)
    	{
    		System.out.print(lista.get(k).nome);
    		System.out.println(" "+lista.get(k).costo);
    	}
    	
    }
    public void giallo()
    {
    	int i=0;
    	int j=0;
    	List<Character> list=lettera.getItems();
    	lista=null;
    	lista=new ArrayList<>();
    	while(i<calciatori.size())
    	{
    		j=0;
    		while(j<list.size())
    		{
    			if(calciatori.get(i).nome.startsWith(String.valueOf(list.get(j))) && calciatori.get(i).importanza.equals("giallo")  && calciatori.get(i).visto==false)
    			{
    				lista.add(calciatori.get(i));
    			}
    			j++;
    		}
    		i++;
    	}
    	Collections.sort(lista,new SortbyValue() );
    	System.out.println();
    	for(int k=0;k<lista.size();k++)
    	{
    		System.out.print(lista.get(k).nome);
    		System.out.println(" "+lista.get(k).costo);
    	}
    }
    public void verde()
    {
    	int i=0;
    	int j=0;
    	List<Character> list=lettera.getItems();
    	lista=null;
    	lista=new ArrayList<>();
    	while(i<calciatori.size())
    	{
    		j=0;
    		while(j<list.size())
    		{
    			if(calciatori.get(i).nome.startsWith(String.valueOf(list.get(j))) && calciatori.get(i).importanza.equals("verde") && calciatori.get(i).visto==false)
    			{
    				lista.add(calciatori.get(i));
    			}
    			j++;
    		}
    		i++;
    	}
    	Collections.sort(lista,new SortbyValue() );
    	System.out.println();
    	for(int k=0;k<lista.size();k++)
    	{
    		System.out.print(lista.get(k).nome);
    		System.out.println(" "+lista.get(k).costo);
    	}
    	
    }
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException 
    {
				
    			
				FXMLLoader loader= new FXMLLoader(getClass().getResource("lista.fxml"));
				 root = (Parent)loader.load();
				  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				  
				  scene = new Scene(root);
				  stage.setScene(scene);
				  stage.show();
		
		
   /* for(int i=0;i<calciatori.size();i++)
	{
		System.out.println(calciatori.get(i).nome);
	}
	*/
    }
    @FXML
    public void acquisto_all()
    {
    	
    	int aux=checkint(price2.getText());
    	if(aux==0 || allenatore.getValue().isEmpty())
    	{
    		System.out.println("Inserire valori validi");
    	}
    	if(MainSceneController.role=='p')
    	{
    		aux2=0;
    	}
    	if(MainSceneController.role=='d')
    	{
    		aux2=1;
    	}
    	if(MainSceneController.role=='c')
    	{
    		aux2=2;
    	}
    	if(MainSceneController.role=='a')
    	{
    		aux2=3;
    	}
    	if(allenatore.getValue().equals("Ignazio"))
    	{
    		MainSceneController.budget[0]-=aux;
    		MainSceneController.giocatori[0][aux2]++;
    	}
    	if(allenatore.getValue().equals("Michele"))
    	{
    		MainSceneController.budget[1]-=aux;
    		MainSceneController.giocatori[1][aux2]++;
    	}
    	if(allenatore.getValue().equals("Claudio"))
    	{
    		MainSceneController.budget[2]-=aux;
    		MainSceneController.giocatori[2][aux2]++;
    	}
    	if(allenatore.getValue().equals("Gabriel"))
    	{
    		MainSceneController.budget[3]-=aux;
    		MainSceneController.giocatori[3][aux2]++;
    	}
    	if(allenatore.getValue().equals("Ciocia"))
    	{
    		MainSceneController.budget[4]-=aux;
    		MainSceneController.giocatori[4][aux2]++;
    	}
    	if(allenatore.getValue().equals("Mitolo"))
    	{
    		MainSceneController.budget[5]-=aux;
    		MainSceneController.giocatori[5][aux2]++;
    	}
    	if(allenatore.getValue().equals("Gianfranco"))
    	{
    		MainSceneController.budget[6]-=aux;
    		MainSceneController.giocatori[6][aux2]++;
    	}
    	if(allenatore.getValue().equals("Stino"))
    	{
    		MainSceneController.budget[7]-=aux;
    		MainSceneController.giocatori[7][aux2]++;
    	}
    	if(allenatore.getValue().equals("Raffaele"))
    	{
    		MainSceneController.budget[8]-=aux;
    		MainSceneController.giocatori[8][aux2]++;
    	}
    	if(allenatore.getValue().equals("Paolo"))
    	{
    		MainSceneController.budget[9]-=aux;
    		MainSceneController.giocatori[9][aux2]++;
    	}
    	if(allenatore.getValue().equals("Vincenzo"))
    	{
    		MainSceneController.budget[10]-=aux;
    		MainSceneController.giocatori[10][aux2]++;
    	}
    	price2.setText("");
    	avanti();
    }
    
}