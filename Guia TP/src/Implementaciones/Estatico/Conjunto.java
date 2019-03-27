package Implementaciones.Estatico;

import Api.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {

	private int [] v;
	private int ult;

	public void InicializarConjunto() {
		ult = 0;
		v = new int[100];
	}

	public int Elegir() {
		return v[ult-1];
	}

	public void Sacar(int x) {
		int i=0;
		while(i<ult && v[i]!=x)
			i++;
		if (i<ult) {
			v[i] = v[ult-1];
			ult--;
		}
	}

	public void Agregar(int x) {
		if(!this.Pertenece(x)) {
			v[ult]=x;
			ult++;
		}
	}

	public boolean ConjuntoVacio() {
		return ult==0;
	}
	
	public boolean Pertenece(int x) {
		int i = 0;
		while(i<ult && v[i]!=x)
			i++;
		return !(i==ult);
	}
}
