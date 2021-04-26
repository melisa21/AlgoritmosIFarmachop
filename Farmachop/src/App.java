import archivos.ManejadorArchivosGenerico;
import farmacia.Farmaceutica;
import farmacia.Farmaco;
import farmacia.IFarmaco;
import farmacia.ISuero;
import farmacia.Suero;
import tdas.ILista;
import tdas.INodo;
import tdas.Nodo;
import tdas.Lista;

public class App {
    public static void main(String[] args) throws Exception {
        //ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        
        
        Farmaceutica far = new Farmaceutica();

        String[] listaFarmacos = ManejadorArchivosGenerico.leerArchivo("C:/Users/Meli/Documents/GitHub/AlgoritmosIFarmachop/Farmachop/src/farmacos.txt");
        far.agregarListaFarmacoArchivo(listaFarmacos);

        String[] listaSueros = ManejadorArchivosGenerico.leerArchivo("C:/Users/Meli/Documents/GitHub/AlgoritmosIFarmachop/Farmachop/src/Sueros.txt");
        far.agregarListaSuerosArchivo(listaSueros);

        far.agregarListaBlanca("C:/Users/Meli/Documents/GitHub/AlgoritmosIFarmachop/Farmachop/src/listablanca.txt");
        far.agregarListaNegra("C:/Users/Meli/Documents/GitHub/AlgoritmosIFarmachop/Farmachop/src/listanegra.txt");

        //Caso Prueba 1
        ISuero unSuero = new Suero(10, "");
        ILista<IFarmaco> listfarmacos = new Lista<IFarmaco>();
        IFarmaco farm = new Farmaco(6, "");
        INodo<IFarmaco> unFarmaco = new Nodo<IFarmaco>(farm.getIdFarmaco().toString() ,farm);
        listfarmacos.insertarUltimo(unFarmaco);
        System.out.println(far.preparadoViable(unSuero, listfarmacos)); 
    }
}
