 use(function () {

    var jsondata = currentPage.properties.get("jsondata");
    var jsonlength = currentPage.properties.get("jsondata").length;

    var keys = [];

    for (var i=0; i < jsonlength; i++) {
        keys.push(JSON.parse(jsondata[i]).key1);
    }

    return {
        keys : keys

    };
});