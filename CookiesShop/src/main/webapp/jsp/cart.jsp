<%--
  Created by IntelliJ IDEA.
  User: Ayaz_Khusnutdinov
  Date: 23.10.2018
  Time: 6:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>
    <title>Cart</title>
</head>
<script>
    function sendGood(name) {
        $.ajax({
            type: 'POST',
            url: '/cart',
            data: {
                name: name
            }
        }).done(function (data) {
            let divTable = document.getElementById('users_table');
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
            divTable.innerHTML = tableHtml;
        })

    }
</script>
<body>
Товаров в корзине: ${count}
<div id="goods_table">

</div>

</body>
</html>
