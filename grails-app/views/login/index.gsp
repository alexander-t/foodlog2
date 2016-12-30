<!DOCTYPE html>
<html lang="en">
<head>
    <title>Foodlog - Inloggning</title>
    <meta name="layout" content="foodlog">
    <script>
        $(document).ready(function () {
            $('#u').focus();
        });
    </script>
</head>

<body>

<div class="row top_spacing">
    <div class="span3">&nbsp;</div>

    <div class="span6">
        <div class="hero-unit">

            <g:form controller="login" action="login" class="form-inline">
                <div class="row">
                    <div><label for="u">Användarnamn</label></div>
                    <div><input type="text" name="u" id="u"></div>
                </div>

                <div class="row">
                    <div><label for="p">Lösenord</label></div>
                    <div><input type="password" name="p" id="p">&nbsp;
                        <button type="submit" class="btn btn-primary">Logga in</button></div>
                </div>
            </g:form>
        </div>
    </div>
    <div class="span3">&nbsp;</div>
</div>
</body>
</html>