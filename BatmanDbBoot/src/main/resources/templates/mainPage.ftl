<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Resume - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <#--
        <link href="/css/bootstrap.min.css" type="text/css" rel="stylesheet">
    -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
    <link href="http://localhost:8080/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://localhost:8080/css/custom_bootstrap.css" type="text/css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>

<body id="page-top">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
    <a class="navbar-brand js-scroll-trigger" href="#page-top">
        <span class="d-block d-lg-none">Welcome</span>
        <span class="d-none d-lg-block">
          <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="http://localhost:8080/img/bat_logo.png" alt="">
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
                <span id="user_name" class="text-primary">${userName}</span>
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
        <table id="subjects_table_head" class="table table-hover">
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
                    data-real_name="${item.realName}" data-weakness="${(item.weakness.name)!""}"
                    data-defence="${(item.defence.name)!""}"
                    data-type="${item.type}" data-image="${(item.imageBase64)!"img/placeholder.png"}"
                    data-toggle="modal"
                    data-target="#subjectInfoModal"
                    class="clickable-row" style="cursor: pointer">
                    <td>${item.id}</td>
                    <td>${item.alias}</td>
                    <td>${item.realName}</td>
                    <td>${(item.weakness.name)!""}</td>
                    <td>${(item.defence.name)!""}</td>
                    <td>${item.type}</td>
                </tr>/
            </#list>
            </tbody>
        </table>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#subjects_input").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    search(value);
                });
            });
        </script>

        <button type="button" class="btn btn-dark float-right" data-toggle="modal" data-target="#insertSubjectModal">
            Add
        </button>
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
                <tr data-id="${item.id}" data-ammo="${(item.ammo.name)!""}"
                    data-image="${(item.imageBase64)!"img/placeholder.png"}"
                    data-name="${item.name}" data-amount="${item.weapon.amount}" data-toggle="modal"
                    data-target="#weaponAmmoInfoModal"
                    class='clickable-row' style="cursor: pointer">
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${(item.ammo.name)!""}</td>
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

        <button type="button" class="btn btn-dark float-right" data-toggle="modal" data-target="#insertWeaponAmmoModal">
            Add
        </button>
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
        <button type="button" data-toggle="modal" data-target="#insertEquipmentModal" class="btn btn-dark float-right">
            Add
        </button>
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
                <tr data-toggle="modal" data-id="${item.id}" data-name="${item.name}"
                    data-air="${item.air?then('Yes', 'No')}"
                    data-water="${item.water?then('Yes', 'No')}" data-ground="${item.ground?then('Yes', 'No')}"
                    data-amount="${(item.amount)!"0"}" data-target="#transportInfoModal" class='clickable-row'
                    data-image="${(item.imageBase64)!"img/placeholder.png"}"
                    style="cursor: pointer">
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.water?then('Yes', 'No')}</td>
                    <td>${item.air?then('Yes', 'No')}</td>
                    <td>${item.ground?then('Yes', 'No')}</td>
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

        <button type="button" data-toggle="modal" data-target="#insertTransportModal" class="btn btn-dark float-right">
            Add
        </button>

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
                <tr data-toggle="modal" data-target="#expenseInfoModal" data-id="${item.id}"
                    data-name="${item.name}" data-type="${item.type}" data-cost="${item.cost}"
                    data-amount="${item.amount}" data-budget="${item.budget}"
                    style="cursor: pointer" class="clickableRow">
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.type}</td>
                    <td>${item.cost}</td>
                    <td>${item.amount}</td>
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
            </div>

            <div class="modal fade" id="transportInfoModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title fa-pull-left">Information</h4>
                        </div>
                        <div class="modal-body">
                            <div class="span6 text-center fa-pull-right">
                                <div class="col-xs-2">
                                    <figure>
                                        <img id="transport_image"
                                             style="max-width: 60%; height: auto;" src="">
                                        <figcaption>
                                            <button id="btn_delete_transport" type="button"
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
                                <p class="font-weight-bold h5" style="display:inline">Water: </p>
                                <p id="water" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Air: </p>
                                <p id="air" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Ground: </p>
                                <p id="ground" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Amount: </p>
                                <p id="amount" style="display:inline"></p>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
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

                        $("#btn_delete_equipment").on("click", function (e1) {
                            console.log($(e.relatedTarget).data('id'));
                            deleteEntity("equipment", $(e.relatedTarget).data('id'));
                        });
                    }).modal('show');
                </script>

                <script type="text/javascript">
                    $('#weaponAmmoInfoModal').on('show.bs.modal', function (e) {
                        $(this).find("#name").text($(e.relatedTarget).data('name'));
                        $(this).find("#amount").text($(e.relatedTarget).data('amount'));
                        $(this).find("#ammo").text($(e.relatedTarget).data('ammo'));
                        console.log("WEAPON CLICK");

                        var image = new Image();
                        image.src = $(e.relatedTarget).data('image');
                        $("#weapon_ammo_image").attr("src", image.src);

                        $("#btn_delete_weapon_ammo").on("click", function (e1) {
                            deleteEntity("weapon", $(e.relatedTarget).data('id'));
                        });
                    }).modal('show');
                </script>

                <script type="text/javascript">
                    $('#transportInfoModal').on('show.bs.modal', function (e) {
                        $(this).find("#name").text($(e.relatedTarget).data('name'));
                        $(this).find("#amount").text($(e.relatedTarget).data('amount'));
                        $(this).find("#air").text($(e.relatedTarget).data('air'));
                        $(this).find("#water").text($(e.relatedTarget).data('water'));
                        $(this).find("#ground").text($(e.relatedTarget).data('ground'));

                        var image = new Image();
                        console.log("TRANS CLICK");
                        image.src = $(e.relatedTarget).data('image');
                        $("#expense_image").attr("src", image.src);

                        $("#btn_delete_transport").on("click", function (e1) {
                            deleteEntity("transport", $(e.relatedTarget).data('id'));
                        });
                    }).modal('show');
                </script>

                <script type="text/javascript">
                    $('#expenseInfoModal').on('show.bs.modal', function (e) {
                        $(this).find("#name").text($(e.relatedTarget).data('name'));
                        $(this).find("#type").text($(e.relatedTarget).data('type'));
                        $(this).find("#cost").text($(e.relatedTarget).data('cost'));
                        $(this).find("#amount").text($(e.relatedTarget).data('фьщгте'));
                        $(this).find("#budget").text($(e.relatedTarget).data('budget'));

                        var image = new Image();
                        console.log("TRANS CLICK");
                        image.src = $(e.relatedTarget).data('image');
                        $("#expense_image").attr("src", image.src);

                        $("#btn_delete_transport").on("click", function (e1) {
                            deleteEntity("expense", $(e.relatedTarget).data('id'));
                        });
                    }).modal('show');
                </script>
            </div>

            <div class="modal fade" id="expenseInfoModal" role="dialog">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title fa-pull-left">Information</h4>
                        </div>
                        <div class="modal-body">
                            <div class="span6 text-center fa-pull-right">
                                <div class="col-xs-2">
                                    <figure>
                                        <img id="transport_image"
                                             style="max-width: 60%; height: auto;" src="">
                                        <figcaption>
                                            <button id="btn_delete_expense" type="button"
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
                                <p class="font-weight-bold h5" style="display:inline">Type: </p>
                                <p id="type" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Cost: </p>
                                <p id="cost" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Amount: </p>
                                <p id="amount" style="display:inline"></p>
                                <br>
                                <p class="font-weight-bold h5" style="display:inline">Budget: </p>
                                <p id="budget" style="display:inline"></p>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="modal fade" id="insertSubjectModal" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">New subject</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Alias:</label>
                                    <input type="text" class="form-control" id="modal_alias">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Real name:</label>
                                    <input type="text" class="form-control" id="modal_real_name">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Weakness:</label>
                                    <input type="text" class="form-control" id="modal_weakness">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Defence:</label>
                                    <input type="text" class="form-control" id="modal_defence">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Type:</label>
                                    <input type="text" class="form-control" id="modal_type">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" id="btn_add" class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript">
                $('#insertSubjectModal').on('show.bs.modal', function (e) {
                    $("#btn_add").on("click", function (e1) {
                        var subject = [
                            $('#modal_alias').val(),
                            $('#modal_real_name').val(),
                            $('#modal_weakness').val(),
                            $('#modal_defence').val(),
                            $('#modal_type').val()
                        ];
                        console.log(subject);
                        addEntity("subject", subject);
                    });
                }).modal('show');
            </script>

            <div class="modal fade" id="insertWeaponAmmoModal" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">New weapon</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Name:</label>
                                    <input type="text" class="form-control" id="modal_weapon_name">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Weapon:</label>
                                    <input type="text" class="form-control" id="modal_weapon">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Ammo:</label>
                                    <input type="text" class="form-control" id="modal_ammo">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" id="btn_add_weapon" class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="insertEquipmentModal" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">New equipment</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Name:</label>
                                    <input type="text" class="form-control" id="modal_equipment_name">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Bulletproof:</label>
                                    <input type="text" class="form-control" id="modal_bullet">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Knifeproof:</label>
                                    <input type="text" class="form-control" id="modal_knife">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Explosionproof:</label>
                                    <input type="text" class="form-control" id="modal_explosion">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" id="btn_add_equipment" class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                $('#insertEquipmentModal').on('show.bs.modal', function (e) {
                    $("#btn_add_equipment").on("click", function (e1) {
                        var equipment = [
                            $('#modal_equipment_name').val(),
                            $('#modal_bullet').val(),
                            $('#modal_knife').val(),
                            $('#modal_explosion').val()
                        ];
                        console.log(equipment);
                        addEntity("equipment", equipment);
                    });
                }).modal('show');
            </script>

            <div class="modal fade" id="insertTransportModal" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">New transport</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="recipient-name" class="col-form-label">Name:</label>
                                    <input type="text" class="form-control" id="modal_transport_name">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Water:</label>
                                    <input type="text" class="form-control" id="modal_water">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Air:</label>
                                    <input type="text" class="form-control" id="modal_air">
                                </div>
                                <div class="form-group">
                                    <label for="message-text" class="col-form-label">Ground:</label>
                                    <input type="text" class="form-control" id="modal_ground">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" id="btn_add_transport" class="btn btn-primary">Add</button>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                $('#insertTransportModal').on('show.bs.modal', function (e) {
                    $("#btn_add_transport").on("click", function (e1) {
                        var transport = [
                            $('#modal_transport_name').val(),
                            $('#modal_water').val(),
                            $('#modal_air').val(),
                            $('#modal_ground').val()
                        ];
                        console.log(transport);
                        addEntity("transport", transport);
                    });
                }).modal('show');
            </script>

</section>
<!-- Bootstrap core JavaScript -->
<script src="http://localhost:8080/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="http://localhost:8080/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="http://localhost:8080/js/resume.js"></script>

<script type="text/javascript">
    function search(query) {
        $.ajax({
            type: 'GET',
            url: '/mainPage/search',
            data: {
                q: query
            }
        }).done(function (data) {
            if (data) {
                var tableHtml = "";
                tableHtml += '<table class="table table-hover">\n' +
                    '            <thead>\n' +
                    '            <tr>\n' +
                    '                <th>#</th>\n' +
                    '                <th>Alias</th>\n' +
                    '                <th>Real name</th>\n' +
                    '                <th>Weakness</th>\n' +
                    '                <th>Defence</th>\n' +
                    '                <th>Type</th>\n' +
                    '            </tr>\n' +
                    '            </thead>';
                for (var i = 0; i < data.length; i++) {
                    tableHtml += '<tbody id="subjects_table">';
                    tableHtml += '<tr>' +
                        '<td>' + data[i].id + '</td>' +
                        '<td>' + data[i].alias + '</td>' +
                        '<td>' + data[i].realName + '</td>' +
                        '<td>' + data[i].weakness.name + '</td>' +
                        '<td>' + data[i].defence.name + '</td>' +
                        '<td>' + data[i].type + '</td>' +
                        '</tr>';
                    tableHtml += '</tbody>';
                }
                tableHtml += '</table>';
                $('#subjects_table_head').html(tableHtml);
            }
        });
    }

    function deleteEntity(table_name, entity_id) {
        let entity = {
            "entity_id": entity_id,
            "table_name": table_name,
            "action": "delete"
        };
        $.ajax({
            url: "/mainPage/json",
            type: "POST",
            contentType: "application/json; charset=utf-8",
            datatype: "json",
            data: JSON.stringify(entity)
        }).done(function (data) {
            alert(data);
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

    function addEntity(table_name, entity) {
        $.ajax({
            url: "/mainPage",
            type: "POST",
            data: {
                entity: entity,
                table_name: table_name,
                action: "add"
            }
        }).done(function (data) {

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
