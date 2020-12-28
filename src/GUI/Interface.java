package GUI;

import java.awt.*;

import javax.swing.*;

public class Interface extends JFrame {
    private static final String RESTAURANTE_CARD = "RESTAURANTE";
    private static final String CLIENTE_CARD = "CLIENTE";
    private static final String LOGIN_CARD = "LOGIN";
    private static final String MENUCLIENTE_CARD = "MENU CLIENTE";
    private static final String MENURESTAURANTE_CARD = "MENU RESTAURANTE";
    private static final String MRESTADICIONARPRATO_CARD = "ADICIONAR PRATO";
    private static final String MRESTATUALIZARPRATO_CARD = "ATUALIZAR PRATO";
    private static final String MRESTATUALIZARDADOS_CARD = "ATUALIZAR DADOS";
    private static final String MRESTRESERVSUPERPANEL_CARD = "RESERVAS";
    private static final int LARGURA_LOGIN = 400;
    private static final int ALTURA_LOGIN = 180;
    private static final int LARGURA_PADRAO = 500;
    private static final int ALTURA_PADRAO = 300;


    public Interface() {
        ImageIcon logo = new ImageIcon("logo3.png");
        this.setIconImage(logo.getImage());
        this.setTitle("RESERVAS DE RESTAURANTES");
        this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentor = this.getContentPane();
        contentor.setLayout(new CardLayout());

        /////// SUPERPAINEIS////////
        JPanel loginSuperPanel = new JPanel();
        loginSuperPanel.setLayout(new BorderLayout());
        JPanel registarNovoClienteSuperPanel = new JPanel();
        registarNovoClienteSuperPanel.setLayout(new BorderLayout());
        JPanel registarNovoRestSuperPanel = new JPanel();
        registarNovoRestSuperPanel.setLayout(new BorderLayout());
        JPanel menuClienteSuperPanel = new JPanel();
        menuClienteSuperPanel.setLayout(new BorderLayout());
        JPanel mRestSuperPanel = new JPanel();
        mRestSuperPanel.setLayout(new BorderLayout());
        JPanel mRestAdPratoSuperPanel = new JPanel();
        mRestAdPratoSuperPanel.setLayout(new BorderLayout());
        JPanel mRestAtPratoDiaSuperPanel = new JPanel();
        mRestAtPratoDiaSuperPanel.setLayout(new BorderLayout());
        JPanel mRestAtDadosSuperPanel = new JPanel();
        mRestAtDadosSuperPanel.setLayout(new BorderLayout());
        JPanel mRestReservasSuperPanel = new JPanel();
        mRestReservasSuperPanel.setLayout(new BorderLayout());

        construirPanelLogin(this, contentor, loginSuperPanel);

        construirPanelCliente(this, contentor, loginSuperPanel, registarNovoClienteSuperPanel);

        construirPanelRestaurante(this, contentor, loginSuperPanel, registarNovoRestSuperPanel);

        construirPanelMenuCliente(this, contentor, loginSuperPanel, menuClienteSuperPanel);

        ////PROBLEMA - não aceita this
        construirPanelMRest(contentor, loginSuperPanel, mRestSuperPanel);

        construirPanelMRestAdPrato(this, contentor, loginSuperPanel, mRestAdPratoSuperPanel);

        construirPanelMRestAtPratoDia(this, contentor, loginSuperPanel, mRestAtPratoDiaSuperPanel);

        construirPanelMRestAtDados (this, contentor, loginSuperPanel, mRestAtDadosSuperPanel);

        construirPanelMRestReservas (this, contentor, loginSuperPanel, mRestReservasSuperPanel);

        contentor.add(loginSuperPanel, LOGIN_CARD);
        contentor.add(registarNovoClienteSuperPanel, CLIENTE_CARD);
        contentor.add(registarNovoRestSuperPanel, RESTAURANTE_CARD);
        contentor.add(menuClienteSuperPanel, MENUCLIENTE_CARD);
        contentor.add(mRestSuperPanel, MENURESTAURANTE_CARD);
        contentor.add(mRestAdPratoSuperPanel, MRESTADICIONARPRATO_CARD);
        contentor.add(mRestAtPratoDiaSuperPanel, MRESTATUALIZARPRATO_CARD);
        contentor.add(mRestAtDadosSuperPanel, MRESTATUALIZARDADOS_CARD);
        contentor.add(mRestReservasSuperPanel, MRESTRESERVSUPERPANEL_CARD);


    }


    private void construirPanelLogin(Interface janela, Container contentor, JPanel loginSuperPanel) {
        ////Criação dos subpaineis norte, centro e sul
        JPanel norteLoginSubPanel = new JPanel();
        JPanel centroLoginSubPanel = new JPanel();
        JPanel sulLoginSubPanel = new JPanel();

        JButton ptEnLoginButton = new JButton("PT/EN");
        ptEnLoginButton.setSize(15, 5);
        JButton loginButton = new JButton(LOGIN_CARD);
        loginButton.setSize(15, 5);
        JButton clienteNovoButton = new JLinkButton("Novo Cliente");
        JButton restauranteNovoButton = new JLinkButton("Novo Restaurante");

        JLabel titleLoginLabel = new JLabel("LOGIN");
        JLabel usernameLoginLabel = new JLabel("Username:");
        JLabel passwordLoginLabel = new JLabel("Password:");

        JTextField usernameLoginText = new JTextField(20);

        JPasswordField passwordLoginField = new JPasswordField(20);

///Layout dos subPaineis north, centro e south
        norteLoginSubPanel.setLayout(new BorderLayout());
        centroLoginSubPanel.setLayout(new BorderLayout());
        sulLoginSubPanel.setLayout(new BorderLayout());

//Adicionar subPaineis no superpainel Login
        loginSuperPanel.add(norteLoginSubPanel, BorderLayout.NORTH);
        loginSuperPanel.add(centroLoginSubPanel, BorderLayout.CENTER);
        loginSuperPanel.add(sulLoginSubPanel, BorderLayout.SOUTH);

/// Criação dos subpaineis nos subpaineis norte, centro e sul
        JPanel norteLoginSSPanelTitle = new JPanel();
        JPanel centroLoginSSPanelForm = new JPanel();
        JPanel centroLoginSSPanelButton = new JPanel();
        JPanel sulLoginSSPanelLinks = new JPanel();

//Layout dos subpaineis dos subpaineis norte, centro e sul
        norteLoginSubPanel.add(norteLoginSSPanelTitle, BorderLayout.CENTER);
        norteLoginSubPanel.add(ptEnLoginButton, BorderLayout.EAST);
        norteLoginSSPanelTitle.setLayout(new FlowLayout());
        norteLoginSSPanelTitle.add(titleLoginLabel);

        centroLoginSubPanel.add(centroLoginSSPanelForm, BorderLayout.NORTH);
        centroLoginSSPanelForm.setLayout(new GridLayout(2, 2));
        centroLoginSSPanelForm.add(usernameLoginLabel);
        centroLoginSSPanelForm.add(usernameLoginText);
        centroLoginSSPanelForm.add(passwordLoginLabel);
        centroLoginSSPanelForm.add(passwordLoginField);
        centroLoginSubPanel.add(centroLoginSSPanelButton, BorderLayout.SOUTH);
        centroLoginSSPanelButton.setLayout(new FlowLayout());
        centroLoginSSPanelButton.add(loginButton);

        sulLoginSubPanel.add(sulLoginSSPanelLinks);
        sulLoginSSPanelLinks.setLayout(new BorderLayout());
        sulLoginSSPanelLinks.add(clienteNovoButton, BorderLayout.EAST);
        sulLoginSSPanelLinks.add(restauranteNovoButton, BorderLayout.WEST);


        clienteNovoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, CLIENTE_CARD);
            janela.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });

        restauranteNovoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANTE_CARD);
            janela.setSize(LARGURA_PADRAO, 350);
            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
            // no actionlistener)
        });
    }
    ////////////////////NOVO CLIENTE/////////////////////////
    private void construirPanelCliente(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registarNovoClienteSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteNovoClienteSubPanel = new JPanel();
        norteNovoClienteSubPanel.setLayout(new BorderLayout());
        JPanel centroNovoClienteSubPanel = new JPanel();
        JPanel sulNovoClienteSubPanel = new JPanel();

        JLabel registarNovoClienteLabel = new JLabel("NOVO CLIENTE");
        JLabel nomeClienteLabel = new JLabel("Nome");
        JLabel emailClienteLabel = new JLabel("E-mail");
        JLabel moradaClienteLabel = new JLabel("Morada");
        JLabel telemovelClienteLabel = new JLabel("Telemóvel");
        JLabel usernameClienteLabel = new JLabel("Username");
        JLabel passwordClienteLabel = new JLabel("Password: ");
        JLabel confirmarPasswordClienteLabel = new JLabel("Confirmar password: ");

        JTextField nomeClienteText = new JTextField(20);
        JTextField emailClienteText = new JTextField(20);
        JTextField moradaClienteText = new JTextField(20);
        JTextField telemovelClienteText = new JTextField(20);
        JTextField usernameClienteText = new JTextField(20);

        JPasswordField passwordClienteField = new JPasswordField(20);
        JPasswordField confirmarPassawordClienteField = new JPasswordField(20);

        JButton ptEnNovoClienteButton = new JButton("PT/EN");
        JButton cancelarClienteButton = new JButton("CANCELAR");
        JButton registarClienteButton = new JButton("REGISTAR");


        registarNovoClienteSuperPanel.add(norteNovoClienteSubPanel, "North");
        registarNovoClienteSuperPanel.add(centroNovoClienteSubPanel, "Center");
        registarNovoClienteSuperPanel.add(sulNovoClienteSubPanel, "South");

        JPanel norteNovoClienteSSPanel = new JPanel();
        norteNovoClienteSSPanel.setLayout(new FlowLayout());
        norteNovoClienteSSPanel.add(registarNovoClienteLabel);
        norteNovoClienteSubPanel.add(norteNovoClienteSSPanel, BorderLayout.CENTER);
        norteNovoClienteSubPanel.add(ptEnNovoClienteButton, BorderLayout.EAST);

        JPanel centroNovoClienteSSPanelForm = new JPanel();
        centroNovoClienteSSPanelForm.setLayout(new GridLayout(7, 2));
        centroNovoClienteSubPanel.add(centroNovoClienteSSPanelForm);
        centroNovoClienteSSPanelForm.add(nomeClienteLabel);
        centroNovoClienteSSPanelForm.add(nomeClienteText);
        centroNovoClienteSSPanelForm.add(emailClienteLabel);
        centroNovoClienteSSPanelForm.add(emailClienteText);
        centroNovoClienteSSPanelForm.add(moradaClienteLabel);
        centroNovoClienteSSPanelForm.add(moradaClienteText);
        centroNovoClienteSSPanelForm.add(telemovelClienteLabel);
        centroNovoClienteSSPanelForm.add(telemovelClienteText);
        centroNovoClienteSSPanelForm.add(usernameClienteLabel);
        centroNovoClienteSSPanelForm.add(usernameClienteText);
        centroNovoClienteSSPanelForm.add(passwordClienteLabel);
        centroNovoClienteSSPanelForm.add(passwordClienteField);
        centroNovoClienteSSPanelForm.add(confirmarPasswordClienteLabel);
        centroNovoClienteSSPanelForm.add(confirmarPassawordClienteField);

        sulNovoClienteSubPanel.setLayout(new FlowLayout());
        sulNovoClienteSubPanel.add(cancelarClienteButton);
        sulNovoClienteSubPanel.add(registarClienteButton);


        registarClienteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENUCLIENTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

        cancelarClienteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);

        });
    }

    ////// MENU CLIENTE//////////
    private void construirPanelMenuCliente(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel menuClienteSuperPanel) {

        /////SUBPAINEIS//////
        JPanel norteMenuClienteSubPanel = new JPanel();
        norteMenuClienteSubPanel.setLayout(new BorderLayout());
        JPanel centroMenuClienteSubPanel = new JPanel();
        JPanel sulMenuClienteSubPanel = new JPanel();

        JLabel registarNovoClienteLabel = new JLabel("MENU CLIENTE");

        JButton ptEnMenuClienteButton = new JButton("PT/EN");
        ////
        JButton consultarRest = new JButton("CONSULTAR RESTAURANTES");
        JButton comentarios = new JButton("COMENTÁRIOS");
        JButton histResComPon = new JButton("HISTÓRICO DE RESERVAS/COMENTAR E PONTUAR");
        JButton fazerReservas = new JButton("FAZER RESERVAS");
        JButton cancelarReserva = new JButton("CANCELAR RESERVA");
        JButton atualDados = new JButton("ATUALIZAR DADOS");

        ///
        //JButton cancelarMenuClienteButton = new JButton("CANCELAR");
        JButton sairMenuClienteButton = new JButton("SAIR");

        menuClienteSuperPanel.add(norteMenuClienteSubPanel, "North");
        menuClienteSuperPanel.add(centroMenuClienteSubPanel, "Center");
        menuClienteSuperPanel.add(sulMenuClienteSubPanel, "South");

        JPanel norteClienteSubPanel = new JPanel();
        norteClienteSubPanel.setLayout(new FlowLayout());
        norteClienteSubPanel.add(registarNovoClienteLabel);
        norteMenuClienteSubPanel.add(norteClienteSubPanel, BorderLayout.CENTER);
        norteMenuClienteSubPanel.add(ptEnMenuClienteButton, BorderLayout.EAST);

        JPanel centroNovoClienteSSPanelForm = new JPanel();
        centroNovoClienteSSPanelForm.setLayout(new GridLayout(7, 1));
        centroMenuClienteSubPanel.add(centroNovoClienteSSPanelForm);
        centroNovoClienteSSPanelForm.add(consultarRest);
        centroNovoClienteSSPanelForm.add(comentarios);
        centroNovoClienteSSPanelForm.add(histResComPon);
        centroNovoClienteSSPanelForm.add(fazerReservas);
        centroNovoClienteSSPanelForm.add(cancelarReserva);
        centroNovoClienteSSPanelForm.add(atualDados);


        sulMenuClienteSubPanel.setLayout(new FlowLayout());
        //sulMenuClienteSubPanel.add(cancelarMenuClienteButton);
        sulMenuClienteSubPanel.add(sairMenuClienteButton);

//        cancelarMenuClienteButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, CLIENTE_CARD);
//            this.setSize(500, 300);
//
//        });

        sairMenuClienteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(400, 180);

        });

    }


