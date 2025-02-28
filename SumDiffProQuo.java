import javax.swing.JOptionPane;

public class SumDiffProQuo {
    public static void main(String[] args) {
        String strNumber1, strNumber2;

        strNumber1 = JOptionPane.showInputDialog(null, "Input first number: ", "First number", JOptionPane.INFORMATION_MESSAGE);
        strNumber2 = JOptionPane.showInputDialog(null, "Input second number: ", "Second number", JOptionPane.INFORMATION_MESSAGE);
        
        double num1 = Double.parseDouble(strNumber1);
        double num2 = Double.parseDouble(strNumber2);
        double sum = num1 + num2;
        double diff = num1 - num2;
        double pro = num1 * num2;
        double quo = num1 / num2;

        String SUM = "Sum: " + num1 + " + " + num2 + " = " + sum;
        String DIFF = "Difference: " + num1 + " - " + num2 + " = " + diff;
        String PRO = "Product: " + num1 + " x " + num2 + " = " + pro;
        String QUO = "Quotient: " + num1 + " / " + num2 + " = " + quo;

        JOptionPane.showMessageDialog(null, SUM, "Display Sum of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, DIFF, "Display Difference of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, PRO, "Display Product of two numbers", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, QUO, "Display Quotient of two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
