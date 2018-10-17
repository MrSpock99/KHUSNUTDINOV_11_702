<%--
  Created by IntelliJ IDEA.
  User: Ayaz_Khusnutdinov
  Date: 16.10.2018
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</head>

<body id="page-top">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav">
    <a class="navbar-brand js-scroll-trigger" href="#page-top">
        <span class="d-block d-lg-none">Welcome, Bruce Wayne</span>
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
                <a class="nav-link js-scroll-trigger" href="#weapons">Weapons</a>
            </li>
            <li class="nav-item">
                <a class="nav-link js-scroll-trigger" href="#ammonition">Ammunition</a>
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
                <span class="text-primary">Bruce Wayne</span>
            </h1>
        </div>
    </section>

</div>


<hr class="m-0">

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="subjects">

    <div class="my-auto">

        <h2 class="mb-5">Subjects</h2>

        <!--<input class="form-control" id="subjectInput" type="text" placeholder="Search..">

        <table class="table table-hover">
            <thead class="thead-inverse">
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
            <tr>
                <th scope="row">1</th>
                <td>Superman</td>
                <td>Clark Kent</td>
                <td></td>
                <td></td>
                <td>Hero</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Joker</td>
                <td></td>
                <td></td>
                <td></td>
                <td>Villain</td>
            </tr>
            </tbody>
        </table>
-->
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
            <tr>
                <th scope="row">1</th>
                <td>Superman</td>
                <td>Clark Kent</td>
                <td></td>
                <td></td>
                <td>Hero</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Joker</td>
                <td></td>
                <td></td>
                <td></td>
                <td>Villain</td>
            </tr>
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
        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Ammunition</th>
            </tr>
            </thead>
            <tbody id="weapon_ammo_table">
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
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

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="weapons">
    <div class="my-auto">
        <h2 class="mb-5">Weapons</h2>

        <input class="form-control" id="weapon_input" type="text" placeholder="Search..">

        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Ammunition</th>
            </tr>
            </thead>
            <tbody id="weapon_table">
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
            </tbody>
        </table>

        <script type="text/javascript">
            $(document).ready(function () {
                $("#weapon_input").on("keyup", function () {
                    var value = $(this).val().toLowerCase();
                    $("#weapon_table tr").filter(function () {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>

        <button type="button" class="btn btn-dark float-right">Add</button>

    </div>
</section>

<hr class="m-0">

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="ammonition">
    <div class="my-auto">
        <h2 class="mb-5">Ammunition</h2>

        <input class="form-control" id="ammo_input" type="text" placeholder="Search..">

        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody id="ammo_table">
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
            </tbody>
        </table>

        <button type="button" class="btn btn-dark float-right">Add</button>

        <hr class="m-0">

    </div>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#ammo_input").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#ammo_table tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>

</section>

<hr class="m-0">

<section class="resume-section p-3 p-lg-5 d-flex flex-column" id="armor">
    <div class="my-auto">
        <h2 class="mb-5">Armor</h2>

        <input class="form-control" id="armor_input" type="text" placeholder="Search..">

        <table class="table">
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
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
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

        <table class="table">

            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Water</th>
                <th>Air</th>
                <th>Ground</th>
            </tr>
            </thead>
            <tbody id="transport_table">
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>
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

        <table class="table">
            <thead class="thead-inverse">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Type</th>
                <th>Cost</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody id="expenses_table">
            <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td>Larry</td>
                <td>the Bird</td>
                <td>@twitter</td>
            </tr>

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

    </div>
</section>


<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/resume.min.js"></script>
</body>

</html>
</html>
