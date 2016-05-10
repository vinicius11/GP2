package br.upe.community.negocios;

import br.upe.community.entidade.Produto;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.ProdutoInexistenteException;
import br.upe.community.persistencia.RepositorioProduto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicosProdutoImpl implements ServicosProduto {
    @Autowired
    private RepositorioProduto repositorioProduto;
    @Autowired
    private ServicosCategoria servicosCategoria;
    
    @Override
    public void cadastrar(Produto produto, String categoriaNome) throws CategoriaInexistenteException {
        produto.setCategoria(servicosCategoria.consultarPorNome(categoriaNome));
        repositorioProduto.save(produto);
       
    }

    @Override
    public void atualizar(Produto produto, Long IDatualizado, String categoriaNome) throws ProdutoInexistenteException, CategoriaInexistenteException {
        
        Produto produtoAtualizar = repositorioProduto.findOne(produto.getId());
        if(produtoAtualizar==null) throw new ProdutoInexistenteException();
        produto.setCategoria(servicosCategoria.consultarPorNome(categoriaNome));
        produto.setId(produtoAtualizar.getId());
        repositorioProduto.save(produto);
    }
    
    public void deletar(Long ID){
        repositorioProduto.delete(ID);
    }

    @Override
    public List<Produto> listarProdutos() {
        return (List<Produto>) repositorioProduto.findAll();
    }

    public Produto consultarPorID(Long ID){
        return repositorioProduto.findOne(ID);
    }
    
    @Override
    public List<Produto> consultarPorNome(String nome) {
        return (List<Produto>) repositorioProduto.findByNome(nome);
    }

    
    public List<Produto> consultarPorCategoria(String nomeCategoria) {
        return(List<Produto>) repositorioProduto.buscarPorCategoria(nomeCategoria);
    }

    @Override
    public long ultimoID() {
        return repositorioProduto.ultimoID();
    }
}
