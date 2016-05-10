/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.negocios;

import br.upe.community.entidade.Doacao;
import br.upe.community.entidade.Produto;

import br.upe.community.entidade.Usuario;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.DoacaoInexistenteException;
import br.upe.community.excecao.DoacaoJaRealizadaException;
import br.upe.community.excecao.ProprioUsuarioAnunciadorException;
import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.listar.DoacaoListar;
import br.upe.community.persistencia.RepositorioDoacao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServicoDoacaoImpl implements ServicoDoacao{
       
    @Autowired
    private RepositorioDoacao repositorioDoacao;
    
    @Autowired
    private ServicosUsuario servicoUsuario; 
       
    @Autowired
    private ServicosProduto servicoProduto;
    
    
    @Override
    public void cadastrar(Doacao doacao,Produto produto,String email,String nomeCategoria) throws UsuarioInexistenteException,CategoriaInexistenteException{
                
                Usuario usuario = servicoUsuario.ConsultarPorEmail(email);
                List<Doacao> listaDoacao = usuario.getProdutosAnunciadosDoacao();
        try {    
                doacao.setAtivo(true);
                doacao.setUsuarioAnunciador(usuario); 
                servicoProduto.cadastrar(produto,nomeCategoria);          
                doacao.setProduto(servicoProduto.consultarPorID(produto.getId()));
                repositorioDoacao.save(doacao);                                             
                listaDoacao.add(doacao);
                usuario.setProdutosAnunciadosDoacao(listaDoacao);
                servicoUsuario.atualizar(usuario, email);
             
        } catch (UsuarioInexistenteException e) {
            throw e;
            
        } catch (CategoriaInexistenteException ex) {
            throw ex;
        } 
    }

    @Override
    public void removerDoacao(long id) throws DoacaoInexistenteException {
         Doacao doacao = consultarPorId(id);
        if(doacao==null){
            throw new DoacaoInexistenteException();
        }else{
           doacao.setAtivo(false);
           repositorioDoacao.save(doacao);
        } 
    }
 
    @Override
    public List<DoacaoListar> listarDoacao() {
        
        List<Doacao> doacao = (List<Doacao>) repositorioDoacao.findAll();
        List<DoacaoListar> doacaoL = new ArrayList<DoacaoListar>();
        
        for(int i = 0; i < doacao.size(); i++){
            
            if(doacao.get(i).isAtivo()){
            DoacaoListar doacaoListar = new DoacaoListar();
            doacaoListar.setDataAnuncio(doacao.get(i).getDataAnuncio());
            doacaoListar.setDataInteressado(doacao.get(i).getDataInteressado());
            doacaoListar.setId(doacao.get(i).getId());
            doacaoListar.setProduto(doacao.get(i).getProduto().getNome());
            doacaoListar.setUsuarioAnunciador(doacao.get(i).getUsuarioAnunciador().getNome());
            if(doacao.get(i).getInteressados() != null){
                List<String> interessados = new ArrayList<String>();
                for(int j = 0; j < doacao.get(i).getInteressados().size(); j++){
                    String nome = doacao.get(i).getInteressados().get(j).getNome();
                    interessados.add(nome);
                }
                doacaoListar.setInteressados(interessados);
            }
            if(doacao.get(i).getUsuarioGanhador()!= null){
            doacaoListar.setUsuarioGanhador(doacao.get(i).getUsuarioGanhador().getNome());
            }
            doacaoL.add(doacaoListar); 
            }
        }
        return doacaoL;
    }
   
    @Override
    public List<DoacaoListar> consultarPorProduto(String nomeProduto) throws DoacaoInexistenteException {
        
        List<DoacaoListar> doacao = repositorioDoacao.consultarPorProduto(nomeProduto); 
        List<DoacaoListar> doacaoL = new ArrayList<DoacaoListar>();
        
        if(doacao==null){
            throw new DoacaoInexistenteException();
        }
        for(int i=0;i<doacao.size();i++){
            if(doacao.get(i).isAtivo()){
                doacaoL.add((DoacaoListar) doacao);
            }
        }  
        return doacaoL; 
    }
    
    @Override
    public List<DoacaoListar> consultarPorCategoria(String nomeCategoria) throws DoacaoInexistenteException {
        
        List<DoacaoListar> doacao = repositorioDoacao.consultarPorCategoria(nomeCategoria); 
        List<DoacaoListar> doacaoL = new ArrayList<DoacaoListar>();
        
        if(doacao==null){
            throw new DoacaoInexistenteException();
        }
        for(int i=0;i<doacao.size();i++){
            if(doacao.get(i).isAtivo()){
                doacaoL.add((DoacaoListar) doacao);
            }
        }  
        return doacaoL; 
    }
    

    @Override
    public List<DoacaoListar> consultarPorUsuarioAnunciador(String nomeUsuario) throws DoacaoInexistenteException {
        
        List<DoacaoListar> doacao = repositorioDoacao.consultarPorUsuarioAnunciador(nomeUsuario); 
        List<DoacaoListar> doacaoL = new ArrayList<DoacaoListar>();
        if(doacao==null){
            throw new DoacaoInexistenteException();
        }
        for(int i=0;i<doacao.size();i++){
            if(doacao.get(i).isAtivo()){
                doacaoL.add((DoacaoListar) doacao);
            }
        }  
        return doacaoL; 
    }
    
    
    @Override
    public List<DoacaoListar> consultarPorUsuarioGanhador(String nomeUsuario) throws DoacaoInexistenteException {
        
        List<DoacaoListar> doacao = repositorioDoacao.consultarPorUsuarioGanhador(nomeUsuario); 
        List<DoacaoListar> doacaoL = new ArrayList<DoacaoListar>();
        if(doacao==null){
            throw new DoacaoInexistenteException();
        }
        for(int i=0;i<doacao.size();i++){
            if(doacao.get(i).isAtivo()){
                doacaoL.add((DoacaoListar) doacao);
            }
        }  
        return doacaoL; 
    }
    

    @Override
    public List<DoacaoListar> consultarPorData(Date data) throws DoacaoInexistenteException {
        
        List<DoacaoListar> doacao = repositorioDoacao.consultarPorDataAnuncio(data); 
        List<DoacaoListar> doacaoL = new ArrayList<DoacaoListar>();
        if(doacao==null){
            throw new DoacaoInexistenteException();
        }
        for(int i=0;i<doacao.size();i++){
            if(doacao.get(i).isAtivo()){
                doacaoL.add((DoacaoListar) doacao);
            }
        }  
        return doacaoL;  
    }
    
    
    public Doacao consultarPorId(long id) throws DoacaoInexistenteException{
        Doacao doacaoAtualizar =  repositorioDoacao.findOne(id);
        if(doacaoAtualizar==null){
           throw new DoacaoInexistenteException();
        }
        return doacaoAtualizar;
    }
    
    @Override
    public void interesseDoacao(String email,long id) throws UsuarioInexistenteException, ProprioUsuarioAnunciadorException, DoacaoJaRealizadaException{
           
            Doacao doacao = new Doacao();
            Usuario usuario = new Usuario();
            List<Usuario> listaUsuario =  new ArrayList<Usuario>();
            List<Doacao> listadoacao =  new ArrayList<Doacao>();
        
            doacao = repositorioDoacao.findOne(id);
            if(doacao.getUsuarioGanhador()!=null) throw new DoacaoJaRealizadaException();
            else{
                usuario = servicoUsuario.ConsultarPorEmail(email);
                if(usuario.getEmail().equals(doacao.getUsuarioAnunciador().getEmail())) throw new ProprioUsuarioAnunciadorException();
                else{
                    listadoacao = usuario.getProdutosInteressadosDoacao();
                    listadoacao.add(doacao);
                    usuario.setProdutosInteressadosDoacao(listadoacao);   // faltava  dar set em produto interessados  
                    listaUsuario = doacao.getInteressados();
                    listaUsuario.add(usuario);
                    doacao.setInteressados(listaUsuario);
                    servicoUsuario.atualizar(usuario, email);
                    if(doacao.getDataInteressado()==null){
                        doacao.setDataInteressado(new Date());
                    }
                    repositorioDoacao.save(doacao);
                }
            }
    }

    @Override
    public void realizarDoacao() throws UsuarioInexistenteException{
        List<Doacao> listaDoacao = (List<Doacao>) repositorioDoacao.findAll();
        
        for(int i= 0; i< listaDoacao.size(); i++){
            
            if(listaDoacao.get(i).getDataInteressado()!=null && listaDoacao.get(i).getUsuarioGanhador()==null){
                Usuario usuarioGanhador = new Usuario();
                List<Usuario> listaUsuarioInteressado = listaDoacao.get(i).getInteressados();
                if(listaUsuarioInteressado.size()==1){
                    usuarioGanhador = listaUsuarioInteressado.get(0);
                }else{
                    usuarioGanhador = listaUsuarioInteressado.get(0);
                    for(int j = 1; j < listaUsuarioInteressado.size(); j++){
                        if(usuarioGanhador.getDoou()<listaUsuarioInteressado.get(j).getDoou()){
                            usuarioGanhador = listaUsuarioInteressado.get(j);
                        }
                    }
                }
                listaDoacao.get(i).getUsuarioAnunciador().setDoou(listaDoacao.get(i).getUsuarioAnunciador().getDoou()+1);
                servicoUsuario.atualizar(listaDoacao.get(i).getUsuarioAnunciador(), listaDoacao.get(i).getUsuarioAnunciador().getEmail());
                usuarioGanhador.setDoado(usuarioGanhador.getDoado()+1);
                List<Doacao> produtosGanhos = usuarioGanhador.getProdutosGanhos();
                produtosGanhos.add(listaDoacao.get(i));
                usuarioGanhador.setProdutosGanhos(produtosGanhos);
                servicoUsuario.atualizar(usuarioGanhador, usuarioGanhador.getEmail());
                listaDoacao.get(i).setUsuarioGanhador(usuarioGanhador);
                repositorioDoacao.save(listaDoacao.get(i));
            }
        }
        
    }


    
}
