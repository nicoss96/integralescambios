
package integrales;

import static integrales.metodos.alto;
import static integrales.metodos.ancho;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class integrales extends JFrame{
    
    metodos grafica = new metodos();
    static String strInput;
    JButton BotonGraficar = new JButton("Graficar");
    JButton BotonIntegrar = new JButton("Integrar");
   
    JLabel Xmax = new JLabel("X max");
    JLabel Xmin = new JLabel("X min");
    JLabel Ymax = new JLabel("Y max");
    JLabel Ymin = new JLabel("Y min");
    JLabel Valores = new JLabel("Área entre:");
    JLabel Integral = new JLabel("El área es:");
    
    public static JTextField xmax = new JTextField("10");
    public static JTextField xmin = new JTextField("-10");
    public static JTextField ymax = new JTextField("10");
    public static JTextField ymin = new JTextField("-10");
    public static JTextField valor1 = new JTextField("");
    public static JTextField valor2 = new JTextField("");
    public static JTextArea integral1 = new JTextArea();
    //este si funciona xd
    JLabel tituloEcuacion = new JLabel("Ingrese Ecuación:");
    //double Amount = Double.parseDouble(txtMonth.getText(integrales.metodos.f(alto)));
    
    public static JTextField inputEcuacion = new JTextField(strInput);
   
    //JButton botonCalcular= new JButton("Calcular");



    Container C = getContentPane();
    
    int m1 = 0, m2 = 0, m3 = 0, m4 = 0, longitud1 = 0, longitud2 = 0, ejex = 0, ejey = 0;
    int n = 1000;
    int m5 ;
    double h = 0.01;
    
    public integrales(){
               
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(((Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width)/4), 
						(Toolkit.getDefaultToolkit().getScreenSize().height -  this.getSize().height)/6);
                this.setVisible(true);
                
        C.setLayout(null);
        grafica.setBounds(25, 25, metodos.ancho, metodos.alto);
        C.add(grafica);
        
        BotonGraficar.setBounds(530, 210, 90, 25);     
        BotonIntegrar.setBounds(530, 290, 90, 25);
        Valores.setBounds(540, 235, 90, 25);
        valor1.setBounds(530, 260, 30, 25);
        valor2.setBounds(590, 260, 30, 25);
        Integral.setBounds(530, 320, 90, 25);
        integral1.setBounds(530, 340, 90, 25);
        
        tituloEcuacion.setBounds(530,50,120,30);
        inputEcuacion.setBounds(530, 80, 100, 30);
        //botonCalcular.setBounds(530, 120, 100, 30);

        xmin.setBounds(25, 415, 30, 20);
        Xmin.setBounds(25, 440, 50, 25);
        xmax.setBounds(445, 415, 30, 20);
        Xmax.setBounds(445, 440, 50, 25);
        ymax.setBounds(495, 25, 30, 20);
        Ymax.setBounds(530, 25, 50, 25);
        ymin.setBounds(495, 380, 30, 20);
        Ymin.setBounds(530, 380, 50, 25);
        
        C.add(BotonGraficar);
        C.add(inputEcuacion);
        C.add(tituloEcuacion);
        //C.add(botonCalcular);
        C.add(BotonIntegrar);
        C.add(Valores);
        C.add(valor1);
        C.add(valor2);
        C.add(Integral);
        C.add(integral1);
        C.add(xmin);
        C.add(Xmin);
        C.add(xmax);
        C.add(Xmax);
        C.add(ymax);
        C.add(Ymax);
        C.add(ymin);
        C.add(Ymin);

        
        BotonGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                m1 = Integer.parseInt(integrales.xmin.getText());
                m2 = Integer.parseInt(integrales.xmax.getText());
                m3 = Integer.parseInt(integrales.ymax.getText());
                m4 = Integer.parseInt(integrales.ymin.getText());
                m5 = Integer.parseInt(integrales.inputEcuacion.getText());
             
                longitud1 = (int) ancho/(Math.abs(m1)+Math.abs(m2));
                longitud2 = (int) alto/(Math.abs(m3)+Math.abs(m4));
                
                double w = (0.004/2)*(m3+Math.abs(m4));
                double p = (0.50)/((Math.abs(m2)));
                
                for (int x = 0; x < 459; x++) {
                    double y = metodos.alto*p*metodos.f(w*(x+(m1*longitud1)))+(m3*longitud2);
                    
                    metodos.ejeX[x] = x;
                    metodos.ejeY[x] = y;
                }
                
                for (int i = 0; i < 459; i++) {
                    double y = alto*p*((metodos.f((w*(i+(m1*longitud1)))+h)-metodos.f((i+(m1*longitud1))*w))/h)+(m3*longitud2);
                    metodos.ejeX1[i] = i;
                    metodos.ejeY1[i] = y; 
                }
                grafica.repaint();
                
            }
        });
        
        BotonIntegrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                m1 = Integer.parseInt(integrales.xmin.getText());
                m2 = Integer.parseInt(integrales.xmax.getText());
                m3 = Integer.parseInt(integrales.ymax.getText());
                m4 = Integer.parseInt(integrales.ymin.getText());
                longitud1 = (int) ancho/(Math.abs(m1)+Math.abs(m2));
                longitud2 = (int) alto/(Math.abs(m3)+Math.abs(m4));
                
                double w = (0.004/2)*(m3+Math.abs(m4));
                double p = (0.50)/((Math.abs(m2)));
                String texto;
                texto = valor1.getText();
                double x1 = Double.parseDouble(texto);
                texto = valor2.getText();
                double x2 = Double.parseDouble(texto);
                int lim1 = ancho/2+((int)x1*longitud1);
                int lim2 = ancho/2+((int)x2*longitud1);
              
                System.out.println("Los limites son: "+lim1+" "+lim2);
                
                double g = (x2-x1)/n;
                double a, suma = 0;
                double d = g/2*(metodos.f(x1)+metodos.f(x2));
                
                for (int i = 1; i < n; i++) {
                    a = g*metodos.f(x1+i*g);
                    suma = suma+a;
                }
                if(x1 == x2) {
                    suma = 0;
                }
                
                double Int = (-1)*(d+suma);
                integrales.integral1.setText(String.valueOf(Int));
                
                for (int x = lim1; x <= lim2; x++) {
                    double y = metodos.alto*p*metodos.f(w*(x+(m1*longitud1)))+(m3*longitud2);
                    metodos.ejeX2[x] = x;
                    metodos.ejeY2[x] = y;
                }
                grafica.repaint();
            }
        });
    }
   
    public static void main(String[] args) {
        integrales marco = new integrales();
        marco.setSize(800, 600);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   
}