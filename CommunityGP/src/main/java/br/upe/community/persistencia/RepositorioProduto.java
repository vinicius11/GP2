package br.upe.community.persistencia;

import br.upe.community.entidade.Categoria;
import br.upe.community.entidade.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioProduto extends CrudRepository<Produto, Long>  {
    
    public List<Produto> findByNome(String nome);
    @Query("select p from Produto p where p.categoria.nome=:nomeCategoria")
    public List<Produto> buscarPorCategoria(String nomeCategoria);
    @Query("select max(id) from Produto")
    public long ultimoID();
    
}
