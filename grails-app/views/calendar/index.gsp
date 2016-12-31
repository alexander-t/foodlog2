<!DOCTYPE html>
<%@ page import="se.tarlinder.foodlog.util.CalendarViewHelper; se.tarlinder.foodlog.domain.Day; se.tarlinder.foodlog.util.TimeUtil" %>
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

    <g:each in="${0..34}" var="dayNumber">
    <%-- Start row --%>
        <g:if test="${dayNumber % 7 == 0}">
            <tr>
        </g:if>

    <%-- Highlight current day --%>
        <g:if test="${dayNumber < month.dates().size() && TimeUtil.isToday(month.dates()[dayNumber])}">
            <td class="calendar_cell" style="background: #B8EAFF">
        </g:if>
        <g:else>
            <td class="calendar_cell">
        </g:else>

    <%-- Print current day--%>
        <g:if test="${dayNumber < month.dates().size()}">
            <b>${dayNumber + 1}</b>
            <g:set var="currentDay" value="${month.dates()[dayNumber]}"/>
            <div style="height: 100%; bottom: 0;">
                <g:set var="day" value="${Day.findByDateAndUser(currentDay, session.user)}"/>
                <g:if test="${day != null}">
                    <g:set var="totals" value="${day.getTotals()}"/>
                    <div>Mat: ${totals.getTotalKcal(false)} kcal</div>
                    <g:progressBar progress="${totals.kcal}" max="${session.user.kcalPerDay}"></g:progressBar>
                    <div>Träning: ${totals.totalWorkoutKcal} kcal</div>
                    <g:progressBar progress="${totals.workoutKcal}" max="${session.user.kcalPerDay}"></g:progressBar>
                </g:if>
                <g:else>
                    <div>&nbsp;</div>
                </g:else>

                <div style="clear: both"></div>
                <g:link class="label label-success" controller="day"
                        params="[date: month.dates()[dayNumber]]">Mat</g:link>
                <g:link class="label label-info" controller="training"
                        params="[date: month.dates()[dayNumber]]">Träning</g:link>
                <%--<a class="label label-warning" href="#">Data</a>--%>
            </div>
            </td>
        </g:if>

    <%--End row --%>
        <g:if test="${(dayNumber + 1) % 7 == 0}">
            </tr>
        </g:if>
    </g:each>
    </tbody>
</table>
</body>
</html>