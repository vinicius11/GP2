package br.upe.community.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Doacao implements Serializable{
    
    private Long Id;
    private Produto produto;
    private Usuario usuarioAnunciador;
    private Usuario usuarioGanhador;
    private List<Usuario> interessados;
    private Date dataAnuncio;
    private Date dataInteressado;
    private boolean ativo; 

    public Doacao(Produto produto, Date dataAnuncio, List<Usuario> interessados,Usuario usuarioGanhador, Date dataInteressado) {
        this.interessados=interessados;
        this.usuarioGanhador = usuarioGanhador;
        this.dataInteressado = dataInteressado;
    }

    public Doacao() {
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    @OneToOne(fetch = FetchType.EAGER)
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    @ManyToOne (fetch = FetchType.EAGER)
    public Usuario getUsuarioGanhador() {
        return usuarioGanhador;
    }

    public void setUsuarioGanhador(Usuario usuarioGanhador) {
        this.usuarioGanhador = usuarioGanhador;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    public Usuario getUsuarioAnunciador() {
        return usuarioAnunciador;
    }

    public void setUsuarioAnunciador(Usuario usuarioAnunciador) {
        this.usuarioAnunciador = usuarioAnunciador;
    }
    
    
    @ManyToMany (fetch = FetchType.EAGER)
    public List<Usuario> getInteressados() {
        return interessados;
    }
    
    public void setInteressados(List<Usuario> interessados) {
        this.interessados = interessados;
    }
    @Temporal(TemporalType.DATE)
    public Date getDataAnuncio() {
        return dataAnuncio;
    }

    public void setDataAnuncio(Date dataAnuncio) {
        this.dataAnuncio = dataAnuncio;
    }
    @Temporal(TemporalType.DATE)
    public Date getDataInteressado() {
        return dataInteressado;
    }

    public void setDataInteressado(Date dataInteressado) {
        this.dataInteressado = dataInteressado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.Id != null ? this.Id.hashCode() : 0);
        hash = 79 * hash + (this.produto != null ? this.produto.hashCode() : 0);
        hash = 79 * hash + (this.usuarioAnunciador != null ? this.usuarioAnunciador.hashCode() : 0);
        hash = 79 * hash + (this.usuarioGanhador != null ? this.usuarioGanhador.hashCode() : 0);
        hash = 79 * hash + (this.interessados != null ? this.interessados.hashCode() : 0);
        hash = 79 * hash + (this.dataAnuncio != null ? this.dataAnuncio.hashCode() : 0);
        hash = 79 * hash + (this.dataInteressado != null ? this.dataInteressado.hashCode() : 0);
        hash = 79 * hash + (this.ativo ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Doacao other = (Doacao) obj;
        if (this.Id != other.Id && (this.Id == null || !this.Id.equals(other.Id))) {
            return false;
        }
        if (this.produto != other.produto && (this.produto == null || !this.produto.equals(other.produto))) {
            return false;
        }
        if (this.usuarioAnunciador != other.usuarioAnunciador && (this.usuarioAnunciador == null || !this.usuarioAnunciador.equals(other.usuarioAnunciador))) {
            return false;
        }
        if (this.usuarioGanhador != other.usuarioGanhador && (this.usuarioGanhador == null || !this.usuarioGanhador.equals(other.usuarioGanhador))) {
            return false;
        }
        if (this.interessados != other.interessados && (this.interessados == null || !this.interessados.equals(other.interessados))) {
            return false;
        }
        if (this.dataAnuncio != other.dataAnuncio && (this.dataAnuncio == null || !this.dataAnuncio.equals(other.dataAnuncio))) {
            return false;
        }
        if (this.dataInteressado != other.dataInteressado && (this.dataInteressado == null || !this.dataInteressado.equals(other.dataInteressado))) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        return true;
    }
}  

