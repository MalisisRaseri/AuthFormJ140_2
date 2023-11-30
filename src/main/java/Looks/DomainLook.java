package Looks;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import DBConnect.DomainRepImpl;
import DBInfo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DomainLook {
    private Stage domainLook;
    private final Person person;

    public DomainLook(Person person){
        this.person = person;
    }

    public void show(){
        domainLook = new Stage();
        VBox vbox = new VBox();

        List<DomainTable> domainTableList = new DomainRepImpl().getDomainByPersonId(person.getId()).stream().map(domain -> {
            return new DomainTable(
                    domain.getWebName(),
                    domain.getDomainName(),
                    domain.getIp(),
                    domain.getRegistrationDate(),
                    domain.getCountry()
            );
        }).collect(Collectors.toList());

        ObservableList<DomainTable> observableList = FXCollections.observableArrayList(domainTableList);
        TableView<DomainTable> table = new TableView<DomainTable>(observableList);


        TableColumn<DomainTable, String> webNameColumn = new TableColumn<>("Web Name");
        webNameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("webName"));
        table.getColumns().add(webNameColumn);

        TableColumn<DomainTable, String> domainNameColumn = new TableColumn<>("Domain Name");
        domainNameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("domainName"));
        table.getColumns().add(domainNameColumn);

        TableColumn<DomainTable, String> ipColumn = new TableColumn<>("IP");
        ipColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("ip"));
        table.getColumns().add(ipColumn);

        TableColumn<DomainTable, LocalDate> registrationDateColumn = new TableColumn<>("Registration Date");
        registrationDateColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, LocalDate>("registrationDate"));
        table.getColumns().add(registrationDateColumn);

        TableColumn<DomainTable, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("country"));
        table.getColumns().add(countryColumn);


        vbox.getChildren().add(table);
        Scene scene = new Scene(vbox, 450, 150);

        domainLook.setTitle(person.getFirstNameLastName());
        domainLook.setScene(scene);
        domainLook.show();
    }
}
