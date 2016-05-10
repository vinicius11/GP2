package br.upe.community.ui;

import br.upe.community.entidade.Usuario;
import br.upe.community.excecao.UsuarioExistenteException;
import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.listar.UsuarioListar;
import br.upe.community.negocios.FachadaServicos;
import java.util.ArrayList;
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
@RequestMapping("/usuario")
public class ControllerUsuario {
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(ControllerUsuario.class);
    @Autowired
    private FachadaServicos fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET)
    public @ResponseBody List<UsuarioListar> listarTodos(){
        return fachada.listarUsuario();
    }
    
    @RequestMapping(value = "/consultar")
    public @ResponseBody List<UsuarioListar> consultar(String nome){
        try{
            return fachada.ConsultarPorNome(nome);
        } catch (UsuarioInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarUsuario(Usuario usuario) {
        try {
            fachada.cadastrar(usuario);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioExistenteException ex) {
            return new ResponseEntity<UsuarioExistenteException>(ex, HttpStatus.BAD_REQUEST);
        } catch (UsuarioInexistenteException ex1) {
            return new ResponseEntity<UsuarioInexistenteException>(ex1, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/atualizar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> atualizarUsuario(Usuario usuario, String emailAtualizar) {
        try {
            fachada.atualizar(usuario, emailAtualizar);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioInexistenteException ex) {
            return new ResponseEntity<UsuarioInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/deletar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> deletarUsuario(String email) {
        try {
            fachada.remover(email);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioInexistenteException ex) {
            return new ResponseEntity<UsuarioInexistenteException>(ex, HttpStatus.BAD_REQUEST);
        }
    }
    
    
    
    //---------------------------------------------------------------------
    
    @RequestMapping("/cadastro")
    public String formCadastrar() {
        return "CadastroUsuario";
    }
    
    @RequestMapping("/atualiza")
    public String formAtualizar() {
        return "atualizaUsuario";
    }
    @RequestMapping("/consulta")
    public String formConsultar() {
        return "ConsultaUsuario";
    }
    @RequestMapping("/deleta")
    public String formDeletar() {
        return "DeletaUsuario";
    }
}
