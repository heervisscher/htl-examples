 use(function () {
  
     // example on parsing handling JSON in Javascript, that is stored in JCR
     // following JSON is stored in a String[] in the JCR
     // {"key1":"value1","key2":"value2"},{"key1":"value3","key2":"value4"}

    var jsondata = currentPage.properties.get("jsondata");
    var jsonlength = currentPage.properties.get("jsondata").length;

    var keys = [];

    for (var i=0; i < jsonlength; i++) {
        // parse the JSON, and get value for key1
        keys.push(JSON.parse(jsondata[i]).key1);
    }

    return {
        keys : keys

    };
});
