<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Telerapplicatie</title>
    </head>
    
    <body>
        <h1>Teler toevoegen</h1>

		<portlet:actionURL var="addTelerActionUrl">
			<portlet:param name="myaction" value="addTeler" />
		</portlet:actionURL>

        <form:form action="${addTelerActionUrl}" commandName="nieuweteler" method="post">   <%-- Spring form tags --%>
            <fieldset>
                <div><label>Voornaam:</label><form:input path="voornaam"/></div>
                <div><label>Familienaam:</label><form:input path="familienaam"/></div>
                <div><label>E-mailadres:</label><form:input path="emailadres"/></div>
                <div><label>Adres:</label><form:input path="adres"/></div>
                <div><label>Telefoon:</label><form:input path="telefoon"/></div>
                <div><label>Paswoord:</label><form:input path="paswoord"/></div>
                <div><input name="submit" type="submit" value="Opslaan"/></div>
            </fieldset>
        </form:form>
        <portlet:renderURL var="showUrl">
			<portlet:param name="myaction" value="" />
 		</portlet:renderURL>
 		
        <a href='<c:out value="${showUrl}"/>'>Home</a>
    </body>
</html>
