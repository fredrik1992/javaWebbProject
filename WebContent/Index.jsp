<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/Index.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="pageWrapper " id="pagewrapperID">

		<%@ include file="Header.jsp"%>


		<%@ include file="Navbar.jsp"%>

		<div class="uiButton dropdown">
			<button class="btn btn-primary dropdown-toggle" type="button"
				id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false">Choose UI</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<button class="dropdown-item" href="#" onclick=chooseUi("dark")>Dark</button>
				<button class="dropdown-item" href="#" onclick=chooseUi("white")>White</button>


			</div>
		</div>



		<%//if sucsessfuly loged in before redirects right away
		String username = (String) session.getAttribute("username");
		if (username != null) {

			response.sendRedirect("LoginController");

		}
		%>

		<form action="<%=request.getContextPath()%>/LoginController"
			method="post">
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Enter</span>
				</div>
				<input type="text" class="form-control" name="username"
					placeholder="Username" aria-label="Username"
					aria-describedby="basic-addon1  " required>
			</div>

			<!-- hidden data -->

			<input id="uiChoice" class="uiChoice" type="hidden" name="uiColor">

			<input id="cookieAllow" class="cookieAllow" type="hidden"
				name="cookieAllow"> <input id="loginHasAttemptbeenMade"
				type="hidden" name="loginHasAttemptbeenMade">
			<!-- hidden -->

			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text" id="basic-addon1">Enter</span>
				</div>
				<input type="text" class="form-control" name="password"
					placeholder="Password" aria-label="Username"
					aria-describedby="basic-addon1" required>
			</div>

			<input type="submit">



		</form>



	</div>

	<script type="text/javascript" src="Js/index.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>