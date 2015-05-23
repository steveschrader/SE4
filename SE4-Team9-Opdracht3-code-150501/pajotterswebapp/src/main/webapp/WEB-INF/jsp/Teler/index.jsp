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
				<h1>Welkom Teler</h1>
				<h4>Hier kan u de verschillende opties waartoe u recht heeft bezien</h4>
				
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				
		        <c:url var="Bestelling" value="/Teler/aanbiedingLijst.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${Bestelling}"/>'>Bestellingen beheren</a>
		        </div>
		        
		           <c:url var="Productie" value="/Teler/productieLijst.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${productie}"/>'>Productie beheren</a>
		        </div>
		        <c:url var="logout" value="/logout.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${logout}"/>'>Logout</a>
		        </div>
			</div>
		</div>
    </body>
</html>
