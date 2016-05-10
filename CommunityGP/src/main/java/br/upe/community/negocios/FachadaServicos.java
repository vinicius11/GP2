package br.upe.community.negocios;

import br.upe.community.entidade.Categoria;
import br.upe.community.entidade.Doacao;
import br.upe.community.entidade.Emprestimo;
import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.excecao.UsuarioExistenteException;
import br.upe.community.entidade.Doacao;
import br.upe.community.entidade.Emprestimo;
import br.upe.community.entidade.Produto;
import br.upe.community.entidade.Usuario;
import br.upe.community.excecao.CategoriaExistenteException;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.DoacaoInexistenteException;
import br.upe.community.excecao.DoacaoJaRealizadaException;
import br.upe.community.excecao.EmprestimoInexistenteException;
import br.upe.community.excecao.EmprestimoJaRealizadoException;
import br.upe.community.excecao.ProdutoInexistenteException;
import br.upe.community.excecao.ProprioUsuarioAnunciadorException;
import br.upe.community.listar.DoacaoListar;
import br.upe.community.listar.EmprestimoListar;
import br.upe.community.listar.UsuarioListar;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface FachadaServicos extends Serializable {
    
    public void cadastrar(Usuario usuario) throws UsuarioExistenteException, UsuarioInexistenteException;
    public void atualizar(Usuario usuario, String emailAtualizar) throws UsuarioInexistenteException;
    public void remover(String email) throws UsuarioInexistenteException;
    public List<UsuarioListar> listarUsuario();
    public Usuario ConsultarPorEmail(String email) throws UsuarioInexistenteException;
    public List<UsuarioListar> ConsultarPorNome(String nome) throws UsuarioInexistenteException;
    
    //Doacao
    public void cadastrarDoacao(Doacao doacao,Produto produto,String email,String nomeCategoria)throws UsuarioInexistenteException,CategoriaInexistenteException;    public void removerDoacao (String email) throws DoacaoInexistenteException;
    public void removerDoacao(long id) throws DoacaoInexistenteException;
    public List<DoacaoListar> listarDoacao();
    public List<DoacaoListar> consultarPorProduto(String nomeProduto) throws DoacaoInexistenteException;
    public List<DoacaoListar> consultarPorCategoria(String nomeCategoria)throws DoacaoInexistenteException;
    public List<DoacaoListar> consultarPorUsuarioAnunciador(String nomeUsuario)throws DoacaoInexistenteException;
    public List<DoacaoListar> consultarPorUsuarioGanhador(String nomeUsuario)throws DoacaoInexistenteException;
    public List<DoacaoListar> consultarPorData(Date data)throws DoacaoInexistenteException;
    public void interesseDoacao(String email,long id)throws UsuarioInexistenteException, ProprioUsuarioAnunciadorException, DoacaoJaRealizadaException;
    public void realizarDoacao() throws UsuarioInexistenteException;
    
    //Emprestimo
    
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
    
    //Produto
    public void cadastrar(Produto produto, String categoriaNome) throws CategoriaInexistenteException;
    public void atualizar(Produto usuario, Long IDatualizado, String categoriaNome) throws ProdutoInexistenteException, CategoriaInexistenteException;
    public void deletarProduto(Long ID);
    public List<Produto> listarProdutos();
    public Produto consultarPorIDProduto(Long ID);
    public List<Produto> consultarPorNomeProduto(String nome);
    public List<Produto> consultarPorCategoriaProduto(String nomeCategoria) throws CategoriaInexistenteException;
    
    //Categoria
    public void cadastrar(Categoria categoria) throws CategoriaExistenteException;
    public void atualizar(String nomeAtual, String nomeAtualizar) throws CategoriaInexistenteException;
    public List<Categoria> listarCategorias();
    public Categoria consultarPorNomeCategoria(String nome) throws CategoriaInexistenteException ;
 }

