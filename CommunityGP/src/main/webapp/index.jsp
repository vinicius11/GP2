<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
        <script type="text/javascript" src="material.js"></script>
        <script type="text/javascript" src="javascript.js"></script>
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript">
            google.load("jquery", "1.3.2", {uncompressed:true});
        </script>
        <title>Community</title>
    </head>
    
    <body>
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">

        <!--Cabeçalho-->
                      
        <header class="mdl-layout__header">
            <div class="mdl-layout--large-screen-only mdl-layout__header-row"> <h3>COMMUNITY</h3></div>
            <div class="mdl-layout--large-screen-only mdl-layout__header-row"></div>
                <div class="mdl-layout__tab-bar mdl-js-ripple-effect mdl-color--primary-dark">                       
                  <div class="mdl-tabs__tab-bar">  
                    <a  href="#Inicio" class="mdl-layout__tab is-active">Inicio</a> 
                    <a  href="#Doações" class="mdl-layout__tab">Doações</a>
                    <a  href="#Emprestimos" class="mdl-layout__tab">Emprestimos</a>                
                    <a  href="#Sobre" class="mdl-layout__tab">Sobre</a>    
                  </div>
                </div>           
        </header>
        
        <div class="mdl-layout__drawer">
                <span class="mdl-layout-title">Usuario</span>
                <nav class="mdl-navigation">
                    <a class="mdl-navigation__link"href="">Cadastrar</a>
                </nav>
        </div>
        

        <main class="mdl-layout__content">
            
            <div class="mdl-layout__tab-panel is-active" id="Inicio">
                <div class="mdl-grid portfolio-max-width">
                <div class="mdl-grid mdl-cell mdl-cell--12-col mdl-cell--4-col-tablet mdl-card mdl-shadow--4dp">
                    <div class="mdl-card__media mdl-cell mdl-cell--12-col-tablet">
                        <img class="article-image" src="Comunidade.jpg" border="0"  alt="">
                    </div>
               <div class="mdl-cell mdl-cell--8-col">
                        <h2 class="mdl-card__title-text">COMMUNITY.com</h2>
                        <div class="mdl-card__supporting-text padding-top">
                            
                            
                        </div>
                        <div class="mdl-card__supporting-text no-left-padding">
                            <p>O Jeito mais fácil de doar e receber</p>
                        </div>
                </div>
                </div>
                </div>
            </div>       
            
            <div class="mdl-layout__tab-panel" id="Doações">           
               
                <div id="Opções" class="mdl-card"> 
                   <button  id="Cadastrar" onclick="verificar('FormCadastro')" class="mdl-button mdl-js-button mdl-button--raised">
                     Cadastrar
                    </button>
                    <button id="Consultar" onclick="verificar('FormConsultarProduto')" class="mdl-button mdl-js-button mdl-button--raised">
                     Consultar por Produto
                    </button>
                     <button id="Consultar" onclick="verificar('FormConsultarData')" class="mdl-button mdl-js-button mdl-button--raised">
                     Consultar por Data
                    </button>
                     <button id="Consultar" onclick="verificar('FormConsultarCategoria')" class="mdl-button mdl-js-button mdl-button--raised">
                     Consultar por Categoria
                    </button>
                     <button id="Consultar" onclick="verificar('FormConsultarUsuario')" class="mdl-button mdl-js-button mdl-button--raised">
                     Consultar por Usuario
                    </button>
                    <button id="Listar" onclick="verificar('FormListar')" class="mdl-button mdl-js-button mdl-button--raised">
                     Listar
                    </button>  
                   
                </div> 
              
                
                
                <div id="FormCadastro" class="Formulario" style = "display: none">
                    
                        <form action="doacao/cadastrar" method="POST">

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                                <input type="text" class="mdl-textfield__input" id="input_produto" name="nome"/>
                                <label for="input_produto" class="mdl-textfield__label">Nome do Produto</label>
                            </div>

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                 <input type="email" class="mdl-textfield__input" id="input_email" name="emailUsuario"/>
                                <label for="input_email" class="mdl-textfield__label">Email</label> 
                            </div>
                             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                                <input type="text" class="mdl-textfield__input" id="input_estado" name="estado"/>
                                <label for="input_estado" class="mdl-textfield__label">Estado do Produto</label>
                            </div>
                             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                                <input type="text" class="mdl-textfield__input" id="input_categoria" name="nomeCategoria"/>
                                <label for="input_categoria" class="mdl-textfield__label">Nome da Categoria</label>
                            </div>
                             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                                <input type="text" class="mdl-textfield__input" id="input_data" name="dataAnuncio" pattern="[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]"/>
                                <label for="input_data" class="mdl-textfield__label">Data do anuncio</label>
                            </div>
                            <br>
                            <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
                       </form>
                </div>
                
                          
                 <!-- Fim  do formulario de cadastro-->
                
                <div id="FormConsultarProduto" class="Formulario" style="display: none">
                    <form>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                            <input type="text" class="mdl-textfield__input" id="consulta_produto" name="nomeProduto"/>
                            <label for="consulta_produto" class="mdl-textfield__label">Nome do Produto</label>
                        </div>
                         <br>
                         <button id="buttonConsultarProduto" onclick="consultarProduto()" type="button" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
         
                    </form>    
                </div>
                
                
                 
                 <!-- Fim  do formulario de consulta por Produto--> 
                
                
                   <div id="FormConsultarCategoria" class="Formulario" style="display: none">
                     <form>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                            <input type="text" class="mdl-textfield__input" id="consultaproduto" name="nomeCategoria"/>
                            <label for="consulta_categoria" class="mdl-textfield__label">Nome da Categoria</label>
                        </div>
                           <br>
                           <button type="button" onclick="consultarCategoria()" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
                    </form>
                </div> <!-- Fim  do formulario de consulta por Categoria--> 
                
                  <div id="FormConsultarData" class="Formulario" style="display: none">
                     <form>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                            <input type="text" class="mdl-textfield__input" id="data" name="dataAnuncio"/>
                            <label for="data" class="mdl-textfield__label">Data do anuncio</label>
                    </div>
                         <br>
                         <button type="button" onclick="consultarData()" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
                    </form>
                </div>       <!-- Fim  do formulario de consulta por data--> 
                                
                <div id="FormConsultarUsuario" class="Formulario" style="display: none">
                    <form>
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                            <input type="text" class="mdl-textfield__input" id="consulta_usuario" name="nomeUsuarioAnunciador"/>
                            <label for="consulta_usuario" class="mdl-textfield__label">Nome do Usuario</label>
                    </div>
                        <br> 
                        <button type="button" onclick="consultarUsuario()" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
                    </form>
                </div>   <!-- Fim  do formulario de consulta por usuario--> 
                   
             
                <div id="FormListar" class="Formulario" style="display: none">
                    
                    <script>
                        var obj = new listaDoacao();
                        obj.resgatarValores();
                    </script>
                </div>
              
               
                
            </div> <!--Painel de doações-->
            
            <div class="mdl-layout__tab-panel" id="Emprestimos">           
               
                <div id="Opções" class="mdl-card"> 
                   <button  id="CadastrarEmprestimo" onclick="verificarEmprestimo('FormCadastroEmprestimo')" class="mdl-button mdl-js-button mdl-button--raised">
                     Cadastrar
                    </button>
                    <button id="Consultar" onclick="verificarEmprestimo('FormConsultarProdutoEmprestimo')" class="mdl-button mdl-js-button mdl-button--raised">
                     Consultar por Produto
                    </button>
                     <button id="Consultar" onclick="verificarEmprestimo('FormConsultarDataEmprestimo')" class="mdl-button mdl-js-button mdl-button--raised">
                     Consultar por Data
                    </button>
                     <button id="Consultar" onclick="verificarEmprestimo('FormConsultarCategoriaEmprestimo')" class="mdl-button mdl-js-button mdl-button--raised">
                     Consultar por Categoria
                    </button>
                     <button id="Consultar" onclick="verificarEmprestimo('FormConsultarUsuarioEmprestimo')" class="mdl-button mdl-js-button mdl-button--raised">
                     Consultar por Usuario
                    </button>
                    <button id="Listar" onclick="verificarEmprestimo('FormListarEmprestimo')" class="mdl-button mdl-js-button mdl-button--raised">
                     Listar
                    </button>  
                   
                </div> 
                
                <div id="FormCadastroEmprestimo" class="Formulario" style = "display: none">
                    
                        <form action="emprestimo/cadastrar" method="POST">

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                                <input type="text" class="mdl-textfield__input" id="input_produto" name="nome"/>
                                <label for="input_produto" class="mdl-textfield__label">Nome do Produto</label>
                            </div>

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                 <input type="email" class="mdl-textfield__input" id="input_email" name="emailUsuario"/>
                                <label for="input_email" class="mdl-textfield__label">Email</label> 
                            </div>
                             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                                <input type="text" class="mdl-textfield__input" id="input_estado" name="estado"/>
                                <label for="input_estado" class="mdl-textfield__label">Estado do Produto</label>
                            </div>
                             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                                <input type="text" class="mdl-textfield__input" id="input_categoria" name="nomeCategoria"/>
                                <label for="input_categoria" class="mdl-textfield__label">Nome da Categoria</label>
                            </div>
                             <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                                <input type="text" class="mdl-textfield__input" id="input_data" name="dataAnuncio" pattern="[0-3][0-9]/[0-1][0-9]/[0-9][0-9][0-9][0-9]"/>
                                <label for="input_data" class="mdl-textfield__label">Data do anuncio</label>
                            </div>
                            <br>
                            <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
                       </form>
                </div>
                
                          
                 <!-- Fim  do formulario de cadastro-->
                
                <div id="FormConsultarProdutoEmprestimo" class="Formulario" style="display: none">
                    <form action="emprestimo/consultar-por-produto" method="POST">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                            <input type="text" class="mdl-textfield__input" id="consulta_produto" name="nomeProduto"/>
                            <label for="consulta_produto" class="mdl-textfield__label">Nome do Produto</label>
                        </div>
                         <br>
                         <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
         
                    </form>    
                </div>     <!-- Fim  do formulario de consulta por Produto--> 
                
                   <div id="FormConsultarCategoriaEmprestimo" class="Formulario" style="display: none">
                     <form action="emprestimo/consultar-por-categoria" method="POST">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                            <input type="text" class="mdl-textfield__input" id="consultaproduto" name="nomeCategoria"/>
                            <label for="consulta_categoria" class="mdl-textfield__label">Nome da Categoria</label>
                        </div>
                        <br>
                        <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
                    </form>
                </div> <!-- Fim  do formulario de consulta por Categoria--> 
                
                  <div id="FormConsultarDataEmprestimo" class="Formulario" style="display: none">
                     <form action="emprestimo/consultar-por-data-anuncio" method="POST">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                            <input type="text" class="mdl-textfield__input" id="data" name="dataAnuncio"/>
                            <label for="data" class="mdl-textfield__label">Data do anuncio</label>
                    </div>
                         <br>
                            <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
                    </form>
                </div>       <!-- Fim  do formulario de consulta por data--> 
                                
                <div id="FormConsultarUsuarioEmprestimo" class="Formulario" style="display: none">
                    <form action="emprestimo/consultar-por-usuario-anunciador" method="POST">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label ">
                            <input type="text" class="mdl-textfield__input" id="consulta_usuario" name="nomeUsuarioAnunciador"/>
                            <label for="consulta_usuario" class="mdl-textfield__label">Nome do Usuario</label>
                    </div>
                        <br> 
                            <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--colored ">Enviar</button>
                    </form>
                </div>   <!-- Fim  do formulario de consulta por usuario--> 
                   
             
                <div id="FormListarEmprestimo" class="Formulario" style="display: none">
                    <script>
                        var obj = new listaEmprestimo();
                        obj.resgatarValores();
                    </script>
                </div>
           </div>  <!-- Painel emprestimo -->
            
           <div class="mdl-layout__tab-panel " id="Sobre">           
             <div class="mdl-grid portfolio-max-width">

                <div id="card" class="mdl-cell mdl-cell--6-col mdl-card mdl-shadow--4dp">
                    <div class="mdl-card__title">
                        <h2 class="mdl-card__title-text">Como funciona</h2>
                    </div>
                    <div class="mdl-card__media">
                        <img class="article-image" src="imagens.jpg" width="500" height="200"> 
                    </div>

                    <div class="mdl-grid portfolio-copy">
                        <h3 class="mdl-cell mdl-cell--12-col mdl-typography--headline">Objetivo</h3>
                        <div class="mdl-cell mdl-cell--8-col mdl-card__supporting-text no-padding ">
                            <p>
                            O Community é apenas destinado a empréstimos e doações de coisas/itens/bens/produtos.
                            O site não é destinado a venda ou aluguel de coisas/itens/bens/produtos.
                            O serviço consiste em prover aos usuários uma plataforma que possibilite e facilite
                            aos usuários se conectarem para doação e empréstimo de itens/bens/coisas/objetos entre
                            si com o objetivo de economizar dinheiro e se desfazer de objetos que você não utilizará mais. 
                            </p>
                        </div>
                        
                        <h3 class="mdl-cell mdl-cell--12-col mdl-typography--headline">O empréstimo ou doação</h3>
                        <div class="mdl-cell mdl-cell--8-col mdl-card__supporting-text no-padding ">
                            <p>
                                O usuário poderá escolher entre os itens/bens/produtos que lhe interessa para empréstimo ou doação. 
                                Os usuários poderão entrar em contato direto, por qualquer meio, para efetuar o empréstimo ou doação, 
                                sob sua total responsabilidade.
                            </p>
                        </div>


                        <h3 class="mdl-cell mdl-cell--12-col mdl-typography--headline">Empréstimos ou doações proibidos</h3>

                        <div class="mdl-cell mdl-cell--8-col mdl-card__supporting-text no-padding ">
                            <p>
                                Fica terminantemente proibido o empréstimo ou doação de pessoas ou itens/bens/coisas/objetos para qualquer
                                atividade ilícita ou imoral, serviços e/ou produtos relacionados a prostituição ou similares, material pornográfico,
                                obsceno ou contrário a moral e os bons costumes, atividades ou objetos/itens/bens/coisas que promovam a violência e/ou
                                a discriminação baseada em questões de raça, sexo, religião, nacionalidade, orientação sexual ou de qualquer outro tipo.
                                Também ficam proibidas atividades ou bens/itens/coisas/objetos que violem a propriedade intelectual, como direitos autorais,
                                marcas, patentes, modelos, desenhos industriais, autoria de softwares, direitos de imagem, voz e quaisquer outros protegidos por lei.
                            </p>
                        </div>
                    </div>
                </div>
           </div>
           </div>
            
        </main>
        
        
    </body>
</html>
