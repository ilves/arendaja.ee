<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="content">
        <h1>${ad.title}</h1>
        <p>${ad.company_title} - ${ad.company_city}, ${ad.company_country}</p>
        <p>${ad.content}</p>
    </tiles:putAttribute>
</tiles:insertDefinition>