package Api;

public interface DiccionarioSimpleTDA {
	void InicializarDiccionario();
	void Agregar(int clave, int valor);
	void Eliminar(int clave);
	float Recuperar(int clave);
	ConjuntoTDA Claves();
}
