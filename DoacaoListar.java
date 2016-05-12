/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.listar;

import br.upe.community.entidade.Doacao;
import br.upe.community.entidade.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author elisson
 */
public class DoacaoListar {
    private Long Id;
    private String produto;
    private String usuarioAnunciador;
    private String usuarioGanhador;
    private List<String> interessados;
    private Date dataAnuncio;
    private Date dataInteressado;
    private boolean ativo;

 
    
    public DoacaoListar(Long Id, String produto, String usuarioAnunciador, String usuarioGanhador, List<String> interessados, Date dataAnuncio, Date dataInteressado) {
        this.Id = Id;
        this.produto = produto;
        this.usuarioAnunciador = usuarioAnunciador;
        this.usuarioGanhador = usuarioGanhador;
        this.interessados = interessados;
        this.dataAnuncio = dataAnuncio;
        this.dataInteressado = dataInteressado;
    }
    public DoacaoListar(Doacao d) {
       
        this.ativo = d.isAtivo();
        this.Id = d.getId();
        this.produto = d.getProduto().getNome();
        this.usuarioAnunciador = d.getUsuarioAnunciador().getNome();
        this.interessados = new ArrayList<String>();
        this.usuarioGanhador = d.getUsuarioGanhador()!= null ? d.getUsuarioGanhador().getNome():null;
        for (Usuario interessado : d.getInteressados()) {
            this.interessados.add(interessado.getNome());
        }
        this.dataAnuncio = d.getDataAnuncio();
        this.dataInteressado = d.getDataInteressado();  
        
    }

    public DoacaoListar() {
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getUsuarioAnunciador() {
        return usuarioAnunciador;
    }

    public void setUsuarioAnunciador(String usuarioAnunciador) {
        this.usuarioAnunciador = usuarioAnunciador;
    }

    public String getUsuarioGanhador() {
        return usuarioGanhador;
    }

    public void setUsuarioGanhador(String usuarioGanhador) {
        this.usuarioGanhador = usuarioGanhador;
    }

    public List<String> getInteressados() {
        return interessados;
    }

    public void setInteressados(List<String> interessados) {
        this.interessados = interessados;
    }

    public Date getDataAnuncio() {
        return dataAnuncio;
    }

    public void setDataAnuncio(Date dataAnuncio) {
        this.dataAnuncio = dataAnuncio;
    }

    public Date getDataInteressado() {
        return dataInteressado;
    }

    public void setDataInteressado(Date dataInteressado) {
        this.dataInteressado = dataInteressado;
    }
    
    
}
