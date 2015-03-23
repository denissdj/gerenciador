function noBack() {
	window.history.forward();
};

noBack();

window.onload = noBack;

window.onpageshow = function(evt) {
	if (evt.persisted)
		noBack();
};

window.onunload = function() {
	void (0);
};

/*
 * funcoes que trabalham como um contador do tempo de sessao do usuario.
 */
var tempoPassado = 0;

var funcaoTimeout;

var tempoAtualizacao = 1000;

window.onload = function() {
	contarTempo();
};
function contarTempo() {
	document.getElementById('contadorSessao').value = tempoMaximoSessao / 1
			- tempoPassado;
	tempoPassado = tempoPassado + 1;

	// se ultrapassar o tempo maximo, redirecione o usuario para a pagina de
	// login.
	// unidades: segundos.
	if (tempoPassado > tempoMaximoSessao / 1) {
		alert('Sua sessão expirou. Você será redirecionado para a página de login.');

		if(location.host === "localhost:8080"){
			var nome = location.pathname.split('/');
			location.href = location.origin + '/' + nome[1];
		} else {
			location.href = location.origin;
			//location.href = "/teste.jsf";
		}
		
	}

	funcaoTimeout = setTimeout("contarTempo()", tempoAtualizacao);
}

function resetaContador() {
	tempoPassado = 0;
	clearTimeout(funcaoTimeout);
	contarTempo();
}