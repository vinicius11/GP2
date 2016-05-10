/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.ui;

import br.upe.community.entidade.Doacao;
import br.upe.community.entidade.Produto;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.DoacaoInexistenteException;
import br.upe.community.excecao.DoacaoJaRealizadaException;
import br.upe.community.excecao.ProprioUsuarioAnunciadorException;
import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.listar.DoacaoListar;
import br.upe.community.negocios.FachadaServicos;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/doacao")
public class ControllerDoacao {
        
    static Logger log = Logger.getLogger(ControllerDoacao.class);
    @Autowired
    private FachadaServicos fachada;
    
    @RequestMapping(value="/cadastrar",produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> cadastrarDoacao(Doacao doacao,Produto produto,String emailUsuario,String nomeCategoria) {
        try {
            fachada.cadastrarDoacao(doacao,produto,emailUsuario,nomeCategoria);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioInexistenteException e) {
            return new ResponseEntity<UsuarioInexistenteException>(e,HttpStatus.BAD_REQUEST);
        } catch (CategoriaInexistenteException ex) {
            return new ResponseEntity<CategoriaInexistenteException>(ex,HttpStatus.BAD_REQUEST);

        }             
    }
    @RequestMapping(value = "/listar")
    public @ResponseBody List<DoacaoListar> listarDoacao(){
        return fachada.listarDoacao();
    }
    
    @RequestMapping(value="/remover",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> removerDoacao(long id){
        
        try{
            fachada.removerDoacao(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(DoacaoInexistenteException e){
            return new ResponseEntity<DoacaoInexistenteException>(e,HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value="/interessadoDoacao",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> interesseDoacao(String email,long id){
        
        try{
            fachada.interesseDoacao(email, id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(UsuarioInexistenteException e){
           return new ResponseEntity<UsuarioInexistenteException>(e,HttpStatus.BAD_REQUEST);
        } catch (ProprioUsuarioAnunciadorException ex) {
            return new ResponseEntity<ProprioUsuarioAnunciadorException>(ex,HttpStatus.BAD_REQUEST);
        } catch (DoacaoJaRealizadaException ex) {
            return new ResponseEntity<DoacaoJaRealizadaException>(ex,HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/consultar-por-produto")
    public @ResponseBody List<DoacaoListar> consultarPorProduto(String nomeProduto) {
        try {
            System.out.println("OPA!");
            return fachada.consultarPorProduto(nomeProduto);
        } catch (DoacaoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-categoria")
    public @ResponseBody List<DoacaoListar> consultarPorCategoria(String nomeCategoria) {
        try {
            return fachada.consultarPorCategoria(nomeCategoria);
        } catch (DoacaoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-usuario-anunciador")
    public @ResponseBody List<DoacaoListar> consultarPorUsuarioAnunciador(String nomeUsuarioAnunciador) {
        try {
            return fachada.consultarPorUsuarioAnunciador(nomeUsuarioAnunciador);
        } catch (DoacaoInexistenteException ex) {
            return null;
        }
    }
    
    
    @RequestMapping(value = "/consultar-por-usuario-ganhador")
    public @ResponseBody List<DoacaoListar> consultarPorUsuarioEmprestado(String nomeUsuarioGanhador) {
        try {
            return fachada.consultarPorUsuarioGanhador(nomeUsuarioGanhador);
        } catch (DoacaoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-data-anuncio")
    public @ResponseBody List<DoacaoListar> consultarPorDataAnuncio(Date dataAnuncio) {
        try {
            return fachada.consultarPorData(dataAnuncio);
        } catch (DoacaoInexistenteException ex) {
            return null;
        }
    }
    
    //--------------------------------------------------------------------------------------------
    
    @RequestMapping("/cadastro")
    public String formCadastrar(){
        return "CadastroDoacao";                
    }
    @RequestMapping("/lista")
    public String formListar(){
        return "ListaDoacao";
    } 
    @RequestMapping("/remove")
    public String formDeletar(){
        return "DeletarDoacao";
    }
    
    @RequestMapping("/interesseDoacao")
    public String formInteresse(){
        return "InteresseDoacao";
    }
    @RequestMapping("/consultaProduto")
    public String formConsultar() {
        return "consultaProdutoDoacao";
    }
    @RequestMapping("/consultaCategoria")
    public String formConsultar2() {
        return "consultaCategoriaDoacao";
    }
    @RequestMapping("/consultaUsuarioAnunciador")
    public String formConsultar3() {
        return "consultaUsuarioAnunciadorDoacao";
    }
    @RequestMapping("/consultaUsuarioGanhador")
    public String formConsultar4() {
        return "consultaUsuarioGanhador";
    }
    
    @RequestMapping("/consultaDataAnuncio")
    public String formConsultar7() {
        return "consultaDataAnuncioDoacao";
    }
}
