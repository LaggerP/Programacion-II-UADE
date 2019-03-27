package Implementaciones.Estatico;

import Api.ColaTDA;

public class Cola implements ColaTDA {
	
	private int [] v;
	private int ult;
	
	@Override
	public void InicializarCola() {
		// TODO Auto-generated method stub
		ult = 0;
		v = new int [100];
	}

	@Override
	public void Acolar(int x) {
		// TODO Auto-generated method stub
		v[ult] = x;
		ult++;
	}

	@Override
	public void Desacolar() {
		// TODO Auto-generated method stub
		for (int i = 0; i<ult-1; i++)
			v[i] = v[i+1];
		ult--;
	}

	@Override
	public boolean ColaVacia() {
		// TODO Auto-generated method stub
		return ult==0;
	}

	@Override
	public int Primero() {
		// TODO Auto-generated method stub
		return v[0];
	}

}
