package Implementaciones.Dinamico;

import Api.ConjuntoTDA;
import Api.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
	
	class nodo{
		int clave;
		nodoV inicioV;
		nodo sig;
	}
	
	class nodoV{
		int valor; 
		nodoV sig;
	}

	nodo inicio;
	
	@Override
	public void inicializarDiccionario() {
		inicio = null;
	}

	@Override
	public void agregar(int c, int x) {
		
		// insertando valores que no estan
		// en la lista primaria (lista de claves)
		nodo posCl = buscarClave(c);
		if(posCl == null) { //si no hay nodos cargados
			nodo nuevoCl = new nodo();
			nuevoCl.clave = c;
			nuevoCl.inicioV = null;
			nuevoCl.sig = inicio;
			inicio = nuevoCl;
			posCl = inicio;
		}
		
		// insertando aquellos valores que no estan
		// en la lista secundaria (lista de valores)
		nodoV posVal = buscarValor(posCl.inicioV, x);
		if (posVal == null) {
			nodoV nuevo = new nodoV();
			nuevo.valor = x;
			nuevo.sig = posCl.inicioV;
			posCl.inicioV = nuevo;
		}
	}
	
	// retorna null si la clave no existe en la lista principal
	private nodo buscarClave (int c) {
		nodo actual = inicio;
		while (actual != null && actual.clave != c)
			actual = actual.sig;
		return actual;
	}

	// retorna null si el valor no existe en la lista secundaria
	private nodoV buscarValor (nodoV inicioV, int x) {
		nodoV actual = inicioV;
		while(actual!= null && actual.valor!=x)
			actual = actual.sig;
		return actual;
	}
	
	@Override
	public void eliminar(int c) {

	}

	@Override
	public ConjuntoTDA claves() {
		return null;
	}

	@Override
	public ConjuntoTDA recuperar(int c) {
		return null;
	}

	@Override
	public void EliminarElem(int c, int x) {
		nodo posCl = buscarClave(c);
		if (posCl != null) { //si la clave existe
			nodoV anterior = null, actual = posCl.inicioV;
			
			//avance en la lista secundaria
			while (actual != null && actual.valor != x) {
				anterior = actual;
				actual = actual.sig;
			}
			if (actual != null)
				// si el valor a eliminar esta en el primer nodo de la lista
				if (anterior == null) 
					posCl.inicioV = posCl.inicioV.sig;
				// si el valor a eliminar esta entre dos nodos de la lista
				else
					anterior.sig = actual.sig;
				// en el caso de que exista un solo valor asociado a la clave
				if (posCl.inicioV == null)
					eliminar(c);
		}
	}

}
