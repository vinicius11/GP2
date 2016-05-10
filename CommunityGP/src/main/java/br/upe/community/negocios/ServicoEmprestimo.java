/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.negocios;

import br.upe.community.entidade.Emprestimo;
import br.upe.community.entidade.Produto;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.EmprestimoInexistenteException;
import br.upe.community.excecao.EmprestimoJaRealizadoException;
import br.upe.community.excecao.ProprioUsuarioAnunciadorException;
import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.listar.EmprestimoListar;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


public interface ServicoEmprestimo extends Serializable {
    
    public void cadastrar(Emprestimo emprestimo,Produto produto,String email,String nomeCategoria) throws UsuarioInexistenteException, CategoriaInexistenteException;
    public void removerEmprestimo (long id) throws EmprestimoInexistenteException;
    public List<EmprestimoListar> listarEmprestimo();
    public List<EmprestimoListar> consultarPorProdutoEmprestimo(String nomeProduto) throws EmprestimoInexistenteException;
    public List<EmprestimoListar> consultarPorCategoriaEmprestimo(String nomeCategoria)throws EmprestimoInexistenteException;
    public List<EmprestimoListar> consultarPorUsuarioAnunciadorEmprestimo(String nomeUsuario)throws EmprestimoInexistenteException;
    public List<EmprestimoListar> consultarPorUsuarioEmprestado(String nomeUsuario)throws EmprestimoInexistenteException;
    public List<EmprestimoListar> consultarPorDataInteressado(Date data)throws EmprestimoInexistenteException;
    public List<EmprestimoListar> consultarPorDataAnuncio(Date data)throws EmprestimoInexistenteException;
    public List<EmprestimoListar> consultarPorDataInicial(Date data)throws EmprestimoInexistenteException;
    public List<EmprestimoListar> consultarPorDataFinal(Date data)throws EmprestimoInexistenteException;
    public void interesseEmprestimo(String email,long id)throws UsuarioInexistenteException, ProprioUsuarioAnunciadorException, EmprestimoJaRealizadoException;
    public void realizarEmprestimo() throws UsuarioInexistenteException;
}
