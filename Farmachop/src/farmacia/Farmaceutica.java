package farmacia;
import archivos.ManejadorArchivosGenerico;
import tdas.ILista;
import tdas.Lista;
import tdas.INodo;
import tdas.Nodo;

public class Farmaceutica {
    private ILista<ISuero> sueros = new Lista<ISuero>();
    private ILista<IFarmaco> farmacos = new Lista<IFarmaco>();
    private ILista<IFarmaco> listaBlanca = new Lista<IFarmaco>();
    private ILista<ICombinacionNegra> listaNegra = new Lista<ICombinacionNegra>();

    public ILista<ISuero> getSueros() {
        return this.sueros;
    }

    
    public ILista<IFarmaco> getFarmacos() {
        return this.farmacos;
    }

   

    public ILista<IFarmaco> getListaBlanca() {
        return this.listaBlanca;
    }

    

    public ILista<ICombinacionNegra> getListaNegra() {
        return this.listaNegra;
    }

    public void insertarSuero(ISuero unSuero) {
        INodo<ISuero> nodo = new Nodo <ISuero> ( unSuero.getIdSuero(), unSuero);
        this.sueros.insertarUltimo(nodo);
    }

    public void agregarListaSuerosArchivo(String[] listaSueros) {
        
        for (String linea : listaSueros) {
            String[] lineaLeida = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            Comparable idSuero = lineaLeida[0];
            String descSuero = lineaLeida[1];
            ISuero suero = new Suero(idSuero, descSuero);
            this.insertarSuero(suero);   
        }
    }

    public void insertarFarmaco(IFarmaco unFarmaco) {
        INodo<IFarmaco> nodo = new Nodo<IFarmaco>( unFarmaco.getIdFarmaco(), unFarmaco);
        this.farmacos.insertarUltimo(nodo);
    }

    public void agregarListaFarmacoArchivo(String[] listaFarmacos) {
        
        for (String linea : listaFarmacos) {
            String[] lineaLeida = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            Comparable idFarmaco = lineaLeida[0];
            String descFarmaco = lineaLeida[1];
            IFarmaco farmaco = new Farmaco(idFarmaco, descFarmaco);
            this.insertarFarmaco(farmaco);   
        }
    }

    public void insertarListaBlanca(Comparable<String> idFarmaco) {
        INodo<IFarmaco> nodo = new Nodo<IFarmaco>( idFarmaco, null);
        this.listaBlanca.insertarUltimo(nodo);
    }

    public void agregarListaBlanca(String nombreArchivo) {
        String[] listaFarmacos = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for (String linea : listaFarmacos) {
            String[] lineaLeida = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            Comparable idFarmaco = lineaLeida[0];
            this.insertarListaBlanca(idFarmaco);   
        }
    }

    public void insertarListaNegra(CombinacionNegra comb) {
        INodo<ICombinacionNegra> nodo = new Nodo<ICombinacionNegra>(comb.getFarmaco(), comb);
        this.listaNegra.insertarUltimo(nodo);
    }

    public void agregarListaNegra(String nombreArchivo) {
        String[] listaFarmacos = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for (String linea : listaFarmacos) {
            String[] lineaLeida = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            Comparable idFarmaco = lineaLeida[0];
            Comparable idSuero = lineaLeida[1];
            CombinacionNegra farmaco = new CombinacionNegra(idFarmaco, idSuero);
            this.insertarListaNegra(farmaco);   
        }
    }

    public Boolean preparadoViable (ISuero identificadorSuero , ILista<IFarmaco> farmacos){
        Boolean valido = true;
	    INodo<IFarmaco>  aux1 = farmacos.getPrimero();
	    INodo<IFarmaco> aux2 = this.listaBlanca.getPrimero();
        INodo<ICombinacionNegra> aux3;
	    while (aux1 != null && valido) {
            while (aux2 != null && aux1.compareTo(aux2.getEtiqueta())!=0) {
			    aux2 = aux2.getSiguiente();
            }
	
            if ( aux1.compareTo(aux2.getEtiqueta())==0){
                valido = true;
                aux1 = aux1.getSiguiente();
            }
            else
            {
                aux3 = this.listaNegra.getPrimero();
                while ((aux3 != null) && (aux1.compareTo(aux3.getEtiqueta())!=0 || identificadorSuero.getIdSuero() != aux3.getDato().getSuero()) ) 
				    aux3 = aux3.getSiguiente();
		        if (aux1.compareTo(aux3.getEtiqueta())==0 && identificadorSuero.getIdSuero() == aux3.getDato().getSuero())
			        valido = false;
                else {
			        aux1 = aux1.getSiguiente();
			        valido = true;
                }
            }
        }
        return valido;

    }

}
