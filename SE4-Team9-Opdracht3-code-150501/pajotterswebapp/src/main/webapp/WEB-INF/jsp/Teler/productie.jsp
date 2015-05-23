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
				<h1>Details van Productie</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<table>
		        	<tr>
		        		<td><b>ID:</b></td> <td><c:out value="${productie.id}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Aangeboden Productie:</b></td> <td><c:out value="${productie.tekst}"/></td>
		        	</tr>
		        	<tr>
		        		<td><b>Aantal:</b></td> <td><c:out value="${productie.aantal}"/></td>
		        	</tr>
		        	
		        	
		        </table>
		        
		        <c:url var="VerwijderproductieUrl" value="/Teler/verwijderProductie.html">
					<c:param name="id" value="${productie.id}" />
		        </c:url>
		        
		        <c:url var="home" value="/Teler/productieLijst.html" />
		        
		        <c:url var="updateproductieUrl" value="/Teler/updateProductie.html">
					<c:param name="id" value="${productie.id}" />
		        </c:url>
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${home}"/>'>Terug</a>
			        <a class="knop" href='<c:out value="${updateproductieUrl}"/>'>Bewerk Productie</a>
			        <a class="knop" href='<c:out value="${VerwijderproductieUrl}"/>'>Verwijder Productie</a>
				</div>
			</div>
		</div>
    </body>
</html>
