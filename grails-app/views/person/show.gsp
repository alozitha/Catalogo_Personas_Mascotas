<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <title>Show contact</title>
</head>
<body>
<div class="panel panel-primary p-4">
    <div class="card-header">
        <h3 class="card-title">Mostrar Persona</h3>
    </div>
    <div class="card-body">
        <h5 class="card-title text-muted text-uppercase ">Nombre</h5>
        <h6 class="card-price ">${person.name}</h6>
            <h5 class="card-title text-muted text-uppercase "> Apellidos:</h5>
            <h6 class="card-price ">
                <g:if test="${person.lastnameM!=null}">
                ${person.lastnameP} ${person.lastnameM}<br/>
                </g:if>
                <g:else>
                    ${person.lastnameP}<br/>
                </g:else>
            </h6>
        <h5 class="card-title text-muted text-uppercase ">Telefono</h5>
        <h6 class="card-price ">${person.phone}</h6>
        <h5 class="card-title text-muted text-uppercase ">Mascotas de la persona</h5>
        <h6 class="card-price ">
            <g:if test="${!petList}">
            Ninguna <br/>
            </g:if>
                <g:else>
                    <g:each var="pet" in="${petList}">
                        ${pet.name} <br/>
                    </g:each>
                </g:else>
        </h6>
        <button type="submit" class="btn btn-primary">Editar</button>
    </div>
</div>
</body>
</html>
