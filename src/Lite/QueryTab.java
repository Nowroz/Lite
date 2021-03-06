package Lite;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Nowroz Islam on 12/1/2017
 * @project Lite
 */
public class QueryTab {
    static Tab queryTab;
    static TextArea statementField;
    static Button run;
    static Label label;
    static void initiate(){
        queryTab=new Tab("Execute SQL");
        AnchorPane pane=new AnchorPane();
        statementField=new TextArea();
        run=new Button("Run");
        label=new Label("Write your query here:");
        AnchorPane.setTopAnchor(label,30.0);
        AnchorPane.setLeftAnchor(label,7.0);
        AnchorPane.setTopAnchor(statementField,50.0);
        AnchorPane.setLeftAnchor(statementField,5.0);
        AnchorPane.setBottomAnchor(run,2.0);
        AnchorPane.setRightAnchor(run,2.0);
        pane.getChildren().addAll(label,statementField,run);
        pane.setMinWidth(780);
        queryTab.setContent(pane);
        run.setDefaultButton(true);
        run.setMinWidth(200);
        run.setOnAction(e->{
            try{
                if(Connection.conn!=null){
                    Statement statement=Connection.conn.createStatement();
                    String query=statementField.getText();
                    statement.execute(query);
                    String [] check=query.split(" ");
                    if (check[0].equals("select") || check[0].equals("SELECT")){
                        ResultSet resultSet=statement.getResultSet();
                        DisplayData.display(resultSet,check[2]);
                    }
                    statement.close();
                }
            }catch(SQLException ex){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Oops!");
                alert.setHeaderText(null);
                alert.setContentText("Can't execute the query: "+ex);
                alert.showAndWait();
            }
        });
    }
}
