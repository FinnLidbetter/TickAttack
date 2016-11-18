import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

/**
 * SimpleViewer class creates the GUI for the TickAttack game
 * @author Finn Lidbetter, Michael Bradet-Legris
 * @version 1.0, 16/10/31
 */

public class SimpleViewer extends JFrame implements IView {
    protected JLabel       streetCredLabel;
    protected JLabel       workCredLabel;
    protected JLabel       healthLabel;
    protected JLabel       infectionStageLabel;
    protected JLabel       timeToCompleteTaskLabel;
    protected JLabel       numberOfTickTestsLabel;
    protected JLabel       numberOfCheapMedsLabel;
    protected JLabel       numberOfAntibioticsLabel;
    protected JLabel       rangerGearLabel;
    protected JLabel       fishingRodLabel;

    protected JPanel       mainPanel;
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

      mainPanel = (JPanel) getContentPane();
      mainPanel.setLayout(new BorderLayout());
      setTitle(title);
      myTitle = title;
      myLabelString = prompt;

      mainPanel.add(makeVariableTracker(), BorderLayout.NORTH);
      mainPanel.add(makeOutput(), BorderLayout.CENTER);
      mainPanel.add(makeMessage(), BorderLayout.SOUTH);
      mainPanel.add(makeItemTracker(), BorderLayout.SOUTH);
      mainPanel.add(makeButtons(), BorderLayout.EAST);

      addKeyListenerToComponent(storeButton);
      addKeyListenerToComponent(useItemButton);
      addKeyListenerToComponent(questChoice);
      addKeyListenerToComponent(storeChoice);
      addKeyListenerToComponent(itemChoice);
      addKeyListenerToComponent(myOutput);
      connectEvents();

      pack();
      setSize(900,500);
      setVisible(true);
    }

    /**
     * Adds a key listener listening for numeric input to the specified JComponent
     * @param jComponent - component to add the key listener to
     */
    public void addKeyListenerToComponent(JComponent jComponent) {
      jComponent.addKeyListener(new KeyListener() {
        public void keyTyped(KeyEvent k) {
        }
        public void keyPressed(KeyEvent k) {
        }
        public void keyReleased(KeyEvent k) {
          int keyValue = k.getKeyCode();
          if (keyValue >= KeyEvent.VK_0 && keyValue <= KeyEvent.VK_9)
            myController.process(keyValue-KeyEvent.VK_0);
        }
      });
    }

    /**
     * Connects a controller to the view
     * @param controller - controller to connect to view
     */
    public void setController(IController controller){
      myController = controller;
      myController.addView(this);
    }

    /**
     * Creates a panel for displaying messages
     * @return panel for displaying messages
     */
    protected JPanel makeMessage(){
      JPanel p = new JPanel(new BorderLayout());
      myMessage = new JTextField(30);
      p.setBorder(BorderFactory.createTitledBorder("message"));
      p.add(myMessage, BorderLayout.CENTER);
      return p;
    }

    /**
     * Creates a button panel for user interaction
     * @return a panel with all of the buttons and their associated dropdown menus
     */
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

    /**
     * Makes a panel for the quest button
     * @return the quest button panel
     */
    private JPanel makeQuestButton() {
      JPanel p = new JPanel(new GridLayout(2,1));
      p.setBorder(BorderFactory.createTitledBorder("Quest: "));
      String[] questNames = {"Ranger Quest", "Fishing Quest"};
      questChoice = new JComboBox<>(questNames);
      p.add(questChoice);
      questButton = new JButton("Perform quest");
      p.add(questButton);
      return p;
    }

    /**
     * Makes a panel for the store button
     * @return the store button panel
     */
    private JPanel makeStoreButton() {
      JPanel p = new JPanel(new GridLayout(2,1));
      p.setBorder(BorderFactory.createTitledBorder("Store: "));
      String[] storeNames = {"Cheap Local Store","Expensive Across Border Store"};
      storeChoice = new JComboBox<>(storeNames);
      p.add(storeChoice);
      storeButton = new JButton("Go to store");
      p.add(storeButton);
      return p;
    }

    /**
     * Makes a panel for the useItem button
     * @return the useItem button panel
     */
    private JPanel makeUseItemButton() {
      JPanel p = new JPanel(new GridLayout(2,1));
      p.setBorder(BorderFactory.createTitledBorder("Item: "));
      String[] itemNames = {"Cheap Meds", "Antibiotics"};
      itemChoice = new JComboBox<>(itemNames);
      p.add(itemChoice);
      useItemButton = new JButton("Consume item");
      p.add(useItemButton);
      return p;
    }

    /**
     * Makes a panel for displaying game information
     * @return text area panel
     */
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

    /**
     * Makes a panel for displaying information about the player
     * @return the player information panel
     */
    protected JPanel makeVariableTracker() {
      JPanel p = new JPanel(new GridLayout(5,1));
      p.add(makeStreetCredLabel());
      p.add(makeWorkCredLabel());
      p.add(makeHealthLabel());
      p.add(makeInfectionStageLabel());
      p.add(makeTimeToCompleteTaskLabel());
      return p;
    }

    /**
     * Makes a panel for tracking player street cred
     * @return the street cred tracking panel
     */
    private JPanel makeStreetCredLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Street Cred: "));
      streetCredLabel = new JLabel("");
      p.add(streetCredLabel);
      return p;
    }

    /**
     * Makes a panel for tracking player work cred
     * @return the work cred tracking panel
     */
    private JPanel makeWorkCredLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Work Cred: "));
      workCredLabel = new JLabel("");
      p.add(workCredLabel);
      return p;
    }

    /**
     * Makes a panel for tracking player health
     * @return the health tracking panel
     */
    private JPanel makeHealthLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Health: "));
      healthLabel = new JLabel("");
      p.add(healthLabel);
      return p;
    }

    /**
     * Makes a panel for tracking player infection stage
     * @return the infection stage tracking panel
     */
    private JPanel makeInfectionStageLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Infection Stage: "));
      infectionStageLabel = new JLabel("");
      p.add(infectionStageLabel);
      return p;
    }

    /**
     * Makes a panel for tracking time remaining to complete a task
     * @return the time tracking panel
     */
    private JPanel makeTimeToCompleteTaskLabel() {
      JPanel p = new JPanel(new GridLayout(1,2));
      p.add(new JLabel("   Time Remaining to Complete Task: "));
      timeToCompleteTaskLabel = new JLabel("");
      p.add(timeToCompleteTaskLabel);
      return p;
    }

    /**
     * Makes a panel for storing information about the player's items
     * @return the item tracking panel
     */
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

    /**
     * Makes a panel for tracking player's tick test items
     * @return the tick test tracking panel
     */
    private JPanel makeNumberOfTickTestsLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("Number of Tick Tests: "));
      numberOfTickTestsLabel = new JLabel("");
      p.add(numberOfTickTestsLabel);
      return p;
    }

    /**
     * Makes a panel for tracking player's cheap meds items
     * @return the cheap meds tracking panel
     */
    private JPanel makeNumberOfCheapMedsLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("   Number of Cheap Meds: "));
      numberOfCheapMedsLabel = new JLabel("");
      p.add(numberOfCheapMedsLabel);
      return p;
    }

    /**
     * Makes a panel for tracking player's antibiotics items
     * @return the antibiotics tracking panel
     */
    private JPanel makeNumberOfAntibioticsLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("   Number of Antibiotics: "));
      numberOfAntibioticsLabel = new JLabel("");
      p.add(numberOfAntibioticsLabel);
      return p;
    }

    /**
     * Makes a panel for tracking player's best ranger gear item
     * @return the ranger gear tracking panel
     */
    private JPanel makeRangerGearLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("   Ranger Gear: "));
      rangerGearLabel = new JLabel("");
      p.add(rangerGearLabel);
      return p;
    }

    /**
     * Makes a panel for tracking player's best fishing rod item
     * @return the fishing rod tracking panel
     */
    private JPanel makeFishingRodLabel() {
      JPanel p = new JPanel(new FlowLayout());
      p.add(new JLabel("   Fishing Rod: "));
      fishingRodLabel = new JLabel("");
      p.add(fishingRodLabel);
      return p;
    }


    /**
     * Sets up the action listeners for each of the buttons
     */
    protected void connectEvents(){
      connectQuestEvent();
      connectStoreEvent();
      connectItemEvent();
      connectTickSearchEvent();
    }

    /**
     * Sets up the action listener for the quest button
     */
    protected void connectQuestEvent(){
      questButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
          myController.process((String)questChoice.getSelectedItem());
        }
      });
    }

    /**
     * Sets up the action listener for the store button
     */
    protected void connectStoreEvent(){
      storeButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
          myController.process((String)storeChoice.getSelectedItem());
        }
      });
    }

    /**
     * Sets up the action listener for the use item button
     */
    protected void connectItemEvent(){
      useItemButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
          myController.process((String)itemChoice.getSelectedItem());
        }
      });
    }

    /**
     * Sets up the action listener for the tick search button
     */
    protected void connectTickSearchEvent(){
      tickSearchButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ev) {
          myController.process("Tick Search");
        }
      });
    }

    /**
     * Updates the view based on the information stored in the player
     * @param playerInfo - the player reference used to get the information to update
     */
    public void update(Player playerInfo){
      updateStreetCred(playerInfo.getStreetCred());
      updateWorkCred(playerInfo.getWorkCred());
      updateHealth(playerInfo.getHealth());
      updateInfectionStage(playerInfo.getInfectionStage());
      updateTimeToCompleteTask(playerInfo.getTimeToCompleteTask());
      updateNumberOfTickTests(playerInfo.getNumTickTests());
      updateNumberofCheapMeds(playerInfo.getNumCheapMeds());
      updateNumberOfAntibiotics(playerInfo.getNumAntibiotics());
      updateFishingRod(playerInfo.getBestRod());
      updateRangerGear(playerInfo.getBestGear());
    }

    /**
     * Updates the view based on information stored in the player and sets the
     * text in the text area
     * @param playerInfo - the player reference used to get the information for the update
     * @param infoString - the string to display in the text area
     */
    public void update(Player playerInfo, String infoString) {
      update(playerInfo);
      myOutput.setText(infoString);
    }

    /**
     * Changes the displayed streetCredValue
     * @param streetCredValue - new StreetCred value
     */
    private void updateStreetCred(long streetCredValue) {
      streetCredLabel.setText(""+streetCredValue);
    }

    /**
     * Changes the displayed workCredValue
     * @param workCredValue - new WorkCred value
     */
    private void updateWorkCred(long workCredValue) {
      workCredLabel.setText(""+workCredValue);
    }

    /**
     * Changes the displayed healthValue
     * @param healthValue - new health value
     */
    private void updateHealth(double healthValue) {
      healthLabel.setText(""+((int)healthValue));
    }

    /**
     * Changes the displayed infection stage
     * @param infectionStage - new infectionStage value
     */
    private void updateInfectionStage(double infectionStage) {
      String infectionStageString = "";
      if (infectionStage<0.05) {
        infectionStageString = "Feeling fine";
      } else if (infectionStage<0.1) {
        infectionStageString = "Early Stages of Lyme Disease";
      } else if (infectionStage<0.15) {
        infectionStageString = "Middle Stages of Lyme Disease";
      } else {
        infectionStageString = "Late Stages of Lyme Disease";
      }
      infectionStageLabel.setText(infectionStageString);
    }

    /**
     * Changes the displayed time remaining to complete a task
     * @param timeRemaining - new time remaining value
     */
    private void updateTimeToCompleteTask(int timeRemaining) {
      if (timeRemaining==0) {
        timeToCompleteTaskLabel.setText("No active task");
      } else {
        timeToCompleteTaskLabel.setText(""+timeRemaining);
      }
    }

    /**
     * Changes the displayed number of Tick tests
     * @param numTickTests - new number of tick tests
     */
    private void updateNumberOfTickTests(int numTickTests) {
      numberOfTickTestsLabel.setText(""+numTickTests);
    }

    /**
     * Changes the displayed number of cheap meds
     * @param numCheapMeds - new number of cheap meds
     */
    private void updateNumberofCheapMeds(int numCheapMeds) {
      numberOfCheapMedsLabel.setText(""+numCheapMeds);
    }

    /**
     * Changes the displayed number of Antibiotics
     * @param numAntibiotics - new number of Antibiotics
     */
    private void updateNumberOfAntibiotics(int numAntibiotics) {
      numberOfAntibioticsLabel.setText(""+numAntibiotics);
    }

    /**
     * Changes the displayed ranger gear
     * @param newRangerGear - new ranger gear to display
     */
    private void updateRangerGear(RangerGear newRangerGear) {
      if (newRangerGear!=null)
        rangerGearLabel.setText(newRangerGear.getName());
      else
        rangerGearLabel.setText("None");
    }

    /**
     * Changes the displayed fishing rod
     * @param newFishingRod - new fishing rod to display
     */
    private void updateFishingRod(FishingRod newFishingRod) {
      if (newFishingRod!=null)
        fishingRodLabel.setText(newFishingRod.getName());
      else
        fishingRodLabel.setText("None");
    }

    /**
     * Displays a message in the view
     * @param s - the string to show as a message
     */
    public void showMessage(String s) {
      myMessage.setText(s);
    }

    /**
     * Shows a popup error message in the view
     * @param s - the string to show in the error message
     */
    public void showError(String s){
      JOptionPane.showMessageDialog(this,s,"Information",
            JOptionPane.ERROR_MESSAGE);
    }
}
