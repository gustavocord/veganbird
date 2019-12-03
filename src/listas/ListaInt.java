package listas;

public class ListaInt {
	
	NodoInt primero;
	
	public void agregarAdelante(int punto) 
	{
		NodoInt nuevo   = new NodoInt();
		nuevo.punto     = punto;
		nuevo.siguiente = this.primero;
		this.primero    = nuevo;
	}
	
	public void imprimir() 
	{
		NodoInt nodo = this.primero;
		System.out.print("[ ");
		while(nodo != null) 
		{
			System.out.print(nodo.punto + " ");
			nodo = nodo.siguiente;
		}
		System.out.println(" ]");
	}

	public void ordenar() 
	{
		//llama al maximo y lo pone atras de una nueva lista
	}
	public int maximo() 
	{
		NodoInt nodo = this.primero;
		int maximo = nodo.punto;
		while(nodo.siguiente != null)
		{
			nodo = nodo.siguiente;
			if(maximo < nodo.punto)
				maximo = nodo.punto;
		}
		return maximo;

	}
}
