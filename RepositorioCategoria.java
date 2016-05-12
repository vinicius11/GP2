
package br.upe.community.persistencia;

import br.upe.community.entidade.Categoria;
import java.awt.List;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioCategoria extends CrudRepository<Categoria, Long>{
    public Categoria findByNome(String nome);
}
