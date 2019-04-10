package Implementaciones.Dinamico;

import Api.ColaPrioridadTDA;


public class ColaPrioridad implements ColaPrioridadTDA {

	class nodo{
		int prioridad;
		int valor;
		nodo sig;
	}

	nodo inicio;
	
	@Override
	public void acolarPrioridad(int p, int x) {
		nodo nuevo = new nodo();
		nuevo.prioridad = p;
		nuevo.valor = x;
		if (inicio == null || p>inicio.prioridad) { //lista vacia o primer nod
			nuevo.sig = inicio;
			inicio = nuevo;
		}else {
			nodo anterior = null, actual = inicio;
			while (actual!= null && p<=actual.prioridad) {
				anterior = actual;
				actual = actual.sig;
				
			}
			nuevo.sig = actual;
			anterior.sig = nuevo;
		}
	}

	@Override
	public void desacolar() {
		inicio = inicio.sig;

	}

	@Override
	public int primero() {
		return inicio.valor;
	}

	@Override
	public int prioridad() {
		return inicio.prioridad;
	}

	@Override
	public boolean colaVacia() {
		return inicio == null;
	}

	@Override
	public void inicializarCola() {
		inicio = null;
	}

}
