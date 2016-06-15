/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upe.community.listar;

import br.upe.community.entidade.Endereco;
import java.util.List;

/**
 *
 * @author elisson
 */
public class UsuarioListar {
    private Long Id;
    private String nome;
    private String sobrenome;
    private String CPF;
    private String senha;
    private String email;
    private Endereco endereco;
    private int doou;
    private int doado;
    private int emprestou;
    private int emprestado;
    private List<String> produtosAnunciadosDoacao;
    private List<String> produtosGanhos;
    private List<String> produtosEmprestimo;
    private List<String> produtosAnunciadoEmprestimo;
    private List<String> produtosInteressadosDoacao;
    private List<String> produtosInteressadosEmprestimo;

    public UsuarioListar() {
    }

    public UsuarioListar(Long Id, String nome, String sobrenome, String CPF, String senha, String email, Endereco endereco, int doou, int doado, int emprestou, int emprestado, List<String> produtosAnunciadosDoacao, List<String> produtosGanhos, List<String> produtosEmprestimo, List<String> produtosAnunciadoEmprestimo, List<String> produtosInteressadosDoacao, List<String> produtosInteressadosEmprestimo) {
        this.Id = Id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.CPF = CPF;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.doou = doou;
        this.doado = doado;
        this.emprestou = emprestou;
        this.emprestado = emprestado;
        this.produtosAnunciadosDoacao = produtosAnunciadosDoacao;
        this.produtosGanhos = produtosGanhos;
        this.produtosEmprestimo = produtosEmprestimo;
        this.produtosAnunciadoEmprestimo = produtosAnunciadoEmprestimo;
        this.produtosInteressadosDoacao = produtosInteressadosDoacao;
        this.produtosInteressadosEmprestimo = produtosInteressadosEmprestimo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getDoou() {
        return doou;
    }

    public void setDoou(int doou) {
        this.doou = doou;
    }

    public int getDoado() {
        return doado;
    }

    public void setDoado(int doado) {
        this.doado = doado;
    }

    public int getEmprestou() {
        return emprestou;
    }

    public void setEmprestou(int emprestou) {
        this.emprestou = emprestou;
    }

    public int getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(int emprestado) {
        this.emprestado = emprestado;
    }

    public List<String> getProdutosAnunciadosDoacao() {
        return produtosAnunciadosDoacao;
    }

    public void setProdutosAnunciadosDoacao(List<String> produtosAnunciadosDoacao) {
        this.produtosAnunciadosDoacao = produtosAnunciadosDoacao;
    }

    public List<String> getProdutosGanhos() {
        return produtosGanhos;
    }

    public void setProdutosGanhos(List<String> produtosGanhos) {
        this.produtosGanhos = produtosGanhos;
    }

    public List<String> getProdutosEmprestimo() {
        return produtosEmprestimo;
    }

    public void setProdutosEmprestimo(List<String> produtosEmprestimo) {
        this.produtosEmprestimo = produtosEmprestimo;
    }

    public List<String> getProdutosAnunciadoEmprestimo() {
        return produtosAnunciadoEmprestimo;
    }

    public void setProdutosAnunciadoEmprestimo(List<String> produtosAnunciadoEmprestimo) {
        this.produtosAnunciadoEmprestimo = produtosAnunciadoEmprestimo;
    }

    public List<String> getProdutosInteressadosDoacao() {
        return produtosInteressadosDoacao;
    }

    public void setProdutosInteressadosDoacao(List<String> produtosInteressadosDoacao) {
        this.produtosInteressadosDoacao = produtosInteressadosDoacao;
    }

    public List<String> getProdutosInteressadosEmprestimo() {
        return produtosInteressadosEmprestimo;
    }

    public void setProdutosInteressadosEmprestimo(List<String> produtosInteressadosEmprestimo) {
        this.produtosInteressadosEmprestimo = produtosInteressadosEmprestimo;
    }

    
}
