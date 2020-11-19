/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoU2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JPanel implements ActionListener{
    // ventana
    int op;
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[];
    public JMenuBar arc;
    public JMenu uno;
    public JMenuItem u0,u1,u2, u3, u4, u5, u6,u7;
    public JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6, btn7,btnmas,btnmenos,btninfo;
    public MouseListener mouse;
    public JPanel panelc;
    public Ventana(String titulo, Punto[] figura) {
           
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(980, 600);
        panelc= new JPanel();
        BorderLayout layout = new BorderLayout(20, 10);
        setLayout(layout);
        panelc.setLayout(new BorderLayout(500, 10));
        arc = new JMenuBar();
        uno = new JMenu("Acciones (Desplegable)");
        uno.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        u0 = new JMenuItem("Escalar");
        u1 = new JMenuItem("Traslación");
        u2 = new JMenuItem("Rotación (+)");
        u3 = new JMenuItem("Rotación (-)");
        u4 = new JMenuItem("Reflexión (X)");
        u5 = new JMenuItem("Reflexión (Y)");
        u6 = new JMenuItem("Reflexión (XY)");
        u7 = new JMenuItem("Reestablecer Fig");
        
        btn0= new JButton("Escalar");
        btn1= new JButton("Traslacion");
        btn2= new JButton("Rotación (+)");
        btn3= new JButton("Rotación (-)");
        btn4= new JButton("Reflexión (X)");
        btn5= new JButton("Reflexión (Y)");
        btn6= new JButton("Reflexión (XY)");
        btn7= new JButton("Restablecer Fig");
        
        btnmas= new JButton(new ImageIcon("src/ProyectoU2/Mas.png"));
        btnmenos= new JButton(new ImageIcon("src/ProyectoU2/Menos.png"));
        btninfo= new JButton(new ImageIcon("src/ProyectoU2/info.png"));
        
        add(arc, BorderLayout.NORTH);
        add(panelc, BorderLayout.EAST);
        
        arc.add(uno);
        arc.add(btn0);
        arc.add(btn1);
        arc.add(btn2);
        arc.add(btn3);
        arc.add(btn4);
        arc.add(btn5);
        arc.add(btn6);
        arc.add(btn7);
        
        panelc.add(btnmas,BorderLayout.NORTH);
        panelc.add(btnmenos,BorderLayout.SOUTH);
        panelc.add(btninfo,BorderLayout.CENTER);
        
        uno.add(u0);
        uno.add(u1);
        uno.add(u2);
        uno.add(u3);
        uno.add(u4);
        uno.add(u5);
        uno.add(u6);
        uno.add(u7);
        
        
        u0.addActionListener(this);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);
        u4.addActionListener(this);
        u5.addActionListener(this);
        u6.addActionListener(this);
        u7.addActionListener(this);
        
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        
        //metodos encargdaos de los eventos del Mouse
        mouse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource()==btnmas) {
                escalar(2.0,2.0);
                repaint();
                }else if(e.getSource()==btnmenos){
                escalar(.5,.5);
                repaint();
                 }else if(e.getSource()==btninfo){
                 JOptionPane.showMessageDialog(null, "Uso mouse: \n"+
                                                     "Click sobre boton con icono + : hace mas grande la figura \n"+
                                                     "Click sobre boton con icono - : hace mas pequeña la figura  \n"+
                                                     "Click sobre boton con icono 'info' : muestra informacion de controles \n\n"+
                                                     "Uso del teclado:   \n"+
                                                     "Tecla de la flechita hacia arriba : realiza un escalamieto \n "+
                                                     "Tecla 'T' : realiza una traslacion \n "+ 
                                                     "Tecla numerica '1' : realiza una rotacion de 90º positiva \n "+
                                                     "Tecla numerica '2' : realiza una rotacion de 90º negativa \n "+
                                                     "Tecla numerica '3' : realiza una reflexion X \n "+
                                                     "Tecla numerica '4' : realiza una reflexion Y  \n "+
                                                     "Tecla numerica '5' : realiza una reflexion XY  \n "+
                                                     "Tecla 'Z' : restablece la figura  \n "
                                                        );           
            }}

            @Override
            public void mousePressed(MouseEvent e) {
             }

            @Override
            public void mouseReleased(MouseEvent e) {
             }

            @Override
            public void mouseEntered(MouseEvent e) {
             }

            @Override
            public void mouseExited(MouseEvent e) {
             }
        };
        btnmas.addMouseListener(mouse);
        btnmenos.addMouseListener(mouse);
        btninfo.addMouseListener(mouse);
        


        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 800);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        ventana.setLocationRelativeTo(null);
        this.figura=figura;
        ventana.setFocusable(true);
        ventana.addKeyListener(new Listener(this));
    
     } 
    
    //metodo encargado de los eventos de los botones principales y del Menu desplegable
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == u0 ) {
            double x, y;
            x=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de x"));
            y=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de y"));
            this.escalar(x, y);
            repaint();
        }else if (e.getSource()== btn0) {
            this.escalar(1.5,1.5 );
            repaint();
        }
        else if (e.getSource() == u1) {
            int x, y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de x"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de y"));
                this.traslacion(x,y);
                repaint();
        }
       else if( e.getSource()== btn1){
                this.traslacion(100,100);
                repaint();
        }
        else if(e.getSource() == u2){
            Double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
                this.rotacion(angulo);
                repaint();
                
        }else if (e.getSource()== btn2) {
            this.rotacion(45);
                repaint();
        }
        else if(e.getSource() == u3  ){
             Double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo"));
                this.rotacion2(angulo);    
                 repaint();
        }else if (e.getSource()== btn3) {
           this.rotacion2(45);    
                 repaint(); 
        }
        else if(e.getSource() == u4 || e.getSource()== btn4){
                this.reflexionX();
                repaint();
        }
        else if(e.getSource() == u5 || e.getSource()== btn5){
                this.reflexionY();
                repaint();
        }
        else if(e.getSource() == u6 || e.getSource()== btn6){
                this.reflexionXY();
                repaint();
        }else if (e.getSource() == u7 || e.getSource()== btn7) {
              Punto figura[] = {
           new Punto (103, 103), 
            new Punto(105, 99), 
            new Punto(106, 98), 
            new Punto(108, 100), 
            new Punto(110, 104), 
            new Punto(112, 108), 
            new Punto(113, 112), 
            new Punto(113, 116), 
            new Punto(115, 115), 
            new Punto(119, 115), 
            new Punto(122, 115), 
            new Punto(124, 115), 
            new Punto(126, 116), 
            new Punto(125, 114), 
            new Punto(123, 110),
            new Punto(122, 106), 
            new Punto(119, 105), 
            new Punto(117, 103), 
            new Punto(116, 101), 
            new Punto(115, 97), 
            new Punto(115, 93), 
            new Punto(113, 92), 
            new Punto(111, 90), 
            new Punto(109, 88), 
            new Punto(108, 86), 
            new Punto(107, 82), 
            new Punto(105, 84), 
            new Punto(101, 86), 
            new Punto(100, 86), 
            new Punto(96, 85),
            new Punto(94, 83), 
            new Punto(92, 85), 
            new Punto(90, 87), 
            new Punto(89, 88), 
            new Punto(88, 88), 
            new Punto(87, 88), 
            new Punto(86, 87), 
            new Punto(83, 85), 
            new Punto(82, 85), 
            new Punto(78, 87), 
            new Punto(76, 88), 
            new Punto(75, 88), 
            new Punto(73, 87), 
            new Punto(75, 89), 
            new Punto(77, 92), 
            new Punto(79, 95), 
            new Punto(81, 100), 
            new Punto(85, 98), 
            new Punto(88, 96), 
            new Punto(90, 95), 
            new Punto(93, 94), 
            new Punto(96, 94), 
            new Punto(99, 94), 
            new Punto(99, 97), 
            new Punto(98, 101), 
            new Punto(100, 99), 
            new Punto(101, 100),
            new Punto(102, 100), 
            new Punto(103, 101), 
             };
    
        restablecer(figura);
        repaint();
        }}

    

    
    //calse encargada de los eventos del teclado
     class Listener implements KeyListener{
        Ventana ventana;

        
        public Listener(Ventana ventana){
        this.ventana = ventana;
        }
        @Override
        public void keyTyped(KeyEvent e) {
          }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.getKeyCode()== KeyEvent.VK_UP) {
                ventana.escalar(2, 2);
                repaint();
            } else if(ke.getKeyCode()== KeyEvent.VK_T) {
            ventana.traslacion(55, 55);
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_1){
                ventana.rotacion(90);
                repaint();
            }else if(ke.getKeyCode()== KeyEvent.VK_2){
                ventana.rotacion2(90);
                repaint();
        }else if(ke.getKeyCode()== KeyEvent.VK_3){
                ventana.reflexionX();
                repaint();
        }else if(ke.getKeyCode()== KeyEvent.VK_4){
                ventana.reflexionY();
                repaint();
        }else if(ke.getKeyCode()== KeyEvent.VK_5){
                ventana.reflexionXY();
                repaint();
        }else if(ke.getKeyCode()== KeyEvent.VK_Z){
              Punto figura[] = {
           new Punto (103, 103), 
            new Punto(105, 99), 
            new Punto(106, 98), 
            new Punto(108, 100), 
            new Punto(110, 104), 
            new Punto(112, 108), 
            new Punto(113, 112), 
            new Punto(113, 116), 
            new Punto(115, 115), 
            new Punto(119, 115), 
            new Punto(122, 115), 
            new Punto(124, 115), 
            new Punto(126, 116), 
            new Punto(125, 114), 
            new Punto(123, 110),
            new Punto(122, 106), 
            new Punto(119, 105), 
            new Punto(117, 103), 
            new Punto(116, 101), 
            new Punto(115, 97), 
            new Punto(115, 93), 
            new Punto(113, 92), 
            new Punto(111, 90), 
            new Punto(109, 88), 
            new Punto(108, 86), 
            new Punto(107, 82), 
            new Punto(105, 84), 
            new Punto(101, 86), 
            new Punto(100, 86), 
            new Punto(96, 85),
            new Punto(94, 83), 
            new Punto(92, 85), 
            new Punto(90, 87), 
            new Punto(89, 88), 
            new Punto(88, 88), 
            new Punto(87, 88), 
            new Punto(86, 87), 
            new Punto(83, 85), 
            new Punto(82, 85), 
            new Punto(78, 87), 
            new Punto(76, 88), 
            new Punto(75, 88), 
            new Punto(73, 87), 
            new Punto(75, 89), 
            new Punto(77, 92), 
            new Punto(79, 95), 
            new Punto(81, 100), 
            new Punto(85, 98), 
            new Punto(88, 96), 
            new Punto(90, 95), 
            new Punto(93, 94), 
            new Punto(96, 94), 
            new Punto(99, 94), 
            new Punto(99, 97), 
            new Punto(98, 101), 
            new Punto(100, 99), 
            new Punto(101, 100),
            new Punto(102, 100), 
            new Punto(103, 101), 
             };
    
        restablecer(figura);
        repaint();  
                
                
        }
            }
        @Override
        public void keyReleased(KeyEvent e) {
            }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        //Dibujar la figura original
        g.setColor(Color.darkGray);
        this.dibujar(g);
        
       
        
        //Dibujar la figura Original
//        g.setColor(Color.pink);
//        this.escalar(0.5, 0.5);
//        this.dibujar(g);
        
        //Traslacion (+)
//        g.setColor(Color.green);
//        this.traslacion(100, 80);
//        this.dibujar(g);
        
        //Rotacion (+)
//        g.setColor(Color.red);
//        this.rotacion(40);
//        this.dibujar(g);
        
        //Rotacion (-)
//        g.setColor(Color.gray);
//        this.rotacion2(45);
//        this.dibujar(g);
        
        //Reflexion (x)
//        g.setColor(Color.yellow);
//        this.reflexionX();
//        this.traslacion(200, 200);
//        this.dibujar(g);
        
        //Reflexion (y)
//        g.setColor(Color.cyan);
//        this.reflexionY();
//        this.traslacion(200, 200);
//        this.dibujar(g);
        
        //Reflexion (x, y)
//        g.setColor(Color.magenta);
//        this.reflexionXY();
//        this.traslacion(200, 200);
//        this.dibujar(g);
        
        //Deformacion
        
    }
    //Accion de Reestablecer figura
   public void restablecer(Punto [] figura){
        this.figura = figura;
    }
    
    
    private void escalar(double fx, double fy){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for(Punto punto : figura){
        //Nueva x: ((a-tx) * fx) + tx
            punto.setX(
                (int)((punto.getX() - tx) * fx + tx)
            );
        //Nueva y: ((a-ty) * fy) + ty
            punto.setY(
                (int)((punto.getY() - ty) * fy + ty)
            );
        }
    }
    
    private void traslacion(double xf, double yf){
        for(Punto punto : figura){
        //Nueva x: a + xf
            punto.setX(
                (int)(punto.getX() + xf)
            );
        //Nueva y: a + yf
            punto.setY(
                (int)(punto.getY() + yf)
            );
        }
    }
   
    
    public void rotacion(double ang){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            //Nueva x: (x - tx) * cos ang - (y - ty) * sen ang + tx
            punto.setX(
                    (int)(((punto.getX() - tx ) * Math.cos(Math.toRadians(ang)) - ((punto.getY() - ty) * Math.sin(Math.toRadians(ang)))) + tx)
            );
            //Nueva x: (x - tx) * sen ang + (y - ty) * cos ang + 
            punto.setY(
                    (int)(((punto.getX() - tx ) * Math.sin(Math.toRadians(ang)) + ((punto.getY() - ty) * Math.cos(Math.toRadians(ang)))) + ty)
            );
        }
    }
    
    public void rotacion2(double ang){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {
            //Nueva x: (x - tx) * cos ang + (y - ty) * sen ang + tx
            punto.setX(
                    (int)((punto.getX() - tx) * Math.cos(Math.toRadians(ang)) + (punto.getY() - ty)*Math.sin(Math.toRadians(ang)) + tx)
            );
            //Nueva x: -1 * (x - tx) * sen ang + (y - ty) * cos ang + ty
            punto.setY(
                    (int)((-1)*(punto.getX() - tx) * Math.sin(Math.toRadians(ang)) + (punto.getY() - ty)*Math.cos(Math.toRadians(ang)) + ty)
            ); 
        }
    }
    
    private void reflexionX(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for(Punto punto : figura){
        //Nueva x: -1 * (x - tx) + tx
            punto.setX(
                (int)(-(punto.getX() - tx) + tx)
            );
        //Nueva y: (y - ty) + ty
            punto.setY(
                (int)((punto.getY() - ty) + ty)
            );
        }
    }
    
    private void reflexionY(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for(Punto punto : figura){
        //Nueva x: (x - tx) + tx
            punto.setX(
                (int)((punto.getX() - tx) + tx)
            );
        //Nueva y: -1 * (y - ty) + ty
            punto.setY(
                (int)(-(punto.getY() - ty) + ty)
            );
        }
    }
    
    private void reflexionXY(){
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for(Punto punto : figura){
        //Nueva x: -1 * (x - tx) + tx
            punto.setX(
                (int)(-(punto.getX() - tx) + tx)
            );
        //Nueva y: -1 * (y - ty) + ty
            punto.setY(
                (int)(-(punto.getY() - ty) + ty)
            );
        }
    }
    
    private void dibujar(Graphics g){
        for (int i = 0; i < figura.length-1; i++) {
            g.drawLine(
                figura[i].getX(),//Punto A
                figura[i].getY(),
                figura[i+1].getX(),
                figura[i+1].getY()//Punto B
            );
        }
    }
    
   
}

