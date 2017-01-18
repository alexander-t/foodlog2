<!DOCTYPE html>
<%@ page import="se.tarlinder.foodlog.util.TimeUtil" contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>MatLoggen - Statistik och Data</title>
    <meta name="layout" content="foodlog"/>
    <script>
        $(document).ready(function () {
            $('#nav_stats').addClass("active");
        });
    </script>
</head>

<body>
<h2>Statistik och Data</h2>

<div class="row">
    <div class="col-md-4">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Sammanfattning</h3>
            </div>

            <div class="panel-body">
                <h4>${stats.daysOnDiet} dagar på diet</h4>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Energi in/ut</th><th>kcal</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="danger">Mat</td><td class="danger">${stats.foodKcal}</td>
                    </tr>
                    <tr>
                        <td class="success">Energibalans</td><td class="success">${stats.energyBalanceKcal}</td>
                    </tr>
                    <tr>
                        <td class="success">Träning</td><td class="success">${stats.workoutKcal}</td>
                    </tr>
                    <tr><td colspan="2">&nbsp;</td></tr>
                    <tr>
                        <td><strong>Totalt</strong></td>
                        <td>${stats.getKcalDiff()}</td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>${stats.getKiloDiff()} kg</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Mätpunkter</h3>
            </div>

            <div class="panel-body">
                <table class="table">
                    <tbody>
                    <g:each in="${userDataPoints}" var="dataPoint">
                        <tr>
                            <td>${TimeUtil.prettyPrint(dataPoint.day.date)}</td>
                            <td>${dataPoint.value} ${dataPoint.dataPointType.unit}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="col-md-4">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Personliga data</h3>
            </div>

            <div class="panel-body">
                <h4>${session.user.name}</h4>
                <p><strong>Mål:</strong> ${session.user.kcalPerDay} kcal/dag</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>