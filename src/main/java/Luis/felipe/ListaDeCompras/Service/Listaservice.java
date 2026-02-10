package Luis.felipe.ListaDeCompras.Service;

import Luis.felipe.ListaDeCompras.Model.Lista;
import Luis.felipe.ListaDeCompras.Repository.Listarepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Listaservice {

    private final Listarepository listarepository;

    public Listaservice(Listarepository listarepository) {

        this.listarepository = listarepository;
    }

    //MOSTRAR LISTA
    public List<Lista> getLista (){
        return listarepository.findAll();
    }

    //Add item na lista
    public Lista addItem(Lista lista){
        return listarepository.save(lista);/*Lista seria um Item e não uma lista*/
    }

    //Deletar item
    public void delete(Long id){
        listarepository.deleteById(id);
    }

    //Deletar lista/Tabela
    public void deleteall(){
        listarepository.deleteAll();
    }

    //Atualizarlista
    public Lista atualizaLista(Lista lista, Long id){
        Optional<Lista> optionalLista = listarepository.findById(id);

        if(!optionalLista.isPresent()) {
            throw new RuntimeException("Item do id: " + id + " não encontrado!");
        }
        Lista lista1 = optionalLista.get();
        lista1.setItem(lista.getItem());
        lista1.setQuantidade(lista.getQuantidade());
        return listarepository.save(lista1);
    }
}
