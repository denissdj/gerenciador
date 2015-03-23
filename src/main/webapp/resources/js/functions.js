///**
// * Author: 3Way Networks - Fábrica de Software
// * 
// * Data de Criação: 26.09.2012
// */
//var r = /[\Wa-zA-Z]/g;
//
//var ELEMENT_FOCUS;
//
///**
// * Funções executadas ao carregar página.
// * 
// * @author Bruno Zafalão
// */
//jQuery(document).ready(function() {
//
//	/**
//	 * Metodo responsavel por inserir mascara de novo dígito de celular em São
//	 * Paulo.
//	 * 
//	 */
//	jQuery('.celular').focusout(function() {
//		var phone, element;
//		element = $(this);
//		element.unmask();
//		phone = element.val().replace(/\D/g, '');
//		if (phone.length > 10) {
//			element.mask("(99) 99999-999?9");
//		} else {
//			element.mask("(99) 9999-9999?9");
//		}
//	}).trigger('focusout');
//
//	jQuery("input").focus(function() {
//
//		ELEMENT_FOCUS = this;
//	});
//
//	/* Configura o título do sistema apresentado no menu. */
//	jQuery('.tituloSistema').parent().parent().css('opacity', '1');
//
//	/* Configuração das tabelas exibidas no sistema. */
//	jQuery('th[role*="columnheader"] div').css('background', '#E3E3E3');
//	jQuery('th[role*="columnheader"] div').css('-webkit-border-radius', '2px');
//	jQuery('th[role*="columnheader"] div').css('-moz-border-radius', '2px');
//	jQuery('th[role*="columnheader"]').css('color', 'black');
//	jQuery('th[role*="columnheader"]').css('font-weight', 'bold');
//
//	/* Oculta o modal de espera em caso de erro do sistema. */
//	window.onerror = function() {
//
//		PF('statusDialog').hide();
//	};
//
//	/**
//	 * Realiza a exibição do status dialog na submissão de qualquer formulario
//	 */
//	jQuery('form').each(function() {
//
//		jQuery(this).submit(function() {
//
//			try {
//
//				if (STATUS_DIALOG_SHOW) {
//
//					PF('statusDialog').show();
//				}
//
//				alterarPaginacaoTabela();
//
//			} catch (e) {
//
//				if (console) {
//
//					console.log(e);
//				}
//
//				alterarPaginacaoTabela();
//			}
//		});
//
//	});
//
//	/**
//	 * Define as mascaras usadas no sistema.
//	 */
//	setMasks();
//
//	/**
//	 * Função responsável por validar a hora no formato hh:mm
//	 */
//	jQuery(".hora").keyup(function(e) {
//
//		var hora = this.value;
//
//		var tecla = e.which;
//
//		var regex = new RegExp('^([0-1][0-9]|[2][0-3]):([0-5][0-9])$');
//
//		if (!regex.test(hora) && tecla != 8) {
//
//			var horaValida = '';
//
//			for (var i = 0; i < hora.length; i++) {
//
//				if (hora.charCodeAt(i) > 47 && hora.charCodeAt(i) < 58) {
//
//					if (horaValida.length == 1) {
//
//						horaValida = horaValida + hora.charAt(i) + ":";
//
//					} else {
//
//						horaValida = horaValida + hora.charAt(i);
//
//					}
//
//				}
//
//			}
//
//			var tamanho = horaValida.length;
//
//			this.value = horaValida;
//
//			var values = horaValida.split(":");
//
//			if (values[0].substring(0, 1) > 2) {
//
//				this.value = '';
//
//			} else if (tamanho == 2 && values[0] < 24) {
//
//				this.value = horaValida + ":";
//
//			} else if (values[0] > 23) {
//
//				this.value = values[0].substring(0, 1);
//
//			} else if (values[1].substring(0, 1) > 5 || values[1] > 59) {
//
//				this.value = values[0].substring(0, 2) + ":";
//
//			}
//
//		}
//
//	});
//
//	jQuery(".hora").blur(function() {
//
//		var regex = new RegExp('^([0-1][0-9]|[2][0-3]):([0-5][0-9])$');
//
//		if (!regex.test(this.value)) {
//
//			this.value = '';
//
//		}
//
//	});
//
//	alterarHeaderTabela();
//
//	alterarPaginacaoTabela();
//});
//
//$(document).ajaxComplete(function() {
//	alterarPaginacaoTabela();
//});
//
//function alterarPaginacaoTabela() {
//
//	$('.ui-icon-seek-first').removeClass("ui-icon-seek-first ui-icon").text(
//			'Primeira');
//
//	$('.ui-icon-seek-prev').removeClass("ui-icon-seek-first ui-icon").text(
//			'Anterior');
//
//	$('.ui-icon-seek-next').removeClass("ui-icon-seek-first ui-icon").text(
//			'Próxima');
//
//	$('.ui-icon-seek-end').removeClass("ui-icon-seek-first ui-icon").text(
//			'Última');
//
//}
//
//function mascararCampo() {
//
//	jQuery(".mascaraCostumizada").find('input').mask("999/9999-TB");
//}
//
//function alterarHeaderTabela() {
//
//	jQuery(".ui-dt-c").removeAttr("style");
//}
//
///**
// * Define o input <p:calendar /> para ser exibido em Portugues.
// * 
// * @author Bruno Zafalão
// */
//PrimeFaces.locales['pt_BR'] = {
//	closeText : 'Fechar',
//	prevText : 'Anterior',
//	nextText : 'Próximo',
//	currentText : 'Começo',
//	monthNames : [ 'Janeiro', 'Fevereiro', 'Marco', 'Abril', 'Maio', 'Junho',
//			'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro' ],
//	monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago',
//			'Set', 'Out', 'Nov', 'Dez' ],
//	dayNames : [ 'Domingo', 'Segunda', 'Ter�a', 'Quarta', 'Quinta', 'Sexta',
//			'Sábado' ],
//	dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab' ],
//	dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S' ],
//	weekHeader : 'Semana',
//	firstDay : 1,
//	isRTL : false,
//	showMonthAfterYear : false,
//	yearSuffix : '',
//	timeOnlyTitle : 'Horas',
//	timeText : 'Tempo',
//	hourText : 'Hora',
//	minuteText : 'Minuto',
//	secondText : 'Segundo',
//	currentText : 'Data Atual',
//	ampm : false,
//	month : 'Mes',
//	week : 'Semana',
//	day : 'Dia',
//	allDayText : 'Todo Dia'
//};
//
//var NULL = "";
//
///**
// * Variavel global responsavel por representar se o status dialog sera exibido
// * ou nao.
// * 
// * @author Cézar Augusto
// */
//var STATUS_DIALOG_SHOW = true;
//
///**
// * Desabilita a exibição do status dialog
// * 
// * @author Cézar Augusto
// */
//function disabilitarStatusDialog() {
//
//	STATUS_DIALOG_SHOW = false;
//}
//
///**
// * Habilita a exibição do status dialog
// * 
// * @author Cézar Augusto
// */
//function habilitarStatusDialog() {
//
//	STATUS_DIALOG_SHOW = true;
//}
//
///**
// * Define as mascaras usadas no sistema.
// */
//function setMasks() {
//
//	var tratarQuantidadeCaracteres = function() {
//
//		maxlength = jQuery(this).attr('maxlength');
//
//		if (jQuery(this).val().length > maxlength) {
//
//			doisUltimosDigitos = jQuery(this).val().substr(-2);
//
//			jQuery(this).val(
//					jQuery(this).val().substring(0, maxlength - 2) + ","
//							+ doisUltimosDigitos);
//		}
//	};
//
//	jQuery(".realType").priceFormat({
//		prefix : '',
//		centsSeparator : ',',
//		thousandsSeparator : '.'
//	}).keyup(tratarQuantidadeCaracteres).keydown(tratarQuantidadeCaracteres);
//
//	jQuery(".numeric").numeric().keyup(function() {
//
//		jQuery(this).val(jQuery(this).val().replace(r, ''));
//
//	});
//}
//
///**
// * Define como default a primeira pagina do input p:dataTable.
// */
//function setFirstPaginator() {
//
//	dtTable.getPaginator().setPage(0);
//}
//
//var VALUE_OBSERVACAO_ITEM;
//
//function desabilitarObservacao(observacao) {
//
//	if ((observacao != undefined)) {
//
//		if (jQuery(observacao.jqId).val().length > 400) {
//
//			jQuery(observacao.jqId).val(VALUE_OBSERVACAO_ITEM);
//
//		} else {
//
//			VALUE_OBSERVACAO_ITEM = jQuery(observacao.jqId).val();
//		}
//	}
//}
//
//var VALUE_JUSTIFICATIVA;
//
//function desabilitarJustificativa(justificativa) {
//
//	if ((justificativa != undefined)) {
//
//		if (jQuery(justificativa.jqId).val().length > 200) {
//
//			jQuery(justificativa.jqId).val(VALUE_JUSTIFICATIVA);
//
//		} else {
//
//			VALUE_JUSTIFICATIVA = jQuery(justificativa.jqId).val();
//		}
//	}
//}
//
///**
// * Metodo responsavel por desabilidar o botão pesquisar no onKeyUp dos campos
// * inputText
// * 
// * se o value do input for diferente de null ou diferente do valor da mascara.
// * 
// */
//function verificarPesquisa(elements) {
//
//	var valoresPreenchidos = new Array();
//
//	for (var i = 0; i < elements.length; i++) {
//
//		val = jQuery(elements[i].jqId).val();
//
//		if (val == undefined || val == "" || val == "Selecione") {
//
//			val = jQuery(elements[i].jqId + " input").val();
//		}
//
//		if (val == "" || val == "Selecione") {
//
//			val = undefined;
//		}
//
//		if (val !== undefined) {
//
//			valoresPreenchidos.push(val);
//		}
//	}
//
//	if (valoresPreenchidos.length == 0) {
//
//		alertaPesquisa.show();
//
//	} else {
//
//		jQuery("form").submit();
//
//	}
//}
//
///**
// * Define mascara moeda.
// * 
// * @param objTextBox
// * 
// * @param SeparadorMilesimo
// * 
// * @param SeparadorDecimal
// * 
// * @param e
// * 
// * @returns {Boolean}
// */
//function mascaraMoeda(objTextBox, SeparadorMilesimo, SeparadorDecimal, e) {
//
//	var key = '';
//	var i = j = 0;
//	var len = len2 = 0;
//	var strCheck = '0123456789';
//	var aux = aux2 = '';
//	var whichCode = (window.Event) ? e.which : e.keyCode;
//	if (whichCode == 13 || whichCode == 8)
//		return true;
//	key = String.fromCharCode(whichCode); // Valor para o código da Chave
//	if (strCheck.indexOf(key) == -1)
//		return false; // Chave inválida
//	len = objTextBox.value.length;
//	for (i = 0; i < len; i++)
//		if ((objTextBox.value.charAt(i) != '0')
//				&& (objTextBox.value.charAt(i) != SeparadorDecimal))
//			break;
//	aux = '';
//	for (; i < len; i++)
//		if (strCheck.indexOf(objTextBox.value.charAt(i)) != -1)
//			aux += objTextBox.value.charAt(i);
//	aux += key;
//	len = aux.length;
//	if (len == 0)
//		objTextBox.value = '';
//	if (len == 1)
//		objTextBox.value = '0' + SeparadorDecimal + '0' + aux;
//	if (len == 2)
//		objTextBox.value = '0' + SeparadorDecimal + aux;
//	if (len > 2) {
//		aux2 = '';
//		for (j = 0, i = len - 3; i >= 0; i--) {
//			if (j == 3) {
//				aux2 += SeparadorMilesimo;
//				j = 0;
//			}
//			aux2 += aux.charAt(i);
//			j++;
//		}
//		objTextBox.value = '';
//		len2 = aux2.length;
//		for (i = len2 - 1; i >= 0; i--)
//			objTextBox.value += aux2.charAt(i);
//		objTextBox.value += SeparadorDecimal + aux.substr(len - 2, len);
//	}
//
//	return false;
//}
//
//function limparCamposContrato(keyCode) {
//
//	if (keyCode == 8) {
//
//		limparDadosContrato();
//
//	}
//}
//
//function notCompleteCorrect() {
//
//	return (jQuery('.autoCompleteContrato input').val() == '' || (jQuery(
//			'.autoCompleteContrato input').val().length) < 11);
//}
//
//function notCompleteCorrectSite() {
//
//	return (jQuery('.autoCompleteSiteID input').val() == '' || (jQuery(
//			'.autoCompleteSiteID input').val().length) < 11);
//
//}
//
//function limparCamposSiteID(keyCode) {
//
//	if (keyCode == 8) {
//
//		limparDadosSiteID();
//
//	}
//}
//
//function limparQuantidadeEstimada() {
//
//	var quantidadeEstAta = jQuery("input[name$='quantidadeEstAta']");
//
//	jQuery.each(quantidadeEstAta, function(index, value) {
//
//		var value = jQuery(this).val();
//
//		if (eval(value) == 0) {
//
//			jQuery(this).val("");
//		}
//	});
//}
//
//function setFocus(posicao) {
//
//	var proximo = jQuery(jQuery("input[name$='quantidadeEstAta']").get(posicao))
//			.parent().parent().next();
//
//	jQuery(proximo).focus();
//}
//
//function upload() {
//
//	jQuery("input[type='file']").click();
//}
//
//function setNumericInput(element) {
//
//	$(element).numeric();
//}
//
//var qntItensSelecionados = 0;
//
//function setQntItensSelecionados(qntItens) {
//
//	qntItensSelecionados = qntItens;
//}
//
//function verifyCheckBox() {
//
//	if (qntItensSelecionados > 4) {
//
//		$("input:checkbox:not(:checked)").attr('disabled', 'disabled');
//
//	} else {
//
//		$("input:checkbox:not(:checked)").removeAttr('disabled');
//	}
//}
//
//function addChecked(element) {
//
//	var isChecked = $(element).is(':checked');
//
//	if (isChecked) {
//
//		qntItensSelecionados++;
//
//	} else {
//
//		if (qntItensSelecionados > 0) {
//
//			qntItensSelecionados--;
//		}
//	}
//}
//
//function resetInputNumeric() {
//
//	$("input:checkbox:not(:checked)").each(function() {
//
//		var c = $(this).attr('class');
//
//		var id = c.split("-")[1];
//
//		var value = $('.txt-pont-nacional-' + id).val();
//
//		$(".pont-" + id).val(value);
//
//		$('.pont-' + id).attr('value', value);
//
//		$('.txt-pont-temp-' + id).attr('value', value);
//
//	});
//}


//
//function setPrimeiraPaginaDataTable() {
//	$('.ui-paginator-page').each(function(index) {
//		if ($('.ui-datatable-data > tr').length < 2) {
//			if (index == 0) {
//				$(this).click();
//			}
//		}
//	});
//}
//
//function travarEnvioFormularioEnter() {
//	$('input').keypress(function(e) {
//		var code = null;
//		code = (e.keyCode ? e.keyCode : e.which);
//		return (code == 13) ? false : true;
//	});
//}
//
//function mostrarMsgTableVazia(classe, msg){
//
//	if ($('.' + classe + ' > div > table > tbody > tr').hasClass('ui-datatable-empty-message')) {
//		
//		showMessageInfo(msg);
//		
//	}else{
//		
//		ocultarMsg();
//	}
//	
//}


function showMessageInfo(msg) {
	$('#msg-global').text(msg);
	$('#mensagem').removeClass('alert-success alert-error alert-info alert-warning ocultar').addClass('alert-info').show('slow');
}

function showMessageError(msg) {
	$('#msg-global').text(msg);
	$('#mensagem').removeClass('alert-success alert-error alert-info alert-warning').addClass('alert-error').show('slow');
}

function showMessageSucess(msg) {
	$('#msg-global').text(msg);
	$('#mensagem').removeClass('alert-success alert-error alert-info alert-warning').addClass('alert-success').show('slow');
}

function showMessageWarning(msg) {
	$('#msg-global').text(msg);
	$('#mensagem').removeClass('alert-success alert-error alert-info alert-warning').addClass('alert-warning').show('slow');
}

function ocultarMsg() {
	$('#mensagem').hide('slow');
}