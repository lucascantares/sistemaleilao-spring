
function compararDataInicioLeilao(data){

	var data = new Date();
	var dia = String(data.getDate()).padStart(2, '0');
	var mes = String(data.getMonth() + 1).padStart(2, '0');
	var ano = data.getFullYear();
	dataAtual = ano + '-' + mes + '-' + dia;
	if(data.value<dataAtual){
		alert("A data que vc inseriu e antiga, atualize");
	}
}

function compararDataFimLeilao(dataInicio,dataFechamento){

	if(dataInicio.value>dataFechamento.value){
	console.log(dataInicio,dataFechamento);
		alert("A data que vc inseriu antecede a data de incio, por favor Corrija!");
		
	}
}
function addMascara(i){
	   
	   var v = i.value;
	   
	   if(isNaN(v[v.length-1])){ // impede entrar outro caractere que não seja número
	      i.value = v.substring(0, v.length-1);
	      return;
	   }
	   
	   i.setAttribute("maxlength", "14");
	   if (v.length == 3 || v.length == 7) i.value += ".";
	   if (v.length == 11) i.value += "-";

	}
	
	var tabela = document.querySelector("#tblItens");
	mostraLeiloes();
	
	
	function functionChamarTela(url, destino) {
		var ajax = new XMLHttpRequest();
	  	ajax.onreadystatechange = function() {
	   		if(this.status == 200){
	   			document.getElementById(destino).innerHTML = ajax.responseText;
	   		}
	  	}
	  	
	  	ajax.open("GET", url);
	  	ajax.send(); 
		
	}
	

	 function mostraLeiloes() {
			
			var ajax = new XMLHttpRequest();
		  	ajax.onreadystatechange = function() {
		   		if(this.readyState == 4 && this.status == 200){
		   		
		   			var leiloes = JSON.parse(ajax.responseText);
		   			//console.log(leiloes);
		   			atualizaTabela(leiloes);
		   		}
		  	}
		  	
		  	ajax.open("GET", "carregajson",true);
		  	ajax.send(); 
		  	
			}

	 function atualizaTabela(leiloes) {
		
		 leiloes.forEach(function(leilao){
			 addItem(leilao);
		 });
	}

	function addItem(leilao){
			var tr = montaTr(leilao);
			tabela.appendChild(tr);
		}
	  	
	function montaTr(leilao){
		var tr = document.createElement("tr");
		
		var idTd = montaTd(leilao.codLeilao);
		var descricaoTd = montaTd(leilao.item);
		var lanceMinimoTd = montaTd(leilao.lanceMinimo);
		var lanceAtualTd = montaTd(leilao.lanceAtual);
		var dataAberturaTd = montaTd(leilao.dataAbertura);
		var dataFechamentoTd = montaTd(leilao.dataFechamento);
		var situacaoTd = montaTd(leilao.situacao);
		
		tr.appendChild(idTd);
		tr.appendChild(dataAberturaTd);
		tr.appendChild(descricaoTd);
		tr.appendChild(lanceMinimoTd);
		tr.appendChild(lanceAtualTd);
		tr.appendChild(dataFechamentoTd);
		tr.appendChild(situacaoTd);
		
		
		var tdParticipar = montaTdControle(leilao, "Participar");
		var tdverLances = montaTdControle(leilao, "Ver Lances");
		
		tr.appendChild(tdParticipar);
		tr.appendChild(tdverLances);

		
		tr.setAttribute("id", leilao.codLeilao);
		return tr;
	}


	function montaTdControle(leilao, tipo){
		
		var link = document.createElement("button");
		const params = new URLSearchParams({
			descricao: leilao.codLeilao,
			operacao: tipo
		});
		
		link.textContent = tipo;
		//link.setAttribute('href', "leilao?" + params.toString());
		link.setAttribute('onClick',"functionChamarTela('fazerLance','divConteudo')");
		link.setAttribute('id', leilao.codLeilao); 
		if(tipo == "participar"){
			link.classList.add("btn-participar");
			link.onclick
		}
		
		if(tipo == "verLances"){
			link.classList.add("btn-verLances");
		}
		 
		var tdControle =  document.createElement("td");
		tdControle.appendChild(link);
		return tdControle;
		
	}

	function montaTd(dado){
		var td = document.createElement("td");
		td.textContent = dado;
		return td;
	}
	
	
