package Implementaciones.Estatico;

import Api.ConjuntoTDA;
import Api.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {

	class Elem {
		int clave, valor;
	}

	Elem[] Elementos;
	int cant;

	@Override
	public void Agregar(int clave, int valor) {
		int i;
		for (i = 0; i < cant && Elementos[i].clave != clave; i++)
			;
		if (i < cant) {
			Elementos[i].valor = valor;
		} else {
			Elementos[i] = new Elem();
			Elementos[i].valor = valor;
			Elementos[i].clave = clave;
			cant++;
		}
	}

	@Override
	public ConjuntoTDA Claves() {
		ConjuntoTDA cl = new Conjunto();
		cl.InicializarConjunto();
		for (int i = 0; i < cant; i++) {
			cl.Agregar(Elementos[i].clave);
		}
		return cl;
	}

	@Override
	public void Eliminar(int clave) {
		int i;
		for (i = 0; i < cant && Elementos[i].clave != clave; i++)
			;
		if (i < cant) {
			cant--;
			for (; i < cant; i++) {
				Elementos[i] = Elementos[i + 1];
			}
		}
	}

	@Override
	public void InicializarDiccionario() {
		Elementos = new Elem[100];
		cant = 0;
	}

	@Override
	public float Recuperar(int clave) {
		int i;
		float numero = 0;
		for (i = 0; i < cant && Elementos[i].clave != clave; i++)
			;
		if (i < cant) {
			numero = Elementos[i].valor;
		}
		return numero;
	}
}
