<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="content">
        <h2 class="page-title">Lisa uus t&ouml;&ouml;kuulutus</h2>
        <form:form method="POST" action="/new" modelAttribute="ad" role="form">
            <form:errors path="*" cssClass="error"/>
            <div class="form-group">
                <form:label path="company_title"><spring:message code="ad.company" /></form:label>
                <form:input path="company_title" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="title"><spring:message code="ad.title" /></form:label>
                <form:input path="title" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="content"><spring:message code="ad.content" /></form:label>
                <form:textarea path="content" class="form-control" rows="6" />
            </div>
            <div class="form-group">
                <form:label path="company_city"><spring:message code="ad.company_city" /></form:label>
                <form:input path="company_city" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="company_country"><spring:message code="ad.company_country" /></form:label>
                <form:input path="company_country" class="form-control" />
            </div>

            <input type="submit" value="Salvesta" class="btn btn-primary"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>