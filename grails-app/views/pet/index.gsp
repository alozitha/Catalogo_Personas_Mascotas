<!DOCTYPE html>
<html>
<head>
    <style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
    </style>
</head>
<body>
<h2>Lista de Mascotas</h2>
<table>
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

<div>
    <br>
    <button><g:link action="create">Agregar nueva mascota</g:link></button>
</div>

<g:if test="${flash.message}">
    <div class="message" style="display: block">${flash.message}</div>
</g:if>

</body>
</html>