<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
    <h2 class="align-baseline">Lista de Personas</h2>
<div class="border-left p-4">
    <table class="table table-sm table-dark">
        <tr>
            <th  scope="col">Nombre</th>
            <th  scope="col">Apellidos</th>
            <th  scope="col">Telefono</th>
            <th  scope="col">Direccion</th>
            <th  scope="col">Num mascotas</th>
        </tr>
        <g:each var="person" in="${personList}">
            <tr>
                <td><g:link action="show" id="${person.id}">${person.name}</g:link><br/></td>
                <g:if  test="${person.lastnameM !=null}">
                    <td>${person.lastnameP} ${person.lastnameM}.</td>
                </g:if>
                <g:else>
                    <td>${person.lastnameP}</td>
                </g:else>
                <td>${person.phone}</td>
                <td>${person.address}</td>
                <td>${person.petCount}</td>
            </tr>
        </g:each>

    </table>
</div>

    <div class="p-4">
        <br>
        <button><g:link action="create">Agregar nueva persona</g:link></button>
    </div>

    <g:if test="${flash.message}">
        <div class="message" style="display: block">${flash.message}</div>
    </g:if>

</body>
</html>