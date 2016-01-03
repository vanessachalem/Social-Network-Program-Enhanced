package pa07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates an action listener for the getFriendsSameAgeButton which will call the getFriendsSameAge() method
 * @author Vanessa
 *
 */
public class SameAgeActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Network.getFriendsSameAge();

	}


}
