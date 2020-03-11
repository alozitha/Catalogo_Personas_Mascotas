<!DOCTYPE html>
<html>
<body>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>


<div class="container">

    <h5 class="card-header info-color white-text text-center p-4">
        <strong>Nuevo contacto persona</strong>
    </h5>

    <!--Card content-->
    <div class="card-body px-lg-5 pt-1">

        <!-- Form -->

        <g:form action="save" method="POST" class="text-center" style="color: #757575;">
            <div class="form-group">
                <label >Nombre:</label>
                <g:field class="form-control" type="text" name="name" min="10"  value="${person?.name}"/><br/>
            </div>
            <div class="form-group">
                <label>Apellido Paterno:</label>
                <g:field class="form-control" type="text" name="lastnameP" value="${person?.lastnameP}"/><br/>
            </div>
            <div class="form-group">
                <label>Apellido Materno:</label>
                <g:field class="form-control" type="text"  name="lastnameM" value="${person?.lastnameM}"/><br/>
            </div>
            <div class="form-group">
                <label> Direccion:</label>
                <g:field class="form-control" type="text"  name="address"  value="${person?.address}"/><br/>
            </div>
            <div class="form-group">
                <label>Telefono:</label>
                <g:field class="form-control" type="text"  name="phone" min="10"  value="${person?.phone}"/><br/>
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
            <g:renderErrors bean = "${person}"/>
        </g:form>
        <!-- Form -->

    </div>

</div>
<!-- Material form login -->
</body>
</html>