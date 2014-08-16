<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="content">
        This page is secured

        <c:if test="${pageContext.request.userPrincipal.name != null}">
           <h2>Welcome : ${pageContext.request.userPrincipal.name}
               | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>
        </c:if>

    </tiles:putAttribute>
</tiles:insertDefinition>