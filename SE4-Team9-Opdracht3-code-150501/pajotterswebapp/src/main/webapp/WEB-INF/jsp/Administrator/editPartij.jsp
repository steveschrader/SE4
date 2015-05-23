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
				<h1>Partij bewerken</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Bewerk de onderstaande velden naar believen en klik op opslaan.
				<c:url var="url" value="/Administrator/updatePartij.html" />
				<form:form method="POST" commandName="departij" action="${url}">
					<table>
						<tbody>
							<tr>
								<td><label for="idveld">ID:</label></td>
								<td><form:input id="idveld" path="id"></form:input><div id="zichtbareid"></div></td>
							</tr>
							<tr>
								<td><label for="vnaam">Naam:</label></td>
								<td><form:input id="vnaam" path="voornaam" /></td>
								<td><font color="red"><form:errors path="voornaam" /></font></td>
							</tr>
							<tr>
								<td><label for="fnaam">Familienaam:</label></td>
								<td><form:input id="fnaam" path="familienaam" /></td>
								<td><font color="red"><form:errors path="familienaam" /></font></td>
							</tr>
							
							<tr>
								<td><label for="email">Emailadres:</label></td>
								<td><form:input id="email" path="emailadres" /></td>
								<td><font color="red"><form:errors path="emailadres" /></font></td>
							</tr>
							
							<tr>
								<td><label for="pwoord">Paswoord:</label></td>
								<td><form:input id="pwoord" path="paswoord" /></td>
								<td><font color="red"><form:errors path="paswoord" /></font></td>
							</tr>
							<tr>
								<td><label for="rol">Rol:</label></td>
								<td><form:select id="rol" path="" name="rol">
										  <option value="Industrie">Industrie</option>
										  <option value="Koper">Koper</option>
										  <option value="Leverancier">Leverancier</option>
										  <option value="Pajotter">Pajotter</option>
										  <option value="Teler">Teler</option>
								</form:select></td>
							</tr>
						</tbody>
					</table>
					
					<div class="knoppenpaneel">
						<input class="knop" name="submit" type="submit" value="Opslaan" />
						<c:url var="home" value="/Administrator/home.html" />
						<a class="knop" href='<c:out value="${home}"/>'>Annuleren</a>
					</div>
				</form:form>
			</div>
		</div>
		
		
		
	</body>
</html>
