package Implementaciones.Dinamico;

import Api.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	
	class nodo{
		int valor;
		nodo sig;
	}
	
	nodo inicio;

	@Override
	public void InicializarConjunto() {
		inicio = null;
	}

	@Override
	public int Elegir() {
		return inicio.valor;
	}

	@Override
	public void Sacar(int x) {
		nodo actual = inicio, anterior = null;
		while (actual != null && actual.valor != x){
			anterior = actual;
			actual = actual.sig;
		}
		if (actual != null) {
			if(anterior == null){
				inicio = inicio.sig;
			}
			else{
				anterior.sig = actual.sig;
			}
		}
	}

	@Override
	public void Agregar(int x) {
		if(!Pertenece(x)) {
			nodo nuevo = new nodo();
			nuevo.valor = x;
			nuevo.sig = inicio;
			inicio = nuevo;
		}
	}

	@Override
	public boolean ConjuntoVacio() {
		return inicio == null;
	}

	@Override
	public boolean Pertenece(int x) {
		nodo actual = inicio;
		while(actual != null && actual.valor != x){
			actual = actual.sig;
		}
		return (actual != null);
	}

}
