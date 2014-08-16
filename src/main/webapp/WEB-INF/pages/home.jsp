<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="content">
        <div class="body">
            <c:forEach var="ad" items="${ads}">
                <div class="job-ad">
                    <h2><a href="<spring:url value="/ad/${ad.id}" />">${ad.title}</a></h2>
                    <span class="company">${ad.company_title}</span>
                    <span> - </span>
                    <span class="location">${ad.company_city}, ${ad.company_country}</span>
                    <span class="summary">${ad.summary}</span>
                    <span class="info">
                        ${ad.relativeDateTime}
                    </span>
                </div>
            </c:forEach>

            <c:if test="${empty ads}"><p>&Uuml;htegi aktiivset kuulutust ei leitud!</p></c:if>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>