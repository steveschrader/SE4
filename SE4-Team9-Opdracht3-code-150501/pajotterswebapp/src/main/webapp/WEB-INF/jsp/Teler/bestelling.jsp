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
				<h1>Details van de bestelling</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<table>
		        	<tr>
		        		<td><b>ID:</b></td> <td><c:out value="${bestelling.id}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Aangeboden bestelling:</b></td> <td><c:out value="${bestelling.tekst}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Aantal:</b></td> <td><c:out value="${bestelling.aantal}"/></td>
		        	</tr>
		        	
		        	<tr>
		        		<td><b>Leverancier:</b></td> <td><c:out value="${bestelling.LervancierId}"/></td>
		        	</tr>
		        	
		        	
		        	
		        </table>
		        
		        <c:url var="VerwijderbestellingUrl" value="/Teler/verwijderBestelling.html">
					<c:param name="id" value="${bestelling.id}" />
		        </c:url>
		        
		        <c:url var="home" value="/Teler/bestellingLijst.html" />
		        
		        <c:url var="updatebestellingUrl" value="/Teler/updateBestelling.html">
					<c:param name="id" value="${bestelling.id}" />
		        </c:url>
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${home}"/>'>Terug</a>
			        <a class="knop" href='<c:out value="${updatebestellingUrl}"/>'>Bewerk Bestelling</a>
			        <a class="knop" href='<c:out value="${VerwijderbestellingUrl}"/>'>Verwijder Bestelling</a>
				</div>
			</div>
		</div>
    </body>
</html>
