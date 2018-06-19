<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>reviewfinal</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript"src="jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	
	var xmlHttp;
	xmlHttp=new XMLHttpRequest();
	var url="getreview.bhukkad";
	xmlHttp.open('POST', url, true)
	xmlHttp.send();
	xmlHttp.onreadystatechange=function()
	{
		if(xmlHttp.readyState==4)
		{
		result=xmlHttp.responseText;
		result=result.trim();
		$("#review").html(result);
		}
		
		
		
	}
});	 
</script>
</head>
<body class="bodystyles">

	<nav class="navbar navbar-light bg-light justify-content-between">
		<a class="navbar-brand">Bhukkad Guest Reviews</a>
		
	</nav>
	<div class="container">
				<div id="comments" class="column nine">

					<br />
					<h2>Restaurant</h2>

		

	
	<div>
	<div id="review">
	
	
	
	</div>
</div>
				</div>
				<form action="feedback.bhukkad" method="post">
			
					<table ID="FormTable_1678" class="region formBuilderTable">
						<tr>
							<td class="formTableCell"><div class="fieldNameOutputHTML">
									<strong>Tell us about your experience with BHUKKAD
										APP:</strong>
								</div></td>


						</tr>
						<tr>
							<td class="formTableCell">
							
							<div class="fieldNameOutputTextLine">
									<label>Name: <span class="required">*</span></label>
								</div>
								<div class="fieldWrapperOutputTextLine">
									<input id="Feed_name" name="FeedbackName" type="text"
										class="textbox" />
								</div></td>


						</tr>
						<!-- <tr>
							<td class="formTableCell"><div
									class="fieldNameOutputTextLine">
									<label>Last Initial: </label>
								</div>
								<div class="fieldWrapperOutputTextLine">
									<input name="ctl00$content4$FORM_1678_15983_15512" type="text"
										id="content4_FORM_1678_15983_15512" class="textbox" />
								</div></td>


						</tr> -->
						
						<tr>
							<td class="formTableCell"><div
									class="fieldNameOutputTextArea">
									<label>Comments: <span class="required">*</span></label>
								</div>
								<div class="fieldWrapperOutputTextArea">
									<input rows="2"
										 id="Feed_comment" class="textarea" name="FeedbackComment">
									</input>
								</div></td>


						</tr>
						<!-- <tr>
							<td class="formTableCell"><div
									class="fieldNameOutputTextLine">
									<label><span class="BotTextbox"> Suggestions: </span></label>
								</div>
								<div class="fieldWrapperOutputTextLine">
									<input name="ctl00$content4$FORM_1678_16874_16403" type="text"
										id="content4_FORM_1678_16874_16403" class="BotTextbox" />
								</div></td>


						</tr> -->
						<tr>
							<td><input type="submit"
								value="Submit"
								id="submitform"
								/></td>
						</tr>
					</table>
				</form>
				</div>
</body>
</html>