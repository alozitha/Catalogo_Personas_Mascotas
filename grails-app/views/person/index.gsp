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
    <h2>Lista de Personas</h2>
    <table>
        <tr>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Telefono</th>
            <th>Direccion</th>
        </tr>
        <g:each var="person" in="${personList}">
            <tr>
                <td>${person.name}</td>
                <g:if  test="${person.lastnameM !=null}">
                    <td>${person.lastnameP} ${person.lastnameP}.</td>
                </g:if>
            <g:else>
                <td>${person.lastnameP}</td>
           </g:else>
                <td>${person.phone}</td>
                <td>${person.address}</td>
            </tr>
        </g:each>
    </table>

    <div>
        <br>
        <button><g:link class="create" action="create">Agregar nueva persona</g:link></button>
    </div>

</body>
</html>