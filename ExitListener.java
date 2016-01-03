package pa07;
import java.awt.event.*;

/**
 * creates an ExitListener implementing ActionLister
 * which will exit the program when the ExitButton is clicked
 * @author Vanessa
 *
 */
public class ExitListener implements ActionListener {
	
	public ExitListener(){
		
	}
	public void actionPerformed(ActionEvent a) {
			System.exit(0);
	}
}
		
	