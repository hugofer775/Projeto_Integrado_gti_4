function checkPassword(form) {
	
 var dt_compra = form[form.id + ":dt_compra"].value;
 var dt_venda = form[form.id + ":dt_venda"].value;
 
 var a = parseInt(dt_compra.split("/")[2].toString() + dt_compra.split("/")[1].toString() + dt_compra.split("/")[0].toString());
 var b = parseInt(dt_venda.split("/")[2].toString() + dt_venda.split("/")[1].toString() + dt_venda.split("/")[0].toString());

 if (b < a)
	 alert("Digite a porcentagem de 0 a 100");
 else
	 form.submit();
}