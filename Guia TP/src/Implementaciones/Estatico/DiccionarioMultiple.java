package Implementaciones.Estatico;

import Api.ConjuntoTDA;
import Api.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

	class Elem{
        int clave;
        int [] valores;
        int ultV;
    }

    Elem [] v; //vector de claves
    int ultCl;

    public void inicializarDiccionario(){
        v = new Elem [100];
        ultCl = 0;
    }

    public ConjuntoTDA claves(){
        ConjuntoTDA salida = new Conjunto();
        salida.InicializarConjunto();
        for (int i = 0; i<ultCl; i ++)
            salida.Agregar(v[i].clave);
        return salida;    
    }

    public ConjuntoTDA recuperar (int c){
        int posCl = posClave(c);
        ConjuntoTDA salida = new Conjunto();
        salida.InicializarConjunto();
        if (posCl < ultCl){
            for (int j = 0; j<v[posCl].ultV; j++){
                salida.Agregar(v[posCl].valores[j]);
            }
        }
		return salida; //sin esto la funcion tira error
    }

    //nos retorna la ultima posición de la clave
    private int posClave (int c){
    	int i;
        for (i = 0; i<ultCl && v[i].clave != c; i++)
            ;
		return i;
    }

    
    //consultar bien como funciona la funcion agergar
    public void agregar(int c,int x){
        int posC = posClave(c);
        //si no encontre la clave
        if (posC == ultCl){
            v[posC] = new Elem();
            v[posC].clave = c;
            v[posC].valores = new int [100];
            v[posC].valores[0] = x;
            v[posC].ultV = 1;
            ultCl++;
        }
        //si encontre la clave
        int j;
        for (j=0; j<v[posC].ultV && v[posC].valores[j]!=x;j++)
            ;
        if (j==v[posC].ultV){
            v[posC].valores[j]=x;
            v[posC].ultV++;
        }
    }

    public void eliminar (int c){
        int posC = posClave(c);
        if (posC < ultCl){
            v[posC] = v [ultCl-1];
            ultCl--;
        }
    }

    //consultar como funciona la funcion EliminarElem
    public void EliminarElem (int c, int x){
        int posC = posClave(c);
        if (posC<ultCl){
            int j;
            for (j=0;j<v[posC].ultV&&v[posC].valores[j]!= x;j++){
                if (j<v[posC].ultV){
                    v[posC].valores[j] = v[posC].valores[v[posC].ultV];
                    v[posC].ultV--;
                    if (v[posC].ultV==0){
                        eliminar(c);
                    }
                }
            }
        }
    }

}
