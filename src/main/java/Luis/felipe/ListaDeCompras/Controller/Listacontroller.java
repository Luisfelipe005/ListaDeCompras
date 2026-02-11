package Luis.felipe.ListaDeCompras.Controller;

import Luis.felipe.ListaDeCompras.Model.Lista;
import Luis.felipe.ListaDeCompras.Service.Listaservice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Lista")
public class Listacontroller {
    private final Listaservice listaservice;

    public Listacontroller(Listaservice listaservice) {
        this.listaservice = listaservice;
    }

    @GetMapping
        public ResponseEntity <List<Lista>> mostrarlista(){
            return ResponseEntity.ok().body(listaservice.getLista());
    }

    @PostMapping
    public Lista addlista(@RequestBody Lista item){
        return listaservice.addItem(item);
    }

    @DeleteMapping("/{id}")
    public void deleteitem(@PathVariable Long id){
        listaservice.delete(id);
    }

    @DeleteMapping
    public void deleteall(){
        listaservice.deleteall();
    }

    @PutMapping("/{id}")
    public Lista atualiza(@RequestBody Lista lista, @PathVariable Long id){
       return listaservice.atualizaLista(lista, id);
    }

    @PatchMapping("/{id}")
    public void marcarComprado(@PathVariable Long id){
        listaservice.marcaComprado(id);
    }

}
