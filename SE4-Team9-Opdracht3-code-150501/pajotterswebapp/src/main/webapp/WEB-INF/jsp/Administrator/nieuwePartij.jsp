
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuwe teler - Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet" type="text/css"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Partij toevoegen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Vul de het onderstaande formulier in om een nieuwe teler aan te maken.</p>
		        <c:url var="url" value="/Administrator/nieuwePartij.html">
		        </c:url>
		        <form:form action="${url}" modelAttribute="departij">   <%-- Spring form tags --%>
			            <table>
				            <tbody>
				            	<tr>
				            		<td><label for="vnaam">Voornaam:</label></td> <td><form:input id="vnaam" path="partij.voornaam"/></td>
				            		<td><font color="red"><form:errors path="partij.voornaam" /></font></td>
				            	</tr>
				            	<tr>
				            		<td><label for="fnaam">Familienaam:</label></td> <td><form:input id="fnaam" path="partij.familienaam"/></td>
				            		<td><font color="red"><form:errors path="partij.familienaam" /></font></td>
				            	</tr>
				            	<tr>
				            		<td><label for="email">E-mailadres:</label></td> <td><form:input id="email" path="partij.emailadres"/></td>
				            		<td><font color="red"><form:errors path="partij.emailadres" /></font></td>
				            	</tr>
				            	<tr>
				            		<td><label for="pwoord">Paswoord:</label></td> <td><form:input id="pwoord" path="partij.paswoord"/></td>
				            		<td><font color="red"><form:errors path="partij.paswoord" /></font></td>
				            	</tr>
				            	
				            	<tr>
   									<td><label for="rol">Rol:</label></td>
   									

   									<td>
	   									<form:select id="rol" path="rol" name="rol">
										  <form:option value="Industrie">Industrie</form:option>
										  <form:option value="Koper">Koper</form:option>
										  <form:option value="Leverancier">Leverancier</form:option>
										  <form:option value="Pajotter">Pajotter</form:option>
										  <form:option value="Teler">Teler</form:option>
										</form:select>
									</td>
				                </tr>
			            	</tbody>
			            </table>
			            
			            <div class="knoppenpaneel">
		                	<input class="knop" name="submit" type="submit" value="Opslaan"/>
		                	<c:url var="home" value="/Administrator/home.html" />
		                	<a class="knop" href='<c:out value="${home}"/>'>Home</a>
		                </div>
		        </form:form>
			</div>
		</div>
    </body>
</html>
