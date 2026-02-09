package Luis.felipe.ListaDeCompras.Service;

import Luis.felipe.ListaDeCompras.Model.Lista;
import Luis.felipe.ListaDeCompras.Repository.Listarepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Listaservice {

    private final Listarepository listarepository;

    public Listaservice(Listarepository listarepository) {

        this.listarepository = listarepository;
    }

    //MOSTRAR LISTA
    public List<Lista> lista (){
        return listarepository.findAll();
    }

    //Add item na lista
    public Lista addItem(Lista lista){
        return listarepository.save(lista);/*Lista seria um Item e não uma lista*/
    }

}
