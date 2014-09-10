<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="eventLayout">
    <tiles:putAttribute name="content">
        <h2 class="page-title">Lisa uus &uuml;ritus</h2>
        <form:form method="POST" action="/events/new" modelAttribute="event" role="form">
            <form:errors path="*" cssClass="error"/>
            <div class="form-group">
                <form:label path="title"><spring:message code="event.title" /></form:label>
                <form:input path="title" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="dateStart"><spring:message code="event.date_start" /></form:label>
                <form:input path="dateStart" placeholder="YYYY-MM-DD HH:mm" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="content"><spring:message code="event.content" /></form:label>
                <form:textarea path="content" class="form-control" rows="6" />
            </div>
            <div class="form-group">
                <form:label path="info_url"><spring:message code="event.info_url" /></form:label>
                <form:input path="info_url" class="form-control" />
            </div>
             <div class="form-group">
                <form:label path="location_title"><spring:message code="event.location_title" /></form:label>
                <form:input path="location_title" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="location_city"><spring:message code="event.location_city" /></form:label>
                <form:input path="location_city" class="form-control" />
            </div>
            <div class="form-group">
                <form:label path="location_country"><spring:message code="event.location_country" /></form:label>
                <form:input path="location_country" class="form-control" />
            </div>

            <input type="submit" value="Salvesta" class="btn btn-primary"/>

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form:form>
    </tiles:putAttribute>
</tiles:insertDefinition>