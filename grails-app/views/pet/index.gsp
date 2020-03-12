<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="header" />
    </head>

<body>
<g:if test="${flash.message}">
    <div class="message" style="display: block">${flash.message}</div>
</g:if>
<div class="container">
    <div class="row col-md-6 col-md-offset-2">
        <h1 class="p-4">Lista de mascotas</h1>
        <a href="create" class="btn btn-dark"><b>+</b> Añadir nueva mascota</a>
    </div>

    <div class="row col-md-12 register register-right">
        <table class="table">
            <thead>
            <tr class="table-light">
                <th>Nombre</th>
                <th>Cumpleaños</th>
                <th>Adopcion</th>
                <th>Dueño</th>
                <th class="text-center">Action</th>
            </tr>
            </thead>
            <g:each var="pet" in="${petList}">
                <tr class="table-light">
                    <td>${pet?.name}</td>
                    <td><g:formatDate format="yyyy-MM-dd" date="${pet?.birthday}"/></td>
                    <td><g:formatDate format="yyyy-MM-dd" date="${pet?.adoption}"/></td>
                    <td>${pet?.person?.name} ${pet?.person?.lastnameP} ${pet?.person?.lastnameM}</td>
                    <td class="text-center"><a class='btn btn-info btn-xs' href="edit/${pet?.id}">Editar</a>
                        <a href="show/${pet?.id}" class="btn btn-success btn-xs">Ver</a></td>
                </tr>
            </g:each>
        </table>
    </div>
</div>
</body>
</html>