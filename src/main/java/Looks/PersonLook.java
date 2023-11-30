package Looks;

import DBConnect.DomainRep;
import DBConnect.DomainRepImpl;
import DBConnect.PersonRep;
import DBConnect.PersonRepImpl;
import DBInfo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.VBox;

public class PersonLook{
    private Stage personLook;
    private final PersonRep personRepository;
    private final DomainRep domainRepository;

    public PersonLook(){
        personRepository = new PersonRepImpl();
        domainRepository = new DomainRepImpl();
    }

    public void show () {
        personLook = new Stage ();
        VBox vbox = new VBox();

        List<PersonTable> personTableList = new ArrayList<>();
        List<Person> personList = personRepository.getPersons();
        for (Person person : personList) {
            int domainsNumber = domainRepository.getDomainByPerson(person).size();
            personTableList.add(new PersonTable(
                    person.getId(),
                    person.getJobTitle(),
                    person.getFirstNameLastName(),
                    person.getPhone(),
                    person.getEmail(),
                    domainsNumber));
        }

        ObservableList<PersonTable> observableList = FXCollections.observableArrayList(personTableList);
        TableView<PersonTable> personTable = new TableView<PersonTable>(observableList);


        TableColumn<PersonTable, Integer> idColumn = new TableColumn<>("Identificator");
        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        personTable.getColumns().add(idColumn);

        TableColumn<PersonTable, String> jobTitleColumn = new TableColumn<>("Job Title");
        jobTitleColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("jobTitle"));
        personTable.getColumns().add(jobTitleColumn);

        TableColumn<PersonTable, String> firstNameLastNameColumn = new TableColumn<>("First and Last Name");
        firstNameLastNameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("firstNameLastName"));
        personTable.getColumns().add(firstNameLastNameColumn);

        TableColumn<PersonTable, String> phoneColumn = new TableColumn<>("Phone Number");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("phone"));
        personTable.getColumns().add(phoneColumn);

        TableColumn<PersonTable, String> emailColumn = new TableColumn<>("EMAIL");
        emailColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("email"));
        personTable.getColumns().add(emailColumn);

        TableColumn<PersonTable, Integer> domainsNumberColumn = new TableColumn<>("Number of domains");
        domainsNumberColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("domainsNumber"));
        personTable.getColumns().add(domainsNumberColumn);


        personTable.setOnMouseClicked(e->{
            if(e.getClickCount()==2){
                PersonTable table = personTable.getSelectionModel().getSelectedItem();
                Person person = personRepository.getPersonById(table.getId());
                DomainLook domainLook = new DomainLook(person);
                domainLook.show();
            }
        });


        vbox.getChildren().add(personTable);
        Scene scene = new Scene(vbox, 770, 350);

        personLook.setTitle("Persons");
        personLook.setScene(scene);
        personLook.show();
    }
}
