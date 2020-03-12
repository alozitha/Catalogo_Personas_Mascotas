<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="header" />
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
