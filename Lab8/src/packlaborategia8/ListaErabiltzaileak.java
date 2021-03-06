package packlaborategia8;


import java.util.ArrayList;
import java.util.Iterator;

public class ListaErabiltzaileak
{
	// atributuak
	private static ListaErabiltzaileak nireListaErabiltzaileak = null;
	private ArrayList<Erabiltzailea>lista;
	
	// eraikitzailea
	
    private ListaErabiltzaileak()
    { 
    	this.lista = new ArrayList<Erabiltzailea>();
    }
   	
    // beste metodoak
    
   	public static ListaErabiltzaileak getListaErabiltzaileak()
   	{
   		if (nireListaErabiltzaileak == null)
   		{
   			nireListaErabiltzaileak = new ListaErabiltzaileak();
   		}
   		return nireListaErabiltzaileak;
   	}
	public int erabiltzaileKopurua()
   	{
		return(this.lista.size());
   	}
   	private Iterator<Erabiltzailea> getIteradorea()
   	{
   		return this.lista.iterator();
   	}
   	public Erabiltzailea bilatuErabiltzaileaIdz(int pId)
   	{
   		try
   		{
	   		boolean salataria = false;
	   		Erabiltzailea e = null;
	   		Iterator<Erabiltzailea>itr = this.getIteradorea();
	   		while (itr.hasNext()&& !salataria)
	   		{
	   			e = itr.next();
	   			if(e.idHauDu(pId))
	   			{
	   				salataria = true;
	   			}
	   		}
	   		if (!salataria)
	   		{
	   			throw new Exception();
	   		}
	   		return e;
   		}
   		catch (Exception e)
   		{
   			System.out.println("Ez dago id hori duen erabiltzailerik");
   			return null;
   		}
   	}
   	public boolean badagoIdBerdinekoErabiltzailerik(Erabiltzailea pErabiltzailea)
   	{
   		Erabiltzailea e = null;
   		Iterator<Erabiltzailea>itr = this.getIteradorea();
   		boolean salataria = false;
   		while (itr.hasNext() && !salataria)
   		{
   			e = itr.next();
   			if (e.idBerdinaDute(pErabiltzailea))
   			{
   				salataria = true;
   			}
   		}
   		return salataria;
   	}
   	public void erabiltzaileariAltaEman(Erabiltzailea pErabiltzailea)
   	{   		
   		if (!this.lista.contains(pErabiltzailea))
   		{
   			this.lista.add(pErabiltzailea);
   		}
   	}
	public void erabiltzaileaBajaEman(int pIdErabiltzailea)
	{
		Erabiltzailea e = this.bilatuErabiltzaileaIdz(pIdErabiltzailea);
		if (e != null)
		{
			this.lista.remove(e);
			System.out.println(e.getIzena()+" erabiltzailea ondo eman da BAJAN");
		}
	}
   	public Erabiltzailea norkDaukaMaileguan(Liburua pLiburu)
   	{
   		Iterator <Erabiltzailea> itr = this.getIteradorea();
   		Erabiltzailea er = null;
   		boolean salataria = false;
   		while (itr.hasNext() && !salataria)
   		{
   			er = itr.next();
   			if (er.maileguanDu(pLiburu))
   			{
   				return er;
   			}
   		}
   		er = null;
   		return er;
   	}
   	public void inprimatu()
   	{	
   		System.out.println(this.lista.size()+" Erabiltzaile");
   		Iterator <Erabiltzailea> itr = this.getIteradorea();
   		while (itr.hasNext())
   		{
   			Erabiltzailea e = itr.next();
   			e.inprimatu();
   		}
   	}
   	public void erreseteatu()
   	{
   		this.lista.clear();   	
   	}
}
