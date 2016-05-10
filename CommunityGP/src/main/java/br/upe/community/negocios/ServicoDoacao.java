/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.negocios;

import br.upe.community.entidade.Doacao;
import br.upe.community.entidade.Produto;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.DoacaoInexistenteException;
import br.upe.community.excecao.DoacaoJaRealizadaException;
import br.upe.community.excecao.ProprioUsuarioAnunciadorException;
import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.listar.DoacaoListar;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


public interface ServicoDoacao extends Serializable {
    
    public void cadastrar(Doacao doacao,Produto produto,String email,String nomeCategoria) throws UsuarioInexistenteException,CategoriaInexistenteException;    
    public void removerDoacao(long id) throws DoacaoInexistenteException;
    public List<DoacaoListar> listarDoacao();
    public List<DoacaoListar> consultarPorProduto(String nomeProduto) throws DoacaoInexistenteException;
    public List<DoacaoListar> consultarPorCategoria(String nomeCategoria)throws DoacaoInexistenteException;
    public List<DoacaoListar> consultarPorUsuarioAnunciador(String nomeUsuario)throws DoacaoInexistenteException;
    public List<DoacaoListar> consultarPorUsuarioGanhador(String nomeUsuario)throws DoacaoInexistenteException;
    public List<DoacaoListar> consultarPorData(Date data)throws DoacaoInexistenteException;
    public void interesseDoacao(String email,long id)throws UsuarioInexistenteException, ProprioUsuarioAnunciadorException, DoacaoJaRealizadaException;
    public void realizarDoacao() throws UsuarioInexistenteException;
}
