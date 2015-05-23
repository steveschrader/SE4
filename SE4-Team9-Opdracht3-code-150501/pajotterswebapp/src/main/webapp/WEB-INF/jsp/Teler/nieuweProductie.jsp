<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nieuwe Productie toevoegen - Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Productie toevoegen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p>Vul de het onderstaande formulier in om een nieuwe productie toe te voegen.</p>
		        <c:url var="url" value="/Teler/nieuweProductie.html">
		        <c:param name="PartijId" value="1" />
		        </c:url>
		        <form:form action="${url}" commandName="deproductie">   <%-- Spring form tags --%>
			            <table>
				            <tbody>
				            	<tr>
				            		<td><label for="tekst">Aan te bieden productie:</label></td> <td><form:input id="tekst" path="tekst"/></td>
				            		<td><font color="red"><form:errors path="tekst" /></font></td>
				            	</tr>
				            	<tr>
				            		<td><label for="aantal">Aantal:</label></td> <td><form:input id="aantal" path="aantal" type="number"/></td>
				            		<td><font color="red"><form:errors path="aantal" /></font></td>
				            	</tr>
				            	
			            	</tbody>
			            </table>
			            
			            <div class="knoppenpaneel">
		                	<input class="knop" name="submit" type="submit" value="Opslaan"/>
		                	<c:url var="home" value="/Teler/index.html" />
		                	<a class="knop" href='<c:out value="${home}"/>'>Home</a>
		                </div>
		        </form:form>
			</div>
		</div>
    </body>
</html>
