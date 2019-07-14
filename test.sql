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
        idclub  Int  Auto_increment  NOT NULL ,
        nomclub Varchar (50) ,
        idsport Int NOT NULL
	,CONSTRAINT club_PK PRIMARY KEY (idclub)

	,CONSTRAINT club_sport_FK FOREIGN KEY (idsport) REFERENCES sport(idsport)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: championnat
#------------------------------------------------------------

CREATE TABLE championnat(
        idchampionnat Int  Auto_increment  NOT NULL ,
        division      Varchar (50) ,
        niveau        Varchar (50),
        idsport       Int NOT NULL
	,CONSTRAINT championnat_PK PRIMARY KEY (idchampionnat)

	,CONSTRAINT championnat_sport_FK FOREIGN KEY (idsport) REFERENCES sport(idsport)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: equipe
#------------------------------------------------------------

CREATE TABLE equipe(
        idequipe      Int  Auto_increment  NOT NULL ,
        nomequipe     Varchar (50) ,
        idclub        Int NOT NULL ,
        idchampionnat Int NOT NULL
	,CONSTRAINT equipe_PK PRIMARY KEY (idequipe)

	,CONSTRAINT equipe_club_FK FOREIGN KEY (idclub) REFERENCES club(idclub)
	,CONSTRAINT equipe_championnat0_FK FOREIGN KEY (idchampionnat) REFERENCES championnat(idchampionnat)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Joueur
#------------------------------------------------------------

CREATE TABLE Joueur(
        id             Int  Auto_increment  NOT NULL ,
        email          Varchar (150) ,
        password       Varchar (50) ,
        Nom            Varchar (50) ,
        prenom         Varchar (50) ,
        date_naissance Date ,
        ville          Varchar (50) ,
        cp             Int ,
        idclub         Int NOT NULL ,
        idequipe       Int NOT NULL
	,CONSTRAINT Joueur_PK PRIMARY KEY (id)

	,CONSTRAINT Joueur_club_FK FOREIGN KEY (idclub) REFERENCES club(idclub)
	,CONSTRAINT Joueur_equipe0_FK FOREIGN KEY (idequipe) REFERENCES equipe(idequipe)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: tournois
#------------------------------------------------------------

CREATE TABLE tournois(
        idtournois  Int  Auto_increment  NOT NULL ,
        restriction Varchar (300) NOT NULL ,
        idsport     Int NOT NULL
	,CONSTRAINT tournois_PK PRIMARY KEY (idtournois)

	,CONSTRAINT tournois_sport_FK FOREIGN KEY (idsport) REFERENCES sport(idsport)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: match
#------------------------------------------------------------

CREATE TABLE matchs(
        idmatchs      Int  Auto_increment  NOT NULL ,
        scoreDom      Varchar (50) NOT NULL ,
        scoreExt      Varchar (50) NOT NULL ,
        idchampionnat Int NOT NULL ,
        idtournois    Int NOT NULL
	,CONSTRAINT matchs_PK PRIMARY KEY (idmatchs)

	,CONSTRAINT matchs_championnat_FK FOREIGN KEY (idchampionnat) REFERENCES championnat(idchampionnat)
	,CONSTRAINT matchs_tournois0_FK FOREIGN KEY (idtournois) REFERENCES tournois(idtournois)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: entrainement
#------------------------------------------------------------

CREATE TABLE entrainement(
        identrainement Int  Auto_increment  NOT NULL ,
        date           Varchar (50) ,
        lieu           Varchar (50) ,
        idequipe       Int NOT NULL
	,CONSTRAINT entrainement_PK PRIMARY KEY (identrainement)

	,CONSTRAINT entrainement_equipe_FK FOREIGN KEY (idequipe) REFERENCES equipe(idequipe)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: engager
#------------------------------------------------------------

CREATE TABLE engager(
        idtournois   Int NOT NULL ,
        idequipe     Int NOT NULL ,
        datetournois Date ,
        nomtournois  Varchar (50) NOT NULL
	,CONSTRAINT engager_PK PRIMARY KEY (idtournois,idequipe)

	,CONSTRAINT engager_tournois_FK FOREIGN KEY (idtournois) REFERENCES tournois(idtournois)
	,CONSTRAINT engager_equipe0_FK FOREIGN KEY (idequipe) REFERENCES equipe(idequipe)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: affecter
#------------------------------------------------------------

CREATE TABLE affecter(
        id             Int NOT NULL ,
        identrainement Int NOT NULL
	,CONSTRAINT affecter_PK PRIMARY KEY (id,identrainement)

	,CONSTRAINT affecter_Joueur_FK FOREIGN KEY (id) REFERENCES Joueur(id)
	,CONSTRAINT affecter_entrainement0_FK FOREIGN KEY (identrainement) REFERENCES entrainement(identrainement)
)ENGINE=InnoDB;
