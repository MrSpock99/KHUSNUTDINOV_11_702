function sendGood(name) {
    $.ajax({
        type: 'POST',
        url: '/cart',
        data: {
            name: name
        }
    }).done(function (data) {
        var divTable = goods.getElementById('goods_table');
        var tableHtml = "";
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

        for (var i = 0; i < data.length; i++) {
            tableHtml += '<tr>' +
                '<td>' + data[i].id + '</td>' +
                '<td>' + data[i].name + '</td>' +
                '</tr>';
        }
        tableHtml += '</table>';
        divTable.innerHTML = tableHtml;
    })

}