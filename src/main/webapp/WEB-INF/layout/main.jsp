<!DOCTYPE HTML>
<%@ include file="/WEB-INF/layout/taglibs.jsp"%>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap-theme.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/style/main.css'/>"/>
    <link rel="shortcut icon" type="image/x-icon" href="<c:url value='/resources/seo/favicon.ico'/>" />
    <meta charset="utf-8">
    <meta name="description" content="<tiles:insertAttribute name="page_description" ignore="true"/>">
    <meta property="og:image" content="<tiles:insertAttribute name="og_image" ignore="true"/>" />
    <meta property="og:title" content="<tiles:insertAttribute name="og_title" ignore="true"/>" />
    <meta property="og:description" content="<tiles:insertAttribute name="og_desc" ignore="true"/>"/>
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
</head>
<body role="document">
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
            (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
                m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
        ga('create', 'UA-20618536-8', 'auto');
        ga('send', 'pageview');
    </script>
    <div id="fb-root"></div>
    <script>(function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&appId=160976784019268&version=v2.0";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));</script>
    <tiles:insertAttribute name="header" />
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <tiles:insertAttribute name="content" />
            </div>
            <div class="col-sm-3 col-sm-offset-1">
                <tiles:insertAttribute name="menu" />
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer" />
</body>
</html>