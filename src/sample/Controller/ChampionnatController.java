package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import sample.Class.Championnat;
import sample.Class.Equipe;
import sample.Data.ApiCaller;

import java.util.ArrayList;
import java.util.List;

public class ChampionnatController {
    ListeChampionnatController controller = new ListeChampionnatController();



    @FXML
    private ListView<String> lvlisteequipe;

    private ObservableList<String> observableListequipes = FXCollections.observableArrayList();


    public void initialize(){
        int idchampionnat =controller.getIdchampionnat();
        System.out.println(idchampionnat);
        lvlisteequipe.getItems().clear();

        /**ApiCaller caller = ApiCaller.getInstance();
        ArrayList<Equipe> equipes = new ArrayList<Equipe>();
        if (caller.showselectedchampionnat(equipes)==200){
            int i=0;
            while(i<championnat.size()){
                observableListdepreg.add(championnat.get(i).getNomdepreg());
                System.out.println(championnat.get(i).getNomdepreg());
                i=i+1;
            }
            lvdepreg.setItems(observableListequipes);

            lvdepreg.setOnMouseClicked(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {
                    System.out.println("clicked on " + lvdepreg.getSelectionModel().getSelectedItem());
                    loadchmp(lvdepreg.getSelectionModel().getSelectedItem());
                }
            });
        }**/
    }

}
