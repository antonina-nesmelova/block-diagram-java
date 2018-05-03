package schema.window;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class Choice extends JPanel implements ItemListener {
	  public Choice() {
		  JComboBox type_choice = new JComboBox(); 
	      BlockShape.panel.add(type_choice);
	      type_choice.setBounds(13, 12, 70, 22);
	      type_choice.addItem("Water"); 
	      type_choice.addItem("Alkohol"); 
	      type_choice.addItem("Energy"); 
	      type_choice.addItemListener((ItemListener) this); 
	  }

	  public void itemStateChanged(ItemEvent ie) {
	      BlockShape.sel_ch = (String)ie.getItem();
	  }    
}
