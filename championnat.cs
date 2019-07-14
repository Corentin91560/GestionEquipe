using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Gestionequipe
{
    #region Championnat
    public class Championnat
    {
        #region Member Variables
        protected int _idchampionnat;
        protected string _division;
        protected int _idsport;
        protected string _niveau;
        protected string _nomdepreg;
        #endregion
        #region Constructors
        public Championnat() { }
        public Championnat(string division, int idsport, string niveau, string nomdepreg)
        {
            this._division=division;
            this._idsport=idsport;
            this._niveau=niveau;
            this._nomdepreg=nomdepreg;
        }
        #endregion
        #region Public Properties
        public virtual int Idchampionnat
        {
            get {return _idchampionnat;}
            set {_idchampionnat=value;}
        }
        public virtual string Division
        {
            get {return _division;}
            set {_division=value;}
        }
        public virtual int Idsport
        {
            get {return _idsport;}
            set {_idsport=value;}
        }
        public virtual string Niveau
        {
            get {return _niveau;}
            set {_niveau=value;}
        }
        public virtual string Nomdepreg
        {
            get {return _nomdepreg;}
            set {_nomdepreg=value;}
        }
        #endregion
    }
    #endregion
}