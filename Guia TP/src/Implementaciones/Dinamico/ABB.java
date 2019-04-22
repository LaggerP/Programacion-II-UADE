package Implementaciones.Dinamico;

import Api.ABBTDA;

public class ABB implements ABBTDA {
	
	class nodo{
		int dato;
		ABBTDA izq,der;
	}

	nodo primer;
	
	@Override
	public void inicializarArbol() {
		primer = null;
	}

	@Override
	public int raiz() {
		return primer.dato;
	}

	@Override
	public ABBTDA hijoIzq() {
		return primer.izq;
	}

	@Override
	public ABBTDA hijoDer() {
		return primer.der;
	}

	@Override
	public void agregar(int x) {
		if (arbolVacio()) {
			nodo nuevo = new nodo();
			nuevo.dato = x;
			nuevo.izq = new ABB();
			nuevo.izq.inicializarArbol();
			nuevo.der = new ABB();
			nuevo.der.inicializarArbol();
			primer = nuevo;
		}
		else if (primer.dato > x) 
			hijoIzq().agregar(x);
		else
			hijoDer().agregar(x);
	}
	
	@Override
	public void eliminar(int x) {

	}

	@Override
	public boolean arbolVacio() {
		// TODO Auto-generated method stub
		return false;
	}
}
