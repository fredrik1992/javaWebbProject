<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/Feed.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="pageWrapper">

		<%
		String username = (String) session.getAttribute("username");
		if (username == null) {
			
			response.sendRedirect("index.jsp");
		}
		%>

		<%@ include file="Header.jsp"%>

		
		<button class="addFeedButton btn btn-primary" onclick="openForm()"   href="" role="button">Add feed</button>

		
		

		<%@ include file="Navbar.jsp"%>
		
<div class = "searchBoxTags">
<div class="input-group">
  <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search"
    aria-describedby="search-addon" />
  <button type="submit" class="btn btn-outline-primary">search</button>
</div>

</div>		


		<!-- hidden -->
		<form class="feedForm" id="feedFormID" action = "<%=request.getContextPath() %>/AddTagsController" method = "post">
			
			<div class="form-group">
				<label for="exampleFormControlSelect1">Select Tag</label> <select
					class="form-control" id="exampleFormControlSelect1" name = "tag">
					<option>Sun</option>
					<option>Moon</option>
					<option>3</option>
					<option>4</option>
					<option>5</option>
				</select>
			</div>
			
			<div class="form-group">
				<label for="exampleFormControlTextarea1">TextArea</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					rows="3" name = "text"></textarea>
			</div>
			<input class="btn btn-primary" type="submit" value="Submit">
		</form>

		<!-- hidden -->



		<!-- make a request to get all  tags into a bean list that is saved somwhere not sure where ? -->

		<%
		String allFeeds = (String) session.getAttribute("allFeedsData");
		if (allFeeds == null) {
			
			response.sendRedirect("GetTagsController");

		}
		%>





		<div class="row">

			<%
			if (allFeeds != null) {
				String[] splitFeeds = allFeeds.split(";");
				String text = "";
				String tag = "";
				for (int i = 0; i < splitFeeds.length; i++) {
					if (i % 2 == 0) {
				text = splitFeeds[i];
					} else {
				tag = splitFeeds[i];
				//create element
				out.print("<div class=\"col-md-4\"> <h2>Post</h2> <p>" + text
						+ "</p> <p><a class=\"btn btn-secondary\" href=\"#\" role=\"button\">" + tag
						+ " »</a></p> </div> ");
					}
				}

			}
			%>

		</div>


        <script type="text/javascript" src="Js/Feed.js"></script>
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