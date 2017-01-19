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
<div class="container">
    <div class="row" style="padding-top: 2em;">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Login</h3>
                </div>

                <div class="panel panel-body">
                    <g:form controller="login" action="login">
                        <g:hiddenField name="dest" value="${params.dest}"/>
                        <div class="form-group">
                            <label for="u">Användarnamn</label>
                            <input type="text" name="u" id="u" class="form-control">
                        </div>

                        <div class="form-group">
                            <label for="p">Lösenord</label>
                            <input type="password" name="p" id="p" class="form-control">
                        </div>

                        <div class="pull-right">
                            <button type="submit" class="btn btn-primary">Logga in</button>
                        </div>
                    </g:form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>