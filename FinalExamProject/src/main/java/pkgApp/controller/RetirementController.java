package pkgApp.controller;


import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {


	private RetirementApp mainApp = null;

	@FXML
	private TextField txtYearsToWork;

	@FXML
	private TextField txtAnnualReturnWWorking;

	@FXML
	private TextField txtYearsRetired;

	@FXML
	private TextField txtAnnualReturnWRetired;

	@FXML
	private TextField txtRequiredIncome;

	@FXML
	private TextField txtMonthlySSI;

	@FXML
	private Label totalAmountToSave;

	@FXML
	private Label amountToSave;
	
	//Test Stuff
//	@FXML
//	private GridPane myGridPane;
	
	//Ideas
	//HashMap txtFields<TextFields, String> = new HashMap<TextFields>;
	//ArrayList<TextField> 

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}

	@FXML
	public void btnClear(ActionEvent event) {
		
		//System.out.println("Clear pressed");
		
		
		txtYearsToWork.clear();
		txtYearsToWork.setStyle("-fx-text-fill: black;");
		
		txtAnnualReturnWWorking.clear();
		txtAnnualReturnWWorking.setStyle("-fx-text-fill: black;");
		
		txtYearsRetired.clear();
		txtYearsRetired.setStyle("-fx-text-fill: black;");
		
		txtAnnualReturnWRetired.clear();
		txtAnnualReturnWRetired.setStyle("-fx-text-fill: black;");
		
		txtRequiredIncome.clear();
		txtRequiredIncome.setStyle("-fx-text-fill: black;");
		
		txtMonthlySSI.clear();
		txtMonthlySSI.setStyle("-fx-text-fill: black;");
		
		//totalAmountToSave.setText("");
		
		//amountToSave.setText("");
		
		totalAmountToSave.setText("");
		totalAmountToSave.setStyle("-fx-text-fill: black;");
		amountToSave.setText("");
		amountToSave.setStyle("-fx-text-fill: black;");
		

		//	TODO: Clear all the text inputs

		//		RetirementController.clearTextFields();
		//		for ()
		//		input.setStyle("-fx-text-fill: red;")

	}

	@FXML
	public void btnCalculate(ActionEvent event) {

		//System.out.println(txtAnnualReturnWWorking.getText());
		//	TODO: Call AmountToSave and TotalAmountSaved and populate 

		//for each TextField
		//verifyTypeIntegerData

		Retirement retired = new Retirement();
		
		txtYearsToWork.setStyle("-fx-text-fill: black;");
		txtAnnualReturnWWorking.setStyle("-fx-text-fill: black;");
		txtYearsRetired.setStyle("-fx-text-fill: black;");
		txtAnnualReturnWRetired.setStyle("-fx-text-fill: black;");
		txtRequiredIncome.setStyle("-fx-text-fill: black;");
		txtMonthlySSI.setStyle("-fx-text-fill: black;");

		//checks years of working is an int
		if (verifyTypeIntegerData(txtYearsRetired)) {
			//System.out.println(txtYearsRetired.getText());
			
			//sets years of work to a Retirement variable
			retired.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
			//System.out.println(txtYearsRetired.getText());
			
			//checks rate while retired is an double
			if (verifyTypeDoubleData(txtAnnualReturnWRetired)) {
				//System.out.println(txtAnnualReturnWRetired.getText());
				
				//sets rate to a Retirement variable
				retired.setdAnnualReturnRetired(Double.parseDouble(txtAnnualReturnWRetired.getText()));
				//System.out.println(txtAnnualReturnWRetired.getText());
				
				//checks years of working is a reasonable value between 0-.2
				if ((retired.getdAnnualReturnRetired() < 0) && retired.getdAnnualReturnRetired() > .20) {
					txtAnnualReturnWRetired.setStyle("-fx-text-fill: yellow;");
				}
				
				//checks if monthly income is a double
				if (verifyTypeDoubleData(txtRequiredIncome)) {
					//System.out.println(txtRequiredIncome.getText());
					
					//sets monthly income to a Retirement variable
					retired.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
					//System.out.println(txtRequiredIncome.getText());
					
					//checks if MonthlySSI is a double
					if (verifyTypeDoubleData(txtMonthlySSI)) {
						//System.out.println(txtMonthlySSI.getText());
						
						//sets monthlySSI income to a Retirement variable
						retired.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));
						//System.out.println(txtMonthlySSI.getText());
						
						
						//For some reason, when it goes to the pv function in apache lib, it messes up!!!
						totalAmountToSave.setText(Double.toString(Math.abs(rnd2Deci(retired.TotalAmountSaved()))));
						//System.out.println(totalAmountToSave.getText());
						
						if(verifyTypeIntegerData(txtYearsRetired)) {
							retired.setiYearsToWork(Integer.parseInt(txtYearsToWork.getText()));
							if (verifyTypeDoubleData(txtAnnualReturnWWorking)) {
								retired.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturnWWorking.getText()));
								if ((retired.getdAnnualReturnWorking() < 0) && retired.getdAnnualReturnWorking() > .20) {
									txtAnnualReturnWWorking.setStyle("-fx-text-fill: yellow;");
								}
								amountToSave.setText(Double.toString(Math.abs(rnd2Deci(retired.AmountToSave()))));
							}
						}
					}
				}
			}
		}




	}

	private boolean verifyTypeDoubleData(TextField input) {
		try {
			Double.parseDouble(input.getText());
			return true;
		}
		catch (NumberFormatException e){
			input.setStyle("-fx-text-fill: red;");
			return false;
		}
	}

	private boolean verifyTypeIntegerData(TextField input) {
		try {
			Integer.parseInt(input.getText());
			return true;
		}
		catch(NumberFormatException e) {
			input.setStyle("-fx-text-fill: red;");
			return false;
		}
	}
	
	public double rnd2Deci(double numberToBeRounded) {
		return ((double)((int)(numberToBeRounded * 100))) / 100;
	}
//
//		private void clearFields() {
//			Retirement retired = new Retirement();
//			for (Node o : myGridPane.getChildren()) {
//				if (GridPane.getColumnIndex(o) == 2) {
//					if (o instanceof TextField) {
//						myGridPane.getChildren().get().setText("");
//					}
//					if (o instanceof Label) {
//						
//					}
//					
//				}
//			}
//			TextFields.clear(); //method exists, just have to make it more personalized for each field
//		}
}
