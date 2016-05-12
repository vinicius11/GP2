package br.upe.community.persistencia;

import br.upe.community.entidade.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
    
    public Usuario findByEmail(String email);
    public List<Usuario> findByNome(String nome);
    public List<Usuario> findByNomeAndSobrenome(String nome, String Sobrenome);
    public Usuario findByEmailAndSenha(String email, String senha);
    @Query("Select u from Usuario u where u.nome like '%nomeUsuario%'")
    public List<Usuario> buscarTuya(@Param("nomeUsuario")String nomeUsuario);
}
