<%--
  Created by IntelliJ IDEA.
  User: Ayaz_Khusnutdinov
  Date: 23.10.2018
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <title>Goods</title>
    <style>
        .layer2 {
            position: absolute; /* Абсолютное позиционирование */
            top: 15px; /* Положение от нижнего края */
            right: 15px; /* Положение от правого края */
            line-height: 1px;
        }
    </style>
</head>
<script>
    function sendGood(id) {
        $.ajax({
            type: 'POST',
            url: '/goods',
            data: {
                product_id: id
            }
        }).done(function (data) {
            console.log(data);
            let tableHtml = "";
            tableHtml += '<table>';
            tableHtml +=
                '<tr>' +
                '<th>' +
                'id' +
                '</th>' +
                '<th>' +
                'name' +
                '</th>' +
                '</tr>';
            for (let i = 0; i < data.length; i++) {
                tableHtml += '<tr>' +
                    '<td>' + data[i].id + '</td>' +
                    '<td>' + data[i].name + '</td>' +
                    '<td>' + '<button onclick="deleteProduct(data[i].id)" formaction="delete" id=' + data[i].id + 'name="T-Shirt">Delete</button>' + '</td>' +
                    '</tr>';
            }
            tableHtml += '</table>';
            $("#goods_table").html(tableHtml);
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
            alert(msg)
        })
    }
</script>

<script>
    function deleteProduct(id) {
        $.ajax({
            type: 'POST',
            url: '/goods',
            data: {
                product_id: id,
                action: 'delete'
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
            alert(msg)
        });
    }
</script>
<script>
    function getData() {
        $.ajax({
            url: "/goods.json",
            type: "GET",
            data_type:"json"
        })
            .done(function (data) {
                console.log(data);
                let tableHtml = "";
                tableHtml += '<table>';
                tableHtml +=
                    '<tr>' +
                    '<th>' +
                    'id' +
                    '</th>' +
                    '<th>' +
                    'name' +
                    '</th>' +
                    '</tr>';

                for (let i = 0; i < data.length; i++) {
                    tableHtml += '<tr>' +
                        '<td>' + data[i].id + '</td>' +
                        '<td>' + data[i].name + '</td>' +
                        '<td>' + '<button onclick="deleteProduct(data[i].id)" formaction="delete" id=' + data[i].id +'name="T-Shirt">Delete</button>' + '</td>'+
                        '</tr>';
                }
                tableHtml += '</table>';
                $("#goods_table").html(tableHtml);
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
            alert(msg)
        });
    }
</script>
<body onload="getData()">

<p style="text-align: center">
    <button  onclick="sendGood(1)" id="good_1" name="T-Shirt">T-Shirt</button>
<p style="text-align: center">
    <button onclick="sendGood(2)" id="good_2" name="Skirt">Skirt</button>
<p style="text-align: center">
    <button onclick="sendGood(3)" id="good_3" name="Jacket">Jacket</button>

<div id="goods_table">

</div>
<button onclick="sendGood()" class="layer2"><img src="images/bucket.png"
                                                 height="64" width="64">
</button>
</body>
</html>
