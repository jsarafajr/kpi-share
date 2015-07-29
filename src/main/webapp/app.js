var express = require("express");
var app = express();

app.listen(3000);

app.use(express.static(__dirname + "/public/web"));

app.get("/", function(req, res) {
    res.render("index.html");
});