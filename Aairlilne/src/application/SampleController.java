package application;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class SampleController implements Initializable {
	


    @FXML
    private RadioButton airlineRd;

    @FXML
    private ToggleGroup option;

    @FXML
    private RadioButton airlinenumberRd;

    @FXML
    private RadioButton departureairportRd;

    @FXML
    private RadioButton arrivairportRd;

	    @FXML
	    private ChoiceBox<String> choiceairline; //I have declared the type of choice boxes

	    @FXML
	    private ChoiceBox<String> choicenumber;

	    @FXML
	    private ChoiceBox<String> choicedeparture;

	    @FXML
	    private ChoiceBox<String> choicearrival;

	    @FXML
	    private Button search;

	    @FXML
	    private Button close;
	  
	    String [] sdata=new String[4];
	    Path p=Paths.get("C:\\Users\\deosi\\Desktop\\flight.txt"); //Here we saving the files of file flight.txt
	    InputStream ip;
	    BufferedReader Br;//Buffereader and inputstream are created for file handling 
	  //FlightInformation is not used
	    String sname;

	    @FXML
	    private ListView<String> airlinelistview; 
	   
	    ObservableList<FlightInformation> Info=FXCollections.observableArrayList();
	  
	    @FXML
	    void onairlineRd(MouseEvent event) { //condition to disable the choice box based on click
	    	airlinelistview.getItems().clear();//clear previous data
	    	choicedeparture.setDisable(true);
    	    choicearrival.setDisable(true);
    	    choiceairline.setDisable(false);
	    	choicenumber.setDisable(true);
	    	   
	   	 airlinelistview.getItems().add("Airline"+"\t"+"AirlineNo"+"\t"+"Departure"+"\t"+"Arrival");//adding the header
	    	
	    	    try {
	    	     ip = new BufferedInputStream(Files.newInputStream(p)); //used p to create input stream object which will used for buffer reader
	    	     Br = new BufferedReader(new InputStreamReader(ip));
	    	     sname = Br.readLine();//reading entire line of file 
	    	      while (sname != null) {
	    	        sdata = sname.split(",");     //breaking the line which is sperated by comos
	    	        sname = Br.readLine(); //reading other line
	    	        
	    	        
	    	        if (!choiceairline.getItems().contains(sdata[0])) //checking for condition if the file contain airline as in choice box then we will add it
	    	          choiceairline.getItems().add(sdata[0]); 
	    	      } 
	    	      Br.close();
	    	    } catch (IOException e) {
	    	      e.printStackTrace();
	    	    } 
	    	  
			
// in other onRadio box methods this has been used
	    }

	    @FXML
	    void onairlinenumberRd(MouseEvent event) {
	    	
	    	airlinelistview.getItems().clear();
	    	choicedeparture.setDisable(true);
    	    choicearrival.setDisable(true);
    	    choiceairline.setDisable(true);
	    	choicenumber.setDisable(false);
	   	 airlinelistview.getItems().add("Airline"+"\t"+"Airline Number"+"\t"+"Departure"+"\t"+"Arrival");
	    	   
	    	
	    	
	    	 try {
	    	     ip = new BufferedInputStream(Files.newInputStream(p));
	    	     Br = new BufferedReader(new InputStreamReader(ip));
	    	     sname = Br.readLine();
	    	      while (sname != null) {
	    	        sdata = sname.split(",");
	    	        sname = Br.readLine();
	    	       
	    	        if (!choicenumber.getItems().contains(sdata[1]))
	    	          choicenumber.getItems().add(sdata[1]); 
	    	      } 
	    	      Br.close();
	    	    } catch (IOException e) {
	    	      e.printStackTrace();
	    	    } 

	    }

	    @FXML
	    void onarrivalRd(MouseEvent event) {
	    	
	    	airlinelistview.getItems().clear();
	    	choicedeparture.setDisable(true);
    	    choicearrival.setDisable(false);
    	    choiceairline.setDisable(true);
	    	choicenumber.setDisable(true);
	    	   
	   	 airlinelistview.getItems().add("Airline"+"\t"+"Airline Number  "+"\t"+"Departure   "+"\t"+"  Arrival");
	    	
	    	
	    	 try {
	    	     ip = new BufferedInputStream(Files.newInputStream(p));
	    	     Br = new BufferedReader(new InputStreamReader(ip));
	    	     sname = Br.readLine();
	    	      while (sname != null) {
	    	        sdata = sname.split(",");
	    	        sname = Br.readLine();
	    	        
	    	        if (!choicearrival.getItems().contains(sdata[3]))
	    	          choicearrival.getItems().add(sdata[3]); 
	    	      } 
	    	      Br.close();
	    	    } catch (IOException e) {
	    	      e.printStackTrace();
	    	    } 
	    	

	    }

	    @FXML
	    void onclose(ActionEvent event) {
     Platform.exit();//simply closing the platform
	    }

	    @FXML
	    void ondepartureRd(MouseEvent event) {
	    	
	     	airlinelistview.getItems().clear();
	    	choicedeparture.setDisable(false);
    	    choicearrival.setDisable(true);
    	    choiceairline.setDisable(true);
	    	choicenumber.setDisable(true);
	   	 airlinelistview.getItems().add("Airline"+"\t"+"Airline Number"+"\t"+"Departure"+"\t"+"Arrival");
	    	   
	    	
	    	
	    	 try {
	    	     ip = new BufferedInputStream(Files.newInputStream(p));
	    	     Br = new BufferedReader(new InputStreamReader(ip));
	    	     sname = Br.readLine();
	    	      while (!(sname == null)) {
	    	        sdata = sname.split(",");
	    	        sname = Br.readLine();
	    	        
	    	        if (!choicedeparture.getItems().contains(sdata[2]))
	    	          choicedeparture.getItems().add(sdata[2]); 
	    	      } 
	    	      Br.close();
	    	    } catch (IOException e) {
	    	      e.printStackTrace();
	    	    }

	    }

	    @FXML
	    void onsearch(ActionEvent event) {
	    	try {
				ip=new BufferedInputStream(Files.newInputStream(p));// simply repeat the previous process
				Br=new BufferedReader(new InputStreamReader(ip));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	if(airlineRd.isSelected()) {
	    	try {
				
				
					sname=Br.readLine();//to read line
					while(sname!=null) {
						sdata=sname.split(",");//split it
						if(choiceairline.getSelectionModel().getSelectedItem().toString().equals(sdata[0].toString()))
							//if choice matches we will add the data into list view
					
						{
							airlinelistview.getItems().add(sdata[0]+"\t"+sdata[1]+"\t"+sdata[2]+"\t           "+sdata[3]);
							
						
						}
						sname=Br.readLine();//reading other line so loop continuous
					}
					
				
				Br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	    	//similar used of else if statement
	    	else if(airlinenumberRd.isSelected()) {
	    		
		    	try {
					
					
						sname=Br.readLine();
						while(sname!=null) {
							sdata=sname.split(",");
							if(choicenumber.getSelectionModel().getSelectedItem().toString().equals(sdata[1].toString()))
						
							{
								airlinelistview.getItems().add(sdata[0]+"\t"+sdata[1]+"\t"+sdata[2]+"\t           "+sdata[3]);
								
							
							}
							sname=Br.readLine();
						}
						
					
					Br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
	    	else if(departureairportRd.isSelected()) {
	    	
		    	try {
					
					
						sname=Br.readLine();
						while(sname!=null) {
							sdata=sname.split(",");
							if(choicedeparture.getSelectionModel().getSelectedItem().toString().equals(sdata[2].toString()))
						
							{
								airlinelistview.getItems().add(sdata[0]+"\t"+sdata[1]+"\t"+sdata[2]+"\t           "+sdata[3]);
								
							
							}
							sname=Br.readLine();
						}
						
					
					Br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
	    	else if(arrivairportRd.isSelected()) {
	    		
		    	try {
					
					
						sname=Br.readLine();
						while(sname!=null) {
							sdata=sname.split(",");
							if(choicearrival.getSelectionModel().getSelectedItem().toString().equals(sdata[3].toString()))
						
							{
								airlinelistview.getItems().add(sdata[0]+"\t"+sdata[1]+"\t"+sdata[2]+"\t           "+sdata[3]);
								
							
							}
							sname=Br.readLine();
						}
						
					
					Br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
	    	
	    	
	    	

	    	
		
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			//these are to set value as soon the window opens
		 choiceairline.setValue("Select the Airline");
		 choicenumber.setValue("Select the Airline Number");	 
		 choicedeparture.setValue("Select the Departure ");	 
		 choicearrival.setValue("Select the Arrival");
		 airlinelistview.getItems().add("Airline"+"\t"+"Airline Number"+"\t"+"Departure"+"\t"+"Arrival");
		}
	
	
}
