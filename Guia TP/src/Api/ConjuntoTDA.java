package Api;

public interface ConjuntoTDA {
	void InicializarConjunto();
	int Elegir();
	void Sacar(int x);
	void Agregar(int x);
	boolean ConjuntoVacio();
	boolean Pertenece(int x);
}
