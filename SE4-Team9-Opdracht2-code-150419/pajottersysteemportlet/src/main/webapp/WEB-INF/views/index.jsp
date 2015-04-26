<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Welkom in de Pajottersapplicatie</title>
    </head>
    
    <body>
        <h1>Lijst van Telers</h1>
        
        <ul>
             <c:forEach items="${telers}" var="teler">
            
				<portlet:renderURL var="telerUrl">
					<portlet:param name="myaction" value="telerDetail" />
					<portlet:param name="id" value="${teler.id}" />
				</portlet:renderURL>					

                <li>
                    <a href='<c:out value="${telerUrl}"/>'>
                        <c:out value="${teler.voornaam}" />
                        <c:out value="${teler.familienaam}" />
                    </a>
                </li>
            </c:forEach>
        </ul>
        
		<portlet:renderURL var="showAddTelerUrl">
			<portlet:param name="myaction" value="addTelerForm" />
		</portlet:renderURL>
		
		<a href='<c:out value="${showAddTelerUrl}"/>'> Nieuwe teler toevoegen</a>
		
		
		
    </body>
    
    
</html>
