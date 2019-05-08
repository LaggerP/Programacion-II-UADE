package Implementaciones.Dinamico;

import Api.ColaTDA;

public class Cola implements ColaTDA {
	
	class nodo{
		int valor;
		nodo sig;
	}

	nodo inicio;
	
	@Override
	public void Acolar(int x) {
		nodo nuevo = new nodo();
		nuevo.valor = x;
		if (inicio == null) { //lista vacia o primer nodo
			nuevo.sig = inicio;
			inicio = nuevo;
		}else {
			nodo anterior = null, actual = inicio;
			while (actual!= null) {
				anterior = actual;
				actual = actual.sig;
				
			}
			nuevo.sig = actual;
			anterior.sig = nuevo;
		}
	}

	@Override
	public void Desacolar() {
		inicio = inicio.sig;

	}

	@Override
	public int Primero() {
		return inicio.valor;
	}

	@Override
	public boolean ColaVacia() {
		return inicio == null;
	}

	@Override
	public void InicializarCola() {
		inicio = null;
	}

}
