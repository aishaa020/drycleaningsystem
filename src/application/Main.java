package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import static javafx.stage.Modality.NONE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.converter.IntegerStringConverter;


/**
 * A JavaFX ConnectDB Application
 */
public class Main extends Application {
	/**
	 * @param args the command line arguments
	 * 
	 * 
	 */
	private static ArrayList<Customer> datac = new ArrayList<>();
	private static ObservableList<Customer> dataListc;

	private static ArrayList<String> customername = new ArrayList<>();
	private static ObservableList<String> customernames;

	private static ArrayList<Customer_order> order = new ArrayList<>();
	private static ObservableList<Customer_order> orderslist;

	private static ArrayList<Item_instance> items = new ArrayList<>();
	private static ObservableList<Item_instance> itemslist;

	private static ArrayList<Serv_cloth> datas = new ArrayList<>();
	private static ObservableList<Serv_cloth> dataLists;

	private static ObservableList<Serv_cloth> drycleanlist;
	private static ArrayList<Serv_cloth> dryclean = new ArrayList<>();

	private static ObservableList<Serv_cloth> drynironlist;
	private static ArrayList<Serv_cloth> drycleanniron = new ArrayList<>();

	private static ObservableList<Serv_cloth> ironlist;
	private static ArrayList<Serv_cloth> iron = new ArrayList<>();
	
	private ArrayList<Employee> datae = new ArrayList<>();
	private ObservableList<Employee> dataListe;
	
	private ArrayList<Bill> datab = new ArrayList<>();
	private ObservableList<Bill> dataListb;
	
	private ArrayList<Pays> datap = new ArrayList<>();
	private ObservableList<Pays> dataListp;

	private static FilteredList<String> filteredData;
	private static Scene scene1;

	private static int paycount = 199;
	private static int billcount = 19;
	private static int count = 1;
	private static int counte = 9;
	private static int ordernum = 100;
	private String dbURL;
	private String dbUsername = "root";
	private String dbPassword = "1202347";
	private String URL = "127.0.0.1";
	private String port = "3306";
	private String dbName = "dryclean1";
	private Connection con;
	private static final String ADMIN_USERNAME = "aisha";
	private static final String ADMIN_PASSWORD = "1";
	private static final String IMAGE_PATH = "C:\\Users\\iFix\\Desktop\\DataBase\\WhatsApp 7_9_2023 5_23_39 PM.png";

	Font font3 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 55);
	Font font1 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 42);
	Font font2 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 16);
	Font font0 = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 14);

	@Override
	public void start(Stage primaryStage) throws ClassNotFoundException, SQLException {


		getDatasc();
		//getData();
		//getDataitem();
//		getDatab();
//		dataListb = FXCollections.observableArrayList(datab);
//    	getDatap();
//		dataListp = FXCollections.observableArrayList(datap);

//	    orderslist = FXCollections.observableArrayList(order);
		//getDatae();
		//dataListe = FXCollections.observableArrayList(datae);
		
		//dataListc = FXCollections.observableArrayList(datac);
		dataLists = FXCollections.observableArrayList(datas);
		//customernames = FXCollections.observableArrayList(customername);
		
		itemslist = FXCollections.observableArrayList(items);
		

//		ctableview(primaryStage);
//		primaryStage.show();
		
		
		Image image = new Image(IMAGE_PATH);
		ImageView imageView = new ImageView(image);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5.5);
        grid.setHgap(5.5);

        
        Text usernameLabel = new Text("Username:");
        usernameLabel.setFont(font2);
       
        TextField usernameField = new TextField();
        usernameField.setPrefWidth(110);
        usernameField.setMaxWidth(110);
      

        // Add password label and password field
        Text passwordLabel = new Text("Password:");
        passwordLabel.setFont(font2);
        
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefWidth(110);
        passwordField.setMaxWidth(110);
       

        // Add login button
        Button loginButton = new Button("Login");
        loginButton.setMinSize(100, 20);
        loginButton.setFont(font0);
        loginButton.setStyle("-fx-background-color: #1cbeff; ;");
        
        HBox hb1 = new HBox();
        hb1.setSpacing(15);
        hb1.getChildren().addAll(usernameLabel, usernameField );
        
        HBox hb2 = new HBox();
        hb2.setSpacing(15);
        hb2.getChildren().addAll(passwordLabel, passwordField );
        
        VBox vb = new VBox();
        vb.setSpacing(15);
        vb.getChildren().addAll(hb1, hb2, loginButton);
        vb.setAlignment(Pos.CENTER);
        
        
        grid.add(vb, 0, 0);
        grid.add(loginButton, 0, 1);
       
        
        
        

        // Add event handling to the login button
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                // Successful login, display a message
                showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, Admin!");
                try {
    				orders(primaryStage);
    			} catch (ClassNotFoundException | SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        		primaryStage.show();
                
            } else {
                // Invalid credentials, display an error message
                showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
            }

            // Clear the input fields
            usernameField.clear();
            passwordField.clear();
            
           
        });
        

       StackPane sp = new StackPane();
       sp.getChildren().addAll(imageView, grid);

        Scene scene = new Scene(sp, 620, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

	@SuppressWarnings("unchecked")
	// tableview for customers
	public void ctableview(Stage stage) {

		TableView<Customer> ctable = new TableView<Customer>();

		Label l1 = new Label("customer table");
		l1.setFont(new Font("Arial", 20));
		l1.setTextFill(Color.BLUEVIOLET);

		ctable.setEditable(true);
		ctable.setMaxHeight(300);
		ctable.setMaxWidth(800);

		TableColumn<Customer, Integer> cid = new TableColumn<Customer, Integer>("customer_id");

		cid.setMinWidth(50);
		cid.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customer_id"));

		///////////////////////////////////////////////////////////////////////////

		TableColumn<Customer, String> cname = new TableColumn<Customer, String>("customer_name");

		cname.setMinWidth(50);
		cname.setCellValueFactory(new PropertyValueFactory<Customer, String>("customer_name"));
		cname.setCellFactory(TextFieldTableCell.forTableColumn());

		cname.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
			((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setCustomer_name(t.getNewValue()); // display only
			try {
				UpdateName(t.getRowValue().getCustomer_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		//////////////////////////////////////////////////////////////////////////

		TableColumn<Customer, String> caddy = new TableColumn<Customer, String>("address");

		caddy.setMinWidth(50);
		caddy.setCellValueFactory(new PropertyValueFactory<Customer, String>("address"));
		caddy.setCellFactory(TextFieldTableCell.forTableColumn());
		caddy.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
			((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setAddress(t.getNewValue()); 
																														
			try {
				UpdateAddress(t.getRowValue().getCustomer_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		//////////////////////////////////////////////////////////////////////////

		TableColumn<Customer, String> cphone = new TableColumn<Customer, String>("phone");

		cphone.setMinWidth(50);
		cphone.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
		cphone.setCellFactory(TextFieldTableCell.forTableColumn());
		cphone.setOnEditCommit((CellEditEvent<Customer, String> t) -> {
			((Customer) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPhone(t.getNewValue()); 
																													
			try {
				UpdatePhone(t.getRowValue().getCustomer_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		//////////////////////////////////////////////

		ctable.setItems(dataListc);

		ctable.getColumns().addAll(cid, cname, cphone, caddy);

		final TextField addcid = new TextField();
		addcid.setPrefWidth(110);
		addcid.setMaxWidth(110);
		addcid.setPromptText("customer_id");
		addcid.setMaxWidth(cname.getPrefWidth());

		final TextField addcname = new TextField();
		addcname.setPrefWidth(110);
		addcname.setMaxWidth(110);
		addcname.setPromptText("customer_name");
		addcname.setMaxWidth(cname.getPrefWidth());

		final TextField addcaddy = new TextField();
		addcaddy.setPrefWidth(110);
		addcaddy.setMaxWidth(110);
		addcaddy.setPromptText("customer_phone");
		addcaddy.setMaxWidth(caddy.getPrefWidth());

		final TextField addcphone = new TextField();
		addcphone.setPrefWidth(110);
		addcphone.setMaxWidth(110);
		addcphone.setPromptText("customer_address");
		addcphone.setMaxWidth(cphone.getPrefWidth());

		final Button addButton = new Button("Add");
		addButton.setMinSize(100, 20);
		addButton.setFont(font0);
		addButton.setStyle("-fx-background-color: #1cbeff; ;");
		addButton.setOnAction(e -> {
			Customer rc;
			rc = new Customer(Integer.parseInt(addcid.getText()), addcname.getText(), addcphone.getText(),
					addcaddy.getText());
			dataListc.add(rc);
			insertDatac(rc);
			addcname.clear();
			addcaddy.clear();
			addcphone.clear();

		});

		final Button deleteButton = new Button("Delete");
		deleteButton.setMinSize(100, 20);
		deleteButton.setFont(font0);
		deleteButton.setStyle("-fx-background-color: #1cbeff; ;");
		deleteButton.setOnAction(e -> {
			ObservableList<Customer> selectedRows = ctable.getSelectionModel().getSelectedItems();
			ArrayList<Customer> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				ctable.getItems().remove(row);
				deletec(row);
				ctable.refresh();
			});
		});

		final Button refreshButton = new Button("Refresh");
		refreshButton.setMinSize(100, 20);
		refreshButton.setFont(font0);
		refreshButton.setStyle("-fx-background-color: #1cbeff; ;");
		refreshButton.setOnAction(e -> {
			ctable.refresh();
		});

		Text ta1 = new Text("Find the number of customers");
		ta1.setFont(font2);

		TextField txt1 = new TextField();
		txt1.setPrefWidth(110);
		txt1.setMaxWidth(110);
		txt1.setPromptText("#");

		Button btn1 = new Button("Find");
		btn1.setFont(font0);
		btn1.setStyle("-fx-background-color: #1cbeff;");
		btn1.setMinSize(100, 20);

		btn1.setOnAction(e -> {
			ArrayList<String> data2 = new ArrayList<>();
			try {
				connectDB();
				Statement s1 = con.createStatement();
				ResultSet rs = s1.executeQuery("select Count(customer_id) from customer ;");
				while (rs.next()) {
					data2.add(rs.getString(1));
				}
				txt1.setText(data2.get(0));

				rs.close();
				s1.close();
				con.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		Text ta2 = new Text("Find the customer phone # using their id");
		ta2.setFont(font2);

		TextField txt2 = new TextField();
		txt2.setPrefWidth(110);
		txt2.setMaxWidth(110);
		txt2.setPromptText("id#");

		TextField txt3 = new TextField();
		txt3.setPrefWidth(110);
		txt3.setPromptText("result");
		txt3.setMaxWidth(110);

		Button btn2 = new Button("Find");
		btn2.setFont(font0);
		btn2.setStyle("-fx-background-color: #1cbeff;");
		btn2.setMinSize(100, 20);

		btn2.setOnAction(e -> {
			ArrayList<String> data2 = new ArrayList<>();
			try {
				connectDB();
				Statement s1 = con.createStatement();
				ResultSet rs = s1.executeQuery(
						"select phone from customer where customer_id =" + Integer.parseInt(txt2.getText()) + ";");
				while (rs.next()) {
					data2.add(rs.getString(1));
				}
				txt3.setText(data2.get(0));

				rs.close();
				s1.close();
				con.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		Text ta3 = new Text("Find the id and name of the customers that have debt");
		ta3.setFont(font2);

		TextArea cu = new TextArea();
		cu.setMaxSize(300, 100);

		Button btn3 = new Button("Find");
		btn3.setFont(font0);
		btn3.setStyle("-fx-background-color: #1cbeff;");
		btn3.setMinSize(100, 20);

		btn3.setOnAction(e -> {
			ArrayList<String> data2 = new ArrayList<>();
			int count = 0;
			try {
				connectDB();
				Statement s1 = con.createStatement();
				ResultSet rs = s1.executeQuery(
						"select c.customer_id, c.customer_name from customer c, bill b, pays p where c.customer_id = b.customer_id and"
								+ " b.customer_id = p.customer_id and p.payment = 'false';");
				while (rs.next()) {
					data2.add("customer id: " + rs.getString(1) + " " + "customer name:" + rs.getString(2));
					cu.setText(data2.get(count) + "\n");
					count++;
				}

				rs.close();
				s1.close();
				con.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

		final Button back = new Button("back");
		back.setMinSize(100, 20);
		back.setFont(font0);
		back.setStyle("-fx-background-color: #1cbeff; ;");
		back.setOnAction(e -> {
			stage.setScene(scene1);
			stage.show();
		}); 
		
		GridPane gr = new GridPane();
		gr.setHgap(5.5);
		gr.setVgap(5.5);
		gr.setAlignment(Pos.CENTER);

		Text title = new Text("Customers");
		title.setFont(font1);

		HBox hb1 = new HBox();
		hb1.setSpacing(15);
		hb1.getChildren().addAll(back, deleteButton, refreshButton);

		ctable.setStyle("-fx-background-color: #1cbeff; ");
		VBox vb1 = new VBox();
		vb1.setSpacing(15);
		vb1.getChildren().addAll(ctable, hb1);
		vb1.setLayoutX(850);
		vb1.setLayoutY(600);

		HBox hb2 = new HBox(10);
		hb2.setSpacing(15);
		hb2.getChildren().addAll(addcid, addcname, addcaddy, addcphone, addButton);

		HBox hb3 = new HBox(10);
		hb3.setSpacing(15);
		hb3.getChildren().addAll(txt1, btn1);

		HBox hb4 = new HBox(10);
		hb4.setSpacing(15);
		hb4.getChildren().addAll(txt2, txt3, btn2);

		HBox hb5 = new HBox(10);
		hb5.setSpacing(15);
		hb5.getChildren().addAll(cu, btn3);

		VBox vb2 = new VBox();
		vb2.setSpacing(15);
		vb2.getChildren().addAll(hb2, ta1, hb3, ta2, hb4, ta3, hb5);

		gr.add(title, 0, 0);
		gr.add(vb1, 0, 2);
		gr.add(vb2, 5, 2);
		ctable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		gr.setVgrow(ctable, Priority.ALWAYS);
		vb1.setVgrow(ctable, Priority.ALWAYS);

		Scene scene = new Scene(gr, 900, 600);
		stage.setTitle("customer");
		stage.setScene(scene);

	}

//getdata for customers
	private void getData() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		String SQL;

		connectDB();
		System.out.println("Connection established");

		SQL = "select * from customer order by customer_id";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);

		while (rs.next()) {
			datac.add(
					new Customer(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(4), rs.getString(3)));
			customername.add(rs.getString(2));

		}
		rs.close();
		stmt.close();

		con.close();
		// System.out.println(customername);
		System.out.println("Connection closed" + datac.size());

	}

	private void connectDB() throws ClassNotFoundException, SQLException {

		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");

		con = DriverManager.getConnection(dbURL, p);

	}

	public void ExecuteStatement(String SQL) throws SQLException {

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(SQL);
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
			System.out.println("SQL statement is not executed!");

		}

	}

	// update customer name
	public void UpdateName(int customer_id, String customer_name) throws ClassNotFoundException {
		try {
			System.out.println(
					"Update customer Set customer_name =" + customer_name + "Where customer_id=" + customer_id);
			connectDB();
			ExecuteStatement("update customer set customer_name = '" + customer_name + "'where customer_id= "
					+ customer_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdateAddress(int customer_id, String address) throws ClassNotFoundException {
		try {
			System.out.println(
					"update customer set address = '" + address + "' where customer_id= " + customer_id + " ;");
			connectDB();
			ExecuteStatement(
					"update customer set address = '" + address + "' where customer_id= " + customer_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdatePhone(int customer_id, String phone) throws ClassNotFoundException {
		try {
			System.out.println("update customer set phone = '" + phone + "' where customer_id= " + customer_id + " ;");
			connectDB();
			ExecuteStatement("update customer set phone = '" + phone + "' where customer_id= " + customer_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deletec(Customer row) {
		try {
			System.out.println("delete from  customer where customer_id=" + row.getCustomer_id() + ";");
			connectDB();
			ExecuteStatement("delete from  customer where customer_id=" + row.getCustomer_id() + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertDatac(Customer rc) {

		try {
			System.out.println(
					"Insert into customer (customer_id, customer_name, address, phone) values(" + rc.getCustomer_id()
							+ ",'" + rc.getCustomer_name() + "','" + rc.getAddress() + "','" + rc.getPhone() + "');");

			connectDB();
			ExecuteStatement(
					"Insert into customer (customer_id, customer_name, address, phone) values(" + rc.getCustomer_id()
							+ ",'" + rc.getCustomer_name() + "','" + rc.getAddress() + "','" + rc.getPhone() + "');");
			con.close();
			System.out.println("Connection closed" + datac.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// get data for serv_cloth

	private void getDatasc() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection Sucssed");
		SQL = "select * from serv_cloth ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		while (rs.next())
			// System.out.println(rs.getString(3));

			datas.add(new Serv_cloth(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3))));
		rs.close();
		st.close();
		con.close();
	}

	private void getDatadry() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection Sucssed");
		SQL = "select * from serv_cloth s where s.service_type = 'dry cleaning';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		while (rs.next())
			// System.out.println(rs.getString(3));

			dryclean.add(new Serv_cloth(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3))));
		rs.close();
		st.close();
		con.close();
	}

	private void getDatadryniron() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection Sucssed");
		SQL = "select * from serv_cloth s where s.service_type = 'dry cleaning and ironing';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		while (rs.next())
			// System.out.println(rs.getString(3));

			drycleanniron.add(new Serv_cloth(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3))));
		rs.close();
		st.close();
		con.close();
	}

	private void getDatairon() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection Sucssed");
		SQL = "select * from serv_cloth s where s.service_type = 'ironing';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		while (rs.next())
			// System.out.println(rs.getString(3));

			iron.add(new Serv_cloth(rs.getString(1), rs.getString(2), Integer.parseInt(rs.getString(3))));
		rs.close();
		st.close();
		con.close();
	}

	private MenuItem[] getMenuItems(ObservableList<String> items, TextField textField) {
		MenuItem[] menuItems = new MenuItem[items.size()];
		for (int i = 0; i < items.size(); i++) {
			String item = items.get(i);
			MenuItem menuItem = new MenuItem(item);
			menuItem.setOnAction(event -> {
				textField.setText(item);
			});
			menuItems[i] = menuItem;
		}
		return menuItems;
	}

	// get data for customer order
	private void getDataco() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection Sucssed");
		SQL = "select * from customer_order order by order_id ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		while (rs.next())
			// System.out.println(rs.getString(3));

			order.add(new Customer_order(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),
					rs.getString(3)));
		rs.close();
		st.close();
		con.close();
	}

	// get data for item instance
	private void getDatains() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection Sucssed");
		SQL = "select * from item_instance order by item_id ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		while (rs.next())
			// System.out.println(rs.getString(3));

			items.add(new Item_instance(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),
					Integer.parseInt(rs.getString(3)), rs.getString(4), rs.getString(5),
					Integer.parseInt(rs.getString(6)), Integer.parseInt(rs.getString(7)),
					Integer.parseInt(rs.getString(8))));
		rs.close();
		st.close();
		con.close();
	}

	// get data for customer order
	private void getDataitem() throws SQLException, ClassNotFoundException {
		String SQL;
		connectDB();
		System.out.println("Connection Sucssed");
		SQL = "select * from customer_order order by order_id ";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		while (rs.next())
			// System.out.println(rs.getString(3));

			order.add(new Customer_order(Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)),
					rs.getString(3)));
		rs.close();
		st.close();
		con.close();
	}

	public void deleteitem(Item_instance row) {
		try {
			System.out.println("delete from  item_instance where item_id =" + row.getItem_id() + ";");
			connectDB();
			ExecuteStatement("delete from  item_instance where item_id=" + row.getItem_id() + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void insertitems(Item_instance rc) {

		try {

			System.out.println(
					"Insert into item_instance (item_id, order_id, customer_id, item_type, service_type, service_cost, numberofitems, total_amount ) values("
							+ rc.getItem_id() + "," + rc.getOrder_id() + "," + rc.getCustomer_id() + ",'"
							+ rc.getItem_type() + "','" + rc.getService_type() + "'," + rc.getService_cost() + ","
							+ rc.getNumberofitems() + "," + rc.getTotal_amount() + ");");

			connectDB();
			ExecuteStatement(
					"Insert into item_instance (item_id, order_id, customer_id, item_type, service_type, service_cost, numberofitems, total_amount ) values("
							+ rc.getItem_id() + "," + rc.getOrder_id() + "," + rc.getCustomer_id() + ",'"
							+ rc.getItem_type() + "','" + rc.getService_type() + "'," + rc.getService_cost() + ","
							+ rc.getNumberofitems() + "," + rc.getTotal_amount() + ");");
			items.add(rc);
			con.close();
			System.out.println("Connection closed" + items.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void Updateorderid(int item_id, int order_id) throws ClassNotFoundException {
		try {
			System.out.println("update item_instance set order_id = " + order_id + " where item_id= " + item_id + " ;");
			connectDB();
			ExecuteStatement("update item_instance set order_id = " + order_id + " where item_id= " + item_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Updatecustid(int item_id, int customer_id) throws ClassNotFoundException {
		try {
			System.out.println(
					"update item_instance set customer_id = " + customer_id + " where item_id= " + item_id + " ;");
			connectDB();
			ExecuteStatement(
					"update item_instance set customer_id = " + customer_id + " where item_id= " + item_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Updateitemnum(int item_id, int numberofitems) throws ClassNotFoundException {
		try {
			System.out.println(
					"update item_instance set numberofitems = " + numberofitems + " where item_id= " + item_id + " ;");
			connectDB();
			ExecuteStatement(
					"update item_instance set numberofitems = " + numberofitems + " where item_id= " + item_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Updatetotal(int item_id, int total_amount) throws ClassNotFoundException {
		try {
			System.out.println(
					"update item_instance set total_amount = " + total_amount + " where item_id= " + item_id + " ;");
			connectDB();
			ExecuteStatement(
					"update item_instance set total_amount = " + total_amount + " where item_id= " + item_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void orders(Stage stage) throws ClassNotFoundException, SQLException {

		Label l1 = new Label("DATE");
		l1.setFont(new Font("Arial", 20));
		l1.setTextFill(Color.BLUEVIOLET);

		TextField txt1 = new TextField();
		txt1.setPrefWidth(110);
		txt1.setMaxWidth(110);
		LocalDate currentLocalDateTime = LocalDate.now();

		// Create DateTimeFormatter instance with specified format
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd ");

		// Format LocalDateTime to String
		String formattedDateTime = currentLocalDateTime.format(dateTimeFormatter);

		txt1.setText(formattedDateTime);

		Label l2 = new Label("Customers");
		l2.setFont(new Font("Arial", 20));
		l2.setTextFill(Color.BLUEVIOLET);

		TextField txt2 = new TextField();
		txt2.setPrefWidth(110);
		txt2.setMaxWidth(110);

		TableView<Serv_cloth> sctable = new TableView<Serv_cloth>();

		stage.setTitle("serv_cloth");


		Label l3 = new Label("service and clothing items ");
		l3.setFont(new Font("Arial", 20));
		l3.setTextFill(Color.BLUEVIOLET);

		sctable.setEditable(true);
		sctable.setMaxHeight(600);
		sctable.setMaxWidth(600);

		TableColumn<Serv_cloth, String> stype = new TableColumn<Serv_cloth, String>("service_type");

		stype.setMinWidth(120);
		stype.setCellValueFactory(new PropertyValueFactory<Serv_cloth, String>("service_type"));
		///////////////////////////////

		TableColumn<Serv_cloth, String> itype = new TableColumn<Serv_cloth, String>("item_type");

		itype.setMinWidth(120);
		itype.setCellValueFactory(new PropertyValueFactory<Serv_cloth, String>("item_type"));
		///////////////////////////////

		TableColumn<Serv_cloth, Integer> scost = new TableColumn<Serv_cloth, Integer>("service_cost");

		scost.setMinWidth(120);
		scost.setCellValueFactory(new PropertyValueFactory<Serv_cloth, Integer>("service_cost"));
		//////////////////////////////

		ContextMenu resultsMenu = new ContextMenu();
		getData();
		customernames = FXCollections.observableArrayList(customername);
		filteredData = new FilteredList<>(customernames, p -> true);
		txt2.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(item -> {
				if (newValue == null || newValue.isEmpty()) {
					return true; // Show all items when the search field is empty
				}
				String lowerCaseFilter = newValue.toLowerCase();
				return item.toLowerCase().contains(lowerCaseFilter);
			});

			if (newValue != null && !newValue.isEmpty()) {
				// Show the search results when the text field is not empty
				resultsMenu.getItems().clear();
				resultsMenu.getItems().addAll(getMenuItems(filteredData, txt2));
				resultsMenu.show(txt2, Side.BOTTOM, 0, 0);

			} else {
				resultsMenu.hide();
			}

		});

		VBox root = new VBox(txt2);

		sctable.getColumns().addAll(stype, itype, scost);
		sctable.setStyle("-fx-background-color: #1cbeff; ");
		sctable.setItems(dataLists);

		Button btn1 = new Button("Drycleaning");
		btn1.setMinSize(100, 20);
		btn1.setFont(font0);
		btn1.setStyle("-fx-background-color: #1cbeff; ;");

		btn1.setOnAction(e -> {
			sctable.getItems().clear();

			try {
				getDatadry();
				drycleanlist = FXCollections.observableArrayList(dryclean);
				sctable.setItems(drycleanlist);

			} catch (Exception e2) {
				// TODO: handle exception
			}

		});

		Button btn2 = new Button("drycleaning & Ironing");
		btn2.setMinSize(100, 20);
		btn2.setFont(font0);
		btn2.setStyle("-fx-background-color: #1cbeff; ;");

		btn2.setOnAction(e -> {
			sctable.getItems().clear();

			try {
				getDatadryniron();
				drynironlist = FXCollections.observableArrayList(drycleanniron);
				sctable.setItems(drynironlist);

			} catch (Exception e2) {
				// TODO: handle exception
			}

		});

		Button btn3 = new Button("Ironing");
		btn3.setMinSize(100, 20);
		btn3.setFont(font0);
		btn3.setStyle("-fx-background-color: #1cbeff; ;");

		btn3.setOnAction(e -> {

			try {
				getDatairon();
				ironlist = FXCollections.observableArrayList(iron);
				sctable.setItems(ironlist);

			} catch (Exception e2) {
				// TODO: handle exception
			}
		});

		TableView<Item_instance> otable = new TableView<Item_instance>();
		otable.setEditable(true);
		otable.setMaxHeight(800);
		otable.setMaxWidth(800);

		TableColumn<Item_instance, Integer> item_id = new TableColumn<Item_instance, Integer>("item_id");

		item_id.setMinWidth(100);
		item_id.setCellValueFactory(new PropertyValueFactory<Item_instance, Integer>("item_id"));

		///////////////////////////////

		TableColumn<Item_instance, Integer> cid = new TableColumn<Item_instance, Integer>("customer_id");

		cid.setMinWidth(100);
		cid.setCellValueFactory(new PropertyValueFactory<Item_instance, Integer>("customer_id"));

		cid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		cid.setOnEditCommit((CellEditEvent<Item_instance, Integer> t) -> {
			((Item_instance) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setCustomer_id(t.getNewValue()); // display
			// only
			try {
				Updatecustid(t.getRowValue().getItem_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		///////////////////////////////

		TableColumn<Item_instance, Integer> oid = new TableColumn<Item_instance, Integer>("order_id");

		oid.setMinWidth(100);
		oid.setCellValueFactory(new PropertyValueFactory<Item_instance, Integer>("order_id"));

		oid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		oid.setOnEditCommit((CellEditEvent<Item_instance, Integer> t) -> {
			((Item_instance) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setOrder_id(t.getNewValue()); // display
			// only
			try {
				Updateorderid(t.getRowValue().getItem_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		//////////////////////////////

		TableColumn<Item_instance, String> sertype = new TableColumn<Item_instance, String>("service_type");

		sertype.setMinWidth(100);
		sertype.setCellValueFactory(new PropertyValueFactory<Item_instance, String>("service_type"));

		///////////////////////////////

		TableColumn<Item_instance, String> ittype = new TableColumn<Item_instance, String>("item_type");

		ittype.setMinWidth(100);
		ittype.setCellValueFactory(new PropertyValueFactory<Item_instance, String>("item_type"));
		//////////////////////////////

		TableColumn<Item_instance, Integer> cost = new TableColumn<Item_instance, Integer>("service_cost");

		cost.setMinWidth(100);
		cost.setCellValueFactory(new PropertyValueFactory<Item_instance, Integer>("service_cost"));
		//////////////////////////////

		TableColumn<Item_instance, Integer> itnum = new TableColumn<Item_instance, Integer>("numberofitems");

		itnum.setMinWidth(100);
		itnum.setCellValueFactory(new PropertyValueFactory<Item_instance, Integer>("numberofitems"));
		

		itnum.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		itnum.setOnEditCommit((CellEditEvent<Item_instance, Integer> t) -> {
			((Item_instance) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setNumberofitems(t.getNewValue()); // display
			// only
			try {
				Updateitemnum(t.getRowValue().getItem_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		//////////////////////////////

		TableColumn<Item_instance, Integer> total = new TableColumn<Item_instance, Integer>("total_amount");

		total.setMinWidth(100);
		total.setCellValueFactory(new PropertyValueFactory<Item_instance, Integer>("total_amount"));

		total.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

		total.setOnEditCommit((CellEditEvent<Item_instance, Integer> t) -> {
			((Item_instance) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setTotal_amount(t.getNewValue()); // display
			// only
			try {
				Updatetotal(t.getRowValue().getItem_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		//////////////////////////////

		otable.setItems(itemslist);
		otable.setStyle("-fx-background-color: #1cbeff; ");
		otable.getColumns().addAll(item_id, cid, oid, sertype, ittype, cost, itnum, total);
		
		Button coscene = new Button("orders");
		coscene.setMinSize(100, 20);
		coscene.setFont(font0);
		coscene.setStyle("-fx-background-color: #f5ff0a; ;");
		
		getDataitem();
		orderslist = FXCollections.observableArrayList(order);
		coscene.setOnAction(e ->{
//			try {
//				
//			} catch (ClassNotFoundException | SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			//
			cotableview(stage);
			
			//stage.show();
			
			
		});
		//getData();
		dataListc = FXCollections.observableArrayList(datac);
		
		Button cuscene = new Button("CUSTOMERS");
		cuscene.setMinSize(100, 20);
		cuscene.setFont(font0);
		cuscene.setStyle("-fx-background-color: #f5ff0a; ;");
		
		cuscene.setOnAction(e ->{
			
			ctableview(stage);
			
			
			
			
		});
		
		getDatae();
		dataListe = FXCollections.observableArrayList(datae);
		Button escene = new Button("EMPLOYEES");
		escene.setMinSize(100, 20);
		escene.setFont(font0);
		escene.setStyle("-fx-background-color: #f5ff0a; ;");
		
		escene.setOnAction(e ->{
			
			
			etableview(stage);
			
			
			
			
		});
		
		getDatab();
		dataListb = FXCollections.observableArrayList(datab);
		
		Button bscene = new Button("BILLS");
		bscene.setMinSize(100, 20);
		bscene.setFont(font0);
		bscene.setStyle("-fx-background-color: #f5ff0a; ;");
		
		bscene.setOnAction(e ->{
			
			btableview(stage);
			
		
			
			
		});
		getDatap();
		dataListp = FXCollections.observableArrayList(datap);
		
		Button pscene = new Button("PAYMENT");
		pscene.setMinSize(100, 20);
		pscene.setFont(font0);
		pscene.setStyle("-fx-background-color: #f5ff0a; ;");
		
		pscene.setOnAction(e ->{
			
			
			ptableview(stage);
			
			
			
			
		});
		
		HBox other = new HBox();
		other.setSpacing(15);
		other.getChildren().addAll(coscene, cuscene, escene, bscene, pscene);
		
		
		
		

		Button btn4 = new Button("CREATE ORDER");
		btn4.setMinSize(100, 20);
		btn4.setFont(font0);
		btn4.setStyle("-fx-background-color: #1cbeff; ;");

		TextField txt3 = new TextField();
		txt3.setPrefWidth(110);
		txt3.setMaxWidth(110);
		txt3.setPromptText("order#");

		HBox hb = new HBox();
		hb.setSpacing(15);
		hb.getChildren().addAll(btn4, txt3);

		Button btn5 = new Button("ADD ITEM");
		btn5.setMinSize(100, 20);
		btn5.setFont(font0);
		btn5.setStyle("-fx-background-color: #1cbeff; ;");

		TextField txt4 = new TextField();
		txt4.setPrefWidth(110);
		txt4.setMaxWidth(110);
		txt4.setPromptText("# of items");

		VBox vb2 = new VBox();
		vb2.setSpacing(15);
		vb2.getChildren().addAll(btn5, txt4);
		
		TextField txt5 = new TextField();
		txt5.setPrefWidth(110);
		txt5.setMaxWidth(110);
		txt5.setPromptText("total");

		btn4.setOnAction(e -> {
			ArrayList<Integer> data2 = new ArrayList<>();
			//ordernum++;

			try {
				if(!orderslist.isEmpty()) {
					Customer_order lasItem = orderslist.get(orderslist.size() - 1);

					// Get the ID value from the last row
					int lastId = lasItem.getOrder_id() ;
					ordernum = lastId + 1;
				}
				connectDB();
				String str = txt2.getText();
				Statement s1 = con.createStatement();
				ResultSet rs = s1.executeQuery(
						"select c.customer_id from customer c " + "where c.customer_name = '" + str + "';");
				System.out.println(str);

				while (rs.next()) {
					data2.add(Integer.parseInt(rs.getString(1)));

				}
				Customer_order rc;
				rc = new Customer_order(ordernum, data2.get(0), txt1.getText());
				orderslist.add(rc);
				insertDataco(rc);
				txt3.setText(ordernum + "");

				rs.close();
				s1.close();
				con.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			

		});
		
		

		final Button deleteButton = new Button("Delete");
		deleteButton.setMinSize(100, 20);
		deleteButton.setFont(font0);
		deleteButton.setStyle("-fx-background-color: #1cbeff; ;");
		deleteButton.setOnAction(e -> {
			ObservableList<Item_instance> selectedRows = otable.getSelectionModel().getSelectedItems();
			ArrayList<Item_instance> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				otable.getItems().remove(row);
				deleteitem(row);
				otable.refresh();
			});
		});

		final Button refreshButton = new Button("Refresh");
		refreshButton.setMinSize(100, 20);
		refreshButton.setFont(font0);
		refreshButton.setStyle("-fx-background-color: #1cbeff; ;");
		refreshButton.setOnAction(e -> {
			otable.refresh();
		});

		final Button reset = new Button("Reset");
		reset.setMinSize(100, 20);
		reset.setFont(font0);
		reset.setStyle("-fx-background-color: #1cbeff; ;");
		reset.setOnAction(e -> {
			txt2.clear();
			txt3.clear();
			txt4.clear();
			txt5.clear();
            otable.getItems().clear();
			
		});

		btn5.setOnAction(e -> {

			ArrayList<String> data2 = new ArrayList<>();

			try {
				
				if(!items.isEmpty()) {
					Item_instance lasItem = items.get(items.size() - 1);

					// Get the ID value from the last row
					int lastId = lasItem.getItem_id();
					count = lastId + 1;
				}
				//count++;
				connectDB();
				String str = txt2.getText();
				Statement s1 = con.createStatement();
				ResultSet rs = s1.executeQuery(
						"select c.customer_id from customer c " + "where c.customer_name = '" + str + "';");
				System.out.println(str);

				while (rs.next()) {
					data2.add(rs.getString(1));
					System.out.println(rs.getString(1));
				}

				rs.close();
				s1.close();
				con.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			SelectionModel<Serv_cloth> selectionModel = sctable.getSelectionModel();

			
			Serv_cloth selectedItem = selectionModel.getSelectedItem();

			if (selectedItem != null) {
				
				String first = selectedItem.getService_type();
				String second = selectedItem.getItem_type();
				int third = selectedItem.getService_cost();

				Item_instance rc;
				rc = new Item_instance(count, ordernum, Integer.parseInt(data2.get(0)), first, second, third,
						Integer.parseInt(txt4.getText()), (Integer.parseInt(txt4.getText()) * (int) third));

				itemslist.add(rc);
				insertitems(rc);
				otable.setItems(itemslist);
//				System.out.println("Column 1 value: " + first);
//				System.out.println("Column 2 value: " + second);
//				System.out.println("Column 3 value: " + third);
				
			} else {
				
				System.out.println("No item selected.");
			}
			
			

		});
		
		
		
		
		Button btn = new Button("Calculate Bill");
		btn.setMinSize(100, 20);
		btn.setFont(font0);
		btn.setStyle("-fx-background-color: #1cbeff; ;");
		
		HBox ht = new HBox();
		ht.setSpacing(15);
		ht.getChildren().addAll(txt5, btn);
		
		CheckBox checkBox = new CheckBox("Payed");
		
		checkBox.setFont(font0);
		
		
		btn.setOnAction(e ->{
			ArrayList<String> data2 = new ArrayList<>();
			ArrayList<String> data3 = new ArrayList<>();
			ArrayList<String> data4 = new ArrayList<>();
			
			if(!dataListb.isEmpty() && !dataListp.isEmpty()) {
				Bill lastItem = dataListb.get(dataListb.size() - 1);

				// Get the ID value from the last row
				int lastId = lastItem.getBill_id() ;
				billcount = lastId + 1;
				
				Pays lasttItem = dataListp.get(dataListp.size() - 1);

				// Get the ID value from the last row
				int lasttId = lasttItem.getPayment_id();
				paycount = lasttId +1 ;
			}
			

			try {
				int s = Integer.parseInt(txt3.getText());
				connectDB();
				String str = txt2.getText();
				Statement s1 = con.createStatement();
				ResultSet rs = s1.executeQuery(
						"select sum(total_amount) from item_instance where order_id =" +s+ ";");
				System.out.println(str);

				while (rs.next()) {
					data2.add(rs.getString(1));
					
				}
				
				txt5.setText(data2.get(0));

				rs.close();
				s1.close();
				con.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				
				connectDB();
				String str = txt2.getText();
				Statement s1 = con.createStatement();
				ResultSet rs = s1.executeQuery(
						"select c.customer_id from customer c " + "where c.customer_name = '" + str + "';");
				System.out.println(str);

				while (rs.next()) {
					data3.add(rs.getString(1));
					System.out.println(rs.getString(1));
				}

				rs.close();
				s1.close();
				con.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			

			
			//.billcount++;

			
		Bill rc; 
		rc = new Bill(billcount,Integer.parseInt(txt3.getText()) , Integer.parseInt(data3.get(0)), Integer.parseInt(data2.get(0)));
		
		insertDatab(rc);
		dataListb.add(rc);
		
		
		
		
		String str1 = "";
		if(checkBox.isSelected())
			str1 += "true";
		else
			str1 += "false";
		
		try {
			
			connectDB();
			
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(
					"select employee_id from employee where employee_name = '"+ ADMIN_USERNAME +"';");
			

			while (rs.next()) {
				data4.add(rs.getString(1));
				System.out.println(rs.getString(1));
			}

			rs.close();
			s1.close();
			con.close();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	
		//paycount++;
		Pays pc; 
		pc = new Pays(paycount, billcount, Integer.parseInt(txt3.getText()), Integer.parseInt(data3.get(0)),Integer.parseInt(data4.get(0)) , txt1.getText(), str1  );
		insertDatap(pc);
		dataListp.add(pc);
		
		
	    dataListp = FXCollections.observableArrayList(datap);
			
			
		});
		
		

		
		
		
		
		GridPane gr = new GridPane();

		gr.setHgap(5.5);
		gr.setVgap(5.5);
		gr.setAlignment(Pos.TOP_LEFT);

		HBox hb1 = new HBox();
		hb1.setSpacing(15);

		hb1.getChildren().addAll(l1, txt1);

		HBox hb2 = new HBox();
		hb2.setSpacing(15);

		hb2.getChildren().addAll(l2, root);

		HBox hb3 = new HBox();
		hb3.setSpacing(15);
		hb3.getChildren().addAll(btn1, btn2, btn3);

		HBox delref = new HBox();
		delref.setSpacing(15);
		delref.getChildren().addAll(deleteButton, refreshButton,  reset, checkBox, ht);

		VBox vb = new VBox();
		vb.setSpacing(15);
		vb.getChildren().addAll(hb1, hb2, sctable);

		sctable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		gr.add(vb, 0, 0);
		gr.add(other, 5, 0);
		gr.add(hb, 5, 3);
		gr.add(sctable, 0, 4);
		gr.add(hb3, 0, 6);
		gr.add(vb2, 2, 4);
		gr.add(otable, 5, 4);
		gr.add(delref, 5, 6);
		

		scene1 = new Scene(gr, 1350, 700);
		stage.setScene(scene1);
		
	}

	// update customer_id for customer_order
	public void Updateco(int order_id, int customer_id) throws ClassNotFoundException {
		try {
			System.out.println(
					"update customer_order set customer_id = " + customer_id + " where order_id= " + order_id + " ;");
			connectDB();
			ExecuteStatement(
					"update customer_order set customer_id = " + customer_id + " where order_id= " + order_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// update order_date for customer_order
	public void Updatecd(int order_id, String order_date) throws ClassNotFoundException {
		try {
			System.out.println(
					"update customer_order set order_date = '" + order_date + "' where order_id= " + order_id + " ;");
			connectDB();
			ExecuteStatement(
					"update customer_order set order_date = '" + order_date + "' where order_id= " + order_id + " ;");
			con.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// delete customer_order
	public void deleteco(Customer_order row) {
		try {
			System.out.println("delete from  customer_order where order_id=" + row.getOrder_id() + ";");
			connectDB();
			ExecuteStatement("delete from  customer_order where order_id=" + row.getOrder_id() + ";");
			con.close();
			System.out.println("Connection closed");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	// insert in customerorder table
	private void insertDataco(Customer_order rc) {

		try {
			System.out.println("Insert into customer_order (order_id, customer_id, order_date) values("
					+ rc.getOrder_id() + "," + rc.getCustomer_id() + ",'" + rc.getOrder_date() + "');");

			connectDB();
			ExecuteStatement("Insert into customer_order (order_id, customer_id, order_date) values(" + rc.getOrder_id()
					+ "," + rc.getCustomer_id() + ",'" + rc.getOrder_date() + "');");
			con.close();
			System.out.println("Connection closed" + order.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// tableview for customer_order
	public void cotableview(Stage stage) {
		TableView<Customer_order> cotable = new TableView<Customer_order>();

		
		stage.setTitle("customer order");
		
		

		Label l1 = new Label("order table");
		l1.setFont(new Font("Arial", 20));
		l1.setTextFill(Color.BLUEVIOLET);

		cotable.setEditable(true);
		cotable.setMaxHeight(400);
		cotable.setMaxWidth(400);

		TableColumn<Customer_order, Integer> oid = new TableColumn<Customer_order, Integer>("order_id");

		oid.setMinWidth(100);
		oid.setCellValueFactory(new PropertyValueFactory<Customer_order, Integer>("order_id"));
		///////////////////////////////

		TableColumn<Customer_order, Integer> cid = new TableColumn<Customer_order, Integer>("customer_id");

		cid.setMinWidth(100);
		cid.setCellValueFactory(new PropertyValueFactory<Customer_order, Integer>("customer_id"));
		// cid.setCellFactory(TextFieldTableCell.forTableColumn());

		cid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		cid.setOnEditCommit((CellEditEvent<Customer_order, Integer> t) -> {
			((Customer_order) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setCustomer_id(t.getNewValue()); // display only
			try {
				Updateco(t.getRowValue().getOrder_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		///////////////////////////////

		TableColumn<Customer_order, String> odate = new TableColumn<Customer_order, String>("order_date");

		odate.setMinWidth(100);
		odate.setCellValueFactory(new PropertyValueFactory<Customer_order, String>("order_date"));
		odate.setCellFactory(TextFieldTableCell.forTableColumn());
        
		odate.setOnEditCommit((CellEditEvent<Customer_order, String> t) -> {
			((Customer_order) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setOrder_date(t.getNewValue()); // display only
			try {
				Updatecd(t.getRowValue().getOrder_id(), t.getNewValue());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		///////////////////////////////

		cotable.setItems(orderslist);

		cotable.setStyle("-fx-background-color: #1cbeff; ");
		cotable.getColumns().addAll(oid, cid, odate);

		final TextField addoid = new TextField();
		addoid.setPromptText("order_id");
		addoid.setMaxWidth(oid.getPrefWidth());

		final TextField addcid = new TextField();
		addcid.setPromptText("customer_id");
		addcid.setMaxWidth(cid.getPrefWidth());

		final TextField addodate = new TextField();
		addodate.setPromptText("order_date");
		addodate.setMaxWidth(odate.getPrefWidth());

		final Button addButton = new Button("Add");
		addButton.setMinSize(100, 20);
		addButton.setFont(font0);
		addButton.setStyle("-fx-background-color: #1cbeff; ;");

		addButton.setOnAction(e -> {
			Customer_order rc;
			rc = new Customer_order(Integer.valueOf(addoid.getText()), Integer.valueOf(addcid.getText()),
					addodate.getText());
			orderslist.add(rc);
			insertDataco(rc);
			addcid.clear();
			addodate.clear();

		});

		final Button deleteButton = new Button("Delete");
		deleteButton.setMinSize(100, 20);
		deleteButton.setFont(font0);
		deleteButton.setStyle("-fx-background-color: #1cbeff; ;");
		deleteButton.setOnAction(e -> {
			ObservableList<Customer_order> selectedRows = cotable.getSelectionModel().getSelectedItems();
			ArrayList<Customer_order> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				cotable.getItems().remove(row);
				deleteco(row);
				cotable.refresh();
			});
		});

		final Button refreshButton = new Button("Refresh");
		refreshButton.setMinSize(100, 20);
		refreshButton.setFont(font0);
		refreshButton.setStyle("-fx-background-color: #1cbeff; ;");
		refreshButton.setOnAction(e -> {
			cotable.refresh();
		});
		
		
		Text t = new Text("Get unpayed orders for this customer");
		t.setFont(font0);
		
	    TextField name = new TextField();
	    name.setPromptText("customer_name");
	    name.setPrefWidth(110);
	    name.setMaxWidth(110);
		
		Button btn1 = new Button("Find");
		btn1.setMinSize(100, 20);
		btn1.setFont(font0);
		btn1.setStyle("-fx-background-color: #1cbeff; ;");
		
		btn1.setOnAction(e ->{
			ArrayList<String> data2 = new ArrayList<>();
			try {
				int counter = 0 ;
				connectDB();
				Statement s1 = con.createStatement();
				ResultSet rs = s1.executeQuery("select o.order_id from customer_order o, pays p where o.order_id = p.order_id and  p.payment = 'false';");
				while (rs.next()) {
					
					data2.add(rs.getString(1));
					name.setText(data2.get(counter));
					counter++;
					
				}
			
				rs.close();
				s1.close();
				con.close();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			
		});
		
		Button back = new Button("Back");
		back.setMinSize(100, 20);
		back.setFont(font0);
		back.setStyle("-fx-background-color: #1cbeff; ;");
		
		back.setOnAction(e ->{
			stage.setScene(scene1);
			stage.show();
			
		});
		
		
		Text t1 = new Text("Get unpayed orders for this customer");
		t1.setFont(font0);
		
	    TextField name1 = new TextField();
	    name1.setPromptText("customer_name");
	    name1.setPrefWidth(110);
	    name1.setMaxWidth(110);
		
		Button btn2 = new Button("Find");
		btn2.setMinSize(100, 20);
		btn2.setFont(font0);
		btn2.setStyle("-fx-background-color: #1cbeff; ;");
		
		
		Text t2 = new Text("Get unpayed orders for this customer");
		t2.setFont(font0);
		
	    TextField name2 = new TextField();
	    name2.setPromptText("customer_name");
	    name2.setPrefWidth(110);
	    name2.setMaxWidth(110);
		
		Button btn3 = new Button("Find");
		btn3.setMinSize(100, 20);
		btn3.setFont(font0);
		btn3.setStyle("-fx-background-color: #1cbeff; ;");
		
		HBox hb2 = new HBox(10);
		hb2.setSpacing(15);
		hb2.getChildren().addAll( name, btn1);
		
		HBox hb3 = new HBox(10);
		hb3.setSpacing(15);
		hb3.getChildren().addAll( name1, btn2);

		HBox hb4 = new HBox(10);
		hb4.setSpacing(15);
		hb4.getChildren().addAll( name2, btn3);
		
		VBox vb2 = new VBox();
		vb2.setSpacing(15);
		vb2.getChildren().addAll(t, hb2, t1, hb3, t2, hb4);
		
		

		GridPane gr = new GridPane();
		gr.setHgap(5.5);
		gr.setVgap(5.5);
		gr.setAlignment(Pos.TOP_LEFT);
	
		Text title = new Text("Customer orders");
		title.setFont(font1);
		
		HBox hb1 = new HBox();
		hb1.setSpacing(15);
		hb1.getChildren().addAll(deleteButton, refreshButton, back);

		cotable.setStyle("-fx-background-color: #1cbeff; ");
		VBox vb1 = new VBox();
		vb1.setSpacing(15);
		vb1.getChildren().addAll(cotable, hb1);
		
		
		
		
		gr.add(title, 0, 0);
		gr.add(vb1, 0, 1);
		gr.add(vb2, 5, 1);
		

		cotable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		Scene scene = new Scene(gr, 900, 600);
		stage.setTitle("customer orders");
		stage.setScene(scene);
		
		
		
	}
	private void getDatae() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String SQL;
		connectDB();
		System.out.println("Connection Sucssed");
		SQL = "select * from employee order by employee_id";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		while (rs.next())
			// System.out.println(rs.getString(3));

			datae.add(new Employee(Integer.parseInt(rs.getString(1)), rs.getString(2)));
		rs.close();
		st.close();
		con.close();

	}
	
	private void insertDatae(Employee rc) {

		try {
			System.out.println("Insert into employee (employee_id, employee_name) values("

					+rc.getEmployee_id()+ ",'" + rc.getEmployee_name() + "');");

			connectDB();
			ExecuteStatement("Insert into employee (employee_id, employee_name) values("

					+rc.getEmployee_id()+ ",'" + rc.getEmployee_name() + "');");
			con.close();
			System.out.println("Connection closed" + datae.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//update employee name
		public void UpdateNamee(int employee_id, String employee_name) throws ClassNotFoundException {
			try {
				System.out.println("Update employee Set employee_name ='" + employee_name + "'Where employee_id=" + employee_id);
				connectDB();
				ExecuteStatement("update employee set employee_name = '" + employee_name + "'where employee_id= " + employee_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//delete row from employee
		public void deletee(Employee row) {
			try {
				System.out.println("delete from  employee where employee_id="+row.getEmployee_id() + ";");
				connectDB();
				ExecuteStatement("delete from  employee where employee_id="+row.getEmployee_id() + ";");
				con.close();
				System.out.println("Connection closed");
				
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
		}
	
	public void etableview(Stage stage) {
		TableView<Employee> etable = new TableView<Employee>();

		
		
		stage.setTitle("employee");
		

		Label l1 = new Label("employee table");
		l1.setFont(new Font("Arial", 20));
		l1.setTextFill(Color.BLUEVIOLET);

		etable.setEditable(true);
		etable.setMaxHeight(400);
		etable.setMaxWidth(400);
		
		TableColumn<Employee, Integer> eid = new TableColumn<Employee, Integer>("employee_id");

		eid.setMinWidth(200);
		eid.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employee_id"));
		
		/***********************/
		
		
		TableColumn<Employee, String> ename = new TableColumn<Employee, String>("employee_name");

		ename.setMinWidth(200);
		ename.setCellValueFactory(new PropertyValueFactory<Employee, String>("employee_name"));
		ename.setCellFactory(TextFieldTableCell.forTableColumn());
		
		ename.setOnEditCommit(
        		(CellEditEvent<Employee, String> t) -> {
                       ((Employee) t.getTableView().getItems().get(
        	                        t.getTablePosition().getRow())
        	                        ).setEmployee_name(t.getNewValue()); //display only
                       try {
                    	   UpdateNamee( t.getRowValue().getEmployee_id(),t.getNewValue());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        		});
		
		etable.setItems(dataListe);
		etable.setStyle("-fx-background-color: #1cbeff; ");
		etable.getColumns().addAll(eid, ename);
		etable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		final TextField addename = new TextField();
		addename.setPromptText("employee_name");
		addename.setMaxWidth(ename.getPrefWidth());
		
		
		final Button addButton = new Button("Add");
		addButton.setMinSize(100, 20);
		addButton.setFont(font0);
		addButton.setStyle("-fx-background-color: #1cbeff; ;");

		addButton.setOnAction(e -> {
			
			Employee rc;
			rc = new Employee(counte++,addename.getText());
			dataListe.add(rc);
			insertDatae(rc);
			addename.clear();
			

		});

		final Button deleteButton = new Button("Delete");
		deleteButton.setMinSize(100, 20);
		deleteButton.setFont(font0);
		deleteButton.setStyle("-fx-background-color: #1cbeff; ;");
		
		deleteButton.setOnAction(e -> {
			ObservableList<Employee> selectedRows = etable.getSelectionModel().getSelectedItems();
			ArrayList<Employee> rows = new ArrayList<>(selectedRows);
			rows.forEach(row -> {
				etable.getItems().remove(row);
				deletee(row);
				etable.refresh();
			});
		});

		final Button refreshButton = new Button("Refresh");
		refreshButton.setMinSize(100, 20);
		refreshButton.setFont(font0);
		refreshButton.setStyle("-fx-background-color: #1cbeff; ;");
		refreshButton.setOnAction(e -> {
			etable.refresh();
		});
		
		final Button back = new Button("back");
		back.setMinSize(100, 20);
		back.setFont(font0);
		back.setStyle("-fx-background-color: #1cbeff; ;");
		back.setOnAction(e -> {
			stage.setScene(scene1);
			stage.show();
		});
		
		
		HBox hb = new HBox();
		hb.setSpacing(15);
		hb.getChildren().addAll(addename, addButton );
		
		HBox hb1 = new HBox();
		hb1.setSpacing(15);
		hb1.getChildren().addAll(back, deleteButton, refreshButton );
		
		VBox vb = new VBox();
		
		vb.setSpacing(15);
		vb.getChildren().addAll(hb,etable, hb1);
		GridPane gr = new GridPane();
		gr.setAlignment(Pos.CENTER);
		gr.setVgap(5.5);
		gr.setHgap(5.5);
		
		gr.add(vb, 0, 0);
		
		Scene scene = new Scene(gr, 500, 550);
		
		stage.setScene(scene);
		
		
	}
	//update payed for pays 
		public void Updatepayed(int payment_id, String payment) throws ClassNotFoundException {
			try {
				System.out.println("Update pays Set payment =" + payment + "Where payment_id=" + payment_id);
				connectDB();
				ExecuteStatement("update pays set payment = '" + payment + "' where payment_id= " + payment_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//update customer_id for pays
		public void Updatepcid(int payment_id, int customer_id) throws ClassNotFoundException {
			try {
				System.out.println("Update pays Set customer_id =" + customer_id + "Where payment_id=" + payment_id);
				connectDB();
				ExecuteStatement("update pays set customer_id = " + customer_id + "where payment_id= " + payment_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//update employee_id for pays
		public void Updatepeid(int payment_id, int employee_id) throws ClassNotFoundException {
			try {
				System.out.println("Update pays Set employee_id =" + employee_id + "Where payment_id=" + payment_id);
				connectDB();
				ExecuteStatement("update pays set employee_id = " + employee_id + "where payment_id= " + payment_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//update payment_date for pays
		public void Updateppd(int payment_id, String payment_date) throws ClassNotFoundException {
			try {
				System.out.println("Update pays Set payment_date ='" + payment_date + "'Where payment_id=" + payment_id);
				connectDB();
				ExecuteStatement("update pays set payment_date = '" + payment_date + "'where payment_id= " + payment_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//update order_id for pays
		public void Updatepoid(int payment_id, int order_id) throws ClassNotFoundException {
			try {
				System.out.println("Update pays Set order_id =" + order_id + "Where payment_id=" + payment_id);
				connectDB();
				ExecuteStatement("update pays set order_id = " + order_id + "where payment_id= " + payment_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//update bill_id for pays
		public void Updatepbid(int payment_id, int bill_id) throws ClassNotFoundException {
			try {
				System.out.println("Update pays Set bill_id =" + bill_id + "Where payment_id=" + payment_id);
				connectDB();
				ExecuteStatement("update pays set bill_id = " + bill_id + "where payment_id= " + payment_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//delete pays record
		public void deletepayment(Pays row) {
			try {
				System.out.println("delete from  pays where payment_id="+row.getPayment_id() + ";");
				connectDB();
				ExecuteStatement("delete from  pays where payment_id="+row.getPayment_id() + ";");
				con.close();
				System.out.println("Connection closed");
				
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
		}
		//insert for pays
		private void insertDatap(Pays rc) {

			try {
				System.out.println("Insert into pays (payment_id, employee_id, customer_id, order_id, bill_id, payment_date, payment) values("

						+rc.getPayment_id()+","+rc.getEmployee_id()+ ","+ rc.getCustomer_id() + "," + rc.getOrder_id() + "," 
						+ rc.getBill_id() +",'"+ rc.getPayment_date()+"'," +rc.getPayment() +  ");");

				connectDB();
				ExecuteStatement("Insert into pays (payment_id, employee_id, customer_id, order_id, bill_id, payment_date, payment) values("

                        +rc.getPayment_id()+","+rc.getEmployee_id()+ ","+ rc.getCustomer_id() + "," + rc.getOrder_id() + "," 
						+ rc.getBill_id() +",'"+ rc.getPayment_date()+"'," +rc.getPayment() +  ");");
				datap.add(rc);
				con.close();
				
				System.out.println("Connection closed" + datap.size());

			} catch (SQLException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
			}
		
		//get data for pays
		private void getDatap() throws SQLException, ClassNotFoundException {
			String SQL;
			connectDB();
			System.out.println("Connection Sucssed");
			SQL = "select * from pays order by payment_id ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next()) {
				 System.out.println(rs.getString(3));
			     System.out.println(rs.getString(4));

				datap.add(new Pays(Integer.parseInt(rs.getString(1)),Integer.parseInt(rs.getString(2)), 
						Integer.parseInt(rs.getString(3)), Integer.parseInt(rs.getString(4)),
						Integer.parseInt(rs.getString(5)) ,rs.getString(6), rs.getString(7)));
			}
			rs.close();
			st.close();
			con.close();
		}
		
		//tableview for pays
		public void ptableview(Stage stage) {
			TableView<Pays> ptable = new TableView<Pays>();

			
			stage.setTitle("paying");
			

			Label l1 = new Label("paying table");
			l1.setFont(new Font("Arial", 20));
			l1.setTextFill(Color.BLUEVIOLET);

			ptable.setEditable(true);
			ptable.setMaxHeight(700);
			ptable.setMaxWidth(700);
			
			
			TableColumn<Pays, Integer> pid = new TableColumn<Pays, Integer>("payment_id");

			pid.setMinWidth(100);
			pid.setCellValueFactory(new PropertyValueFactory<Pays, Integer>("payment_id"));
			///////////////////////////////
			
			
			TableColumn<Pays, Integer> oid = new TableColumn<Pays, Integer>("order_id");

			oid.setMinWidth(100);
			oid.setCellValueFactory(new PropertyValueFactory<Pays, Integer>("order_id"));
			oid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
			
			oid.setOnEditCommit(
	        		(CellEditEvent<Pays, Integer> t) -> {
	                       ((Pays) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setOrder_id(t.getNewValue()); //display only
	                       try {
	                    	   Updatepoid( t.getRowValue().getPayment_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			///////////////////////////////
			
			
			TableColumn<Pays, Integer> cid = new TableColumn<Pays, Integer>("customer_id");

			cid.setMinWidth(100);
			cid.setCellValueFactory(new PropertyValueFactory<Pays, Integer>("customer_id"));
			cid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

			
			cid.setOnEditCommit(
	        		(CellEditEvent<Pays, Integer> t) -> {
	                       ((Pays) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setCustomer_id(t.getNewValue()); //display only
	                       try {
	                    	   Updatepcid( t.getRowValue().getPayment_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			///////////////////////////////
			
			
			TableColumn<Pays, Integer> eid = new TableColumn<Pays, Integer>("employee_id");

			eid.setMinWidth(100);
			eid.setCellValueFactory(new PropertyValueFactory<Pays, Integer>("employee_id"));
			eid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

			eid.setOnEditCommit(
	        		(CellEditEvent<Pays, Integer> t) -> {
	                       ((Pays) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setEmployee_id(t.getNewValue()); //display only
	                       try {
	                    	   Updatepeid( t.getRowValue().getPayment_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			//////////////////////////////
			
			
			
			TableColumn<Pays, String> pdate = new TableColumn<Pays, String>("payment_date");

			pdate.setMinWidth(100);
			pdate.setCellValueFactory(new PropertyValueFactory<Pays, String>("payment_date"));
			pdate.setCellFactory(TextFieldTableCell.forTableColumn());

			
			pdate.setOnEditCommit(
	        		(CellEditEvent<Pays, String> t) -> {
	                       ((Pays) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setPayment_date(t.getNewValue()); //display only
	                       try {
	                    	   Updateppd( t.getRowValue().getPayment_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			///////////////////////////////
			
			TableColumn<Pays, Integer> bid = new TableColumn<Pays, Integer>("bill_id");

			bid.setMinWidth(100);
			bid.setCellValueFactory(new PropertyValueFactory<Pays, Integer>("bill_id"));
			bid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

			
			bid.setOnEditCommit(
	        		(CellEditEvent<Pays, Integer> t) -> {
	                       ((Pays) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setBill_id(t.getNewValue()); //display only
	                       try {
	                    	   Updatepbid( t.getRowValue().getPayment_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			///////////////////////////////
			
			TableColumn<Pays, String> payed = new TableColumn<Pays, String>("payment");

			payed.setMinWidth(100);
			payed.setCellValueFactory(new PropertyValueFactory<Pays, String>("payment"));
			payed.setCellFactory(TextFieldTableCell.forTableColumn());

			
			payed.setOnEditCommit(
	        		(CellEditEvent<Pays, String> t) -> {
	                       ((Pays) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setPayment(t.getNewValue()); //display only
	                       try {
	                    	   Updatepayed( t.getRowValue().getPayment_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			///////////////////////////////
			
			
			ptable.setItems(dataListp);
			ptable.setStyle("-fx-background-color: #1cbeff; ");
			ptable.getColumns().addAll(pid, oid, cid, eid,pdate,bid, payed  );
			ptable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			final TextField addbid = new TextField();
			addbid.setPromptText("bill_id");
			addbid.setMaxWidth(bid.getPrefWidth());

			final TextField addoid = new TextField();
			addoid.setPromptText("order_id");
			addoid.setMaxWidth(oid.getPrefWidth());

			final TextField addcid = new TextField();
			addcid.setPromptText("customer_id");
			addcid.setMaxWidth(cid.getPrefWidth());

			final TextField addeid = new TextField();
			addeid.setPromptText("employee_id");
			addeid.setMaxWidth(eid.getPrefWidth());
			
			final TextField addpdate = new TextField();
			addpdate.setPromptText("order_date");
			addpdate.setMaxWidth(pdate.getPrefWidth());

			
			final TextField addpayed = new TextField();
			addpayed.setPromptText("payed");
			addpayed.setMaxWidth(payed.getPrefWidth());

			final Button addButton = new Button("Add");

			addButton.setOnAction(e -> {
				Pays rc;
				rc = new Pays(paycount++ ,Integer.valueOf(addbid.getText()), Integer.valueOf(addoid.getText()), Integer.valueOf(addcid.getText()),
						Integer.valueOf(addeid.getText()), addpdate.getText(), addpayed.getText());
				
				dataListp.add(rc);
				insertDatap(rc);
				addcid.clear();
				addeid.clear();
				addpdate.clear();
				addoid.clear();
				addpayed.clear();
				addbid.clear();

			});

			final Button deleteButton = new Button("Delete");
			deleteButton.setMinSize(100, 20);
			deleteButton.setFont(font0);
			deleteButton.setStyle("-fx-background-color: #1cbeff; ;");
			deleteButton.setOnAction(e -> {
				ObservableList<Pays> selectedRows = ptable.getSelectionModel().getSelectedItems();
				ArrayList<Pays> rows = new ArrayList<>(selectedRows);
				rows.forEach(row -> {
					ptable.getItems().remove(row);
					deletepayment(row);
					ptable.refresh();
				});
			});

			final Button refreshButton = new Button("Refresh");
			refreshButton.setMinSize(100, 20);
			refreshButton.setFont(font0);
			refreshButton.setStyle("-fx-background-color: #1cbeff; ;");
			refreshButton.setOnAction(e -> {
				ptable.refresh();
			});
			
			final Button back = new Button("back");
			back.setMinSize(100, 20);
			back.setFont(font0);
			back.setStyle("-fx-background-color: #1cbeff; ;");
			back.setOnAction(e -> {
				stage.setScene(scene1);
				stage.show();
			});
			
			GridPane gr = new GridPane();
			gr.setAlignment(Pos.CENTER);
			gr.setHgap(5.5);
			gr.setVgap(5.5);
			
			HBox hb = new HBox();
			hb.setSpacing(15);
			hb.getChildren().addAll(deleteButton, refreshButton, back);		
			
			gr.add(ptable, 0, 0);
			gr.add(hb, 0, 1);
			
			Scene scene = new Scene(gr, 800, 600);
			stage.setScene(scene);
			
			
			
			
			
			
		}
		
		//get data for bill
		private void getDatab() throws SQLException, ClassNotFoundException {
			String SQL;
			connectDB();
			System.out.println("Connection Sucssed");
			SQL = "select * from bill order by bill_id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL);
			while (rs.next())
				// System.out.println(rs.getString(3));

				datab.add(new Bill( Integer.parseInt(rs.getString(1)), Integer.parseInt(rs.getString(2)), Integer.parseInt(rs.getString(3)),
						Integer.parseInt(rs.getString(4))));
			rs.close();
			st.close();
			con.close();
		}
		
		
		//update amount for bill
		public void Updatetot(int bill_id, int amount) throws ClassNotFoundException {
			try {
				System.out.println("Update bill Set amount =" + amount + "Where bill_id=" + bill_id);
				connectDB();
				ExecuteStatement("update bill set amount = " + amount + "where bill_id= " + bill_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//update customer_id for bill
		public void Updatecb(int bill_id, int customer_id) throws ClassNotFoundException {
			try {
				System.out.println("Update bill Set customer_id =" + customer_id + "Where bill_id=" + bill_id);
				connectDB();
				ExecuteStatement("update bill set customer_id = " + customer_id + "where bill_id= " + bill_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//update order_id for bill
		public void Updateob(int bill_id, int order_id) throws ClassNotFoundException {
			try {
				System.out.println("Update bill Set order_id =" + order_id + "Where bill_id=" + bill_id);
				connectDB();
				ExecuteStatement("update bill set order_id = " + order_id + "where bill_id= " + bill_id + " ;");
				con.close();
				System.out.println("connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//delete bill record
		public void deleteb(Bill row) {
			try {
				System.out.println("delete from  bill where bill_id="+row.getBill_id() + ";");
				connectDB();
				ExecuteStatement("delete from  bill where bill_id="+row.getBill_id() + ";");
				con.close();
				System.out.println("Connection closed");
				
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
		}
		//insert for bill
		private void insertDatab(Bill rc) {

			try {
				System.out.println("Insert into bill (bill_id, customer_id, order_id,  amount) values("

						+rc.getBill_id()+","+ rc.getCustomer_id() + "," + rc.getOrder_id() + "," + rc.getAmount() + ");");

				connectDB();
				ExecuteStatement("Insert into bill (bill_id, customer_id, order_id,  amount) values("

                        +rc.getBill_id()+","+ rc.getCustomer_id() + "," + rc.getOrder_id() + "," + rc.getAmount() + ");");
				datab.add(rc);
				con.close();
				
				System.out.println("Connection closed" + datab.size());

			} catch (SQLException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
			}
		//tableview for bill
		public void btableview(Stage stage) {
			TableView<Bill> btable = new TableView<Bill>();

			
			stage.setTitle("bill");
			

			Label l1 = new Label("bill table");
			l1.setFont(new Font("Arial", 20));
			l1.setTextFill(Color.BLUEVIOLET);

			btable.setEditable(true);
			btable.setMaxHeight(500);
			btable.setMaxWidth(500);
			
			TableColumn<Bill, Integer> bid = new TableColumn<Bill, Integer>("bill_id");

			bid.setMinWidth(50);
			bid.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("bill_id"));
			///////////////////////////////
			
			
			TableColumn<Bill, Integer> bamount = new TableColumn<Bill, Integer>("amount");

			bamount.setMinWidth(50);
			bamount.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("amount"));
			bamount.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
			
			bamount.setOnEditCommit(
	        		(CellEditEvent<Bill, Integer> t) -> {
	                       ((Bill) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setAmount(t.getNewValue()); //display only
	                       try {
	                    	   Updatetotal( t.getRowValue().getBill_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			///////////////////////////////
			
			
			TableColumn<Bill, Integer> bcid = new TableColumn<Bill, Integer>("customer_id");

			bcid.setMinWidth(50);
			bcid.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("customer_id"));
			bcid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
			
			bcid.setOnEditCommit(
	        		(CellEditEvent<Bill, Integer> t) -> {
	                       ((Bill) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setCustomer_id(t.getNewValue()); //display only
	                       try {
	                    	   Updatecb( t.getRowValue().getBill_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			//////////////////////////////
			
			
			
			TableColumn<Bill, Integer> boid = new TableColumn<Bill, Integer>("order_id");

			boid.setMinWidth(50);
			boid.setCellValueFactory(new PropertyValueFactory<Bill, Integer>("order_id"));
			boid.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
			
			boid.setOnEditCommit(
	        		(CellEditEvent<Bill, Integer> t) -> {
	                       ((Bill) t.getTableView().getItems().get(
	        	                        t.getTablePosition().getRow())
	        	                        ).setOrder_id(t.getNewValue()); //display only
	                       try {
	                    	   Updateob( t.getRowValue().getBill_id(),t.getNewValue());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		});
			///////////////////////////////
			
			btable.setItems(dataListb);
			btable.setStyle("-fx-background-color: #1cbeff; ");
			btable.getColumns().addAll(bid, bamount, bcid, boid);
			btable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			final TextField addbamount = new TextField();
			addbamount.setPromptText("amount");
			addbamount.setMaxWidth(bamount.getPrefWidth());

			final TextField addbcid = new TextField();
			addbcid.setPromptText("customer_id");
			addbcid.setMaxWidth(bcid.getPrefWidth());

			final TextField addboid = new TextField();
			addboid.setPromptText("order_id");
			addboid.setMaxWidth(boid.getPrefWidth());

			final Button addButton = new Button("Add");

			addButton.setOnAction(e -> {
				Bill rc;
				rc = new Bill(billcount++, Integer.valueOf(addboid.getText()), Integer.valueOf(addbcid.getText()), Integer.valueOf(addbamount.getText()));
				dataListb.add(rc);
				insertDatab(rc);
				addbamount.clear();
				addbcid.clear();
				addboid.clear();

			});

			final Button deleteButton = new Button("Delete");
			deleteButton.setMinSize(100, 20);
			deleteButton.setFont(font0);
			deleteButton.setStyle("-fx-background-color: #1cbeff; ;");
			deleteButton.setOnAction(e -> {
				ObservableList<Bill> selectedRows = btable.getSelectionModel().getSelectedItems();
				ArrayList<Bill> rows = new ArrayList<>(selectedRows);
				rows.forEach(row -> {
					btable.getItems().remove(row);
					deleteb(row);
					btable.refresh();
				});
			});

			final Button refreshButton = new Button("Refresh");
			refreshButton.setMinSize(100, 20);
			refreshButton.setFont(font0);
			refreshButton.setStyle("-fx-background-color: #1cbeff; ;");
			refreshButton.setOnAction(e -> {
				btable.refresh();
			});
			
			final Button back = new Button("back");
			back.setMinSize(100, 20);
			back.setFont(font0);
			back.setStyle("-fx-background-color: #1cbeff; ;");
			back.setOnAction(e -> {
				stage.setScene(scene1);
				stage.show();
			});
			
			

			GridPane gr = new GridPane();
			gr.setAlignment(Pos.CENTER);
			gr.setHgap(5.5);
			gr.setVgap(5.5);
			
			HBox hb = new HBox();
			hb.setSpacing(15);
			hb.getChildren().addAll(deleteButton, refreshButton, back);		
			
			gr.add(btable, 0, 0);
			gr.add(hb, 0, 1);
			
			Scene scene = new Scene(gr, 600, 600);
			stage.setScene(scene);
			
			
		}
		

	public static void main(String[] args) {
		launch(args);
	}
}
