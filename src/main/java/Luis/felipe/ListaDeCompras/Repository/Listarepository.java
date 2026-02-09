package Luis.felipe.ListaDeCompras.Repository;

import Luis.felipe.ListaDeCompras.Model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Listarepository extends JpaRepository<Lista, Long> {
}
