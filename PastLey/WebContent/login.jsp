
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="/template/header.jsp"%>

<!--         -->
<!-- SECTION -->
<!--         -->
<div class="main-content">

	<!--        -->
	<!-- HEADER -->
	<!--        -->
	<div class="header bg-gradient-primary py-7 py-lg-8 pt-lg-9">
		<div class="container">
			<div class="header-body text-center mb-7">
				<div class="row justify-content-center">
					<div class="col-xl-5 col-lg-6 col-md-8 px-5">
						<h1 class="text-white">Bienvenido!</h1>
						<p class="text-lead text-white">Use these awesome forms to
							login or create new account in your project for free.</p>
					</div>
				</div>
			</div>
		</div>
		<div class="separator separator-bottom separator-skew zindex-100">
			<svg x="0" y="0" viewBox="0 0 2560 100" preserveAspectRatio="none"
				version="1.1" xmlns="http://www.w3.org/2000/svg">
          	<polygon class="fill-default" points="2560 0 2560 100 0 100"></polygon>
        </svg>
		</div>
	</div>

	<!--       -->
	<!-- LOGIN -->
	<!--       -->
	<div class="container mt--8 pb-5">
		<div class="row justify-content-center">
			<div class="col-lg-5 col-md-7">
				<div class="card bg-secondary border-0 mb-0">
					<div class="card-body px-lg-5 py-lg-5">
						<div class="text-center text-muted mb-4">
							<h1>Iniciar Sesión</h1>
						</div>

						<form role="form" action="" method="POST" id="pastley__login-form"
							class="pastley__login-form">

							<!--       -->
							<!-- EMAIL -->
							<!--       -->
							<div class="form-group mb-3">
								<div
									class="input-group input-group-merge input-group-alternative">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="ni ni-email-83"></i></span>
									</div>
									<input class="form-control" placeholder="Email" type="email"
										name="email" id="login-usuario-email">
								</div>
							</div>

							<!--          -->
							<!-- PASSWORD -->
							<!--          -->
							<div class="form-group">
								<div
									class="input-group input-group-merge input-group-alternative">
									<div class="input-group-prepend">
										<span class="input-group-text"><i
											class="ni ni-lock-circle-open"></i></span>
									</div>
									<input class="form-control" placeholder="Clave" type="password"
										name="clave" id="login-usuario-clave">
								</div>
							</div>

							<!--      -->
							<!-- TYPE -->
							<!--      -->
							<div class="form-group">
								<select class="form-control" id="login-usuario-tipo-usuario"
									name="tipo">
									<option value="">Tipo Usuario</option>
									<option value="1">Administrador</option>
									<option value="2">Asistente Adninistrativo</option>
								</select>
							</div>


							<!--        -->
							<!-- REMBER -->
							<!--        -->
							<div
								class="custom-control custom-control-alternative custom-checkbox">
								<input class="custom-control-input" id=" customCheckLogin"
									type="checkbox"> <label class="custom-control-label"
									for=" customCheckLogin"> <span class="text-muted">Recordame!</span>
								</label>
							</div>

							<!--        -->
							<!-- ACTION -->
							<!--        -->
							<div class="text-center">
								<input type="submit" class="btn btn-primary my-4"
									value="Ingresar" title="Iniciar Sesión">
							</div>
						</form>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-6">
						<a href="#" class="text-light"><small>¿Olvidaste la
								clave?</small></a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<!--    -->
<!-- JS -->
<!--    -->
<script type="text/javascript" src="resources/js/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script type="text/javascript" src="resources/js/request/login.js"></script>



<%@include file="/template/footer.jsp"%>