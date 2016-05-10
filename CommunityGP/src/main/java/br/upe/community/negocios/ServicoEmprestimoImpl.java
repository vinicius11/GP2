/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.negocios;

import br.upe.community.entidade.Emprestimo;
import br.upe.community.entidade.Produto;
import br.upe.community.entidade.Usuario;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.EmprestimoInexistenteException;
import br.upe.community.excecao.EmprestimoJaRealizadoException;
import br.upe.community.excecao.ProprioUsuarioAnunciadorException;
import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.listar.EmprestimoListar;
import br.upe.community.persistencia.RepositorioEmprestimo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoEmprestimoImpl implements ServicoEmprestimo {
    
    @Autowired
    private RepositorioEmprestimo repositorioEmprestimo;
    @Autowired
    private ServicosProduto servicosProduto;
    @Autowired
    private ServicosUsuario servicosUsuario;
    
    @Override
    public void cadastrar(Emprestimo emprestimo,Produto produto,String email,String nomeCategoria) throws UsuarioInexistenteException, CategoriaInexistenteException {
                Usuario usuario = servicosUsuario.ConsultarPorEmail(email);
                List<Emprestimo> listaEmprestimo = usuario.getProdutosAnunciadoEmprestimo();
        try {                  
            
                emprestimo.setUsuarioAnunciador(usuario); 
                emprestimo.setAtivo(true);
                servicosProduto.cadastrar(produto,nomeCategoria);
                long id = servicosProduto.ultimoID();
                
                emprestimo.setProduto(servicosProduto.consultarPorID(id));
                System.out.println(id);            
                repositorioEmprestimo.save(emprestimo);
               
                listaEmprestimo.add(emprestimo);
                usuario.setProdutosAnunciadoEmprestimo(listaEmprestimo);
                
                servicosUsuario.atualizar(usuario, email);
                
             
        } catch (UsuarioInexistenteException e) {
            throw e;
            
        } catch (CategoriaInexistenteException ex) {
            throw ex;
        }
    }

    public Emprestimo consultarPorId(long id) throws EmprestimoInexistenteException{
        Emprestimo emprestimoAtualizar =  repositorioEmprestimo.findOne(id);
        if(emprestimoAtualizar==null){
           throw new EmprestimoInexistenteException();
        }
        return emprestimoAtualizar;
    }
    @Override
    public void removerEmprestimo(long id) throws EmprestimoInexistenteException {
        Emprestimo emprestimo = consultarPorId(id);
        if(emprestimo==null){
            throw new EmprestimoInexistenteException();
        }else{
           emprestimo.setAtivo(false);
           repositorioEmprestimo.save(emprestimo);
        }
    }

    @Override
    public List<EmprestimoListar> listarEmprestimo() {
        
        List<Emprestimo> emprestimo = (List<Emprestimo>) repositorioEmprestimo.findAll();
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                System.out.println(emprestimo.get(i).getInteressados().size());
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    
                    System.out.println(i + " " + j + " " + nome);
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar);
            
            }
        }    
         return emp;
    }

    @Override
    public List<EmprestimoListar> consultarPorProdutoEmprestimo(String nomeProduto) throws EmprestimoInexistenteException {
        
        List<Emprestimo> emprestimo = repositorioEmprestimo.buscarProduto(nomeProduto); 
        if(emprestimo==null)
            throw new EmprestimoInexistenteException();
        
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar);
            
            }
        }
        return emp;        
    }

    @Override
    public List<EmprestimoListar> consultarPorCategoriaEmprestimo(String nomeCategoria) throws EmprestimoInexistenteException {
        
        List<Emprestimo> emprestimo = repositorioEmprestimo.buscarCategoria(nomeCategoria); 
        if(emprestimo==null)
            throw new EmprestimoInexistenteException();
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar);
            
            }
        }    
        return emp;   
    }

    @Override
    public List<EmprestimoListar> consultarPorUsuarioAnunciadorEmprestimo(String nomeUsuario) throws EmprestimoInexistenteException {
        
        List<Emprestimo> emprestimo = repositorioEmprestimo.buscarUsuarioAnunciador(nomeUsuario); 
        if(emprestimo==null)
            throw new EmprestimoInexistenteException();
        
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar);
            
            }
        }    
        return emp; 
    }

    @Override
    public List<EmprestimoListar> consultarPorUsuarioEmprestado(String nomeUsuario) throws EmprestimoInexistenteException {
        
        List<Emprestimo> emprestimo = repositorioEmprestimo.buscarUsuarioEmprestado(nomeUsuario); 
        if(emprestimo==null)
            throw new EmprestimoInexistenteException();
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar);
            
            }
        }
        return emp;   
    }
    @Override
    public List<EmprestimoListar> consultarPorDataInteressado(Date data) throws EmprestimoInexistenteException {
        
        List<Emprestimo> emprestimo = repositorioEmprestimo.buscarDateInteressado(data); 
        if(emprestimo==null)
            throw new EmprestimoInexistenteException();
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar);
            
            }
        }    
        return emp;   
    }
    
    @Override
    public List<EmprestimoListar> consultarPorDataAnuncio(Date data) throws EmprestimoInexistenteException {
        
        List<Emprestimo> emprestimo = repositorioEmprestimo.buscarDateAnuncio(data); 
        if(emprestimo==null)
            throw new EmprestimoInexistenteException();
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar); 
            }
        }    
        return emp;   
    }
    @Override
    public List<EmprestimoListar> consultarPorDataInicial(Date data) throws EmprestimoInexistenteException {
        
        List<Emprestimo> emprestimo = repositorioEmprestimo.buscarDateInicial(data); 
        if(emprestimo==null)
            throw new EmprestimoInexistenteException();
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar);
            
            }
        }    
        return emp;   
    }
    @Override
    public List<EmprestimoListar> consultarPorDataFinal(Date data) throws EmprestimoInexistenteException {
        
        List<Emprestimo> emprestimo = repositorioEmprestimo.buscarDateFinal(data); 
        if(emprestimo==null)
            throw new EmprestimoInexistenteException();
        List<EmprestimoListar> emp = new ArrayList<EmprestimoListar>();
        
        for(int i = 0; i < emprestimo.size(); i++){
            if(emprestimo.get(i).isAtivo()){
            EmprestimoListar emprestimoListar = new EmprestimoListar();
            emprestimoListar.setDataAnuncio(emprestimo.get(i).getDataAnuncio());
            emprestimoListar.setDataFinal(emprestimo.get(i).getDataFinal());
            emprestimoListar.setDataInicial(emprestimo.get(i).getDataInicial());
            emprestimoListar.setDataInteressado(emprestimo.get(i).getDataInteressado());
            emprestimoListar.setId(emprestimo.get(i).getId());
            emprestimoListar.setProduto(emprestimo.get(i).getProduto().getNome());
            emprestimoListar.setUsuarioAnunciador(emprestimo.get(i).getUsuarioAnunciador().getNome());
            if(emprestimo.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < emprestimo.get(i).getInteressados().size(); j++){
                    String nome = emprestimo.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                emprestimoListar.setInteressados(interessados);
            }
            if(emprestimo.get(i).getUsuarioEmprestado() != null){
            emprestimoListar.setUsuarioEmprestado(emprestimo.get(i).getUsuarioEmprestado().getNome());
            }
            emp.add(emprestimoListar);
            
            }
        }    
        return emp;   
    }

    @Override
    public void interesseEmprestimo(String email, long id) throws UsuarioInexistenteException, ProprioUsuarioAnunciadorException, EmprestimoJaRealizadoException {
            Emprestimo emprestimo = new Emprestimo();
            Usuario usuario = new Usuario();
            List<Usuario> listaUsuario =  new ArrayList<Usuario>();
            List<Emprestimo> listaEmprestimo =  new ArrayList<Emprestimo>();
            
            emprestimo = repositorioEmprestimo.findOne(id);
            if(emprestimo.getUsuarioEmprestado()!=null) throw new EmprestimoJaRealizadoException();
            else{
                usuario = servicosUsuario.ConsultarPorEmail(email);
                if(usuario.getEmail().equals(emprestimo.getUsuarioAnunciador().getEmail())) throw new ProprioUsuarioAnunciadorException();
                else{
                    listaEmprestimo = usuario.getProdutosInteressadosEmprestimo();
                    listaEmprestimo.add(emprestimo);
                //    usuario.setProdutosInteressadosEmprestimo(listaEmprestimo); // faltava colocar
                    listaUsuario = emprestimo.getInteressados();
                    listaUsuario.add(usuario);
                    emprestimo.setInteressados(listaUsuario);
                    emprestimo.getUsuarioAnunciador().setEmprestou(emprestimo.getUsuarioAnunciador().getEmprestou()+1);
                    servicosUsuario.atualizar(usuario, email);
                    if(emprestimo.getDataInteressado()==null){
                    emprestimo.setDataInteressado(new Date());
                    }
                    repositorioEmprestimo.save(emprestimo);
                }
            }
    }

    @Override
    public void realizarEmprestimo() throws UsuarioInexistenteException{
        List<Emprestimo> listaEmprestimo = (List<Emprestimo>) repositorioEmprestimo.findAll();
        
        for(int i= 0; i< listaEmprestimo.size(); i++){
            if(listaEmprestimo.get(i).getDataInteressado()!=null && listaEmprestimo.get(i).getUsuarioEmprestado()==null){
                Usuario usuarioEmprestado = new Usuario();
                List<Usuario> listaUsuarioInteressado = listaEmprestimo.get(i).getInteressados();
                if(listaUsuarioInteressado.size()==1){
                    usuarioEmprestado = listaUsuarioInteressado.get(0);
                }else{
                    usuarioEmprestado = listaUsuarioInteressado.get(0);
                    for(int j = 1; j < listaUsuarioInteressado.size(); j++){
                        if(usuarioEmprestado.getDoou()<listaUsuarioInteressado.get(j).getDoou()){
                            usuarioEmprestado = listaUsuarioInteressado.get(j);
                        }
                    }
                }
                listaEmprestimo.get(i).getUsuarioAnunciador().setDoou(listaEmprestimo.get(i).getUsuarioAnunciador().getDoou()+1);
                servicosUsuario.atualizar(listaEmprestimo.get(i).getUsuarioAnunciador(), listaEmprestimo.get(i).getUsuarioAnunciador().getEmail());                
                usuarioEmprestado.setEmprestado(usuarioEmprestado.getEmprestado()+1);
                List<Emprestimo> produtosEmprestimo = usuarioEmprestado.getProdutosEmprestimo();
                produtosEmprestimo.add(listaEmprestimo.get(i));
                usuarioEmprestado.setProdutosEmprestimo(produtosEmprestimo);
                servicosUsuario.atualizar(usuarioEmprestado, usuarioEmprestado.getEmail());
                listaEmprestimo.get(i).setUsuarioEmprestado(usuarioEmprestado);
                repositorioEmprestimo.save(listaEmprestimo.get(i));
            }
        }
    }
}
