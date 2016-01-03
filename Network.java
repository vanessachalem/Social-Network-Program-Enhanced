package pa07;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


/**
 * creates simple social network
 * where people can add/remove friends, see their current friends and see which friends are their same age 
 * implements GUIs within the Network class allowing users to interact with the program through dialog boxes, and buttons in a frame 
 * @author Vanessa
 * @version updated 5/23/13
 */
@SuppressWarnings("serial")
public class Network extends JPanel{
	static Set<Person> friendSet;	
	public static Person user = null;
	
	/**
	 * constructor
	 * creates social network object 
	 */
	public Network(){
		friendSet = new HashSet<Person>(); 
	}
	
	/**
	 * adds Person p as a friend of the user
	 * @param Person p
	 */
	public static void addFriend(Person p){
		friendSet.add(p);
			
	}
			
	/**
	 * removes Person p from the user's set of friends 
	 * @param Person p
	 */
	public static void removeFriend(Person p){
			friendSet.remove(p);	
			JOptionPane.showMessageDialog(null, "You have just removed " + p.getName());
		
	}
		
	/**
	 * allows user to remove all of his/her friends
	 */
	public static void removeAllFriends(){
		friendSet.removeAll(friendSet);
		JOptionPane.showMessageDialog(null, "You have just removed all of your friends");
	}
	
	/**
	 * determines which are the user's friends
	 * and returns a set of their names  
	 * @return Set<String> getFriendNames
	 */
	public static Set<String> getFriends(){
		Set<String> getFriendNames = new HashSet<String>();
			for(Person friend: friendSet){
				getFriendNames.add(friend.getName());	
			}
			return getFriendNames;
	}
	
	/**
	 * using JOptionPane prints a set of the user's friend's names
	 */
	public static void getFriendNames() {
		if (getFriends().isEmpty()){
			JOptionPane.showMessageDialog(null, "You currently have no friends");
		}else{
			JOptionPane.showMessageDialog(null, "Your friends are:" + getFriends());		
		}
	}
	
	/**
	 * determines which of the user's friends have the same age as him/her
	 * and returns a set of their names
	 * @return Set<String> friendsSameAge
	 */
	public static void getFriendsSameAge(){
		Set<String> friendsSameAge = new HashSet<String>();
		for(Person r: friendSet){
			if(r.getAge() == user.getAge()){
				friendsSameAge.add(r.getName());
			}
		}
		
		if(friendsSameAge.isEmpty()){
			JOptionPane.showMessageDialog(null, "You have no friends of your same age");
		}else{
			JOptionPane.showMessageDialog(null, "Your friends of your same age are:" + friendsSameAge);
		}	
	}
	
	/**
	 * Prompts for user info in a dialogue box
	 * Creates a Person object with this info
	 * @return Person user
	 */
	public static Person userInfo(){
		//dialog box prompts for user's info
		String name1 = JOptionPane.showInputDialog(null,"name:");
		String age1 = JOptionPane.showInputDialog(null,"age:");
		//converts Person's age to int 
		int agePerson = Integer.parseInt(age1);
		//creates and returns Person object with this name and age
		Person user = new Person(name1,agePerson);
		return user;
	}
		
	/**
	 * Prompts for friend's info in a dialogue box
	 * Creates a Person object with this info which is then added as a friend
	 */		
	public static void enterFriendInfo(){
		//dialog box prompts user for friend's info 
		String friendName = JOptionPane.showInputDialog(null,"friend's name:");
		String friendAge = JOptionPane.showInputDialog(null,"friend's age:");
		//converts Person's age to int 
		int agef = Integer.parseInt(friendAge);					
		//creates Person object with this name and age 
		Person friend = new Person(friendName, agef);
		//calls method addFriend with friend as parameters
		addFriend(friend);
		//calls method getFriends
		JOptionPane.showMessageDialog(null, "These are your current friends:" + getFriends());
	}

	
	/**
	 * prints a list for the user of all of the friends that he/she has
	 * and then allows him to type in the info of the one that he wants to remove
	 * @param Person p Network currentNetwork
	 */
	public static void whichFriend(){
		//dialog box prompts user for friend's info 
		String friendName1 = JOptionPane.showInputDialog("These are your current friends:"+ getFriends() + "\n please enter the name of the friend you would like to remove");
		String friendAge1 = JOptionPane.showInputDialog(null,"What is his/her age:");
		//converts Person's age to int 
		int agef = Integer.parseInt(friendAge1);					
		Person friendToRemove = new Person(friendName1, agef);
		//calls method removeFriend with friendToRemove as parameters
		removeFriend(friendToRemove);		
	}
	
	/**
	 * contains a frame with an "Exit" button which will end the user's use of the network
	 */
	public static void exit(){
		//creates frame 
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setEnabled(true);
		frame.setTitle("The Social Network");
		frame.setSize(new Dimension(600, 200));
		frame.setLayout(new FlowLayout());
		//creates a label 
		JLabel label1 = new JLabel("Thank you for visiting the social network!!!!");
		JLabel label2 = new JLabel("These are your friends" + getFriends());
		JLabel label3 = new JLabel("Come again to acquire more friends!"); 
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);
		JButton buttonExit = new JButton("Exit!");
		//creates action listener and adds it to button to read commands
		ActionListener a = new ExitListener();
		buttonExit.addActionListener(a);
		frame.add(buttonExit);				
	}

	/**
	 * creates a frame with buttons giving the user options to determine what he would like to do
	 * @param user 
	 */
	public void userOptions(){
		//creates frame 
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setEnabled(true);
		frame.setTitle("The Social Network");
		frame.setSize(new Dimension(400, 200));
		frame.setLayout(new FlowLayout());
		//creates a label and adds it to frame
		JLabel label = new JLabel("What would you like to do?"); 
		frame.add(label);
		
		//creates buttons with action listeners and adds them to frame
		JButton buttonAddFriends = new JButton("Add Friends");
		ActionListener b = new AddFriendsActionListener();
		buttonAddFriends.addActionListener(b);
		frame.add(buttonAddFriends);
			
		JButton buttonRemoveFriends = new JButton("Remove Friends");
		ActionListener c = new RemoveFriendsActionListener();
		buttonRemoveFriends.addActionListener(c);
		frame.add(buttonRemoveFriends);
		
		JButton buttonRemoveAll = new JButton("Remove All Friends");
		ActionListener d = new RemoveAllActionListner();
		buttonRemoveAll.addActionListener(d);
		frame.add(buttonRemoveAll);
		
		JButton buttonGetFriends = new JButton ("Get list of friends");
		ActionListener e = new GetFriendsActionListener();
		buttonGetFriends.addActionListener(e);
		frame.add(buttonGetFriends);
			
		JButton buttonGetFriendsSameAge = new JButton ("Get list of friends of your same age");
		ActionListener f = new SameAgeActionListener();
		buttonGetFriendsSameAge.addActionListener(f);
		frame.add(buttonGetFriendsSameAge);
		
		JButton buttonSignOut = new JButton("Sign Out!");
		//creates action listener and adds it to button to read commands
		ActionListener exit = new SignOutListener();
		buttonSignOut.addActionListener(exit);
		frame.add(buttonSignOut);	
		
	}
	
	/**
	 * Main method 
	 * Creates a Network object and allows the user to input his information and 
	 * then select what he would like to do through the buttons that are created 
	 * in a frame when the userOptions() method is called 
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException{
		Network socialNetwork = new Network();
		int login = JOptionPane.showConfirmDialog(null, "Welcome to the social network! \n Would you like to login?");
		//if the user selects "yes" - call the userInfo() method
		if(login == JOptionPane.YES_OPTION){
			user = Network.userInfo();		
		//else exit the program
		}else{
			JOptionPane.showMessageDialog(null, "exiting...come again!");
			return;
		}
		
		//call method userOptions() 
		socialNetwork.userOptions();
			
	}

}
