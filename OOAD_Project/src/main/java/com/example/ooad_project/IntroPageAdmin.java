package com.example.ooad_project;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import com.example.ooad_project.Employee;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class IntroPageAdmin implements Initializable
{
    public JFXButton addNewProjectBtn;
    public JFXButton addEmployeeBtn;
    public JFXButton allEmployeeBtn;
    public JFXButton allProjectBtn;
    public Label projectCountLabel;
    public Label employeeCountLabel;
    public TableView<Project> projectTableView;
    public TableView<Employee> employeeTableView;
    public TableColumn<Project,String> projectName;
    public TableColumn<Project,String> projectStartDate;
    public TableColumn<Project,String> projectEndDate;
    public TableColumn<Employee,String> employeeId;
    public TableColumn<Employee, String> employeeName;
    public TableColumn<Employee, String> employeeDesignation;
    private int projectCount=0, employeeCount=0;
    private Stage stage;
    private void getProjectTableData()
    {
        projectTableView.getItems().clear();
        projectCount = 0;
        try
        {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT project_name, start_date, end_date FROM Projects";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
            {
                projectCount++;
                String projectName = rs.getString("project_name");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");

                Project singleProject = new Project(projectName,startDate,endDate);
                projectTableView.getItems().add(singleProject);
            }

            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        projectCountLabel.setText(String.valueOf(projectCount));
    }

    private void getEmployeeTableData()
    {
        //Clear the all column data from table
        employeeTableView.getItems().clear();
        employeeCount = 0;
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT Empid, EmpName, designation FROM Employee";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next())
            {
                employeeCount++;
                int emId = rs.getInt("id");
                String employeeName = rs.getString("name");
                String employeeDesignation = rs.getString("designation");

                String employeeId = String.valueOf(emId);

                Employee singleEmployee = new Employee(employeeId,employeeName,employeeDesignation);
                employeeTableView.getItems().add(singleEmployee);
            }
            statement.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        employeeCountLabel.setText(String.valueOf(employeeCount));
    }
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        projectName.setCellValueFactory(new PropertyValueFactory<>("projectName"));
        projectStartDate.setCellValueFactory(new PropertyValueFactory<>("projectStartDate"));
        projectEndDate.setCellValueFactory(new PropertyValueFactory<>("projectEndDate"));
        projectTableView.setEditable(false);
        employeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeName.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        employeeDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        employeeTableView.setEditable(false);
        getProjectTableData();
        getEmployeeTableData();
    }

    public void allProjectsBtnAction(ActionEvent event)
    {
        return;
/*        if(event.getSource() == allProjectBtn){
            FXMLLoader Loader = new FXMLLoader();

            Loader.setLocation(getClass().getResource("../ProjectSummary/projectsummary.fxml"));

            try {
                Loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }

            ProjectSummaryController projectSummaryController = Loader.getController();
            projectSummaryController.setUserRole(getUserRole());
            projectSummaryController.setAdminId(getAdminId());
            projectSummaryController.initializeProjects(getUserRole());

            Parent p = Loader.getRoot();
            stage = (Stage) allProjectsBtn.getScene().getWindow();
            Scene scene = new Scene(p);
            stage.setScene(scene);
            stage.show();
        }*/
    }

    public void addNewProjectBtnAction(ActionEvent event)
    {
        if(event.getSource() == addNewProjectBtn)
        {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("projectdetail.fxml"));
            try {
                Loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProjectDetailController projectDetailController = Loader.getController();
            Parent p = Loader.getRoot();
            stage = (Stage) addNewProjectBtn.getScene().getWindow();
            Scene scene = new Scene(p);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void allEmployeeBtnAction(ActionEvent event)
    {
        return;
/*        if(event.getSource() == allEmployeeBtn)
        {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("../AllEmployee/allemployee.fxml"));
            try {
                Loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            AllEmployeeController allEmpController = Loader.getController();
            allEmpController.setUserRole(getUserRole());
            allEmpController.setAdminId(getAdminId());
            Parent p = Loader.getRoot();
            stage = (Stage) allEmployeeBtn.getScene().getWindow();
            Scene scene = new Scene(p);
            stage.setScene(scene);
            stage.show();
        }*/
    }

    public void addEmployeeBtnAction(ActionEvent event)
    {
        return;
/*        if (event.getSource() == addEmployeeBtn)
        {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("../AddEmployee/AddEmployee.fxml"));
            try {
                Loader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Parent p = Loader.getRoot();
            Stage stage = new Stage();
            Scene scene = new Scene(p);
            stage.setScene(scene);
            stage.showAndWait();
        }*/
    }
}