package juego;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;

import listas.ListaInt;

public class ManejoDeArchivos {
	
	
	@SuppressWarnings("unused")
	private static int record;
	
	
	ManejoDeArchivos()
	{
		record = 0;
		
	}
		    
	    public static ListaInt guardarLista(String archivo) throws FileNotFoundException, IOException
	    {	
	    	
	    	ListaInt lista = new ListaInt();
	    	String cadena;
	    	FileReader f = new FileReader(archivo);
	    	BufferedReader b = new BufferedReader(f);
	    	while((cadena = b.readLine()) != null) 
	    	{
	    		int punto = Integer.parseInt(cadena);
	    		lista.agregarAdelante(punto);
	    		
				

	    		
	    	}
	    	b.close();
	    	return lista;
	    }

	    
	    public static int record(ListaInt lista) 
	    {
	    	record = lista.maximo();
	    	return lista.maximo();
	    }
	    
	    public static void escribir(String puntajes)
	    {
	    	try {
	            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
	            File archivo = new File("puntaje.txt");

	            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
	            FileWriter escribir = new FileWriter(archivo, true);


	            //Escribimos en el archivo con el metodo write 
	            

	            escribir.write(puntajes);
	            escribir.write("\r\n"); 

	            //Cerramos la conexion
	            escribir.close();
	        } //Si existe un problema al escribir cae aqui
	        catch (Exception e) {
	            System.out.println("Error al escribir");
	        }
	  
	}
	    
	
	    
	
	   
}
