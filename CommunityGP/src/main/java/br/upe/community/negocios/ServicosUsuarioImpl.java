package br.upe.community.negocios;

import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.excecao.UsuarioExistenteException;
import br.upe.community.entidade.Usuario;
import br.upe.community.listar.UsuarioListar;
import br.upe.community.persistencia.RepositorioUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicosUsuarioImpl implements ServicosUsuario {
    
    @Autowired
    private RepositorioUsuario repositorioUsuario;
    
    
    @Override
    public void cadastrar(Usuario usuario) throws UsuarioExistenteException, UsuarioInexistenteException {
        Usuario us = repositorioUsuario.findByEmail(usuario.getEmail());
        if(us!=null){
            if(!us.isAtivo()){
                us.setAtivo(true);
                us.setCPF(usuario.getCPF());
                us.setNome(usuario.getNome());
                us.setSenha(usuario.getSenha());
                us.setSobrenome(usuario.getSobrenome());
                atualizar(us, us.getEmail());
            }else{
                throw new UsuarioExistenteException();
            }
        }else{
            repositorioUsuario.save(usuario);
        }
    }

    @Override
    public void atualizar(Usuario usuario, String emailAtualizar) throws UsuarioInexistenteException {
        
        Usuario usuarioAtualizar = repositorioUsuario.findByEmail(usuario.getEmail());
        if(usuarioAtualizar==null)
            throw new UsuarioInexistenteException();
        usuarioAtualizar.setCPF(usuario.getCPF());
        usuarioAtualizar.setDoado(usuario.getDoado());
        usuarioAtualizar.setDoou(usuario.getDoou());
        usuarioAtualizar.setEmprestado(usuario.getEmprestado());
        usuarioAtualizar.setEmprestou(usuario.getEmprestou());
        usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setSobrenome(usuario.getSobrenome());
        usuarioAtualizar.setSenha(usuario.getSenha());
        usuarioAtualizar.setProdutosAnunciadoEmprestimo(usuario.getProdutosAnunciadoEmprestimo());
        usuarioAtualizar.setProdutosAnunciadosDoacao(usuario.getProdutosAnunciadosDoacao());
        usuarioAtualizar.setProdutosEmprestimo(usuario.getProdutosEmprestimo());
        usuarioAtualizar.setProdutosGanhos(usuario.getProdutosGanhos());
        usuarioAtualizar.setProdutosInteressadosDoacao(usuario.getProdutosInteressadosDoacao());
        usuarioAtualizar.setProdutosInteressadosEmprestimo(usuario.getProdutosInteressadosEmprestimo());
        usuarioAtualizar.setAtivo(usuario.isAtivo());
        repositorioUsuario.save(usuarioAtualizar);
    }

    @Override
    public void remover(String email) throws UsuarioInexistenteException {
        Usuario usuarioAtualizar = repositorioUsuario.findByEmail(email);
        if(usuarioAtualizar==null)
            throw new UsuarioInexistenteException();
        usuarioAtualizar.setAtivo(false);
        repositorioUsuario.save(usuarioAtualizar);
    }

    @Override
    public List<UsuarioListar> listarTodos() {
        
        List<UsuarioListar> retorno = new ArrayList<UsuarioListar>();
        List<Usuario> pesquisa = (List<Usuario>) repositorioUsuario.findAll();
        
        for(int i = 0; i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()){
                UsuarioListar ul = new UsuarioListar();
                ul.setCPF(pesquisa.get(i).getCPF());
                ul.setDoado(pesquisa.get(i).getDoado());
                ul.setDoou(pesquisa.get(i).getDoou());
                ul.setEmail(pesquisa.get(i).getEmail());
                ul.setEmprestado(pesquisa.get(i).getEmprestado());
                ul.setEmprestou(pesquisa.get(i).getEmprestou());
                ul.setId(pesquisa.get(i).getId());
                ul.setNome(pesquisa.get(i).getNome());
                ul.setSobrenome(pesquisa.get(i).getSobrenome());
                ul.setSenha(pesquisa.get(i).getSenha());
                if(pesquisa.get(i).getProdutosAnunciadoEmprestimo()!=null){
                    List<String> produtosAnunciados = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosAnunciadoEmprestimo().size(); j++){
                        String nome = pesquisa.get(i).getProdutosAnunciadoEmprestimo().get(j).getProduto().getNome();
                        produtosAnunciados.add(nome);
                    }
                    ul.setProdutosAnunciadoEmprestimo(produtosAnunciados);
                }
                if(pesquisa.get(i).getProdutosAnunciadosDoacao()!=null){
                    List<String> produtosAnunciados = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosAnunciadosDoacao().size(); j++){
                        String nome = pesquisa.get(i).getProdutosAnunciadosDoacao().get(j).getProduto().getNome();
                        produtosAnunciados.add(nome);
                    }
                    ul.setProdutosAnunciadosDoacao(produtosAnunciados);
                }
                if(pesquisa.get(i).getProdutosEmprestimo()!=null){
                    List<String> produtosGanhos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosEmprestimo().size(); j++){
                        String nome = pesquisa.get(i).getProdutosEmprestimo().get(j).getProduto().getNome();
                        produtosGanhos.add(nome);
                    }
                    ul.setProdutosEmprestimo(produtosGanhos);
                }
                if(pesquisa.get(i).getProdutosGanhos()!=null){
                    List<String> produtosGanhos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosGanhos().size(); j++){
                        String nome = pesquisa.get(i).getProdutosGanhos().get(j).getProduto().getNome();
                        produtosGanhos.add(nome);
                    }
                    ul.setProdutosGanhos(produtosGanhos);
                }
                if(pesquisa.get(i).getProdutosInteressadosDoacao()!=null){
                    List<String> produtosGanhos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosInteressadosDoacao().size(); j++){
                        String nome = pesquisa.get(i).getProdutosInteressadosDoacao().get(j).getProduto().getNome();
                        produtosGanhos.add(nome);
                    }
                    ul.setProdutosInteressadosDoacao(produtosGanhos);
                }
                if(pesquisa.get(i).getProdutosInteressadosEmprestimo()!=null){
                    List<String> produtosGanhos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosInteressadosEmprestimo().size(); j++){
                        String nome = pesquisa.get(i).getProdutosInteressadosEmprestimo().get(j).getProduto().getNome();
                        produtosGanhos.add(nome);
                    }
                    ul.setProdutosInteressadosEmprestimo(produtosGanhos);
                }
                retorno.add(ul);
            }
        }
        return retorno;
    }

    @Override
    public Usuario ConsultarPorEmail(String email) throws UsuarioInexistenteException {
        Usuario usuarioAtualizar = repositorioUsuario.findByEmail(email);
        if(usuarioAtualizar==null || !usuarioAtualizar.isAtivo())
            throw new UsuarioInexistenteException();
        return usuarioAtualizar;
    }
    
   

    @Override
    public List<UsuarioListar> ConsultarPorNome(String nome) throws UsuarioInexistenteException { 
        
        List<UsuarioListar> retorno = new ArrayList<UsuarioListar>();
        List<Usuario> pesquisa = repositorioUsuario.findByNome(nome);
        if(pesquisa==null)
            throw new UsuarioInexistenteException();
        for(int i = 0; i < pesquisa.size(); i++){
            if(pesquisa.get(i).isAtivo()){
                UsuarioListar ul = new UsuarioListar();
                ul.setCPF(pesquisa.get(i).getCPF());
                ul.setDoado(pesquisa.get(i).getDoado());
                ul.setDoou(pesquisa.get(i).getDoou());
                ul.setEmail(pesquisa.get(i).getEmail());
                ul.setEmprestado(pesquisa.get(i).getEmprestado());
                ul.setEmprestou(pesquisa.get(i).getEmprestou());
                ul.setId(pesquisa.get(i).getId());
                ul.setNome(pesquisa.get(i).getNome());
                ul.setSobrenome(pesquisa.get(i).getSobrenome());
                ul.setSenha(pesquisa.get(i).getSenha());
                if(pesquisa.get(i).getProdutosAnunciadoEmprestimo()!=null){
                    List<String> produtosAnunciados = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosAnunciadoEmprestimo().size(); j++){
                        String nomee = pesquisa.get(i).getProdutosAnunciadoEmprestimo().get(j).getProduto().getNome();
                        produtosAnunciados.add(nomee);
                    }
                    ul.setProdutosAnunciadoEmprestimo(produtosAnunciados);
                }
                if(pesquisa.get(i).getProdutosAnunciadosDoacao()!=null){
                    List<String> produtosAnunciados = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosAnunciadosDoacao().size(); j++){
                        String nomee = pesquisa.get(i).getProdutosAnunciadosDoacao().get(j).getProduto().getNome();
                        produtosAnunciados.add(nomee);
                    }
                    ul.setProdutosAnunciadosDoacao(produtosAnunciados);
                }
                if(pesquisa.get(i).getProdutosEmprestimo()!=null){
                    List<String> produtosGanhos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosEmprestimo().size(); j++){
                        String nomee = pesquisa.get(i).getProdutosEmprestimo().get(j).getProduto().getNome();
                        produtosGanhos.add(nomee);
                    }
                    ul.setProdutosEmprestimo(produtosGanhos);
                }
                if(pesquisa.get(i).getProdutosGanhos()!=null){
                    List<String> produtosGanhos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosGanhos().size(); j++){
                        String nomee = pesquisa.get(i).getProdutosGanhos().get(j).getProduto().getNome();
                        produtosGanhos.add(nomee);
                    }
                    ul.setProdutosGanhos(produtosGanhos);
                }
                if(pesquisa.get(i).getProdutosInteressadosDoacao()!=null){
                    List<String> produtosGanhos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosInteressadosDoacao().size(); j++){
                        String nomee = pesquisa.get(i).getProdutosInteressadosDoacao().get(j).getProduto().getNome();
                        produtosGanhos.add(nomee);
                    }
                    ul.setProdutosInteressadosDoacao(produtosGanhos);
                }
                if(pesquisa.get(i).getProdutosInteressadosEmprestimo()!=null){
                    List<String> produtosGanhos = new ArrayList<String>();
                    for(int j = 0; j < pesquisa.get(i).getProdutosInteressadosEmprestimo().size(); j++){
                        String nomee = pesquisa.get(i).getProdutosInteressadosEmprestimo().get(j).getProduto().getNome();
                        produtosGanhos.add(nomee);
                    }
                    ul.setProdutosInteressadosEmprestimo(produtosGanhos);
                }
                retorno.add(ul);
            }
        }
        return retorno;
    }
    
}
