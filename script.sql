#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: sport
#------------------------------------------------------------

CREATE TABLE sport(
        idsport  Int  Auto_increment  NOT NULL ,
        nomsport Varchar (50)
	,CONSTRAINT sport_PK PRIMARY KEY (idsport)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: club
#------------------------------------------------------------

CREATE TABLE club(
        idclub            Int  Auto_increment  NOT NULL ,
        nomclub           Varchar (50) ,
        idsport           Int  Auto_increment  ,
        idsport_pratiquer Int NOT NULL
	,CONSTRAINT club_AK UNIQUE (idsport)
	,CONSTRAINT club_PK PRIMARY KEY (idclub)

	,CONSTRAINT club_sport_FK FOREIGN KEY (idsport_pratiquer) REFERENCES sport(idsport)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Joueur
#------------------------------------------------------------

CREATE TABLE Joueur(
        id             Int  Auto_increment  NOT NULL ,
        Nom            Varchar (50) ,
        prenom         Varchar (50) ,
        date_naissance Date ,
        ville          Varchar (50) ,
        cp             Int ,
        idclub         Int  Auto_increment  ,
        idclub_signer  Int NOT NULL
	,CONSTRAINT Joueur_AK UNIQUE (idclub)
	,CONSTRAINT Joueur_PK PRIMARY KEY (id)

	,CONSTRAINT Joueur_club_FK FOREIGN KEY (idclub_signer) REFERENCES club(idclub)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: championnat
#------------------------------------------------------------

CREATE TABLE championnat(
        idchampionnat     Int  Auto_increment  NOT NULL ,
        division          Varchar (50) ,
        idsport           Int  Auto_increment  ,
        idsport_concerner Int NOT NULL
	,CONSTRAINT championnat_AK UNIQUE (idsport)
	,CONSTRAINT championnat_PK PRIMARY KEY (idchampionnat)

	,CONSTRAINT championnat_sport_FK FOREIGN KEY (idsport_concerner) REFERENCES sport(idsport)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: equipe
#------------------------------------------------------------

CREATE TABLE equipe(
        idequipe                 Int  Auto_increment  NOT NULL ,
        nomequipe                Varchar (50) ,
        idclub                   Int  Auto_increment  ,
        idchampionnat            Int  Auto_increment  NOT NULL ,
        idclub_composer          Int NOT NULL ,
        idchampionnat_participer Int NOT NULL
	,CONSTRAINT equipe_AK UNIQUE (idclub,idchampionnat)
	,CONSTRAINT equipe_PK PRIMARY KEY (idequipe)

	,CONSTRAINT equipe_club_FK FOREIGN KEY (idclub_composer) REFERENCES club(idclub)
	,CONSTRAINT equipe_championnat0_FK FOREIGN KEY (idchampionnat_participer) REFERENCES championnat(idchampionnat)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: tournois
#------------------------------------------------------------

CREATE TABLE tournois(
        idtournois           Int  Auto_increment  NOT NULL ,
        restriction          Varchar (300) NOT NULL ,
        idsport              Int  Auto_increment  ,
        idsport_correspondre Int NOT NULL
	,CONSTRAINT tournois_AK UNIQUE (idsport)
	,CONSTRAINT tournois_PK PRIMARY KEY (idtournois)

	,CONSTRAINT tournois_sport_FK FOREIGN KEY (idsport_correspondre) REFERENCES sport(idsport)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: match
#------------------------------------------------------------

CREATE TABLE match(
        idmatch                Int  Auto_increment  NOT NULL ,
        scoreDom               Varchar (50) NOT NULL ,
        scoreExt               Varchar (50) NOT NULL ,
        idchampionnat          Int  Auto_increment  NOT NULL ,
        idtournois             Int  Auto_increment  NOT NULL ,
        idchampionnat_realiser Int NOT NULL ,
        idtournois__realiser   Int NOT NULL
	,CONSTRAINT match_AK UNIQUE (idchampionnat,idtournois)
	,CONSTRAINT match_PK PRIMARY KEY (idmatch)

	,CONSTRAINT match_championnat_FK FOREIGN KEY (idchampionnat_realiser) REFERENCES championnat(idchampionnat)
	,CONSTRAINT match_tournois0_FK FOREIGN KEY (idtournois__realiser) REFERENCES tournois(idtournois)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: engager
#------------------------------------------------------------

CREATE TABLE engager(
        idtournois   Int NOT NULL ,
        idequipe     Int NOT NULL ,
        datetournois Date
	,CONSTRAINT engager_PK PRIMARY KEY (idtournois,idequipe)

	,CONSTRAINT engager_tournois_FK FOREIGN KEY (idtournois) REFERENCES tournois(idtournois)
	,CONSTRAINT engager_equipe0_FK FOREIGN KEY (idequipe) REFERENCES equipe(idequipe)
)ENGINE=InnoDB;

