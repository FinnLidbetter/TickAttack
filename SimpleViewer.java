import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Collection;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Finn Lidbetter
 * This class handles the GUI for this program. This code was not
 * written by me. 
 */

public class SimpleViewer extends JFrame implements IView{
    protected int          streetCredValue;
    protected int          workCredValue;
    protected int          healthValue;
    protected String       infectionStageString;
    protected int          remainingQuestTime;
    protected int          numberOfTickTests;
    protected int          numberOfCheapMeds;
    protected int          numberOfAntibiotics;
    protected String       rangerGear; // MAYBE REPLACE THIS WITH AN ENUM???
    protected String       fishingRod;
    
    protected JTextArea    myOutput;
    protected IController  myController;
    protected String       myTitle;
    protected String       myLabelString;
    
    protected JComboBox<String> questChoice;
    protected JComboBox<String> storeChoice;
    protected JComboBox<String> itemChoice;
    protected JButton questButton;
    protected JButton storeButton;
    protected JButton useItemButton;
    protected JButton tickSearchButton;
    
    
    protected JTextField   myMessage;
    
    
    public SimpleViewer(String title, String prompt){
      setDefaultCloseOperation(EXIT_ON_CLOSE);
		
      JPanel panel = (JPanel) getContentPane();
      panel.setLayout(new BorderLayout());
      setTitle(title);
      myTitle = title;
      myLabelString = prompt;
  
      panel.add(makeVariableTracker(), BorderLayout.NORTH);
      panel.add(makeOutput(), BorderLayout.CENTER);
      panel.add(makeMessage(), BorderLayout.SOUTH);
      panel.add(makeItemTracker(), BorderLayout.SOUTH);
      panel.add(makeButtons(), BorderLayout.EAST);
      connectEvents();
  
      pack();
      setSize(800,400);
      setVisible(true);
    }

    public void setController(IController controller){
      myController = controller;
      myController.addView(this);
    }

    protected JPanel makeMessage(){
    	JPanel p = new JPanel(new BorderLayout());
    	myMessage = new JTextField(30);
    	p.setBorder(BorderFactory.createTitledBorder("message"));
    	p.add(myMessage, BorderLayout.CENTER);
    	return p;
    }
    
    protected JPanel makeButtons() {
      JPanel p = new JPanel(new GridLayout(3,1));
      JPanel p1 = new JPanel(new GridLayout(2,1));
      p1.setBorder(BorderFactory.createTitledBorder("Quest: "));
      String[] questNames = {"Ranger quest", "Fishing quest"};
      questChoice = new JComboBox<>(questNames);
      p1.add(questChoice);
      questButton = new JButton("Perform quest");
      p1.add(questButton);
      p.add(p1);
      
      JPanel p2 = new JPanel(new GridLayout(2,1));
      p2.setBorder(BorderFactory.createTitledBorder("Store: "));
      String[] storeNames = {"Cheap Local Store","Big Expensive Foreign Store"};
      storeChoice = new JComboBox<>(storeNames);
      p2.add(storeChoice);
      storeButton = new JButton("Go to store");
      p2.add(storeButton);
      p.add(p2);
      
      JPanel p3 = new JPanel(new GridLayout(2,1));
      p3.setBorder(BorderFactory.createTitledBorder("Item: "));
      String[] itemNames = {"Cheap meds", "Antibiotics"};
      itemChoice = new JComboBox<>(itemNames);
      p3.add(itemChoice);
      useItemButton = new JButton("Consume item");
      p3.add(useItemButton);
      p.add(p3);
      
      JPanel outerPanel = new JPanel(new BorderLayout());
      outerPanel.add(p, BorderLayout.CENTER);
      tickSearchButton = new JButton("Perform a tick search");
      outerPanel.add(tickSearchButton, BorderLayout.SOUTH);
      return outerPanel;
    }

    protected JPanel makeOutput(){
      JPanel p = new JPanel(new BorderLayout());
      myOutput = new JTextArea();
      myOutput.setColumns(50);
      myOutput.setRows(10);
      myOutput.setEditable(false);
      JScrollPane sp = new JScrollPane(myOutput,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      p.setBorder(BorderFactory.createTitledBorder("Game Information: "));
      p.add(sp, BorderLayout.CENTER);
      return p;
    }

    protected JPanel makeVariableTracker() {
      JPanel p = new JPanel(new GridLayout(5,0));
      JLabel streetCredLabel = new JLabel("   Street cred: " + streetCredValue);
      JLabel workCredLabel = new JLabel("   Work cred: " + workCredValue);
      JLabel healthLabel = new JLabel("   Health: " + healthValue);
      JLabel infectionStageLabel = new JLabel("   Infection stage: " + infectionStageString);
      JLabel questTimeLabel = new JLabel("   Quest time remaining: " + remainingQuestTime);
      p.add(streetCredLabel);
      p.add(workCredLabel);
      p.add(healthLabel);
      p.add(infectionStageLabel);
      p.add(questTimeLabel);
      return p;
    }
    
    protected JPanel makeItemTracker() {
      JPanel p = new JPanel(new FlowLayout());
      p.setBorder(BorderFactory.createTitledBorder("Items Owned: "));
      
      JLabel tickTestsLabel = new JLabel("Number of tick tests: "+numberOfTickTests);
      p.add(tickTestsLabel);
      
      JLabel cheapMedsLabel = new JLabel("    Number of cheap meds: "+numberOfCheapMeds);
      p.add(cheapMedsLabel);
      
      JLabel antibioticsLabel = new JLabel("    Number of antibiotics: "+numberOfAntibiotics);
      p.add(antibioticsLabel);
      
      JLabel rangerGearLabel = new JLabel("    Ranger gear: "+rangerGear);
      p.add(rangerGearLabel);
      
      JLabel fishingRodLabel = new JLabel("    Fishing rod: "+fishingRod);
      p.add(fishingRodLabel);
      
      return p;
    }

    protected void connectEvents(){
      connectQuestEvent();
      connectStoreEvent();
      connectItemEvent();
      connectTickSearchEvent();
    }
    
    protected void connectQuestEvent(){
      questButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
          myController.process((String)questChoice.getSelectedItem());
        }
      });
    }

    protected void connectStoreEvent(){
      storeButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
          myController.process((String)storeChoice.getSelectedItem());
        }
      });
    }
   
    protected void connectItemEvent(){
      questButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
          myController.process((String)itemChoice.getSelectedItem());
        }
      });
    }
    
    protected void connectTickSearchEvent(){
      tickSearchButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
          myController.process("Tick search");
        }
      });
    }
    
    public void update(String infoString){
      myOutput.setText(infoString);
    }
    
    public void updateStreetCred(int streetCredValue) {
      this.streetCredValue = streetCredValue;
    }
    public void updateWorkCred(int workCredValue) {
      this.workCredValue = workCredValue;
    }
    public void updateHealth(int healthValue) {;
      this.healthValue = healthValue;
    }
    /* Add update methods for these.
    protected String       infectionStageString;
    protected int          remainingQuestTime;
    protected int          numberOfTickTests;
    protected int          numberOfCheapMeds;
    protected int          numberOfAntibiotics;
    protected String       rangerGear; // MAYBE REPLACE THIS WITH AN ENUM???
    protected String       fishingRod;
   */

    public void showMessage(String s) {
      myMessage.setText(s);
    }
	
    public void showError(String s){
      JOptionPane.showMessageDialog(this,s,"Controller Error",
            JOptionPane.ERROR_MESSAGE);
    }

}
