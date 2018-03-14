/**
 * Sample Skeleton for 'IndoNumero.fxml' Controller Class
 */
package it.polito.tdp.indonumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class IndoNumeroController {
	
	private int NMAX = 100 ;
	private int TMAX = 7 ; // log in base 2 di 100 = 6.9 
	
	private int segreto ; // numero da indovinare
	private int tentativi ; // tentativi gia' fatti
	
	private boolean inGame = false ;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnNuova"
    private Button btnNuova; // Value injected by FXMLLoader

    @FXML // fx:id="txtCurr"
    private TextField txtCurr; // Value injected by FXMLLoader

    @FXML // fx:id="txtMax"
    private TextField txtMax; // Value injected by FXMLLoader

    @FXML // fx:id="boxGioco"
    private HBox boxGioco; // Value injected by FXMLLoader

    @FXML // fx:id="txtTentativo"
    private TextField txtTentativo; // Value injected by FXMLLoader

    @FXML // fx:id="txtLog"
    private TextArea txtLog; // Value injected by FXMLLoader

    @FXML
    void handleNuova(ActionEvent event) {

    	// Permetto all'utente di iniziare una nuova partita
    	//Questo metodo deve inventare un numero casuale
    	this.segreto = (int) (Math.random()*NMAX) + 1 ; // Valore tra 1 compreso e 100 escluso
    	
    	this.tentativi = 0 ;
    	this.inGame = true ;
    	
    	//Rifletto sull'interfaccia queste ultime due informazioni : 
    	// 1. Disabilito il bottone Nuova Partita
    	// 2. Abilito il testo dove inserire il tentativo
    	btnNuova.setDisable(true);
    	boxGioco.setDisable(false); // Doppia negazione : così il boxGioco è ATTIVATO
    	txtCurr.setText(String.format("%d", this.tentativi));
    	txtMax.setText(String.format("%d", TMAX));
    	
    }

    @FXML
    void handleProva(ActionEvent event) {

    	//Estraggo il numero che l'utente ha inserito e verificare che sia un numero
    	String numS = txtTentativo.getText();
    	
    	if ( numS.length()==0) {
    		txtLog.appendText("Devi inserire un numero\n");
    		return;
    	}
    	
    	try {
    		
    		int num = Integer.parseInt(numS); //Converto la stringa in numero
    	
    	}catch(NumberFormatException ex) {
    		
    		txtLog.appendText("Il dato inserito non e' numerico\n");
    		return;
    		
    	}
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtCurr != null : "fx:id=\"txtCurr\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtMax != null : "fx:id=\"txtMax\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert boxGioco != null : "fx:id=\"boxGioco\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtTentativo != null : "fx:id=\"txtTentativo\" was not injected: check your FXML file 'IndoNumero.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'IndoNumero.fxml'.";

    }
}
