<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="eventLayout">
    <tiles:putAttribute name="content">
        <h1>${event.title}</h1>
        <p>${event.location_title} - ${event.location_city}, ${event.location_country}</p>
        <p>${event.content}</p>
        <if test="${fn:length(event.info_url) > 0}">
            <p>Lisainfo: <a target="_blank" href="${event.info_url}">${event.info_url}</a></p>
        </if>
    </tiles:putAttribute>
</tiles:insertDefinition>