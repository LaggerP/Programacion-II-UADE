package Implementaciones.Dinamico;

import Api.PilaTDA;

public class Pila implements PilaTDA {
	
	class nodo{
		int valor;
		nodo sig;
	}

	nodo inicio;
	
	@Override
	public void InicializarPila() {
		inicio = null;

	}

	@Override
	public void Apilar(int x) {
		nodo nuevo;
		nuevo = new nodo();
		nuevo.valor = x;
		nuevo.sig = inicio;
		inicio = nuevo;

	}

	@Override
	public void Desapilar() {
		inicio = inicio.sig;

	}

	@Override
	public int Tope() {
		return inicio.valor;
	}

	@Override
	public boolean PilaVacia() {
		return inicio == null;
	}

}
