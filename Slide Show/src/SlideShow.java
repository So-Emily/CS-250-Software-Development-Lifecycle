import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private JPanel bottomPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		//Changed the text background color
		textPane.setBackground(Color.PINK);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		// Changed the text panel to a basic panel to make it work with the buttons and text easier
		bottomPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		// Added wellness and detox to title
		setTitle("Top 5 Wellness and Detox Destinations SlideShow");
		getContentPane().setLayout(new BorderLayout(10, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		bottomPane.setLayout(new BorderLayout());
		bottomPane.add(textPane, BorderLayout.CENTER);
		bottomPane.add(buttonPane, BorderLayout.SOUTH);

		getContentPane().add(bottomPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */

	// Changed all the images to added wellness/detox images
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/boat-yoga.jpg") + "'</body></html>";
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/beach-yoga.jpg") + "'</body></html>";
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/green-yoga.jpg") + "'</body></html>";
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/mountain-yoga.jpg") + "'</body></html>";
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/ny-yoga.jpg") + "'</body></html>";
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */

	// Slides have been updated with a wellness/detox vacation based title and description 
	private String getTextDescription(int i) {
		String text = ""; 
		if (i==1){
			// Slide 1 is boat yoga in greece
			text = "<html><body><font size='5'><b>Greek Islands, Greece</b></font><br>"
				+ "Practice yoga on the open water while sailing between beautiful islands. "
				+ "It’s peaceful, scenic, and slightly impressive if you can balance during waves."
				+ "</body></html>";
		} else if (i==2){
			// Slide 2 is beach yoga in mexico
			text = "<html><body><font size='5'><b>Tulum, Mexico</b></font><br>"
				+ "Relax with beachfront yoga and meditation along the Caribbean coast. "
				+ "Basically, it’s the kind of place where your stress disappears faster than your phone battery"
				+ "</body></html>";
		} else if (i==3){
			// Slide 3 is green yoga in bali
			text = "<html><body><font size='5'><b>Ubud, Bali, Indonesia</b></font><br>"
				+ "Rejuvenate with detox programs, fresh juices, and daily yoga sessions in a tropical jungle setting. "
				+ "Yes, this is where people go to 'find themselves' (and drink a lot of green smoothies)."
				+ "</body></html>";
		} else if (i==4){
			// Slide 4 is mountain yoga in colorado
			text = "<html><body><font size='5'><b>Aspen, Colorado</b></font><br>"
				+ "Reconnect with nature through mountain-top yoga, fresh air, and incredible views. "
				+ "Bonus: you’ll feel extremely outdoorsy even if this is your only hike."
				+ "</body></html>";
		} else if (i==5){
			// Slide 5 is new york city yoga
			text = "<html><body><font size='5'><b>New York City, USA</b></font><br>"
				+ "Find your balance with outdoor yoga in the middle of a busy city. "
				+ "It’s calm, it’s chaotic, and yes… there might be a taxi honking in the background."
				+ "</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}