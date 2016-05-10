package br.upe.community;

import br.upe.community.excecao.UsuarioInexistenteException;
import br.upe.community.negocios.FachadaServicos;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceBasicUsageFixedDelay {
    @Autowired
    FachadaServicos fachada;
    
    @Scheduled(fixedDelay = 300000)
    public void demoServiceMethod()
    {
        try {
            fachada.realizarDoacao();
            fachada.realizarEmprestimo();
        } catch (UsuarioInexistenteException ex) {
            Logger.getLogger(DemoServiceBasicUsageFixedDelay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}