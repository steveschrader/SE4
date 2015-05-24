<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productie details - Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Details van de Vraag</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<table>
		        	<tr>
		        		<td><b>ID:</b></td> <td><c:out value="${vraag.id}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Vraag:</b></td> <td><c:out value="${vraag.tekst}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Antwoord:</b></td>
		        		<td><c:out value=""/></td>
		        	</tr>
		        	
		        	
		        	
		        	
		        </table>
		        
		        <c:url var="VerwijdervraagUrl" value="/Teler/verwijderVraag.html">
					<c:param name="id" value="${vraag.id}" />
		        </c:url>
		        
		        <c:url var="home" value="/Teler/vraagLijst.html" />
		        
		        <c:url var="updatevraagUrl" value="/Teler/updateVraag.html">
					<c:param name="id" value="${vraag.id}" />
		        </c:url>
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${home}"/>'>Terug</a>
			        <a class="knop" href='<c:out value="${updatevraagUrl}"/>'>Bewerk Vraag</a>
			        <a class="knop" href='<c:out value="${VerwijdervraagUrl}"/>'>Verwijder Vraag</a>
				</div>
			</div>
		</div>
    </body>
</html>
