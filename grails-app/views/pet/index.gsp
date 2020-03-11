<!DOCTYPE html>
<html>
<head>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    </head>
</head>
<body>
<h2>Lista de Mascotas</h2>
<div class="border-left p-4">
    <table class="table table-bordered table-dark">
        <tr>
            <th>Nombre</th>
            <th>Cumpleaños</th>
            <th>Fecha_adopcion</th>
            <th>Dueño</th>
        </tr>
        <g:each var="pet" in="${petList}">
            <tr>
                <td><g:link action="show" id="${pet?.id}">${pet?.name}</g:link><br/></td>
                <td><g:formatDate format="yyyy-MM-dd" date="${pet?.birthday}"/></td>
                <td><g:formatDate format="yyyy-MM-dd" date="${pet?.adoption}"/></td>
                <td>${pet?.person?.name} ${pet?.person?.lastnameP} ${pet?.person?.lastnameM}</td>
            </tr>
        </g:each>
    </table>

</div>


<div class="p-4">
    <br>
    <button><g:link action="create">Agregar nueva mascota</g:link></button>
</div>

<g:if test="${flash.message}">
    <div class="message" style="display: block">${flash.message}</div>
</g:if>

</body>
</html>