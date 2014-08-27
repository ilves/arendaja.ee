<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="content">
        <div class="body">
            <h2 style="margin-bottom:20px;">T&ouml;&ouml;kuulutused, projektid, t&ouml;&ouml;pakkumised tarkvara programeerijatele, arendajatele, adminstraatoritele ja teistele IT inimestele. Kiirelt ja mugavalt!</h2>
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

            <c:url value="/new" var="newAd" />
            <c:if test="${empty ads}"><p>&Uuml;htegi aktiivset kuulutust ei leitud! Ole esimene ja lisa <a href="${newAd}">uus kuulutus</a>.</p></c:if>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>