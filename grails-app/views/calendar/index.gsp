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
                </g:if>
                <g:else>
                    <g:set var="totals" value="${new se.tarlinder.foodlog.model.DayTotals()}"/>
                </g:else>

                <fl:progressBar progress="${totals.getNetKcal()}" max="${session.user.kcalPerDay}"/>
                <div class="text-center">
                    <g:if test="${!totals.isEmpty()}">
                        <p class="h3">${totals.getNetKcal()} kcal</p>
                        <g:link class=" label label-success" controller="day"
                                params="[date: month.dates()[dayNumber]]">Mat (${totals.getTotalKcal(false)})</g:link>
                        <g:link class="label label-info" controller="training"
                                params="[date: month.dates()[dayNumber]]">Träning (${totals.totalWorkoutKcal})</g:link>
                    </g:if>
                    <g:else>
                        <p class="h3">&nbsp;</p>
                        <g:link class=" label label-success" controller="day"
                                params="[date: month.dates()[dayNumber]]">Mat</g:link>
                        <g:link class="label label-info" controller="training"
                                params="[date: month.dates()[dayNumber]]">Träning</g:link>
                    </g:else>
                    <%--<g:link class="label label-warning" controller="data">Data</g:link>--%>
                </div>
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