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
    ////////////////////NOVO RESTAURANTE/////////////////////////
    private void construirPanelRestaurante(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registarNovoRestauranteSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteNovoRestauranteSubPanel = new JPanel();
        norteNovoRestauranteSubPanel.setLayout(new BorderLayout());
        JPanel centroNovoRestauranteSubPanel = new JPanel();
        centroNovoRestauranteSubPanel.setLayout(new FlowLayout());
        JPanel sulNovoRestauranteSubPanel = new JPanel();

        JLabel registarNovoRestauranteLabel = new JLabel("NOVO RESTAURANTE");
        JLabel nomeRestauranteLabel = new JLabel("Nome");
        JLabel emailRestauranteLabel = new JLabel("E-mail");
        JLabel moradaRestauranteLabel = new JLabel("Morada");
        JLabel telemovelRestauranteLabel = new JLabel("Telemóvel");
///////////////////////
        JLabel lotacaoRestauranteLabel = new JLabel("Lotação:");
        JLabel esplanadaRestauranteLabel = new JLabel("Esplanada");
        JLabel zonaInteriorLabel = new JLabel("Zona Interior:");
        JLabel zonaInteriorNFumRestauranteLabel = new JLabel("Ñ Fumadores");
        JLabel zonaInteriorFumRestauranteLabel = new JLabel("Fumadores");
        JLabel horariosRestauranteLabel = new JLabel("Horários:");
        JLabel horariosAlmocoRestauranteLabel = new JLabel("Almoço:");
        JLabel horarioAlmocoInicioRestauranteLabel = new JLabel("Início");
        JLabel horarioAlmocoFimRestauranteLabel = new JLabel("Fim");
        JLabel horariosJantarRestauranteLabel = new JLabel("Jantar:");
        JLabel horarioJantarInicioRestauranteLabel = new JLabel("Início");
        JLabel horarioJantarFimRestauranteLabel = new JLabel("Fim");
//////////////////////////////////


        JLabel usernameRestauranteLabel = new JLabel("Username");
        JLabel passwordRestauranteLabel = new JLabel("Password ");
        JLabel confirmarPasswordRestauranteLabel = new JLabel("Confirmar password ");

        JTextField nomeRestauranteText = new JTextField(18);
        nomeRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField emailRestauranteText = new JTextField(18);
        emailRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField moradaRestauranteText = new JTextField(15);
        moradaRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField telemovelRestauranteText = new JTextField(5);
        telemovelRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        ////////
        JTextField esplanadaRestauranteText = new JTextField(3);
        esplanadaRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField zonaInteriorNFumRestauranteText = new JTextField(3);
        zonaInteriorNFumRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField zonaInteriorFumRestauranteText = new JTextField(3);
        zonaInteriorFumRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioAlmocoInicioRestauranteText = new JTextField(3);
        horarioAlmocoInicioRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioAlmocoFimRestauranteText = new JTextField(3);
        horarioAlmocoFimRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioJantarInicioRestauranteText = new JTextField(3);
        horarioJantarInicioRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioJantarFimRestauranteText = new JTextField(3);
        horarioJantarFimRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        ///////
        JTextField usernameRestauranteText = new JTextField(20);
        usernameRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JPasswordField passwordRestauranteField = new JPasswordField(15);
        passwordRestauranteField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JPasswordField confirmarPasswordRestauranteField = new JPasswordField(15);
        confirmarPasswordRestauranteField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JButton ptEnNovoRestauranteButton = new JButton("PT/EN");
        JButton cancelarRestauranteButton = new JButton("CANCELAR");
        JButton registarRestauranteButton = new JButton("REGISTAR");

        registarNovoRestauranteSuperPanel.add(norteNovoRestauranteSubPanel, "North");
        registarNovoRestauranteSuperPanel.add(centroNovoRestauranteSubPanel, "Center");
        registarNovoRestauranteSuperPanel.add(sulNovoRestauranteSubPanel, "South");

//        JPanel norteSupMRestSubPanel = new JPanel();
//        norteSupMRestSubPanel.setLayout(new FlowLayout());
//        norteNovoRestauranteSubPanel.add(norteSupMRestSubPanel, BorderLayout.CENTER);
//        norteSupMRestSubPanel.add(registarNovoRestauranteLabel);
//        norteNovoRestauranteSubPanel.add(ptEnNovoRestauranteButton, BorderLayout.EAST);

        JPanel norteNovoRestSSPanel = new JPanel();
        norteNovoRestSSPanel.setLayout(new FlowLayout());
        norteNovoRestSSPanel.add(registarNovoRestauranteLabel);
        norteNovoRestauranteSubPanel.add(norteNovoRestSSPanel, BorderLayout.CENTER);
        norteNovoRestauranteSubPanel.add(ptEnNovoRestauranteButton, BorderLayout.EAST);

        JPanel centroNovoRestSSPanelForm1 = new JPanel();
        centroNovoRestSSPanelForm1.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm1);
        JPanel centroNovoRestSSPanelForm2 = new JPanel();
        centroNovoRestSSPanelForm2.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm2, BorderLayout.CENTER);
        JPanel centroNovoRestSSPanelForm3 = new JPanel();
        //centroNovoRestSSPanelForm3.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm3, BorderLayout.CENTER);

        JPanel centroNovoRestSSPanelForm4 = new JPanel();
        centroNovoRestSSPanelForm4.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm4, BorderLayout.CENTER);

        JPanel centroNovoRestSSPanelForm5 = new JPanel();
        centroNovoRestSSPanelForm5.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm5, BorderLayout.CENTER);

        JPanel centroNovoRestSSPanelForm6 = new JPanel();
        centroNovoRestSSPanelForm6.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm6, BorderLayout.CENTER);

        centroNovoRestSSPanelForm1.add(nomeRestauranteLabel);
        centroNovoRestSSPanelForm1.add(nomeRestauranteText);
        centroNovoRestSSPanelForm1.add(emailRestauranteLabel);
        centroNovoRestSSPanelForm1.add(emailRestauranteText);
        centroNovoRestSSPanelForm2.add(moradaRestauranteLabel);
        centroNovoRestSSPanelForm2.add(moradaRestauranteText);
        centroNovoRestSSPanelForm2.add(telemovelRestauranteLabel);
        centroNovoRestSSPanelForm2.add(telemovelRestauranteText);
        /////
        centroNovoRestSSPanelForm3.add(lotacaoRestauranteLabel);
        centroNovoRestSSPanelForm3.add(esplanadaRestauranteLabel);
        centroNovoRestSSPanelForm3.add(esplanadaRestauranteText);
        centroNovoRestSSPanelForm3.add(zonaInteriorLabel);
        centroNovoRestSSPanelForm3.add(zonaInteriorNFumRestauranteLabel);
        centroNovoRestSSPanelForm3.add(zonaInteriorNFumRestauranteText);
        centroNovoRestSSPanelForm3.add(zonaInteriorFumRestauranteLabel);
        centroNovoRestSSPanelForm3.add(zonaInteriorFumRestauranteText);

        centroNovoRestSSPanelForm4.add(horariosRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horariosAlmocoRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioAlmocoInicioRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioAlmocoInicioRestauranteText);
        centroNovoRestSSPanelForm4.add(horarioAlmocoFimRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioAlmocoFimRestauranteText);
        centroNovoRestSSPanelForm4.add(horariosJantarRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioJantarInicioRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioJantarInicioRestauranteText);
        centroNovoRestSSPanelForm4.add(horarioJantarFimRestauranteLabel);
        centroNovoRestSSPanelForm4.add(horarioJantarFimRestauranteText);

        //
        centroNovoRestSSPanelForm5.add(usernameRestauranteLabel);
        centroNovoRestSSPanelForm5.add(usernameRestauranteText);

        centroNovoRestSSPanelForm6.add(passwordRestauranteLabel);
        centroNovoRestSSPanelForm6.add(passwordRestauranteField);
        centroNovoRestSSPanelForm6.add(confirmarPasswordRestauranteLabel);
        centroNovoRestSSPanelForm6.add(confirmarPasswordRestauranteField);


        sulNovoRestauranteSubPanel.setLayout(new FlowLayout());
        sulNovoRestauranteSubPanel.add(cancelarRestauranteButton);
        sulNovoRestauranteSubPanel.add(registarRestauranteButton);

        cancelarRestauranteButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, LOGIN_CARD);
            this.setSize(500, 180);
        });

        registarRestauranteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(500, 300);

        });
    }

    //////MENU RESTAURANTE////////
    private void construirPanelMRest(Container contentor, JPanel loginSuperPanel, JPanel menuRestauranteSuperPanel) {

        /////SUBPAINEIS//////
        JPanel norteMenuRestauranteSubPanel = new JPanel();
        norteMenuRestauranteSubPanel.setLayout(new BorderLayout());
        JPanel centroMenuRestauranteSubPanel = new JPanel();
        JPanel sulMenuRestauranteSubPanel = new JPanel();

        JLabel registarNovoRestauranteLabel = new JLabel("MENU RESTAURANTE");

        JButton ptEnMenuRestauranteButton = new JButton("PT/EN");
        ////
        JButton mRestAdicionarPratoButton = new JButton("ADICIONAR PRATO");
        JButton mRestAtualizarPratoDiaButton = new JButton("ATUALIZAR PRATO DO DIA");
        JButton mRestAtualizarDadosButton = new JButton("ATUALIZAR DADOS");
        JButton mRestReservasButton = new JButton("RESERVAS");
        JButton consultarComentarios = new JButton("CONSULTAR COMENTÁRIOS");
        JButton responderComentarios = new JButton("RESPONDER COMENTÁRIOS");
        JButton pontuacaoMedia = new JButton("PONTUAÇÃO MÉDIA");


        ///
        //JButton cancelarMenuRestauranteButton = new JButton("CANCELAR");
        JButton sairMenuRestauranteButton = new JButton("SAIR");

        menuRestauranteSuperPanel.add(norteMenuRestauranteSubPanel, "North");
        menuRestauranteSuperPanel.add(centroMenuRestauranteSubPanel, "Center");
        menuRestauranteSuperPanel.add(sulMenuRestauranteSubPanel, "South");

        JPanel norteMenuRestauranteSSPanel = new JPanel();
        norteMenuRestauranteSSPanel.setLayout(new FlowLayout());
        norteMenuRestauranteSSPanel.add(registarNovoRestauranteLabel);
        norteMenuRestauranteSubPanel.add(norteMenuRestauranteSSPanel, BorderLayout.CENTER);
        norteMenuRestauranteSubPanel.add(ptEnMenuRestauranteButton, BorderLayout.EAST);

        JPanel centroNovoRestauranteSSPanelForm = new JPanel();
        centroNovoRestauranteSSPanelForm.setLayout(new GridLayout(7, 1));
        centroMenuRestauranteSubPanel.add(centroNovoRestauranteSSPanelForm);
        centroNovoRestauranteSSPanelForm.add(mRestAdicionarPratoButton);
        centroNovoRestauranteSSPanelForm.add(mRestAtualizarPratoDiaButton);
        centroNovoRestauranteSSPanelForm.add(mRestAtualizarDadosButton);
        centroNovoRestauranteSSPanelForm.add(mRestReservasButton);
        centroNovoRestauranteSSPanelForm.add(consultarComentarios);
        centroNovoRestauranteSSPanelForm.add(responderComentarios);
        centroNovoRestauranteSSPanelForm.add(pontuacaoMedia);

        sulMenuRestauranteSubPanel.setLayout(new FlowLayout());
        //sulMenuRestauranteSubPanel.add(cancelarMenuRestauranteButton);
        sulMenuRestauranteSubPanel.add(sairMenuRestauranteButton);

//        cancelarMenuRestauranteButton.addActionListener(a -> {
//           CardLayout cl = (CardLayout) contentor.getLayout();
//           cl.show(contentor, LOGIN_CARD);
//            this.setSize(500, 300);
//
//       });
        mRestAdicionarPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTADICIONARPRATO_CARD);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);

        });

        mRestAtualizarPratoDiaButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTATUALIZARPRATO_CARD);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);

        });

        mRestReservasButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTRESERVSUPERPANEL_CARD);
            this.setSize(LARGURA_PADRAO, 350);

        });

        mRestAtualizarDadosButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MRESTATUALIZARDADOS_CARD);
            this.setSize(LARGURA_PADRAO, 350);




        });


        sairMenuRestauranteButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, RESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });
    }

    ///////////MENU RESTAURANTE - ADICIONAR PRATO//////////////////////
    private void construirPanelMRestAdPrato(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestAdPratoSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteAdPratoSubPanel = new JPanel();
        norteAdPratoSubPanel.setLayout(new BorderLayout());
        JPanel centroAdPratoSubPanel = new JPanel();
        JPanel sulAdPratoSubPanel = new JPanel();

        JLabel adPratoLabel = new JLabel("ADICIONAR PRATO");
        JLabel nomePratoLabel = new JLabel("Nome Prato");
        JLabel descricaoPratoLabel = new JLabel("Descrição");
        JLabel precoPratoLabel = new JLabel("Preço");

        JTextField nomePratoText = new JTextField(20);
        JTextField descricaoPratoText = new JTextField(20);
        JTextField precoPratoText = new JTextField(10);


        JButton ptEnAdPratoButton = new JButton("PT/EN");
        JButton voltarMenuRestAdPratoButton = new JButton("MENU RESTAURANTE");
        JButton confirmarAdPratoButton = new JButton("CONFIRMAR");


        JComboBox tipoPratoAd = new JComboBox();
        tipoPratoAd.addItem("Carta");
        tipoPratoAd.addItem("Prato do dia");


        mRestAdPratoSuperPanel.add(norteAdPratoSubPanel, "North");
        mRestAdPratoSuperPanel.add(centroAdPratoSubPanel, "Center");
        mRestAdPratoSuperPanel.add(sulAdPratoSubPanel, "South");

        JPanel norteAdPratoSSPanel = new JPanel();
        norteAdPratoSSPanel.setLayout(new FlowLayout());
        norteAdPratoSSPanel.add(adPratoLabel);
        norteAdPratoSubPanel.add(norteAdPratoSSPanel, BorderLayout.CENTER);
        norteAdPratoSubPanel.add(ptEnAdPratoButton, BorderLayout.EAST);

        JPanel centroAdPratoSSPanelForm = new JPanel();
        centroAdPratoSSPanelForm.setLayout(new GridLayout(5, 2));
        centroAdPratoSubPanel.add(centroAdPratoSSPanelForm);
        centroAdPratoSubPanel.add(tipoPratoAd);
        centroAdPratoSSPanelForm.add(nomePratoLabel);
        centroAdPratoSSPanelForm.add(nomePratoText);
        centroAdPratoSSPanelForm.add(descricaoPratoLabel);
        centroAdPratoSSPanelForm.add(descricaoPratoText);
        centroAdPratoSSPanelForm.add(precoPratoLabel);
        centroAdPratoSSPanelForm.add(precoPratoText);

        sulAdPratoSubPanel.setLayout(new FlowLayout());
        sulAdPratoSubPanel.add(voltarMenuRestAdPratoButton);
        sulAdPratoSubPanel.add(confirmarAdPratoButton);


        voltarMenuRestAdPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

        confirmarAdPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });

    }

    /////////MENU RESTAURANTE – ATUALIZAR PRATO//////////////////////
    private void construirPanelMRestAtPratoDia(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestAtPratoSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteAtPratoSubPanel = new JPanel();
        norteAtPratoSubPanel.setLayout(new BorderLayout());
        JPanel centroAtPratoSubPanel = new JPanel();
        JPanel sulAtPratoSubPanel = new JPanel();

        JLabel atPratoLabel = new JLabel("ATUALIZAR PRATO DO DIA");
        JLabel atNomePratoLabel = new JLabel("Nome Prato");
        JLabel atDescricaoPratoLabel = new JLabel("Descrição");
        JLabel atPrecoPratoLabel = new JLabel("Preço");

        JTextField atNomePratoText = new JTextField(20);
        JTextField atDescricaoPratoText = new JTextField(20);
        JTextField atPrecoPratoText = new JTextField(10);

        JButton ptEnAtPratoButton = new JButton("PT/EN");
        JButton voltarMenuRestAtPratoButton = new JButton("MENU RESTAURANTE");
        JButton confirmarAtPratoButton = new JButton("CONFIRMAR");

        mRestAtPratoSuperPanel.add(norteAtPratoSubPanel, "North");
        mRestAtPratoSuperPanel.add(centroAtPratoSubPanel, "Center");
        mRestAtPratoSuperPanel.add(sulAtPratoSubPanel, "South");

        JPanel norteAtPratoSSPanel = new JPanel();
        norteAtPratoSSPanel.setLayout(new FlowLayout());
        norteAtPratoSSPanel.add(atPratoLabel);
        norteAtPratoSubPanel.add(norteAtPratoSSPanel, BorderLayout.CENTER);
        norteAtPratoSubPanel.add(ptEnAtPratoButton, BorderLayout.EAST);

        JPanel centroAtPratoSSPanelForm = new JPanel();
        centroAtPratoSSPanelForm.setLayout(new GridLayout(3, 2));
        centroAtPratoSubPanel.add(centroAtPratoSSPanelForm);
        //centroAtPratoSSPanelForm.add(atPratoLabel);
        centroAtPratoSSPanelForm.add(atNomePratoLabel);
        centroAtPratoSSPanelForm.add(atNomePratoText);
        centroAtPratoSSPanelForm.add(atDescricaoPratoLabel);
        centroAtPratoSSPanelForm.add(atDescricaoPratoText);
        centroAtPratoSSPanelForm.add(atPrecoPratoLabel);
        centroAtPratoSSPanelForm.add(atPrecoPratoText);

        sulAtPratoSubPanel.setLayout(new FlowLayout());
        sulAtPratoSubPanel.add(voltarMenuRestAtPratoButton);
        sulAtPratoSubPanel.add(confirmarAtPratoButton);


        voltarMenuRestAtPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });
        confirmarAtPratoButton.addActionListener(a -> {
            CardLayout cl = (CardLayout) contentor.getLayout();
            cl.show(contentor, MENURESTAURANTE_CARD);
            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);

        });
    }

