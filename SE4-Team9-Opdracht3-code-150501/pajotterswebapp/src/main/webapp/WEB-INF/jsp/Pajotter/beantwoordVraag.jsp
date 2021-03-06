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
				<h1>Vraag beantwoorden</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Vul hier het antwoord in op de Vraag</p>
				<c:url var="url" value="/Pajotter/beantwoordVraag.html" />
				<form:form method="POST" commandName="devraag" action="${url}" >
					<table>
						<tbody>
							<tr>
			            		<td><label for="id">Vraag:</label></td> <td><form:input id="id" path="id"/></td>
			            		<td><font color="red"><form:errors path="tekst" /></font></td>
			            	</tr>
							<tr>
			            		<td><label for="tekst">Vraag:</label></td> <td><form:input id="tekst" path="tekst"/></td>
			            		<td><font color="red"><form:errors path="tekst" /></font></td>
			            	</tr>
			            	<tr>
			            		<td><label for="tekst">Antwoord:</label></td> <td><form:input id="antwoord" path="" name="antwoord"/></td>
			            		
			            	</tr>
			            	
						</tbody>
					</table>
					
					<div class="knoppenpaneel">
						<input class="knop" name="submit" type="submit" value="Opslaan" />
						<c:url var="home" value="/Pajotter/vraagLijst.html" />
						<a class="knop" href='<c:out value="${home}"/>'>Annuleren</a>
					</div>
				</form:form>
			</div>
		</div>
		
		
		
	</body>
</html>
