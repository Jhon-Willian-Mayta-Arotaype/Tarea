import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioOperaciones extends JFrame{
    private JButton But_Operar;
    private JTextField textNum1;
    private JTextField textN2;
    private JTextField text_Resul;
    private JComboBox Combo_Operaciones;
    private JPanel Operacions;
    private JRadioButton but_B1_B2;
    private JRadioButton But_B2_B1;
    private JCheckBox Redondear;

    public FormularioOperaciones(){
        setContentPane(Operacions);
        setTitle("Es hora de operar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        Combo_Operaciones.addItem("Sumar");
        Combo_Operaciones.addItem("Restar");
        Combo_Operaciones.addItem("Multiplicar");
        Combo_Operaciones.addItem("Dividir");


        But_Operar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double x,y,r=0.0;//Es necesario inicializar "r"
                String operacion;

                x = Double.parseDouble(textNum1.getText());
                y = Double.parseDouble(textN2.getText());

                switch (Combo_Operaciones.getSelectedItem().toString()){

                    case "Sumar":
                        r = x+y;
                        break;
                    case "Restar":
                        if (But_B2_B1.isSelected()){
                            r=y-x;
                        }else{
                            r=x-y;
                        }
                        break;
                    case "Multiplicar":
                        r = x*y;
                        break;
                    case "Dividir":
                        if (But_B2_B1.isSelected()){
                            r=y/x;
                        }else{
                            r=x/y;
                        }
                        break;
                }
                text_Resul.setText(Double.toString(r));
                if (Redondear.isSelected()){
                    String text_result = String.format("%.2f",r);
                    text_Resul.setText(text_result);
                }else
                    text_Resul.setText(Double.toString(r));
            }
        });
        ButtonGroup group = new ButtonGroup();
        group.add(but_B1_B2);
        group.add(But_B2_B1);
        Redondear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
    public static void main(String[] args) {
        new FormularioOperaciones();
    }
}
