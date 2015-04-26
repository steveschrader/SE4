<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuwe teler - Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Teler toevoegen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Vul de het onderstaande formulier in om een nieuwe teler aan te maken.</p>
		        <c:url var="url" value="/nieuweTeler.html" />
		        <form:form action="${url}" commandName="deteler">   <%-- Spring form tags --%>
			            <table>
				            <tbody>
				            	<tr>
				            		<td><label for="vnaam">Voornaam:</label></td> <td><form:input id="vnaam" path="voornaam"/></td>
				            	</tr>
				            	<tr>
				            		<td><label for="fnaam">Familienaam:</label></td> <td><form:input id="fnaam" path="familienaam"/></td>
				            	</tr>
				            	<tr>
				            		<td><label for="email">E-mailadres:</label></td> <td><form:input id="email" path="emailadres"/></td>
				            	</tr>
				            	<tr>
				            		<td><label for="adres">Adres:</label></td> <td><form:input id="adres" path="adres"/></td>
				            	</tr>
				            	<tr>
				            		<td><label for="telefoon">Telefoon:</label></td> <td><form:input for="telefoon" path="telefoon"/></td>
				            	</tr>
				            	<tr>
				            		<td><label for="pwoord">Paswoord:</label></td> <td><form:input id="pwoord" path="paswoord"/></td>
				            	</tr>
			            	</tbody>
			            </table>
			            
			            <div class="knoppenpaneel">
		                	<input class="knop" name="submit" type="submit" value="Opslaan"/>
		                	<c:url var="home" value="/home.html" />
		                	<a class="knop" href='<c:out value="${home}"/>'>Home</a>
		                </div>
		        </form:form>
			</div>
		</div>
    </body>
</html>
