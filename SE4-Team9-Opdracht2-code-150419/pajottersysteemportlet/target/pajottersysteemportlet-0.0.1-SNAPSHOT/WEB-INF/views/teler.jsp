<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Pajottersapplicatie</title>
    </head>
    
    <body>
        <h1>Details van teler</h1>
        
        <b>Id:</b>
        <c:out value="${teler.id}" /><br/>
        <b>Voornaam:</b>
        <c:out value="${teler.voornaam}" /><br/>
        <b>Familienaam:</b>
        <c:out value="${teler.familienaam}" /><br/>
        <b>E-mailadres:</b>
        <c:out value="${teler.emailadres}" /><br/>
        <b>Adres:</b>
        <c:out value="${teler.adres}" /><br/>
        <b>Telefoon:</b>
        <c:out value="${teler.telefoon}" /><br/>
        <b>Paswoord:</b>
        <c:out value="${teler.paswoord}" /><br/>
        <br/>

        <portlet:renderURL var="showUrl">
			<portlet:param name="myaction" value="" />
 		</portlet:renderURL>
 		
        <a href='<c:out value="${showUrl}"/>'>Home</a>
         <br/>
        <portlet:renderURL var="deleteUrl">
			<portlet:param name="myaction" value="telerDelete" />
			<portlet:param name="id" value="${teler.id}" />
 		</portlet:renderURL>
 		
 		<a href='<c:out value="${deleteUrl}"/>'>Delete</a>
 		 <br/>
 		<portlet:renderURL var="updatepageUrl">
			<portlet:param name="myaction" value="telerUpdatePage" />
			<portlet:param name="id" value="${teler.id}" />
 		</portlet:renderURL>
 		
 		<a href='<c:out value="${updatepageUrl}"/>'>Update</a>
    </body>
</html>
