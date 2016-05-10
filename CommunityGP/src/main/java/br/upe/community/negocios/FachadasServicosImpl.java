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
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FachadasServicosImpl implements FachadaServicos {
    
    @Autowired
    private ServicosUsuario servicosUsuarios;
    @Autowired
    private ServicoDoacao servicoDoacao;
    @Autowired
    private ServicoEmprestimo servicoEmprestimo;
    @Autowired
    private ServicosProduto servicoProduto;
    @Autowired
    private ServicosCategoria servicosCategoria;
    
    @Override
    public void cadastrar(Usuario usuario) throws UsuarioExistenteException, UsuarioInexistenteException  {
        servicosUsuarios.cadastrar(usuario);
    }

    @Override
    public void atualizar(Usuario usuario, String emailAtualizar) throws UsuarioInexistenteException {
        servicosUsuarios.atualizar(usuario,emailAtualizar);
    }

    @Override
    public void remover(String email) throws UsuarioInexistenteException {
        servicosUsuarios.remover(email);
    }

    public List<UsuarioListar> listarUsuario() {
        return servicosUsuarios.listarTodos();
    }

    @Override
    public Usuario ConsultarPorEmail(String email) throws UsuarioInexistenteException {
        return servicosUsuarios.ConsultarPorEmail(email);
    }

    @Override
    public List<UsuarioListar> ConsultarPorNome(String nome) throws UsuarioInexistenteException {
        return servicosUsuarios.ConsultarPorNome(nome);
    }
    
    //doação
    @Override
    public void cadastrarDoacao(Doacao doacao,Produto produto,String email,String nomeCategoria) throws UsuarioInexistenteException,CategoriaInexistenteException{
        servicoDoacao.cadastrar(doacao,produto,email,nomeCategoria);
    }

    @Override
    public void removerDoacao(long id) throws DoacaoInexistenteException {
        servicoDoacao.removerDoacao(id);
    }

    @Override
    public List<DoacaoListar> listarDoacao() {
        return servicoDoacao.listarDoacao();
    }

    @Override
    public List<DoacaoListar> consultarPorProduto(String nomeProduto) throws DoacaoInexistenteException {
        System.out.println("OPA1!");
        return servicoDoacao.consultarPorProduto(nomeProduto);
    }

    @Override
    public List<DoacaoListar> consultarPorCategoria(String nomeCategoria) throws DoacaoInexistenteException {
        return servicoDoacao.consultarPorCategoria(nomeCategoria);
    }
    @Override
    public List<DoacaoListar> consultarPorUsuarioAnunciador(String nomeUsuario)throws DoacaoInexistenteException {
        return servicoDoacao.consultarPorUsuarioAnunciador(nomeUsuario);
    }
    @Override
    public List<DoacaoListar> consultarPorUsuarioGanhador(String nomeUsuario)throws DoacaoInexistenteException {
        return servicoDoacao.consultarPorUsuarioGanhador(nomeUsuario);
    }
    
    @Override
    public List<DoacaoListar> consultarPorData(Date data) throws DoacaoInexistenteException {
        return servicoDoacao.consultarPorData(data);
    }
    
    
    @Override
    public void interesseDoacao(String email,long id)throws UsuarioInexistenteException, ProprioUsuarioAnunciadorException, DoacaoJaRealizadaException{
        servicoDoacao.interesseDoacao(email,id);
    }
    
    @Override
    public void realizarDoacao() throws UsuarioInexistenteException{
        servicoDoacao.realizarDoacao() ;
    }

    
    //Emprestimo
    
    @Override
    public void cadastrar(Emprestimo emprestimo,Produto produto,String email,String nomeCategoria) throws UsuarioInexistenteException, CategoriaInexistenteException {
        servicoEmprestimo.cadastrar(emprestimo, produto, email, nomeCategoria);
    }

    @Override
    public void removerEmprestimo(long id) throws EmprestimoInexistenteException {
        servicoEmprestimo.removerEmprestimo(id);
    }

    @Override
    public List<EmprestimoListar> listarEmprestimo() {
        return servicoEmprestimo.listarEmprestimo();
    }

    @Override
    public List<EmprestimoListar> consultarPorProdutoEmprestimo(String nomeProduto) throws EmprestimoInexistenteException {
        return servicoEmprestimo.consultarPorProdutoEmprestimo(nomeProduto);
    }

    @Override
    public List<EmprestimoListar> consultarPorDataInteressado(Date data) throws EmprestimoInexistenteException {
        return servicoEmprestimo.consultarPorDataInteressado(data);
    }

    @Override
    public List<EmprestimoListar> consultarPorDataInicial(Date data) throws EmprestimoInexistenteException {
        return servicoEmprestimo.consultarPorDataInicial(data);
    }
    
    @Override
    public List<EmprestimoListar> consultarPorDataFinal(Date data) throws EmprestimoInexistenteException {
        return servicoEmprestimo.consultarPorDataFinal(data);
    }
    
    @Override
    public List<EmprestimoListar> consultarPorDataAnuncio(Date data) throws EmprestimoInexistenteException {
        return servicoEmprestimo.consultarPorDataAnuncio(data);
    }
    
    @Override
    public List<EmprestimoListar> consultarPorCategoriaEmprestimo(String nomeCategoria) throws EmprestimoInexistenteException  {
        return servicoEmprestimo.consultarPorCategoriaEmprestimo(nomeCategoria);
    }
 
    @Override
    public List<EmprestimoListar> consultarPorUsuarioAnunciadorEmprestimo(String nomeUsuario)throws EmprestimoInexistenteException {
        return servicoEmprestimo.consultarPorUsuarioAnunciadorEmprestimo(nomeUsuario);
    }
    @Override
    public List<EmprestimoListar> consultarPorUsuarioEmprestado(String nomeUsuario)throws EmprestimoInexistenteException {
        return servicoEmprestimo.consultarPorUsuarioEmprestado(nomeUsuario);
    }
    
    @Override
    public void interesseEmprestimo(String email,long id)throws UsuarioInexistenteException, ProprioUsuarioAnunciadorException, EmprestimoJaRealizadoException {
        servicoEmprestimo.interesseEmprestimo(email,id);
    }
   
    @Override
    public void realizarEmprestimo() throws UsuarioInexistenteException {
        servicoEmprestimo.realizarEmprestimo();
    }
    
    //Produto
    @Override
    public void cadastrar(Produto produto, String categoriaNome) throws CategoriaInexistenteException {
        servicoProduto.cadastrar(produto, categoriaNome);
    }
    @Override
    public void atualizar(Produto usuario, Long IDatualizado, String categoriaNome) throws ProdutoInexistenteException, CategoriaInexistenteException{
        servicoProduto.atualizar(usuario,IDatualizado,categoriaNome);
    }
    @Override
    public void deletarProduto(Long ID){
        servicoProduto.deletar(ID);
    }
    @Override
    public List<Produto> listarProdutos(){
        return servicoProduto.listarProdutos();
    }
    @Override
    public Produto consultarPorIDProduto(Long ID){
        return servicoProduto.consultarPorID(ID);
    }
    @Override
    public List<Produto> consultarPorNomeProduto(String nome){
        return servicoProduto.consultarPorNome(nome);
    }
   @Override
    public List<Produto> consultarPorCategoriaProduto(String nomeCategoria) throws CategoriaInexistenteException {
        return servicoProduto.consultarPorCategoria(nomeCategoria);
    }
    
    //Categoria
    @Override
    public void cadastrar(Categoria categoria) throws CategoriaExistenteException {
        servicosCategoria.cadastrar(categoria);
    }
    @Override
    public void atualizar(String nomeAtual, String nomeAtualizar) throws CategoriaInexistenteException {
        servicosCategoria.atualizar(nomeAtual, nomeAtualizar);
    }
    @Override
    public List<Categoria> listarCategorias(){
        return servicosCategoria.listarTodos();
    }
    @Override
    public Categoria consultarPorNomeCategoria(String nome) throws CategoriaInexistenteException { 
        return servicosCategoria.consultarPorNome(nome);
    }

    @Override
    public void removerDoacao(String email) throws DoacaoInexistenteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
