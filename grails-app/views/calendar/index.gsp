<!DOCTYPE html>
<%@ page import="se.tarlinder.foodlog.domain.Day; se.tarlinder.foodlog.util.TimeUtil" %>
<html lang="en">
<head>
    <title>MatLoggen - Kalender</title>
    <meta name="layout" content="foodlog"/>
    <script>
        $(document).ready(function () {
            $('#nav_calendar').addClass("active");
        });
    </script>
</head>

<body>

<h2>${month.name()}</h2>
<table class="table table-bordered">
    <tbody>
    <g:set var="dayIndex" value="${0}"/>
    <g:each var="date" in="${month.dates()}">
    <%-- Start row --%>
        <g:if test="${dayIndex % 7 == 0}">
            <tr>
        </g:if>

    <%-- Highlight current dayIndex --%>
        <td class="calendar_cell ${date == today ? 'today' : ''}">
            <p>${TimeUtil.prettyPrint(date)}</p>
            <g:set var="currentDay" value="${month.dates()[dayIndex]}"/>
            <div style="height: 100%; bottom: 0;">
                <g:set var="day" value="${Day.findByDateAndUser(currentDay, session.user)}"/>
                <g:if test="${day != null}">
                    <g:set var="totals" value="${day.getTotals()}"/>
                </g:if>
                <g:else>
                    <g:set var="totals" value="${new se.tarlinder.foodlog.model.DayTotals()}"/>
                </g:else>

                <fl:progressBar progress="${totals.getNetKcal()}" max="${session.user.kcalPerDay}"/>
                <div class="text-center">
                    <g:if test="${!totals.isEmpty()}">
                        <p class="h4">${totals.getNetKcal()} kcal</p>
                        <g:link class=" label label-success" controller="day"
                                params="[date: month.dates()[dayIndex]]">Mat (${totals.getTotalKcal(false)})</g:link>
                        <g:link class="label label-info" controller="training"
                                params="[date: month.dates()[dayIndex]]">Träning (${totals.totalWorkoutKcal})</g:link>
                    </g:if>
                    <g:else>
                        <p class="h4">&nbsp;</p>
                        <g:link class=" label label-success" controller="day"
                                params="[date: month.dates()[dayIndex]]">Mat</g:link>
                        <g:link class="label label-info" controller="training"
                                params="[date: month.dates()[dayIndex]]">Träning</g:link>
                    </g:else>
                <g:link class="label label-warning" controller="datapoint"
                        params="[date: month.dates()[dayIndex]]">Data</g:link>
                </div>
            </div>

        </td>

    <%-- End row --%>
        <g:if test="${++dayIndex % 7 == 0}">
            <tr>
        </g:if>
    </g:each>
    </tbody>
</table>
</body>
</html>