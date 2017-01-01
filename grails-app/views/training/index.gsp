<!DOCTYPE html>
<%@ page import="se.tarlinder.foodlog.util.TimeUtil" contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>MatLoggen - Träning</title>
    <meta name="layout" content="foodlog"/>
    <script>

        var updateTrainingCalories = function() {
            var pattern = /^.*\((\d+)kcal\)\s*$/;
            var match = pattern.exec($("select option:selected").text());
            if (match != null) {
                $("#usedKcal").val(match[1]);
            }
        };

        $(document).ready(function () {
            $("select").change(updateTrainingCalories);

            // Make sure the right calories are set when starting up
            updateTrainingCalories();
        });
    </script>
</head>

<body>
<h2>Träning (${TimeUtil.prettyPrint(date)})</h2>
<g:form controller="training" action="add" class="form-inline">
    <g:select name="workoutTypeId" from="${workoutTypes}" optionKey="id"
              optionValue="${{it.name + " (" + it.averageKcal + "kcal)"}}"></g:select>
    <g:hiddenField name="date" value="${date}"></g:hiddenField>
    <input type="text" id="usedKcal" name="usedKcal" maxlength="4" style="width: 100px" value="">
    <input type="submit" value="Lägg till" class="btn btn-primary">
</g:form>

<table class="table table-bordered">
    <thead>
    <tr>
        <th>Aktivitet</th>
        <th>Energiförbrukning (kcal)</th>
    </tr>
    </thead>
    <tbody>
    <g:each in="${day.workouts}" var="workout">
        <tr>
            <td>${workout.workoutType.name}</td>
            <td>${workout.usedKcal}</td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>