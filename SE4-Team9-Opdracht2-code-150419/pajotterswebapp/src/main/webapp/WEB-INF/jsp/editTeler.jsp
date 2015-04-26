<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Teler bewerken - Pajottersapplicatie</title>
        <script src="jquery.js"></script>
        <script type="text/javascript">
        	$(document).ready(function () {
        			var id = $("#idveld").val();
        			$("#idveld").hide();
        			$("#zichtbareid").text(id);
        		});
        </script>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
	<body>
		<div id="BovenPaneel">
			<div id="Titel">
				<h1>Teler bewerken</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Bewerk de onderstaande velden naar believen en klik op opslaan.
				<c:url var="url" value="/updateTeler.html" />
				<form:form method="POST" commandName="deteler" action="${url}">
					<table>
						<tbody>
							<tr>
								<td><label for="idveld">ID:</label></td>
								<td><form:input id="idveld" path="id"></form:input><div id="zichtbareid"></div></td>
							</tr>
							<tr>
								<td><label for="vnaam">Naam:</label></td>
								<td><form:input id="vnaam" path="voornaam" /></td>
							</tr>
							<tr>
								<td><label for="fnaam">Familienaam:</label></td>
								<td><form:input id="fnaam" path="familienaam" /></td>
							</tr>
							
							<tr>
								<td><label for="email">Emailadres:</label></td>
								<td><form:input id="email" path="emailadres" /></td>
							</tr>
							<tr>
								<td><label for="adres">Adres:</label></td>
								<td><form:input id="adres" path="adres"/></td>
							</tr>
							<tr>
								<td><label for="telefoon">Telefoon:</label></td>
								<td><form:input id="telefoon" path="telefoon" /></td>
							</tr>
							<tr>
								<td><label for="pwoord">Paswoord:</label></td>
								<td><form:input id="pwoord" path="paswoord" /></td>
							</tr>
						</tbody>
					</table>
					
					<div class="knoppenpaneel">
						<input class="knop" name="submit" type="submit" value="Opslaan" />
						<c:url var="home" value="/home.html" />
						<a class="knop" href='<c:out value="${home}"/>'>Annuleren</a>
					</div>
				</form:form>
			</div>
		</div>
		
		
		
	</body>
</html>
