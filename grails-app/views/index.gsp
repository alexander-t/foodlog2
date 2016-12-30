<!DOCTYPE html>
<html lang="en">
<head>
    <title>MatLoggen</title>
    <meta name="layout" content="foodlog">
    <script>
        $(document).ready(function () {
            $('#nav_home').addClass("active");
        });
    </script>
</head>

<body>
<div>
    <div style="text-align: center; ">
        <g:link controller="Calendar"><g:img dir="img" file="calendar.jpg" alt="Kalender" width="200"/></g:link>
        <g:link controller="Foodlist"><g:img dir="img" file="pie-chart.jpg" alt="Livsmedelslista" width="200"/></g:link>
    </div>
</div>
</body>
</html>