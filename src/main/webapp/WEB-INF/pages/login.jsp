<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<%@page session="true"%>
<tiles:insertDefinition name="baseLayout">
    <tiles:putAttribute name="content">


      <c:if test="${not empty error}">
      			<div class="error">${error}</div>
      		</c:if>
      		<c:if test="${not empty msg}">
      			<div class="msg">${msg}</div>
      		</c:if>

        <form name='loginForm'
        		  c:action="@{/login}" method='POST'>
            <div><label> User Name : <input type="text" name="username"/> </label></div>
            <div><label> Password: <input type="password" name="password"/> </label></div>
            <div><input type="submit" value="Sign In"/></div>
            <input type="hidden" name="${_csrf.parameterName}"
            			value="${_csrf.token}" />
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>