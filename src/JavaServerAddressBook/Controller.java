package JavaServerAddressBook;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    @FXML private TextField nameField;
    @FXML private TextField addressField;
    @FXML private TextField phoneField;
    @FXML private TextField emailField;
    @FXML private TextField commentField;
    @FXML private TableView tableView;
    private queryBuilder sam = new queryBuilder();
    public void addPerson(ActionEvent e) {
        ObservableList<Person> data = tableView.getItems();
        Person p;
        p = new Person(nameField.getText(),addressField.getText(),phoneField.getText(), emailField.getText(), commentField.getText());
        sam.addInDb(p);
        data.clear();
        nameField.clear();
        addressField.clear();
        phoneField.clear();
        emailField.clear();
        commentField.clear();
        viewAllPeople(new ActionEvent());
    }
    public void viewPerson(ActionEvent e) {
        ObservableList<Person> data = tableView.getItems();
        String personName = nameField.getText();
        ArrayList<Person> people = sam.searchFor(personName);
        data.clear();
        for(Person p : people) {
            data.add(p);
        }
    }
    public void viewAllPeople(ActionEvent e) {
        ObservableList<Person> data = tableView.getItems();
        data.clear();
        for(Person p : sam.getAll()) {
            data.add(p);
        }
    }
    public void removePerson(ActionEvent e) {
        Person p;
        ObservableList<Person> row , allRows;
        allRows = tableView.getItems();
        row = tableView.getSelectionModel().getSelectedItems();

        if(isSelected(row)) {
            sam.removeFromDb(row.get(0));
            row.forEach(allRows::remove);
        } else {

        }
    }
    public void clearTable(ActionEvent e) {
        ObservableList<Person> data = tableView.getItems();
        data.clear();
    }
    private boolean isSelected(ObservableList<Person> row) {
        return row.get(0) != null;
    }
}
