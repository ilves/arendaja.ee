<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="content">
        <div class="body">
            <h1>Manage ADS</h1>
            <table class="table">
            <c:forEach var="ad" items="${ads}">
                <form:form modelAttribute="action" method="POST">
                <tr>
                    <td>${ad.title}</td>
                    <td><c:if test="${ad.active eq '1'}">Aktiivne</c:if></td>
                    <td><form:select path="action" items="${actions}" /></td>
                    <td><input type="submit" value="Edasi" class="btn btn-primary"/></td>
                </tr>
                <input type="hidden" name="id" value="${ad.id}"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form:form>
            </c:forEach>
            </table>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>