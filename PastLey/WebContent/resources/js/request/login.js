

/*********************************************************************************************
 ****************************************** REQUESTS ***************************************** 
 *********************************************************************************************/

//////////////////////////////////////////////////////////////////////////////////////////////
// LOGIN
//////////////////////////////////////////////////////////////////////////////////////////////
jQuery(document).on('submit', '#pastley__login-form', function(event) {
	event.preventDefault();
	jQuery.ajax({
		url : 'login?accion=login',
		type : 'POST',
		dataType : 'json',
		data : $(this).serialize(),
		beforeSend : function() {
			console.log("CARGANDO");
		}
	}).done(function(respuesta) {
		console.log(respuesta);
		if(!respuesta.error){
			if(respuesta.rol == 1){
				window.location = "pages/admi/index.jsp";
			}else if(respuesta.rol == 2){
				window.location = "pages/cashier/index.jsp";
			}
		}else{
			Swal.fire({ 
		          title: respuesta.title,
		          showClass: {popup: 'animated fadeInDown faster'},
		          hideClass: {popup: 'animated fadeOutUp faster' },
		          text: respuesta.text,
		          icon: respuesta.icon,
		          footer: respuesta.footer,
		          backdrop: true,
		          timer: 5000,
		          timerProgressBar: true,
		    });	
		}
	}).fail(function(respuesta) {
		Swal.fire({
	          title: 'Se ha presentado un error!',
	          showClass: {  popup: 'animated fadeInDown faster'},
	          hideClass: { popup: 'animated fadeOutUp faster'},
	          text: 'Lamentamos que haya pasado esto, por favor comunicanos sobre este error.',
	          icon: 'error',
	          footer: 'Vuelva a intentar mas tarde.',
	          backdrop: true, 
	          timer: 5000,
	          timerProgressBar: true,
	    });
	}).always(function() {
		console.log("REQUESTS LOGIN COMPLETED!");
	});
});