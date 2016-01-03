package pa07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates an action listener for the removeAllButton which will call the removeAllFriends() method
 * @author Vanessa
 *
 */
public class RemoveAllActionListner implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		 Network.removeAllFriends();
		

	}

}
