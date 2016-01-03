package pa07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates an action listener for the RemoveFriendsButton which will call the removeFriends() method
 * @author Vanessa
 *
 */
public class RemoveFriendsActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Network.whichFriend();
	}

}
