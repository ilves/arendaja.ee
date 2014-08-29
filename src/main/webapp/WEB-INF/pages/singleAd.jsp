<%@ include file="/WEB-INF/layout/taglibs.jsp"%>

<h1>${ad.title}</h1>
<p>${ad.company_title} - ${ad.company_city}, ${ad.company_country}</p>
<p>${ad.content}</p>
<c:if test="${fn:length(ad.info_url) > 5}">
    <p>Lisainfo: <a target="_blank" href="${ad.info_url}">${ad.info_url}</a></p>
</c:if>

<c:set var="baseURL" value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}" />
<div class="social">
    <div class="fb-share-button" data-type="box_count" data-href="${baseUrl}/ad/${ad.id}"></div>
</div>