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
    protected JLabel       streetCredLabel;
    protected JLabel       workCredLabel;
    protected JLabel       healthLabel;
    protected JLabel       infectionStageLabel;
    protected JLabel       remainingQuestTimeLabel;
    protected JLabel       numberOfTickTestsLabel;
    protected JLabel       numberOfCheapMedsLabel;
    protected JLabel       numberOfAntibioticsLabel;
    protected JLabel       rangerGearLabel;
    protected JLabel       fishingRodLabel;
    
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
      
      p.add(makeQuestButton());
      p.add(makeStoreButton());
      p.add(makeUseItemButton());

      JPanel outerPanel = new JPanel(new BorderLayout());
      outerPanel.add(p, BorderLayout.CENTER);
      tickSearchButton = new JButton("Perform a tick search");
      outerPanel.add(tickSearchButton, BorderLayout.SOUTH);
      return outerPanel;
    }
    private JPanel makeQuestButton() {
      JPanel p = new JPanel(new GridLayout(2,1));
      p.setBorder(BorderFactory.createTitledBorder("Quest: "));
      String[] questNames = {"Ranger quest", "Fishing quest"};
      questChoice = new JComboBox<>(questNames);
      p.add(questChoice);
      questButton = new JButton("Perform quest");
      p.add(questButton);
      return p;
    }
    private JPanel makeStoreButton() {
      JPanel p = new JPanel(new GridLayout(2,1));
      p.setBorder(BorderFactory.createTitledBorder("Store: "));
      String[] storeNames = {"Cheap Local Store","Big Expensive Foreign Store"};
      storeChoice = new JComboBox<>(storeNames);
      p.add(storeChoice);
      storeButton = new JButton("Go to store");
      p.add(storeButton);
      return p;
    }
    private JPanel makeUseItemButton() {
      JPanel p = new JPanel(new GridLayout(2,1));
      p.setBorder(BorderFactory.createTitledBorder("Item: "));
      String[] itemNames = {"Cheap meds", "Antibiotics"};
      itemChoice = new JComboBox<>(itemNames);
      p.add(itemChoice);
      useItemButton = new JButton("Consume item");
      p.add(useItemButton);
      return p;
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
      p.add(makeStreetCredLabel());
      p.add(makeWorkCredLabel());
      p.add(makeHealthLabel());
      p.add(makeInfectionStageLabel());
      p.add(makeRemainingQuestTimeLabel());
      return p;
    }
    
    private JPanel makeStreetCredLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Street Cred: "));
      streetCredLabel = new JLabel("");
      p.add(streetCredLabel);
      return p;
    }
    
    private JPanel makeWorkCredLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Work Cred: "));
      workCredLabel = new JLabel("");
      p.add(workCredLabel);
      return p;
    }
    
    private JPanel makeHealthLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Health: "));
      healthLabel = new JLabel("");
      p.add(healthLabel);
      return p;
    }
    
    private JPanel makeInfectionStageLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Infection Stage: "));
      infectionStageLabel = new JLabel("");
      p.add(infectionStageLabel);
      return p;
    }
    
    private JPanel makeRemainingQuestTimeLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Remaining Quest Time: "));
      remainingQuestTimeLabel = new JLabel("");
      p.add(remainingQuestTimeLabel);
      return p;
    }
    
    protected JPanel makeItemTracker() {
      JPanel p = new JPanel(new FlowLayout());
      p.setBorder(BorderFactory.createTitledBorder("Items Owned: "));
      p.add(makeNumberOfTickTestsLabel());
      p.add(makeNumberOfCheapMedsLabel());
      p.add(makeNumberOfAntibioticsLabel());
      p.add(makeRangerGearLabel());
      p.add(makeFishingRodLabel());
      return p;
    }
     
    private JPanel makeNumberOfTickTestsLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("Number of Tick Tests: "));
      numberOfTickTestsLabel = new JLabel("");
      p.add(numberOfTickTestsLabel);
      return p;
    }
    
    private JPanel makeNumberOfCheapMedsLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("   Number of Cheap Meds: "));
      numberOfCheapMedsLabel = new JLabel("");
      p.add(numberOfCheapMedsLabel);
      return p;
    }

    private JPanel makeNumberOfAntibioticsLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("   Number of Antibiotics: "));
      numberOfAntibioticsLabel = new JLabel("");
      p.add(numberOfAntibioticsLabel);
      return p;
    }
    
    private JPanel makeRangerGearLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("   Ranger Gear: "));
      rangerGearLabel = new JLabel("");
      p.add(rangerGearLabel);
      return p;
    }
    
    private JPanel makeFishingRodLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("   Fishing Rod: "));
      fishingRodLabel = new JLabel("");
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
      useItemButton.addActionListener(new ActionListener(){
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
      streetCredLabel.setText(""+streetCredValue);
      
    }
    public void updateWorkCred(int workCredValue) {
      workCredLabel.setText(""+workCredValue);
    }
    public void updateHealth(int healthValue) {
      healthLabel.setText(""+healthValue);
    }
    public void updateInfectionStageString(double infectionStage) {
      String infectionStageString = "";
      switch((int)infectionStage) {
        case 0:
          infectionStageString = "Feeling fine";
          break;
        case 1:
          infectionStageString = "Early Stages";
          break;
        case 2:
          infectionStageString = "Middle Stages";
          break;
        case 3:
          infectionStageString = "Late Stages";
          break;
      }
      infectionStageLabel.setText(infectionStageString);
    }
    
    public void updateRemainingQuestTime(int timeRemaining) {
      remainingQuestTimeLabel.setText(""+timeRemaining);
    }
    
    public void updateNumberOfTickTests(int numTickTests) {
      numberOfTickTestsLabel.setText(""+numTickTests);
    }
    
    public void updateNumberofCheapMeds(int numCheapMeds) {
      numberOfCheapMedsLabel.setText(""+numCheapMeds);
    }
    
    public void updateRangerGear(String newRangerGear) {
      rangerGearLabel.setText(newRangerGear);
    }
    
    public void updateFishingRod(String newFishingRod) {
      fishingRodLabel.setText(newFishingRod);
    }
    
    public void showMessage(String s) {
      myMessage.setText(s);
    }
  
    public void showError(String s){
      JOptionPane.showMessageDialog(this,s,"Controller Error",
            JOptionPane.ERROR_MESSAGE);
    }
}