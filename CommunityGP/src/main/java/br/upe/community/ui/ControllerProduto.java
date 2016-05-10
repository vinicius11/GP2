package br.upe.community.ui;

import br.upe.community.entidade.Categoria;
import br.upe.community.entidade.Produto;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.ProdutoInexistenteException;
import br.upe.community.excecao.UsuarioInexistenteException;
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
@RequestMapping("/produto")
public class ControllerProduto {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerUsuario.class);
    @Autowired
    private FachadaServicos fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET)
    public @ResponseBody List<Produto> listarTodos(){
        return fachada.listarProdutos();
    }
    
    @RequestMapping(value = "/consultar-por-nome")
    public @ResponseBody List<Produto> consultarPorNome(String nome) {
        return fachada.consultarPorNomeProduto(nome);
    }
    
    
    @RequestMapping(value = "/consultar-por-categoria")
    public @ResponseBody List<Produto> consultarPorCategoria(String nome) {
        try {
            return fachada.consultarPorCategoriaProduto(nome);
        } catch (CategoriaInexistenteException ex) {
            return (List<Produto>) new ResponseEntity<CategoriaInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarProduto(Produto produto, String categoriaNome) {
        try {
            fachada.cadastrar(produto, categoriaNome);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CategoriaInexistenteException ex) {
            return new ResponseEntity<CategoriaInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
            
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarProduto(Produto produto, Long IDatualizado, String categoriaNome) {
        try{
            fachada.atualizar(produto, IDatualizado, categoriaNome);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (CategoriaInexistenteException ex) {
            return new ResponseEntity<CategoriaInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        } catch (ProdutoInexistenteException ex) {
            return new ResponseEntity<ProdutoInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarProduto(Long ID) {
        fachada.deletarProduto(ID);
        return new ResponseEntity<String>(HttpStatus.OK);
        
    }
    
    //-----------------------------------------------------------------------------------
    
     @RequestMapping("/cadastro")
    public String formCadastrar() {
        return "cadastroProduto";
    }
    
    @RequestMapping("/atualiza")
    public String formAtualizar() {
        return "atualizaProduto";
    }
    @RequestMapping("/consultaPorNome")
    public String formConsultar() {
        return "consultaPorNomeProduto";
    }
    @RequestMapping("/consultaPorCategoria")
    public String formConsultarPorCate() {
        return "consultaPorCategoriaProduto";
    }
    @RequestMapping("/deleta")
    public String formDeletar() {
        return "deletaProduto";
    }
}
