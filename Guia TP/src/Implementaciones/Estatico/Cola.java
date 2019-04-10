package Implementaciones.Estatico;

import Api.ColaTDA;

public class Cola implements ColaTDA {
	
	private int [] v;
	private int ult;
	
	@Override
	public void InicializarCola() {
		ult = 0;
		v = new int [100];
	}

	@Override
	public void Acolar(int x) {
		v[ult] = x;
		ult++;
	}

	@Override
	public void Desacolar() {
		for (int i = 0; i<ult-1; i++)
			v[i] = v[i+1];
		ult--;
	}

	@Override
	public boolean ColaVacia() {
		return ult==0;
	}

	@Override
	public int Primero() {
		return v[0];
	}

}
