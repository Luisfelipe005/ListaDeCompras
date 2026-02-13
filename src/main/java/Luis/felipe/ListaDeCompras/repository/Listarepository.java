package Luis.felipe.ListaDeCompras.repository;

import Luis.felipe.ListaDeCompras.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Listarepository extends JpaRepository<Lista, Long> {

    List<Lista> findByItemContainsIgnoreCase(String nome);

}
