var express = require('express');
var router = express.Router();
var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '',
  database: "gestionequipe"
});

router.post('/', function(request, response) {
	var email = request.body.email;
	var password = request.body.password;
  console.log("okay");
  console.log(email+' '+password);
	if (email && password) {
		connection.query('SELECT * FROM joueur WHERE email = ? AND password = ?', [email, password], function(error, results, fields) {
			if (results.length > 0) {
        console.log("okay");
        response.send(results);
			} else {
        console.log("not okay");
        error="Incorrect Username and/or Password!";
        response.status(error.status || 400);
				response.send({
          error: error
        });
			}
			response.end();
		});
	} else {
    error='Please enter Username and Password!';
    response.status(error.status || 400);
    response.send({
      error: error
    });
		response.end();
	}
});


router.get('/', function(request, response) {
  console.log("okay");
		connection.query('SELECT * FROM joueur ', function(error, results, fields) {
			if (results.length > 0) {
        response.send(results);
			} else {
        error="pas de joueur en base";
				response.send({
          error: error
        });
			}
			response.end();
		});
});
router.get('/test', function(request, response) {
  console.log("okay");
		connection.query('SELECT * FROM joueur ', function(error, results, fields) {
			if (results.length > 0) {
        response.send(results);
			} else {
        error="pas de joueur en base";
				response.send({
          error: error
        });
			}
			response.end();
		});
});

module.exports = router;
