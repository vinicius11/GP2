/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.ui;

import br.upe.community.entidade.Categoria;
import br.upe.community.entidade.Produto;
import br.upe.community.entidade.Usuario;
import br.upe.community.excecao.CategoriaExistenteException;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.DoacaoInexistenteException;
import br.upe.community.excecao.UsuarioExistenteException;
import br.upe.community.listar.DoacaoListar;
import br.upe.community.negocios.FachadaServicos;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/categoria")
public class ControllerCategoria {
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerUsuario.class);
    @Autowired
    private FachadaServicos fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET)
    public @ResponseBody List<Categoria> listarTodos(){
        return fachada.listarCategorias();
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarCategoria(Categoria categoria) {
        try{
            fachada.cadastrar(categoria);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(CategoriaExistenteException e){
            return new ResponseEntity<CategoriaExistenteException>(e, HttpStatus.BAD_REQUEST);
        }    
    }
    
    @RequestMapping(value = "/consultar")
    public @ResponseBody Categoria consultar(String nome) {
        try {
            return fachada.consultarPorNomeCategoria(nome);
        } catch (CategoriaInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarCategoria(String nomeAtual, String nomeAtualizar) {
        Categoria categoria;
        try {
            categoria = fachada.consultarPorNomeCategoria(nomeAtual);
            categoria.setNome(nomeAtualizar);
            fachada.atualizar(nomeAtual,nomeAtualizar);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CategoriaInexistenteException ex) {
            return new ResponseEntity<CategoriaInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
        
    }
    
   
    
    //-----------------------------------------------------------------------------
    
    @RequestMapping("/cadastro")
    public String formCadastrar() {
        return "cadastroCategoria";
    }
    
    @RequestMapping("/atualiza")
    public String formAtualizar() {
        return "atualizaCategoria";
    }
    
    @RequestMapping("/consulta")
    public String formConsultar() {
        return "consultaCategoria";
    }
}
