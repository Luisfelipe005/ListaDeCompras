package Luis.felipe.ListaDeCompras.service;

import Luis.felipe.ListaDeCompras.model.Lista;
import Luis.felipe.ListaDeCompras.repository.Listarepository;
import Luis.felipe.ListaDeCompras.exception.ItemNaoEncontradoException;
import Luis.felipe.ListaDeCompras.exception.RequisicaoInvalidaException;
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
    //Buscar por nome
    public List<Lista> listaPorNome(String item){
        if(listarepository.findByItemContainsIgnoreCase(item).isEmpty()){
            throw new ItemNaoEncontradoException("Item não encontrado na lista");
        }
      return listarepository.findByItemContainsIgnoreCase(item);
    }

    //Add item na lista
    public Lista addItem(Lista lista){
        if(lista.getItem() == null || lista.getItem().isBlank() || lista.getQuantidade() == null){
            throw new RequisicaoInvalidaException("Verifique se tem algo faltando! " +
                    "\nEx: Correto \"item\":\"Algo\",\n" +
                    "    \"quantidade\": 0");
        }
        return listarepository.save(lista);/*Lista seria um Item e não uma lista*/

    }

    //Deletar item
    public void delete(Long id){
        Optional<Lista> listaOptional = listarepository.findById(id);
        if(listaOptional.isEmpty()){
            throw new ItemNaoEncontradoException("Item não foi encontrado!");
        }
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
            throw new ItemNaoEncontradoException("Item não foi encontrado!");
        }
        Lista lista1 = optionalLista.get();
        lista1.setItem(lista.getItem());
        lista1.setQuantidade(lista.getQuantidade());
        if (lista1.getComprado()){
            lista1.setComprado(false);
        }
        return listarepository.save(lista1);
    }

    //marcar/Desmarcar como comprado
    public void marcaComprado(Long id){
        Optional<Lista> optionalLista = listarepository.findById(id);
        if (optionalLista.isEmpty()){
            throw new ItemNaoEncontradoException("Item não foi encontrado!");
        }
        Lista lista1 = optionalLista.get();
        if (!lista1.getComprado()){
            lista1.setComprado(true);
        }else {
            lista1.setComprado(false);
        }
        listarepository.save(lista1);
    }
}
