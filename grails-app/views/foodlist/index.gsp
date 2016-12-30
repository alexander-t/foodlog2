<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="layout" content="foodlog"/>
    <title>MatLoggen - Livsmedelslista</title>
    <asset:javascript src="jquery.tablesorter.min.js"/>

    <style>
    th.headerSortUp {
        background-image: url(${resource(dir: 'img', file: 'arrow_up.png')});
        background-repeat: no-repeat;
        background-origin: content;
        background-position: center right;
    }

    th.headerSortDown {
        background-image: url(${resource(dir: 'img', file: 'arrow_down.png')});
        background-repeat: no-repeat;
        background-origin: content;
        background-position: center right;
    }
    </style>

    <script>
        $(document).ready(function () {
            $('#nav_foodlist').addClass("active");
            $("#foodtable").tablesorter();
        });
    </script>
</head>

<body>

<h2>Livsmedelslista</h2>

<g:if test="${session?.user?.admin}">
    <div class="well">
        <g:form controller="foodlist" id="addFoodForm" action="add" class="form-inline">
            <fieldset>
                <input type="text" name="foodName" id="foodName" class="input-medium" placeholder="Livsmedel" required/>
                <input type="text" name="brand" id="brand" class="input-small" placeholder="Tillverkare"/>
                <input type="text" name="kcal" class="input-small" placeholder="kcal" required/>
                <input type="text" name="protein" class="input-small" placeholder="Protein" required/>
                <input type="text" name="carbohydrate" class="input-small" placeholder="Kolhydrat" required/>
                <input type="text" name="fat" class="input-small" placeholder="Fett" required/>
                <input type="text" name="packSizeInGrams" class="input-small" placeholder="Portion"/>
                <button type="submit" class="btn btn-primary">Lägg till&nbsp;<i class="icon-arrow-down icon-white"></i></button>
            </fieldset>
        </g:form>
    </div>
</g:if>

<table id="foodtable" class="tablesorter table table-bordered table-striped">
    <thead>
    <tr>
        <th>Livsmedel</th>
        <th class="number-holder">kcal</th>
        <th class="number-holder">Protein</th>
        <th class="number-holder">Kolhydrat</th>
        <th class="number-holder">Fett</th>
        <th>Portion</th></tr>
    </thead>
    <tbody>
    <g:each in="${food}" var="f">
        <tr>
            <td>${f.name + " " + f.brandOrEmptyString}</td>
            <td>${f.kcal}</td>
            <td>${f.protein}</td>
            <td>${f.carbohydrate}</td>
            <td>${f.fat}</td>
            <td>${f.packSizeInGrams}</td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>