var express = require('express');
var router = express.Router();
var mysql      = require('mysql');
var connection = mysql.createConnection({
  host     : 'localhost',
  user     : 'root',
  password : '',
  database: "gestionequipe"
});

router.post('/getchampionnat', function(request, response) {
	var idchampionnat = request.body.idchampionnat;
  console.log("okay "+idchampionnat);
	if (idchampionnat) {
		connection.query('select nomequipe,idequipe from equipe,championnat where  equipe.idchampionnat=championnat.idchampionnat and championnat.idchampionnat = ?', [idchampionnat], function(error, results, fields) {
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

router.post('/', function(request, response) {
	var nomdepreg = request.body.nomdepreg;
  console.log("okay "+nomdepreg);
	if (nomdepreg) {
		connection.query('SELECT division,idchampionnat FROM championnat WHERE nomdepreg = ? ', [nomdepreg], function(error, results, fields) {
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

router.get('/departemental', function(request, response) {
  console.log("okay");
		connection.query('SELECT distinct(nomdepreg) FROM championnat where niveau="departemental"', function(error, results, fields) {
			if (results.length > 0) {
        response.send(results);
			} else {
        error="pas de championnat departementaux";
				response.send({
          error: error
        });
			}
			response.end();
		});
});
router.get('/regional', function(request, response) {
  console.log("okay");
		connection.query('SELECT distinct(nomdepreg) FROM championnat where niveau="regional"', function(error, results, fields) {
			if (results.length > 0) {
        response.send(results);
			} else {
        error="pas de championnat regionaux";
				response.send({
          error: error
        });
			}
			response.end();
		});
});
router.get('/national', function(request, response) {
  console.log("okay");
		connection.query('SELECT distinct(nomdepreg) FROM championnat where niveau="national"', function(error, results, fields) {
			if (results.length > 0) {
        response.send(results);
			} else {
        error="pas de championnat nationaux";
				response.send({
          error: error
        });
			}
			response.end();
		});
});

module.exports = router;
