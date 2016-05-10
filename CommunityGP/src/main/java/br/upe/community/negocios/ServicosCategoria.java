package br.upe.community.negocios;

import br.upe.community.entidade.Categoria;
import br.upe.community.excecao.CategoriaExistenteException;
import br.upe.community.excecao.CategoriaInexistenteException;
import java.io.Serializable;
import java.util.List;

public interface ServicosCategoria extends Serializable {
    public void cadastrar(Categoria categoria) throws CategoriaExistenteException;
    public void atualizar(String nomeAtual, String nomeAtualizar) throws CategoriaInexistenteException;
    public List<Categoria> listarTodos();
    public Categoria consultarPorNome(String nome) throws CategoriaInexistenteException;
}
