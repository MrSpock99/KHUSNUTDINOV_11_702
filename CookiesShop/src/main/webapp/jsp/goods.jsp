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
                        '</tr>';
                }
                tableHtml += '</table>';
                $("#goods_table").html(tableHtml);
            }).fail(function () {
                alert('ALL BAD')
            });
    }
</script>

<script>
    function getData(){
    $.ajax({
        url : "/goods",
        dataType : 'json',
        error : function() {

            alert("Error");
        },
        success : function(data) {
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
                    '</tr>';
            }
            tableHtml += '</table>';
            $("#goods_table").html(tableHtml);
        }
        });
    }
</script>
<body>

<p style="text-align: center">
    <button onclick="sendGood(1)" id="good_1" name="T-Shirt">T-Shirt</button>
<p style="text-align: center">
    <button onclick="sendGood(2)" id="good_2" name="Skirt">Skirt</button>
<p style="text-align: center">
    <button onclick="sendGood(3)" id="good_3" name="Jacket">Jacket</button>

<div id="goods_table">

</div>
<button onclick="getData()" class="layer2"><img src="images/bucket.png"
                                                height="64" width="64">
</button>
</body>
</html>
