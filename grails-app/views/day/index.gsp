<!DOCTYPE html>
<%@ page import="se.tarlinder.foodlog.util.TimeUtil; se.tarlinder.foodlog.domain.Meal" contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>MatLoggen - Dag</title>
    <meta name="layout" content="foodlog"/>
    <asset:javascript src="jquery.tablesorter.min.js"/>
    <style>
    th.headerSortUp {
        background-image: url(${resource(dir: 'img', file: 'arrow_up.png')});
        background-repeat: no-repeat;
        background-position: center right;
    }

    th.headerSortDown {
        background-image: url(${resource(dir: 'img', file: 'arrow_down.png')});
        background-repeat: no-repeat;
        background-position: center right;
    }
    </style>

    <script>
        var updatePortionSize = function() {
            var pattern = /^.*\((\d+)g\)\s*$/;
            var match = pattern.exec($("select option:selected").text());
            if (match != null) {
                $("#portionSize").val(match[1]);
            } else {
                $("#portionSize").val("100");
            }
        };

        $(document).ready(function () {
            $("table").tablesorter();
            $("select").change(updatePortionSize);

            // Make sure the right default portion size is set when starting up
            updatePortionSize();
        });
    </script>

</head>

<body>
<h2>Kostdagbok <small>(${TimeUtil.prettyPrint(day.date)})</small></h2>

<g:form controller="day" action="add" class="form-inline">
    <g:hiddenField name="date" value="${day.date}"/>
    <div class="form-group">
        <label class="sr-only" for="foodId">Mat</label>
        <g:select class="form-control bottom10" id="foodId" name="foodId" from="${food}" optionKey="id"
                  optionValue="${{ it.getNameWithPortionSize() }}"/>
    </div>

    <div class="input-group bottom10">
        <input type="text" id="portionSize" name="portionSize" value="100" class="form-control" aria-describedby="gram-addon">
        <span class="input-group-addon" id="gram-addon">g</span>
    </div>

    <button type="submit" class="btn btn-primary bottom10">
        <span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span>Lägg till
    </button>

</g:form>

<table class="tablesorter table table-bordered table-striped">
    <thead>
    <tr>
        <th class="text-holder">Livsmedel</th>
        <th class="number-holder">portion (g)</th>
        <th class="number-holder">kcal</th>
        <th class="number-holder">protein</th>
        <th class="number-holder">kolhydrat</th>
        <th class="number-holder">fett</th>
        <th>&nbsp;</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${new TreeSet<Meal>(day.meals)}" var="meal">
        <tr>
            <td>${meal.food.name}</td>
            <td>${meal.portionInGrams}</td>
            <td>${String.format("%.1f", (meal.portionInGrams / 100 * meal.food.kcal))}</td>
            <td>${String.format("%.1f", (meal.portionInGrams / 100 * meal.food.protein))}</td>
            <td>${String.format("%.1f", (meal.portionInGrams / 100 * meal.food.carbohydrate))}</td>
            <td>${String.format("%.1f", (meal.portionInGrams / 100 * meal.food.fat))}</td>
            <td><g:link controller="day" action="delete" id="${meal.id}" params="[date: day.date]"><span class="glyphicon glyphicon-trash"></span></g:link></td>
        </tr>
    </g:each>
    </tbody>
    <tfoot>
    <tr>
        <g:set var="dayTotals" value="${day.getTotals()}"/>

        <td colspan="2"><b>Summa</b></td>
        <td><b>${dayTotals.totalKcal}</b></td>
        <td><b>${dayTotals.totalProtein}</b></td>
        <td><b>${dayTotals.totalCarbohydrate}</b></td>
        <td><b>${dayTotals.totalFat}</b></td>
        <td>&nbsp;</td>
    </tr>
    </tfoot>
</table>
</body>
</html>