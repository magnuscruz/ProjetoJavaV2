//
//
//
//package com.company.gui;
//
//import com.company.Sistema;
//import com.company.gui.util.DateLabelFormatter;
//
//import org.jdatepicker.impl.JDatePanelImpl;
//import org.jdatepicker.impl.JDatePickerImpl;
//import org.jdatepicker.impl.UtilDateModel;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.text.ParseException;
//import java.util.Enumeration;
//import java.util.Properties;
//import java.util.ResourceBundle;
//
//import javax.swing.*;
//import javax.swing.text.MaskFormatter;
//
//public class Interface extends JFrame {
//    private static final String LOGIN_CARD = "LOGIN";
//    private static final String RESTAURANTE_CARD = "RESTAURANTE";
//    private static final String CLIENTE_CARD = "CLIENTE";
//    private static final String MENUCLIENTE_CARD = "MENU CLIENTE";
//    private static final String MCLIREST_CARD = "MENU CLIENTE - CONSULTAR RESTAURANTES";
//    private static final String MCLICOMENTARIOS_CARD = "MENU CLIENTE - COMENTÁRIOS";
//    private static final String MCLIATDADOS_CARD = "MENU CLIENTE - ACTUALIZAR DADOS";
//    private static final String MCLIHISRES_CARD = "MENU CLIENTE - HISTÓRICO DE RESERVAS";
//    private static final String MCLIMRESCOMPONTRESE_CARD = "MENU CLIENTE - HISTÓRICO DE RESERVAS: COMENTAR";
//    private static final String MCLIRESACT_CARD = "MENU CLIENTE - RESERVAS ACTIVAS";
//    private static final String MCLIFAZERRES_CARD = "MENU CLIENTE - FAZER RESERVAS";
//    private static final String MCLIFAZERRESP_CARD = "MENU CLIENTE - FAZER RESERVAS PRESENCIAL";
//    private static final String MCLIFAZERRESTA_CARD = "MENU CLIENTE - FAZER RESERVAS TAKE-AWAY";
//    private static final String MCLIRESERVAS_CARD = "MENU CLIENTE - RESERVAS";
//    private static final String MCLIMRESTFORDRESTS_CARD = "MENU CLIENTE - MENU RESTAURANTES";
//    private static final String MCLIMRESTFRESTPONT_CARD = "MENU CLIENTE - MENU RESTAURANTES - PONTUAÇÃO";
//    private static final String MCLIMRESTFORDRESTVALOR_CARD = "MENU CLIENTE - MENU RESTAURANTES - VALOR MÉDIO DOS PRATOS";
//    private static final String MCLIMRESTFORDRESTVALORCARTA_CARD = "MENU CLIENTE - MENU RESTAURANTES - VALOR MÉDIO DOS PRATOS - CARTA";
//    private static final String MCLIMRESTFORDRESTVALORPDIA_CARD = "MENU CLIENTE - MENU RESTAURANTES - VALOR MÉDIO DOS PRATOS - PRATO DO DIA";
//    private static final String MCLIMRESTFRESTHFUNC_CARD = "MENU CLIENTE - MENU RESTAURANTES - HORÁRIO FUNCIONAMENTO";
//    private static final String MCLIMRESTFRESTLOT_CARD = "MENU CLIENTE - MENU RESTAURANTES - LOTAÇÃO";
//    private static final String MCLIMRESTFRESTCID_CARD = "MENU CLIENTE - MENU RESTAURANTES - CIDADE";
//
//
//    private static final String MENURESTAURANTE_CARD = "MENU RESTAURANTE";
//    private static final String MRESTADICIONARPRATO_CARD = "ADICIONAR PRATO";
//    private static final String MRESTACTUALIZARPRATO_CARD = "ACTUALIZAR PRATO DO DIA";
//    private static final String MRESTACTUALIZARDADOS_CARD = "MENU RESTAURANTE - ACTUALIZAR DADOS";
//    private static final String MRESTRESERV_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS";
//    private static final String MRESTCOMENTARIOS_CARD = "MENU RESTAURANTE - COMENTÁRIOS";
//    private static final int LARGURA_LOGIN = 400;
//    private static final int ALTURA_LOGIN = 180;
//    private static final int LARGURA_PADRAO = 500;
//    private static final int ALTURA_PADRAO = 300;
//    private boolean passwordValido;
//    private boolean confirmarPasswordValido;
//    private Sistema sistema = new Sistema();
//    private MaskFormatter mascaraTelemovel;
//
//
//    public Interface() {
//
//        try {
//            mascaraTelemovel = new MaskFormatter("#########");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        ImageIcon logo = new ImageIcon("logo3.png");
//        this.setIconImage(logo.getImage());
//
//
//        this.setTitle("RESERVAS DE RESTAURANTES");
//        this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        Container contentor = this.getContentPane();
//        contentor.setLayout(new CardLayout());
//
//        /////// SUPERPAINEIS////////
//        JPanel loginSuperPanel = new JPanel();
//        loginSuperPanel.setLayout(new BorderLayout());
//        JPanel regNovoCliSuperPanel = new JPanel();
//        regNovoCliSuperPanel.setLayout(new BorderLayout());
//        JPanel registarNovoRestSuperPanel = new JPanel();
//        registarNovoRestSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliSuperPanel = new JPanel();
//        mCliSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliRestSuperPanel = new JPanel();
//        mCliRestSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliComentariosSuperPanel = new JPanel();
//        mCliComentariosSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliAtDadosSuperPanel = new JPanel();
//        mCliAtDadosSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliHistResSuperPanel = new JPanel();
//        mCliHistResSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMResComPontReseSuperPanel = new JPanel();
//        mCliMResComPontReseSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliResActSuperPanel = new JPanel();
//        mCliResActSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliFazerResSuperPanel = new JPanel();
//        mCliFazerResSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliFazerResPSuperPanel = new JPanel();
//        mCliFazerResPSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliFazerResTASuperPanel = new JPanel();
//        mCliFazerResTASuperPanel.setLayout(new BorderLayout());
//        JPanel mCliReservasMReseSuperPanel = new JPanel();
//        mCliReservasMReseSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMRestFOrdRestsSuperPanel = new JPanel();
//        mCliMRestFOrdRestsSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMRestFRestPontSuperPanel = new JPanel();
//        mCliMRestFRestPontSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMRestFOrdRestValorSuperPanel = new JPanel();
//        mCliMRestFOrdRestValorSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMRestFOrdRestValorCartaSuperPanel = new JPanel();
//        mCliMRestFOrdRestValorCartaSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMRestFOrdRestValorPDiaSuperPanel = new JPanel();
//        mCliMRestFOrdRestValorPDiaSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMRestFRestHFuncSuperPanel = new JPanel();
//        mCliMRestFRestHFuncSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMRestFRestLotSuperPanel = new JPanel();
//        mCliMRestFRestLotSuperPanel.setLayout(new BorderLayout());
//        JPanel mCliMRestFRestCidSuperPanel = new JPanel();
//        mCliMRestFRestCidSuperPanel.setLayout(new BorderLayout());
//
//
//        JPanel mRestSuperPanel = new JPanel();
//        mRestSuperPanel.setLayout(new BorderLayout());
//        JPanel mRestAdPratoSuperPanel = new JPanel();
//        mRestAdPratoSuperPanel.setLayout(new BorderLayout());
//        JPanel mRestAtPratoDiaSuperPanel = new JPanel();
//        mRestAtPratoDiaSuperPanel.setLayout(new BorderLayout());
//        JPanel mRestAtDadosSuperPanel = new JPanel();
//        mRestAtDadosSuperPanel.setLayout(new BorderLayout());
//        JPanel mRestReservasSuperPanel = new JPanel();
//        mRestReservasSuperPanel.setLayout(new BorderLayout());
//        JPanel mRestComentariosSuperPanel = new JPanel();
//        mRestComentariosSuperPanel.setLayout(new BorderLayout());
//
//
//        construirPanelLogin(this, contentor, loginSuperPanel);
//
//        construirPanelCliente(this, contentor, loginSuperPanel, regNovoCliSuperPanel);
//
//        construirPanelRestaurante(this, contentor, loginSuperPanel, registarNovoRestSuperPanel);
//
//        construirPanelMenuCliente(this, contentor, loginSuperPanel, mCliSuperPanel);
//
//        ////PROBLEMA - não aceita this
//        construirPanelMRest(contentor, loginSuperPanel, mRestSuperPanel);
//
//        construirPanelMRestAdPrato(this, contentor, loginSuperPanel, mRestAdPratoSuperPanel);
//
//        construirPanelMRestAtPratoDia(this, contentor, loginSuperPanel, mRestAtPratoDiaSuperPanel);
//
//        construirPanelMRestAtDados(this, contentor, loginSuperPanel, mRestAtDadosSuperPanel);
//
//        construirPanelMRestReservas(this, contentor, loginSuperPanel, mRestReservasSuperPanel);
//
//        construirPanelMRestComentarios(this, contentor, loginSuperPanel, mRestComentariosSuperPanel);
//
//        //construirPanelMCliRestaurantes(this, contentor, loginSuperPanel, mCliRestSuperPanel);
//
//        construirPanelMCliComentarios(this, contentor, loginSuperPanel, mCliComentariosSuperPanel);
//
//        construirPanelMCliAtDados(this, contentor, loginSuperPanel, mCliAtDadosSuperPanel);
//
//        construirPanelMCliHistRes(this, contentor, loginSuperPanel, mCliHistResSuperPanel);
//
//        construirPanelMCliResAct(this, contentor, loginSuperPanel, mCliResActSuperPanel);
//
//        construirPanelMCliFazerRes(this, contentor, loginSuperPanel, mCliFazerResSuperPanel);
//
//        construirPanelMCliFazerResP(this, contentor, loginSuperPanel, mCliFazerResPSuperPanel);
//
//        construirPanelMCliFazerResTA(this, contentor, loginSuperPanel, mCliFazerResTASuperPanel);
//
//        construirPanelReservasMCliMRese(this, contentor, loginSuperPanel, mCliReservasMReseSuperPanel);
//
//        construirPanelMCliMResComPonReservas(this, contentor, loginSuperPanel, mCliMResComPontReseSuperPanel);
//
//        construirPanelMCliMRestFOrdRests(this, contentor, loginSuperPanel, mCliMRestFOrdRestsSuperPanel);
//
//        construirPanelMCliMRestFRestPont(this, contentor, loginSuperPanel, mCliMRestFRestPontSuperPanel);
//
//        construirPanelMCliMRestFOrdRestValor(this, contentor, loginSuperPanel, mCliMRestFOrdRestValorSuperPanel);
//
//        construirPanelMCliMRestFOrdRestValorCarta(this, contentor, loginSuperPanel, mCliMRestFOrdRestValorCartaSuperPanel);
//
//        construirPanelMCliMRestFOrdRestValorPDia(this, contentor, loginSuperPanel, mCliMRestFOrdRestValorPDiaSuperPanel);
//
//        construirPanelMCliMRestFRestHFunc(this, contentor, loginSuperPanel, mCliMRestFRestHFuncSuperPanel);
//
//        construirPanelMCliMRestFRestLot(this, contentor, loginSuperPanel, mCliMRestFRestLotSuperPanel);
//
//        construirPanelMCliMRestFRestCid(this, contentor, loginSuperPanel, mCliMRestFRestCidSuperPanel);
//
//
//        contentor.add(loginSuperPanel, LOGIN_CARD);
//        contentor.add(regNovoCliSuperPanel, CLIENTE_CARD);
//        contentor.add(registarNovoRestSuperPanel, RESTAURANTE_CARD);
//        contentor.add(mCliSuperPanel, MENUCLIENTE_CARD);
//        contentor.add(mRestSuperPanel, MENURESTAURANTE_CARD);
//        contentor.add(mRestAdPratoSuperPanel, MRESTADICIONARPRATO_CARD);
//        contentor.add(mRestAtPratoDiaSuperPanel, MRESTACTUALIZARPRATO_CARD);
//        contentor.add(mRestAtDadosSuperPanel, MRESTACTUALIZARDADOS_CARD);
//        contentor.add(mRestReservasSuperPanel, MRESTRESERV_CARD);
//        contentor.add(mRestComentariosSuperPanel, MRESTCOMENTARIOS_CARD);
//        contentor.add(mCliRestSuperPanel, MCLIREST_CARD);
//        contentor.add(mCliComentariosSuperPanel, MCLICOMENTARIOS_CARD);
//        contentor.add(mCliAtDadosSuperPanel, MCLIATDADOS_CARD);
//        contentor.add(mCliHistResSuperPanel, MCLIHISRES_CARD);
//        contentor.add(mCliResActSuperPanel, MCLIRESACT_CARD);
//        contentor.add(mCliFazerResSuperPanel, MCLIFAZERRES_CARD);
//        contentor.add(mCliFazerResPSuperPanel, MCLIFAZERRESP_CARD);
//        contentor.add(mCliFazerResTASuperPanel, MCLIFAZERRESTA_CARD);
//        contentor.add(mCliReservasMReseSuperPanel, MCLIRESERVAS_CARD);
//        contentor.add(mCliMResComPontReseSuperPanel, MCLIMRESCOMPONTRESE_CARD);
//        contentor.add(mCliMRestFOrdRestsSuperPanel, MCLIMRESTFORDRESTS_CARD);
//        contentor.add(mCliMRestFRestPontSuperPanel, MCLIMRESTFRESTPONT_CARD);
//        contentor.add(mCliMRestFOrdRestValorSuperPanel, MCLIMRESTFORDRESTVALOR_CARD);
//        contentor.add(mCliMRestFOrdRestValorCartaSuperPanel, MCLIMRESTFORDRESTVALORCARTA_CARD);
//        contentor.add(mCliMRestFOrdRestValorPDiaSuperPanel, MCLIMRESTFORDRESTVALORPDIA_CARD);
//        contentor.add(mCliMRestFRestHFuncSuperPanel, MCLIMRESTFRESTHFUNC_CARD);
//        contentor.add(mCliMRestFRestLotSuperPanel, MCLIMRESTFRESTLOT_CARD);
//        contentor.add(mCliMRestFRestCidSuperPanel, MCLIMRESTFRESTCID_CARD);
//
//    }
//
//
//    private void construirPanelLogin(Interface janela, Container contentor, JPanel loginSuperPanel) {
//        ////Criação dos subpaineis norte, centro e sul
//        JPanel norteLoginSubPanel = new JPanel();
//        JPanel centroLoginSubPanel = new JPanel();
//        JPanel sulLoginSubPanel = new JPanel();
//
//        JButton ptEnLoginButton = new JButton("PT/EN");
//        ptEnLoginButton.setSize(15, 5);
//        JButton loginButton = new JButton(LOGIN_CARD);
//        loginButton.setSize(15, 5);
//        JButton clienteNovoButton = new JLinkButton("Novo Cliente");
//        JButton restauranteNovoButton = new JLinkButton("Novo Restaurante");
//
//        JLabel titleLoginLabel = new JLabel("LOGIN");
//        JLabel usernameLoginLabel = new JLabel("Username");
//        JLabel passwordLoginLabel = new JLabel("Password");
//
//        JTextField usernameLoginText = new JTextField(20);
//
//        JPasswordField passwordLoginField = new JPasswordField(20);
//
/////Layout dos subPaineis north, centro e south
//        norteLoginSubPanel.setLayout(new BorderLayout());
//        centroLoginSubPanel.setLayout(new BorderLayout());
//        sulLoginSubPanel.setLayout(new BorderLayout());
//
////Adicionar subPaineis no superpainel Login
//        loginSuperPanel.add(norteLoginSubPanel, BorderLayout.NORTH);
//        loginSuperPanel.add(centroLoginSubPanel, BorderLayout.CENTER);
//        loginSuperPanel.add(sulLoginSubPanel, BorderLayout.SOUTH);
//
///// Criação dos subpaineis nos subpaineis norte, centro e sul
//        JPanel norteLoginSSPanelTitle = new JPanel();
//        JPanel centroLoginSSPanelForm = new JPanel();
//        JPanel centroLoginSSPanelButton = new JPanel();
//        JPanel sulLoginSSPanelLinks = new JPanel();
//
////Layout dos subpaineis dos subpaineis norte, centro e sul
//        norteLoginSubPanel.add(norteLoginSSPanelTitle, BorderLayout.CENTER);
//        norteLoginSubPanel.add(ptEnLoginButton, BorderLayout.EAST);
//        norteLoginSSPanelTitle.setLayout(new FlowLayout());
//        norteLoginSSPanelTitle.add(titleLoginLabel);
//
//        centroLoginSubPanel.add(centroLoginSSPanelForm, BorderLayout.NORTH);
//        centroLoginSSPanelForm.setLayout(new GridLayout(2, 2));
//        centroLoginSSPanelForm.add(usernameLoginLabel);
//        centroLoginSSPanelForm.add(usernameLoginText);
//        centroLoginSSPanelForm.add(passwordLoginLabel);
//        centroLoginSSPanelForm.add(passwordLoginField);
//        centroLoginSubPanel.add(centroLoginSSPanelButton, BorderLayout.SOUTH);
//        centroLoginSSPanelButton.setLayout(new FlowLayout());
//        centroLoginSSPanelButton.add(loginButton);
//
//        sulLoginSubPanel.add(sulLoginSSPanelLinks);
//        sulLoginSSPanelLinks.setLayout(new BorderLayout());
//        sulLoginSSPanelLinks.add(clienteNovoButton, BorderLayout.EAST);
//        sulLoginSSPanelLinks.add(restauranteNovoButton, BorderLayout.WEST);
//
//
//        clienteNovoButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, CLIENTE_CARD);
//            janela.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
//            // no actionlistener)
//        });
//
//        restauranteNovoButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, RESTAURANTE_CARD);
//            janela.setSize(LARGURA_PADRAO, 350);
//            // passar por parâmetro no construtor (fica como referência pq qdo precisarmos
//            // no actionlistener)
//        });
//    }
//
//    ////////////////////NOVO CLIENTE/////////////////////////
//    private void construirPanelCliente(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registarNovoClienteSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteNovoClienteSubPanel = new JPanel();
//        norteNovoClienteSubPanel.setLayout(new BorderLayout());
//        JPanel centroNovoClienteSubPanel = new JPanel();
//        JPanel sulNovoClienteSubPanel = new JPanel();
//
//        JLabel registarNovoClienteLabel = new JLabel("NOVO CLIENTE");
//        registarNovoClienteLabel.setForeground(Color.BLUE);
//        JLabel nomeClienteLabel = new JLabel("Nome");
//        //nomeClienteLabel.setBounds(50,80,100,20);
//        JLabel emailClienteLabel = new JLabel("E-mail");
//        JLabel moradaClienteLabel = new JLabel("Morada");
//        JLabel telemovelClienteLabel = new JLabel("Telemóvel");
//        JLabel usernameClienteLabel = new JLabel("Username");
//        JLabel passwordClienteLabel = new JLabel("Password ");
//        JLabel confirmarPasswordClienteLabel = new JLabel("Confirmar password ");
//
//        JTextField nomeClienteText = new JTextField(20);
//        nomeClienteText.setMargin(new Insets(3, 3, 3, 3));
//        //nomeClienteText.setBorder(BorderFactory.createLineBorder(Color.black, 1));
//        JTextField emailClienteText = new JTextField(20);
//        //emailClienteText.setBorder(BorderFactory.createLineBorder(Color.black, 1));
//        JTextField moradaClienteText = new JTextField(20);
//        JTextField telemovelClienteText = new JFormattedTextField(mascaraTelemovel);
//        telemovelClienteText.setColumns(20);
//        JTextField usernameClienteText = new JTextField(20);
//
//        JPasswordField passwordClienteField = new JPasswordField(20);
//        JPasswordField confirmarPassawordClienteField = new JPasswordField(20);
//
//        JButton ptEnNovoClienteButton = new JButton("PT/EN");
//        JButton cancelarClienteButton = new JButton("CANCELAR");
//        JButton registarClienteButton = new JButton("REGISTAR");
//
//        //todo não deu certo
//        //Define as máscaras
//        MaskFormatter mascaraTelCliente = null;
//
//        try {
//            mascaraTelCliente = new MaskFormatter("(##)####-####");
//
//        } catch (ParseException excp) {
//            System.err.println("Erro na formatação: " + excp.getMessage());
//            System.exit(-1);
//        }
//
//        //Seta as máscaras nos objetos JFormattedTextField
//        JFormattedTextField telClienteT = new JFormattedTextField(mascaraTelCliente);
//        //telClienteT.setBounds(150,80,100,20);
//
//
//        registarNovoClienteSuperPanel.add(norteNovoClienteSubPanel, "North");
//        registarNovoClienteSuperPanel.add(centroNovoClienteSubPanel, "Center");
//        registarNovoClienteSuperPanel.add(sulNovoClienteSubPanel, "South");
//
//        JPanel norteNovoClienteSSPanel = new JPanel();
//        norteNovoClienteSSPanel.setLayout(new FlowLayout());
//        norteNovoClienteSSPanel.add(registarNovoClienteLabel);
//        norteNovoClienteSubPanel.add(norteNovoClienteSSPanel, BorderLayout.CENTER);
//        norteNovoClienteSubPanel.add(ptEnNovoClienteButton, BorderLayout.EAST);
//
//        JPanel centroNovoClienteSSPanelForm = new JPanel();
//        centroNovoClienteSSPanelForm.setLayout(new GridLayout(7, 2));
//        centroNovoClienteSubPanel.add(centroNovoClienteSSPanelForm);
//        centroNovoClienteSSPanelForm.add(nomeClienteLabel);
//        centroNovoClienteSSPanelForm.add(nomeClienteText);
//        centroNovoClienteSSPanelForm.add(emailClienteLabel);
//        centroNovoClienteSSPanelForm.add(emailClienteText);
//        centroNovoClienteSSPanelForm.add(moradaClienteLabel);
//        centroNovoClienteSSPanelForm.add(moradaClienteText);
//        centroNovoClienteSSPanelForm.add(telemovelClienteLabel);
//        centroNovoClienteSSPanelForm.add(telemovelClienteText);
//        centroNovoClienteSSPanelForm.add(usernameClienteLabel);
//        centroNovoClienteSSPanelForm.add(usernameClienteText);
//        centroNovoClienteSSPanelForm.add(passwordClienteLabel);
//        centroNovoClienteSSPanelForm.add(passwordClienteField);
//        centroNovoClienteSSPanelForm.add(confirmarPasswordClienteLabel);
//        centroNovoClienteSSPanelForm.add(confirmarPassawordClienteField);
//
//        sulNovoClienteSubPanel.setLayout(new FlowLayout());
//        sulNovoClienteSubPanel.add(cancelarClienteButton);
//        sulNovoClienteSubPanel.add(registarClienteButton);
//
//
//        registarClienteButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//        cancelarClienteButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
//
//        });
//    }
//
//
//    ////// MENU CLIENTE//////////
//    private void construirPanelMenuCliente(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliSuperPanel) {
//
//        /////SUBPAINEIS//////
//        JPanel norteMenuClienteSubPanel = new JPanel();
//        norteMenuClienteSubPanel.setLayout(new BorderLayout());
//        JPanel centroMenuClienteSubPanel = new JPanel();
//        JPanel sulMenuClienteSubPanel = new JPanel();
//
//        JLabel registarNovoClienteLabel = new JLabel("MENU CLIENTE");
//        registarNovoClienteLabel.setForeground(Color.BLUE);
//
//        JButton ptEnMenuClienteButton = new JButton("PT/EN");
//        ////
//        JButton restaurantesMCliButton = new JButton("RESTAURANTES");
//        JButton comentariosMCliButton = new JButton("COMENTÁRIOS");
//        JButton reservasMCliButton = new JButton("RESERVAS");
//
//        JButton atualDadosMCliButton = new JButton("ACTUALIZAR DADOS");
//
//        ///
//        //JButton cancelarMenuClienteButton = new JButton("CANCELAR");
//        JButton logoutMenuClienteButton = new JButton("LOGOUT");
//
//        mCliSuperPanel.add(norteMenuClienteSubPanel, "North");
//        mCliSuperPanel.add(centroMenuClienteSubPanel, "Center");
//        mCliSuperPanel.add(sulMenuClienteSubPanel, "South");
//
//        JPanel norteClienteSubPanel = new JPanel();
//        norteClienteSubPanel.setLayout(new FlowLayout());
//        norteClienteSubPanel.add(registarNovoClienteLabel);
//        norteMenuClienteSubPanel.add(norteClienteSubPanel, BorderLayout.CENTER);
//        norteMenuClienteSubPanel.add(ptEnMenuClienteButton, BorderLayout.EAST);
//
//        JPanel centroNovoClienteSSPanelForm = new JPanel();
//        centroNovoClienteSSPanelForm.setLayout(new GridLayout(7, 2));
//        centroMenuClienteSubPanel.add(centroNovoClienteSSPanelForm);
//        centroNovoClienteSSPanelForm.add(restaurantesMCliButton);
//        centroNovoClienteSSPanelForm.add(comentariosMCliButton);
//        centroNovoClienteSSPanelForm.add(reservasMCliButton);
//
//        centroNovoClienteSSPanelForm.add(atualDadosMCliButton);
//
//        sulMenuClienteSubPanel.setLayout(new FlowLayout());
//        sulMenuClienteSubPanel.add(logoutMenuClienteButton);
//
//        comentariosMCliButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLICOMENTARIOS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        restaurantesMCliButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        reservasMCliButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIRESERVAS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        atualDadosMCliButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIATDADOS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//
//        logoutMenuClienteButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(400, 180);
//        });
//
//    }
//
//
//    ////// MENU CLIENTE – MENU RESERVAS//////////
//    private void construirPanelReservasMCliMRese
//    (Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliReservasMReseSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMReseSubPanel = new JPanel();
//        norteMCliMReseSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMReseSubPanel = new JPanel();
//        JPanel sulMCliMReseSubPanel = new JPanel();
//
//        JLabel registarNovoMCliMReseLabel = new JLabel("MENU CLIENTE - RESERVAS");
//        registarNovoMCliMReseLabel.setForeground(Color.BLUE);
//
//        JButton ptEnMCliMReseButton = new JButton("PT/EN");
//        JButton histReseComPonMCliMReseButton = new JButton("HISTÓRICO");
//        JButton ReservasActMCliMReseButton = new JButton("RESERVAS ACTIVAS");
//        JButton fazerReservasMCliMReseButton = new JButton("FAZER RESERVAS");
//        JButton voltarMCliMReseButton = new JButton("MENU CLIENTE");
//
//        JButton logoutMCliMReseButton = new JButton("LOGOUT");
//
//        mCliReservasMReseSuperPanel.add(norteMCliMReseSubPanel, "North");
//        mCliReservasMReseSuperPanel.add(centroMCliMReseSubPanel, "Center");
//        mCliReservasMReseSuperPanel.add(sulMCliMReseSubPanel, "South");
//
//        JPanel norteMCliMReseSSPanel = new JPanel();
//        norteMCliMReseSSPanel.setLayout(new FlowLayout());
//        norteMCliMReseSSPanel.add(registarNovoMCliMReseLabel);
//        norteMCliMReseSubPanel.add(norteMCliMReseSSPanel, BorderLayout.CENTER);
//        norteMCliMReseSubPanel.add(ptEnMCliMReseButton, BorderLayout.EAST);
//
//        JPanel centroNovoMCliMReseSSPanel = new JPanel();
//        centroNovoMCliMReseSSPanel.setLayout(new GridLayout(7, 2));
//        centroMCliMReseSubPanel.add(centroNovoMCliMReseSSPanel);
//
//        centroNovoMCliMReseSSPanel.add(histReseComPonMCliMReseButton);
//        centroNovoMCliMReseSSPanel.add(ReservasActMCliMReseButton);
//        centroNovoMCliMReseSSPanel.add(fazerReservasMCliMReseButton);
//
//        sulMCliMReseSubPanel.setLayout(new FlowLayout());
//        sulMCliMReseSubPanel.add(logoutMCliMReseButton);
//        sulMCliMReseSubPanel.add(voltarMCliMReseButton);
//
//
//        histReseComPonMCliMReseButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIHISRES_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        ReservasActMCliMReseButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIRESACT_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        fazerReservasMCliMReseButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIFAZERRES_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliMReseButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        logoutMCliMReseButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(400, 180);
//        });
//
//    }
//
//
//    //////MENU CLIENTE – RESERVAS - HISTÓRICO//////////
//
//    private void construirPanelMCliHistRes(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliHistResSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliHistResSubPanel = new JPanel();
//        norteMCliHistResSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliHistResSubPanel = new JPanel();
//        JPanel sulMCliHistResSubPanel = new JPanel();
//
//        JLabel mCliTitHistResLabel = new JLabel("MENU CLIENTE - HISTÓRICO DE RESERVAS");
//
//        JLabel mCliIdHistResLabel = new JLabel("ID");
//
//        String[] mCliIdHistRes = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//        JComboBox arrayMCliIdHistResCBox = new JComboBox(mCliIdHistRes);
//
////todo faltou visualizar – aumentar tamanho da coluna e tornar possível seleção para visualizar, comentar e pontuar
//        String[] nomeColunasMCliHistRes = new String[]{
//                "ID", "DATA", "RESTAURANTE"
//        };
//
//        Object[][] data = new Object[][]{
//                {"ID", "DATA", "RESTAURANTE"},
//                {1, "dd/MM/yyy", "A"},
//                {1, "dd/MM/yyy", "B"},
//                {3, "dd/MM/yyy", "C"},
//        };
//        //criação da tabela
//        JTable tabelaMCliHistRes = new JTable(data, nomeColunasMCliHistRes);
//
//        JButton ptEnMCliRestButton = new JButton("PT/EN");
//        JButton voltarMCliHistResButton = new JButton("MENU CLIENTE");
//        JButton comentarMCliHistResButton = new JButton("COMENTAR");
//        JButton retornarMCliHistResButton = new JButton("VOLTAR");
//
//        mCliHistResSuperPanel.add(norteMCliHistResSubPanel, "North");
//        mCliHistResSuperPanel.add(centroMCliHistResSubPanel, "Center");
//        mCliHistResSuperPanel.add(sulMCliHistResSubPanel, "South");
//
//        JPanel norteMCliHistResSSPanel = new JPanel();
//        norteMCliHistResSSPanel.setLayout(new FlowLayout());
//        norteMCliHistResSSPanel.add(mCliTitHistResLabel);
//        norteMCliHistResSubPanel.add(norteMCliHistResSSPanel, BorderLayout.CENTER);
//        norteMCliHistResSubPanel.add(ptEnMCliRestButton, BorderLayout.EAST);
//
//        JPanel centroMCliHistResSSPanel = new JPanel();
//        centroMCliHistResSSPanel.setLayout(new FlowLayout());
//        centroMCliHistResSubPanel.add(centroMCliHistResSSPanel, BorderLayout.WEST);
//
//        JPanel centroMCliHistResSSPanel1 = new JPanel();
//        centroMCliHistResSSPanel1.setLayout(new FlowLayout());
//        centroMCliHistResSubPanel.add(centroMCliHistResSSPanel1, BorderLayout.WEST);
//
//        centroMCliHistResSSPanel.add(tabelaMCliHistRes);
//        centroMCliHistResSSPanel1.add(mCliIdHistResLabel);
//        centroMCliHistResSSPanel1.add(arrayMCliIdHistResCBox);
//
//        sulMCliHistResSubPanel.setLayout(new FlowLayout());
//        sulMCliHistResSubPanel.add(voltarMCliHistResButton);
//        sulMCliHistResSubPanel.add(retornarMCliHistResButton);
//        sulMCliHistResSubPanel.add(comentarMCliHistResButton);
//
//        retornarMCliHistResButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIRESERVAS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        //todo falta ativar este botão
//        comentarMCliHistResButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESCOMPONTRESE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliHistResButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//    }
//
//    //todo espaço para escrever comentário pode ter barra de rolagem? ativar o botão OK
//    /////////// MENU CLIENTE - MENU RESERVA - HISTÓRICO DE RESERVAS - COMENTAR UMA RESERVA///////
//    private void construirPanelMCliMResComPonReservas(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMResComPontReseSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliRestComPonReseSubPanel = new JPanel();
//        norteMCliRestComPonReseSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliRestComPonReseSubPanel = new JPanel();
//        JPanel sulMCliRestComPonReseSubPanel = new JPanel();
//
//        JRadioButton umPont = new JRadioButton("1");
//        JRadioButton doisPont = new JRadioButton("2");
//        JRadioButton tresPont = new JRadioButton("3");
//        JRadioButton quatroPont = new JRadioButton("4");
//        JRadioButton cincoPont = new JRadioButton("5");
//
//        JLabel mCliRestComPonReseLabel = new JLabel("MENU CLIENTE – HISTÓRICO DE RESERVAS - COMENTAR");
//        JLabel restMCliMReseComPonLabel = new JLabel("RESTAURANTE");
//        JLabel dataMCliMReseComPonLabel = new JLabel("DATA DA RESERVA");
//        JLabel pontMCliRestComPonReseLabel = new JLabel("ATRIBUIR PONTUAÇÃO:");
//
//        JTextField restMCliMReseComPonText = new JTextField(20);
//        JTextField dataMCliMReseComPonText = new JTextField(8);
//        JTextArea novoComMCliMReseComPonTextA = new JTextArea(5, 50);
//        //novoComMCliMReseComPonTextA.setSize(100, 80);
//
//        ButtonGroup group = new ButtonGroup();
//        group.add(umPont);
//        group.add(doisPont);
//        group.add(tresPont);
//        group.add(quatroPont);
//        group.add(cincoPont);
//
//        JButton ptEnMCliRestComPonReseButton = new JButton("PT/EN");
//        JButton voltarMCliRestComPonReseButton = new JButton("MENU CLIENTE");
//        JButton okMCliRestComPonReseButton = new JButton("OK");
//        JButton retornarMCliRestComPonReseButton = new JButton("VOLTAR");
//
//        mCliMResComPontReseSuperPanel.add(norteMCliRestComPonReseSubPanel, "North");
//        mCliMResComPontReseSuperPanel.add(centroMCliRestComPonReseSubPanel, "Center");
//        mCliMResComPontReseSuperPanel.add(sulMCliRestComPonReseSubPanel, "South");
//
//        JPanel norteMCliRestComPonReseSSPanel = new JPanel();
//        norteMCliRestComPonReseSSPanel.setLayout(new FlowLayout());
//        norteMCliRestComPonReseSSPanel.add(mCliRestComPonReseLabel);
//        norteMCliRestComPonReseSubPanel.add(norteMCliRestComPonReseSSPanel, BorderLayout.CENTER);
//        norteMCliRestComPonReseSubPanel.add(ptEnMCliRestComPonReseButton, BorderLayout.EAST);
//
//        JPanel centroMCliRestComPonReseSSPanel = new JPanel();
//        centroMCliRestComPonReseSSPanel.setLayout(new FlowLayout());
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel, BorderLayout.WEST);
//
//        JPanel centroMCliRestComPonReseSSPanel1 = new JPanel();
//        centroMCliRestComPonReseSSPanel1.setLayout(new FlowLayout());
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel1, BorderLayout.CENTER);
//
//        JPanel centroMCliRestComPonReseSSPanel2 = new JPanel();
//        centroMCliRestComPonReseSSPanel2.setLayout(new GridLayout(1, 1));
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel2);
//
//        JPanel centroMCliRestComPonReseSSPanel3 = new JPanel();
//        centroMCliRestComPonReseSSPanel3.setLayout(new BorderLayout());
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel3, BorderLayout.WEST);
//
//        JPanel centroMCliRestComPonReseSSPanel4 = new JPanel();
//        centroMCliRestComPonReseSSPanel4.setLayout(new BorderLayout());
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel4, BorderLayout.WEST);
//
//        JPanel centroMCliRestComPonReseSSPanel5 = new JPanel();
//        centroMCliRestComPonReseSSPanel5.setLayout(new BorderLayout());
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel5, BorderLayout.WEST);
//
//        JPanel centroMCliRestComPonReseSSPanel6 = new JPanel();
//        centroMCliRestComPonReseSSPanel6.setLayout(new BorderLayout());
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel6, BorderLayout.WEST);
//
//        JPanel centroMCliRestComPonReseSSPanel7 = new JPanel();
//        centroMCliRestComPonReseSSPanel7.setLayout(new BorderLayout());
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel7, BorderLayout.WEST);
//
//        JPanel centroMCliRestComPonReseSSPanel8 = new JPanel();
//        centroMCliRestComPonReseSSPanel8.setLayout(new GridLayout(1, 2));
//        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel8);
//        centroMCliRestComPonReseSSPanel.add(restMCliMReseComPonLabel);
//        centroMCliRestComPonReseSSPanel.add(restMCliMReseComPonText);
//        centroMCliRestComPonReseSSPanel.add(dataMCliMReseComPonLabel);
//        centroMCliRestComPonReseSSPanel.add(dataMCliMReseComPonText);
//        centroMCliRestComPonReseSSPanel1.add(novoComMCliMReseComPonTextA);
//
//        centroMCliRestComPonReseSSPanel2.add(pontMCliRestComPonReseLabel);
//        centroMCliRestComPonReseSSPanel3.add(umPont);
//        centroMCliRestComPonReseSSPanel4.add(doisPont);
//        centroMCliRestComPonReseSSPanel5.add(tresPont);
//        centroMCliRestComPonReseSSPanel6.add(quatroPont);
//        centroMCliRestComPonReseSSPanel7.add(cincoPont);
//
//        sulMCliRestComPonReseSubPanel.setLayout(new FlowLayout());
//        sulMCliRestComPonReseSubPanel.add(voltarMCliRestComPonReseButton);
//        sulMCliRestComPonReseSubPanel.add(retornarMCliRestComPonReseButton);
//        sulMCliRestComPonReseSubPanel.add(okMCliRestComPonReseButton);
//
//        retornarMCliRestComPonReseButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIRESERVAS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//        voltarMCliRestComPonReseButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        //todo ver os encaminhamentos
//        okMCliRestComPonReseButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(500, 180);
//        });
//    }
//
//
//    ////////////////////NOVO RESTAURANTE/////////////////////////
//    private void construirPanelRestaurante(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel registarNovoRestauranteSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteNovoRestauranteSubPanel = new JPanel();
//        norteNovoRestauranteSubPanel.setLayout(new BorderLayout());
//        JPanel centroNovoRestauranteSubPanel = new JPanel();
//        centroNovoRestauranteSubPanel.setLayout(new FlowLayout());
//        JPanel sulNovoRestauranteSubPanel = new JPanel();
//
//        JLabel registarNovoRestauranteLabel = new JLabel("NOVO RESTAURANTE");
//        registarNovoRestauranteLabel.setForeground(Color.RED);
//        JLabel nomeRestauranteLabel = new JLabel("Nome");
//        JLabel emailRestauranteLabel = new JLabel("E-mail");
//        JLabel moradaRestauranteLabel = new JLabel("Morada");
//        JLabel cidadeRestauranteLabel = new JLabel("Cidade");
//        JLabel telemovelRestauranteLabel = new JLabel("Telemóvel");
/////////////////////////
//        JLabel lotacaoRestauranteLabel = new JLabel("Lotação:");
//        JLabel esplanadaRestauranteLabel = new JLabel("Esplanada");
//        JLabel zonaInteriorLabel = new JLabel("Zona Interior:");
//        JLabel zonaInteriorNFumRestauranteLabel = new JLabel("Ñ Fumadores");
//        JLabel zonaInteriorFumRestauranteLabel = new JLabel("Fumadores");
//        JLabel horariosRestauranteLabel = new JLabel("Horários:");
//        JLabel horariosAlmocoRestauranteLabel = new JLabel("Almoço:");
//        JLabel horarioAlmocoInicioRestauranteLabel = new JLabel("Início");
//        JLabel horarioAlmocoFimRestauranteLabel = new JLabel("Fim");
//        JLabel horariosJantarRestauranteLabel = new JLabel("Jantar:");
//        JLabel horarioJantarInicioRestauranteLabel = new JLabel("Início");
//        JLabel horarioJantarFimRestauranteLabel = new JLabel("Fim");
////////////////////////////////////
//
//
//        JLabel usernameRestauranteLabel = new JLabel("Username");
//        JLabel passwordRestauranteLabel = new JLabel("Password ");
//        JLabel confirmarPasswordRestauranteLabel = new JLabel("Confirmar password ");
//
//        JTextField nomeRestauranteText = new JTextField(18);
//        nomeRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField emailRestauranteText = new JTextField(18);
//        emailRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField moradaRestauranteText = new JTextField(20);
//        moradaRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField cidadeRestauranteText = new JTextField(15);
//        cidadeRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField telemovelRestauranteText = new JFormattedTextField(mascaraTelemovel);
//        telemovelRestauranteText.setColumns(8);
//        telemovelRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        ////////
//        JTextField esplanadaRestauranteText = new JTextField(3);
//        esplanadaRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField zonaInteriorNFumRestauranteText = new JTextField(3);
//        zonaInteriorNFumRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField zonaInteriorFumRestauranteText = new JTextField(3);
//        zonaInteriorFumRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField horarioAlmocoInicioRestauranteText = new JTextField(3);
//        horarioAlmocoInicioRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField horarioAlmocoFimRestauranteText = new JTextField(3);
//        horarioAlmocoFimRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField horarioJantarInicioRestauranteText = new JTextField(3);
//        horarioJantarInicioRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField horarioJantarFimRestauranteText = new JTextField(3);
//        horarioJantarFimRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        ///////
//        JTextField usernameRestauranteText = new JTextField(20);
//        usernameRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//
//        JPasswordField passwordRestauranteField = new JPasswordField(15);
//        passwordRestauranteField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JPasswordField confirmarPasswordRestauranteField = new JPasswordField(15);
//        confirmarPasswordRestauranteField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//
//        JButton ptEnNovoRestauranteButton = new JButton("PT/EN");
//        JButton cancelarRestauranteButton = new JButton("CANCELAR");
//        JButton registarRestauranteButton = new JButton("REGISTAR");
//
//        registarNovoRestauranteSuperPanel.add(norteNovoRestauranteSubPanel, "North");
//        registarNovoRestauranteSuperPanel.add(centroNovoRestauranteSubPanel, "Center");
//        registarNovoRestauranteSuperPanel.add(sulNovoRestauranteSubPanel, "South");
//
////        JPanel norteSupMRestSubPanel = new JPanel();
////        norteSupMRestSubPanel.setLayout(new FlowLayout());
////        norteNovoRestauranteSubPanel.add(norteSupMRestSubPanel, BorderLayout.CENTER);
////        norteSupMRestSubPanel.add(registarNovoRestauranteLabel);
////        norteNovoRestauranteSubPanel.add(ptEnNovoRestauranteButton, BorderLayout.EAST);
//
//        JPanel norteNovoRestSSPanel = new JPanel();
//        norteNovoRestSSPanel.setLayout(new FlowLayout());
//        norteNovoRestSSPanel.add(registarNovoRestauranteLabel);
//        norteNovoRestauranteSubPanel.add(norteNovoRestSSPanel, BorderLayout.CENTER);
//        norteNovoRestauranteSubPanel.add(ptEnNovoRestauranteButton, BorderLayout.EAST);
//
//        JPanel centroNovoRestSSPanelForm1 = new JPanel();
//        centroNovoRestSSPanelForm1.setLayout(new FlowLayout());
//        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm1);
//        JPanel centroNovoRestSSPanelForm2 = new JPanel();
//        centroNovoRestSSPanelForm2.setLayout(new FlowLayout());
//        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm2, BorderLayout.CENTER);
//        JPanel centroNovoRestSSPanelForm2A = new JPanel();
//        centroNovoRestSSPanelForm2A.setLayout(new FlowLayout());
//        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm2A, BorderLayout.CENTER);
//        JPanel centroNovoRestSSPanelForm3 = new JPanel();
//        //centroNovoRestSSPanelForm3.setLayout(new FlowLayout());
//        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm3, BorderLayout.CENTER);
//
//        JPanel centroNovoRestSSPanelForm4 = new JPanel();
//        centroNovoRestSSPanelForm4.setLayout(new FlowLayout());
//        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm4, BorderLayout.CENTER);
//
//        JPanel centroNovoRestSSPanelForm5 = new JPanel();
//        centroNovoRestSSPanelForm5.setLayout(new FlowLayout());
//        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm5, BorderLayout.CENTER);
//
//        JPanel centroNovoRestSSPanelForm6 = new JPanel();
//        centroNovoRestSSPanelForm6.setLayout(new FlowLayout());
//        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm6, BorderLayout.CENTER);
//
//        centroNovoRestSSPanelForm1.add(nomeRestauranteLabel);
//        centroNovoRestSSPanelForm1.add(nomeRestauranteText);
//        centroNovoRestSSPanelForm1.add(emailRestauranteLabel);
//        centroNovoRestSSPanelForm1.add(emailRestauranteText);
//        centroNovoRestSSPanelForm2.add(moradaRestauranteLabel);
//        centroNovoRestSSPanelForm2.add(moradaRestauranteText);
//        centroNovoRestSSPanelForm2A.add(cidadeRestauranteLabel);
//        centroNovoRestSSPanelForm2A.add(cidadeRestauranteText);
//        centroNovoRestSSPanelForm2A.add(telemovelRestauranteLabel);
//        centroNovoRestSSPanelForm2A.add(telemovelRestauranteText);
//        /////
//        centroNovoRestSSPanelForm3.add(lotacaoRestauranteLabel);
//        centroNovoRestSSPanelForm3.add(esplanadaRestauranteLabel);
//        centroNovoRestSSPanelForm3.add(esplanadaRestauranteText);
//        centroNovoRestSSPanelForm3.add(zonaInteriorLabel);
//        centroNovoRestSSPanelForm3.add(zonaInteriorNFumRestauranteLabel);
//        centroNovoRestSSPanelForm3.add(zonaInteriorNFumRestauranteText);
//        centroNovoRestSSPanelForm3.add(zonaInteriorFumRestauranteLabel);
//        centroNovoRestSSPanelForm3.add(zonaInteriorFumRestauranteText);
//
//        centroNovoRestSSPanelForm4.add(horariosRestauranteLabel);
//        centroNovoRestSSPanelForm4.add(horariosAlmocoRestauranteLabel);
//        centroNovoRestSSPanelForm4.add(horarioAlmocoInicioRestauranteLabel);
//        centroNovoRestSSPanelForm4.add(horarioAlmocoInicioRestauranteText);
//        centroNovoRestSSPanelForm4.add(horarioAlmocoFimRestauranteLabel);
//        centroNovoRestSSPanelForm4.add(horarioAlmocoFimRestauranteText);
//        centroNovoRestSSPanelForm4.add(horariosJantarRestauranteLabel);
//        centroNovoRestSSPanelForm4.add(horarioJantarInicioRestauranteLabel);
//        centroNovoRestSSPanelForm4.add(horarioJantarInicioRestauranteText);
//        centroNovoRestSSPanelForm4.add(horarioJantarFimRestauranteLabel);
//        centroNovoRestSSPanelForm4.add(horarioJantarFimRestauranteText);
//
//        //
//        centroNovoRestSSPanelForm5.add(usernameRestauranteLabel);
//        centroNovoRestSSPanelForm5.add(usernameRestauranteText);
//
//        centroNovoRestSSPanelForm6.add(passwordRestauranteLabel);
//        centroNovoRestSSPanelForm6.add(passwordRestauranteField);
//        centroNovoRestSSPanelForm6.add(confirmarPasswordRestauranteLabel);
//        centroNovoRestSSPanelForm6.add(confirmarPasswordRestauranteField);
//
//
//        sulNovoRestauranteSubPanel.setLayout(new FlowLayout());
//        sulNovoRestauranteSubPanel.add(cancelarRestauranteButton);
//        sulNovoRestauranteSubPanel.add(registarRestauranteButton);
//
//        cancelarRestauranteButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(500, 180);
//        });
//
//        registarRestauranteButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(500, 300);
//
//        });
//    }
//
//    //////MENU RESTAURANTE////////
//    private void construirPanelMRest(Container contentor, JPanel loginSuperPanel, JPanel menuRestauranteSuperPanel) {
//
//        /////SUBPAINEIS//////
//        JPanel norteMenuRestauranteSubPanel = new JPanel();
//        norteMenuRestauranteSubPanel.setLayout(new BorderLayout());
//        JPanel centroMenuRestauranteSubPanel = new JPanel();
//        JPanel sulMenuRestauranteSubPanel = new JPanel();
//
//        JLabel registarNovoRestauranteLabel = new JLabel("MENU RESTAURANTE");
//        registarNovoRestauranteLabel.setForeground(Color.RED);
//
//        JButton ptEnMenuRestauranteButton = new JButton("PT/EN");
//        ////
//        JButton mRestAdicionarPratoButton = new JButton("ADICIONAR PRATO");
//        JButton mRestActualizarPratoDiaButton = new JButton("ACTUALIZAR PRATO DO DIA");
//        JButton mRestActualizarDadosButton = new JButton("ACTUALIZAR DADOS");
//        JButton mRestReservasButton = new JButton("RESERVAS");
//        JButton mRestConsultarComentariosButton = new JButton("COMENTÁRIOS");
//        JButton pontuacaoMedia = new JButton("PONTUAÇÃO MÉDIA");
//
//
//        ///
//        //JButton cancelarMenuRestauranteButton = new JButton("CANCELAR");
//        JButton logoutMenuRestauranteButton = new JButton("LOGOUT");
//
//        menuRestauranteSuperPanel.add(norteMenuRestauranteSubPanel, "North");
//        menuRestauranteSuperPanel.add(centroMenuRestauranteSubPanel, "Center");
//        menuRestauranteSuperPanel.add(sulMenuRestauranteSubPanel, "South");
//
//        JPanel norteMenuRestauranteSSPanel = new JPanel();
//        norteMenuRestauranteSSPanel.setLayout(new FlowLayout());
//        norteMenuRestauranteSSPanel.add(registarNovoRestauranteLabel);
//        norteMenuRestauranteSubPanel.add(norteMenuRestauranteSSPanel, BorderLayout.CENTER);
//        norteMenuRestauranteSubPanel.add(ptEnMenuRestauranteButton, BorderLayout.EAST);
//
//        JPanel centroNovoRestauranteSSPanelForm = new JPanel();
//        centroNovoRestauranteSSPanelForm.setLayout(new GridLayout(7, 1));
//        centroMenuRestauranteSubPanel.add(centroNovoRestauranteSSPanelForm);
//        centroNovoRestauranteSSPanelForm.add(mRestAdicionarPratoButton);
//        centroNovoRestauranteSSPanelForm.add(mRestActualizarPratoDiaButton);
//        centroNovoRestauranteSSPanelForm.add(mRestActualizarDadosButton);
//        centroNovoRestauranteSSPanelForm.add(mRestReservasButton);
//        centroNovoRestauranteSSPanelForm.add(mRestConsultarComentariosButton);
//        centroNovoRestauranteSSPanelForm.add(pontuacaoMedia);
//
//        sulMenuRestauranteSubPanel.setLayout(new FlowLayout());
//        //sulMenuRestauranteSubPanel.add(cancelarMenuRestauranteButton);
//        sulMenuRestauranteSubPanel.add(logoutMenuRestauranteButton);
//
////        cancelarMenuRestauranteButton.addActionListener(a -> {
////           CardLayout cl = (CardLayout) contentor.getLayout();
////           cl.show(contentor, LOGIN_CARD);
////            this.setSize(500, 300);
////
////       });
//        mRestAdicionarPratoButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MRESTADICIONARPRATO_CARD);
//            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
//        });
//
//        mRestActualizarPratoDiaButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MRESTACTUALIZARPRATO_CARD);
//            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
//        });
//
//        mRestReservasButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MRESTRESERV_CARD);
//            this.setSize(LARGURA_PADRAO, 350);
//        });
//
//        mRestActualizarDadosButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MRESTACTUALIZARDADOS_CARD);
//            this.setSize(LARGURA_PADRAO, 350);
//        });
//
////        mRestReservasButton.addActionListener(a -> {
////            CardLayout cl = (CardLayout) contentor.getLayout();
////            cl.show(contentor, MRESTCOMENTARIOS_CARD);
////            this.setSize(LARGURA_PADRAO, 350);
////      });
//
//        mRestConsultarComentariosButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MRESTCOMENTARIOS_CARD);
//            this.setSize(LARGURA_PADRAO, 350);
//        });
//
//        logoutMenuRestauranteButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
//        });
//    }
//
//    ///////////MENU RESTAURANTE - ADICIONAR PRATO//////////////////////
//    private void construirPanelMRestAdPrato(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestAdPratoSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteAdPratoSubPanel = new JPanel();
//        norteAdPratoSubPanel.setLayout(new BorderLayout());
//        JPanel centroAdPratoSubPanel = new JPanel();
//        JPanel sulAdPratoSubPanel = new JPanel();
//
//        JLabel adPratoLabel = new JLabel("ADICIONAR PRATO");
//        JLabel nomePratoLabel = new JLabel("Nome Prato");
//        JLabel descricaoPratoLabel = new JLabel("Descrição");
//        JLabel precoPratoLabel = new JLabel("Preço");
//
//        JTextField nomePratoText = new JTextField(20);
//        JTextField descricaoPratoText = new JTextField(20);
//        JTextField precoPratoText = new JTextField(10);
//
//
//        JButton ptEnAdPratoButton = new JButton("PT/EN");
//        JButton voltarMenuRestAdPratoButton = new JButton("MENU RESTAURANTE");
//        JButton confirmarAdPratoButton = new JButton("CONFIRMAR");
//
//
//        JComboBox tipoPratoAd = new JComboBox();
//        tipoPratoAd.addItem("Carta");
//        tipoPratoAd.addItem("Prato do dia");
//
//
//        mRestAdPratoSuperPanel.add(norteAdPratoSubPanel, "North");
//        mRestAdPratoSuperPanel.add(centroAdPratoSubPanel, "Center");
//        mRestAdPratoSuperPanel.add(sulAdPratoSubPanel, "South");
//
//        JPanel norteAdPratoSSPanel = new JPanel();
//        norteAdPratoSSPanel.setLayout(new FlowLayout());
//        norteAdPratoSSPanel.add(adPratoLabel);
//        norteAdPratoSubPanel.add(norteAdPratoSSPanel, BorderLayout.CENTER);
//        norteAdPratoSubPanel.add(ptEnAdPratoButton, BorderLayout.EAST);
//
//        JPanel centroAdPratoSSPanelForm = new JPanel();
//        centroAdPratoSSPanelForm.setLayout(new GridLayout(5, 2));
//        centroAdPratoSubPanel.add(centroAdPratoSSPanelForm);
//        centroAdPratoSubPanel.add(tipoPratoAd);
//        centroAdPratoSSPanelForm.add(nomePratoLabel);
//        centroAdPratoSSPanelForm.add(nomePratoText);
//        centroAdPratoSSPanelForm.add(descricaoPratoLabel);
//        centroAdPratoSSPanelForm.add(descricaoPratoText);
//        centroAdPratoSSPanelForm.add(precoPratoLabel);
//        centroAdPratoSSPanelForm.add(precoPratoText);
//
//        sulAdPratoSubPanel.setLayout(new FlowLayout());
//        sulAdPratoSubPanel.add(voltarMenuRestAdPratoButton);
//        sulAdPratoSubPanel.add(confirmarAdPratoButton);
//
//
//        voltarMenuRestAdPratoButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//        confirmarAdPratoButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//    }
//
//    /////////MENU RESTAURANTE – ACTUALIZAR PRATO//////////////////////
//    private void construirPanelMRestAtPratoDia(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestAtPratoSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteAtPratoSubPanel = new JPanel();
//        norteAtPratoSubPanel.setLayout(new BorderLayout());
//        JPanel centroAtPratoSubPanel = new JPanel();
//        JPanel sulAtPratoSubPanel = new JPanel();
//
//        JLabel atPratoLabel = new JLabel("ACTUALIZAR PRATO DO DIA");
//        JLabel atNomePratoLabel = new JLabel("Nome Prato");
//        JLabel atDescricaoPratoLabel = new JLabel("Descrição");
//        JLabel atPrecoPratoLabel = new JLabel("Preço");
//
//        JTextField atNomePratoText = new JTextField(20);
//        JTextField atDescricaoPratoText = new JTextField(20);
//        JTextField atPrecoPratoText = new JTextField(10);
//
//        JButton ptEnAtPratoButton = new JButton("PT/EN");
//        JButton voltarMenuRestAtPratoButton = new JButton("MENU RESTAURANTE");
//        JButton confirmarAtPratoButton = new JButton("CONFIRMAR");
//
//        mRestAtPratoSuperPanel.add(norteAtPratoSubPanel, "North");
//        mRestAtPratoSuperPanel.add(centroAtPratoSubPanel, "Center");
//        mRestAtPratoSuperPanel.add(sulAtPratoSubPanel, "South");
//
//        JPanel norteAtPratoSSPanel = new JPanel();
//        norteAtPratoSSPanel.setLayout(new FlowLayout());
//        norteAtPratoSSPanel.add(atPratoLabel);
//        norteAtPratoSubPanel.add(norteAtPratoSSPanel, BorderLayout.CENTER);
//        norteAtPratoSubPanel.add(ptEnAtPratoButton, BorderLayout.EAST);
//
//        JPanel centroAtPratoSSPanelForm = new JPanel();
//        centroAtPratoSSPanelForm.setLayout(new GridLayout(3, 2));
//        centroAtPratoSubPanel.add(centroAtPratoSSPanelForm);
//        //centroAtPratoSSPanelForm.add(atPratoLabel);
//        centroAtPratoSSPanelForm.add(atNomePratoLabel);
//        centroAtPratoSSPanelForm.add(atNomePratoText);
//        centroAtPratoSSPanelForm.add(atDescricaoPratoLabel);
//        centroAtPratoSSPanelForm.add(atDescricaoPratoText);
//        centroAtPratoSSPanelForm.add(atPrecoPratoLabel);
//        centroAtPratoSSPanelForm.add(atPrecoPratoText);
//
//        sulAtPratoSubPanel.setLayout(new FlowLayout());
//        sulAtPratoSubPanel.add(voltarMenuRestAtPratoButton);
//        sulAtPratoSubPanel.add(confirmarAtPratoButton);
//
//
//        voltarMenuRestAtPratoButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//        confirmarAtPratoButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//    }
//
//    ///////////////////MENU RESTAURANTE - ACTUALIZAR DADOS /////////////////////////
//    private void construirPanelMRestAtDados(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestAtDadosSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMRestAtDadosSubPanel = new JPanel();
//        norteMRestAtDadosSubPanel.setLayout(new BorderLayout());
//        JPanel centroMRestAtDadosSubPanel = new JPanel();
//        JPanel sulMRestAtDadosSubPanel = new JPanel();
//
//        JLabel atDadosRestLabel = new JLabel("ACTUALIZAR DADOS");
//        JLabel nomeAtDadosRestLabel = new JLabel("Nome");
//        JLabel emailAtDadosRestLabel = new JLabel("E-mail");
//        JLabel moradaAtDadosRestLabel = new JLabel("Morada");
//        JLabel cidadeAtDadosRestLabel = new JLabel("Cidade");
//        JLabel telemovelAtDadosRestLabel = new JLabel("Telemóvel");
/////////////////////////
//        JLabel lotacaoAtDadosRestLabel = new JLabel("Lotação:");
//        JLabel esplanadaAtDadosRestLabel = new JLabel("Esplanada");
//        JLabel zonaInteriorAtDadosRestLabel = new JLabel("Zona Interior:");
//        JLabel zonaInteriorNFumAtDadosRestLabel = new JLabel("Ñ Fumadores");
//        JLabel zonaInteriorFumAtDadosRestLabel = new JLabel("Fumadores");
//        JLabel horariosAtDadosRestLabel = new JLabel("Horários:");
//        JLabel horariosAlmocoAtDadosRestLabel = new JLabel("Almoço:");
//        JLabel horarioAlmocoInicioAtDadosRestLabel = new JLabel("Início");
//        JLabel horarioAlmocoFimAtDadosRestLabel = new JLabel("Fim");
//        JLabel horariosJantarAtDadosRestLabel = new JLabel("Jantar:");
//        JLabel horarioJantarInicioAtDadosRestLabel = new JLabel("Início");
//        JLabel horarioJantarFimAtDadosRestLabel = new JLabel("Fim");
//        JLabel usernameAtDadosRestLabel = new JLabel("Username");
//        JLabel passwordAtDadosRestLabel = new JLabel("Password");
//        JLabel confirmarPasswordAtDadosRestLabel = new JLabel("Confirmar password ");
//
//        JTextField nomeAtDadosRestText = new JTextField(18);
//        nomeAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField emailAtDadosRestText = new JTextField(18);
//        emailAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField moradaAtDadosRestText = new JTextField(20);
//        moradaAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField cidadeAtDadosRestText = new JTextField(15);
//        cidadeAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField telemovelAtDadosRestText = new JFormattedTextField(mascaraTelemovel);
//        telemovelAtDadosRestText.setColumns(8);
//        telemovelAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//
//        //JTextField lotacaoAtDadosRestText = new JTextField(5);
//        JTextField esplanadaAtDadosRestText = new JTextField(3);
//        esplanadaAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField zonaInteriorNFumAtDadosRestText = new JTextField(3);
//        zonaInteriorNFumAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField zonaInteriorFumAtDadosRestText = new JTextField(3);
//        zonaInteriorFumAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField horarioAlmocoInicioAtDadosRestText = new JTextField(3);
//        horarioAlmocoInicioAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField horarioAlmocoFimAtDadosRestText = new JTextField(3);
//        horarioAlmocoFimAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField horarioJantarInicioAtDadosRestText = new JTextField(3);
//        horarioJantarInicioAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField horarioJantarFimAtDadosRestText = new JTextField(3);
//        horarioJantarFimAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        ///////
//        JTextField usernameAtDadosRestText = new JTextField(20);
//        usernameAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//
//        JPasswordField passwordAtDadosRestField = new JPasswordField(15);
//        passwordAtDadosRestField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JPasswordField confirmarPasswordAtDadosRestField = new JPasswordField(15);
//        confirmarPasswordAtDadosRestField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//
//        JButton ptEnAtDadosRestButton = new JButton("PT/EN");
//        JButton voltarMenuRestAtDadosRestButton = new JButton("MENU RESTAURANTE");
//        JButton atDadosRestButton = new JButton("ACTUALIZAR");
//
//        mRestAtDadosSuperPanel.add(norteMRestAtDadosSubPanel, "North");
//        mRestAtDadosSuperPanel.add(centroMRestAtDadosSubPanel, "Center");
//        mRestAtDadosSuperPanel.add(sulMRestAtDadosSubPanel, "South");
//
//        JPanel norteAtDadosRestSSPanel = new JPanel();
//        norteAtDadosRestSSPanel.setLayout(new FlowLayout());
//        norteAtDadosRestSSPanel.add(atDadosRestLabel);
//        norteMRestAtDadosSubPanel.add(norteAtDadosRestSSPanel, BorderLayout.CENTER);
//        norteMRestAtDadosSubPanel.add(ptEnAtDadosRestButton, BorderLayout.EAST);
//
//        JPanel centroAtDadosRestSSPanelForm1 = new JPanel();
//        centroAtDadosRestSSPanelForm1.setLayout(new FlowLayout());
//        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm1, BorderLayout.WEST);
//
//        JPanel centroAtDadosRestSSPanelForm2 = new JPanel();
//        centroAtDadosRestSSPanelForm2.setLayout(new FlowLayout());
//        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm2, BorderLayout.WEST);
//
//        JPanel centroAtDadosRestSSPanelForm2A = new JPanel();
//        centroAtDadosRestSSPanelForm2A.setLayout(new FlowLayout());
//        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm2A, BorderLayout.WEST);
//
//        JPanel centroAtDadosRestSSPanelForm3 = new JPanel();
//        //centroAtDadosRestSSPanelForm3.setLayout(new FlowLayout());
//        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm3, BorderLayout.WEST);
//
//        JPanel centroAtDadosRestSSPanelForm4 = new JPanel();
//        centroAtDadosRestSSPanelForm4.setLayout(new FlowLayout());
//        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm4, BorderLayout.WEST);
//
//        JPanel centroAtDadosRestSSPanelForm5 = new JPanel();
//        centroAtDadosRestSSPanelForm5.setLayout(new FlowLayout());
//        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm5, BorderLayout.WEST);
//
//        JPanel centroAtDadosRestSSPanelForm6 = new JPanel();
//        centroAtDadosRestSSPanelForm6.setLayout(new FlowLayout());
//        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm6, BorderLayout.WEST);
//
//        centroAtDadosRestSSPanelForm1.add(nomeAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm1.add(nomeAtDadosRestText);
//        centroAtDadosRestSSPanelForm1.add(emailAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm1.add(emailAtDadosRestText);
//
//        centroAtDadosRestSSPanelForm2.add(moradaAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm2.add(moradaAtDadosRestText);
//        centroAtDadosRestSSPanelForm2A.add(cidadeAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm2A.add(cidadeAtDadosRestText);
//        centroAtDadosRestSSPanelForm2A.add(telemovelAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm2A.add(telemovelAtDadosRestText);
//
//        centroAtDadosRestSSPanelForm3.add(lotacaoAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm3.add(esplanadaAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm3.add(esplanadaAtDadosRestText);
//        centroAtDadosRestSSPanelForm3.add(zonaInteriorAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm3.add(zonaInteriorNFumAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm3.add(zonaInteriorNFumAtDadosRestText);
//        centroAtDadosRestSSPanelForm3.add(zonaInteriorFumAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm3.add(zonaInteriorFumAtDadosRestText);
//
//
//        centroAtDadosRestSSPanelForm4.add(horariosAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm4.add(horariosAlmocoAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm4.add(horarioAlmocoInicioAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm4.add(horarioAlmocoInicioAtDadosRestText);
//        centroAtDadosRestSSPanelForm4.add(horarioAlmocoFimAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm4.add(horarioAlmocoFimAtDadosRestText);
//        centroAtDadosRestSSPanelForm4.add(horariosJantarAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm4.add(horarioJantarInicioAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm4.add(horarioJantarInicioAtDadosRestText);
//        centroAtDadosRestSSPanelForm4.add(horarioJantarFimAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm4.add(horarioJantarFimAtDadosRestText);
//
//        centroAtDadosRestSSPanelForm5.add(usernameAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm5.add(usernameAtDadosRestText);
//
//        centroAtDadosRestSSPanelForm6.add(passwordAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm6.add(passwordAtDadosRestField);
//        centroAtDadosRestSSPanelForm6.add(confirmarPasswordAtDadosRestLabel);
//        centroAtDadosRestSSPanelForm6.add(confirmarPasswordAtDadosRestField);
//
//        sulMRestAtDadosSubPanel.setLayout(new FlowLayout());
//        sulMRestAtDadosSubPanel.add(voltarMenuRestAtDadosRestButton);
//        sulMRestAtDadosSubPanel.add(atDadosRestButton);
//
//        voltarMenuRestAtDadosRestButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        atDadosRestButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//    }
//
//    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS//////////
//    private void construirPanelMRestReservas(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestReservasSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMRestReservasSubPanel = new JPanel();
//        norteMRestReservasSubPanel.setLayout(new BorderLayout());
//        JPanel centroMRestReservasSubPanel = new JPanel();
//        JPanel sulMRestReservasSubPanel = new JPanel();
//
//        JLabel mRestReservasLabel = new JLabel("HISTÓRICO DE RESERVAS");
//        JLabel usernameMRestReservasLabel = new JLabel("Username");
//        //JLabel filtrarTipomRestResLabel = new JLabel("Escolha a opção em que a lista será mostrada:");
//        JLabel filtrarDataInicioMRestReservasLabel = new JLabel("De");
//        JLabel filtrarDataFimMRestReservasLabel = new JLabel("Até");
//
//
//        JTextField usernameMRestReservasText = new JTextField(20);
//
//        JCheckBox cem = new JCheckBox("Até 100");
//        cem.setMnemonic(KeyEvent.VK_C);
//        JCheckBox duzentos = new JCheckBox("100-200");
//        duzentos.setMnemonic(KeyEvent.VK_C);
//        JCheckBox trezentos = new JCheckBox("200-300");
//        trezentos.setMnemonic(KeyEvent.VK_C);
//        JCheckBox quatrocentos = new JCheckBox("+ de 300");
//        quatrocentos.setMnemonic(KeyEvent.VK_C);
//
//
//        JRadioButton filtrarIntervDatasMRestResRButton = new JRadioButton("DATAS");
//        //todo verificar a questão do calendário
//        JRadioButton filtrarTipomRestResRButton = new JRadioButton("TIPO");
//        JRadioButton filtrarIntervValmRestResRButton = new JRadioButton("VALORES");
//        JRadioButton filtrarClientemRestResRButton = new JRadioButton("CLIENTE");
//
//        ButtonGroup group = new ButtonGroup();
//        group.add(filtrarIntervDatasMRestResRButton);
//        group.add(filtrarTipomRestResRButton);
//        group.add(filtrarIntervValmRestResRButton);
//        group.add(filtrarClientemRestResRButton);
//
//        JComboBox<String> filtrosTipoMRestReservasJCBox = new JComboBox<>();
//        filtrosTipoMRestReservasJCBox.addItem("");
//        filtrosTipoMRestReservasJCBox.addItem("Presencial");
//        filtrosTipoMRestReservasJCBox.addItem("Take-Away");
//
//        JButton ptEnMRestReservasButton = new JButton("PT/EN");
//        JButton voltarMRestReservasButton = new JButton("MENU RESTAURANTE");
//        JButton okMRestReservasButton = new JButton("OK");
//
//        //Adição do calendário
//        UtilDateModel model1 = new UtilDateModel();
//        UtilDateModel model2 = new UtilDateModel();
//
//        ResourceBundle b = ResourceBundle.getBundle("Text");
//
//        Properties p = convertResourceBundleToProperties(b);
//        JDatePanelImpl datePanel = new JDatePanelImpl(model1, p);
//        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//
//        JDatePanelImpl datePanel1 = new JDatePanelImpl(model2, p);
//        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
//
//        mRestReservasSuperPanel.add(norteMRestReservasSubPanel, "North");
//        mRestReservasSuperPanel.add(centroMRestReservasSubPanel, "Center");
//        mRestReservasSuperPanel.add(sulMRestReservasSubPanel, "South");
//
//        JPanel norteMRestReservasSSPanel = new JPanel();
//        norteMRestReservasSSPanel.setLayout(new FlowLayout());
//        norteMRestReservasSSPanel.add(mRestReservasLabel);
//        norteMRestReservasSubPanel.add(norteMRestReservasSSPanel, BorderLayout.CENTER);
//        norteMRestReservasSubPanel.add(ptEnMRestReservasButton, BorderLayout.EAST);
//
//        JPanel centroMRestReservasSSPanel = new JPanel();
//        centroMRestReservasSSPanel.setLayout(new FlowLayout());
//        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel, BorderLayout.WEST);
//
//        JPanel centroMRestReservasSSPanel1 = new JPanel();
//        centroMRestReservasSSPanel1.setLayout(new FlowLayout());
//        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel1, BorderLayout.WEST);
//
//        JPanel centroMRestReservasSSPanel2 = new JPanel();
//        centroMRestReservasSSPanel2.setLayout(new FlowLayout());
//        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel2, BorderLayout.WEST);
//
//        JPanel centroMRestReservasSSPanel2A = new JPanel();
//        centroMRestReservasSSPanel2A.setLayout(new GridLayout(1, 1));
//        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel2A, BorderLayout.WEST);
//
//        JPanel centroMRestReservasSSPanel3 = new JPanel();
//        centroMRestReservasSSPanel3.setLayout(new FlowLayout());
//        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel3, BorderLayout.WEST);
//
//        JPanel centroMRestReservasSSPanel4 = new JPanel();
//        centroMRestReservasSSPanel4.setLayout(new FlowLayout());
//        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel4, BorderLayout.WEST);
//
//        centroMRestReservasSSPanel.add(filtrarIntervDatasMRestResRButton);
//        centroMRestReservasSSPanel1.add(filtrarDataInicioMRestReservasLabel);
//        centroMRestReservasSSPanel1.add(datePicker1);
//        centroMRestReservasSSPanel1.add(filtrarDataFimMRestReservasLabel);
//        centroMRestReservasSSPanel1.add(datePicker2);
//
//        centroMRestReservasSSPanel2.add(filtrarTipomRestResRButton);
//        centroMRestReservasSSPanel2A.add(filtrosTipoMRestReservasJCBox);
//
//        centroMRestReservasSSPanel3.add(filtrarIntervValmRestResRButton);
//        centroMRestReservasSSPanel3.add(cem);
//        centroMRestReservasSSPanel3.add(duzentos);
//        centroMRestReservasSSPanel3.add(trezentos);
//        centroMRestReservasSSPanel3.add(quatrocentos);
//
//        centroMRestReservasSSPanel4.add(filtrarClientemRestResRButton);
//        centroMRestReservasSSPanel4.add(usernameMRestReservasLabel);
//        centroMRestReservasSSPanel4.add(usernameMRestReservasText);
//
//        sulMRestReservasSubPanel.setLayout(new FlowLayout());
//        sulMRestReservasSubPanel.add(voltarMRestReservasButton);
//        sulMRestReservasSubPanel.add(okMRestReservasButton);
//
//
//        voltarMRestReservasButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//        //todo ver os encaminhamentos
//        okMRestReservasButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(500, 180);
//        });
//    }
//
//    /**
//     * Convert ResourceBundle into a Properties object.
//     *
//     * @param resource a resource bundle to convert.
//     * @return Properties a properties version of the resource bundle.
//     */
//
//
//////////COMENTEI AQUI NOVAMENTE////////////////////
//
//
//
//
//
//    private static Properties convertResourceBundleToProperties(ResourceBundle resource) {
//        Properties properties = new Properties();
//        Enumeration<String> keys = resource.getKeys();
//        while (keys.hasMoreElements()) {
//            String key = keys.nextElement();
//            properties.put(key, resource.getString(key));
//        }
//        return properties;
//    }
//
//
//    //////MENU RESTAURANTE – COMENTÁRIOS//////////
//    private void construirPanelMRestComentarios(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mRestComentariosSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMRestComentariosSubPanel = new JPanel();
//        norteMRestComentariosSubPanel.setLayout(new BorderLayout());
//        JPanel centroMRestComentariosSubPanel = new JPanel();
//        JPanel sulMRestComentariosSubPanel = new JPanel();
//
//        JLabel mRestComentariosLabel = new JLabel("COMENTÁRIOS RECEBIDOS");
//
//
//        String[] nomeColunasMRestComentarios = new String[]{
//                "USERNAME", "COMENTÁRIO", "PONTUAÇÃO"
//        };
//
//        //todo exemplo a verificar
//        Object[][] dados = new Object[][]{
//                {"USERNAME", "COMENTÁRIO", "PONTUAÇÃO"},
//                {"Nuno", "Muito bom", 4.0},
//                {"Manuel", "Excelente", 5.0},
//                {"André", "Pouco espaço interno", 3.0},
//        };
//        //criação da tabela
//        JTable tabela = new JTable(dados, nomeColunasMRestComentarios);
//
////        JPopupMenu popupMenu = new JPopupMenu();
////        JMenuItem menuItemAdd = new JMenuItem("Responder");
//
//        JButton ptEnMRestReservasButton = new JButton("PT/EN");
//        JButton voltarMRestComentariosButton = new JButton("MENU RESTAURANTE");
//        JButton responderMRestComentariosButton = new JButton("OK");
//
//        mRestComentariosSuperPanel.add(norteMRestComentariosSubPanel, "North");
//        mRestComentariosSuperPanel.add(centroMRestComentariosSubPanel, "Center");
//        mRestComentariosSuperPanel.add(sulMRestComentariosSubPanel, "South");
//
//        JPanel norteMRestComentariosSSPanel = new JPanel();
//        norteMRestComentariosSSPanel.setLayout(new FlowLayout());
//        norteMRestComentariosSSPanel.add(mRestComentariosLabel);
//        norteMRestComentariosSubPanel.add(norteMRestComentariosSSPanel, BorderLayout.CENTER);
//        norteMRestComentariosSubPanel.add(ptEnMRestReservasButton, BorderLayout.EAST);
//
//        JPanel centroMRestReservasSSPanel1 = new JPanel();
//        centroMRestReservasSSPanel1.setLayout(new FlowLayout());
//        centroMRestComentariosSubPanel.add(tabela, BorderLayout.WEST);
//
//        sulMRestComentariosSubPanel.setLayout(new FlowLayout());
//        sulMRestComentariosSubPanel.add(voltarMRestComentariosButton);
//        sulMRestComentariosSubPanel.add(responderMRestComentariosButton);
//
//
//        voltarMRestComentariosButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENURESTAURANTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//        //todo ver os encaminhamentos para responder comentário
//        responderMRestComentariosButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(500, 180);
//        });
//
//    }
//
//    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTROS//////////
//    private void construirPanelMCliMRestFOrdRests(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMRestFOrdRestsSuperPanel) {
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMRestFOrdRestsSubPanel = new JPanel();
//        norteMCliMRestFOrdRestsSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMRestFOrdRestsSubPanel = new JPanel();
//        JPanel sulMCliMRestFOrdRestsSubPanel = new JPanel();
//
//        JLabel mCliMRestFOrdRestsLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
//
//        JLabel fMCliMRestFOrdRestsLabel = new JLabel("FILTRAR:");
//        JButton fhoraFMCliMRestFOrdRestsButton = new JButton("HORA DE FUNCIONAMENTO");
//        JButton fLotMCliMRestFOrdRestsButton = new JButton("LOTAÇÃO");
//        JButton fCidCliMRestFOrdRestsButton = new JButton("CIDADE");
//
//        JLabel fOrdMCliMRestsFOrdRestLabel = new JLabel("FILTRAR/ORDENAR:");
//        JButton fOrdPontCliMRestFOrdRestsButton = new JButton("PONTUAÇÃO");
//        JButton fOrdValoresMCliMRestFOrdRestsButton = new JButton("VALORES MÉDIOS DOS PRATOS");
//
//        JButton ptEnMCliMRestFOrdRestsButton = new JButton("PT/EN");
//        JButton voltarMCliMRestsFOrdRestButton = new JButton("MENU CLIENTE");
//
//        mCliMRestFOrdRestsSuperPanel.add(norteMCliMRestFOrdRestsSubPanel, "North");
//        mCliMRestFOrdRestsSuperPanel.add(centroMCliMRestFOrdRestsSubPanel, "Center");
//        mCliMRestFOrdRestsSuperPanel.add(sulMCliMRestFOrdRestsSubPanel, "South");
//
//        JPanel norteMCliMRestFOrdRestsSSPanel = new JPanel();
//        norteMCliMRestFOrdRestsSSPanel.setLayout(new FlowLayout());
//        norteMCliMRestFOrdRestsSSPanel.add(mCliMRestFOrdRestsLabel);
//        norteMCliMRestFOrdRestsSubPanel.add(norteMCliMRestFOrdRestsSSPanel, BorderLayout.CENTER);
//        norteMCliMRestFOrdRestsSubPanel.add(ptEnMCliMRestFOrdRestsButton, BorderLayout.EAST);
//
//        JPanel centroMCliMRestFOrdRestsSSPanel = new JPanel();
//        centroMCliMRestFOrdRestsSSPanel.setLayout(new GridLayout(8, 1));
//        centroMCliMRestFOrdRestsSubPanel.add(centroMCliMRestFOrdRestsSSPanel);
//
//        centroMCliMRestFOrdRestsSSPanel.add(fMCliMRestFOrdRestsLabel);
//        centroMCliMRestFOrdRestsSSPanel.add(fhoraFMCliMRestFOrdRestsButton);
//        centroMCliMRestFOrdRestsSSPanel.add(fLotMCliMRestFOrdRestsButton);
//        centroMCliMRestFOrdRestsSSPanel.add(fCidCliMRestFOrdRestsButton);
//        centroMCliMRestFOrdRestsSSPanel.add(fOrdMCliMRestsFOrdRestLabel);
//        centroMCliMRestFOrdRestsSSPanel.add(fOrdPontCliMRestFOrdRestsButton);
//        centroMCliMRestFOrdRestsSSPanel.add(fOrdValoresMCliMRestFOrdRestsButton);
//
//        sulMCliMRestFOrdRestsSubPanel.setLayout(new FlowLayout());
//        sulMCliMRestFOrdRestsSubPanel.add(voltarMCliMRestsFOrdRestButton);
//
//        fhoraFMCliMRestFOrdRestsButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFRESTHFUNC_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        fLotMCliMRestFOrdRestsButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFRESTLOT_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        fCidCliMRestFOrdRestsButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFRESTCID_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        fOrdPontCliMRestFOrdRestsButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFRESTPONT_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        fOrdValoresMCliMRestFOrdRestsButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTVALOR_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliMRestsFOrdRestButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//    }
//
//    //////MENU RESTAURANTE – RESTAURANTES – FILTRAR POR PONTUAÇÃO//////////
//    private void construirPanelMCliMRestFRestPont(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMRestFRestPontSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMRestFRestPontSubPanel = new JPanel();
//        norteMCliMRestFRestPontSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMRestFRestPontSubPanel = new JPanel();
//        JPanel sulMCliMRestFRestPontSubPanel = new JPanel();
//
//        JLabel mCliMRestsFRestPontLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
//        JLabel mCliMRestFRestPontLabel = new JLabel("PONTUAÇÃO");
//
//        JCheckBox umMCliMRestFRestPont = new JCheckBox("1 - Péssimo");
//        umMCliMRestFRestPont.setMnemonic(KeyEvent.VK_C);
//        JCheckBox doisMCliMRestFRestPont = new JCheckBox("2 - Ruim");
//        doisMCliMRestFRestPont.setMnemonic(KeyEvent.VK_C);
//        JCheckBox tresMCliMRestFRestPont = new JCheckBox("3 - Regular");
//        tresMCliMRestFRestPont.setMnemonic(KeyEvent.VK_C);
//        JCheckBox quatroMCliMRestFRestPont = new JCheckBox("4 - Bom");
//        quatroMCliMRestFRestPont.setMnemonic(KeyEvent.VK_C);
//        JCheckBox cincoMCliMRestFRestPont = new JCheckBox("5 - Muito Bom");
//        cincoMCliMRestFRestPont.setMnemonic(KeyEvent.VK_C);
//
//        JButton ptEnMCliMRestFRestPontButton = new JButton("PT/EN");
//        JButton voltarMCliMRestFRestPontButton = new JButton("MENU CLIENTE");
//        JButton retonarMCliMRestFRestPontButton = new JButton("VOLTAR");
//
//        mCliMRestFRestPontSuperPanel.add(norteMCliMRestFRestPontSubPanel, "North");
//        mCliMRestFRestPontSuperPanel.add(centroMCliMRestFRestPontSubPanel, "Center");
//        mCliMRestFRestPontSuperPanel.add(sulMCliMRestFRestPontSubPanel, "South");
//
//        JPanel norteMCliMRestFRestPontSSPanel = new JPanel();
//        norteMCliMRestFRestPontSSPanel.setLayout(new FlowLayout());
//        norteMCliMRestFRestPontSSPanel.add(mCliMRestsFRestPontLabel);
//        norteMCliMRestFRestPontSubPanel.add(norteMCliMRestFRestPontSSPanel, BorderLayout.CENTER);
//        norteMCliMRestFRestPontSubPanel.add(ptEnMCliMRestFRestPontButton, BorderLayout.EAST);
//
//        JPanel centroMCliMRestFRestPontSSPanel = new JPanel();
//        centroMCliMRestFRestPontSSPanel.setLayout(new GridLayout(6, 1));
//        centroMCliMRestFRestPontSubPanel.add(centroMCliMRestFRestPontSSPanel);
//
//        centroMCliMRestFRestPontSSPanel.add(mCliMRestFRestPontLabel);
//        centroMCliMRestFRestPontSSPanel.add(umMCliMRestFRestPont);
//        centroMCliMRestFRestPontSSPanel.add(doisMCliMRestFRestPont);
//        centroMCliMRestFRestPontSSPanel.add(tresMCliMRestFRestPont);
//        centroMCliMRestFRestPontSSPanel.add(quatroMCliMRestFRestPont);
//        centroMCliMRestFRestPontSSPanel.add(cincoMCliMRestFRestPont);
//
//        sulMCliMRestFRestPontSubPanel.setLayout(new FlowLayout());
//        sulMCliMRestFRestPontSubPanel.add(voltarMCliMRestFRestPontButton);
//        sulMCliMRestFRestPontSubPanel.add(retonarMCliMRestFRestPontButton);
//
//        umMCliMRestFRestPont.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        doisMCliMRestFRestPont.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        tresMCliMRestFRestPont.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        quatroMCliMRestFRestPont.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        cincoMCliMRestFRestPont.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        retonarMCliMRestFRestPontButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliMRestFRestPontButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//    }
//
//    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTROS – VALORES MÉDIOS DOS PRATOS//////////
//    private void construirPanelMCliMRestFOrdRestValor(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMRestFOrdRestValorSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMRestFOrdRestValorSubPanel = new JPanel();
//        norteMCliMRestFOrdRestValorSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMRestFOrdRestValorSubPanel = new JPanel();
//        JPanel sulMCliMRestFOrdRestValorSubPanel = new JPanel();
//
//        JLabel mCliMRestFOrdRestsValorLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
//        JLabel mCliMRestFOrdRestValorLabel = new JLabel("VALORES MÉDIOS DOS PRATOS");
//
//        JRadioButton fOrdValoresCartaMCliMRestFOrdRestValorRButton = new JRadioButton("CARTA");
//        JRadioButton fOrdValoresPDiaMCliMRestFOrdRestValorRButton = new JRadioButton("PRATOS DO DIA");
//
//        ButtonGroup group = new ButtonGroup();
//        group.add(fOrdValoresCartaMCliMRestFOrdRestValorRButton);
//        group.add(fOrdValoresPDiaMCliMRestFOrdRestValorRButton);
//
//        JButton ptEnMCliMRestFOrdRestValorButton = new JButton("PT/EN");
//        JButton voltarMCliMRestFOrdRestValorutton = new JButton("MENU CLIENTE");
//        JButton retornarMCliMRestFOrdRestValorButton = new JButton("VOLTAR");
//
//        mCliMRestFOrdRestValorSuperPanel.add(norteMCliMRestFOrdRestValorSubPanel, "North");
//        mCliMRestFOrdRestValorSuperPanel.add(centroMCliMRestFOrdRestValorSubPanel, "Center");
//        mCliMRestFOrdRestValorSuperPanel.add(sulMCliMRestFOrdRestValorSubPanel, "South");
//
//        JPanel norteMCliMRestFOrdRestValorSSPanel = new JPanel();
//        norteMCliMRestFOrdRestValorSSPanel.setLayout(new FlowLayout());
//        norteMCliMRestFOrdRestValorSSPanel.add(mCliMRestFOrdRestsValorLabel);
//        norteMCliMRestFOrdRestValorSubPanel.add(norteMCliMRestFOrdRestValorSSPanel, BorderLayout.CENTER);
//        norteMCliMRestFOrdRestValorSubPanel.add(ptEnMCliMRestFOrdRestValorButton, BorderLayout.EAST);
//
//        JPanel centroMCliMRestFOrdRestValorSSPanel = new JPanel();
//        centroMCliMRestFOrdRestValorSSPanel.setLayout(new GridLayout(3, 1));
//        centroMCliMRestFOrdRestValorSubPanel.add(centroMCliMRestFOrdRestValorSSPanel);
//
//        JPanel centroMCliMRestFOrdRestValorSSPanel1 = new JPanel();
//        centroMCliMRestFOrdRestValorSSPanel1.setLayout(new GridBagLayout());
//        centroMCliMRestFOrdRestValorSubPanel.add(centroMCliMRestFOrdRestValorSSPanel1);
//
//        centroMCliMRestFOrdRestValorSSPanel.add(mCliMRestFOrdRestValorLabel);
//        centroMCliMRestFOrdRestValorSSPanel.add(fOrdValoresCartaMCliMRestFOrdRestValorRButton);
//        centroMCliMRestFOrdRestValorSSPanel.add(fOrdValoresPDiaMCliMRestFOrdRestValorRButton);
//
//        sulMCliMRestFOrdRestValorSubPanel.setLayout(new FlowLayout());
//        sulMCliMRestFOrdRestValorSubPanel.add(voltarMCliMRestFOrdRestValorutton);
//        sulMCliMRestFOrdRestValorSubPanel.add(retornarMCliMRestFOrdRestValorButton);
//
//
//        fOrdValoresCartaMCliMRestFOrdRestValorRButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTVALORCARTA_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//        fOrdValoresPDiaMCliMRestFOrdRestValorRButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTVALORPDIA_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//        retornarMCliMRestFOrdRestValorButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//        voltarMCliMRestFOrdRestValorutton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//    }
//
//
//    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTRAR POR VALORES MÉDIOS DOS PRATOS - CARTA//////////
//    private void construirPanelMCliMRestFOrdRestValorCarta(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMRestFOrdRestValorCartaSuperPanel) {
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMRestFOrdRestValorCartaSubPanel = new JPanel();
//        norteMCliMRestFOrdRestValorCartaSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMRestFOrdRestValorCartaSubPanel = new JPanel();
//        JPanel sulMCliMRestFOrdRestValorCartaSubPanel = new JPanel();
//
//        JLabel mCliMRestFOrdRestsValorCartaLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
//        JLabel mCliMRestFOrdRestValorCartaLabel = new JLabel("VALORES MÉDIOS DOS PRATOS - CARTA");
//        JCheckBox dezMCliMRestFOrdRestValorCartaCBox = new JCheckBox(">10€");
//        dezMCliMRestFOrdRestValorCartaCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox dezVinteMCliMRestFOrdRestValorCartaCBox = new JCheckBox("10€-20€");
//        dezVinteMCliMRestFOrdRestValorCartaCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox vinteTrintaMCliMRestFOrdRestValorCartaCBox = new JCheckBox("20€-30€");
//        vinteTrintaMCliMRestFOrdRestValorCartaCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox trintaQuarentaMCliMRestFOrdRestValorCartaCBox = new JCheckBox("30€-40€");
//        trintaQuarentaMCliMRestFOrdRestValorCartaCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox quarentaMaisMCliMRestFOrdRestValorCartaCBox = new JCheckBox("<40€");
//        quarentaMaisMCliMRestFOrdRestValorCartaCBox.setMnemonic(KeyEvent.VK_C);
//
//        JButton ptEnMCliMRestFOrdRestValorCartaButton = new JButton("PT/EN");
//        JButton voltarMCliMRestFOrdRestValorCartaButton = new JButton("MENU CLIENTE");
//        JButton retornarMCliMRestFOrdRestValorCartaButton = new JButton("VOLTAR");
//
//
//        mCliMRestFOrdRestValorCartaSuperPanel.add(norteMCliMRestFOrdRestValorCartaSubPanel, "North");
//        mCliMRestFOrdRestValorCartaSuperPanel.add(centroMCliMRestFOrdRestValorCartaSubPanel, "Center");
//        mCliMRestFOrdRestValorCartaSuperPanel.add(sulMCliMRestFOrdRestValorCartaSubPanel, "South");
//
//        JPanel norteMCliMRestFOrdRestValorCartaSSPanel = new JPanel();
//        norteMCliMRestFOrdRestValorCartaSSPanel.setLayout(new FlowLayout());
//        norteMCliMRestFOrdRestValorCartaSSPanel.add(mCliMRestFOrdRestsValorCartaLabel);
//        norteMCliMRestFOrdRestValorCartaSubPanel.add(norteMCliMRestFOrdRestValorCartaSSPanel, BorderLayout.CENTER);
//        norteMCliMRestFOrdRestValorCartaSubPanel.add(ptEnMCliMRestFOrdRestValorCartaButton, BorderLayout.EAST);
//
//        JPanel centroMCliMRestFOrdRestValorCartaSSPanel = new JPanel();
//        centroMCliMRestFOrdRestValorCartaSSPanel.setLayout(new GridLayout(1, 2));
//        centroMCliMRestFOrdRestValorCartaSubPanel.add(centroMCliMRestFOrdRestValorCartaSSPanel);
//
//        JPanel centroMCliMRestFOrdRestValorCartaSSPanel1 = new JPanel();
//        centroMCliMRestFOrdRestValorCartaSSPanel1.setLayout(new GridBagLayout());
//        centroMCliMRestFOrdRestValorCartaSubPanel.add(centroMCliMRestFOrdRestValorCartaSSPanel1);
//
//        centroMCliMRestFOrdRestValorCartaSSPanel.add(mCliMRestFOrdRestValorCartaLabel);
//        centroMCliMRestFOrdRestValorCartaSSPanel1.add(dezMCliMRestFOrdRestValorCartaCBox);
//        centroMCliMRestFOrdRestValorCartaSSPanel1.add(dezVinteMCliMRestFOrdRestValorCartaCBox);
//        centroMCliMRestFOrdRestValorCartaSSPanel1.add(vinteTrintaMCliMRestFOrdRestValorCartaCBox);
//        centroMCliMRestFOrdRestValorCartaSSPanel1.add(trintaQuarentaMCliMRestFOrdRestValorCartaCBox);
//        centroMCliMRestFOrdRestValorCartaSSPanel1.add(quarentaMaisMCliMRestFOrdRestValorCartaCBox);
//
//        sulMCliMRestFOrdRestValorCartaSubPanel.setLayout(new FlowLayout());
//        sulMCliMRestFOrdRestValorCartaSubPanel.add(voltarMCliMRestFOrdRestValorCartaButton);
//        sulMCliMRestFOrdRestValorCartaSubPanel.add(retornarMCliMRestFOrdRestValorCartaButton);
//
//        dezMCliMRestFOrdRestValorCartaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        dezVinteMCliMRestFOrdRestValorCartaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        vinteTrintaMCliMRestFOrdRestValorCartaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        trintaQuarentaMCliMRestFOrdRestValorCartaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        quarentaMaisMCliMRestFOrdRestValorCartaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        retornarMCliMRestFOrdRestValorCartaButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliMRestFOrdRestValorCartaButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//    }
//
//    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTRAR POR VALORES MÉDIOS DOS PRATOS – PRATO DO DIA//////////
//    private void construirPanelMCliMRestFOrdRestValorPDia(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMRestFOrdRestValorPDiaSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMRestFOrdRestValorPDiaSubPanel = new JPanel();
//        norteMCliMRestFOrdRestValorPDiaSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMRestFOrdRestValorPDiaSubPanel = new JPanel();
//        JPanel sulMCliMRestFOrdRestValorPDiaSubPanel = new JPanel();
//        JLabel mCliMRestFOrdRestsValorPDiaLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
//        JLabel mCliMRestFOrdRestValorMedPDiaLabel = new JLabel("VALORES MÉDIOS DOS PRATOS – PRATO DO DIA");
//
//        JCheckBox dezMCliMRestFOrdRestValorPDiaCBox = new JCheckBox(">10€");
//        dezMCliMRestFOrdRestValorPDiaCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox dezVinteMCliMRestFOrdRestValorPDiaCBox = new JCheckBox("10€-20€");
//        dezVinteMCliMRestFOrdRestValorPDiaCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox vinteTrintaMCliMRestFOrdRestValorPDiaCBox = new JCheckBox("20€-30€");
//        vinteTrintaMCliMRestFOrdRestValorPDiaCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox trintaQuarentaMCliMRestFOrdRestValorPDiaCBox = new JCheckBox("30€-40€");
//        trintaQuarentaMCliMRestFOrdRestValorPDiaCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox quarentaMaisMCliMRestFOrdRestValorPDiaCBox = new JCheckBox("<40€");
//        quarentaMaisMCliMRestFOrdRestValorPDiaCBox.setMnemonic(KeyEvent.VK_C);
//
//        JButton ptEnMCliMRestFOrdRestValorPDiaButton = new JButton("PT/EN");
//        JButton voltarMCliMRestFOrdRestValorPDiaButton = new JButton("MENU CLIENTE");
//        JButton retornarMCliMRestFOrdRestValorPDiaButton = new JButton("VOLTAR");
//
//        mCliMRestFOrdRestValorPDiaSuperPanel.add(norteMCliMRestFOrdRestValorPDiaSubPanel, "North");
//        mCliMRestFOrdRestValorPDiaSuperPanel.add(centroMCliMRestFOrdRestValorPDiaSubPanel, "Center");
//        mCliMRestFOrdRestValorPDiaSuperPanel.add(sulMCliMRestFOrdRestValorPDiaSubPanel, "South");
//
//        JPanel norteMCliMRestFOrdRestValorPDiaSSPanel = new JPanel();
//        norteMCliMRestFOrdRestValorPDiaSSPanel.setLayout(new FlowLayout());
//        norteMCliMRestFOrdRestValorPDiaSSPanel.add(mCliMRestFOrdRestsValorPDiaLabel);
//        norteMCliMRestFOrdRestValorPDiaSubPanel.add(norteMCliMRestFOrdRestValorPDiaSSPanel, BorderLayout.CENTER);
//        norteMCliMRestFOrdRestValorPDiaSubPanel.add(ptEnMCliMRestFOrdRestValorPDiaButton, BorderLayout.EAST);
//
//        JPanel centroMCliMRestFOrdRestValorPDiaSSPanel = new JPanel();
//        centroMCliMRestFOrdRestValorPDiaSSPanel.setLayout(new GridLayout(1, 2));
//        centroMCliMRestFOrdRestValorPDiaSubPanel.add(centroMCliMRestFOrdRestValorPDiaSSPanel);
//
//        JPanel centroMCliMRestFOrdRestValorPDiaSSPanel1 = new JPanel();
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.setLayout(new GridBagLayout());
//        centroMCliMRestFOrdRestValorPDiaSubPanel.add(centroMCliMRestFOrdRestValorPDiaSSPanel1);
//
//        centroMCliMRestFOrdRestValorPDiaSSPanel.add(mCliMRestFOrdRestValorMedPDiaLabel);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(dezMCliMRestFOrdRestValorPDiaCBox);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(dezVinteMCliMRestFOrdRestValorPDiaCBox);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(vinteTrintaMCliMRestFOrdRestValorPDiaCBox);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(trintaQuarentaMCliMRestFOrdRestValorPDiaCBox);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(quarentaMaisMCliMRestFOrdRestValorPDiaCBox);
//
//        sulMCliMRestFOrdRestValorPDiaSubPanel.setLayout(new FlowLayout());
//        sulMCliMRestFOrdRestValorPDiaSubPanel.add(voltarMCliMRestFOrdRestValorPDiaButton);
//        sulMCliMRestFOrdRestValorPDiaSubPanel.add(retornarMCliMRestFOrdRestValorPDiaButton);
//
//        dezMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        dezVinteMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        vinteTrintaMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        trintaQuarentaMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        quarentaMaisMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        retornarMCliMRestFOrdRestValorPDiaButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//        voltarMCliMRestFOrdRestValorPDiaButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//    }
//
//    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTROS – HORÁRIO DE FUNCIONAMENTO//////////
//    private void construirPanelMCliMRestFRestHFunc(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMRestFRestHFuncSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMRestFRestHFuncSubPanel = new JPanel();
//        norteMCliMRestFRestHFuncSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMRestFRestHFuncSubPanel = new JPanel();
//        JPanel sulMCliMRestFRestHFuncSubPanel = new JPanel();
//
//        JLabel mCliMRestsFRestsHFuncLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
//        JLabel mCliMRestFRestHFuncLabel = new JLabel("HORÁRIOS DE FUNCIONAMENTO");
//
//        JLabel fHoraMCliMRestFRestHFuncLabel = new JLabel("HORA");
//        JLabel fDataMCliMRestFRestHFuncLabel = new JLabel("DATA");
//
////Calendário
//        UtilDateModel modelMCliMRestFRestHFun = new UtilDateModel();
//
//        ResourceBundle b = ResourceBundle.getBundle("Text");
//
//        Properties p = convertResourceBundleToProperties(b);
//        JDatePanelImpl datePanelMCliMRestFRestHFun = new JDatePanelImpl(modelMCliMRestFRestHFun, p);
//        JDatePickerImpl datePickerMCliMRestFRestHFun = new JDatePickerImpl(datePanelMCliMRestFRestHFun, new DateLabelFormatter());
//
////TODO ver melhor forma de apresentar para conseguir selecionar
//        String[] fHoraMCliMRestFRestHFun = {"", "11h", "11h30", "12h", "12h30", "13h", "13h30", "14h", "14h30", "15h", "15h30", "19h", "19h30", "20h", "20h30", "21h", "21h30", "22h", "22h30"};
//        JComboBox arrayfHoraFMCliMRestFRestHFuncJCBox = new JComboBox(fHoraMCliMRestFRestHFun);
//
//        JButton ptEnMCliMRestFRestHFuncButton = new JButton("PT/EN");
//        JButton voltarMCliMRestFRestHFuncButton = new JButton("MENU CLIENTE");
//        JButton retornarMCliMRestFRestHFuncButton = new JButton("VOLTAR");
//
//
//        mCliMRestFRestHFuncSuperPanel.add(norteMCliMRestFRestHFuncSubPanel, "North");
//        mCliMRestFRestHFuncSuperPanel.add(centroMCliMRestFRestHFuncSubPanel, "Center");
//        mCliMRestFRestHFuncSuperPanel.add(sulMCliMRestFRestHFuncSubPanel, "South");
//
//        JPanel norteMCliMRestFRestHFuncSSPanel = new JPanel();
//        norteMCliMRestFRestHFuncSSPanel.setLayout(new FlowLayout());
//        norteMCliMRestFRestHFuncSSPanel.add(mCliMRestsFRestsHFuncLabel);
//        norteMCliMRestFRestHFuncSubPanel.add(norteMCliMRestFRestHFuncSSPanel, BorderLayout.CENTER);
//        norteMCliMRestFRestHFuncSubPanel.add(ptEnMCliMRestFRestHFuncButton, BorderLayout.EAST);
//
//        JPanel centroMCliMRestFRestHFuncSSPanel = new JPanel();
//        centroMCliMRestFRestHFuncSSPanel.setLayout(new FlowLayout());
//        centroMCliMRestFRestHFuncSubPanel.add(centroMCliMRestFRestHFuncSSPanel);
//
//        JPanel centroMCliMRestFRestHFuncSSPanel1 = new JPanel();
//        centroMCliMRestFRestHFuncSSPanel1.setLayout(new FlowLayout());
//        centroMCliMRestFRestHFuncSubPanel.add(centroMCliMRestFRestHFuncSSPanel1);
//
//        JPanel centroMCliMRestFRestHFuncSSPanel2 = new JPanel();
//        centroMCliMRestFRestHFuncSSPanel2.setLayout(new FlowLayout());
//        centroMCliMRestFRestHFuncSubPanel.add(centroMCliMRestFRestHFuncSSPanel2);
//
//        JPanel centroMCliMRestFRestHFuncSSPanel3 = new JPanel();
//        centroMCliMRestFRestHFuncSSPanel3.setLayout(new FlowLayout());
//        centroMCliMRestFRestHFuncSubPanel.add(centroMCliMRestFRestHFuncSSPanel3);
//
//        centroMCliMRestFRestHFuncSSPanel.add(mCliMRestFRestHFuncLabel);
//        centroMCliMRestFRestHFuncSSPanel1.add(fDataMCliMRestFRestHFuncLabel);
//        centroMCliMRestFRestHFuncSSPanel1.add(datePickerMCliMRestFRestHFun);
//        centroMCliMRestFRestHFuncSSPanel2.add(fHoraMCliMRestFRestHFuncLabel);
//        centroMCliMRestFRestHFuncSSPanel2.add(arrayfHoraFMCliMRestFRestHFuncJCBox);
//
//        sulMCliMRestFRestHFuncSubPanel.setLayout(new FlowLayout());
//        sulMCliMRestFRestHFuncSubPanel.add(voltarMCliMRestFRestHFuncButton);
//        sulMCliMRestFRestHFuncSubPanel.add(retornarMCliMRestFRestHFuncButton);
//
//        //todo faltar ver botões
//        retornarMCliMRestFRestHFuncButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliMRestFRestHFuncButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//    }
//
//    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTROS - LOTAÇÃO//////////
//    private void construirPanelMCliMRestFRestLot(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMRestFRestLotSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMRestFRestLotSubPanel = new JPanel();
//        norteMCliMRestFRestLotSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMRestFRestLotSubPanel = new JPanel();
//        JPanel sulMCliMRestFRestLotSubPanel = new JPanel();
//
//        JLabel mCliMRestsFRestsLotLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
//        JLabel mCliMRestFRestLotLabel = new JLabel("LOTAÇÃO");
//        JLabel dataMCliMRestFRestLotLabel = new JLabel("DATA");
//
//        //todo exemplo a verificar (HÁ FORMA MELHOR?)
//        String[] nomeColunasMCliMRestFRestLot = new String[]{
//                "RESTAURANTE”, “ZONA", "TOTAL", "DISPONÍVEIS"
//        };
//
//        Object[][] dadosMCliMRestFRestLot = new Object[][]{
//                {"RESTAURANTE”, “ZONA", "TOTAL", "DISPONÍVEIS"},
//                {"A", "Esplanada", 20, 5},
//                {"B", "Interior Ñ Fumadores", 20, 10},
//                {"C", "Interior Fumadores", 5, 2},
//        };
//
//        //criação da tabela
//        JTable tabelaMCliMRestFRestLot = new JTable(dadosMCliMRestFRestLot, nomeColunasMCliMRestFRestLot);
//
//
////Calendário
//        UtilDateModel modelMCliMRestFRestLot = new UtilDateModel();
//
//        ResourceBundle b = ResourceBundle.getBundle("Text");
//
//        Properties p = convertResourceBundleToProperties(b);
//        JDatePanelImpl datePanelMCliMRestFRestLot = new JDatePanelImpl(modelMCliMRestFRestLot, p);
//        JDatePickerImpl datePickerMCliMRestFRestLot = new JDatePickerImpl(datePanelMCliMRestFRestLot, new DateLabelFormatter());
//
//        //todo verificar porque não deu certo
//        JComboBox fLotCliMRestFRestLotJCBox = new JComboBox();
//        for (int i = 1; i <= 50; i++) {
//            fLotCliMRestFRestLotJCBox.addItem(i);
//        }
//
//        JButton ptEnMCliMRestFRestLotButton = new JButton("PT/EN");
//        JButton voltarMCliMRestFRestLotButton = new JButton("MENU CLIENTE");
//        JButton retornarMCliMRestFRestLotButton = new JButton("VOLTAR");
//
//        mCliMRestFRestLotSuperPanel.add(norteMCliMRestFRestLotSubPanel, "North");
//        mCliMRestFRestLotSuperPanel.add(centroMCliMRestFRestLotSubPanel, "Center");
//        mCliMRestFRestLotSuperPanel.add(sulMCliMRestFRestLotSubPanel, "South");
//
//        JPanel norteMCliMRestFRestLotSSPanel = new JPanel();
//        norteMCliMRestFRestLotSSPanel.setLayout(new FlowLayout());
//        norteMCliMRestFRestLotSSPanel.add(mCliMRestsFRestsLotLabel);
//        norteMCliMRestFRestLotSubPanel.add(norteMCliMRestFRestLotSSPanel, BorderLayout.CENTER);
//        norteMCliMRestFRestLotSubPanel.add(ptEnMCliMRestFRestLotButton, BorderLayout.EAST);
//
//        JPanel centroMCliMRestFRestLotSSPanel = new JPanel();
//        centroMCliMRestFRestLotSSPanel.setLayout(new GridLayout(4, 2));
//        centroMCliMRestFRestLotSubPanel.add(centroMCliMRestFRestLotSSPanel);
//
//        JPanel centroMCliMRestFRestLotSSPanel1 = new JPanel();
//        centroMCliMRestFRestLotSSPanel1.setLayout(new GridBagLayout());
//        centroMCliMRestFRestLotSubPanel.add(centroMCliMRestFRestLotSSPanel1);
//
//        JPanel centroMCliMRestFRestLotSSPanel2 = new JPanel();
//        centroMCliMRestFRestLotSSPanel2.setLayout(new GridBagLayout());
//        centroMCliMRestFRestLotSubPanel.add(centroMCliMRestFRestLotSSPanel2);
//
//        centroMCliMRestFRestLotSSPanel.add(mCliMRestFRestLotLabel);
//        centroMCliMRestFRestLotSSPanel1.add(dataMCliMRestFRestLotLabel);
//        centroMCliMRestFRestLotSSPanel1.add(datePickerMCliMRestFRestLot);
//        centroMCliMRestFRestLotSSPanel2.add(tabelaMCliMRestFRestLot);
//
//        sulMCliMRestFRestLotSubPanel.setLayout(new FlowLayout());
//        sulMCliMRestFRestLotSubPanel.add(voltarMCliMRestFRestLotButton);
//        sulMCliMRestFRestLotSubPanel.add(retornarMCliMRestFRestLotButton);
//
//        retornarMCliMRestFRestLotButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliMRestFRestLotButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//    }
//
//    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTROS - CIDADE//////////
//    private void construirPanelMCliMRestFRestCid(Interface janela, Container contentor, JPanel loginSuperPanel, JPanel mCliMRestFRestCidSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliMRestFRestCidSubPanel = new JPanel();
//        norteMCliMRestFRestCidSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliMRestFRestCidSubPanel = new JPanel();
//        JPanel sulMCliMRestFRestCidSubPanel = new JPanel();
//
//        JLabel mCliMRestsFRestsCidLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
//        JLabel mCliMRestFRestCidLabel = new JLabel("CIDADE");
//
//        JCheckBox coimbraMCliMRestFOrdRestJCBox = new JCheckBox("Coimbra");
//        coimbraMCliMRestFOrdRestJCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox portoMCliMRestFOrdRestJCBox = new JCheckBox("Porto");
//        portoMCliMRestFOrdRestJCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox lisboaMCliMRestFOrdRestJCBox = new JCheckBox("Lisboa");
//        lisboaMCliMRestFOrdRestJCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox guimaraesMCliMRestFOrdRestJCBox = new JCheckBox("Guimarães");
//        guimaraesMCliMRestFOrdRestJCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox bragaMCliMRestFOrdRestJCBox = new JCheckBox("Braga");
//        bragaMCliMRestFOrdRestJCBox.setMnemonic(KeyEvent.VK_C);
//        JCheckBox vilaDoCondeMCliMRestFOrdRestJCBox = new JCheckBox("Vila do Conde");
//        vilaDoCondeMCliMRestFOrdRestJCBox.setMnemonic(KeyEvent.VK_C);
//
//        JButton ptEnMCliMRestFRestCidButton = new JButton("PT/EN");
//        JButton voltarMCliMRestFRestCidButton = new JButton("MENU CLIENTE");
//        JButton retornarMCliMRestFRestCidButton = new JButton("VOLTAR");
//
//        mCliMRestFRestCidSuperPanel.add(norteMCliMRestFRestCidSubPanel, "North");
//        mCliMRestFRestCidSuperPanel.add(centroMCliMRestFRestCidSubPanel, "Center");
//        mCliMRestFRestCidSuperPanel.add(sulMCliMRestFRestCidSubPanel, "South");
//
//        JPanel norteMCliMRestFRestCidSSPanel = new JPanel();
//        norteMCliMRestFRestCidSSPanel.setLayout(new FlowLayout());
//        norteMCliMRestFRestCidSSPanel.add(mCliMRestsFRestsCidLabel);
//        norteMCliMRestFRestCidSubPanel.add(norteMCliMRestFRestCidSSPanel, BorderLayout.CENTER);
//        norteMCliMRestFRestCidSubPanel.add(ptEnMCliMRestFRestCidButton, BorderLayout.EAST);
//
//        JPanel centroMCliMRestFRestCidSSPanel = new JPanel();
//        centroMCliMRestFRestCidSSPanel.setLayout(new GridLayout(8, 2));
//        centroMCliMRestFRestCidSubPanel.add(centroMCliMRestFRestCidSSPanel);
//
//        centroMCliMRestFRestCidSSPanel.add(mCliMRestFRestCidLabel);
//        centroMCliMRestFRestCidSSPanel.add(coimbraMCliMRestFOrdRestJCBox);
//        centroMCliMRestFRestCidSSPanel.add(portoMCliMRestFOrdRestJCBox);
//        centroMCliMRestFRestCidSSPanel.add(lisboaMCliMRestFOrdRestJCBox);
//        centroMCliMRestFRestCidSSPanel.add(bragaMCliMRestFOrdRestJCBox);
//        centroMCliMRestFRestCidSSPanel.add(guimaraesMCliMRestFOrdRestJCBox);
//        centroMCliMRestFRestCidSSPanel.add(vilaDoCondeMCliMRestFOrdRestJCBox);
//
//        sulMCliMRestFRestCidSubPanel.setLayout(new FlowLayout());
//        sulMCliMRestFRestCidSubPanel.add(voltarMCliMRestFRestCidButton);
//        sulMCliMRestFRestCidSubPanel.add(retornarMCliMRestFRestCidButton);
//
//        coimbraMCliMRestFOrdRestJCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        portoMCliMRestFOrdRestJCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        lisboaMCliMRestFOrdRestJCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//        bragaMCliMRestFOrdRestJCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//        guimaraesMCliMRestFOrdRestJCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//        vilaDoCondeMCliMRestFOrdRestJCBox.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        retornarMCliMRestFRestCidButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIMRESTFORDRESTS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//        voltarMCliMRestFRestCidButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//    }
//
//
//    //todo ver como criar o apagar e editar comentário na seleção da tabela e ver a questão do OK
//    //////MENU CLIENTE – CONSULTAR COMENTÁRIOS MENU//////////
//
//    private void construirPanelMCliComentarios(Interface janela, Container contentor, JPanel
//            loginSuperPanel, JPanel mCliComSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliComSubPanel = new JPanel();
//        norteMCliComSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliComSubPanel = new JPanel();
//        JPanel sulMCliComSubPanel = new JPanel();
//
//        JLabel mCliFilComLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS:");
//
//        JLabel mCliFComLabel = new JLabel("PRÓPRIOS");
//        JLabel mCliFComCliLabel = new JLabel("CLIENTE");
//        JLabel mCliFComRestLabel = new JLabel("RESTAURANTE");
//        JLabel mCliFComDatasLabel = new JLabel("INTERVALO DATAS");
//        JLabel mCliFComDataILabel = new JLabel("De");
//        JLabel mCliFComDataFLabel = new JLabel("Até");
//
////todo faltou visualizar
//        String[] nomeColunasMCliCom = new String[]{
//                "ID", "DATA", "RESTAURNATE"
//        };
//
//        Object[][] data = new Object[][]{
//                {"ID", "DATA", "RESTAURANTE"},
//                {1, "dd/MM/yyy", "A"},
//                {2, "dd/MM/yyy", "B"},
//                {3, "dd/MM/yyy", "C"},
//        };
//        //criação da tabela
//        JTable tabelaMCliFCom = new JTable(data, nomeColunasMCliCom);
//
//        //JPopupMenu popupMenu = new JPopupMenu();
//        //JMenuItem menuItemAdd = new JMenuItem("Responder");
//
//        JTextField mCliFComCliText = new JTextField(17);
//        JTextField mCliFComRestText = new JTextField(17);
//
////Adição do calendário
//        UtilDateModel model4 = new UtilDateModel();
//        UtilDateModel model5 = new UtilDateModel();
//
//        ResourceBundle b = ResourceBundle.getBundle("Text");
//
//        Properties p = convertResourceBundleToProperties(b);
//        JDatePanelImpl datePanel3 = new JDatePanelImpl(model4, p);
//        JDatePickerImpl datePicker4 = new JDatePickerImpl(datePanel3, new DateLabelFormatter());
//        JDatePanelImpl datePanel4 = new JDatePanelImpl(model5, p);
//        JDatePickerImpl datePicker5 = new JDatePickerImpl(datePanel4, new DateLabelFormatter());
//
//
//        JButton ptEnMCliRestButton = new JButton("PT/EN");
//        JButton voltarMCliComButton = new JButton("MENU CLIENTE");
//        JButton okMCliComButton = new JButton("OK");
//
//        mCliComSuperPanel.add(norteMCliComSubPanel, "North");
//        mCliComSuperPanel.add(centroMCliComSubPanel, "Center");
//        mCliComSuperPanel.add(sulMCliComSubPanel, "South");
//
//        JPanel norteMCliComSSPanel = new JPanel();
//        norteMCliComSSPanel.setLayout(new FlowLayout());
//        norteMCliComSSPanel.add(mCliFilComLabel);
//        norteMCliComSubPanel.add(norteMCliComSSPanel, BorderLayout.CENTER);
//        norteMCliComSubPanel.add(ptEnMCliRestButton, BorderLayout.EAST);
//
//        JPanel centroMCliComSSPanel = new JPanel();
//        centroMCliComSSPanel.setLayout(new FlowLayout());
//        centroMCliComSubPanel.add(centroMCliComSSPanel, BorderLayout.WEST);
//
//        JPanel centroMCliComSSPanel1 = new JPanel();
//        centroMCliComSSPanel1.setLayout(new FlowLayout());
//        centroMCliComSubPanel.add(centroMCliComSSPanel1, BorderLayout.WEST);
//
//        JPanel centroMCliComSSPanel2 = new JPanel();
//        centroMCliComSSPanel2.setLayout(new FlowLayout());
//        centroMCliComSubPanel.add(centroMCliComSSPanel2, BorderLayout.WEST);
//
//        JPanel centroMCliComSSPanel3 = new JPanel();
//        centroMCliComSSPanel3.setLayout(new FlowLayout());
//        centroMCliComSubPanel.add(centroMCliComSSPanel3, BorderLayout.WEST);
//
//        JPanel centroMCliComSSPanel4 = new JPanel();
//        centroMCliComSSPanel4.setLayout(new FlowLayout());
//        centroMCliComSubPanel.add(centroMCliComSSPanel4, BorderLayout.CENTER);
//
//        centroMCliComSSPanel.add(mCliFComLabel);
//        centroMCliComSSPanel.add(tabelaMCliFCom);
//
//        centroMCliComSSPanel1.add(mCliFComCliLabel);
//        centroMCliComSSPanel1.add(mCliFComCliText);
//
//        centroMCliComSSPanel1.add(mCliFComRestLabel);
//        centroMCliComSSPanel1.add(mCliFComRestText);
//
//        centroMCliComSSPanel2.add(mCliFComDatasLabel);
//        centroMCliComSSPanel3.add(mCliFComDataILabel);
//        centroMCliComSSPanel3.add(datePicker4);
//        centroMCliComSSPanel3.add(mCliFComDataFLabel);
//        centroMCliComSSPanel3.add(datePicker5);
//
//        sulMCliComSubPanel.setLayout(new FlowLayout());
//        sulMCliComSubPanel.add(voltarMCliComButton);
//        sulMCliComSubPanel.add(okMCliComButton);
//
//
//        voltarMCliComButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//        //todo ver os encaminhamentos para responder comentário
//        okMCliComButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(500, 180);
//        });
//
//    }
//
//
//    ////////////////////MENU CLIENTE - ACTUALIZAR DADOS /////////////////////////
//    private void construirPanelMCliAtDados(Interface janela, Container contentor, JPanel
//            loginSuperPanel, JPanel mCliAtDadosSuperPanel) {
//
//        passwordValido = false;
//        confirmarPasswordValido = false;
//
//        /////SUBPAINEIS//////
//        JPanel norteAtDadosMCliSubPanel = new JPanel();
//        norteAtDadosMCliSubPanel.setLayout(new BorderLayout());
//        JPanel centroAtDadosMCliSubPanel = new JPanel();
//        JPanel sulAtDadosMCliSubPanel = new JPanel();
//
//        JLabel atDadosMCliLabel = new JLabel("ACTUALIZAR DADOS");
//        atDadosMCliLabel.setForeground(Color.BLUE);
//        JLabel nomeCliMCliLabel = new JLabel("Nome");
//        //nomeCliMCliLabel.setBounds(50,80,100,20);
//        JLabel emailCliMCliLabel = new JLabel("E-mail");
//        JLabel moradaCliMCliLabel = new JLabel("Morada");
//        JLabel telemovelCliMCliLabel = new JLabel("Telemóvel");
//        JLabel usernameCliMCliLabel = new JLabel("Username");
//        JLabel passwordCliMCliLabel = new JLabel("Password");
//        JLabel confirmarPasswordCliMCliLabel = new JLabel("Confirmar password: ");
//
//        JTextField nomeCliMCliText = new JTextField(20);
//        nomeCliMCliText.setMargin(new Insets(3, 3, 3, 3));
//        JTextField emailCliMCliText = new JTextField(20);
//        JTextField moradaCliMCliText = new JTextField(20);
//        JTextField telemovelCliMCliText = new JFormattedTextField(mascaraTelemovel);
//        telemovelCliMCliText.setColumns(20);
//        JTextField usernameCliMCliText = new JTextField(20);
//
//        JPasswordField passwordCliMCliField = new JPasswordField(20);
//        passwordCliMCliField.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                passwordValido = true;
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (passwordCliMCliField.getPassword().length < 6) {
//                    passwordValido = false;
//                }
//
//            }
//        });
//        JPasswordField confirmarPassawordCliMCliField = new JPasswordField(20);
//        confirmarPassawordCliMCliField.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                confirmarPasswordValido = true;
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (!passwordCliMCliField.getPassword().equals(confirmarPassawordCliMCliField.getPassword())) {
//                    confirmarPasswordValido = false;
//                }
//
//            }
//        });
//        JButton ptEnAtDadosMCliButton = new JButton("PT/EN");
//        JButton voltarCliMCliButton = new JButton("MENU CLIENTE");
//        JButton actualizarCliMCliButton = new JButton("ACTUALIZAR");
//
//        mCliAtDadosSuperPanel.add(norteAtDadosMCliSubPanel, "North");
//        mCliAtDadosSuperPanel.add(centroAtDadosMCliSubPanel, "Center");
//        mCliAtDadosSuperPanel.add(sulAtDadosMCliSubPanel, "South");
//
//        JPanel norteAtDadosMCliSSPanel = new JPanel();
//        norteAtDadosMCliSSPanel.setLayout(new FlowLayout());
//        norteAtDadosMCliSSPanel.add(atDadosMCliLabel);
//        norteAtDadosMCliSubPanel.add(norteAtDadosMCliSSPanel, BorderLayout.CENTER);
//        norteAtDadosMCliSubPanel.add(ptEnAtDadosMCliButton, BorderLayout.EAST);
//
//        JPanel centroAtDadosMCliSSPanel = new JPanel();
//        centroAtDadosMCliSSPanel.setLayout(new GridLayout(7, 2));
//        centroAtDadosMCliSubPanel.add(centroAtDadosMCliSSPanel);
//        centroAtDadosMCliSSPanel.add(nomeCliMCliLabel);
//        centroAtDadosMCliSSPanel.add(nomeCliMCliText);
//        centroAtDadosMCliSSPanel.add(emailCliMCliLabel);
//        centroAtDadosMCliSSPanel.add(emailCliMCliText);
//        centroAtDadosMCliSSPanel.add(moradaCliMCliLabel);
//        centroAtDadosMCliSSPanel.add(moradaCliMCliText);
//        centroAtDadosMCliSSPanel.add(telemovelCliMCliLabel);
//        centroAtDadosMCliSSPanel.add(telemovelCliMCliText);
//        centroAtDadosMCliSSPanel.add(usernameCliMCliLabel);
//        centroAtDadosMCliSSPanel.add(usernameCliMCliText);
//        centroAtDadosMCliSSPanel.add(passwordCliMCliLabel);
//        centroAtDadosMCliSSPanel.add(passwordCliMCliField);
//        centroAtDadosMCliSSPanel.add(confirmarPasswordCliMCliLabel);
//        centroAtDadosMCliSSPanel.add(confirmarPassawordCliMCliField);
//
//        sulAtDadosMCliSubPanel.setLayout(new FlowLayout());
//        sulAtDadosMCliSubPanel.add(voltarCliMCliButton);
//        sulAtDadosMCliSubPanel.add(actualizarCliMCliButton);
//
//        actualizarCliMCliButton.addActionListener(a -> {
//            if (!passwordValido) {
//                JOptionPane.showMessageDialog(((Component) a.getSource()).getParent(), "Password Inválido: deve conter o mínimo de 6 caracteres!");
//                passwordCliMCliField.requestFocus();
//                return;
//            }
//            if (!confirmarPasswordValido) {
//                JOptionPane.showMessageDialog(((Component) a.getSource()).getParent(), "Password Inválido: deve ser igual password!");
//                confirmarPassawordCliMCliField.requestFocus();
//                return;
//            }
//            //TODO faz-se necessário atualizar  método atualizarDados Cliente, retirando o password e criar um novo metodo para atualização de password
//            sistema.atualizarDadosCliente(nomeCliMCliText.getText(),
//                    moradaCliMCliText.getText(),
//                    telemovelCliMCliText.getText(),
//                    emailCliMCliText.getText(),
//                    passwordCliMCliField.getPassword().toString(),
//                    confirmarPassawordCliMCliField.getPassword().toString(),
//                    confirmarPassawordCliMCliField.getPassword().toString());
//        });
//        voltarCliMCliButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//    }
//// todo verificar os botões editar e apagar que estão em conflito com visualizar
//
//    //////MENU CLIENTE – RESERVAS - ACTIVAS//////////
//
//    private void construirPanelMCliResAct(Interface janela, Container contentor, JPanel
//            loginSuperPanel, JPanel mCliResActSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliResActSubPanel = new JPanel();
//        norteMCliResActSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliResActSubPanel = new JPanel();
//        JPanel sulMCliResActSubPanel = new JPanel();
//
//        JLabel mCliTitHistResActLabel = new JLabel("MENU CLIENTE - RESERVAS ACTIVAS");
//        JLabel mCliIdHistResActLabel = new JLabel("ID");
//
//        String[] mCliIdHistResAct = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//        JComboBox arrayMCliIdHistResActCBox = new JComboBox(mCliIdHistResAct);
//
////todo faltou visualizar – aumentar tamanho da coluna e tornar possível seleção para visualizar, editar e cancelar
//        String[] nomeColunasMCliResAct = new String[]{
//                "ID", "DATA", "RESTAURNATE"
//        };
//
//        Object[][] dados = new Object[][]{
//                {"ID", "DATA", "RESTAURANTE"},
//                {1, "dd/MM/yyy", "A"},
//                {2, "dd/MM/yyy", "B"},
//                {3, "dd/MM/yyy", "C"},
//        };
//        //criação da tabela
//        JTable tabelaMCliResAct = new JTable(dados, nomeColunasMCliResAct);
//
//        JButton ptEnMCliRestButton = new JButton("PT/EN");
//        JButton voltarMCliResActButton = new JButton("MENU CLIENTE");
//        JButton visualizarMCliResActButton = new JButton("VISUALIZAR");
//        JButton retonarMCliResActButton = new JButton("RETORNAR");
//
//        JRadioButton editarMCliResActButton = new JRadioButton("EDITAR");
//        JRadioButton apagarMCliResActButton = new JRadioButton("APAGAR");
//
//        ButtonGroup group = new ButtonGroup();
//        group.add(editarMCliResActButton);
//        group.add(apagarMCliResActButton);
//
//        mCliResActSuperPanel.add(norteMCliResActSubPanel, "North");
//        mCliResActSuperPanel.add(centroMCliResActSubPanel, "Center");
//        mCliResActSuperPanel.add(sulMCliResActSubPanel, "South");
//
//        JPanel norteMCliResActSSPanel = new JPanel();
//        norteMCliResActSSPanel.setLayout(new FlowLayout());
//        norteMCliResActSSPanel.add(mCliTitHistResActLabel);
//        norteMCliResActSubPanel.add(norteMCliResActSSPanel, BorderLayout.CENTER);
//        norteMCliResActSubPanel.add(ptEnMCliRestButton, BorderLayout.EAST);
//
//        JPanel centroMCliResActSSPanel = new JPanel();
//        centroMCliResActSSPanel.setLayout(new FlowLayout());
//        centroMCliResActSubPanel.add(centroMCliResActSSPanel, BorderLayout.WEST);
//
//        JPanel centroMCliResActSSPanel1 = new JPanel();
//        centroMCliResActSSPanel1.setLayout(new FlowLayout());
//        centroMCliResActSubPanel.add(centroMCliResActSSPanel1, BorderLayout.WEST);
//
//        JPanel centroMCliResActSSPanel2 = new JPanel();
//        centroMCliResActSSPanel2.setLayout(new FlowLayout());
//        centroMCliResActSubPanel.add(centroMCliResActSSPanel2, BorderLayout.WEST);
//
//        centroMCliResActSSPanel.add(tabelaMCliResAct);
//        centroMCliResActSSPanel1.add(mCliIdHistResActLabel);
//        centroMCliResActSSPanel1.add(arrayMCliIdHistResActCBox);
//        centroMCliResActSSPanel2.add(editarMCliResActButton);
//        centroMCliResActSSPanel2.add(apagarMCliResActButton);
//
//        sulMCliResActSubPanel.setLayout(new FlowLayout());
//        sulMCliResActSubPanel.add(voltarMCliResActButton);
//        sulMCliResActSubPanel.add(retonarMCliResActButton);
//        sulMCliResActSubPanel.add(visualizarMCliResActButton);
//
//
//        visualizarMCliResActButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//
//        });
//
//        editarMCliResActButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        apagarMCliResActButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        retonarMCliResActButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIRESERVAS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliResActButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//    }
//
//    //////MENU CLIENTE – FAZER RESERVAS//////////
//    private void construirPanelMCliFazerRes(Interface janela, Container contentor, JPanel
//            loginSuperPanel, JPanel mCliFazerResSuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliFResSubPanel = new JPanel();
//        norteMCliFResSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliFResSubPanel = new JPanel();
//        JPanel sulMCliFResSubPanel = new JPanel();
//
//        JLabel mCliTitFResLabel = new JLabel("MENU CLIENTE - FAZER RESERVAS");
//        JLabel tipoResMCliFResLabel = new JLabel("TIPO DE RESERVA:");
//        JLabel nomeResMCliFResLabel = new JLabel("RESTAURANTE:");
//
//        JTextField nomeResMCliFResText = new JTextField(25);
//
//        JRadioButton presencialMCliFResRButton = new JRadioButton("PRESENCIAL");
//        JRadioButton takeAwayMCliFResRButton = new JRadioButton("TAKE-AWAY");
//
//        ButtonGroup group = new ButtonGroup();
//        group.add(presencialMCliFResRButton);
//        group.add(takeAwayMCliFResRButton);
//
//        JButton ptEnMCliFResButton = new JButton("PT/EN");
//        JButton voltarMCliFResButton = new JButton("MENU CLIENTE");
//        JButton retornarMCliFResButton = new JButton("VOLTAR");
//
//        mCliFazerResSuperPanel.add(norteMCliFResSubPanel, "North");
//        mCliFazerResSuperPanel.add(centroMCliFResSubPanel, "Center");
//        mCliFazerResSuperPanel.add(sulMCliFResSubPanel, "South");
//
//        JPanel norteMCliFResSSPanel = new JPanel();
//        norteMCliFResSSPanel.setLayout(new FlowLayout());
//        norteMCliFResSSPanel.add(mCliTitFResLabel);
//        norteMCliFResSubPanel.add(norteMCliFResSSPanel, BorderLayout.CENTER);
//        norteMCliFResSubPanel.add(ptEnMCliFResButton, BorderLayout.EAST);
//
//        JPanel centroMCliFResSSPanel = new JPanel();
//        centroMCliFResSSPanel.setLayout(new FlowLayout());
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel, BorderLayout.WEST);
//
//        JPanel centroMCliFResSSPanel1 = new JPanel();
//        centroMCliFResSSPanel1.setLayout(new FlowLayout());
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel1, BorderLayout.WEST);
//
//        JPanel centroMCliFResSSPanel2 = new JPanel();
//        centroMCliFResSSPanel2.setLayout(new FlowLayout());
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel2, BorderLayout.WEST);
//
//        JPanel centroMCliFResSSPanel3 = new JPanel();
//        centroMCliFResSSPanel3.setLayout(new GridLayout(1, 1));
//        centroMCliFResSubPanel.add(centroMCliFResSSPanel3, BorderLayout.WEST);
//
//        //todo ver como listar o restaurantes
//        centroMCliFResSSPanel1.add(nomeResMCliFResLabel);
//        centroMCliFResSSPanel1.add(nomeResMCliFResText);
//        centroMCliFResSSPanel2.add(tipoResMCliFResLabel);
//        centroMCliFResSSPanel3.add(presencialMCliFResRButton);
//        centroMCliFResSSPanel3.add(takeAwayMCliFResRButton);
//
//        sulMCliFResSubPanel.setLayout(new FlowLayout());
//        sulMCliFResSubPanel.add(voltarMCliFResButton);
//        sulMCliFResSubPanel.add(retornarMCliFResButton);
//
//        presencialMCliFResRButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIFAZERRESP_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        takeAwayMCliFResRButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIFAZERRESTA_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        retornarMCliFResButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIRESERVAS_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        voltarMCliFResButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//    }
//
//
//    //////MENU CLIENTE – FAZER RESERVA PRESENCIAL//////////
//    private void construirPanelMCliFazerResP(Interface janela, Container contentor, JPanel
//            loginSuperPanel, JPanel mCliFazerResPSuperPanel) {
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliFResPSubPanel = new JPanel();
//        norteMCliFResPSubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliFResPSubPanel = new JPanel();
//        JPanel sulMCliFResPSubPanel = new JPanel();
//
//        JLabel mCliTitFResPLabel = new JLabel("FAZER RESERVAS PRESENCIAL");
//        JLabel diaMCliFResPLabel = new JLabel("DIA");
//        JLabel horaMCliFResPLabel = new JLabel("HORA");
//        //JLabel horaDeMCliFResPLabel = new JLabel("De");
//        //JLabel horaAteMCliFResPLabel = new JLabel("Até");
//        JLabel qtdePessoasMCliFResPLabel = new JLabel("QUANTIDADE DE PESSOAS");
//        JLabel msgMCliFResPLabel = new JLabel("Contatar diretamente o restaurante no caso de reservas para mais de 20 pessoas");
//
//        String[] horaDeMCliFRes = {"", "11h", "11h30", "12h", "12h30", "13h", "13h30", "14h", "14h30", "15h", "15h30", "19h", "19h30", "20h", "20h30", "21h", "21h30", "22h", "22h30"};
//        JComboBox arrayHoraDeMCliFResPCBox = new JComboBox(horaDeMCliFRes);
//
//        //todo verificar se não deve mesmo constar
//        //String [] horaAteMCliFRes = {"","12h","12h30","13h","13h30","14h","14h30","15h","15h30","19h","19h30","20h","20h30","21h","21h30","22h","22h30"};
//        //JComboBox arrayHoraAteMCliFResPCBox = new JComboBox(horaAteMCliFRes);
//
//        String[] qtdePessoasMCliFRes = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
//        JComboBox arrayQtdePessoasMCliFResPCBox = new JComboBox(qtdePessoasMCliFRes);
//
//        JButton ptEnMCliFResPButton = new JButton("PT/EN");
//        JButton voltarMCliFResPButton = new JButton("MENU CLIENTE");
//        JButton confirmarMCliFResPButton = new JButton("OK");
//        JButton retornarMCliFResPButton = new JButton("VOLTAR");
//
//        //Adição do calendário
//        //UtilDateModel model1 = new UtilDateModel();
//        UtilDateModel model6 = new UtilDateModel();
//
//        ResourceBundle b = ResourceBundle.getBundle("Text");
//
//        Properties p = convertResourceBundleToProperties(b);
//        JDatePanelImpl datePanel5 = new JDatePanelImpl(model6, p);
//        JDatePickerImpl datePicker6 = new JDatePickerImpl(datePanel5, new DateLabelFormatter());
//
//        mCliFazerResPSuperPanel.add(norteMCliFResPSubPanel, "North");
//        mCliFazerResPSuperPanel.add(centroMCliFResPSubPanel, "Center");
//        mCliFazerResPSuperPanel.add(sulMCliFResPSubPanel, "South");
//
//        JPanel norteMCliFResSPPSSPanel = new JPanel();
//        norteMCliFResSPPSSPanel.setLayout(new FlowLayout());
//        norteMCliFResSPPSSPanel.add(mCliTitFResPLabel);
//        norteMCliFResPSubPanel.add(norteMCliFResSPPSSPanel, BorderLayout.CENTER);
//        norteMCliFResPSubPanel.add(ptEnMCliFResPButton, BorderLayout.EAST);
//
//        JPanel centroMCliFResPSSPanel = new JPanel();
//        centroMCliFResPSSPanel.setLayout(new FlowLayout());
//        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel, BorderLayout.WEST);
//
//        JPanel centroMCliFResPSSPanel1 = new JPanel();
//        centroMCliFResPSSPanel1.setLayout(new FlowLayout());
//        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel1, BorderLayout.WEST);
//
//        JPanel centroMCliFResPSSPanel2 = new JPanel();
//        centroMCliFResPSSPanel2.setLayout(new FlowLayout());
//        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel2, BorderLayout.WEST);
//
//        JPanel centroMCliFResPSSPanel3 = new JPanel();
//        centroMCliFResPSSPanel3.setLayout(new GridLayout(1, 1));
//        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel3, BorderLayout.WEST);
//
//        JPanel centroMCliFResPSSPanel4 = new JPanel();
//        centroMCliFResPSSPanel4.setLayout(new FlowLayout());
//        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel4, BorderLayout.WEST);
//
//        centroMCliFResPSSPanel.add(diaMCliFResPLabel);
//        centroMCliFResPSSPanel.add(datePicker6);
//        centroMCliFResPSSPanel1.add(horaMCliFResPLabel);
//        //centroMCliFResPSSPanel2.add(horaDeMCliFResPLabel);
//        centroMCliFResPSSPanel2.add(arrayHoraDeMCliFResPCBox);
//        //centroMCliFResPSSPanel2.add(horaAteMCliFResPLabel);
//        //centroMCliFResPSSPanel2.add(arrayHoraAteMCliFResPCBox);
//
//        centroMCliFResPSSPanel3.add(qtdePessoasMCliFResPLabel);
//        centroMCliFResPSSPanel3.add(arrayQtdePessoasMCliFResPCBox);
//        centroMCliFResPSSPanel4.add(msgMCliFResPLabel);
//
//        sulMCliFResPSubPanel.setLayout(new FlowLayout());
//        sulMCliFResPSubPanel.add(voltarMCliFResPButton);
//        sulMCliFResPSubPanel.add(retornarMCliFResPButton);
//        sulMCliFResPSubPanel.add(confirmarMCliFResPButton);
//
//        voltarMCliFResPButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        retornarMCliFResPButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIFAZERRES_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        //todo ver os encaminhamentos
//        confirmarMCliFResPButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, LOGIN_CARD);
//            this.setSize(500, 180);
//        });
//
//    }
//
//    //////MENU CLIENTE – FAZER RESERVA TAKE-AWAY//////////
//    private void construirPanelMCliFazerResTA(Interface janela, Container contentor, JPanel
//            loginSuperPanel, JPanel mCliFazerResTASuperPanel) {
//
//
//        /////SUBPAINEIS//////
//        JPanel norteMCliFResTASubPanel = new JPanel();
//        norteMCliFResTASubPanel.setLayout(new BorderLayout());
//        JPanel centroMCliFResTASubPanel = new JPanel();
//        JPanel sulMCliFResTASubPanel = new JPanel();
//
//        JLabel mCliTitFResTALabel = new JLabel("FAZER RESERVAS TAKE-AWAY");
//        JLabel horaMCliFResTALabel = new JLabel("HORA");
//        JLabel idMCliFResTALabel = new JLabel("ID");
//        JLabel qtdePratosMCliFResTALabel = new JLabel("QUANTIDADE");
//        JLabel pratosMCliFResTALabel = new JLabel("PRATOS");
//
//        String[] horasMCliFResTA = {"", "11h30", "12h", "12h30", "13h", "13h30", "14h", "14h30", "15h", "15h30", "19h", "19h30", "20h", "20h30", "21h", "21h30", "22h", "22h30"};
//        JComboBox arrayHorasMCliFResTACBox = new JComboBox(horasMCliFResTA);
//
//        String[] idMCliFResTA = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
//        JComboBox arrayIdMCliFResTACBox = new JComboBox(idMCliFResTA);
//
//        String[] qtdePratosMCliFResTA = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
//        JComboBox arrayQtdePratosMCliFResTACBox = new JComboBox(qtdePratosMCliFResTA);
//
////todo possibilitar que o prato possa ser selecionado
//        String[] nomeColunasMCliFResTA = new String[]{
//                "ID", "NOME", "DESCRIÇÃO", "PREÇO", "TIPO"
//        };
//
//        Object[][] dados = new Object[][]{
//                {"ID", "NOME", "DESCRIÇÃO", "PREÇO", "TIPO"},
//                {1, "Sardinha", "Assada", "15.0", "Carta"},
//                {2, "Peru", "Ensopado", "15.0", "Prato do Dia"},
//                {3, "Bifana", "Frita", "15.0", "Carta"},
//                {4, "Sardinha", "Assada", "15.0", "Carta"},
//                {5, "Peru", "Ensopado", "15.0", "Prato do Dia"},
//                {6, "Bifana", "Frita", "15.0", "Carta"},
//
//        };
//        //criação da tabela
//        JTable tabelaMCliFResTA = new JTable(dados, nomeColunasMCliFResTA);
//
//        JButton ptEnMCliFResTAButton = new JButton("PT/EN");
//        JButton voltarMCliFResTAButton = new JButton("MENU CLIENTE");
//        JButton adicionarMCliFResTAButton = new JButton("ADICIONAR");
//        JButton retornarMCliFResButton = new JButton("VOLTAR");
//        JButton finalizarMCliFResTAButton = new JButton("FINALIZAR");
//
//        mCliFazerResTASuperPanel.add(norteMCliFResTASubPanel, "North");
//        mCliFazerResTASuperPanel.add(centroMCliFResTASubPanel, "Center");
//        mCliFazerResTASuperPanel.add(sulMCliFResTASubPanel, "South");
//
//        JPanel norteMCliFResTASSPanel = new JPanel();
//        norteMCliFResTASSPanel.setLayout(new FlowLayout());
//        norteMCliFResTASSPanel.add(mCliTitFResTALabel);
//        norteMCliFResTASubPanel.add(norteMCliFResTASSPanel, BorderLayout.CENTER);
//        norteMCliFResTASubPanel.add(ptEnMCliFResTAButton, BorderLayout.EAST);
//
//        JPanel centroMCliFResTASSPanel = new JPanel();
//        centroMCliFResTASSPanel.setLayout(new FlowLayout());
//        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel, BorderLayout.WEST);
//
//        JPanel centroMCliFResTASSPanel1 = new JPanel();
//        centroMCliFResTASSPanel1.setLayout(new FlowLayout());
//        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel1, BorderLayout.WEST);
//
//        JPanel centroMCliFResTASSPanel2 = new JPanel();
//        centroMCliFResTASSPanel2.setLayout(new FlowLayout());
//        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel2, BorderLayout.WEST);
//
//        JPanel centroMCliFResTASSPanel3 = new JPanel();
//        centroMCliFResTASSPanel3.setLayout(new FlowLayout());
//        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel3, BorderLayout.CENTER);
//
//        JPanel centroMCliFResTASSPanel4 = new JPanel();
//        centroMCliFResTASSPanel4.setLayout(new FlowLayout());
//        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel4, BorderLayout.WEST);
//
//        centroMCliFResTASSPanel.add(horaMCliFResTALabel);
//        centroMCliFResTASSPanel1.add(arrayHorasMCliFResTACBox);
//        centroMCliFResTASSPanel3.add(pratosMCliFResTALabel);
//        centroMCliFResTASSPanel3.add(tabelaMCliFResTA);
//        centroMCliFResTASSPanel4.add(idMCliFResTALabel);
//        centroMCliFResTASSPanel4.add(arrayIdMCliFResTACBox);
//        centroMCliFResTASSPanel4.add(qtdePratosMCliFResTALabel);
//        centroMCliFResTASSPanel4.add(arrayQtdePratosMCliFResTACBox);
//
//        sulMCliFResTASubPanel.setLayout(new FlowLayout());
//        sulMCliFResTASubPanel.add(voltarMCliFResTAButton);
//        sulMCliFResTASubPanel.add(retornarMCliFResButton);
//        sulMCliFResTASubPanel.add(adicionarMCliFResTAButton);
//        sulMCliFResTASubPanel.add(finalizarMCliFResTAButton);
//
//
//        voltarMCliFResTAButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MENUCLIENTE_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        retornarMCliFResButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIFAZERRES_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//        //todo fazer nova página com valor final (botoes de finalizar, editar e remover com quantidade)
//        finalizarMCliFResTAButton.addActionListener(a -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIFAZERRES_CARD);
//            this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
//        });
//
//        //todo ver os encaminhamentos
//        adicionarMCliFResTAButton.addActionListener(e -> {
//            CardLayout cl = (CardLayout) contentor.getLayout();
//            cl.show(contentor, MCLIFAZERRES_CARD);
//            this.setSize(500, 180);
//        });
//
//
//        this.setVisible(true);
//    }
//
//}