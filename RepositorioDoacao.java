/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.persistencia;


import br.upe.community.entidade.Doacao;
import br.upe.community.entidade.Produto;
import br.upe.community.listar.DoacaoListar;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;



public interface RepositorioDoacao extends CrudRepository<Doacao, Long>{
   
        
    @Query("select new br.upe.community.listar.DoacaoListar(d) from Doacao d where d.produto.nome=:nomeProduto")
    public List<DoacaoListar> consultarPorProduto(@Param("nomeProduto") String nomeProduto);
    @Query("select new br.upe.community.listar.DoacaoListar(d) from Doacao d where d.produto.categoria.nome=:nomeCategoria ")
    public List<DoacaoListar> consultarPorCategoria(@Param("nomeCategoria") String nomeCategoria); 
    @Query("select new br.upe.community.listar.DoacaoListar(d) from Doacao d where d.dataAnuncio=:dataAnuncio")
    public List<DoacaoListar> consultarPorDataAnuncio(@Param("dataAnuncio") Date dataAnuncio);
    @Query("select new br.upe.community.listar.DoacaoListar(d) from Doacao d where d.usuarioGanhador.nome=:nomeUsuario")
    public List<DoacaoListar> consultarPorUsuarioGanhador(@Param("nomeUsuario")  String nomeUsuario);
    @Query("select new br.upe.community.listar.DoacaoListar(d) from Doacao d where d.usuarioAnunciador.nome=:nomeUsuario")
    public List<DoacaoListar> consultarPorUsuarioAnunciador( @Param("nomeUsuario") String nomeUsuario);
        
}
