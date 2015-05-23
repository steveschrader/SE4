<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bestelling bewerken - Pajottersapplicatie</title>
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
				<h1>Bestelling bewerken</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Bewerk de onderstaande velden naar believen en klik op opslaan.
				<c:url var="url" value="/Teler/updateBestelling.html" />
				<form:form method="POST" commandName="debestelling" action="${url}" >
					<table>
						<tbody>
							<tr>
								<td><label for="idveld">ID:</label></td>
								<td><form:input id="idveld" path="id"></form:input><div id="zichtbareid"></div></td>
							</tr>
							<tr>
			            		<td><label for="tekst">Aan te bieden bestelling:</label></td> <td><form:input id="tekst" path="tekst"/></td>
			            		<td><font color="red"><form:errors path="tekst" /></font></td>
			            	</tr>
			            	<tr>
			            		<td><label for="aantal">Aantal:</label></td> <td><form:input id="aantal" path="aantal" type="number"/></td>
			            		<td><font color="red"><form:errors path="aantal" /></font></td>
			            	</tr>
						</tbody>
					</table>
					
					<div class="knoppenpaneel">
						<input class="knop" name="submit" type="submit" value="Opslaan" />
						<c:url var="home" value="/Teler/bestellingLijst.html" />
						<a class="knop" href='<c:out value="${home}"/>'>Annuleren</a>
					</div>
				</form:form>
			</div>
		</div>
		
		
		
	</body>
</html>
