package application;

import java.util.Comparator;

public class giocatore
{
	public String nome;
	public int costo;
	public String importanza;
	public boolean visto;
	public giocatore(String n,int c,String i)
	{
		nome=n;
		costo=c;
		importanza=i;
		visto=false;
	}
	public giocatore()
	{
		nome="ciao";
		costo=1;
		importanza="nulla";
		visto=false;
	}
	public giocatore(giocatore g)
	{
		nome=g.nome;
		costo=g.costo;
		importanza=g.importanza;
		visto=g.visto;
	}
}
class SortbyValue implements Comparator<giocatore>
{
	 public int compare(giocatore a, giocatore b)
	    {
		 	return b.costo-a.costo;
	    }
}