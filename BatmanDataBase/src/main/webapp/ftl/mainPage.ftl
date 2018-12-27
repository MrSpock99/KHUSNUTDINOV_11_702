<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Resume - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/resume.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>

<body onload="getUserName()" id="page-top">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
    <a class="navbar-brand js-scroll-trigger" href="#page-top">
        <span class="d-block d-lg-none">Welcome</span>
        <span class="d-none d-lg-block">
          <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="img/bat_logo.png" alt="">
        </span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="#welcome">Welcome</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="#subjects">Subjects</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="#weapon_ammo">Weapons with ammunition</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="#armor">Armor</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="#transport">Transport</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="#expenses">Expenses</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid p-0">

    <section class="resume-section p-3 p-lg-5 d-flex d-column" id="welcome">
        <div class="my-auto">
            <h1 class="mb-0">Welcome,
                <span id="user_name" class="text-primary">Bruce Wayne</span>
            </h1>
        </div>
    </section>

</div>


<hr class="m-0">

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="subjects">

    <div class="my-auto">

        <h2 class="mb-5">Subjects</h2>

        <input class="form-control" id="subjects_input" type="text" placeholder="Search..">
        <br>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Alias</th>
                <th>Real name</th>
                <th>Weakness</th>
                <th>Defence</th>
                <th>Type</th>
            </tr>
            </thead>
            <tbody id="subjects_table">
            <#list subjectList as item>
            <tr data-id="${item.id}" data-alias="${item.alias}"
                data-real_name="${item.realName}" data-weakness="${item.weakness.name}"
                data-defence="${item.defence.name}"
                data-type="${item.type}" data-image="${(item.imageBase64)!"resources/images/placeholder.png"}"
                data-toggle="modal"
                data-target="#subjectInfoModal"
                class="clickable-row" style="cursor: pointer">
                <td>${item.id}</td>
                <td>${item.alias}</td>
                <td>${item.realName}</td>
                <td>${item.weakness.name}</td>
                <td>${item.defence.name}</td>
                <td>${item.type}</td>
            </tr>
            </#list>
            </tbody>
        </table>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#subjects_input").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#subjects_table tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>

        <button type="button" class="btn btn-dark float-right">Add</button>

    </div>


</section>

<hr class="m-0">

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="weapon_ammo">
    <div class="my-auto">
        <h2 class="mb-5">Weapons with ammunition</h2>

        <input class="form-control" id="weapon_ammo_input" type="text" placeholder="Search..">
        <br>
        <table class="table table-hover">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Ammunition</th>
            </tr>
            </thead>
            <tbody id="weapon_ammo_table">
            <#list weaponList as item>
            <tr data-id="${item.id}" data-ammo="${item.ammo.name}"
                data-image="${(item.imageBase64)!"resources/images/placeholder.png"}"
                data-name="${item.name}" data-amount="${item.amount}" data-toggle="modal"
                data-target="#weaponAmmoInfoModal"
                class='clickable-row' style="cursor: pointer">
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.ammo.name}</td>
            </tr>
            </#list>
            </tbody>
        </table>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#weapon_ammo_input").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#weapon_ammo_table tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>


        <button type="button" class="btn btn-dark float-right">Add</button>

    </div>
</section>

<hr class="m-0">

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="armor">
    <div class="my-auto">
        <h2 class="mb-5">Armor</h2>

        <input class="form-control" id="armor_input" type="text" placeholder="Search..">

        <table class="table table-hover">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Bulletproof</th>
                <th>Knife-proof</th>
                <th>Explosion-proof</th>
            </tr>
            </thead>
            <tbody id="armor_table">
             <#list equipmentList as item>
             <tr data-toggle="modal" data-id="${item.id}" data-name="${item.name}"
                 data-bullet="${item.bullet?then('Yes', 'No')}"
                 data-knife="${item.knife?then('Yes', 'No')}" data-explosion="${item.explosion?then('Yes', 'No')}"
                 data-amount="${item.amount}" data-target="#equipmentInfoModal" class='clickable-row'
                 data-image="${(item.imageBase64)!"img/placeholder.png"}"
                 style="cursor: pointer">
                 <td>${item.id}</td>
                 <td>${item.name}</td>
                 <td>${item.bullet?then('Yes', 'No')}</td>
                 <td>${item.knife?then('Yes', 'No')}</td>
                 <td>${item.explosion?then('Yes', 'No')}</td>
             </tr>
             </#list>
            </tbody>
        </table>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#armor_input").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#armor_table tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>
        <button type="button" class="btn btn-dark float-right">Add</button>
    </div>
</section>


<hr class="m-0">

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="transport">
    <div class="my-auto">
        <h2 class="mb-5">Transport</h2>

        <input class="form-control" id="transport_input" type="text" placeholder="Search..">

        <table class="table table-hover">

            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Water</th>
                <th>Air</th>
                <th>Ground</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="transport_table">
             <#list transportList as item>
             <tr onclick="showInfo('expense',${item.id})" data-toggle="modal" data-target="#infoModal"
                 style="cursor: pointer" class="clickableRow">
                 <td>${item.id}</td>
                 <td>${item.name}</td>
                 <td>${item.water?then('Yes', 'No')}</td>
                 <td>${item.air?then('Yes', 'No')}</td>
                 <td>${item.ground?then('Yes', 'No')}</td>
                 <td>
                     <button type="button" class="btn btn-danger">Delete</button>
                 </td>
             </tr>
             </#list>
            </tbody>
        </table>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#transport_input").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#transport_table tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>

        <button type="button" class="btn btn-dark float-right">Add</button>

        <hr class="m-0">

    </div>
</section>

<hr class="m-0">

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="expenses">
    <div class="my-auto">
        <h2 class="mb-5">Expenses</h2>

        <input class="form-control" id="expenses_input" type="text" placeholder="Search..">

        <table class="table table-hover">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Type</th>
                <th>Cost</th>
                <th>Amount</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="expenses_table">
            <#list expensesList as item>
            <tr onclick="showInfo('expense',${item.id})" data-toggle="modal" data-target="#infoModal"
                style="cursor: pointer" class="clickableRow">
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.type}</td>
                <td>${item.cost}</td>
                <td>${item.amount}</td>
                <td>
                    <button type="button" onclick="deleteEntity('expenses',${item.id})" class="btn btn-danger">Delete
                    </button>
                </td>
            </tr>
            </#list>
            </tbody>
        </table>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#expenses_input").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#expenses_table tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>

        <button type="button" class="btn btn-dark float-right">Add</button>

        <hr class="m-0">
        <div class="container">
            <div class="modal fade" id="subjectInfoModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title fa-pull-left">Dossier</h4>
                        </div>
                        <div class="modal-body">
                            <div class="span6 text-center fa-pull-right">
                                <div class="col-xs-2">
                                    <figure>
                                        <img id="subject_image"
                                             style="max-width: 60%; height: auto;">
                                        <figcaption>
                                            <button id="btn_delete_subject" type="button" class="btn btn-default">
                                                Delete
                                            </button>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                            <div class="text-center">
                                <p class="font-weight-bold h5" style="display:inline">Alias: </p>
                                <p id="alias" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Real name: </p>
                                <p id="real_name" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Weakness: </p>
                                <p id="weakness" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Defence: </p>
                                <p id="defence" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Type: </p>
                                <p id="type" style="display:inline"></p>
                                <br>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="equipmentInfoModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title fa-pull-left">Information</h4>
                        </div>
                        <div class="modal-body">
                            <div class="span6 text-center fa-pull-right">
                                <div class="col-xs-2">
                                    <figure>
                                        <img id="equipment_image"
                                             style="max-width: 60%; height: auto;">
                                        <figcaption>
                                            <button id="btn_delete_equipment" type="button" class="btn btn-default">
                                                Delete
                                            </button>
                                        </figcaption>
                                    </figure>
                                </div>
                            </div>
                            <div class="text-center">
                                <p class="font-weight-bold h5" style="display:inline">Name: </p>
                                <p id="name" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Bulletproof: </p>
                                <p id="bullet" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Knifeproof: </p>
                                <p id="knife" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Explosionproof: </p>
                                <p id="explosion" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Amount: </p>
                                <p id="amount" style="display:inline"></p>
                                <br>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="weaponAmmoInfoModal" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title fa-pull-left">Information</h4>
                            </div>
                            <div class="modal-body">
                                <div class="span6 text-center fa-pull-right">
                                    <div class="col-xs-2">
                                        <figure>
                                            <img id="weapon_ammo_image"
                                                 style="max-width: 60%; height: auto;" src="">
                                            <figcaption>
                                                <button id="btn_delete_weapon_ammo" type="button"
                                                        class="btn btn-default">Delete
                                                </button>
                                            </figcaption>
                                        </figure>
                                    </div>
                                </div>
                                <div class="text-center">
                                    <p class="font-weight-bold h5" style="display:inline">Name: </p>
                                    <p id="name" style="display:inline"></p>
                                    <br>
                                    <p class="font-weight-bold h5" style="display:inline">Ammo: </p>
                                    <p id="ammo" style="display:inline"></p>
                                    <br>
                                    <p class="font-weight-bold h5" style="display:inline">Amount: </p>
                                    <p id="amount" style="display:inline"></p>
                                    <br>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>

                    <script type="text/javascript">
                        $('#subjectInfoModal').on('show.bs.modal', function (e) {
                            $(this).find("#alias").text($(e.relatedTarget).data('alias'));
                            $(this).find("#real_name").text($(e.relatedTarget).data('real_name'));
                            $(this).find("#weakness").text($(e.relatedTarget).data('weakness'));
                            $(this).find("#defence").text($(e.relatedTarget).data('defence'));
                            $(this).find("#type").text($(e.relatedTarget).data('type'));

                            var image = new Image();
                            image.src = $(e.relatedTarget).data('image');
                            $("#subject_image").attr("src", image.src);

                            $("#btn_delete_subject").on("click", function (e1) {
                                deleteEntity("subject", $(e.relatedTarget).data('id'));
                            });
                        }).modal('show');
                    </script>
                    <script type="text/javascript">
                        $('#equipmentInfoModal').on('show.bs.modal', function (e) {
                            $(this).find("#name").text($(e.relatedTarget).data('name'));
                            $(this).find("#bullet").text($(e.relatedTarget).data('bullet'));
                            $(this).find("#knife").text($(e.relatedTarget).data('knife'));
                            $(this).find("#explosion").text($(e.relatedTarget).data('explosion'));
                            $(this).find("#amount").text($(e.relatedTarget).data('amount'));

                            var image = new Image();
                            image.src = $(e.relatedTarget).data('image');
                            $("#equipment_image").attr("src", image.src);

                            $("#btn_delete_equipment").on("click", function (e) {
                                deleteEntity("equipment", $(e.relatedTarget).data('id'));
                            });
                        }).modal('show');
                    </script>
                    <script type="text/javascript">
                        $('#weaponAmmoInfoModal').on('show.bs.modal', function (e) {
                            $(this).find("#name").text($(e.relatedTarget).data('name'));
                            $(this).find("#amount").text($(e.relatedTarget).data('amount'));
                            $(this).find("#ammo").text($(e.relatedTarget).data('ammo'));

                            var image = new Image();
                            //выдает ошибку 404, хз как поправить
                            image.src = $(e.relatedTarget).data('image');
                            $("#weapon_ammo_image").attr("src", image.src);

                            $("#btn_delete_weapon_ammo").on("click", function (e1) {
                                deleteEntity("weapon", $(e.relatedTarget).data('id'));
                            });
                        }).modal('show');
                    </script>
                </div>

</section>
<!-- Bootstrap core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/resume.min.js"></script>

<script>
    function getUserName() {
        $.ajax({
            url: "/mainPage.json",
            type: "GET",
            data_type: "json"
        })
                .done(function (data) {
                    console.log(data);
                    $("#user_name").text(data); // setting text
                }).fail(function (jqXHR, exception) {
            var msg = '';
            if (jqXHR.status === 0) {
                msg = 'Not connect.\n Verify Network.';
            } else if (jqXHR.status == 404) {
                msg = 'Requested page not found. [404]';
            } else if (jqXHR.status == 500) {
                msg = 'Internal Server Error [500].';
            } else if (exception === 'parsererror') {
                msg = 'Requested JSON parse failed.';
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                msg = 'Uncaught Error.\n' + jqXHR.responseText;
            }
            alert(msg);
        });
    }

    function deleteEntity(table_name, entity_id) {
        $.ajax({
            url: "/mainPage",
            type: "POST",
            data: {
                entity_id: entity_id,
                table_name: table_name,
                action: "delete"
            }
        }).done(function (data) {
            console.log("HAHAHA DELETE");
            $("#user_name").text(data); // setting text
        }).fail(function (jqXHR, exception) {
            var msg = '';
            if (jqXHR.status === 0) {
                msg = 'Not connect.\n Verify Network.';
            } else if (jqXHR.status == 404) {
                msg = 'Requested page not found. [404]';
            } else if (jqXHR.status == 500) {
                msg = 'Internal Server Error [500].';
            } else if (exception === 'parsererror') {
                msg = 'Requested JSON parse failed.';
            } else if (exception === 'timeout') {
                msg = 'Time out error.';
            } else if (exception === 'abort') {
                msg = 'Ajax request aborted.';
            } else {
                msg = 'Uncaught Error.\n' + jqXHR.responseText;
            }
            alert(msg);
        });
    }


</script>
<script>

</script>

</body>

</html>
