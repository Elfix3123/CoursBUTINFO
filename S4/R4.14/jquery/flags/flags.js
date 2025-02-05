$(function(){
	var fr = $('<div/>');
	fr.append($('<div/>',{text:'France'}));
	fr.append($('<img/>',{src:'fr.gif'}));
	$('body').append(fr);
	$('img').css('border','solid 3px gray');
	$('img').css('width',200);
	$('div').css('display','block');
	$('body > div').css('width','fit-content');
	$('div div').css('text-align','center');
	$('body').css('font-family','arial');
	$('body').css('font-size','x-large');
});
