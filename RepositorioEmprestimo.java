package br.upe.community.persistencia;

import br.upe.community.entidade.Emprestimo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RepositorioEmprestimo extends CrudRepository<Emprestimo, Long>{
    
    @Query("select d from Emprestimo d where d.produto.nome=:nomeProduto")
    public List<Emprestimo> buscarProduto(@Param("nomeProduto") String nomeProduto);
    @Query("select d from Emprestimo d where d.produto.categoria.nome=:nomeCategoria")
    public List<Emprestimo> buscarCategoria(@Param("nomeCategoria") String nomeCategoria); 
    @Query("select d from Emprestimo d where d.dataAnuncio=:dataAnuncio")
    public List<Emprestimo> buscarDateAnuncio(@Param("dataAnuncio")Date dataAnuncio);
    @Query("select d from Emprestimo d where d.dataInteressado=:dataInteressado")
    public List<Emprestimo> buscarDateInteressado(@Param("dataInteressado")Date dataInteressado);
    @Query("select d from Emprestimo d where d.dataInicial=:dataInicial")
    public List<Emprestimo> buscarDateInicial(@Param("dataInicial") Date dataInicial);
    @Query("select d from Emprestimo d where d.dataFinal=:dataFinal")
    public List<Emprestimo> buscarDateFinal(@Param("dataFinal") Date dataFinal);
    @Query("select d from Emprestimo d where d.usuarioEmprestado.nome=:nomeUsuario")
    public List<Emprestimo> buscarUsuarioEmprestado(@Param("nomeUsuario") String nomeUsuario);
    @Query("select d from Emprestimo d where d.usuarioAnunciador.nome=:nomeUsuario")
    public List<Emprestimo> buscarUsuarioAnunciador(@Param("nomeUsuario") String nomeUsuario);
    
}
