package rocket.app.view;

import java.awt.Button;
import java.awt.TextField;
import java.text.NumberFormat;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	@FXML
	private TextField txtIncome;
	
	@FMXL
	private TextField txtExpenses;
	
	@FMXL
	private TextField txtCreditScore;
	
	@FXML
	private TextField txtHouseCost;
	
	@FXML 
	private ComboBox<String> comboBoxTerm;
	
	@FXML
	private Label Income;
	
	@FXML
	private Label Expenses;
	
	@FXML
	private Label CreditScore;
	
	@FXML 
	private Label HouseCost;
	
	@FXML 
	private Label LoanTerm;
	
	@FXML 
	private Label Payment;
	
	@FXML
	private Label Error;
	
	@FXML
	private Label lblMortgagePayment;
	
	@FXML 
	private TextField MortgagePayment;
	
	@FXML 
	private Label thrownException;
	
	@FXML 
	private Label paymentException;
	
	@FXML
	private Button CalculatePayment;
	
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setIncome(Double.parseDouble(txtIncome.getText()));
		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	private static NumberFormat nf = NumberFormat.getCurrencyInstance();
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double firstPaymentMethod = lRequest.getIncome() * .28;
		double secondPaymentMethod = (lRequest.getIncome() * .36 - lRequest.getExpenses());
		double finalActualPayment;
		
		if (firstPaymentMethod < secondPaymentMethod){
			finalActualPayment = firstPaymentMethod;
		}
		else {
			finalActualPayment = secondPaymentMethod;
		}
		
		double payment = lRequest.getdPayment();
		
		if (finalActualPayment < payment) {
			txtExpenses.setText("payment too high");
		}
		else {
			MortgagePayment.setText("Monthly Mortgage Payment: " + nf.format(lRequest.getdPayment()));
		}
	}
	
	@FXML
	public void Exit(ActionEvent event) {
		System.exit(0);
	}
}
