<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title><g:layoutTitle default="MatLoggen"/></title>
    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="site.css"/>
    <asset:javascript src="jquery-2.2.0.min.js"/>
    <g:layoutHead/>
</head>

<body>

<div class="container">
    <div class="page-header">
        <div class="top_background">
            <img src="${resource(dir: 'img', file: 'logo_swe.jpg')}" alt="FoodLog">
        </div>
    </div>

    <div class="pull-right">
        <g:if test="${session.user != null}">
            ${session.user.kcalPerDay} kcal/dag&nbsp;
            <g:link controller="login" action="logout">Logga ut ${session.user.name}</g:link>
        </g:if>
    </div>

    <ul class="nav nav-tabs">
        <li id="nav_home"><g:link uri="/">Hem</g:link></li>
        <li id="nav_calendar"><g:link controller="calendar">Kalender</g:link></li>
        <li id="nav_foodlist"><g:link controller="foodlist">Livsmedelslista</g:link></li>
        <li><a href="http://www7.slv.se/SokNaringsinnehall" target="_blank">Livsmedelsdatabasen</a></li>
    </ul>
    <g:layoutBody/>
</div>
</body>
</html>