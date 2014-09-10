<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<div class="menu bg-warning">
    <ul class="nav nav-pills nav-stacked">
        <li class="<c:if test="${requestScope['javax.servlet.forward.request_uri'] eq '/events'}">active</c:if>">
            <c:url value="/events" var="home" />
            <a href="${home}">&Uuml;ritused</a>
        </li>
        <li class="<c:if test="${requestScope['javax.servlet.forward.request_uri'] eq '/events/new'}">active</c:if>">
            <c:url value="/events/new" var="newAd" />
            <a href="${newAd}">Lisa uus &uuml;ritus</a>
        </li>
    </ul>
</div>
<iframe class="fb-plugin" src="//www.facebook.com/plugins/likebox.php?href=https%3A%2F%2Fwww.facebook.com%2Fprogrammeerija&amp;width&amp;height=400&amp;colorscheme=light&amp;show_faces=true&amp;header=true&amp;stream=false&amp;show_border=true&amp;appId=1461170917493753" scrolling="no" frameborder="0" style="border:none; overflow:hidden; height:400px;" allowTransparency="true"></iframe>