
package br.upe.community.negocios;

import br.upe.community.entidade.Produto;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.ProdutoInexistenteException;
import java.io.Serializable;
import java.util.List;


public interface ServicosProduto extends Serializable {
    public void cadastrar(Produto produto, String categoriaNome)throws CategoriaInexistenteException ;
    public void atualizar(Produto usuario, Long IDatualizado, String categoriaNome) throws ProdutoInexistenteException, CategoriaInexistenteException;
    public void deletar(Long ID);
    public Produto consultarPorID(Long ID);
    public List<Produto> listarProdutos();
    public List<Produto> consultarPorNome(String nome);
    public List<Produto> consultarPorCategoria(String nomeCategoria);
    public long ultimoID();
}
