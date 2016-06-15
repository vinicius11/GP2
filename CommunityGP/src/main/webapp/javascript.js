/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function verificar(div){
    
      document.getElementById('FormCadastro').style.display='none';
      document.getElementById('FormConsultarProduto').style.display='none';
      document.getElementById('FormConsultarData').style.display='none';
      document.getElementById('FormConsultarCategoria').style.display='none';
      document.getElementById('FormConsultarUsuario').style.display='none';
      document.getElementById('FormListar').style.display='none';
      
      document.getElementById(div).style.display = 'block';
  
}

function verificarEmprestimo(div){
    
      document.getElementById('FormCadastroEmprestimo').style.display='none';
      document.getElementById('FormConsultarProdutoEmprestimo').style.display='none';
      document.getElementById('FormConsultarDataEmprestimo').style.display='none';
      document.getElementById('FormConsultarCategoriaEmprestimo').style.display='none';
      document.getElementById('FormConsultarUsuarioEmprestimo').style.display='none';
      document.getElementById('FormListarEmprestimo').style.display='none';
      
      document.getElementById(div).style.display = 'block';
  
}

//doação!!!

document.querySelector("#buttonConsultarProduto").addEventListener("click", consultarProduto);


function listaDoacao(){
	

	// Resgatar valores.
	listaDoacao.prototype.resgatarValores = function(){
		$('#FormListar').html('Carregando dados...');

		// Estrutura de resultado.
                
                
                
		$.getJSON('http://localhost:8080/Community/doacao/listar.json',function(data){
                    $('#FormListar').html('Carregando .');
                    
			this.qtd = data.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'produto: ' + data[i].produto + '<br />';
				this.retorno += 'Nome: ' + data[i].usuarioAnunciador + ' - ';
				this.retorno += 'Data: ' + data[i].dataAnuncio + '<br /><br />';
                                
			}
                        
			$('#FormListar').html(this.retorno);
		});

	};

}

function consultarProduto(){
    var obj = new consultarPorProduto(document.getElementById('consulta_produto').value);
    obj.resgatarValores();
}

function consultarPorProduto(nome){
	var qtd;
	var retorno;

	// Resgatar valores.
	consultarPorProduto.prototype.resgatarValores = function(){
		$('#FormConsultarProduto').html('Carregando dados...');

		// Estrutura de resultado.
                
                var x = "http://localhost:8080/Community/doacao/consultar-por-produto/";
                x=x.concat(nome);
                x=x.concat(".json");
                
                
		$.getJSON(x, function(data){
                    $('#FormConsultarProduto').html('Carregando .');
                    
			this.qtd = data.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'produto: ' + data[i].produto + '<br />';
				this.retorno += 'Nome: ' + data[i].usuarioAnunciador + ' - ';
				this.retorno += 'Data: ' + data[i].dataAnuncio + '<br /><br />';
                                
			}
                        
			$('#FormConsultarProduto').html(this.retorno);
		});

	};

}

function consultarData(){
    var obj = new consultarPorData(document.getElementById('data').value);
    obj.resgatarValores();
}

function consultarPorData(nome){
	var qtd;
	var retorno;

	// Resgatar valores.
	consultarPorData.prototype.resgatarValores = function(){
		$('#FormConsultarData').html('Carregando dados...');

		// Estrutura de resultado.
                
                var x = "http://localhost:8080/Community/doacao/consultar-por-data-anuncio/";
                x=x.concat(nome);
                x=x.concat(".json");
                
                $('#FormConsultarData').html(x);
		$.getJSON(x, function(data){
                    $('#FormConsultarData').html('Carregando .');
                    
			this.qtd = data.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'produto: ' + data[i].produto + '<br />';
				this.retorno += 'Nome: ' + data[i].usuarioAnunciador + ' - ';
				this.retorno += 'Data: ' + data[i].dataAnuncio + '<br /><br />';
                                
			}
                        
			$('#FormConsultarData').html(this.retorno);
		});

	};

}

function consultarCategoria(){
    var obj = new consultarPorCategoria(document.getElementById('consultaproduto').value);
    obj.resgatarValores();
}

function consultarPorCategoria(nome){
	var qtd;
	var retorno;

	// Resgatar valores.
	consultarPorCategoria.prototype.resgatarValores = function(){
		$('#FormConsultarCategoria').html('Carregando dados...');

		// Estrutura de resultado.
                
                var x = "http://localhost:8080/Community/doacao//consultar-por-categoria/";
                x=x.concat(nome);
                x=x.concat(".json");
                
                $('#FormConsultarCategoria').html(x);
		$.getJSON(x, function(data){
                    $('#FormConsultarCategoria').html('Carregando .');
                    
			this.qtd = data.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'produto: ' + data[i].produto + '<br />';
				this.retorno += 'Nome: ' + data[i].usuarioAnunciador + ' - ';
				this.retorno += 'Data: ' + data[i].dataAnuncio + '<br /><br />';
                                
			}
                        
			$('#FormConsultarCategoria').html(this.retorno);
		});

	};

}

function consultarUsuario(){
    var obj = new consultarPorUsuario(document.getElementById('consulta_usuario').value);
    obj.resgatarValores();
}

function consultarPorUsuario(nome){
	var qtd;
	var retorno;

	// Resgatar valores.
	consultarPorUsuario.prototype.resgatarValores = function(){
		$('#FormConsultarUsuario').html('Carregando dados...');

		// Estrutura de resultado.
                
                var x = "http://localhost:8080/Community/doacao/consultar-por-usuario-anunciador/";
                x=x.concat(nome);
                x=x.concat(".json");
                
                $('#FormConsultarUsuario').html(x);
		$.getJSON(x, function(data){
                    $('#FormConsultarUsuario').html('Carregando .');
                    
			this.qtd = data.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'produto: ' + data[i].produto + '<br />';
				this.retorno += 'Nome: ' + data[i].usuarioAnunciador + ' - ';
				this.retorno += 'Data: ' + data[i].dataAnuncio + '<br /><br />';
                                
			}
                        
			$('#FormConsultarUsuario').html(this.retorno);
		});

	};

}
//fim doação


//emprestimo

function listaEmprestimo(){
	var qtd;
	var retorno;

	// Resgatar valores.
	listaEmprestimo.prototype.resgatarValores = function(){
		$('#FormListarEmprestimo').html('Carregando dados...');

		// Estrutura de resultado.
                
		$.getJSON('http://localhost:8080/Community/emprestimo/listar.json',function(data){
                    $('#FormListarEmprestimo').html('Carregando .');
                    
			this.qtd = data.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'produto: ' + data[i].produto + '<br />';
				this.retorno += 'Nome: ' + data[i].usuarioAnunciador + ' - ';
				this.retorno += 'Data: ' + data[i].dataAnuncio + '<br /><br />';
                                
			}
                        
			$('#FormListarEmprestimo').html(this.retorno);
		});

	};

}

//fim emprestimo

//usuario
function listaUsuario(){
	var qtd;
	var retorno;

	// Resgatar valores.
	listaUsuario.prototype.resgatarValores = function(){
		$('#FormListar').html('Carregando dados...');

		// Estrutura de resultado.
                
		$.getJSON('http://localhost:8080/Community/usuario/listar.json',function(data){
                    $('#FormListar').html('Carregando .');
                    
			this.qtd = data.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'produto: ' + data[i].produto + '<br />';
				this.retorno += 'Nome: ' + data[i].usuarioAnunciador + ' - ';
				this.retorno += 'Data: ' + data[i].dataAnuncio + '<br /><br />';
                                
			}
                        
			$('#FormListar').html(this.retorno);
		});

	};

}

//fim usuario

//categoria
function listaCategoria(){
	var qtd;
	var retorno;

	// Resgatar valores.
	listaCategoria.prototype.resgatarValores = function(){
		$('#FormListar').html('Carregando dados...');

		// Estrutura de resultado.
                
		$.getJSON('http://localhost:8080/Community/categoria/listar.json',function(data){
                    $('#FormListar').html('Carregando .');
                    
			this.qtd = data.length;
			this.retorno = '';

			for (i = 0; i < this.qtd; i++){
				this.retorno += 'Categoria: ' + data[i].nome + '<br /><br />';
                                
			}
                        
			$('#FormListar').html(this.retorno);
		});

	};

}

//fim categoria
// Objeto.


