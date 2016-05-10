package br.upe.community.negocios;

import br.upe.community.entidade.Categoria;
import br.upe.community.excecao.CategoriaExistenteException;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.persistencia.RepositorioCategoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicosCategoriaImpl implements ServicosCategoria {
    @Autowired
    private RepositorioCategoria repositorioCategoria;
    @Override
    public void cadastrar(Categoria categoria) throws CategoriaExistenteException {
       
        if(repositorioCategoria.findByNome(categoria.getNome())!=null) 
            throw new CategoriaExistenteException();
        repositorioCategoria.save(categoria);
    }

    @Override
    public void atualizar(String nomeAtual, String nomeAtualizar) throws CategoriaInexistenteException {
        Categoria categoriaAtualizar = repositorioCategoria.findByNome(nomeAtual);
        if(categoriaAtualizar==null) throw new CategoriaInexistenteException();
        categoriaAtualizar.setNome(nomeAtualizar);
        repositorioCategoria.save(categoriaAtualizar);
    }

    @Override
    public List<Categoria> listarTodos() {
        return (List<Categoria>) repositorioCategoria.findAll();
    }

    @Override
    public Categoria consultarPorNome(String nome) throws CategoriaInexistenteException {
        if(repositorioCategoria.findByNome(nome)==null){
            throw new CategoriaInexistenteException();
        }
        return repositorioCategoria.findByNome(nome);
    }
    
}
