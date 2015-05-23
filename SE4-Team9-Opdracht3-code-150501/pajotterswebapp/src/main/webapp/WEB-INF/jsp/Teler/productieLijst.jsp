<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Lijst van Productie</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<ul>
		            <c:forEach items="${productie}" var="productie">
		                <c:url var="productieUrl" value="/Teler/productie.html">
		                    <c:param name="id" value="${productie.id}" />
		                </c:url>
		                <li>
		                    <a href='<c:out value="${productieUrl}"/>'>
		                        <c:out value="${productie.aantal}" />
		                        <c:out value="${productie.tekst}" />
		                        
		                    </a>
		                </li>
		            </c:forEach>
		        </ul>
		        <c:url var="nieuweProductieUrl" value="/Teler/nieuweProductie.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${nieuweProductieUrl}"/>'>Productie Toevoegen</a>
		        	<c:url var="home" value="/Teler/index.html" />
		                	<a class="knop" href='<c:out value="${home}"/>'>Home</a>
		        </div>
			</div>
		</div>
    </body>
</html>
