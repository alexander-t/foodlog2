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
<h4>Energi in</h4>
<p>Mat: ${foodKcal}</p>
<h4>Energi ut</h4>
<p>Energibalans: ${energyBalanceKcal}</p>
<p>Träning: ${workoutKcal}</p>
<h4>Totalt</h4>
<p>${foodKcal - energyBalanceKcal - workoutKcal}</p>
</body>

</html>