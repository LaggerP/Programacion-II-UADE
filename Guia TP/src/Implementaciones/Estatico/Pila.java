package Implementaciones.Estatico;

import Api.PilaTDA;

public class Pila implements PilaTDA {

	private int [] v;
	private int ult;
	
	@Override
	public void InicializarPila() {
		// TODO Auto-generated method stub
		ult = 0;
		v = new int [100];
	}

	@Override
	public void Apilar(int x) {
		// TODO Auto-generated method stub
		v[ult] = x;
		ult++;
	}

	@Override
	public void Desapilar() {
		// TODO Auto-generated method stub
		ult--;
	}

	@Override
	public int Tope() {
		// TODO Auto-generated method stub
		return v[ult-1];
	}

	@Override
	public boolean PilaVacia() {
		// TODO Auto-generated method stub
		if (ult == 0)
			return true;
		else
			return false;
	}

}
