package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    public Frame () {
    JFrame janela = new JFrame();
        janela.setTitle("APP");
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentor = janela.getContentPane();
        contentor.setLayout(new CardLayout());

        ///////SUPERPAINEIS////////
        JPanel login = new JPanel();
        login.setLayout(new BorderLayout());
        //contentor.add(login);
        JPanel registoCliente = new JPanel();
        registoCliente.setLayout(new BorderLayout());
        //contentor.add(registoCliente);
        JPanel registoRestaurante = new JPanel();
        registoRestaurante.setLayout(new BorderLayout());
        //contentor.add(registoRestaurante);



        JPanel norte = new JPanel();
        JPanel centro = new JPanel();
        JPanel  sul = new JPanel();

        JButton lingua_Botao = new JButton("PT/EN");
        JButton login_Botao = new JButton("LOGIN");
        JButton cliente_Botao = new JButton("Cliente");
        JButton restaurante_Botao = new JButton("Restaurante");

        JLabel registar_Label = new JLabel("Registar");


        JLabel username_Label = new JLabel("Username");
        JTextField username_Text = new JTextField(20);
        JLabel password_Label = new JLabel("       Password: ");
        JPasswordField passaword_Text = new JPasswordField(20);

        login.add(norte, "North");
        login.add(centro, "Center");
        login.add(sul, "South");

        norte.add(lingua_Botao);

        JPanel c1 = new JPanel();
        c1.setLayout(new FlowLayout());
        JPanel c2 = new JPanel();
        c2.setLayout(new FlowLayout());
        JPanel c3 = new JPanel();
        c3.setLayout(new FlowLayout());


        centro.add(c1);
        centro.add(c2);
        centro.add(c3);

        c1.add(username_Label);
        c1.add(username_Text);
        c2.add(password_Label);
        c2.add(passaword_Text);
        c3.add(login_Botao);
        c3.add(registar_Label);
        c3.add(cliente_Botao);
        c3.add(restaurante_Botao);


        sul.add(c3);



        contentor.add(login);
        contentor.add(registoCliente);
        contentor.add(registoRestaurante);

        cliente_Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) contentor.getLayout();
                cl.next(contentor);// passar por parâmetro no construtor (fica como referência pq qdo precisarmos no actionlistener)

            }
        });

        //   cl.next(c); // controlar por meio de um botão


////////////////////REGISTO CLIENTE/////////////////////////
        JPanel norte1 = new JPanel();
        JPanel centro1 = new JPanel();
        JPanel  sul1 = new JPanel();

        JButton lingua_botao1 = new JButton("PT/EN");


        JLabel registarCliente_label = new JLabel("Registar Cliente");

        JLabel nome_label = new JLabel("Nome");
        JTextField nome_text1 = new JTextField(20);
        JLabel email_label = new JLabel("E-mail");
        JTextField email_text1 = new JTextField(20);
        JLabel morada_label = new JLabel("Morada");
        JTextField morada_text1 = new JTextField(20);
        JLabel telemovel_label = new JLabel("Telemóvel");
        JTextField telemovel_text1 = new JTextField(20);
        JLabel username_label1 = new JLabel("Username");
        JTextField username_text1 = new JTextField(20);
        JLabel password_label1 = new JLabel("Password: ");
        JPasswordField passaword_text1 = new JPasswordField(20);
        JLabel confirmarPassword_label = new JLabel("Confirmar password: ");
        JPasswordField confirmarPassaword_text = new JPasswordField(20);

        JButton cancelar_botao = new JButton("CANCELAR");
        JButton registar_botao1 = new JButton("REGISTAR");

        registoCliente.add(norte1, "North");
        registoCliente.add(centro1, "Center");
        registoCliente.add(sul1, "South");

        norte1.add(registarCliente_label);
        norte1.add(lingua_Botao);


        JPanel c11 = new JPanel();
        c11.setLayout(new GridLayout(7,2));

        centro1.add(c11);


        c11.add(nome_label);
        c11.add(nome_text1);
        c11.add(email_label);
        c11.add(email_text1);
        c11.add(morada_label);
        c11.add(morada_text1);
        c11.add(telemovel_label);
        c11.add(telemovel_text1);
        c11.add(username_label1);
        c11.add(username_text1);
        c11.add(password_label1);
        c11.add(passaword_text1);
        c11.add(confirmarPassword_label);
        c11.add(confirmarPassaword_text);


        sul1.setLayout(new FlowLayout());
        sul1.add(cancelar_botao);
        sul1.add(registar_botao1);


    //////MENU CLIENTE//////////








        janela.setVisible(true);
    }


}
