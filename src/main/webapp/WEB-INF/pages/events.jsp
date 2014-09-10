<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="eventLayout">
    <tiles:putAttribute name="content">
        <div class="body">
            <h2 style="margin-bottom:20px;">L&auml;hiajal toimuvad &uuml;ritused programeerijatele, arendajatele, adminstraatoritele ja teistele IT inimestele. Kiirelt ja mugavalt!</h2>

            <table class="table">
                <tr>
                    <th>Pealkiri</th>
                    <th>Aeg</th>
                    <th>Asukoht</th>
                    <th></th>
                </tr>
                <c:forEach var="event" items="${events}">
                <tr>
                    <td><a href="<spring:url value="/events/event/${event.id}" />">${event.title}</a></td>
                    <td><fmt:formatDate value="${event.dateStart}" pattern="yyyy-MM-dd HH:mm" /></td>
                    <td>${event.location_title} - ${event.location_city}, ${event.location_country}</td>
                    <td><a href="<spring:url value="/events/event/${event.id}" />" role="button" class="btn btn-info btn-xs pull-right">Lisainfo</a></td>
                </tr>
                </c:forEach>
            </table>

            <c:url value="/events/new" var="newAd" />
            <c:if test="${empty events}"><p>&Uuml;htegi aktiivset &uuml;ritust ei leitud! Ole esimene ja lisa <a href="${newAd}">uus &uuml;ritus</a>.</p></c:if>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>