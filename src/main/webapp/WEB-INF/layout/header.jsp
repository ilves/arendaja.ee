<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<b:navbar>
    <b:navbarHeader brand="&lt;Arendaja.ee/&gt;" link="/"></b:navbarHeader>
    <ul class="nav navbar-nav">
        <li class="<c:if test="${!fn:contains(requestScope['javax.servlet.forward.request_uri'], 'event')}">active</c:if>"><a href="/">T&ouml;&ouml;kuulutused</a></li>
        <li class="<c:if test="${fn:contains(requestScope['javax.servlet.forward.request_uri'], 'event')}">active</c:if>">
            <a href="/events">&Uuml;ritused</a>
        </li>
    </ul>
</b:navbar>