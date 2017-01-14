<!DOCTYPE html>
<%@ page import="se.tarlinder.foodlog.util.TimeUtil" contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>MatLoggen - Personliga Data</title>
    <meta name="layout" content="foodlog"/>
</head>

<body>
<h2>Personliga data</h2>
<g:form controller="datapoint" action="add" class="form-inline">
    <g:hiddenField name="date" value="${date}"/>

    <g:select name="dataPointTypeId" class="form-control bottom10" from="${dataPointTypes}" optionKey="id"
              optionValue="${{ it.name }}"></g:select>

    <div class="input-group bottom10">
        <input type="text" id="value" name="value" class="form-control">
    </div>

    <button type="submit" class="btn btn-primary bottom10">
        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Lägg till
    </button>
</g:form>

<div class="row">
    <div class="col-md-3">
        <table class="table">
            <tbody>
            <g:each in="${day.dataPoints}" var="dataPoint">
                <tr>
                    <td>${dataPoint.dataPointType.name}</td>
                    <td>${dataPoint.value}</td>
                    <td>${dataPoint.dataPointType.unit}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>