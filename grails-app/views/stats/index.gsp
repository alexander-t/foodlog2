<!DOCTYPE html>
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
    <div class="col-md-3">
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
                <td>${stats.getKcalDiff()} (${stats.getKiloDiff()} kg)</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>