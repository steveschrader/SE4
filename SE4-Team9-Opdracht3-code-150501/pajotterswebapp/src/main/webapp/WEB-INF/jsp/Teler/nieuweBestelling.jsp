<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuwe Bestelling toevoegen - Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Bestelling toevoegen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Vul de het onderstaande formulier in om een nieuwe bestelling toe te voegen.</p>
		        <c:url var="url" value="/Teler/nieuweBestelling.html">
		       
		        </c:url>
		        <form:form action="${url}" commandName="debestelling">   <%-- Spring form tags --%>
			            <table>
				            <tbody>
				            	<tr>
				            		<td><label for="tekst">Aan te bieden bestelling:</label></td> <td><form:input id="tekst" path="tekst"/></td>
				            		<td><font color="red"><form:errors path="tekst" /></font></td>
				            	</tr>
				            	<tr>
				            		<td><label for="aantal">Aantal:</label></td> <td><form:input id="aantal" path="aantal" type="number"/></td>
				            		<td><font color="red"><form:errors path="aantal" /></font></td>
				            	</tr>
				            	
				            	<tr>
				            		<td><label for="lev">Leverancier:</label></td> <td><form:input id="lev" path="LeverancierId" type="number"/></td>
				            		<td><font color="red"><form:errors path="LeverancierId" /></font></td>
				            	</tr>
				            	
			            	</tbody>
			            </table>
			            
			            <div class="knoppenpaneel">
		                	<input class="knop" name="submit" type="submit" value="Opslaan"/>
		                	<c:url var="home" value="/index.html" />
		                	<a class="knop" href='<c:out value="${home}"/>'>Home</a>
		                </div>
		        </form:form>
			</div>
		</div>
    </body>
</html>
