package Luis.felipe.ListaDeCompras.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Lista_Comidas")
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String item;
    private Integer quantidade;
    private Boolean comprado;

    public Lista(Long id, String item, Integer quantidade) {
        this.id = id;
        this.item = item;
        this.quantidade = quantidade;
        this.comprado = false;
    }

    public Lista() {
    }

    public Boolean getComprado() {
        return comprado;
    }

    public void setComprado(Boolean comprado) {
        this.comprado = comprado;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
