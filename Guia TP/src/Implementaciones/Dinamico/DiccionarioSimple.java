package Implementaciones.Dinamico;

import Api.ConjuntoTDA;
import Api.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
	
	class NodoCl{
		int clave, valor;
		NodoCl sigCl;
	}
	NodoCl iniCl;

	@Override
	public void InicializarDiccionario() {
		iniCl = null;
	}
	
	@Override
	public void Agregar(int clave, int valor) {
		NodoCl nuevo;
		nuevo = new NodoCl();
		nuevo.clave = clave;
		nuevo.valor = valor;
		NodoCl aux = iniCl;
		while(aux!= null && aux.clave!=clave){
			aux = aux.sigCl;
		}
		if(aux==null){
			nuevo.sigCl = iniCl;
			iniCl = nuevo;
		}
	}

	@Override
	public void Eliminar(int clave) {
		if(iniCl != null){
			if(iniCl.clave == clave){
				iniCl = iniCl.sigCl;
			}
			else{
				NodoCl aux = iniCl;
				while (aux.sigCl != null && aux.sigCl.clave != clave){
					aux = aux.sigCl;
				}
				if(aux.sigCl != null) {
					aux.sigCl = aux.sigCl.sigCl;
				}
			}
		}
	}

	@Override
	public float Recuperar(int clave) {
		NodoCl claveBuscada = iniCl;
		while (claveBuscada != null && claveBuscada.clave != clave){
			claveBuscada = claveBuscada.sigCl;
		}
		return claveBuscada.valor;
	}

	@Override
	public ConjuntoTDA Claves() {
		ConjuntoTDA claves = new Conjunto();
		claves.InicializarConjunto();
		NodoCl actual = iniCl;
		while(actual != null){
			claves.Agregar(iniCl.clave);
			actual = actual.sigCl;
		}
		return claves;
	}
}