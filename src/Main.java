import java.awt.*;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;

public class Main extends JFrame {
    //Variables
    JLabel label;
    JLabel tempLabel;
    JLabel inputTemp;
    JLabel result;
    JTextField textCels;
    JButton convert;
    JRadioButton fahrenheitToCelsius;
    JRadioButton celsiusToFahrenheit;


    public Main () {

        super ("Temperature Converter"); //Title
        setLayout (new FlowLayout ());

        tempLabel = new JLabel ("Temperature Converter\n", SwingConstants.CENTER);
        tempLabel.setFont(new Font("Serif", Font.PLAIN, 25));
        tempLabel.setForeground(Color.RED);
        add (tempLabel);

        label = new JLabel ("Choose Conversion Type: ", SwingConstants.CENTER);
        add(label);

        fahrenheitToCelsius = new JRadioButton("Fahrenheit To Celsius", true);
        fahrenheitToCelsius.setHorizontalAlignment(SwingConstants.CENTER);
        celsiusToFahrenheit = new JRadioButton("Celsius To Fahrenheit", true);
        celsiusToFahrenheit.setHorizontalAlignment(SwingConstants.CENTER);

        convert = new JButton ("Convert Temperature");
        add (convert);


        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(fahrenheitToCelsius);
        bgroup.add(celsiusToFahrenheit);

        inputTemp = new JLabel ("Enter the temperature to convert: ", SwingConstants.CENTER); //Input
        add(inputTemp);

        result = new JLabel ("", SwingConstants.CENTER);
        add(result);

        textCels = new JTextField (5);
        textCels.setMaximumSize(new Dimension(40, 40));
        add (textCels);

        JPanel panel = new JPanel(new GridLayout(10, 1, 12, 6));
        panel.add(tempLabel);
        panel.add(label);

        panel.add(fahrenheitToCelsius);
        panel.add(celsiusToFahrenheit);
        panel.add(inputTemp);
        panel.add(textCels);
        panel.add(result);
        panel.add(convert);

        add(panel, BorderLayout.NORTH);

        convert.addActionListener(new Convert());

    }

    private class Convert implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (fahrenheitToCelsius.isSelected()){
                double conFahToCel = (Double.parseDouble(textCels.getText()) - 32)* (5.0/9.0);
                result.setText("The tempearture converts to: "+ new DecimalFormat("##.0").format(conFahToCel) +" degrees Celsius");
            } // if else statement used to change from F to C and C to F
            else if(celsiusToFahrenheit.isSelected()){
                double conCelToFah = (Double.parseDouble(textCels.getText())* (9.0/5.0)) + 32;
                result.setText("The tempearture converts to: "+ new DecimalFormat("##.0").format(conCelToFah) +" degrees Fahrenheit");
            }

        }
    }


    public static void main(String[] args){
        Main app = new Main ();
        app.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        app.setSize (500, 350); // set the frame size
        app.setVisible (true); // display frame
    }

}