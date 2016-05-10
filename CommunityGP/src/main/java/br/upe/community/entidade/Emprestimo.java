package br.upe.community.entidade;

import java.io.Serializable;
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

@Entity
public class Emprestimo implements Serializable{
    private Long Id;
    private Produto produto;
    private Usuario usuarioAnunciador;
    private Usuario usuarioEmprestado;
    private List<Usuario> interessados;
    private Date dataAnuncio;
    private Date dataInteressado;
    private Date dataInicial;
    private Date dataFinal;
    private boolean ativo; 

    public Emprestimo(Produto produto, Date dataAnuncio, Date dataInicial, Date dataFinal) {
        this.produto = produto;
        this.dataAnuncio = dataAnuncio;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public Emprestimo() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }
    @OneToOne (fetch = FetchType.EAGER)
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    @ManyToOne (fetch = FetchType.EAGER)
    public Usuario getUsuarioEmprestado() {
        return usuarioEmprestado;
    }

    public void setUsuarioEmprestado(Usuario usuarioEmprestado) {
        this.usuarioEmprestado = usuarioEmprestado;
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
    @Temporal(TemporalType.DATE)
    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }
    @Temporal(TemporalType.DATE)
    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
        
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.Id != null ? this.Id.hashCode() : 0);
        hash = 19 * hash + (this.produto != null ? this.produto.hashCode() : 0);
        hash = 19 * hash + (this.usuarioAnunciador != null ? this.usuarioAnunciador.hashCode() : 0);
        hash = 19 * hash + (this.usuarioEmprestado != null ? this.usuarioEmprestado.hashCode() : 0);
        hash = 19 * hash + (this.interessados != null ? this.interessados.hashCode() : 0);
        hash = 19 * hash + (this.dataAnuncio != null ? this.dataAnuncio.hashCode() : 0);
        hash = 19 * hash + (this.dataInteressado != null ? this.dataInteressado.hashCode() : 0);
        hash = 19 * hash + (this.dataInicial != null ? this.dataInicial.hashCode() : 0);
        hash = 19 * hash + (this.dataFinal != null ? this.dataFinal.hashCode() : 0);
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
        final Emprestimo other = (Emprestimo) obj;
        if (this.Id != other.Id && (this.Id == null || !this.Id.equals(other.Id))) {
            return false;
        }
        if (this.produto != other.produto && (this.produto == null || !this.produto.equals(other.produto))) {
            return false;
        }
        if (this.usuarioAnunciador != other.usuarioAnunciador && (this.usuarioAnunciador == null || !this.usuarioAnunciador.equals(other.usuarioAnunciador))) {
            return false;
        }
        if (this.usuarioEmprestado != other.usuarioEmprestado && (this.usuarioEmprestado == null || !this.usuarioEmprestado.equals(other.usuarioEmprestado))) {
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
        if (this.dataInicial != other.dataInicial && (this.dataInicial == null || !this.dataInicial.equals(other.dataInicial))) {
            return false;
        }
        if (this.dataFinal != other.dataFinal && (this.dataFinal == null || !this.dataFinal.equals(other.dataFinal))) {
            return false;
        }
        return true;
    }

   
    
}
