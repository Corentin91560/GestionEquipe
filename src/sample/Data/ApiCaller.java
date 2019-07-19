package sample.Data;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import sample.Class.Championnat;
import sample.Class.Equipe;
import sample.Class.Joueur;


public class ApiCaller {
    private String apiPath = "http://localhost:3000/";

    private static ApiCaller instance;

    public static ApiCaller getInstance() {
        if (instance == null) {
            instance = new ApiCaller();
        }
        return instance;
    }

    private ApiCaller(){

    }



    public int signInUser(String email,String password,Joueur joueur){
        HttpURLConnection con;
        String url = apiPath+"signin";
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/json");

            JSONObject object = new JSONObject();
            object.put("email",email);
            object.put("password",password);
            OutputStream os = con.getOutputStream();
            os.write(object.toString().getBytes("UTF-8"));
            os.close();

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONArray obj = new JSONArray(content.toString());

            joueur.setNom(obj.getJSONObject(0).getString("Nom"));
            joueur.setPrenom(obj.getJSONObject(0).getString("prenom"));
            joueur.setId(obj.getJSONObject(0).getInt("id"));
            joueur.setDate_naissance(obj.getJSONObject(0).getString("date_naissance"));
            joueur.setVille(obj.getJSONObject(0).getString("ville"));
            joueur.setCp(obj.getJSONObject(0).getInt("cp"));
            joueur.setIdclub(obj.getJSONObject(0).getInt("idclub"));
            joueur.setIdequipe(obj.getJSONObject(0).getInt("idequipe"));
            joueur.setEmail(obj.getJSONObject(0).getString("email"));
            joueur.setPassword(obj.getJSONObject(0).getString("password"));

            return con.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return 500;
    }

    public int depregsearch(String niveau, ArrayList<Championnat> championnats){
        HttpURLConnection con;
        String url = apiPath+"championnat/"+niveau;
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type","application/json");


            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONArray obj = new JSONArray(content.toString());

            for (int i = 0; i < obj.length(); i++) {
                championnats.add(i,new Championnat(niveau,obj.getJSONObject(i).getString("nomdepreg")));
            }
            return con.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return 500;
    }


    public int championnatsearch(String nomdepreg, ArrayList<Championnat> championnats){
        HttpURLConnection con;
        String url = apiPath+"championnat/";
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/json");

            JSONObject object = new JSONObject();
            object.put("nomdepreg",nomdepreg);
            OutputStream os = con.getOutputStream();
            os.write(object.toString().getBytes("UTF-8"));
            os.close();

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONArray obj = new JSONArray(content.toString());

            for (int i = 0; i < obj.length(); i++) {
                championnats.add(i,new Championnat(nomdepreg,obj.getJSONObject(i).getString("division"),obj.getJSONObject(i).getInt("idchampionnat")));
            }
            return con.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return 500;
    }


    public int showselectedchampionnat(int idchampionnat, ArrayList<Equipe> equipes){
        HttpURLConnection con;
        String url = apiPath+"championnat/getchampionnat";
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type","application/json");

            JSONObject object = new JSONObject();
            object.put("idchampionnat",idchampionnat);
            OutputStream os = con.getOutputStream();
            os.write(object.toString().getBytes("UTF-8"));
            os.close();

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONArray obj = new JSONArray(content.toString());

            for (int i = 0; i < obj.length(); i++) {
                equipes.add(i,new Equipe(obj.getJSONObject(i).getInt("idequipe"),obj.getJSONObject(i).getString("nomequipe")));
            }
            return con.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return 500;
    }


/**
    public List<Bug> getListBugByStatut(int status){
        HttpURLConnection con;
        String url = apiPath+"bugAdmin/getAllByStatut";
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("UserGestionToken-Agent", "Java client");
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("x-access-token", UserGestionToken.getToken());

            JSONObject object = new JSONObject();
            object.put("filter",status);
            OutputStream os = con.getOutputStream();
            os.write(object.toString().getBytes("UTF-8"));
            os.close();

            int statusRequest =  con.getResponseCode();
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            //System.out.println(content);
            JSONObject obj = new JSONObject(content.toString());

            JSONArray arr = obj.getJSONArray("bugs");
            List<Bug> data = new ArrayList<>();
            for (int i = 0; i < arr.length(); i++) {
                if(arr.getJSONObject(i).has("_id") && arr.getJSONObject(i).has("createdAt") && arr.getJSONObject(i).has("type") && arr.getJSONObject(i).has("status") && arr.getJSONObject(i).has("userID")){
                    data.add(new Bug(arr.getJSONObject(i).getString("_id"),arr.getJSONObject(i).getString("createdAt"),arr.getJSONObject(i).getString("content"),arr.getJSONObject(i).getString("type"),arr.getJSONObject(i).getInt("status"),arr.getJSONObject(i).getString("userID")));
                }
            }
            return data;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return null;
    }

    //On fait une fonction pour la réolution du bug.
    public int resolveBug(String idBug,int status){
        HttpURLConnection con;
        String url = apiPath+"bugAdmin/updateStatus";

        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("PUT");
            con.setRequestProperty("UserGestionToken-Agent", "Java client");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setRequestProperty("x-access-token", UserGestionToken.getToken());

            JSONObject object = new JSONObject();
            object.put("_id",idBug);
            object.put("status",1);

            OutputStream os = con.getOutputStream();
            os.write(object.toString().getBytes("UTF-8"));
            os.close();

            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String line;
                content = new StringBuilder();

                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }

            }

            return con.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return 500;
    }

    public List<ExpenseReport> getListExpenseReport(){
        HttpURLConnection con;
        String url = apiPath+"adminEr/getAll";
        try {
            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("UserGestionToken-Agent", "Java client");
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("x-access-token", UserGestionToken.getToken());


            int statusRequest =  con.getResponseCode();
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONObject obj = new JSONObject(content.toString());

            JSONArray arr = obj.getJSONArray("exenses");
            List<ExpenseReport> listExpenseReport = new ArrayList<ExpenseReport>();
            for (int i = 0; i < arr.length(); i++) {
                listExpenseReport.add(new ExpenseReport(arr.getJSONObject(i).getString("_id"),"id de la compagnie",arr.getJSONObject(i).getInt("price"),arr.getJSONObject(i).getInt("vat"),arr.getJSONObject(i).getString("address"),arr.getJSONObject(i).getInt("status"),arr.getJSONObject(i).getString("createdAt"),"lastUpdatedAt","repayementAt",arr.getJSONObject(i).getString("userID"),"imageID"));

            }

            return listExpenseReport;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ExpenseReport> getListExpenseReportByCompany(String idCompany){
        HttpURLConnection con;
        String url = apiPath+"adminEr/erByCompany";
        try {
            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("UserGestionToken-Agent", "Java client");
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("x-access-token", UserGestionToken.getToken());

            JSONObject object = new JSONObject();
            object.put("companyID",idCompany);
            OutputStream os = con.getOutputStream();
            os.write(object.toString().getBytes("UTF-8"));
            os.close();


            int statusRequest =  con.getResponseCode();
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONObject obj = new JSONObject(content.toString());

            JSONArray arr = obj.getJSONArray("er");
            //On configure la classe ExpenseExport avec les différents champs et on ajoute avec les données que l'on récupère.
            List<ExpenseReport> listExpenseReport = new ArrayList<ExpenseReport>();
            for (int i = 0; i < arr.length(); i++) {
                listExpenseReport.add(new ExpenseReport(arr.getJSONObject(i).getString("_id"),"id de la compagnie",arr.getJSONObject(i).getInt("price"),arr.getJSONObject(i).getInt("vat"),arr.getJSONObject(i).getString("address"),arr.getJSONObject(i).getInt("status"),arr.getJSONObject(i).getString("createdAt"),"lastUpdatedAt","repayementAt",arr.getJSONObject(i).getString("userID"),"imageID"));

            }

            return listExpenseReport;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Company> getListCompany(){
        HttpURLConnection con;
        String url = apiPath+"adminCompany/getAll";
        try {
            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("UserGestionToken-Agent", "Java client");
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("x-access-token", UserGestionToken.getToken());


            int statusRequest =  con.getResponseCode();
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONObject obj = new JSONObject(content.toString());

            JSONArray arr = obj.getJSONArray("companies");
            List<Company> listCompany = new ArrayList<Company>();
            for (int i = 0; i < arr.length(); i++) {
                listCompany.add(new Company(arr.getJSONObject(i).getString("_id"),arr.getJSONObject(i).getString("name"),"image de la companie",arr.getJSONObject(i).getString("createdAt"),"date de modification"));
            }

            return listCompany;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<User> getListUserByCompany(String idCompany){
        HttpURLConnection con;
        String url = apiPath+"admin/getUserByIdCompany";
        try {
            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("UserGestionToken-Agent", "Java client");
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("x-access-token", UserGestionToken.getToken());

            JSONObject object = new JSONObject();
            object.put("companyID",idCompany);
            OutputStream os = con.getOutputStream();
            os.write(object.toString().getBytes("UTF-8"));
            os.close();


            int statusRequest =  con.getResponseCode();
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONObject obj = new JSONObject(content.toString());

            JSONArray arr = obj.getJSONArray("users");
            List<User> listUser = new ArrayList<User>();
            for (int i = 0; i < arr.length(); i++) {
                listUser.add(new User(arr.getJSONObject(i).getString("_id"),arr.getJSONObject(i).getString("lastname"),arr.getJSONObject(i).getString("firstname"),arr.getJSONObject(i).getString("email"),arr.getJSONObject(i).getString("createdAt")));

            }

            return listUser;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //On fait une fonction qui récupère la liste des user
    public List<User> getListAllUser(){
        HttpURLConnection con;
        String url = apiPath+"admin/getAllUser";
        try {
            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("UserGestionToken-Agent", "Java client");
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("x-access-token", UserGestionToken.getToken());



            int statusRequest =  con.getResponseCode();
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONObject obj = new JSONObject(content.toString());

            JSONArray arr = obj.getJSONArray("users");
            List<User> listUser = new ArrayList<User>();
            for (int i = 0; i < arr.length(); i++) {
                listUser.add(new User(arr.getJSONObject(i).getString("_id"),arr.getJSONObject(i).getString("lastname"),arr.getJSONObject(i).getString("firstname"),arr.getJSONObject(i).getString("email"),arr.getJSONObject(i).getString("createdAt")));

            }

            return listUser;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Bug> getAllBug(){
        HttpURLConnection con;
        String url = apiPath+"bugAdmin/getAll";
        try {

            URL myurl = new URL(url);
            con = (HttpURLConnection) myurl.openConnection();

            con.setDoOutput(true);
            con.setRequestMethod("GET");
            con.setRequestProperty("UserGestionToken-Agent", "Java client");
            con.setRequestProperty("Content-Type","application/json");
            con.setRequestProperty("x-access-token", UserGestionToken.getToken());

            int statusRequest =  con.getResponseCode();
            StringBuilder content;
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;
                content = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
            JSONObject obj = new JSONObject(content.toString());

            JSONArray arr = obj.getJSONArray("bugs");
            List<Bug> listData = new ArrayList<Bug>();
            for (int i = 0; i < arr.length(); i++) {

                listData.add(new Bug(arr.getJSONObject(i).getString("_id"),arr.getJSONObject(i).getString("createdAt"),arr.getJSONObject(i).getString("type"),arr.getJSONObject(i).getString("type"),arr.getJSONObject(i).getInt("status"),arr.getJSONObject(i).getString("userID")));

                String post_id = arr.getJSONObject(i).getString("content");

            }

            return listData;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
        return null;
    }
 **/
}
