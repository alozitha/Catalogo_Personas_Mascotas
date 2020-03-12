<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="header" />
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