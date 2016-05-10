package br.upe.community.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Usuario implements Serializable{
    private Long Id;
    private String nome;
    private String sobrenome;
    private String CPF;
    private String senha;
    private String email;
    private Endereco endereco;
    private int doou;
    private int doado;
    private int emprestou;
    private int emprestado;
    private List<Doacao> produtosAnunciadosDoacao;
    private List<Doacao> produtosGanhos;
    private List<Emprestimo> produtosEmprestimo;
    private List<Emprestimo> produtosAnunciadoEmprestimo;
    private List<Doacao> produtosInteressadosDoacao;
    private List<Emprestimo> produtosInteressadosEmprestimo;
    private boolean ativo;
    private String authority;

    public Usuario(String nome, String sobrenome, String CPF, String senha, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CPF = CPF;
        this.senha = senha;
        this.email = email;
        this.doado = 0;
        this.doou = 0;
        this.emprestado = 0;
        this.emprestou = 0;
        this.ativo = true;
        this.produtosGanhos = new ArrayList<Doacao>();
        this.produtosEmprestimo = new ArrayList<Emprestimo>();
        this.produtosInteressadosDoacao = new ArrayList<Doacao>();
        this.produtosInteressadosEmprestimo = new ArrayList<Emprestimo>();
    }

    public Usuario() {
        
        this.doado = 0;
        this.doou = 0;
        this.emprestado = 0;
        this.emprestou = 0;
        this.ativo = true;
        this.authority = "ROLE_ADMIN";
    }
    
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDoou() {
        return doou;
    }

    public void setDoou(int doou) {
        this.doou = doou;
    }

    public int getDoado() {
        return doado;
    }

    public void setDoado(int doado) {
        this.doado = doado;
    }

    public int getEmprestou() {
        return emprestou;
    }

    public void setEmprestou(int emprestou) {
        this.emprestou = emprestou;
    }

    public int getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(int emprestado) {
        this.emprestado = emprestado;
    }
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "usuarioAnunciador")
    public List<Doacao> getProdutosAnunciadosDoacao() {
        return produtosAnunciadosDoacao;
    }

    public void setProdutosAnunciadosDoacao(List<Doacao> produtosAnunciadosDoacao) {
        this.produtosAnunciadosDoacao = produtosAnunciadosDoacao;
    }
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "usuarioAnunciador")
    public List<Emprestimo> getProdutosAnunciadoEmprestimo() {
        return produtosAnunciadoEmprestimo;
    }

    public void setProdutosAnunciadoEmprestimo(List<Emprestimo> produtosAnunciadoEmprestimo) {
        this.produtosAnunciadoEmprestimo = produtosAnunciadoEmprestimo;
    }
    
   
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuarioGanhador")
    public List<Doacao> getProdutosGanhos() {
        return produtosGanhos;
    }

    public void setProdutosGanhos(List<Doacao> produtosGanhos) {
        this.produtosGanhos = produtosGanhos;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "usuarioEmprestado")
    public List<Emprestimo> getProdutosEmprestimo() {
        return produtosEmprestimo;
    }

    public void setProdutosEmprestimo(List<Emprestimo> produtosEmprestimo) {
        this.produtosEmprestimo = produtosEmprestimo;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "interessados")
    public List<Doacao> getProdutosInteressadosDoacao() {
        return produtosInteressadosDoacao;
    }

    public void setProdutosInteressadosDoacao(List<Doacao> produtosInteressadosDoacao) {
        this.produtosInteressadosDoacao = produtosInteressadosDoacao;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "interessados")
    public List<Emprestimo> getProdutosInteressadosEmprestimo() {
        return produtosInteressadosEmprestimo;
    }

    public void setProdutosInteressadosEmprestimo(List<Emprestimo> produtosInteressadosEmprestimo) {
        this.produtosInteressadosEmprestimo = produtosInteressadosEmprestimo;
    }

    @OneToOne (fetch = FetchType.EAGER)
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.Id != null ? this.Id.hashCode() : 0);
        hash = 89 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 89 * hash + (this.sobrenome != null ? this.sobrenome.hashCode() : 0);
        hash = 89 * hash + (this.CPF != null ? this.CPF.hashCode() : 0);
        hash = 89 * hash + (this.senha != null ? this.senha.hashCode() : 0);
        hash = 89 * hash + (this.email != null ? this.email.hashCode() : 0);
        hash = 89 * hash + (this.endereco != null ? this.endereco.hashCode() : 0);
        hash = 89 * hash + this.doou;
        hash = 89 * hash + this.doado;
        hash = 89 * hash + this.emprestou;
        hash = 89 * hash + this.emprestado;
        hash = 89 * hash + (this.produtosAnunciadosDoacao != null ? this.produtosAnunciadosDoacao.hashCode() : 0);
        hash = 89 * hash + (this.produtosGanhos != null ? this.produtosGanhos.hashCode() : 0);
        hash = 89 * hash + (this.produtosEmprestimo != null ? this.produtosEmprestimo.hashCode() : 0);
        hash = 89 * hash + (this.produtosAnunciadoEmprestimo != null ? this.produtosAnunciadoEmprestimo.hashCode() : 0);
        hash = 89 * hash + (this.produtosInteressadosDoacao != null ? this.produtosInteressadosDoacao.hashCode() : 0);
        hash = 89 * hash + (this.produtosInteressadosEmprestimo != null ? this.produtosInteressadosEmprestimo.hashCode() : 0);
        hash = 89 * hash + (this.ativo ? 1 : 0);
        hash = 89 * hash + (this.authority != null ? this.authority.hashCode() : 0);
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
        final Usuario other = (Usuario) obj;
        if (this.Id != other.Id && (this.Id == null || !this.Id.equals(other.Id))) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.sobrenome == null) ? (other.sobrenome != null) : !this.sobrenome.equals(other.sobrenome)) {
            return false;
        }
        if ((this.CPF == null) ? (other.CPF != null) : !this.CPF.equals(other.CPF)) {
            return false;
        }
        if ((this.senha == null) ? (other.senha != null) : !this.senha.equals(other.senha)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if (this.endereco != other.endereco && (this.endereco == null || !this.endereco.equals(other.endereco))) {
            return false;
        }
        if (this.doou != other.doou) {
            return false;
        }
        if (this.doado != other.doado) {
            return false;
        }
        if (this.emprestou != other.emprestou) {
            return false;
        }
        if (this.emprestado != other.emprestado) {
            return false;
        }
        if (this.produtosAnunciadosDoacao != other.produtosAnunciadosDoacao && (this.produtosAnunciadosDoacao == null || !this.produtosAnunciadosDoacao.equals(other.produtosAnunciadosDoacao))) {
            return false;
        }
        if (this.produtosGanhos != other.produtosGanhos && (this.produtosGanhos == null || !this.produtosGanhos.equals(other.produtosGanhos))) {
            return false;
        }
        if (this.produtosEmprestimo != other.produtosEmprestimo && (this.produtosEmprestimo == null || !this.produtosEmprestimo.equals(other.produtosEmprestimo))) {
            return false;
        }
        if (this.produtosAnunciadoEmprestimo != other.produtosAnunciadoEmprestimo && (this.produtosAnunciadoEmprestimo == null || !this.produtosAnunciadoEmprestimo.equals(other.produtosAnunciadoEmprestimo))) {
            return false;
        }
        if (this.produtosInteressadosDoacao != other.produtosInteressadosDoacao && (this.produtosInteressadosDoacao == null || !this.produtosInteressadosDoacao.equals(other.produtosInteressadosDoacao))) {
            return false;
        }
        if (this.produtosInteressadosEmprestimo != other.produtosInteressadosEmprestimo && (this.produtosInteressadosEmprestimo == null || !this.produtosInteressadosEmprestimo.equals(other.produtosInteressadosEmprestimo))) {
            return false;
        }
        if (this.ativo != other.ativo) {
            return false;
        }
        if ((this.authority == null) ? (other.authority != null) : !this.authority.equals(other.authority)) {
            return false;
        }
        return true;
    }

    
}
