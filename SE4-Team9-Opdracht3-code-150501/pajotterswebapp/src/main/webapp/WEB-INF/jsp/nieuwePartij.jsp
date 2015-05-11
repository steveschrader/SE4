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
				<h1>Partij toevoegen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Vul de het onderstaande formulier in om een nieuwe teler aan te maken.</p>
		        <c:url var="url" value="/nieuwePartij.html">
		        	<c:param name="rol" value="${rol}" />
		        </c:url>
		        <form:form action="${url}" commandName="departij">   <%-- Spring form tags --%>
			            <table>
				            <tbody>
				            	<tr>
				            		<td><label for="vnaam">Voornaam:</label></td> <td><form:input id="vnaam" path="voornaam"/></td>
				            		<td><font color="red"><form:errors path="voornaam" /></font></td>
				            	</tr>
				            	<tr>
				            		<td><label for="fnaam">Familienaam:</label></td> <td><form:input id="fnaam" path="familienaam"/></td>
				            		<td><font color="red"><form:errors path="familienaam" /></font></td>
				            	</tr>
				            	<tr>
				            		<td><label for="email">E-mailadres:</label></td> <td><form:input id="email" path="emailadres"/></td>
				            		<td><font color="red"><form:errors path="emailadres" /></font></td>
				            	</tr>
				            	<tr>
				            		<td><label for="pwoord">Paswoord:</label></td> <td><form:input id="pwoord" path="paswoord"/></td>
				            		<td><font color="red"><form:errors path="paswoord" /></font></td>
				            	</tr>
				            	
				            	<tr>
   									<td><label for="rol">Rol:</label></td>
   									
   									<td><form:select id="rol" value="rol" path="rollekedatnietwiltwerken" var="rol">
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
		                	<input class="knop" name="submit" type="submit" value="Opslaan"/>
		                	<c:url var="home" value="/home.html" />
		                	<a class="knop" href='<c:out value="${home}"/>'>Home</a>
		                </div>
		        </form:form>
			</div>
		</div>
    </body>
</html>
