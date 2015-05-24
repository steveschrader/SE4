
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
				<h1>Welkom Administrator</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<p class="inleiding">Hier kan u de verschillende partijen beheren.</p>
				<h2>Lijst van Partijen</h2>
				<ul>
		            <c:forEach items="${partijen}" var="partij">
		                <c:url var="partijUrl" value="/Administrator/partij.html">
		                    <c:param name="id" value="${partij.id}" />
		                </c:url>
		                <li>
		                    <a href='<c:out value="${partijUrl}"/>'>
		                        <c:out value="${partij.voornaam}" />
		                        <c:out value="${partij.familienaam}" />
		                        <!--<c:out value="${partij.id}" />-->
		                        (<c:out value="${partij.getTypes()}"></c:out>)
		                    </a>
		                </li>
		            </c:forEach>
		        </ul>
		        
		        <%--<table style="width: 100%;">
		        	<c:forEach items="${partijen}" var="partij">
		                <c:url var="partijUrl" value="/Administrator/partij.html">
		                    <c:param name="id" value="${partij.id}" />
		                </c:url>
		                <tr>
			                <td>
			                	<a href='<c:out value="${partijUrl}"/>'>
		                        <c:out value="${partij.voornaam}" />
		                        <c:out value="${partij.familienaam}" />
		                        </a>
			                </td>
			                <td>
			                	<a href='<c:out value="${partijUrl}"/>'>
			                	<c:out value="${partij.getTypes()}"></c:out>
			                	</a>
			                </td>
			            </a>
			            </tr>
		            </c:forEach>--%>
		        </table>
		        <c:url var="nieuwePartijUrl" value="/Administrator/nieuwePartij.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${nieuwePartijUrl}"/>'>Partij Toevoegen</a>
		        </div>
		        
		        <form class="form-inline" action="/Pajotters/logout" method="post">
					<input class="knop" type="submit" value="Log out" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		    	</form>
			</div>
		</div>
    </body>
</html>
