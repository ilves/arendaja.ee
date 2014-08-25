<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="content">
        <h1>${ad.title}</h1>
        <p>${ad.company_title} - ${ad.company_city}, ${ad.company_country}</p>
        <p>${ad.content}</p>
        <if test="${fn:length(ad.info_url) > 0}">
            <p>Lisainfo: <a target="_blank" href="${ad.info_url}">${ad.info_url}</a></p>
        </if>
    </tiles:putAttribute>
</tiles:insertDefinition>