/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.listar;

import java.util.Date;
import java.util.List;

/**
 *
 * @author elisson
 */
public class EmprestimoListar {
    private Long Id;
    private String produto;
    private String usuarioAnunciador;
    private String usuarioEmprestado;
    private List<String> interessados;
    private Date dataAnuncio;
    private Date dataInteressado;
    private Date dataInicial;
    private Date dataFinal;

    public EmprestimoListar() {
    }

    public EmprestimoListar(Long Id, String produto, String usuarioAnunciador, String usuarioEmprestado, List<String> interessados, Date dataAnuncio, Date dataInteressado, Date dataInicial, Date dataFinal) {
        this.Id = Id;
        this.produto = produto;
        this.usuarioAnunciador = usuarioAnunciador;
        this.usuarioEmprestado = usuarioEmprestado;
        this.interessados = interessados;
        this.dataAnuncio = dataAnuncio;
        this.dataInteressado = dataInteressado;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
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

    public String getUsuarioEmprestado() {
        return usuarioEmprestado;
    }

    public void setUsuarioEmprestado(String usuarioEmprestado) {
        this.usuarioEmprestado = usuarioEmprestado;
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

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    
}
