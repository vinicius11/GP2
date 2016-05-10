/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.negocios;

import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.excecao.UsuarioExistenteException;
import br.upe.community.entidade.Usuario;
import br.upe.community.listar.UsuarioListar;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author elisson
 */
public interface ServicosUsuario extends Serializable {
    
    public void cadastrar(Usuario usuario) throws UsuarioExistenteException, UsuarioInexistenteException;
    public void atualizar(Usuario usuario, String emailAtualizar) throws UsuarioInexistenteException;
    public void remover(String email) throws UsuarioInexistenteException;
    public List<UsuarioListar> listarTodos();
    public Usuario ConsultarPorEmail(String email) throws UsuarioInexistenteException;
    public List<UsuarioListar> ConsultarPorNome(String nome) throws UsuarioInexistenteException;
    //continua...

}
