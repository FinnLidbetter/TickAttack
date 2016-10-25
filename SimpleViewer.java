import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class SimpleViewer extends JFrame implements IView{
    protected JTextField myInput;
    protected JList      myOutput;
    protected IModel     myModel;
    protected String     myTitle;
    protected String     myLabelString;
    protected JTextField myMessage;
    
    protected static JFileChooser ourChooser = new JFileChooser(".");
    
    
    public SimpleViewer(String title, String prompt){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        JPanel panel = (JPanel) getContentPane();
        panel.setLayout(new BorderLayout());
        setTitle(title);
        myTitle = title;
        myLabelString = prompt;
		
        if (! prompt.equals("")){
            panel.add(makeInput(),  BorderLayout.NORTH);
        }
        
        panel.add(makeOutput(), BorderLayout.CENTER);
        panel.add(makeMessage(), BorderLayout.SOUTH);
        makeMenus();
        connectEvents();
		
        pack();
        setSize(400,400);
        setVisible(true);
    }

    public void setModel(IModel model){
        myModel = model;
        model.addView(this);
    }

    protected JPanel makeMessage(){
    	JPanel p = new JPanel(new BorderLayout());
    	myMessage = new JTextField(30);
    	p.setBorder(BorderFactory.createTitledBorder("message"));
    	p.add(myMessage, BorderLayout.CENTER);
    	return p;
    }
    
    protected JPanel makeInput(){
        JPanel p = new JPanel(new BorderLayout());
        JLabel label = new JLabel(myLabelString);
        myInput = new JTextField(12);
        p.setBorder(BorderFactory.createTitledBorder("input"));
        p.add(label,   BorderLayout.WEST);
        p.add(myInput, BorderLayout.CENTER);
        return p;
    }

    protected JPanel makeOutput(){
        JPanel p = new JPanel(new BorderLayout());
        myOutput = new JList();
        myOutput.setVisibleRowCount(10);
        p.setBorder(BorderFactory.createTitledBorder("output"));
        p.add(new JScrollPane(myOutput), BorderLayout.CENTER);
        return p;
	
    }

    protected JMenu makeFileMenu(){
        JMenu fileMenu = new JMenu("File");
		
        fileMenu.add(new AbstractAction("Open"){
        public void actionPerformed(ActionEvent ev){
		    int retval = ourChooser.showOpenDialog(null);
		    if (retval == JFileChooser.APPROVE_OPTION){
                File file = ourChooser.getSelectedFile();
                try {
                    myModel.initialize(new Scanner(file));
                } catch (FileNotFoundException e) {
                    showError("could not open "+file.getName());
                }
		    }		    
		}
	    });
			
        fileMenu.add(new AbstractAction("Quit"){
            public void actionPerformed(ActionEvent ev){
                System.exit(0);
            }
	    });
        return fileMenu;
    }
    
    protected void makeMenus(){
        JMenuBar bar = new JMenuBar();
        bar.add(makeFileMenu());
        setJMenuBar(bar);
    }

    protected void connectEvents(){
        if (myInput == null) return;
        
    	myInput.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev){
                myModel.process(ev.getActionCommand());
            }
	    });
    }

   
    public void update(Collection elements){
        Object[] array = elements.toArray();
        myOutput.setListData(array);
        if (myInput != null){
            myInput.setText("");
        }
        showMessage("");
    }
    

    public void showMessage(String s) {
        myMessage.setText(s);
    }
	
    public void showError(String s){
        JOptionPane.showMessageDialog(this,s,"Model Error",
				      JOptionPane.ERROR_MESSAGE);
        if (myInput != null){
            myInput.setText("");
        }
    }
}
