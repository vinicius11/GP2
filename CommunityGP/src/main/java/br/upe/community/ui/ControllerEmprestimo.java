package br.upe.community.ui;


import br.upe.community.entidade.Emprestimo;
import br.upe.community.entidade.Produto;
import br.upe.community.excecao.CategoriaInexistenteException;
import br.upe.community.excecao.EmprestimoInexistenteException;
import br.upe.community.excecao.EmprestimoJaRealizadoException;
import br.upe.community.excecao.ProprioUsuarioAnunciadorException;
import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.listar.EmprestimoListar;
import br.upe.community.negocios.FachadaServicos;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/emprestimo")
public class ControllerEmprestimo {
    @Autowired
    private FachadaServicos fachada;
    
    @RequestMapping(value = "/listar", headers="Accept=*/*", method = RequestMethod.GET)
    public @ResponseBody List<EmprestimoListar> listarTodos(){
        return fachada.listarEmprestimo();
    }
    
    @RequestMapping(value = "/cadastrar", headers="Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> adicionarEmprestimo(Emprestimo emprestimo,Produto produto,String emailUsuario,String nomeCategoria){ 
        try {
            fachada.cadastrar(emprestimo,produto,emailUsuario,nomeCategoria);
            return new ResponseEntity<String>(HttpStatus.OK);
        } catch (UsuarioInexistenteException e) {
            return new ResponseEntity<UsuarioInexistenteException>(e,HttpStatus.BAD_REQUEST);
        } catch (CategoriaInexistenteException ex) {
            return new ResponseEntity<CategoriaInexistenteException>(ex,HttpStatus.BAD_REQUEST);

        }
    }
    @RequestMapping(value="/remover",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> removerEmprestimo(long id){
        
        try{
            fachada.removerEmprestimo(id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(EmprestimoInexistenteException e){
            return new ResponseEntity<EmprestimoInexistenteException>(e,HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping(value = "/consultar-por-produto")
    public @ResponseBody List<EmprestimoListar> consultarPorProduto(String nomeProduto) {
        try {
            return fachada.consultarPorProdutoEmprestimo(nomeProduto);
        } catch (EmprestimoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-categoria")
    public @ResponseBody List<EmprestimoListar> consultarPorCategoria(String nomeCategoria) {
        try {
            return fachada.consultarPorCategoriaEmprestimo(nomeCategoria);
        } catch (EmprestimoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-usuario-anunciador")
    public @ResponseBody List<EmprestimoListar> consultarPorUsuarioAnunciador(String nomeUsuarioAnunciador) {
        try {
            return fachada.consultarPorUsuarioAnunciadorEmprestimo(nomeUsuarioAnunciador);
        } catch (EmprestimoInexistenteException ex) {
            return null;
        }
    }
    
    
    @RequestMapping(value = "/consultar-por-usuario-emprestado")
    public @ResponseBody List<EmprestimoListar> consultarPorUsuarioEmprestado(String nomeUsuarioEmprestado) {
        try {
            return fachada.consultarPorUsuarioEmprestado(nomeUsuarioEmprestado);
        } catch (EmprestimoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-data-anuncio")
    public @ResponseBody List<EmprestimoListar> consultarPorDataAnuncio(Date dataAnuncio) {
        try {
            return fachada.consultarPorDataAnuncio(dataAnuncio);
        } catch (EmprestimoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-data-final")
    public @ResponseBody List<EmprestimoListar> consultarPorDataFinal(Date dataFinal) {
        try {
            return fachada.consultarPorDataFinal(dataFinal);
        } catch (EmprestimoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-data-inicial")
    public @ResponseBody List<EmprestimoListar> consultarPorDataInicial(Date dataInicial) {
        try {
            return fachada.consultarPorDataInicial(dataInicial);
        } catch (EmprestimoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value = "/consultar-por-data-interessado")
    public @ResponseBody List<EmprestimoListar> consultarPorDataInteressado(Date dataInteressado) {
        try {
            return fachada.consultarPorDataInteressado(dataInteressado);
        } catch (EmprestimoInexistenteException ex) {
            return null;
        }
    }
    
    @RequestMapping(value="/interessadoEmprestimo",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> interesseEmprestimo(String email,long id){
        
        try{
            fachada.interesseEmprestimo(email, id);
            return new ResponseEntity<String>(HttpStatus.OK);
        }catch(UsuarioInexistenteException e){
           return new ResponseEntity<UsuarioInexistenteException>(e,HttpStatus.BAD_REQUEST);
        } catch (ProprioUsuarioAnunciadorException ex) {
            return new ResponseEntity<ProprioUsuarioAnunciadorException>(ex,HttpStatus.BAD_REQUEST);
        } catch (EmprestimoJaRealizadoException ex) {
            return new ResponseEntity<EmprestimoJaRealizadoException>(ex,HttpStatus.BAD_REQUEST);
        }
    }
    
    //--------------------------------------------------------------------------------------
    
    @RequestMapping("/cadastro")
    public String formCadastrar() {
        return "cadastroEmprestimo";
    }
    @RequestMapping("/interesseEmprestimo")
    public String formInteresse(){
        return "interesseEmprestimo";
    }
    @RequestMapping("/remove")
    public String formDeletar(){
        return "DelatarEmprestimo";
    }
            
    @RequestMapping("/atualiza")
    public String formAtualizar() {
        return "atualizaEmprestimo";
    }
    @RequestMapping("/consultaProduto")
    public String formConsultar() {
        return "consultaProdutoEmprestimo";
    }
    @RequestMapping("/consultaCategoria")
    public String formConsultar2() {
        return "consultaCategoriaEmprestimo";
    }
    @RequestMapping("/consultaUsuarioAnunciador")
    public String formConsultar3() {
        return "consultaUsuarioAnunciadorEmprestimo";
    }
    @RequestMapping("/consultaUsuarioEmprestado")
    public String formConsultar4() {
        return "consultaUsuarioEmprestado";
    }
    @RequestMapping("/consultaDataInicial")
    public String formConsultar5() {
        return "consultaDataInicialEmprestimo";
    }
    @RequestMapping("/consultaDataFinal")
    public String formConsultar6() {
        return "consultaDataFinalEmprestimo";
    }
    @RequestMapping("/consultaDataAnuncio")
    public String formConsultar7() {
        return "consultaDataAnuncioEmprestimo";
    }
    @RequestMapping("/consultaDataInteresse")
    public String formConsultar8() {
        return "consultaDataInteressadoEmprestimo";
    }
}
