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
                product_id: id,
                action: 'buy'
            }
        }).done(function (data) {
            let tableHtml = "";
            tableHtml += '<table>';
            tableHtml +=
                '<tr>' +
                '<th>' +
                'name' +
                '</th>' +
                '<th>' +
                'quantity' +
                '</th>' +
                '</tr>';
            for (var key in data) {
                tableHtml += '<tr>' +
                    '<td>' + getProductName(key) + '</td>' +
                    '<td>' + data[key] + '</td>' +
                    '<td>' + '<button onclick="deleteProduct(' + getProductId(key) + ')" formaction="delete" id=' + 1 + '>Delete</button>' + '</td>' +
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
            console.log(data);
            let tableHtml = "";
            tableHtml += '<table>';
            tableHtml +=
                '<tr>' +
                '<th>' +
                'name' +
                '</th>' +
                '<th>' +
                'quantity' +
                '</th>' +
                '</tr>';
            for (var key in data) {
                tableHtml += '<tr>' +
                    '<td>' + getProductName(key) + '</td>' +
                    '<td>' + data[key] + '</td>' +
                    '<td>' + '<button onclick="deleteProduct(' + getProductId(key) + ')" formaction="delete" id=' + 1 + '>Delete</button>' + '</td>' +
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
<script>
    function getData() {
        $.ajax({
            url: "/goods.json",
            type: "GET",
            data_type: "json"
        })
            .done(function (data) {
                console.log(data);
                let tableHtml = "";
                tableHtml += '<table>';
                tableHtml +=
                    '<tr>' +
                    '<th>' +
                    'name' +
                    '</th>' +
                    '<th>' +
                    'quantity' +
                    '</th>' +
                    '</tr>';

                for (var key in data) {
                    tableHtml += '<tr>' +
                        '<td>' + getProductName(key) + '</td>' +
                        '<td>' + data[key] + '</td>' +
                        '<td>' + '<button onclick="deleteProduct(' + getProductId(key) + ')" formaction="delete" id=' + 1 + '>Delete</button>' + '</td>' +
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

    function getProductId(key) {
        return key.substring(key.indexOf("=") + 1, key.indexOf(","));
    }

    function getProductName(key) {
        return key.substring(key.indexOf("=", key.indexOf("=") + 1) + 1, key.indexOf(",", key.indexOf(",") + 1));
    }
</script>

<body onload="getData()">

<p style="text-align: center">
    <button onclick="sendGood(1)" name="T-Shirt">T-Shirt</button>
<p style="text-align: center">
    <button onclick="sendGood(2)" name="Skirt">Skirt</button>
<p style="text-align: center">
    <button onclick="sendGood(3)" name="Jacket">Jacket</button>

<div id="goods_table">

</div>
<button onclick="getData()" class="layer2"><img src="images/bucket.png"
                                                height="64" width="64">
</button>
</body>
</html>
