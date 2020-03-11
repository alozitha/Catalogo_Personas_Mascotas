<!DOCTYPE html>
<html>
<head>
    <asset:stylesheet src="show.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<div class="container register">
    <div class="row">
        <div class="col-md-3 register-left">
            <asset:image src="prrito.png"/>
            <h3>Pets</h3>
        </div>
        <div class="col-md-9 register-right">
            <div class="tab-content" >
                <div class="tab-pane fade show active" >
                    <h3 class="register-heading">Datos de la mascota ${pet?.name}</h3>
                    <g:form action="update" method="PUT" id="${pet?.id}">
                        <div class="row register-form">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Nombre:</label>
                                    <input type="text" class="form-control" name="name" value="${pet?.name}" />
                                </div>
                                <div class="form-group">
                                    <label>Fecha de nacimiento:</label>
                                    <input type="date" class="form-control" name="bithday"  value="${pet?.birthday?.format('yyyy-MM-dd')}" />
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label>Fecha de adopcion:</label>
                                    <input  class="form-control" type="date" name="adoption" value="${pet?.adoption?.format('yyyy-MM-dd')}" />
                                </div>
                                <div class="form-group">
                                    <label>Dueño:</label>
                                    <g:select class="form-control" optionKey = "id" optionValue ="fullName"
                                              name="person" from = "${personList}" value="${pet?.person?.id}"/>
                                </div>
                                <input type="submit" class="btnRegister"  value="Guardar"/>
                            </div>
                        </div>
                        <g:renderErrors bean = "${pet}"/>
                    </g:form>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
