package com.company.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
//import java.security.interfaces.RSAKey;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.company.Cliente;
import com.company.Comentario;
import com.company.Presencial;
import com.company.Reserva;
import com.company.Restaurante;
import com.company.Sistema;
import com.company.Utilizador;
import com.company.gui.util.DateLabelFormatter;

public class Interface extends JFrame {
    private static final String LOGIN_CARD = "LOGIN";
    private static final String RESTAURANTE_CARD = "RESTAURANTE";
    private static final String CLIENTE_CARD = "CLIENTE";
    private static final String MENUCLIENTE_CARD = "MENU CLIENTE";
    private static final String MCLIATDADOS_CARD = "MENU CLIENTE - ACTUALIZAR DADOS";
    private static final String MCLIHISRES_CARD = "MENU CLIENTE - HISTÓRICO DE RESERVAS";
    private static final String MCLIMRESCOMPONTRESE_CARD = "MENU CLIENTE - HISTÓRICO DE RESERVAS: COMENTAR";
    private static final String MCLIRESACT_CARD = "MENU CLIENTE - RESERVAS ACTIVAS";
    private static final String MCLIFAZERRES_CARD = "MENU CLIENTE - FAZER RESERVAS";
    private static final String MCLIFAZERRESP_CARD = "MENU CLIENTE - FAZER RESERVAS PRESENCIAL";
    private static final String MCLIFAZERRESTA_CARD = "MENU CLIENTE - FAZER RESERVAS TAKE-AWAY";
    private static final String MCLIRESERVAS_CARD = "MENU CLIENTE - RESERVAS";
    private static final String MCLIMRESTFORDRESTS_CARD = "MENU CLIENTE - MENU RESTAURANTES";
    private static final String MCLIMRESTFRESTPONT_CARD = "MENU CLIENTE - MENU RESTAURANTES - PONTUAÇÃO";
    private static final String MCLIMRESTFORDRESTVALOR_CARD = "MENU CLIENTE - MENU RESTAURANTES - VALOR MÉDIO DOS PRATOS";
    private static final String MCLIMRESTFORDRESTVALORCARTA_CARD = "MENU CLIENTE - MENU RESTAURANTES - VALOR MÉDIO DOS PRATOS - CARTA";
    private static final String MCLIMRESTFORDRESTVALORCARTARESULTADO_CARD = "MENU CLIENTE - MENU RESTAURANTES - VALOR MÉDIO DOS PRATOS - CARTA - RESULTADO";
    private static final String MCLIMRESTFORDRESTVALORPDIA_CARD = "MENU CLIENTE - MENU RESTAURANTES - VALOR MÉDIO DOS PRATOS - PRATO DO DIA";
    private static final String MCLIMRESTFORDRESTVALORPDIARESULT_CARD = "MENU CLIENTE - MENU RESTAURANTES - VALOR MÉDIO DOS PRATOS - PRATO DO DIA - RESULTADO";
    private static final String MCLIMRESTFRESTHFUNC_CARD = "MENU CLIENTE - MENU RESTAURANTES - HORÁRIO FUNCIONAMENTO";
    private static final String MCLIMRESTFRESTHFUNCRESULTADO_CARD = "MENU CLIENTE - MENU RESTAURANTES - HORÁRIO FUNCIONAMENTO - RESULTADO";
    private static final String MCLIMRESTFRESTLOT_CARD = "MENU CLIENTE - MENU RESTAURANTES - LOTAÇÃO";
    private static final String MCLIMRESTFRESTLOTRESULTADO_CARD = "MENU CLIENTE - MENU RESTAURANTES - LOTAÇÃO - RESULTADO";
    private static final String MCLIMRESTFRESTCID_CARD = "MENU CLIENTE - MENU RESTAURANTES - CIDADE";
    private static final String MCLIMRESTFRESTCIDRESULTADO_CARD = "MENU CLIENTE - MENU RESTAURANTES - CIDADE - RESULTADO";
    private static final String MCLIMCOM_CARD = "MENU CLIENTE – MENU COMENTÁRIOS";
    private static final String MCLIMCOMFPP_CARD = "MENU CLIENTE – COMENTÁRIOS - PRÓPRIOS";
    private static final String MCLIMCOMFCLI_CARD = "MENU CLIENTE – COMENTÁRIOS – FILTRAR POR CLIENTE";
    private static final String MCLIMCOMFCLIRESULTADO_CARD = "MENU CLIENTE – COMENTÁRIOS – FILTRAR POR CLIENTE - RESULTADO";
    private static final String MCLIMCOMFREST_CARD = "MENU CLIENTE – COMENTÁRIOS - FILTRAR POR RESTAURANTE";
    private static final String MCLIMCOMFRESTRESULTADO_CARD = "MENU CLIENTE – COMENTÁRIOS - FILTRAR POR RESTAURANTE - RESULTADO";
    private static final String MCLIMCOMFID_CARD = "MENU CLIENTE – COMENTÁRIOS – FILTRAR POR INTERVALO DE DATAS";
    private static final String MCLIMCOMFIDRESULTADO_CARD = "MENU CLIENTE – COMENTÁRIOS – FILTRAR POR INTERVALO DE DATAS - RESULTADO";
    private static final String MRESTPMED_CARD = "MENU CLIENTE – PONTUAÇÃO MÉDIA";
    private static final String MENURESTAURANTE_CARD = "MENU RESTAURANTE";
    private static final String MRESTADICIONARPRATO_CARD = "ADICIONAR PRATO";
    private static final String MRESTACTUALIZARPRATO_CARD = "ACTUALIZAR PRATO DO DIA";
    private static final String MRESTACTUALIZARDADOS_CARD = "MENU RESTAURANTE - ACTUALIZAR DADOS";
    private static final String MRESTRESERV_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS";
    private static final String MRESTRESERVASFID_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS - INTERVALO DE DATAS";
    private static final String MRESTRESERVASFTIPO_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS - TIPO";
    private static final String MRESTRESERVASFTIPOP_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS - PRESENCIAL";
    private static final String MRESTRESERVASFTIPOTA_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS - TAKE-AWAY";
    private static final String MRESTRESERVASFIV_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS - INTERVALO VALORES PRATOS";
    private static final String MRESTRESERVASFCLI_CARD = "MENU RESTAURANTE - HISTÓRICO DE RESERVAS - CLIENTES";
    private static final String MRESTCOMENTARIOS_CARD = "MENU RESTAURANTE - COMENTÁRIOS";
    private static final int LARGURA_LOGIN = 400;
    private static final int ALTURA_LOGIN = 180;
    private static final int LARGURA_PADRAO = 600;
    private static final int ALTURA_PADRAO = 350;
    private final Container contentor;
    private final JButton logoutButton;
    //private boolean usernameValido;
    private boolean passwordValido;
    private boolean confirmarPasswordValido;
    private final Sistema sistema;
    private MaskFormatter mascaraTelemovel;
    private JDatePickerImpl datePickerMCliMComFID1;
    private JPanel centroMCliMComFPPSSPanel;
    private JPanel centroMCliMComFCliSSPanel;
    private JPanel centroMCliMComFRestSSPanel;
    private ArrayList<Reserva> listaReserva;
    private JPanel centroMRestReservasFIDSSPanel3;
    private JTextField usernameLoginText;
    private JPasswordField passwordLoginField;
    private JPanel centroMCliMComFCliResultadoSSPanel;
    private JPanel centroMCliMComFRestResultadoSSPanel;
    private JPanel centroMCliMComFIDSSPanel3;
    private ArrayList<Restaurante> listaRestHF;
    private JPanel centroMCliMComFIDResultadoSSPanel;
    private JTextField fHoraMCliMRestFRestHFuncText;
    private JPanel centroMCliMRestFRestHFuncResultadoSSPanel2;
    private JPanel centroMCliMRestFRestCidResultadoSSPanel1;
    private JPanel centroMCliMRestRestLotResultadoSSPanel1;
    private JComboBox restaurantesResMCliFResCBox;
    private JRadioButton mRestReservasFTipoTAJButton;
    private JRadioButton mRestReservasFTipoPJButton;
    private JTextField demCliMRestFOrdRestValorText;
    private JTextField atemCliMRestFOrdRestValorText;
    private JPanel centroMCliMRestFOrdRestValorCartaResultadoSSPanel1;
    private JPanel centroMCliMRestFOrdRestValorPDiaResultSSPanel1;
    private JPanel centroMCliHistResSSPanel;
    private ButtonGroup groupRadioTipoReserva;
    private JPanel centroMCliMRestFRestPontSSPanel1;


    public Interface(Sistema sistema) {

        this.sistema = sistema;

        try {
            mascaraTelemovel = new MaskFormatter("#########");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ImageIcon logo = new ImageIcon("logo3.png");
        this.setIconImage(logo.getImage());

        //INSERINDO NOME DA APLICAÇÃO E LOGO
        this.setTitle("RESERVAS DE RESTAURANTES");
        this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentor = this.getContentPane();
        contentor.setLayout(new CardLayout());

        /////// SUPERPAINEIS////////
        JPanel loginSuperPanel = new JPanel();
        loginSuperPanel.setLayout(new BorderLayout());
        JPanel regNovoCliSuperPanel = new JPanel();
        regNovoCliSuperPanel.setLayout(new BorderLayout());
        JPanel registarNovoRestSuperPanel = new JPanel();
        registarNovoRestSuperPanel.setLayout(new BorderLayout());

        logoutButton = new JButton("LOGOUT");
        logoutButton.addActionListener(a -> {
            sistema.logout();
            mostrarJanela(LOGIN_CARD, usernameLoginText, passwordLoginField);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });

        construirPanelLogin(loginSuperPanel);

        construirPanelCliente(regNovoCliSuperPanel);

        construirPanelRestaurante(registarNovoRestSuperPanel);

        contentor.add(loginSuperPanel, LOGIN_CARD);
        contentor.add(regNovoCliSuperPanel, CLIENTE_CARD);
        contentor.add(registarNovoRestSuperPanel, RESTAURANTE_CARD);
    }

    private void posLogin() {
        JPanel mCliSuperPanel = new JPanel();
        mCliSuperPanel.setLayout(new BorderLayout());
        JPanel mCliAtDadosSuperPanel = new JPanel();
        mCliAtDadosSuperPanel.setLayout(new BorderLayout());
        JPanel mCliHistResSuperPanel = new JPanel();
        mCliHistResSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMResComPontReseSuperPanel = new JPanel();
        mCliMResComPontReseSuperPanel.setLayout(new BorderLayout());
        JPanel mCliResActSuperPanel = new JPanel();
        mCliResActSuperPanel.setLayout(new BorderLayout());
        JPanel mCliFazerResSuperPanel = new JPanel();
        mCliFazerResSuperPanel.setLayout(new BorderLayout());
        JPanel mCliFazerResPSuperPanel = new JPanel();
        mCliFazerResPSuperPanel.setLayout(new BorderLayout());
        JPanel mCliFazerResTASuperPanel = new JPanel();
        mCliFazerResTASuperPanel.setLayout(new BorderLayout());
        JPanel mCliReservasMReseSuperPanel = new JPanel();
        mCliReservasMReseSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFOrdRestsSuperPanel = new JPanel();
        mCliMRestFOrdRestsSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFRestPontSuperPanel = new JPanel();
        mCliMRestFRestPontSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFOrdRestValorSuperPanel = new JPanel();
        mCliMRestFOrdRestValorSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFOrdRestValorCartaSuperPanel = new JPanel();
        mCliMRestFOrdRestValorCartaSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFOrdRestValorCartaResultadoSuperPanel = new JPanel();
        mCliMRestFOrdRestValorCartaResultadoSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFOrdRestValorPDiaSuperPanel = new JPanel();
        mCliMRestFOrdRestValorPDiaSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFOrdRestValorPDiaResultSuperPanel = new JPanel();
        mCliMRestFOrdRestValorPDiaResultSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFRestHFuncSuperPanel = new JPanel();
        mCliMRestFRestHFuncSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFRestLotSuperPanel = new JPanel();
        mCliMRestFRestLotSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFRestLotResultadoSuperPanel = new JPanel();
        mCliMRestFRestLotResultadoSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFRestCidSuperPanel = new JPanel();
        mCliMRestFRestCidSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFRestCidResultadoSuperPanel = new JPanel();
        mCliMRestFRestCidResultadoSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMComSuperPanel = new JPanel();
        mCliMComSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMComFPPSuperPanel = new JPanel();
        mCliMComFPPSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMComFCliSuperPanel = new JPanel();
        mCliMComFCliSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMComFCliResultadoSuperPanel = new JPanel();
        mCliMComFCliResultadoSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMComFRestSuperPanel = new JPanel();
        mCliMComFRestSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMComFRestResultadoSuperPanel = new JPanel();
        mCliMComFRestResultadoSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMComFIDSuperPanel = new JPanel();
        mCliMComFIDSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMComFIDResultadoSuperPanel = new JPanel();
        mCliMComFIDResultadoSuperPanel.setLayout(new BorderLayout());
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
        JPanel mRestReservasFIDSuperPanel = new JPanel();
        mRestReservasFIDSuperPanel.setLayout(new BorderLayout());
        JPanel mRestReservasFTipoSuperPanel = new JPanel();
        mRestReservasFTipoSuperPanel.setLayout(new BorderLayout());
        JPanel mRestReservasFTipoPSuperPanel = new JPanel();
        mRestReservasFTipoPSuperPanel.setLayout(new BorderLayout());
        JPanel mRestReservasFTipoTASuperPanel = new JPanel();
        mRestReservasFTipoTASuperPanel.setLayout(new BorderLayout());
        JPanel mRestReservasFIVSuperPanel = new JPanel();
        mRestReservasFIVSuperPanel.setLayout(new BorderLayout());
        JPanel mRestReservasFCliSuperPanel = new JPanel();
        mRestReservasFCliSuperPanel.setLayout(new BorderLayout());
        JPanel mRestComentariosSuperPanel = new JPanel();
        mRestComentariosSuperPanel.setLayout(new BorderLayout());
        JPanel mRestPMedSuperPanel = new JPanel();
        mRestPMedSuperPanel.setLayout(new BorderLayout());
        JPanel mCliMRestFRestHFuncResultadoSuperPanel = new JPanel();
        mCliMRestFRestHFuncResultadoSuperPanel.setLayout(new BorderLayout());


        if (sistema.getClienteAtivo() != null) {
            construirPanelMenuCliente(mCliSuperPanel);
            construirPanelMCliAtDados(mCliAtDadosSuperPanel);
            construirPanelMCliHistRes(mCliHistResSuperPanel);
            construirPanelMCliResAct(mCliResActSuperPanel);
            construirPanelMCliFazerRes(mCliFazerResSuperPanel);
            construirPanelMCliFazerResP(mCliFazerResPSuperPanel);
            construirPanelMCliFazerResTA(mCliFazerResTASuperPanel);
            construirPanelReservasMCliMRese(mCliReservasMReseSuperPanel);
            construirPanelMCliMResComPonReservas(mCliMResComPontReseSuperPanel);
            construirPanelMCliMRestFOrdRests(mCliMRestFOrdRestsSuperPanel);
            construirPanelMCliMRestFRestPont(mCliMRestFRestPontSuperPanel);
            construirPanelMCliMRestFOrdRestValor(mCliMRestFOrdRestValorSuperPanel);
            construirPanelMCliMRestFOrdRestValorCarta(mCliMRestFOrdRestValorCartaSuperPanel);
            construirPanelMCliMRestFOrdRestValorCartaResultado(mCliMRestFOrdRestValorCartaResultadoSuperPanel);
            construirPanelMCliMRestFOrdRestValorPDia(mCliMRestFOrdRestValorPDiaSuperPanel);
            construirPanelMCliMRestFOrdRestValorPDiaResult(mCliMRestFOrdRestValorPDiaResultSuperPanel);
            construirPanelMCliMRestFRestHFunc(mCliMRestFRestHFuncSuperPanel);
            construirPanelMCliMRestFRestHFuncResultado(mCliMRestFRestHFuncResultadoSuperPanel);
            construirPanelMCliMRestFRestLot(mCliMRestFRestLotSuperPanel);
            construirPanelMCliMRestFRestLotResultado(mCliMRestFRestLotResultadoSuperPanel);
            construirPanelMCliMRestFRestCid(mCliMRestFRestCidSuperPanel);
            construirPanelMCliMRestFRestCidResultado(mCliMRestFRestCidResultadoSuperPanel);
            construirPanelMCliMCom(mCliMComSuperPanel);
            construirPanelMCliMComFPP(mCliMComFPPSuperPanel);
            construirPanelMCliMComFCli(mCliMComFCliSuperPanel);
            construirPanelMCliMComFCliResultado(mCliMComFCliResultadoSuperPanel);
            construirPanelMCliMComFRest(mCliMComFRestSuperPanel);
            construirPanelMCliMComFRest(mCliMComFRestSuperPanel);
            construirPanelMCliMComFRestResultado(mCliMComFRestResultadoSuperPanel);
            construirPanelMCliMComFID(mCliMComFIDSuperPanel);
            construirPanelMCliMComFIDResultado(mCliMComFIDResultadoSuperPanel);

            contentor.add(mCliSuperPanel, MENUCLIENTE_CARD);
            contentor.add(mCliAtDadosSuperPanel, MCLIATDADOS_CARD);
            contentor.add(mCliHistResSuperPanel, MCLIHISRES_CARD);
            contentor.add(mCliResActSuperPanel, MCLIRESACT_CARD);
            contentor.add(mCliFazerResSuperPanel, MCLIFAZERRES_CARD);
            contentor.add(mCliFazerResPSuperPanel, MCLIFAZERRESP_CARD);
            contentor.add(mCliFazerResTASuperPanel, MCLIFAZERRESTA_CARD);
            contentor.add(mCliReservasMReseSuperPanel, MCLIRESERVAS_CARD);
            contentor.add(mCliMResComPontReseSuperPanel, MCLIMRESCOMPONTRESE_CARD);
            contentor.add(mCliMRestFOrdRestsSuperPanel, MCLIMRESTFORDRESTS_CARD);
            contentor.add(mCliMRestFRestPontSuperPanel, MCLIMRESTFRESTPONT_CARD);
            contentor.add(mCliMRestFOrdRestValorSuperPanel, MCLIMRESTFORDRESTVALOR_CARD);
            contentor.add(mCliMRestFOrdRestValorCartaSuperPanel, MCLIMRESTFORDRESTVALORCARTA_CARD);
            contentor.add(mCliMRestFOrdRestValorCartaResultadoSuperPanel, MCLIMRESTFORDRESTVALORCARTARESULTADO_CARD);
            contentor.add(mCliMRestFOrdRestValorPDiaSuperPanel, MCLIMRESTFORDRESTVALORPDIA_CARD);
            contentor.add(mCliMRestFOrdRestValorPDiaResultSuperPanel, MCLIMRESTFORDRESTVALORPDIARESULT_CARD);
            contentor.add(mCliMRestFRestHFuncSuperPanel, MCLIMRESTFRESTHFUNC_CARD);
            contentor.add(mCliMRestFRestHFuncResultadoSuperPanel, MCLIMRESTFRESTHFUNCRESULTADO_CARD);
            contentor.add(mCliMRestFRestLotSuperPanel, MCLIMRESTFRESTLOT_CARD);
            contentor.add(mCliMRestFRestLotResultadoSuperPanel, MCLIMRESTFRESTLOTRESULTADO_CARD);
            contentor.add(mCliMRestFRestCidSuperPanel, MCLIMRESTFRESTCID_CARD);
            contentor.add(mCliMRestFRestCidResultadoSuperPanel, MCLIMRESTFRESTCIDRESULTADO_CARD);
            contentor.add(mCliMComSuperPanel, MCLIMCOM_CARD);
            contentor.add(mCliMComFPPSuperPanel, MCLIMCOMFPP_CARD);
            contentor.add(mCliMComFCliSuperPanel, MCLIMCOMFCLI_CARD);
            contentor.add(mCliMComFCliResultadoSuperPanel, MCLIMCOMFCLIRESULTADO_CARD);
            contentor.add(mCliMComFRestSuperPanel, MCLIMCOMFREST_CARD);
            contentor.add(mCliMComFRestResultadoSuperPanel, MCLIMCOMFRESTRESULTADO_CARD);
            contentor.add(mCliMComFIDSuperPanel, MCLIMCOMFID_CARD);
            contentor.add(mCliMComFIDResultadoSuperPanel, MCLIMCOMFIDRESULTADO_CARD);

        }
        if (sistema.getRestauranteAtivo() != null) {
            construirPanelMRest(mRestSuperPanel);
            construirPanelMRestAdPrato(mRestAdPratoSuperPanel);
            construirPanelMRestAtPratoDia(mRestAtPratoDiaSuperPanel);
            construirPanelMRestAtDados(mRestAtDadosSuperPanel);
            construirPanelMRestReservas(mRestReservasSuperPanel);
            construirPanelMRestReservasFID(mRestReservasFIDSuperPanel);
            construirPanelMRestReservasFTipo(mRestReservasFTipoSuperPanel);
            construirPanelMRestReservasFTipoP(mRestReservasFTipoPSuperPanel);
            construirPanelMRestReservasFTipoTA(mRestReservasFTipoTASuperPanel);
            construirPanelMRestReservasFIV(mRestReservasFIVSuperPanel);
            construirPanelMRestReservasFCli(mRestReservasFCliSuperPanel);
            construirPanelMRestComentarios(mRestComentariosSuperPanel);
            construirPanelMRestPMed(mRestPMedSuperPanel);

            contentor.add(mRestSuperPanel, MENURESTAURANTE_CARD);
            contentor.add(mRestAdPratoSuperPanel, MRESTADICIONARPRATO_CARD);
            contentor.add(mRestAtPratoDiaSuperPanel, MRESTACTUALIZARPRATO_CARD);
            contentor.add(mRestAtDadosSuperPanel, MRESTACTUALIZARDADOS_CARD);
            contentor.add(mRestReservasSuperPanel, MRESTRESERV_CARD);
            contentor.add(mRestReservasFIDSuperPanel, MRESTRESERVASFID_CARD);
            contentor.add(mRestReservasFTipoSuperPanel, MRESTRESERVASFTIPO_CARD);
            contentor.add(mRestReservasFTipoPSuperPanel, MRESTRESERVASFTIPOP_CARD);
            contentor.add(mRestReservasFTipoTASuperPanel, MRESTRESERVASFTIPOTA_CARD);
            contentor.add(mRestReservasFIVSuperPanel, MRESTRESERVASFIV_CARD);
            contentor.add(mRestReservasFCliSuperPanel, MRESTRESERVASFCLI_CARD);
            contentor.add(mRestComentariosSuperPanel, MRESTCOMENTARIOS_CARD);
            contentor.add(mRestPMedSuperPanel, MRESTPMED_CARD);
        }


    }

    ////////LOGIN/////////
    private void construirPanelLogin(JPanel loginSuperPanel) {
        ////Criação dos subpaineis norte, centro e sul
        JPanel norteLoginSubPanel = new JPanel();
        JPanel centroLoginSubPanel = new JPanel();
        JPanel sulLoginSubPanel = new JPanel();

        JButton ptEnLoginButton = new JButton("PT/EN");
        ptEnLoginButton.setSize(15, 5);
        JButton loginButton = new JButton("LOGIN");
        loginButton.setSize(15, 5);
        JButton clienteNovoButton = new JLinkButton("Novo Cliente");
        JButton restauranteNovoButton = new JLinkButton("Novo Restaurante");

        JLabel titleLoginLabel = new JLabel("LOGIN");
        JLabel usernameLoginLabel = new JLabel("Username");
        JLabel passwordLoginLabel = new JLabel("Password");

        usernameLoginText = new JTextField(20);

        passwordLoginField = new JPasswordField(20);

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
        sulLoginSubPanel.add(sulLoginSSPanelLinks);
        sulLoginSSPanelLinks.setLayout(new BorderLayout());
        sulLoginSSPanelLinks.add(clienteNovoButton, BorderLayout.EAST);
        sulLoginSSPanelLinks.add(restauranteNovoButton, BorderLayout.WEST);

        loginButton.addActionListener(a -> {
            Utilizador valida = sistema.login(usernameLoginText.getText(), new String(passwordLoginField.getPassword()));

            if (valida != null) {
                JOptionPane.showMessageDialog(((Component) a.getSource()).getParent(), "Login bem-sucedido!");
                posLogin();
                if (valida instanceof Cliente) {
                    mostrarJanela(MENUCLIENTE_CARD);
                } else {
                    mostrarJanela(MENURESTAURANTE_CARD);
                }

            } else {
                JOptionPane.showMessageDialog(((Component) a.getSource()).getParent(), "Dados inválidos!");
            }
        });

        clienteNovoButton.addActionListener(a -> mostrarJanela(CLIENTE_CARD));

        restauranteNovoButton.addActionListener(a -> mostrarJanela(RESTAURANTE_CARD));
    }

    private void mostrarJanela(String nomeJanela, JTextField... textFields) {
        for (JTextField text : textFields) {
            text.setText(null);
        }
        CardLayout cl = (CardLayout) contentor.getLayout();
        cl.show(contentor, nomeJanela);
        this.setSize(LARGURA_PADRAO, ALTURA_PADRAO);
    }

    ////////////////////NOVO CLIENTE/////////////////////////
    private void construirPanelCliente(JPanel registarNovoClienteSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteNovoClienteSubPanel = new JPanel();
        norteNovoClienteSubPanel.setLayout(new BorderLayout());
        JPanel centroNovoClienteSubPanel = new JPanel();
        JPanel sulNovoClienteSubPanel = new JPanel();

        JLabel registarNovoClienteLabel = new JLabel("NOVO CLIENTE");
        registarNovoClienteLabel.setForeground(Color.BLUE);
        JLabel nomeClienteLabel = new JLabel("Nome");
        JLabel emailClienteLabel = new JLabel("E-mail");
        JLabel moradaClienteLabel = new JLabel("Morada");
        JLabel telemovelClienteLabel = new JLabel("Telemóvel");
        JLabel usernameClienteLabel = new JLabel("Username");
        JLabel passwordClienteLabel = new JLabel("Password ");
        JLabel confirmarPasswordClienteLabel = new JLabel("Confirmar password ");

        JTextField nomeClienteText = new JTextField(20);
        nomeClienteText.setMargin(new Insets(3, 3, 3, 3));
        JTextField emailClienteText = new JTextField(20);
        JTextField moradaClienteText = new JTextField(20);
        JTextField telemovelClienteText = new JFormattedTextField(mascaraTelemovel);
        telemovelClienteText.setColumns(20);
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
            boolean validoNovoCliente = sistema.criarCliente(nomeClienteText.getText(),
                    emailClienteText.getText(),
                    moradaClienteText.getText(),
                    telemovelClienteText.getText(),
                    usernameClienteText.getText(),
//                    Arrays.toString(passwordClienteField.getPassword()),
//                    Arrays.toString(confirmarPassawordClienteField.getPassword()));
                    new String(passwordClienteField.getPassword()),
                    new String(confirmarPassawordClienteField.getPassword()));

            if (validoNovoCliente) {
                JOptionPane.showMessageDialog(((Component) a.getSource()).getParent(), "Registado com sucesso!");
                mostrarJanela(LOGIN_CARD, usernameLoginText, passwordLoginField);
                this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
                //sistema.login(usernameClienteText.getText(),Arrays.toString(passwordClienteField.getPassword()));
                //mostrarJanela(MENUCLIENTE_CARD);
            }
        });

        cancelarClienteButton.addActionListener(a -> {
            mostrarJanela(LOGIN_CARD, usernameLoginText, passwordLoginField);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });
    }


    ////// MENU CLIENTE//////////
    private void construirPanelMenuCliente(JPanel mCliSuperPanel) {

        /////SUBPAINEIS//////
        JPanel norteMenuClienteSubPanel = new JPanel();
        norteMenuClienteSubPanel.setLayout(new BorderLayout());
        JPanel centroMenuClienteSubPanel = new JPanel();
        JPanel sulMenuClienteSubPanel = new JPanel();

        JLabel registarNovoClienteLabel = new JLabel("MENU CLIENTE");
        registarNovoClienteLabel.setForeground(Color.BLUE);

        JButton ptEnMenuClienteButton = new JButton("PT/EN");
        JButton restaurantesMCliButton = new JButton("RESTAURANTES");
        JButton comentariosMCliButton = new JButton("COMENTÁRIOS");
        JButton reservasMCliButton = new JButton("RESERVAS");

        JButton atualDadosMCliButton = new JButton("ACTUALIZAR DADOS");

        mCliSuperPanel.add(norteMenuClienteSubPanel, "North");
        mCliSuperPanel.add(centroMenuClienteSubPanel, "Center");
        mCliSuperPanel.add(sulMenuClienteSubPanel, "South");

        JPanel norteClienteSubPanel = new JPanel();
        norteClienteSubPanel.setLayout(new FlowLayout());
        norteClienteSubPanel.add(registarNovoClienteLabel);
        norteMenuClienteSubPanel.add(norteClienteSubPanel, BorderLayout.CENTER);
        norteMenuClienteSubPanel.add(ptEnMenuClienteButton, BorderLayout.EAST);

        JPanel centroNovoClienteSSPanelForm = new JPanel();
        centroNovoClienteSSPanelForm.setLayout(new GridLayout(7, 2));
        centroMenuClienteSubPanel.add(centroNovoClienteSSPanelForm);
        centroNovoClienteSSPanelForm.add(restaurantesMCliButton);
        centroNovoClienteSSPanelForm.add(comentariosMCliButton);
        centroNovoClienteSSPanelForm.add(reservasMCliButton);

        centroNovoClienteSSPanelForm.add(atualDadosMCliButton);

        sulMenuClienteSubPanel.setLayout(new FlowLayout());
        sulMenuClienteSubPanel.add(logoutButton);

        comentariosMCliButton.addActionListener(a -> mostrarJanela(MCLIMCOM_CARD));

        restaurantesMCliButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));

        reservasMCliButton.addActionListener(a -> mostrarJanela(MCLIRESERVAS_CARD));

        atualDadosMCliButton.addActionListener(a -> mostrarJanela(MCLIATDADOS_CARD));
    }


    ////// MENU CLIENTE – MENU RESERVAS//////////
    private void construirPanelReservasMCliMRese(JPanel mCliReservasMReseSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMCliMReseSubPanel = new JPanel();
        norteMCliMReseSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMReseSubPanel = new JPanel();
        JPanel sulMCliMReseSubPanel = new JPanel();

        JLabel registarNovoMCliMReseLabel = new JLabel("MENU CLIENTE - RESERVAS");
        registarNovoMCliMReseLabel.setForeground(Color.BLUE);

        JButton ptEnMCliMReseButton = new JButton("PT/EN");
        JButton histReseMCliMReseButton = new JButton("HISTÓRICO");
        JButton reservasActMCliMReseButton = new JButton("RESERVAS ACTIVAS");
        JButton fazerReservasMCliMReseButton = new JButton("FAZER RESERVAS");
        JButton voltarMCliMReseButton = new JButton("MENU CLIENTE");

        mCliReservasMReseSuperPanel.add(norteMCliMReseSubPanel, "North");
        mCliReservasMReseSuperPanel.add(centroMCliMReseSubPanel, "Center");
        mCliReservasMReseSuperPanel.add(sulMCliMReseSubPanel, "South");

        JPanel norteMCliMReseSSPanel = new JPanel();
        norteMCliMReseSSPanel.setLayout(new FlowLayout());
        norteMCliMReseSSPanel.add(registarNovoMCliMReseLabel);
        norteMCliMReseSubPanel.add(norteMCliMReseSSPanel, BorderLayout.CENTER);
        norteMCliMReseSubPanel.add(ptEnMCliMReseButton, BorderLayout.EAST);

        JPanel centroNovoMCliMReseSSPanel = new JPanel();
        centroNovoMCliMReseSSPanel.setLayout(new GridLayout(7, 2));
        centroMCliMReseSubPanel.add(centroNovoMCliMReseSSPanel);

        centroNovoMCliMReseSSPanel.add(histReseMCliMReseButton);
        centroNovoMCliMReseSSPanel.add(reservasActMCliMReseButton);
        centroNovoMCliMReseSSPanel.add(fazerReservasMCliMReseButton);

        sulMCliMReseSubPanel.setLayout(new FlowLayout());
        sulMCliMReseSubPanel.add(voltarMCliMReseButton);

        //TODO Tais revisar erro
//        histReseMCliMReseButton.addActionListener(a -> {
//                    ArrayList<Reserva> listaHisRese = sistema.consultarHistoricoReservas(); //Dá erro, método a completar
//                    if (listaHisRese != null && !listaHisRese.isEmpty()) {
//                        String[][] dadosMCliHistResSSPanel = new String[listaHisRese.size()][2];
//                        DateLabelFormatter dateFormatterMCliHistRes = new DateLabelFormatter();
//                        int i = 0;
//                        for (Reserva rsv : listaHisRese) {
//                            try {
//                                dadosMCliHistResSSPanel[i][0] = dateFormatterMCliHistRes.dateTimeToString(rsv.getData());//Deveria ser da reserva
//                            } catch (ParseException parseException) {
//                                parseException.printStackTrace();
//                            }
//                            dadosMCliHistResSSPanel[i][1] = rsv.getRestaurante().getNome();
//                            i++;
//                        }
//                        String[] nomeColunasMCliHistResSSPanel = new String[]{"DATA","RESTAURANTE"};
//                        JTable tabelaMCliHistResSSPanel = new JTable(dadosMCliHistResSSPanel, nomeColunasMCliHistResSSPanel);
//                        JScrollPane jScrollMCliHistRes = new JScrollPane(tabelaMCliHistResSSPanel);
//                        tabelaMCliHistResSSPanel.setVisible(true);
//                        centroMCliHistResSSPanel.add(jScrollMCliHistRes, BorderLayout.CENTER);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Não existem reservas!");
//                        mostrarJanela(MCLIHISRES_CARD);
//                    }
//                });

        reservasActMCliMReseButton.addActionListener(a -> mostrarJanela(MCLIRESACT_CARD));

        fazerReservasMCliMReseButton.addActionListener(a -> {
            restaurantesResMCliFResCBox.removeAllItems();
            sistema.getListaRestaurantes().forEach(r -> restaurantesResMCliFResCBox.addItem(r.getNome()));
            mostrarJanela(MCLIFAZERRES_CARD);
        });

        voltarMCliMReseButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }


    //////MENU CLIENTE – RESERVAS - HISTÓRICO//////////
    private void construirPanelMCliHistRes (JPanel mCliHistResSuperPanel){


        /////SUBPAINEIS//////
        JPanel norteMCliHistResSubPanel = new JPanel();
        norteMCliHistResSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliHistResSubPanel = new JPanel();
        JPanel sulMCliHistResSubPanel = new JPanel();

        JLabel mCliTitHistResLabel = new JLabel("MENU CLIENTE - HISTÓRICO DE RESERVAS");

        JButton ptEnMCliHisRestButton = new JButton("PT/EN");
        JButton voltarMCliHistResButton = new JButton("MENU CLIENTE");
        JButton comentarMCliHistResButton = new JButton("COMENTAR");
        JButton retornarMCliHistResButton = new JButton("VOLTAR");

        mCliHistResSuperPanel.add(norteMCliHistResSubPanel, "North");
        mCliHistResSuperPanel.add(centroMCliHistResSubPanel, "Center");
        mCliHistResSuperPanel.add(sulMCliHistResSubPanel, "South");

        JPanel norteMCliHistResSSPanel = new JPanel();
        norteMCliHistResSSPanel.setLayout(new FlowLayout());
        norteMCliHistResSSPanel.add(mCliTitHistResLabel);
        norteMCliHistResSubPanel.add(norteMCliHistResSSPanel, BorderLayout.CENTER);
        norteMCliHistResSubPanel.add(ptEnMCliHisRestButton, BorderLayout.EAST);

        centroMCliHistResSSPanel = new JPanel();
        centroMCliHistResSSPanel.setLayout(new FlowLayout());
        centroMCliHistResSubPanel.add(centroMCliHistResSSPanel, BorderLayout.WEST);

        sulMCliHistResSubPanel.setLayout(new FlowLayout());
        sulMCliHistResSubPanel.add(voltarMCliHistResButton);
        sulMCliHistResSubPanel.add(retornarMCliHistResButton);
        sulMCliHistResSubPanel.add(comentarMCliHistResButton);

        retornarMCliHistResButton.addActionListener(a -> mostrarJanela(MCLIRESERVAS_CARD));

        //todo falta ativar este botão
        comentarMCliHistResButton.addActionListener(a -> mostrarJanela(MCLIMRESCOMPONTRESE_CARD));

        voltarMCliHistResButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    //todo espaço para escrever comentário pode ter barra de rolagem? ativar o botão OK
    /////////// MENU CLIENTE - MENU RESERVA - HISTÓRICO DE RESERVAS - COMENTAR UMA RESERVA///////
    private void construirPanelMCliMResComPonReservas (JPanel mCliMResComPontReseSuperPanel){


        /////SUBPAINEIS//////
        JPanel norteMCliRestComPonReseSubPanel = new JPanel();
        norteMCliRestComPonReseSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliRestComPonReseSubPanel = new JPanel();
        JPanel sulMCliRestComPonReseSubPanel = new JPanel();

        JRadioButton umPontRestComPonRese = new JRadioButton("1- Péssimo");
        JRadioButton doisPontRestComPonRese = new JRadioButton("2- Ruim");
        JRadioButton tresPontRestComPonRese = new JRadioButton("3- Regular");
        JRadioButton quatroPontRestComPonRese = new JRadioButton("4- Bom");
        JRadioButton cincoPontRestComPonRese = new JRadioButton("5- Muito Bom");

        ButtonGroup group1 = new ButtonGroup();
        group1.add(umPontRestComPonRese);
        group1.add(doisPontRestComPonRese);
        group1.add(tresPontRestComPonRese);
        group1.add(quatroPontRestComPonRese);
        group1.add(cincoPontRestComPonRese);

        JLabel mCliRestComPonReseLabel = new JLabel("MENU CLIENTE – HISTÓRICO DE RESERVAS - COMENTAR");
        JLabel restMCliMReseComPonLabel = new JLabel("RESTAURANTE");
        JLabel dataMCliMReseComPonLabel = new JLabel("DATA DA RESERVA");
        JLabel pontMCliRestComPonReseLabel = new JLabel("ATRIBUIR PONTUAÇÃO:");

        JTextField restMCliMReseComPonText = new JTextField(20);
        JTextField dataMCliMReseComPonText = new JTextField(8);
        JTextArea novoComMCliMReseComPonTextA = new JTextArea(5, 50);

        ButtonGroup group = new ButtonGroup();
        group.add(umPontRestComPonRese);
        group.add(doisPontRestComPonRese);
        group.add(tresPontRestComPonRese);
        group.add(quatroPontRestComPonRese);
        group.add(cincoPontRestComPonRese);

        JButton ptEnMCliRestComPonReseButton = new JButton("PT/EN");
        JButton voltarMCliRestComPonReseButton = new JButton("MENU CLIENTE");
        JButton okMCliRestComPonReseButton = new JButton("OK");
        JButton retornarMCliRestComPonReseButton = new JButton("VOLTAR");

        mCliMResComPontReseSuperPanel.add(norteMCliRestComPonReseSubPanel, "North");
        mCliMResComPontReseSuperPanel.add(centroMCliRestComPonReseSubPanel, "Center");
        mCliMResComPontReseSuperPanel.add(sulMCliRestComPonReseSubPanel, "South");

        JPanel norteMCliRestComPonReseSSPanel = new JPanel();
        norteMCliRestComPonReseSSPanel.setLayout(new FlowLayout());
        norteMCliRestComPonReseSSPanel.add(mCliRestComPonReseLabel);
        norteMCliRestComPonReseSubPanel.add(norteMCliRestComPonReseSSPanel, BorderLayout.CENTER);
        norteMCliRestComPonReseSubPanel.add(ptEnMCliRestComPonReseButton, BorderLayout.EAST);

        JPanel centroMCliRestComPonReseSSPanel = new JPanel();
        centroMCliRestComPonReseSSPanel.setLayout(new FlowLayout());
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel, BorderLayout.WEST);

        JPanel centroMCliRestComPonReseSSPanel1 = new JPanel();
        centroMCliRestComPonReseSSPanel1.setLayout(new FlowLayout());
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel1, BorderLayout.CENTER);

        JPanel centroMCliRestComPonReseSSPanel2 = new JPanel();
        centroMCliRestComPonReseSSPanel2.setLayout(new GridLayout(1, 1));
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel2);

        JPanel centroMCliRestComPonReseSSPanel3 = new JPanel();
        centroMCliRestComPonReseSSPanel3.setLayout(new BorderLayout());
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel3, BorderLayout.WEST);

        JPanel centroMCliRestComPonReseSSPanel4 = new JPanel();
        centroMCliRestComPonReseSSPanel4.setLayout(new BorderLayout());
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel4, BorderLayout.WEST);

        JPanel centroMCliRestComPonReseSSPanel5 = new JPanel();
        centroMCliRestComPonReseSSPanel5.setLayout(new BorderLayout());
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel5, BorderLayout.WEST);

        JPanel centroMCliRestComPonReseSSPanel6 = new JPanel();
        centroMCliRestComPonReseSSPanel6.setLayout(new BorderLayout());
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel6, BorderLayout.WEST);

        JPanel centroMCliRestComPonReseSSPanel7 = new JPanel();
        centroMCliRestComPonReseSSPanel7.setLayout(new BorderLayout());
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel7, BorderLayout.WEST);

        JPanel centroMCliRestComPonReseSSPanel8 = new JPanel();
        centroMCliRestComPonReseSSPanel8.setLayout(new GridLayout(1, 2));
        centroMCliRestComPonReseSubPanel.add(centroMCliRestComPonReseSSPanel8);
        centroMCliRestComPonReseSSPanel.add(restMCliMReseComPonLabel);
        centroMCliRestComPonReseSSPanel.add(restMCliMReseComPonText);
        centroMCliRestComPonReseSSPanel.add(dataMCliMReseComPonLabel);
        centroMCliRestComPonReseSSPanel.add(dataMCliMReseComPonText);
        centroMCliRestComPonReseSSPanel1.add(novoComMCliMReseComPonTextA);

        centroMCliRestComPonReseSSPanel2.add(pontMCliRestComPonReseLabel);
        centroMCliRestComPonReseSSPanel3.add(umPontRestComPonRese);
        centroMCliRestComPonReseSSPanel4.add(doisPontRestComPonRese);
        centroMCliRestComPonReseSSPanel5.add(tresPontRestComPonRese);
        centroMCliRestComPonReseSSPanel6.add(quatroPontRestComPonRese);
        centroMCliRestComPonReseSSPanel7.add(cincoPontRestComPonRese);

        sulMCliRestComPonReseSubPanel.setLayout(new FlowLayout());
        sulMCliRestComPonReseSubPanel.add(voltarMCliRestComPonReseButton);
        sulMCliRestComPonReseSubPanel.add(retornarMCliRestComPonReseButton);
        sulMCliRestComPonReseSubPanel.add(okMCliRestComPonReseButton);

        retornarMCliRestComPonReseButton.addActionListener(a -> mostrarJanela(MCLIRESERVAS_CARD));
        voltarMCliRestComPonReseButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        //todo ver os encaminhamentos
        okMCliRestComPonReseButton.addActionListener(e -> {
            mostrarJanela(LOGIN_CARD, usernameLoginText, passwordLoginField);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });
    }


    ////////////////////NOVO RESTAURANTE/////////////////////////
    private void construirPanelRestaurante (JPanel registarNovoRestauranteSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteNovoRestauranteSubPanel = new JPanel();
        norteNovoRestauranteSubPanel.setLayout(new BorderLayout());
        JPanel centroNovoRestauranteSubPanel = new JPanel();
        centroNovoRestauranteSubPanel.setLayout(new FlowLayout());
        JPanel sulNovoRestauranteSubPanel = new JPanel();

        JLabel registarNovoRestauranteLabel = new JLabel("NOVO RESTAURANTE");
        registarNovoRestauranteLabel.setForeground(Color.RED);
        JLabel nomeRestauranteLabel = new JLabel("Nome");
        JLabel emailRestauranteLabel = new JLabel("E-mail");
        JLabel moradaRestauranteLabel = new JLabel("Morada");
        JLabel cidadeRestauranteLabel = new JLabel("Cidade");
        JLabel telemovelRestauranteLabel = new JLabel("Telemóvel");
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
        JLabel usernameRestauranteLabel = new JLabel("Username");
        JLabel passwordRestauranteLabel = new JLabel("Password ");
        JLabel confirmarPasswordRestauranteLabel = new JLabel("Confirmar password ");

        JTextField nomeRestauranteText = new JTextField(18);
        nomeRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField emailRestauranteText = new JTextField(18);
        emailRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField moradaRestauranteText = new JTextField(20);
        moradaRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField cidadeRestauranteText = new JTextField(15);
        cidadeRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField telemovelRestauranteText = new JFormattedTextField(mascaraTelemovel);
        telemovelRestauranteText.setColumns(8);
        telemovelRestauranteText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
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
        JPanel centroNovoRestSSPanelForm2A = new JPanel();
        centroNovoRestSSPanelForm2A.setLayout(new FlowLayout());
        centroNovoRestauranteSubPanel.add(centroNovoRestSSPanelForm2A, BorderLayout.CENTER);
        JPanel centroNovoRestSSPanelForm3 = new JPanel();
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
        centroNovoRestSSPanelForm2A.add(cidadeRestauranteLabel);
        centroNovoRestSSPanelForm2A.add(cidadeRestauranteText);
        centroNovoRestSSPanelForm2A.add(telemovelRestauranteLabel);
        centroNovoRestSSPanelForm2A.add(telemovelRestauranteText);
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
            mostrarJanela(LOGIN_CARD, usernameLoginText, passwordLoginField);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });

        registarRestauranteButton.addActionListener(a -> {
            int esplanadaRest = Integer.parseInt(esplanadaRestauranteText.getText());
            int zonaIFRest = Integer.parseInt(zonaInteriorFumRestauranteText.getText());
            int zonaINFRest = Integer.parseInt(zonaInteriorNFumRestauranteText.getText());
            LocalTime horaAI = LocalTime.parse(horarioAlmocoInicioRestauranteText.getText());
            LocalTime horaAF = LocalTime.parse(horarioAlmocoFimRestauranteText.getText());
            LocalTime horaJI = LocalTime.parse(horarioJantarInicioRestauranteText.getText());
            LocalTime horaJF = LocalTime.parse(horarioJantarFimRestauranteText.getText());

            boolean validoNovoRest = sistema.criarRestaurante(nomeRestauranteText.getText(),
                    moradaRestauranteText.getText(),
                    cidadeRestauranteText.getText(),
                    telemovelRestauranteText.getText(),
                    emailRestauranteText.getText(),
                    usernameRestauranteText.getText(),
                    new String(passwordRestauranteField.getPassword()),
                    new String(confirmarPasswordRestauranteField.getPassword()),
                    esplanadaRest,
                    zonaIFRest,
                    zonaINFRest,
                    horaAI,
                    horaAF,
                    horaJI,
                    horaJF);

            if (validoNovoRest) {
                JOptionPane.showMessageDialog(null, "Registado com sucesso!");
                mostrarJanela(LOGIN_CARD);
                this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
            }

        });
    }

    //////MENU RESTAURANTE////////
    private void construirPanelMRest (JPanel menuRestauranteSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMenuRestauranteSubPanel = new JPanel();
        norteMenuRestauranteSubPanel.setLayout(new BorderLayout());
        JPanel centroMenuRestauranteSubPanel = new JPanel();
        JPanel sulMenuRestauranteSubPanel = new JPanel();

        JLabel registarNovoRestauranteLabel = new JLabel("MENU RESTAURANTE");
        registarNovoRestauranteLabel.setForeground(Color.RED);

        JButton ptEnMenuRestauranteButton = new JButton("PT/EN");
        JButton mRestAdicionarPratoButton = new JButton("ADICIONAR PRATO");
        JButton mRestActualizarPratoDiaButton = new JButton("ACTUALIZAR PRATO DO DIA");
        JButton mRestActualizarDadosButton = new JButton("ACTUALIZAR DADOS");
        JButton mRestReservasButton = new JButton("RESERVAS");
        JButton mRestConsultarComentariosButton = new JButton("COMENTÁRIOS");
        JButton mRestPMedButton = new JButton("PONTUAÇÃO MÉDIA");

        menuRestauranteSuperPanel.add(norteMenuRestauranteSubPanel, "North");
        menuRestauranteSuperPanel.add(centroMenuRestauranteSubPanel, "Center");
        menuRestauranteSuperPanel.add(sulMenuRestauranteSubPanel, "South");

        JPanel norteMenuRestauranteSSPanel = new JPanel();
        norteMenuRestauranteSSPanel.setLayout(new FlowLayout());
        norteMenuRestauranteSSPanel.add(registarNovoRestauranteLabel);
        norteMenuRestauranteSubPanel.add(norteMenuRestauranteSSPanel, BorderLayout.CENTER);
        norteMenuRestauranteSubPanel.add(ptEnMenuRestauranteButton, BorderLayout.EAST);

        JPanel centroNovoRestauranteSSPanel = new JPanel();
        centroNovoRestauranteSSPanel.setLayout(new GridLayout(7, 1));
        centroMenuRestauranteSubPanel.add(centroNovoRestauranteSSPanel);

        centroNovoRestauranteSSPanel.add(mRestAdicionarPratoButton);
        centroNovoRestauranteSSPanel.add(mRestActualizarPratoDiaButton);
        centroNovoRestauranteSSPanel.add(mRestActualizarDadosButton);
        centroNovoRestauranteSSPanel.add(mRestReservasButton);
        centroNovoRestauranteSSPanel.add(mRestConsultarComentariosButton);
        centroNovoRestauranteSSPanel.add(mRestPMedButton);

        sulMenuRestauranteSubPanel.setLayout(new FlowLayout());
        sulMenuRestauranteSubPanel.add(logoutButton);

        mRestAdicionarPratoButton.addActionListener(a -> mostrarJanela(MRESTADICIONARPRATO_CARD));

        mRestActualizarPratoDiaButton.addActionListener(a -> mostrarJanela(MRESTACTUALIZARPRATO_CARD));

        mRestReservasButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        mRestActualizarDadosButton.addActionListener(a -> mostrarJanela(MRESTACTUALIZARDADOS_CARD));

        mRestPMedButton.addActionListener(a -> mostrarJanela(MRESTPMED_CARD));

        mRestConsultarComentariosButton.addActionListener(a -> mostrarJanela(MRESTCOMENTARIOS_CARD));


    }

    ///////////MENU RESTAURANTE - ADICIONAR PRATO//////////////////////
    private void construirPanelMRestAdPrato (JPanel mRestAdPratoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteAdPratoSubPanel = new JPanel();
        norteAdPratoSubPanel.setLayout(new BorderLayout());
        JPanel centroAdPratoSubPanel = new JPanel();
        JPanel sulAdPratoSubPanel = new JPanel();

        JLabel adPratoLabel = new JLabel("ADICIONAR PRATO");
        JLabel nomePratoLabel = new JLabel("Nome Prato");
        JLabel descricaoPratoLabel = new JLabel("Descrição");
        JLabel precoPratoLabel = new JLabel("Preço");
        JLabel menuRestAdPratoLabel = new JLabel("Tipo    ");

//        JTextField nomePratoText = new JTextField(25);
//        JTextField descricaoPratoText = new JTextField(25);
//        JTextField precoPratoText = new JTextField(10);

        JTextArea nomePratoText = new JTextArea(2, 50);
        JTextArea descricaoPratoText = new JTextArea(4, 50);
        JTextArea precoPratoText = new JTextArea(1, 10);

        JButton ptEnAdPratoButton = new JButton("PT/EN");
        JButton voltarMenuRestAdPratoButton = new JButton("MENU RESTAURANTE");
        JButton confirmarAdPratoButton = new JButton("CONFIRMAR");

        JComboBox menuRestAdPrato = new JComboBox();
        menuRestAdPrato.addItem("Carta");
        menuRestAdPrato.addItem("Prato do dia");


        mRestAdPratoSuperPanel.add(norteAdPratoSubPanel, "North");
        mRestAdPratoSuperPanel.add(centroAdPratoSubPanel, "Center");
        mRestAdPratoSuperPanel.add(sulAdPratoSubPanel, "South");

        JPanel norteAdPratoSSPanel = new JPanel();
        norteAdPratoSSPanel.setLayout(new FlowLayout());
        norteAdPratoSSPanel.add(adPratoLabel);
        norteAdPratoSubPanel.add(norteAdPratoSSPanel, BorderLayout.CENTER);
        norteAdPratoSubPanel.add(ptEnAdPratoButton, BorderLayout.EAST);

        JPanel centroAdPratoSSPanel = new JPanel();
        centroAdPratoSSPanel.setLayout(new FlowLayout());
        centroAdPratoSubPanel.add(centroAdPratoSSPanel);

        JPanel centroAdPratoSSPanel1 = new JPanel();
        centroAdPratoSSPanel1.setLayout(new FlowLayout());
        centroAdPratoSubPanel.add(centroAdPratoSSPanel1);

        JPanel centroAdPratoSSPanel2 = new JPanel();
        centroAdPratoSSPanel2.setLayout(new FlowLayout());
        centroAdPratoSubPanel.add(centroAdPratoSSPanel2);

        JPanel centroAdPratoSSPanel3 = new JPanel();
        centroAdPratoSSPanel3.setLayout(new GridBagLayout());
        centroAdPratoSubPanel.add(centroAdPratoSSPanel3, BorderLayout.CENTER);

        JPanel centroAdPratoSSPanel4 = new JPanel();
        centroAdPratoSSPanel4.setLayout(new GridBagLayout());
        centroAdPratoSubPanel.add(centroAdPratoSSPanel4, BorderLayout.CENTER);


        centroAdPratoSSPanel.add(nomePratoLabel);
        centroAdPratoSSPanel.add(nomePratoText);
        centroAdPratoSSPanel1.add(descricaoPratoLabel);
        centroAdPratoSSPanel1.add(descricaoPratoText);
        centroAdPratoSSPanel2.add(precoPratoLabel);
        centroAdPratoSSPanel2.add(precoPratoText);

        centroAdPratoSSPanel3.add(menuRestAdPratoLabel);
        centroAdPratoSSPanel3.add(menuRestAdPrato);

        sulAdPratoSubPanel.setLayout(new FlowLayout());
        sulAdPratoSubPanel.add(voltarMenuRestAdPratoButton);
        sulAdPratoSubPanel.add(confirmarAdPratoButton);

        voltarMenuRestAdPratoButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

        confirmarAdPratoButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

    }

    /////////MENU RESTAURANTE – ACTUALIZAR PRATO//////////////////////
    private void construirPanelMRestAtPratoDia (JPanel mRestAtPratoSuperPanel){


        /////SUBPAINEIS//////
        JPanel norteAtPratoSubPanel = new JPanel();
        norteAtPratoSubPanel.setLayout(new BorderLayout());
        JPanel centroAtPratoSubPanel = new JPanel();
        JPanel sulAtPratoSubPanel = new JPanel();

        JLabel atPratoLabel = new JLabel("ACTUALIZAR PRATO DO DIA");
        JLabel atNomePratoLabel = new JLabel("Nome Prato");
        JLabel atDescricaoPratoLabel = new JLabel("Descrição");
        JLabel atPrecoPratoLabel = new JLabel("Preço");

        JTextArea atNomePratoText = new JTextArea(1, 50);
        JTextArea atDescricaoPratoText = new JTextArea(1, 50);
        JTextArea atPrecoPratoText = new JTextArea(1, 5);

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

        JPanel centroAtPratoSSPanel = new JPanel();
        centroAtPratoSSPanel.setLayout(new GridLayout(6, 2));
        centroAtPratoSubPanel.add(centroAtPratoSSPanel);

        JPanel centroAtPratoSSPanel1 = new JPanel();
        centroAtPratoSSPanel1.setLayout(new GridLayout(1, 2));
        centroAtPratoSubPanel.add(centroAtPratoSSPanel1);

        centroAtPratoSSPanel.add(atNomePratoLabel);
        centroAtPratoSSPanel.add(atNomePratoText);
        centroAtPratoSSPanel.add(atDescricaoPratoLabel);
        centroAtPratoSSPanel.add(atDescricaoPratoText);
        centroAtPratoSSPanel1.add(atPrecoPratoLabel);
        centroAtPratoSSPanel1.add(atPrecoPratoText);

        sulAtPratoSubPanel.setLayout(new FlowLayout());
        sulAtPratoSubPanel.add(voltarMenuRestAtPratoButton);
        sulAtPratoSubPanel.add(confirmarAtPratoButton);

        voltarMenuRestAtPratoButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));
        confirmarAtPratoButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));
    }

    ///////////////////MENU RESTAURANTE - ACTUALIZAR DADOS /////////////////////////
    private void construirPanelMRestAtDados (JPanel mRestAtDadosSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestAtDadosSubPanel = new JPanel();
        norteMRestAtDadosSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestAtDadosSubPanel = new JPanel();
        JPanel sulMRestAtDadosSubPanel = new JPanel();

        JLabel atDadosRestLabel = new JLabel("ACTUALIZAR DADOS");
        JLabel nomeAtDadosRestLabel = new JLabel("Nome");
        JLabel emailAtDadosRestLabel = new JLabel("E-mail");
        JLabel moradaAtDadosRestLabel = new JLabel("Morada");
        JLabel cidadeAtDadosRestLabel = new JLabel("Cidade");
        JLabel telemovelAtDadosRestLabel = new JLabel("Telemóvel");
        JLabel lotacaoAtDadosRestLabel = new JLabel("Lotação:");
        JLabel esplanadaAtDadosRestLabel = new JLabel("Esplanada");
        JLabel zonaInteriorAtDadosRestLabel = new JLabel("Zona Interior:");
        JLabel zonaInteriorNFumAtDadosRestLabel = new JLabel("Ñ Fumadores");
        JLabel zonaInteriorFumAtDadosRestLabel = new JLabel("Fumadores");
        JLabel horariosAtDadosRestLabel = new JLabel("Horários:");
        JLabel horariosAlmocoAtDadosRestLabel = new JLabel("Almoço:");
        JLabel horarioAlmocoInicioAtDadosRestLabel = new JLabel("Início");
        JLabel horarioAlmocoFimAtDadosRestLabel = new JLabel("Fim");
        JLabel horariosJantarAtDadosRestLabel = new JLabel("Jantar:");
        JLabel horarioJantarInicioAtDadosRestLabel = new JLabel("Início");
        JLabel horarioJantarFimAtDadosRestLabel = new JLabel("Fim");
        JLabel usernameAtDadosRestLabel = new JLabel("Username");
        JLabel passwordAtDadosRestLabel = new JLabel("Password");
        JLabel novaPasswordAtDadosRestLabel = new JLabel("Nova Password");
        JLabel confirmarPasswordAtDadosRestLabel = new JLabel("Confirmar Nova Password");

        JTextField nomeAtDadosRestText = new JTextField(sistema.getRestauranteAtivo().getNome(), 18);
        nomeAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField emailAtDadosRestText = new JTextField(sistema.getRestauranteAtivo().getEmail(), 18);
        emailAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField moradaAtDadosRestText = new JTextField(sistema.getRestauranteAtivo().getMorada(), 20);
        moradaAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField cidadeAtDadosRestText = new JTextField(sistema.getRestauranteAtivo().getCidade(), 15);
        cidadeAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField telemovelAtDadosRestText = new JTextField(sistema.getRestauranteAtivo().getTelefone(), 8);
        telemovelAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
//        JTextField telemovelAtDadosRestText = new JFormattedTextField(mascaraTelemovel);
//        telemovelAtDadosRestText.setColumns(8);
        String esplanadaString = Integer.toString(sistema.getRestauranteAtivo().getLotacaoEsplanada());
        JTextField esplanadaAtDadosRestText = new JTextField(esplanadaString, 3);
        esplanadaAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        String zINFString = Integer.toString(sistema.getRestauranteAtivo().getLotacaoEsplanada());
        JTextField zonaInteriorNFumAtDadosRestText = new JTextField(zINFString, 3);
        zonaInteriorNFumAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        String zIFString = Integer.toString(sistema.getRestauranteAtivo().getLotacaoEsplanada());
        JTextField zonaInteriorFumAtDadosRestText = new JTextField(zIFString, 3);
        zonaInteriorFumAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        //TODO Tais ver com Magnus
//        String hAIString = "", hAFString = "", hJIString = "", hJFString = "";
//        DateLabelFormatter formatarHora = new DateLabelFormatter();
//        try {
//            hAIString = formatarHora.valueToString(sistema.getRestauranteAtivo().getInicioAlm());
//            hAFString = formatarHora.valueToString(sistema.getRestauranteAtivo().getInicioAlm());
//            hJIString = formatarHora.valueToString(sistema.getRestauranteAtivo().getInicioAlm());
//            hJFString = formatarHora.valueToString(sistema.getRestauranteAtivo().getInicioAlm());
//        } catch (ParseException parseException) {
//            parseException.printStackTrace();
//        }

        JTextField horarioAlmocoInicioAtDadosRestText = new JTextField(3);
        horarioAlmocoInicioAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioAlmocoFimAtDadosRestText = new JTextField(3);
        horarioAlmocoFimAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioJantarInicioAtDadosRestText = new JTextField(3);
        horarioJantarInicioAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField horarioJantarFimAtDadosRestText = new JTextField(3);
        horarioJantarFimAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JTextField usernameAtDadosRestText = new JTextField(sistema.getRestauranteAtivo().getUsername(), 20);
        usernameAtDadosRestText.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JPasswordField passwordAtDadosRestField = new JPasswordField(sistema.getRestauranteAtivo().getPassword(), 15);
        passwordAtDadosRestField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JPasswordField novaPasswordAtDadosRestField = new JPasswordField(15);
        novaPasswordAtDadosRestField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        JPasswordField confirmarPasswordAtDadosRestField = new JPasswordField(15);
        confirmarPasswordAtDadosRestField.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        JButton ptEnAtDadosRestButton = new JButton("PT/EN");
        JButton voltarMenuRestAtDadosRestButton = new JButton("MENU RESTAURANTE");
        JButton atDadosRestButton = new JButton("ACTUALIZAR");

        mRestAtDadosSuperPanel.add(norteMRestAtDadosSubPanel, "North");
        mRestAtDadosSuperPanel.add(centroMRestAtDadosSubPanel, "Center");
        mRestAtDadosSuperPanel.add(sulMRestAtDadosSubPanel, "South");

        JPanel norteAtDadosRestSSPanel = new JPanel();
        norteAtDadosRestSSPanel.setLayout(new FlowLayout());
        norteAtDadosRestSSPanel.add(atDadosRestLabel);
        norteMRestAtDadosSubPanel.add(norteAtDadosRestSSPanel, BorderLayout.CENTER);
        norteMRestAtDadosSubPanel.add(ptEnAtDadosRestButton, BorderLayout.EAST);

        JPanel centroAtDadosRestSSPanelForm1 = new JPanel();
        centroAtDadosRestSSPanelForm1.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm1, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm2 = new JPanel();
        centroAtDadosRestSSPanelForm2.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm2, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm2A = new JPanel();
        centroAtDadosRestSSPanelForm2A.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm2A, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm3 = new JPanel();
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm3, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm4 = new JPanel();
        centroAtDadosRestSSPanelForm4.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm4, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm5 = new JPanel();
        centroAtDadosRestSSPanelForm5.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm5, BorderLayout.WEST);

        JPanel centroAtDadosRestSSPanelForm6 = new JPanel();
        centroAtDadosRestSSPanelForm6.setLayout(new FlowLayout());
        centroMRestAtDadosSubPanel.add(centroAtDadosRestSSPanelForm6, BorderLayout.WEST);

        centroAtDadosRestSSPanelForm1.add(nomeAtDadosRestLabel);
        centroAtDadosRestSSPanelForm1.add(nomeAtDadosRestText);
        centroAtDadosRestSSPanelForm1.add(emailAtDadosRestLabel);
        centroAtDadosRestSSPanelForm1.add(emailAtDadosRestText);

        centroAtDadosRestSSPanelForm2.add(moradaAtDadosRestLabel);
        centroAtDadosRestSSPanelForm2.add(moradaAtDadosRestText);
        centroAtDadosRestSSPanelForm2A.add(cidadeAtDadosRestLabel);
        centroAtDadosRestSSPanelForm2A.add(cidadeAtDadosRestText);
        centroAtDadosRestSSPanelForm2A.add(telemovelAtDadosRestLabel);
        centroAtDadosRestSSPanelForm2A.add(telemovelAtDadosRestText);

        centroAtDadosRestSSPanelForm3.add(lotacaoAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(esplanadaAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(esplanadaAtDadosRestText);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorNFumAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorNFumAtDadosRestText);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorFumAtDadosRestLabel);
        centroAtDadosRestSSPanelForm3.add(zonaInteriorFumAtDadosRestText);

        centroAtDadosRestSSPanelForm4.add(horariosAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horariosAlmocoAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioAlmocoInicioAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioAlmocoInicioAtDadosRestText);
        centroAtDadosRestSSPanelForm4.add(horarioAlmocoFimAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioAlmocoFimAtDadosRestText);
        centroAtDadosRestSSPanelForm4.add(horariosJantarAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioJantarInicioAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioJantarInicioAtDadosRestText);
        centroAtDadosRestSSPanelForm4.add(horarioJantarFimAtDadosRestLabel);
        centroAtDadosRestSSPanelForm4.add(horarioJantarFimAtDadosRestText);

        centroAtDadosRestSSPanelForm5.add(usernameAtDadosRestLabel);
        centroAtDadosRestSSPanelForm5.add(usernameAtDadosRestText);

        centroAtDadosRestSSPanelForm5.add(passwordAtDadosRestLabel);
        centroAtDadosRestSSPanelForm5.add(passwordAtDadosRestField);
        centroAtDadosRestSSPanelForm6.add(novaPasswordAtDadosRestLabel);
        centroAtDadosRestSSPanelForm6.add(novaPasswordAtDadosRestField);
        centroAtDadosRestSSPanelForm6.add(confirmarPasswordAtDadosRestLabel);
        centroAtDadosRestSSPanelForm6.add(confirmarPasswordAtDadosRestField);

        sulMRestAtDadosSubPanel.setLayout(new FlowLayout());
        sulMRestAtDadosSubPanel.add(voltarMenuRestAtDadosRestButton);
        sulMRestAtDadosSubPanel.add(atDadosRestButton);

        voltarMenuRestAtDadosRestButton.addActionListener(e -> mostrarJanela(MENURESTAURANTE_CARD));

        atDadosRestButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

    }

    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS//////////
    private void construirPanelMRestReservas (JPanel mRestReservasSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestReservasSubPanel = new JPanel();
        norteMRestReservasSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestReservasSubPanel = new JPanel();
        JPanel sulMRestReservasSubPanel = new JPanel();

        JLabel mRestReservasLabel = new JLabel("HISTÓRICO DE RESERVAS");
        JRadioButton filtrarIntervDatasMRestResRButton = new JRadioButton("DATAS");
        //todo verificar a questão do calendário
        JRadioButton filtrarTipoMRestResRButton = new JRadioButton("TIPO");
        JRadioButton filtrarIntervValMRestResRButton = new JRadioButton("VALORES");
        JRadioButton filtrarClienteMRestResRButton = new JRadioButton("CLIENTE");

        ButtonGroup group = new ButtonGroup();
        group.add(filtrarIntervDatasMRestResRButton);
        group.add(filtrarTipoMRestResRButton);
        group.add(filtrarIntervValMRestResRButton);
        group.add(filtrarClienteMRestResRButton);

        JButton ptEnMRestReservasButton = new JButton("PT/EN");
        JButton voltarMRestReservasButton = new JButton("MENU RESTAURANTE");
        JButton okMRestReservasButton = new JButton("OK");

        mRestReservasSuperPanel.add(norteMRestReservasSubPanel, "North");
        mRestReservasSuperPanel.add(centroMRestReservasSubPanel, "Center");
        mRestReservasSuperPanel.add(sulMRestReservasSubPanel, "South");

        JPanel norteMRestReservasSSPanel = new JPanel();
        norteMRestReservasSSPanel.setLayout(new FlowLayout());
        norteMRestReservasSSPanel.add(mRestReservasLabel);
        norteMRestReservasSubPanel.add(norteMRestReservasSSPanel, BorderLayout.CENTER);
        norteMRestReservasSubPanel.add(ptEnMRestReservasButton, BorderLayout.EAST);

        JPanel centroMRestReservasSSPanel = new JPanel();
        centroMRestReservasSSPanel.setLayout(new FlowLayout());
        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel, BorderLayout.CENTER);

        JPanel centroMRestReservasSSPanel1 = new JPanel();
        centroMRestReservasSSPanel1.setLayout(new FlowLayout());
        centroMRestReservasSubPanel.add(centroMRestReservasSSPanel1, BorderLayout.WEST);

        centroMRestReservasSSPanel.add(filtrarIntervDatasMRestResRButton);
        centroMRestReservasSSPanel.add(filtrarTipoMRestResRButton);
        centroMRestReservasSSPanel.add(filtrarIntervValMRestResRButton);
        centroMRestReservasSSPanel.add(filtrarClienteMRestResRButton);

        sulMRestReservasSubPanel.setLayout(new FlowLayout());
        sulMRestReservasSubPanel.add(voltarMRestReservasButton);
        sulMRestReservasSubPanel.add(okMRestReservasButton);

        filtrarIntervDatasMRestResRButton.addActionListener(a -> mostrarJanela(MRESTRESERVASFID_CARD));

        filtrarTipoMRestResRButton.addActionListener(a -> mostrarJanela(MRESTRESERVASFTIPO_CARD));

        filtrarIntervValMRestResRButton.addActionListener(a -> mostrarJanela(MRESTRESERVASFIV_CARD));

        filtrarClienteMRestResRButton.addActionListener(a -> mostrarJanela(MRESTRESERVASFCLI_CARD));

        voltarMRestReservasButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));
    }


    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS – INTERVALO DATAS//////////
    private void construirPanelMRestReservasFID (JPanel mRestReservasFIDSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestReservasFIDSubPanel = new JPanel();
        norteMRestReservasFIDSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestReservasFIDSubPanel = new JPanel();
        JPanel sulMRestReservasFIDSubPanel = new JPanel();

        JLabel MRestReservasFIDLabel = new JLabel("HISTÓRICO DE RESERVAS - INTERVALO DATAS");
        JLabel filtrarDataInicioMRestReservasFIDLabel = new JLabel("De");
        JLabel filtrarDataFimMRestReservasFIDLabel = new JLabel("Até");

        JButton ptEnMRestReservasFIDButton = new JButton("PT/EN");
        JButton voltarMRestReservasFIDButton = new JButton("MENU RESTAURANTE");
        JButton retornarMRestReservasFIDButton = new JButton("VOLTAR");
        JButton pesquisarMRestReservasFIDButton = new JButton("PESQUISAR");

        //Adição do calendário
        UtilDateModel modelMRestReservasFID1 = new UtilDateModel();
        UtilDateModel modelMRestReservasFID2 = new UtilDateModel();

        ResourceBundle b = ResourceBundle.getBundle("Text");

        Properties p = convertResourceBundleToProperties(b);
        JDatePanelImpl datePanelMRestReservasFID = new JDatePanelImpl(modelMRestReservasFID1, p);
        JDatePickerImpl datePickerMRestReservasFID1 = new JDatePickerImpl(datePanelMRestReservasFID, new DateLabelFormatter());

        JDatePanelImpl datePanelMRestReservasFID1 = new JDatePanelImpl(modelMRestReservasFID2, p);
        JDatePickerImpl datePickerMRestReservasFID2 = new JDatePickerImpl(datePanelMRestReservasFID1, new DateLabelFormatter());

        mRestReservasFIDSuperPanel.add(norteMRestReservasFIDSubPanel, "North");
        mRestReservasFIDSuperPanel.add(centroMRestReservasFIDSubPanel, "Center");
        mRestReservasFIDSuperPanel.add(sulMRestReservasFIDSubPanel, "South");

        JPanel norteMRestReservasFIDSSPanel = new JPanel();
        norteMRestReservasFIDSSPanel.setLayout(new FlowLayout());
        norteMRestReservasFIDSSPanel.add(MRestReservasFIDLabel);
        norteMRestReservasFIDSubPanel.add(norteMRestReservasFIDSSPanel, BorderLayout.CENTER);
        norteMRestReservasFIDSubPanel.add(ptEnMRestReservasFIDButton, BorderLayout.EAST);

        JPanel centroMRestReservasFIDSSPanel = new JPanel();
        centroMRestReservasFIDSSPanel.setLayout(new FlowLayout());
        centroMRestReservasFIDSubPanel.add(centroMRestReservasFIDSSPanel, BorderLayout.WEST);

        JPanel centroMRestReservasFIDSSPanel2 = new JPanel();
        centroMRestReservasFIDSSPanel2.setLayout(new FlowLayout());
        centroMRestReservasFIDSubPanel.add(centroMRestReservasFIDSSPanel2, BorderLayout.WEST);

        centroMRestReservasFIDSSPanel3 = new JPanel();
        centroMRestReservasFIDSSPanel3.setLayout(new FlowLayout());
        centroMRestReservasFIDSubPanel.add(centroMRestReservasFIDSSPanel3, BorderLayout.CENTER);

        centroMRestReservasFIDSSPanel.add(filtrarDataInicioMRestReservasFIDLabel);
        centroMRestReservasFIDSSPanel.add(datePickerMRestReservasFID1);
        centroMRestReservasFIDSSPanel.add(filtrarDataFimMRestReservasFIDLabel);
        centroMRestReservasFIDSSPanel.add(datePickerMRestReservasFID2);
        centroMRestReservasFIDSSPanel2.add(pesquisarMRestReservasFIDButton);

        sulMRestReservasFIDSubPanel.setLayout(new FlowLayout());
        sulMRestReservasFIDSubPanel.add(voltarMRestReservasFIDButton);
        sulMRestReservasFIDSubPanel.add(retornarMRestReservasFIDButton);

        retornarMRestReservasFIDButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        voltarMRestReservasFIDButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

        //todo ver os encaminhamentos
        pesquisarMRestReservasFIDButton.addActionListener(e -> {
            GregorianCalendar data1 = (GregorianCalendar) datePickerMRestReservasFID1.getJFormattedTextField().getValue();
            GregorianCalendar data2 = (GregorianCalendar) datePickerMRestReservasFID2.getJFormattedTextField().getValue();
            if (data1 == null) {
                JOptionPane.showMessageDialog(((Component) e.getSource()).getParent(), "A data inicial deve ser preenchida");
                datePickerMRestReservasFID1.requestFocus();
            }
            if (data2 == null) {
                JOptionPane.showMessageDialog(((Component) e.getSource()).getParent(), "A data final deve ser preenchida");
                datePickerMRestReservasFID2.requestFocus();
            }
            //TODO o certo é pegar o restaurante ativo e a lista de reservas para aquele restaurante - o melhor era concentrar no sistema
            listaReserva = sistema.consultarReservasPorData(data1, data2);
            String[][] dadosMReservasFIDSSPanel = new String[listaReserva.size()][2];
            int i = 0;
            DateLabelFormatter dateFormatter = new DateLabelFormatter();
            for (Reserva r : listaReserva) {
                try {
                    dadosMReservasFIDSSPanel[i][0] = dateFormatter.dateTimeToString(r.getData());
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                dadosMReservasFIDSSPanel[i][1] = r.getCliente().getNome();
                i++;
            }

            String[] nomeColunasMRestReservasFIDSSPanel = new String[]{"DATA", "CLIENTE"};
            JTable tabelaMRestReservasFIDSSPanel = new JTable(dadosMReservasFIDSSPanel, nomeColunasMRestReservasFIDSSPanel);
            JScrollPane jscrollRestReservasFID = new JScrollPane(tabelaMRestReservasFIDSSPanel);
            centroMRestReservasFIDSSPanel3.add(jscrollRestReservasFID, BorderLayout.CENTER);
            mostrarJanela(MRESTRESERVASFID_CARD);
            JOptionPane.showMessageDialog(null, "Sem reservas registadas!");
        });
    }


    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS  - TIPO//////////
    private void construirPanelMRestReservasFTipo (JPanel mRestReservasFTipoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestReservasFTipoSubPanel = new JPanel();
        norteMRestReservasFTipoSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestReservasFTipoSubPanel = new JPanel();
        JPanel sulMRestReservasFTipoSubPanel = new JPanel();

        JLabel mRestReservasFTipoLabel = new JLabel("HISTÓRICO DE RESERVAS - TIPO");

        mRestReservasFTipoPJButton = new JRadioButton("Presencial");
        mRestReservasFTipoTAJButton = new JRadioButton("Take-Away");

        groupRadioTipoReserva = new ButtonGroup();
        groupRadioTipoReserva.add(mRestReservasFTipoPJButton);
        groupRadioTipoReserva.add(mRestReservasFTipoTAJButton);

        JButton ptEnMRestReservasFTipoButton = new JButton("PT/EN");
        JButton voltarMRestReservasFTipoButton = new JButton("MENU RESTAURANTE");
        JButton retornarMRestReservasFTipoButton = new JButton("VOLTAR");

        mRestReservasFTipoSuperPanel.add(norteMRestReservasFTipoSubPanel, "North");
        mRestReservasFTipoSuperPanel.add(centroMRestReservasFTipoSubPanel, "Center");
        mRestReservasFTipoSuperPanel.add(sulMRestReservasFTipoSubPanel, "South");

        JPanel norteMRestReservasFTipoSSPanel = new JPanel();
        norteMRestReservasFTipoSSPanel.setLayout(new FlowLayout());
        norteMRestReservasFTipoSSPanel.add(mRestReservasFTipoLabel);
        norteMRestReservasFTipoSubPanel.add(norteMRestReservasFTipoSSPanel, BorderLayout.CENTER);
        norteMRestReservasFTipoSubPanel.add(ptEnMRestReservasFTipoButton, BorderLayout.EAST);

        JPanel centroMRestReservasFTipoSSPanel = new JPanel();
        centroMRestReservasFTipoSSPanel.setLayout(new GridLayout(1, 1));
        centroMRestReservasFTipoSubPanel.add(centroMRestReservasFTipoSSPanel, BorderLayout.WEST);

        centroMRestReservasFTipoSSPanel.add(mRestReservasFTipoPJButton);
        centroMRestReservasFTipoSSPanel.add(mRestReservasFTipoTAJButton);

        sulMRestReservasFTipoSubPanel.setLayout(new FlowLayout());
        sulMRestReservasFTipoSubPanel.add(voltarMRestReservasFTipoButton);
        sulMRestReservasFTipoSubPanel.add(retornarMRestReservasFTipoButton);

        mRestReservasFTipoPJButton.addActionListener(a -> mostrarJanela(MRESTRESERVASFTIPOP_CARD));

        mRestReservasFTipoTAJButton.addActionListener(a -> mostrarJanela(MRESTRESERVASFTIPOTA_CARD));

        retornarMRestReservasFTipoButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        voltarMRestReservasFTipoButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));
    }

    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS  - TIPO PRESENCIAL//////////
    private void construirPanelMRestReservasFTipoP (JPanel mRestReservasFTipoPSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestReservasFTipoPSubPanel = new JPanel();
        norteMRestReservasFTipoPSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestReservasFTipoPSubPanel = new JPanel();
        JPanel sulMRestReservasFTipoPSubPanel = new JPanel();

        JLabel mRestReservasFTipoPLabel = new JLabel("HISTÓRICO DE RESERVAS - PRESENCIAL");

        String[] nomeColunasMRestReservasFTipoP = new String[]{"CLIENTE", "DATA", "N.PESSOAS"};

        //todo exemplo a verificar
        Object[][] dadosMRestReservasFTipoP = new Object[][]{
                {"CLIENTE", "DATA", "N.PESSOAS"},
                {null, null, null},
        };

        //criação da tabela
        JTable tabelaMRestReservasFTipoP = new JTable(dadosMRestReservasFTipoP, nomeColunasMRestReservasFTipoP);

        JButton ptEnMRestReservasFTipoPButton = new JButton("PT/EN");
        JButton voltarMRestReservasFTipoPButton = new JButton("MENU RESTAURANTE");
        JButton retornarMRestReservasFTipoPButton = new JButton("VOLTAR");
        JButton pesquisarMRestReservasFTipoPButton = new JButton("PESQUISAR");

        mRestReservasFTipoPSuperPanel.add(norteMRestReservasFTipoPSubPanel, "North");
        mRestReservasFTipoPSuperPanel.add(centroMRestReservasFTipoPSubPanel, "Center");
        mRestReservasFTipoPSuperPanel.add(sulMRestReservasFTipoPSubPanel, "South");

        JPanel norteMRestReservasFTipoPSSPanel = new JPanel();
        norteMRestReservasFTipoPSSPanel.setLayout(new FlowLayout());
        norteMRestReservasFTipoPSSPanel.add(mRestReservasFTipoPLabel);
        norteMRestReservasFTipoPSubPanel.add(norteMRestReservasFTipoPSSPanel, BorderLayout.CENTER);
        norteMRestReservasFTipoPSubPanel.add(ptEnMRestReservasFTipoPButton, BorderLayout.EAST);

        JPanel centroMRestReservasFTipoPSSPanel = new JPanel();
        centroMRestReservasFTipoPSSPanel.setLayout(new GridLayout(1, 1));
        centroMRestReservasFTipoPSubPanel.add(centroMRestReservasFTipoPSSPanel, BorderLayout.WEST);

        centroMRestReservasFTipoPSSPanel.add(tabelaMRestReservasFTipoP);

        sulMRestReservasFTipoPSubPanel.setLayout(new FlowLayout());
        sulMRestReservasFTipoPSubPanel.add(voltarMRestReservasFTipoPButton);
        sulMRestReservasFTipoPSubPanel.add(retornarMRestReservasFTipoPButton);
        sulMRestReservasFTipoPSubPanel.add(pesquisarMRestReservasFTipoPButton);

        retornarMRestReservasFTipoPButton.addActionListener(a -> mostrarJanela(MRESTRESERVASFTIPO_CARD));

        voltarMRestReservasFTipoPButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

        //todo ver os encaminhamentos
        pesquisarMRestReservasFTipoPButton.addActionListener(e -> mostrarJanela(MRESTRESERVASFTIPO_CARD));
    }


    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS  - TIPO TAKE-AWAY//////////
    private void construirPanelMRestReservasFTipoTA (JPanel mRestReservasFTipoTASuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestReservasFTipoTASubPanel = new JPanel();
        norteMRestReservasFTipoTASubPanel.setLayout(new BorderLayout());
        JPanel centroMRestReservasFTipoTASubPanel = new JPanel();
        JPanel sulMRestReservasFTipoTASubPanel = new JPanel();

        JLabel mRestReservasFTipoTALabel = new JLabel("HISTÓRICO DE RESERVAS – TAKE-AWAY");

        String[] nomeColunasMRestReservasFTipoTA = new String[]{"CLIENTE", "DATA", "PREÇO"};
        //TODO exemplo a verificar
        Object[][] dadosMRestReservasFTipoTA = new Object[][]{{"CLIENTE", "DATA", "PREÇO"}, {null, null, null},};

        //criação da tabela
        JTable tabelaMRestReservasFTipoTA = new JTable(dadosMRestReservasFTipoTA, nomeColunasMRestReservasFTipoTA);

        JButton ptEnMRestReservasFTipoTAButton = new JButton("PT/EN");
        JButton voltarMRestReservasFTipoTAButton = new JButton("MENU RESTAURANTE");
        JButton retornarMRestReservasFTipoTAButton = new JButton("VOLTAR");
        JButton pesquisarMRestReservasFTipoTAButton = new JButton("PESQUISAR");

        mRestReservasFTipoTASuperPanel.add(norteMRestReservasFTipoTASubPanel, "North");
        mRestReservasFTipoTASuperPanel.add(centroMRestReservasFTipoTASubPanel, "Center");
        mRestReservasFTipoTASuperPanel.add(sulMRestReservasFTipoTASubPanel, "South");

        JPanel norteMRestReservasFTipoTASSPanel = new JPanel();
        norteMRestReservasFTipoTASSPanel.setLayout(new FlowLayout());
        norteMRestReservasFTipoTASSPanel.add(mRestReservasFTipoTALabel);
        norteMRestReservasFTipoTASubPanel.add(norteMRestReservasFTipoTASSPanel, BorderLayout.CENTER);
        norteMRestReservasFTipoTASubPanel.add(ptEnMRestReservasFTipoTAButton, BorderLayout.EAST);

        JPanel centroMRestReservasFTipoTASSPanel = new JPanel();
        centroMRestReservasFTipoTASSPanel.setLayout(new FlowLayout());
        centroMRestReservasFTipoTASubPanel.add(centroMRestReservasFTipoTASSPanel, BorderLayout.WEST);

        centroMRestReservasFTipoTASSPanel.add(tabelaMRestReservasFTipoTA);

        sulMRestReservasFTipoTASubPanel.setLayout(new FlowLayout());
        sulMRestReservasFTipoTASubPanel.add(voltarMRestReservasFTipoTAButton);
        sulMRestReservasFTipoTASubPanel.add(retornarMRestReservasFTipoTAButton);
        sulMRestReservasFTipoTASubPanel.add(pesquisarMRestReservasFTipoTAButton);

        retornarMRestReservasFTipoTAButton.addActionListener(a -> mostrarJanela(MRESTRESERVASFTIPO_CARD));

        voltarMRestReservasFTipoTAButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

        //todo ver os encaminhamentos
        pesquisarMRestReservasFTipoTAButton.addActionListener(e -> mostrarJanela(MRESTRESERVASFTIPO_CARD));
    }


    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS – INTERVALO DE VALORES //////////
    private void construirPanelMRestReservasFIV (JPanel mRestReservasFIVSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestReservasFIVSubPanel = new JPanel();
        norteMRestReservasFIVSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestReservasFIVSubPanel = new JPanel();
        JPanel sulMRestReservasFIVSubPanel = new JPanel();

        JLabel mRestReservasFIVLabel = new JLabel("HISTÓRICO DE RESERVAS - INTERVALO DE VALORES");

        JRadioButton quinzeMRestReservasFIVRButton = new JRadioButton("Até 15");
        JRadioButton quinzeVinteCincoMRestReservasFIVRButton = new JRadioButton("15-25");
        JRadioButton vinteCincoTrintaCincoMRestReservasFIVRButton = new JRadioButton("25-35");
        JRadioButton trintaCincoMRestReservasFIVRButton = new JRadioButton("+ de 35");

        ButtonGroup group = new ButtonGroup();
        group.add(quinzeMRestReservasFIVRButton);
        group.add(quinzeVinteCincoMRestReservasFIVRButton);
        group.add(vinteCincoTrintaCincoMRestReservasFIVRButton);
        group.add(trintaCincoMRestReservasFIVRButton);

        JButton ptEnMRestReservasFIVButton = new JButton("PT/EN");
        JButton voltarMRestReservasFIVButton = new JButton("MENU RESTAURANTE");
        JButton retornarMRestReservasFIVButton = new JButton("VOLTAR");
        JButton pesquisarMRestReservasFIVButton = new JButton("PESQUISAR");

        mRestReservasFIVSuperPanel.add(norteMRestReservasFIVSubPanel, "North");
        mRestReservasFIVSuperPanel.add(centroMRestReservasFIVSubPanel, "Center");
        mRestReservasFIVSuperPanel.add(sulMRestReservasFIVSubPanel, "South");

        JPanel norteMRestReservasFIVSSPanel = new JPanel();
        norteMRestReservasFIVSSPanel.setLayout(new FlowLayout());
        norteMRestReservasFIVSSPanel.add(mRestReservasFIVLabel);
        norteMRestReservasFIVSubPanel.add(norteMRestReservasFIVSSPanel, BorderLayout.CENTER);
        norteMRestReservasFIVSubPanel.add(ptEnMRestReservasFIVButton, BorderLayout.EAST);

        JPanel centroMRestReservasFIVSSPanel = new JPanel();
        centroMRestReservasFIVSSPanel.setLayout(new FlowLayout());
        centroMRestReservasFIVSubPanel.add(centroMRestReservasFIVSSPanel, BorderLayout.WEST);

        centroMRestReservasFIVSSPanel.add(quinzeMRestReservasFIVRButton);
        centroMRestReservasFIVSSPanel.add(quinzeVinteCincoMRestReservasFIVRButton);
        centroMRestReservasFIVSSPanel.add(vinteCincoTrintaCincoMRestReservasFIVRButton);
        centroMRestReservasFIVSSPanel.add(trintaCincoMRestReservasFIVRButton);

        sulMRestReservasFIVSubPanel.setLayout(new FlowLayout());
        sulMRestReservasFIVSubPanel.add(voltarMRestReservasFIVButton);
        sulMRestReservasFIVSubPanel.add(retornarMRestReservasFIVButton);
        sulMRestReservasFIVSubPanel.add(pesquisarMRestReservasFIVButton);

        quinzeMRestReservasFIVRButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        quinzeVinteCincoMRestReservasFIVRButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        vinteCincoTrintaCincoMRestReservasFIVRButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        trintaCincoMRestReservasFIVRButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        retornarMRestReservasFIVButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        voltarMRestReservasFIVButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

        //TODO ver os encaminhamentos
        pesquisarMRestReservasFIVButton.addActionListener(e -> mostrarJanela(MRESTRESERVASFIV_CARD));
    }

    /**
     * Convert ResourceBundle into a Properties object.
     *
     * @param resource a resource bundle to convert.
     * @return Properties a properties version of the resource bundle.
     */

    private static Properties convertResourceBundleToProperties (ResourceBundle resource){
        Properties properties = new Properties();
        Enumeration<String> keys = resource.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            properties.put(key, resource.getString(key));
        }
        return properties;
    }


    //////MENU RESTAURANTE – HISTÓRICO DE RESERVAS - CLIENTE//////////
    private void construirPanelMRestReservasFCli (JPanel mRestReservasFCliSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestReservasFCliSubPanel = new JPanel();
        norteMRestReservasFCliSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestReservasFCliSubPanel = new JPanel();
        JPanel sulMRestReservasFCliSubPanel = new JPanel();

        JLabel MRestReservasFCliLabel = new JLabel("HISTÓRICO DE RESERVAS - CLIENTE");
        JLabel usernameMRestReservasFCliLabel = new JLabel("Nome");

        JTextField usernameMRestReservasFCliText = new JTextField(20);

        JButton ptEnMRestReservasFCliButton = new JButton("PT/EN");
        JButton voltarMRestReservasFCliButton = new JButton("MENU RESTAURANTE");
        JButton retornarMRestReservasFCliButton = new JButton("VOLTAR");
        JButton pesquisarMRestReservasFCliButton = new JButton("PESQUISAR");

        mRestReservasFCliSuperPanel.add(norteMRestReservasFCliSubPanel, "North");
        mRestReservasFCliSuperPanel.add(centroMRestReservasFCliSubPanel, "Center");
        mRestReservasFCliSuperPanel.add(sulMRestReservasFCliSubPanel, "South");

        JPanel norteMRestReservasFCliSSPanel = new JPanel();
        norteMRestReservasFCliSSPanel.setLayout(new FlowLayout());
        norteMRestReservasFCliSSPanel.add(MRestReservasFCliLabel);
        norteMRestReservasFCliSubPanel.add(norteMRestReservasFCliSSPanel, BorderLayout.CENTER);
        norteMRestReservasFCliSubPanel.add(ptEnMRestReservasFCliButton, BorderLayout.EAST);

        JPanel centroMRestReservasFCliSSPanel = new JPanel();
        centroMRestReservasFCliSSPanel.setLayout(new FlowLayout());
        centroMRestReservasFCliSubPanel.add(centroMRestReservasFCliSSPanel, BorderLayout.WEST);

        centroMRestReservasFCliSSPanel.add(usernameMRestReservasFCliLabel);
        centroMRestReservasFCliSSPanel.add(usernameMRestReservasFCliText);

        sulMRestReservasFCliSubPanel.setLayout(new FlowLayout());
        sulMRestReservasFCliSubPanel.add(voltarMRestReservasFCliButton);
        sulMRestReservasFCliSubPanel.add(retornarMRestReservasFCliButton);
        sulMRestReservasFCliSubPanel.add(pesquisarMRestReservasFCliButton);

        voltarMRestReservasFCliButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

        retornarMRestReservasFCliButton.addActionListener(a -> mostrarJanela(MRESTRESERV_CARD));

        //todo ver os encaminhamentos
        pesquisarMRestReservasFCliButton.addActionListener(e -> mostrarJanela(MRESTRESERV_CARD));
    }


    //////MENU RESTAURANTE – COMENTÁRIOS//////////
    private void construirPanelMRestComentarios (JPanel mRestComentariosSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMRestComentariosSubPanel = new JPanel();
        norteMRestComentariosSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestComentariosSubPanel = new JPanel();
        JPanel sulMRestComentariosSubPanel = new JPanel();

        JLabel mRestComentariosLabel = new JLabel("COMENTÁRIOS RECEBIDOS");

        String[] nomeColunasMRestComentarios = new String[]{"RESTAURANTE", "CLIENTE", "COMENTÁRIO", "PONTUAÇÃO"};

        //TODO exemplo a verificar
        Object[][] dadosMRestComentariosCBox = new Object[][]{
                {"RESTAURANTE", "CLIENTE", "COMENTÁRIO", "PONTUAÇÃO"},
                {null, null, null, null},
                {null, null, null, null},
        };
        //criação da tabela
        JTable tabelaMRestComentarios = new JTable(dadosMRestComentariosCBox, nomeColunasMRestComentarios);

        JButton ptEnMRestReservasButton = new JButton("PT/EN");
        JButton voltarMRestComentariosButton = new JButton("MENU RESTAURANTE");
        JButton responderMRestComentariosButton = new JButton("RESPONDER");

        mRestComentariosSuperPanel.add(norteMRestComentariosSubPanel, "North");
        mRestComentariosSuperPanel.add(centroMRestComentariosSubPanel, "Center");
        mRestComentariosSuperPanel.add(sulMRestComentariosSubPanel, "South");

        JPanel norteMRestComentariosSSPanel = new JPanel();
        norteMRestComentariosSSPanel.setLayout(new FlowLayout());
        norteMRestComentariosSSPanel.add(mRestComentariosLabel);
        norteMRestComentariosSubPanel.add(norteMRestComentariosSSPanel, BorderLayout.CENTER);
        norteMRestComentariosSubPanel.add(ptEnMRestReservasButton, BorderLayout.EAST);

        JPanel centroMRestComentariosSSPanel = new JPanel();
        centroMRestComentariosSSPanel.setLayout(new FlowLayout());
        centroMRestComentariosSubPanel.add(centroMRestComentariosSSPanel, BorderLayout.WEST);

        centroMRestComentariosSSPanel.add(tabelaMRestComentarios);

        sulMRestComentariosSubPanel.setLayout(new FlowLayout());
        sulMRestComentariosSubPanel.add(voltarMRestComentariosButton);
        sulMRestComentariosSubPanel.add(responderMRestComentariosButton);

        voltarMRestComentariosButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

        //todo ver os encaminhamentos para responder comentário
        responderMRestComentariosButton.addActionListener(e -> mostrarJanela(MENURESTAURANTE_CARD));

    }

    //////MENU RESTAURANTE – PONTUAÇÃO MÉDIA//////////
    private void construirPanelMRestPMed (JPanel mRestPMedSuperPanel){


        /////SUBPAINEIS//////
        JPanel norteMRestPMedSubPanel = new JPanel();
        norteMRestPMedSubPanel.setLayout(new BorderLayout());
        JPanel centroMRestPMedSubPanel = new JPanel();
        JPanel sulMRestPMedSubPanel = new JPanel();

        JLabel mRestPMedLabel = new JLabel("PONTUAÇÃO MÉDIA");

        String[] nomeColunasMRestPMed = new String[]{
                "ID", "RESTAURANTE", "PONTUAÇÃO"
        };

        //todo exemplo a verificar
        Object[][] dados = new Object[][]{
                {"ID", "RESTAURANTE", "PONTUAÇÃO"},
                {1, "A", 4.0},
                {2, "B", 5.0},
                {3, "C", 3.0},
        };
        //criação da tabela
        JTable tabelaMRESTPMed = new JTable(dados, nomeColunasMRestPMed);

        JButton ptEnMRestPMedButton = new JButton("PT/EN");
        JButton voltarMRestPMedButton = new JButton("MENU RESTAURANTE");
        JButton pesquisarMRestPMedButton = new JButton("PESQUISAR");

        mRestPMedSuperPanel.add(norteMRestPMedSubPanel, "North");
        mRestPMedSuperPanel.add(centroMRestPMedSubPanel, "Center");
        mRestPMedSuperPanel.add(sulMRestPMedSubPanel, "South");

        JPanel norteMRestPMedSSPanel = new JPanel();
        norteMRestPMedSSPanel.setLayout(new FlowLayout());
        norteMRestPMedSSPanel.add(mRestPMedLabel);
        norteMRestPMedSubPanel.add(norteMRestPMedSSPanel, BorderLayout.CENTER);
        norteMRestPMedSubPanel.add(ptEnMRestPMedButton, BorderLayout.EAST);

        JPanel centroMRestPMedSSPanel1 = new JPanel();
        centroMRestPMedSSPanel1.setLayout(new FlowLayout());
        centroMRestPMedSubPanel.add(centroMRestPMedSSPanel1, BorderLayout.WEST);

        centroMRestPMedSSPanel1.add(tabelaMRESTPMed);

        sulMRestPMedSubPanel.setLayout(new FlowLayout());
        sulMRestPMedSubPanel.add(voltarMRestPMedButton);
        sulMRestPMedSubPanel.add(pesquisarMRestPMedButton);

        voltarMRestPMedButton.addActionListener(a -> mostrarJanela(MENURESTAURANTE_CARD));

        //todo ver os encaminhamentos para responder comentário
        pesquisarMRestPMedButton.addActionListener(e -> {
            mostrarJanela(LOGIN_CARD, usernameLoginText, passwordLoginField);
            this.setSize(LARGURA_LOGIN, ALTURA_LOGIN);
        });

    }

    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTROS//////////
    private void construirPanelMCliMRestFOrdRests (JPanel mCliMRestFOrdRestsSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestFOrdRestsSubPanel = new JPanel();
        norteMCliMRestFOrdRestsSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFOrdRestsSubPanel = new JPanel();
        JPanel sulMCliMRestFOrdRestsSubPanel = new JPanel();

        JLabel mCliMRestFOrdRestsLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");

        JLabel fMCliMRestFOrdRestsLabel = new JLabel("FILTRAR:");
        JButton fhoraFMCliMRestFOrdRestsButton = new JButton("HORA DE FUNCIONAMENTO");
        JButton fLotMCliMRestFOrdRestsButton = new JButton("LOTAÇÃO");
        JButton fCidCliMRestFOrdRestsButton = new JButton("CIDADE");

        JLabel fOrdMCliMRestsFOrdRestLabel = new JLabel("FILTRAR/ORDENAR:");
        JButton fOrdPontMCliMRestFOrdRestsButton = new JButton("PONTUAÇÃO");
        JButton fOrdValoresMCliMRestFOrdRestsButton = new JButton("VALORES MÉDIOS DOS PRATOS");

        JButton ptEnMCliMRestFOrdRestsButton = new JButton("PT/EN");
        JButton voltarMCliMRestsFOrdRestButton = new JButton("MENU CLIENTE");

        mCliMRestFOrdRestsSuperPanel.add(norteMCliMRestFOrdRestsSubPanel, "North");
        mCliMRestFOrdRestsSuperPanel.add(centroMCliMRestFOrdRestsSubPanel, "Center");
        mCliMRestFOrdRestsSuperPanel.add(sulMCliMRestFOrdRestsSubPanel, "South");

        JPanel norteMCliMRestFOrdRestsSSPanel = new JPanel();
        norteMCliMRestFOrdRestsSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFOrdRestsSSPanel.add(mCliMRestFOrdRestsLabel);
        norteMCliMRestFOrdRestsSubPanel.add(norteMCliMRestFOrdRestsSSPanel, BorderLayout.CENTER);
        norteMCliMRestFOrdRestsSubPanel.add(ptEnMCliMRestFOrdRestsButton, BorderLayout.EAST);

        JPanel centroMCliMRestFOrdRestsSSPanel = new JPanel();
        centroMCliMRestFOrdRestsSSPanel.setLayout(new GridLayout(8, 1));
        centroMCliMRestFOrdRestsSubPanel.add(centroMCliMRestFOrdRestsSSPanel);

        JPanel centroMCliMRestFOrdRestsSSPanel1 = new JPanel();
        centroMCliMRestFOrdRestsSSPanel1.setLayout(new FlowLayout());
        centroMCliMRestFOrdRestsSubPanel.add(centroMCliMRestFOrdRestsSSPanel1);

        centroMCliMRestFOrdRestsSSPanel.add(fMCliMRestFOrdRestsLabel);
        centroMCliMRestFOrdRestsSSPanel.add(fhoraFMCliMRestFOrdRestsButton);
        centroMCliMRestFOrdRestsSSPanel.add(fLotMCliMRestFOrdRestsButton);
        centroMCliMRestFOrdRestsSSPanel.add(fCidCliMRestFOrdRestsButton);
        centroMCliMRestFOrdRestsSSPanel.add(fOrdMCliMRestsFOrdRestLabel);
        centroMCliMRestFOrdRestsSSPanel.add(fOrdPontMCliMRestFOrdRestsButton);
        centroMCliMRestFOrdRestsSSPanel.add(fOrdValoresMCliMRestFOrdRestsButton);

        sulMCliMRestFOrdRestsSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFOrdRestsSubPanel.add(voltarMCliMRestsFOrdRestButton);


        fhoraFMCliMRestFOrdRestsButton.addActionListener(a -> mostrarJanela(MCLIMRESTFRESTHFUNC_CARD));

        fLotMCliMRestFOrdRestsButton.addActionListener(a -> mostrarJanela(MCLIMRESTFRESTLOT_CARD));

        fCidCliMRestFOrdRestsButton.addActionListener(a -> mostrarJanela(MCLIMRESTFRESTCID_CARD));

        //TODO TAIS NOVO verificar
        fOrdPontMCliMRestFOrdRestsButton.addActionListener(a -> {
            ArrayList<Restaurante> listasRestPont = sistema.consultarRestaurantesPorOrdemPontuacao();
            if (listasRestPont != null && !listasRestPont.isEmpty()) {
                String[][] dadosMCliMRestFRestPontSSPanel = new String[listasRestPont.size()][2];
                int i = 0;
                for (Restaurante ret : listasRestPont) {
                    dadosMCliMRestFRestPontSSPanel[i][0] = ret.getNome();
                    dadosMCliMRestFRestPontSSPanel[i][1] = "" + sistema.getPontuacaoMediaRestaurante(ret); //converte o double para String
                    i++;
                }

                String[] nomeColunasMCliMRestFRestPontSSPanel = new String[]{"RESTAURANTE", "PONTUAÇÃO"};
                JTable tabelaMCliMRestFRestPontSSPanel = new JTable(dadosMCliMRestFRestPontSSPanel, nomeColunasMCliMRestFRestPontSSPanel);
                JScrollPane jScrollnomeColunasMCliMRestFRestPont = new JScrollPane(tabelaMCliMRestFRestPontSSPanel);
                tabelaMCliMRestFRestPontSSPanel.setSize(10, 10);
                tabelaMCliMRestFRestPontSSPanel.setVisible(true);
                centroMCliMRestFRestPontSSPanel1.add(jScrollnomeColunasMCliMRestFRestPont, BorderLayout.CENTER);

                mostrarJanela(MCLIMRESTFRESTPONT_CARD);
            } else {
                JOptionPane.showMessageDialog(null, "Sem restaurante registado");
            }

        });

        voltarMCliMRestsFOrdRestButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }


    //////MENU CLIENTE – RESTAURANTES – FILTRAR POR PONTUAÇÃO//////////
    private void construirPanelMCliMRestFRestPont (JPanel mCliMRestFRestPontSuperPanel) {


        /////SUBPAINEIS//////
        JPanel norteMCliMRestFRestPontSubPanel = new JPanel();
        norteMCliMRestFRestPontSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFRestPontSubPanel = new JPanel();
        centroMCliMRestFRestPontSubPanel.setLayout(new BorderLayout());
        JPanel sulMCliMRestFRestPontSubPanel = new JPanel();

        JLabel mCliMRestsFRestPontLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel mCliMRestFRestPontLabel = new JLabel("PONTUAÇÃO");

        JButton ptEnMCliMRestFRestPontButton = new JButton("PT/EN");
        JButton voltarMCliMRestFRestPontButton = new JButton("MENU CLIENTE");
        JButton retonarMCliMRestFRestPontButton = new JButton("VOLTAR");

        mCliMRestFRestPontSuperPanel.add(norteMCliMRestFRestPontSubPanel, "North");
        mCliMRestFRestPontSuperPanel.add(centroMCliMRestFRestPontSubPanel, "Center");
        mCliMRestFRestPontSuperPanel.add(sulMCliMRestFRestPontSubPanel, "South");

        JPanel norteMCliMRestFRestPontSSPanel = new JPanel();
        norteMCliMRestFRestPontSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFRestPontSSPanel.add(mCliMRestsFRestPontLabel);
        norteMCliMRestFRestPontSubPanel.add(norteMCliMRestFRestPontSSPanel, BorderLayout.CENTER);
        norteMCliMRestFRestPontSubPanel.add(ptEnMCliMRestFRestPontButton, BorderLayout.EAST);

        centroMCliMRestFRestPontSSPanel1 = new JPanel();
        centroMCliMRestFRestPontSSPanel1.setLayout(new FlowLayout());
        centroMCliMRestFRestPontSubPanel.add(centroMCliMRestFRestPontSSPanel1);

        sulMCliMRestFRestPontSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFRestPontSubPanel.add(voltarMCliMRestFRestPontButton);
        sulMCliMRestFRestPontSubPanel.add(retonarMCliMRestFRestPontButton);

        retonarMCliMRestFRestPontButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));
        voltarMCliMRestFRestPontButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTROS – VALORES MÉDIOS DOS PRATOS//////////
    private void construirPanelMCliMRestFOrdRestValor (JPanel mCliMRestFOrdRestValorSuperPanel){


        /////SUBPAINEIS//////
        JPanel norteMCliMRestFOrdRestValorSubPanel = new JPanel();
        norteMCliMRestFOrdRestValorSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFOrdRestValorSubPanel = new JPanel();
        JPanel sulMCliMRestFOrdRestValorSubPanel = new JPanel();

        JLabel mCliMRestFOrdRestsValorLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel mCliMRestFOrdRestValorLabel = new JLabel("VALORES MÉDIOS DOS PRATOS");
        JLabel demCliMRestFOrdRestValorLabel = new JLabel("De");
        JLabel atemCliMRestFOrdRestValorLabel = new JLabel("Até");

        demCliMRestFOrdRestValorText = new JTextField(5);
        atemCliMRestFOrdRestValorText = new JTextField(5);

        JRadioButton fOrdValoresCartaMCliMRestFOrdRestValorRButton = new JRadioButton("CARTA");
        JRadioButton fOrdValoresPDiaMCliMRestFOrdRestValorRButton = new JRadioButton("PRATOS DO DIA");

        ButtonGroup group = new ButtonGroup();
        group.add(fOrdValoresCartaMCliMRestFOrdRestValorRButton);
        group.add(fOrdValoresPDiaMCliMRestFOrdRestValorRButton);

        JButton ptEnMCliMRestFOrdRestValorButton = new JButton("PT/EN");
        JButton voltarMCliMRestFOrdRestValorutton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFOrdRestValorButton = new JButton("VOLTAR");

        mCliMRestFOrdRestValorSuperPanel.add(norteMCliMRestFOrdRestValorSubPanel, "North");
        mCliMRestFOrdRestValorSuperPanel.add(centroMCliMRestFOrdRestValorSubPanel, "Center");
        mCliMRestFOrdRestValorSuperPanel.add(sulMCliMRestFOrdRestValorSubPanel, "South");

        JPanel norteMCliMRestFOrdRestValorSSPanel = new JPanel();
        norteMCliMRestFOrdRestValorSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFOrdRestValorSSPanel.add(mCliMRestFOrdRestsValorLabel);
        norteMCliMRestFOrdRestValorSubPanel.add(norteMCliMRestFOrdRestValorSSPanel, BorderLayout.CENTER);
        norteMCliMRestFOrdRestValorSubPanel.add(ptEnMCliMRestFOrdRestValorButton, BorderLayout.EAST);

        JPanel centroMCliMRestFOrdRestValorSSPanel = new JPanel();
        centroMCliMRestFOrdRestValorSSPanel.setLayout(new GridLayout(3, 1));
        centroMCliMRestFOrdRestValorSubPanel.add(centroMCliMRestFOrdRestValorSSPanel);

        JPanel centroMCliMRestFOrdRestValorSSPanel1 = new JPanel();
        centroMCliMRestFOrdRestValorSSPanel1.setLayout(new FlowLayout());
        centroMCliMRestFOrdRestValorSubPanel.add(centroMCliMRestFOrdRestValorSSPanel1);

        JPanel centroMCliMRestFOrdRestValorSSPanel2 = new JPanel();
        centroMCliMRestFOrdRestValorSSPanel2.setLayout(new GridBagLayout());
        centroMCliMRestFOrdRestValorSubPanel.add(centroMCliMRestFOrdRestValorSSPanel2);

        centroMCliMRestFOrdRestValorSSPanel.add(mCliMRestFOrdRestValorLabel);
        centroMCliMRestFOrdRestValorSSPanel1.add(demCliMRestFOrdRestValorLabel);
        centroMCliMRestFOrdRestValorSSPanel1.add(demCliMRestFOrdRestValorText);
        centroMCliMRestFOrdRestValorSSPanel1.add(atemCliMRestFOrdRestValorLabel);
        centroMCliMRestFOrdRestValorSSPanel1.add(atemCliMRestFOrdRestValorText);
        centroMCliMRestFOrdRestValorSSPanel2.add(fOrdValoresCartaMCliMRestFOrdRestValorRButton);
        centroMCliMRestFOrdRestValorSSPanel2.add(fOrdValoresPDiaMCliMRestFOrdRestValorRButton);

        sulMCliMRestFOrdRestValorSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFOrdRestValorSubPanel.add(voltarMCliMRestFOrdRestValorutton);
        sulMCliMRestFOrdRestValorSubPanel.add(retornarMCliMRestFOrdRestValorButton);

        fOrdValoresCartaMCliMRestFOrdRestValorRButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTVALORCARTA_CARD));

        fOrdValoresPDiaMCliMRestFOrdRestValorRButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTVALORPDIA_CARD));

        retornarMCliMRestFOrdRestValorButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));
        voltarMCliMRestFOrdRestValorutton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }


    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTRAR POR VALORES MÉDIOS DOS PRATOS - CARTA//////////
    private void construirPanelMCliMRestFOrdRestValorCarta (JPanel mCliMRestFOrdRestValorCartaSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestFOrdRestValorCartaSubPanel = new JPanel();
        norteMCliMRestFOrdRestValorCartaSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFOrdRestValorCartaSubPanel = new JPanel();
        JPanel sulMCliMRestFOrdRestValorCartaSubPanel = new JPanel();

        JLabel mCliMRestFOrdRestsValorCartaLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel mCliMRestFOrdRestValorCartaLabel = new JLabel("VALORES MÉDIOS DOS PRATOS - CARTA");

        JButton ptEnMCliMRestFOrdRestValorCartaButton = new JButton("PT/EN");
        JButton voltarMCliMRestFOrdRestValorCartaButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFOrdRestValorCartaButton = new JButton("VOLTAR");

//            ArrayList<Restaurante> listasValoresCarta = sistema.consultarRestaurantePorValores(demCliMRestFOrdRestValorText.getText(), atemCliMRestFOrdRestValorText.getText());
//            if (listasValoresCarta != null && !listasValoresCarta.isEmpty()) {
//                String[][] dadosMCliMRestFOrdRestValorCartaSSPanel = new String[listasValoresCarta.size()][3];
//                int i = 0;
//                for (Restaurante resrte : listasValoresCarta) {
//                    dadosMCliMRestFOrdRestValorCartaSSPanel[i][0] = resrte.getNome();
//                    dadosMCliMRestFOrdRestValorCartaSSPanel[i][1] = resrte.getCidade();
//                    dadosMCliMRestFOrdRestValorCartaSSPanel[i][2] = "" + resrte.getPrecoMedioRestaurante();
//                    i++;
//                }
//
//                String[] nomeColunasMCliMRestFOrdRestValorCartaSSPanel = new String[]{"RESTAURANTE", "CIDADE", "PREÇOS MÉDIOS"};
//                JTable tabelaMCliMRestFOrdRestValorCartaSSPanel = new JTable(dadosMCliMRestFOrdRestValorCartaSSPanel, nomeColunasMCliMRestFOrdRestValorCartaSSPanel);
//                JScrollPane jScrollMCliMRestFOrdRestValorCarta = new JScrollPane(tabelaMCliMRestFOrdRestValorCartaSSPanel);
//                tabelaMCliMRestFOrdRestValorCartaSSPanel.setVisible(true);
//                centroMCliMRestFOrdRestValorCartaResultadoSSPanel1.add(jScrollMCliMRestFOrdRestValorCarta, BorderLayout.CENTER);
//            } else {
//                JOptionPane.showMessageDialog(null, "Sem registo nos valores informados!");
//            }

        mCliMRestFOrdRestValorCartaSuperPanel.add(norteMCliMRestFOrdRestValorCartaSubPanel, "North");
        mCliMRestFOrdRestValorCartaSuperPanel.add(centroMCliMRestFOrdRestValorCartaSubPanel, "Center");
        mCliMRestFOrdRestValorCartaSuperPanel.add(sulMCliMRestFOrdRestValorCartaSubPanel, "South");

        JPanel norteMCliMRestFOrdRestValorCartaSSPanel = new JPanel();
        norteMCliMRestFOrdRestValorCartaSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFOrdRestValorCartaSSPanel.add(mCliMRestFOrdRestsValorCartaLabel);
        norteMCliMRestFOrdRestValorCartaSubPanel.add(norteMCliMRestFOrdRestValorCartaSSPanel, BorderLayout.CENTER);
        norteMCliMRestFOrdRestValorCartaSubPanel.add(ptEnMCliMRestFOrdRestValorCartaButton, BorderLayout.EAST);

        JPanel centroMCliMRestFOrdRestValorCartaSSPanel = new JPanel();
        centroMCliMRestFOrdRestValorCartaSSPanel.setLayout(new GridLayout(1, 2));
        centroMCliMRestFOrdRestValorCartaSubPanel.add(centroMCliMRestFOrdRestValorCartaSSPanel);

        JPanel centroMCliMRestFOrdRestValorCartaSSPanel1 = new JPanel();
        centroMCliMRestFOrdRestValorCartaSSPanel1.setLayout(new GridBagLayout());
        centroMCliMRestFOrdRestValorCartaSubPanel.add(centroMCliMRestFOrdRestValorCartaSSPanel1);

        centroMCliMRestFOrdRestValorCartaSSPanel.add(mCliMRestFOrdRestValorCartaLabel);

        sulMCliMRestFOrdRestValorCartaSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFOrdRestValorCartaSubPanel.add(voltarMCliMRestFOrdRestValorCartaButton);
        sulMCliMRestFOrdRestValorCartaSubPanel.add(retornarMCliMRestFOrdRestValorCartaButton);

        retornarMCliMRestFOrdRestValorCartaButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTVALOR_CARD));

        voltarMCliMRestFOrdRestValorCartaButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }


    //////MENU RESTAURANTE – RESTAURANTES – MENU FILTRAR POR VALORES MÉDIOS DOS PRATOS - Carta - RESULTADO//////////
    private void construirPanelMCliMRestFOrdRestValorCartaResultado (JPanel
                                                                             mCliMRestFOrdRestValorCartaResultadoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestFOrdRestValorCartaResultadoSubPanel = new JPanel();
        norteMCliMRestFOrdRestValorCartaResultadoSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFOrdRestValorCartaResultadoSubPanel = new JPanel();
        JPanel sulMCliMRestFOrdRestValorCartaResultadoSubPanel = new JPanel();

        JLabel mCliMRestFOrdRestsValorCartaResultadoLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel mCliMRestFOrdRestValorCartaResultadoLabel = new JLabel("VALORES MÉDIOS DOS PRATOS - CARTA");


        JButton ptEnMCliMRestFOrdRestValorCartaResultadoButton = new JButton("PT/EN");
        JButton voltarMCliMRestFOrdRestValorCartaResultadoButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFOrdRestValorCartaResultadoButton = new JButton("VOLTAR");


        mCliMRestFOrdRestValorCartaResultadoSuperPanel.add(norteMCliMRestFOrdRestValorCartaResultadoSubPanel, "North");
        mCliMRestFOrdRestValorCartaResultadoSuperPanel.add(centroMCliMRestFOrdRestValorCartaResultadoSubPanel, "Center");
        mCliMRestFOrdRestValorCartaResultadoSuperPanel.add(sulMCliMRestFOrdRestValorCartaResultadoSubPanel, "South");

        JPanel norteMCliMRestFOrdRestValorCartaResultadoSSPanel = new JPanel();
        norteMCliMRestFOrdRestValorCartaResultadoSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFOrdRestValorCartaResultadoSSPanel.add(mCliMRestFOrdRestsValorCartaResultadoLabel);
        norteMCliMRestFOrdRestValorCartaResultadoSubPanel.add(norteMCliMRestFOrdRestValorCartaResultadoSSPanel, BorderLayout.CENTER);
        norteMCliMRestFOrdRestValorCartaResultadoSubPanel.add(ptEnMCliMRestFOrdRestValorCartaResultadoButton, BorderLayout.EAST);

        JPanel centroMCliMRestFOrdRestValorCartaResultadoSSPanel = new JPanel();
        centroMCliMRestFOrdRestValorCartaResultadoSSPanel.setLayout(new FlowLayout());
        centroMCliMRestFOrdRestValorCartaResultadoSubPanel.add(centroMCliMRestFOrdRestValorCartaResultadoSSPanel, BorderLayout.CENTER);

        centroMCliMRestFOrdRestValorCartaResultadoSSPanel1 = new JPanel();
        centroMCliMRestFOrdRestValorCartaResultadoSSPanel1.setLayout(new FlowLayout());
        centroMCliMRestFOrdRestValorCartaResultadoSubPanel.add(centroMCliMRestFOrdRestValorCartaResultadoSSPanel1, BorderLayout.CENTER);

        centroMCliMRestFOrdRestValorCartaResultadoSSPanel.add(mCliMRestFOrdRestValorCartaResultadoLabel);

        sulMCliMRestFOrdRestValorCartaResultadoSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFOrdRestValorCartaResultadoSubPanel.add(voltarMCliMRestFOrdRestValorCartaResultadoButton);
        sulMCliMRestFOrdRestValorCartaResultadoSubPanel.add(retornarMCliMRestFOrdRestValorCartaResultadoButton);

        retornarMCliMRestFOrdRestValorCartaResultadoButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTVALOR_CARD));

        voltarMCliMRestFOrdRestValorCartaResultadoButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    ////MENU CLIENTE – RESTAURANTES – MENU FILTRAR POR VALORES MÉDIOS DOS PRATOS – PRATO DO DIA//////////
    private void construirPanelMCliMRestFOrdRestValorPDia (JPanel mCliMRestFOrdRestValorPDiaSuperPanel){


        /////SUBPAINEIS//////
        JPanel norteMCliMRestFOrdRestValorPDiaSubPanel = new JPanel();
        norteMCliMRestFOrdRestValorPDiaSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFOrdRestValorPDiaSubPanel = new JPanel();
        JPanel sulMCliMRestFOrdRestValorPDiaSubPanel = new JPanel();
        JLabel mCliMRestFOrdRestsValorPDiaLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel mCliMRestFOrdRestValorMedPDiaLabel = new JLabel("VALORES MÉDIOS DOS PRATOS – PRATO DO DIA");

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

        JButton ptEnMCliMRestFOrdRestValorPDiaButton = new JButton("PT/EN");
        JButton voltarMCliMRestFOrdRestValorPDiaButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFOrdRestValorPDiaButton = new JButton("VOLTAR");

//            ArrayList<Restaurante> listasValoresPDia = sistema.consultarRestaurantePorValores(demCliMRestFOrdRestValorText.getText(), atemCliMRestFOrdRestValorText.getText());
//            if (listasValoresPDia != null && !listasValoresPDia.isEmpty()) {
//                String[][] dadosMCliMRestFOrdRestValorPDiaSSPanel = new String[listasValoresPDia.size()][3];
//                int i = 0;
//                for (Restaurante resrte : listasValoresPDia) {
//                    dadosMCliMRestFOrdRestValorPDiaSSPanel[i][0] = resrte.getNome();
//                    dadosMCliMRestFOrdRestValorPDiaSSPanel[i][1] = resrte.getCidade();
//                    dadosMCliMRestFOrdRestValorPDiaSSPanel[i][2] = "" + resrte.getPrecoMedioRestaurante();
//                    i++;
//                }
//
//                String[] nomeColunasMCliMRestFOrdRestValorPDiaSSPanel = new String[]{"RESTAURANTE", "CIDADE", "PREÇOS MÉDIOS"};
//                JTable tabelaMCliMRestFOrdRestValorPDiaSSPanel = new JTable(dadosMCliMRestFOrdRestValorPDiaSSPanel, nomeColunasMCliMRestFOrdRestValorPDiaSSPanel);
//                JScrollPane jScrollMCliMRestFOrdRestValorPDia = new JScrollPane(tabelaMCliMRestFOrdRestValorPDiaSSPanel);
//                tabelaMCliMRestFOrdRestValorPDiaSSPanel.setVisible(true);
//                centroMCliMRestFOrdRestValorPDiaResultSSPanel1.add(jScrollMCliMRestFOrdRestValorPDia, BorderLayout.CENTER);
//            } else {
//                JOptionPane.showMessageDialog(null, "Sem registo nos valores informados!");
//            }

        mCliMRestFOrdRestValorPDiaSuperPanel.add(norteMCliMRestFOrdRestValorPDiaSubPanel, "North");
        mCliMRestFOrdRestValorPDiaSuperPanel.add(centroMCliMRestFOrdRestValorPDiaSubPanel, "Center");
        mCliMRestFOrdRestValorPDiaSuperPanel.add(sulMCliMRestFOrdRestValorPDiaSubPanel, "South");

        JPanel norteMCliMRestFOrdRestValorPDiaSSPanel = new JPanel();
        norteMCliMRestFOrdRestValorPDiaSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFOrdRestValorPDiaSSPanel.add(mCliMRestFOrdRestsValorPDiaLabel);
        norteMCliMRestFOrdRestValorPDiaSubPanel.add(norteMCliMRestFOrdRestValorPDiaSSPanel, BorderLayout.CENTER);
        norteMCliMRestFOrdRestValorPDiaSubPanel.add(ptEnMCliMRestFOrdRestValorPDiaButton, BorderLayout.EAST);

        JPanel centroMCliMRestFOrdRestValorPDiaSSPanel = new JPanel();
        centroMCliMRestFOrdRestValorPDiaSSPanel.setLayout(new GridLayout(1, 2));
        centroMCliMRestFOrdRestValorPDiaSubPanel.add(centroMCliMRestFOrdRestValorPDiaSSPanel);

        JPanel centroMCliMRestFOrdRestValorPDiaSSPanel1 = new JPanel();
        centroMCliMRestFOrdRestValorPDiaSSPanel1.setLayout(new GridBagLayout());
        centroMCliMRestFOrdRestValorPDiaSubPanel.add(centroMCliMRestFOrdRestValorPDiaSSPanel1);

        centroMCliMRestFOrdRestValorPDiaSSPanel.add(mCliMRestFOrdRestValorMedPDiaLabel);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(dezMCliMRestFOrdRestValorPDiaCBox);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(dezVinteMCliMRestFOrdRestValorPDiaCBox);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(vinteTrintaMCliMRestFOrdRestValorPDiaCBox);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(trintaQuarentaMCliMRestFOrdRestValorPDiaCBox);
//        centroMCliMRestFOrdRestValorPDiaSSPanel1.add(quarentaMaisMCliMRestFOrdRestValorPDiaCBox);

        sulMCliMRestFOrdRestValorPDiaSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFOrdRestValorPDiaSubPanel.add(voltarMCliMRestFOrdRestValorPDiaButton);
        sulMCliMRestFOrdRestValorPDiaSubPanel.add(retornarMCliMRestFOrdRestValorPDiaButton);

//        dezMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
//
//        dezVinteMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
//
//        vinteTrintaMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
//
//        trintaQuarentaMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
//
//        quarentaMaisMCliMRestFOrdRestValorPDiaCBox.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliMRestFOrdRestValorPDiaButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));
        voltarMCliMRestFOrdRestValorPDiaButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    ////MENU CLIENTE – RESTAURANTES – MENU FILTRAR POR VALORES MÉDIOS DOS PRATOS – PRATO DO DIA - RESULTADO//////////
    private void construirPanelMCliMRestFOrdRestValorPDiaResult (JPanel mCliMRestFOrdRestValorPDiaResultSuperPanel){


        /////SUBPAINEIS//////
        JPanel norteMCliMRestFOrdRestValorPDiaResultSubPanel = new JPanel();
        norteMCliMRestFOrdRestValorPDiaResultSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFOrdRestValorPDiaResultSubPanel = new JPanel();
        JPanel sulMCliMRestFOrdRestValorPDiaResultSubPanel = new JPanel();
        JLabel mCliMRestFOrdRestsValorPDiaResultLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel mCliMRestFOrdRestValorMedPDiaResultLabel = new JLabel("VALORES MÉDIOS DOS PRATOS – PRATO DO DIA");

        JButton ptEnMCliMRestFOrdRestValorPDiaResultButton = new JButton("PT/EN");
        JButton voltarMCliMRestFOrdRestValorPDiaResultButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFOrdRestValorPDiaResultButton = new JButton("VOLTAR");

        mCliMRestFOrdRestValorPDiaResultSuperPanel.add(norteMCliMRestFOrdRestValorPDiaResultSubPanel, "North");
        mCliMRestFOrdRestValorPDiaResultSuperPanel.add(centroMCliMRestFOrdRestValorPDiaResultSubPanel, "Center");
        mCliMRestFOrdRestValorPDiaResultSuperPanel.add(sulMCliMRestFOrdRestValorPDiaResultSubPanel, "South");

        JPanel norteMCliMRestFOrdRestValorPDiaResultSSPanel = new JPanel();
        norteMCliMRestFOrdRestValorPDiaResultSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFOrdRestValorPDiaResultSSPanel.add(mCliMRestFOrdRestsValorPDiaResultLabel);
        norteMCliMRestFOrdRestValorPDiaResultSubPanel.add(norteMCliMRestFOrdRestValorPDiaResultSSPanel, BorderLayout.CENTER);
        norteMCliMRestFOrdRestValorPDiaResultSubPanel.add(ptEnMCliMRestFOrdRestValorPDiaResultButton, BorderLayout.EAST);

        JPanel centroMCliMRestFOrdRestValorPDiaResultSSPanel = new JPanel();
        centroMCliMRestFOrdRestValorPDiaResultSSPanel.setLayout(new GridLayout(1, 2));
        centroMCliMRestFOrdRestValorPDiaResultSubPanel.add(centroMCliMRestFOrdRestValorPDiaResultSSPanel);

        centroMCliMRestFOrdRestValorPDiaResultSSPanel1 = new JPanel();
        centroMCliMRestFOrdRestValorPDiaResultSSPanel1.setLayout(new FlowLayout());
        centroMCliMRestFOrdRestValorPDiaResultSubPanel.add(centroMCliMRestFOrdRestValorPDiaResultSSPanel1);

        centroMCliMRestFOrdRestValorPDiaResultSSPanel.add(mCliMRestFOrdRestValorMedPDiaResultLabel);

        sulMCliMRestFOrdRestValorPDiaResultSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFOrdRestValorPDiaResultSubPanel.add(voltarMCliMRestFOrdRestValorPDiaResultButton);
        sulMCliMRestFOrdRestValorPDiaResultSubPanel.add(retornarMCliMRestFOrdRestValorPDiaResultButton);


        retornarMCliMRestFOrdRestValorPDiaResultButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));
        voltarMCliMRestFOrdRestValorPDiaResultButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }


    //////MENU ClLIENTE – RESTAURANTES – MENU FILTROS – HORÁRIO DE FUNCIONAMENTO//////////
    private void construirPanelMCliMRestFRestHFunc (JPanel mCliMRestFRestHFuncSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestFRestHFuncSubPanel = new JPanel();
        norteMCliMRestFRestHFuncSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFRestHFuncSubPanel = new JPanel();
        JPanel sulMCliMRestFRestHFuncSubPanel = new JPanel();

        JLabel mCliMRestsFRestsHFuncLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel mCliMRestFRestHFuncLabel = new JLabel("HORÁRIOS DE FUNCIONAMENTO");

        JLabel fHoraMCliMRestFRestHFuncLabel = new JLabel("HORA");
        fHoraMCliMRestFRestHFuncText = new JTextField(5);

        JButton ptEnMCliMRestFRestHFuncButton = new JButton("PT/EN");
        JButton voltarMCliMRestFRestHFuncButton = new JButton("MENU CLIENTE");
        JButton pesquisarMCliMRestFRestHFuncButton = new JButton("PESQUISAR");
        JButton retornarMCliMRestFRestHFuncButton = new JButton("VOLTAR");

        mCliMRestFRestHFuncSuperPanel.add(norteMCliMRestFRestHFuncSubPanel, "North");
        mCliMRestFRestHFuncSuperPanel.add(centroMCliMRestFRestHFuncSubPanel, "Center");
        mCliMRestFRestHFuncSuperPanel.add(sulMCliMRestFRestHFuncSubPanel, "South");

        JPanel norteMCliMRestFRestHFuncSSPanel = new JPanel();
        norteMCliMRestFRestHFuncSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFRestHFuncSSPanel.add(mCliMRestsFRestsHFuncLabel);
        norteMCliMRestFRestHFuncSubPanel.add(norteMCliMRestFRestHFuncSSPanel, BorderLayout.CENTER);
        norteMCliMRestFRestHFuncSubPanel.add(ptEnMCliMRestFRestHFuncButton, BorderLayout.EAST);

        JPanel centroMCliMRestFRestHFuncSSPanel = new JPanel();
        centroMCliMRestFRestHFuncSSPanel.setLayout(new FlowLayout());
        centroMCliMRestFRestHFuncSubPanel.add(centroMCliMRestFRestHFuncSSPanel);

        JPanel centroMCliMRestFRestHFuncSSPanel1 = new JPanel();
        centroMCliMRestFRestHFuncSSPanel1.setLayout(new FlowLayout());
        centroMCliMRestFRestHFuncSubPanel.add(centroMCliMRestFRestHFuncSSPanel1);

        JPanel centroMCliMRestFRestHFuncSSPanel2 = new JPanel();
        centroMCliMRestFRestHFuncSSPanel2.setLayout(new FlowLayout());
        centroMCliMRestFRestHFuncSubPanel.add(centroMCliMRestFRestHFuncSSPanel2);

        centroMCliMRestFRestHFuncSSPanel.add(mCliMRestFRestHFuncLabel);
        centroMCliMRestFRestHFuncSSPanel1.add(fHoraMCliMRestFRestHFuncLabel);
        centroMCliMRestFRestHFuncSSPanel1.add(fHoraMCliMRestFRestHFuncText);

        sulMCliMRestFRestHFuncSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFRestHFuncSubPanel.add(voltarMCliMRestFRestHFuncButton);
        sulMCliMRestFRestHFuncSubPanel.add(retornarMCliMRestFRestHFuncButton);
        sulMCliMRestFRestHFuncSubPanel.add(pesquisarMCliMRestFRestHFuncButton);

        //TODO faltar ver métodos para pesquisar e o comando do mostrarJanela tem quer alterado


        //método feito ontem à noite
        pesquisarMCliMRestFRestHFuncButton.addActionListener(a -> {
            Pattern pttrn = Pattern.compile("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
            if (fHoraMCliMRestFRestHFuncText.getText() != null && pttrn.matcher(fHoraMCliMRestFRestHFuncText.getText()).find()) {
                LocalTime hora = LocalTime.parse(fHoraMCliMRestFRestHFuncText.getText() + ":00", DateTimeFormatter.ISO_TIME);
                listaRestHF = sistema.consultarRestaurantePorHorario(hora);
                if (listaRestHF != null && !listaRestHF.isEmpty()) {
                    String[][] dadosMCliMRestFRestHFuncSSPanel = new String[listaRestHF.size()][1];
                    int i = 0;
                    for (Restaurante rest : listaRestHF) {
                        dadosMCliMRestFRestHFuncSSPanel[i][0] = rest.getNome();
                        i++;
                    }
                    String[] nomeColunasMCliMRestFRestFuncSSPanel = new String[]{"RESTAURANTE"};
                    JTable tabelaMCliMRestFRestHFuncSSPanel = new JTable(dadosMCliMRestFRestHFuncSSPanel, nomeColunasMCliMRestFRestFuncSSPanel);
                    JScrollPane jScrollMCliMRestFRestFuncFPP = new JScrollPane(tabelaMCliMRestFRestHFuncSSPanel);
                    centroMCliMRestFRestHFuncResultadoSSPanel2.add(jScrollMCliMRestFRestFuncFPP, BorderLayout.CENTER);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum restaurante aberto neste horário!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Escreva uma hora válida!");
            }
            mostrarJanela(MCLIMRESTFRESTHFUNCRESULTADO_CARD);
        });

        retornarMCliMRestFRestHFuncButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));

        voltarMCliMRestFRestHFuncButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }


    //////MENU ClLIENTE – RESTAURANTES – MENU FILTROS – HORÁRIO DE FUNCIONAMENTO - RESULTADO//////////
    private void construirPanelMCliMRestFRestHFuncResultado (JPanel mCliMRestFRestHFuncResultadoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestFRestHFuncResultadoSubPanel = new JPanel();
        norteMCliMRestFRestHFuncResultadoSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFRestHFuncResultadoSubPanel = new JPanel();
        JPanel sulMCliMRestFRestHFuncResultadoSubPanel = new JPanel();

        JLabel mCliMRestsFRestsHFuncLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel MCliMRestFRestHFuncResultadoLabel = new JLabel("HORÁRIOS DE FUNCIONAMENTO");

        JLabel fHoraMCliMRestFRestHFuncResultadoLabel = new JLabel("HORA");
        JTextField fHoraMCliMRestFRestHFuncResultadoText = new JTextField(5);

        JButton ptEnMCliMRestFRestHFuncResultadoButton = new JButton("PT/EN");
        JButton voltarMCliMRestFRestHFuncResultadoButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFRestHFuncResultadoButton = new JButton("VOLTAR");

        mCliMRestFRestHFuncResultadoSuperPanel.add(norteMCliMRestFRestHFuncResultadoSubPanel, "North");
        mCliMRestFRestHFuncResultadoSuperPanel.add(centroMCliMRestFRestHFuncResultadoSubPanel, "Center");
        mCliMRestFRestHFuncResultadoSuperPanel.add(sulMCliMRestFRestHFuncResultadoSubPanel, "South");

        JPanel norteMCliMRestFRestHFuncResultadoSSPanel = new JPanel();
        norteMCliMRestFRestHFuncResultadoSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFRestHFuncResultadoSSPanel.add(mCliMRestsFRestsHFuncLabel);
        norteMCliMRestFRestHFuncResultadoSubPanel.add(norteMCliMRestFRestHFuncResultadoSSPanel, BorderLayout.CENTER);
        norteMCliMRestFRestHFuncResultadoSubPanel.add(ptEnMCliMRestFRestHFuncResultadoButton, BorderLayout.EAST);

        JPanel centroMCliMRestFRestHFuncResultadoSSPanel = new JPanel();
        centroMCliMRestFRestHFuncResultadoSSPanel.setLayout(new FlowLayout());
        centroMCliMRestFRestHFuncResultadoSubPanel.add(centroMCliMRestFRestHFuncResultadoSSPanel);

        JPanel centroMCliMRestFRestHFuncResultadoSSPanel1 = new JPanel();
        centroMCliMRestFRestHFuncResultadoSSPanel1.setLayout(new FlowLayout());
        centroMCliMRestFRestHFuncResultadoSubPanel.add(centroMCliMRestFRestHFuncResultadoSSPanel1);

        centroMCliMRestFRestHFuncResultadoSSPanel2 = new JPanel();
        centroMCliMRestFRestHFuncResultadoSSPanel2.setLayout(new FlowLayout());
        centroMCliMRestFRestHFuncResultadoSubPanel.add(centroMCliMRestFRestHFuncResultadoSSPanel2);

        centroMCliMRestFRestHFuncResultadoSSPanel.add(MCliMRestFRestHFuncResultadoLabel);
        centroMCliMRestFRestHFuncResultadoSSPanel1.add(fHoraMCliMRestFRestHFuncResultadoLabel);
        centroMCliMRestFRestHFuncResultadoSSPanel1.add(fHoraMCliMRestFRestHFuncResultadoText);

        sulMCliMRestFRestHFuncResultadoSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFRestHFuncResultadoSubPanel.add(voltarMCliMRestFRestHFuncResultadoButton);
        sulMCliMRestFRestHFuncResultadoSubPanel.add(retornarMCliMRestFRestHFuncResultadoButton);

        retornarMCliMRestFRestHFuncResultadoButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));

        voltarMCliMRestFRestHFuncResultadoButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    //////MENU CLIENTE – RESTAURANTES – MENU FILTROS - LOTAÇÃO//////////
    private void construirPanelMCliMRestFRestLot (JPanel mCliMRestFRestLotSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestFRestLotSubPanel = new JPanel();
        norteMCliMRestFRestLotSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFRestLotSubPanel = new JPanel();
        JPanel sulMCliMRestFRestLotSubPanel = new JPanel();

        JLabel mCliMRestsFRestsLotLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel lotacaoMCliMRestFRestLotLabel = new JLabel("LOTAÇÃO");
        JLabel lugaresMCliMRestFRestLotLabel = new JLabel("N. DE PESSOAS PARA A RESERVA");
        JLabel dataMCliMRestFRestLotLabel = new JLabel("DATA");
        JButton pesquisarMCliMRestFRestLotButton = new JButton("PESQUISAR");

        JTextField lugaresMCliMRestFRestLotText = new JTextField(3);
        //Calendário
        UtilDateModel modelMCliMRestFRestLot = new UtilDateModel();

        ResourceBundle b = ResourceBundle.getBundle("Text");

        Properties p = convertResourceBundleToProperties(b);
        JDatePanelImpl datePanelMCliMRestFRestLot = new JDatePanelImpl(modelMCliMRestFRestLot, p);
        JDatePickerImpl datePickerMCliMRestFRestLot = new JDatePickerImpl(datePanelMCliMRestFRestLot, new DateLabelFormatter());

        JButton ptEnMCliMRestFRestLotButton = new JButton("PT/EN");
        JButton voltarMCliMRestFRestLotButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFRestLotButton = new JButton("VOLTAR");

        mCliMRestFRestLotSuperPanel.add(norteMCliMRestFRestLotSubPanel, "North");
        mCliMRestFRestLotSuperPanel.add(centroMCliMRestFRestLotSubPanel, "Center");
        mCliMRestFRestLotSuperPanel.add(sulMCliMRestFRestLotSubPanel, "South");

        JPanel norteMCliMRestFRestLotSSPanel = new JPanel();
        norteMCliMRestFRestLotSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFRestLotSSPanel.add(mCliMRestsFRestsLotLabel);
        norteMCliMRestFRestLotSubPanel.add(norteMCliMRestFRestLotSSPanel, BorderLayout.CENTER);
        norteMCliMRestFRestLotSubPanel.add(ptEnMCliMRestFRestLotButton, BorderLayout.EAST);

        JPanel centroMCliMRestFRestLotSSPanel = new JPanel();
        centroMCliMRestFRestLotSSPanel.setLayout(new GridLayout(4, 2));
        centroMCliMRestFRestLotSubPanel.add(centroMCliMRestFRestLotSSPanel);

        JPanel centroMCliMRestFRestLotSSPanel1 = new JPanel();
        centroMCliMRestFRestLotSSPanel1.setLayout(new GridBagLayout());
        centroMCliMRestFRestLotSubPanel.add(centroMCliMRestFRestLotSSPanel1);

        JPanel centroMCliMRestFRestLotSSPanel2 = new JPanel();
        centroMCliMRestFRestLotSSPanel2.setLayout(new GridBagLayout());
        centroMCliMRestFRestLotSubPanel.add(centroMCliMRestFRestLotSSPanel2);

        JPanel centroMCliMRestFRestLotSSPanel3 = new JPanel();
        centroMCliMRestFRestLotSSPanel3.setLayout(new FlowLayout());
        centroMCliMRestFRestLotSubPanel.add(centroMCliMRestFRestLotSSPanel3);

        centroMCliMRestFRestLotSSPanel.add(lotacaoMCliMRestFRestLotLabel);
        centroMCliMRestFRestLotSSPanel1.add(dataMCliMRestFRestLotLabel);
        centroMCliMRestFRestLotSSPanel1.add(datePickerMCliMRestFRestLot);
        centroMCliMRestFRestLotSSPanel2.add(lugaresMCliMRestFRestLotLabel);
        centroMCliMRestFRestLotSSPanel2.add(lugaresMCliMRestFRestLotText);

        sulMCliMRestFRestLotSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFRestLotSubPanel.add(voltarMCliMRestFRestLotButton);
        sulMCliMRestFRestLotSubPanel.add(retornarMCliMRestFRestLotButton);
        sulMCliMRestFRestLotSubPanel.add(pesquisarMCliMRestFRestLotButton);

        //ñ está funcionando Tais
        pesquisarMCliMRestFRestLotButton.addActionListener(a -> {
            GregorianCalendar dataMCliMRestFRestLot = (GregorianCalendar) datePickerMCliMRestFRestLot.getJFormattedTextField().getValue();
            int lugares = Integer.parseInt(lugaresMCliMRestFRestLotText.getText()); //String para inteiro
            ArrayList<Restaurante> listaRestLot = sistema.consultarRestaurantePorLotacao(dataMCliMRestFRestLot, lugares);
            if (dataMCliMRestFRestLot == null) {
                JOptionPane.showMessageDialog(null, "A data deve ser preenchida");
                datePickerMCliMRestFRestLot.requestFocus();
            }
            if (listaRestLot != null && !listaRestLot.isEmpty()) {
                String[][] dadosMRestFRestLotSPanel = new String[listaRestLot.size()][2];
                int i = 0;
                DateLabelFormatter dateFormatterMRestFRestLot = new DateLabelFormatter();
                for (Restaurante resnte : listaRestLot) {
                    try {
                        dadosMRestFRestLotSPanel[i][0] = dateFormatterMRestFRestLot.dateTimeToString(datePickerMCliMRestFRestLot);
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    dadosMRestFRestLotSPanel[i][1] = resnte.getNome();
                    dadosMRestFRestLotSPanel[i][2] = resnte.getCidade();
                    i++;
                }
                String[] nomeColunasMRestFRestLotSSPanel = new String[]{"RESTAURANTE", "CIDADE"};
                JTable tabelaMRestFRestLotSSPanelSSPanel = new JTable(dadosMRestFRestLotSPanel, nomeColunasMRestFRestLotSSPanel);
                JScrollPane jscrollMRestFRestLot = new JScrollPane(tabelaMRestFRestLotSSPanelSSPanel);
                tabelaMRestFRestLotSSPanelSSPanel.setSize(10, 10);
                tabelaMRestFRestLotSSPanelSSPanel.setVisible(true);
                centroMCliMRestRestLotResultadoSSPanel1.add(jscrollMRestFRestLot, BorderLayout.CENTER);
            } else {
                JOptionPane.showMessageDialog(null, "Não há lugares disponíveis nesta data!");
            }
            mostrarJanela(MCLIMRESTFRESTLOTRESULTADO_CARD);

        });

        retornarMCliMRestFRestLotButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));

        voltarMCliMRestFRestLotButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    //////MENU CLIENTE – RESTAURANTES – MENU FILTROS - LOTAÇÃO - RESULTADO//////////
    private void construirPanelMCliMRestFRestLotResultado (JPanel mCliMRestRestLotResultadoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestRestLotResultadoSubPanel = new JPanel();
        norteMCliMRestRestLotResultadoSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestRestLotResultadoSubPanel = new JPanel();
        JPanel sulMCliMRestRestLotResultadoSubPanel = new JPanel();

        JLabel mCliMRestsFRestsLotResultadoLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel lotacaoMCliMRestRestLotResultadoLabel = new JLabel("LOTAÇÃO");

        JButton ptEnMCliMRestRestLotResultadoButton = new JButton("PT/EN");
        JButton voltarMCliMRestRestLotResultadoButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestRestLotResultadoButton = new JButton("VOLTAR");

        mCliMRestRestLotResultadoSuperPanel.add(norteMCliMRestRestLotResultadoSubPanel, "North");
        mCliMRestRestLotResultadoSuperPanel.add(centroMCliMRestRestLotResultadoSubPanel, "Center");
        mCliMRestRestLotResultadoSuperPanel.add(sulMCliMRestRestLotResultadoSubPanel, "South");

        JPanel norteMCliMRestRestLotResultadoSSPanel = new JPanel();
        norteMCliMRestRestLotResultadoSSPanel.setLayout(new FlowLayout());
        norteMCliMRestRestLotResultadoSSPanel.add(mCliMRestsFRestsLotResultadoLabel);
        norteMCliMRestRestLotResultadoSubPanel.add(norteMCliMRestRestLotResultadoSSPanel, BorderLayout.CENTER);
        norteMCliMRestRestLotResultadoSubPanel.add(ptEnMCliMRestRestLotResultadoButton, BorderLayout.EAST);

        JPanel centroMCliMRestRestLotResultadoSSPanel = new JPanel();
        centroMCliMRestRestLotResultadoSSPanel.setLayout(new GridLayout(4, 2));
        centroMCliMRestRestLotResultadoSubPanel.add(centroMCliMRestRestLotResultadoSSPanel);

        centroMCliMRestRestLotResultadoSSPanel1 = new JPanel();
        centroMCliMRestRestLotResultadoSSPanel1.setLayout(new FlowLayout());
        centroMCliMRestRestLotResultadoSubPanel.add(centroMCliMRestRestLotResultadoSSPanel1);

        centroMCliMRestRestLotResultadoSSPanel.add(lotacaoMCliMRestRestLotResultadoLabel);

        sulMCliMRestRestLotResultadoSubPanel.setLayout(new FlowLayout());
        sulMCliMRestRestLotResultadoSubPanel.add(voltarMCliMRestRestLotResultadoButton);
        sulMCliMRestRestLotResultadoSubPanel.add(retornarMCliMRestRestLotResultadoButton);

        retornarMCliMRestRestLotResultadoButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));

        voltarMCliMRestRestLotResultadoButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    //////MENU CLIENTE – RESTAURANTES – MENU FILTROS - CIDADE//////////
    private void construirPanelMCliMRestFRestCid (JPanel mCliMRestFRestCidSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestFRestCidSubPanel = new JPanel();
        norteMCliMRestFRestCidSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFRestCidSubPanel = new JPanel();
        JPanel sulMCliMRestFRestCidSubPanel = new JPanel();

        JLabel mCliMRestsFRestCidLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel mCliMRestFRestCidLabel = new JLabel("CIDADE");

        JTextField mCliMRestFRestCidText = new JTextField(15);

        JButton ptEnMCliMRestFRestCidButton = new JButton("PT/EN");
        JButton voltarMCliMRestFRestCidButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFRestCidButton = new JButton("VOLTAR");
        JButton pesquisarMCliMRestFRestCidButton = new JButton("PESQUISAR");

        mCliMRestFRestCidSuperPanel.add(norteMCliMRestFRestCidSubPanel, "North");
        mCliMRestFRestCidSuperPanel.add(centroMCliMRestFRestCidSubPanel, "Center");
        mCliMRestFRestCidSuperPanel.add(sulMCliMRestFRestCidSubPanel, "South");

        JPanel norteMCliMRestFRestCidSSPanel = new JPanel();
        norteMCliMRestFRestCidSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFRestCidSSPanel.add(mCliMRestsFRestCidLabel);
        norteMCliMRestFRestCidSubPanel.add(norteMCliMRestFRestCidSSPanel, BorderLayout.CENTER);
        norteMCliMRestFRestCidSubPanel.add(ptEnMCliMRestFRestCidButton, BorderLayout.EAST);

        JPanel centroMCliMRestFRestCidSSPanel = new JPanel();
        centroMCliMRestFRestCidSSPanel.setLayout(new GridLayout(8, 2));
        centroMCliMRestFRestCidSubPanel.add(centroMCliMRestFRestCidSSPanel);

        JPanel centroMCliMRestFRestCidSSPanel1 = new JPanel();
        centroMCliMRestFRestCidSSPanel1.setLayout(new GridLayout(8, 2));
        centroMCliMRestFRestCidSubPanel.add(centroMCliMRestFRestCidSSPanel1);

        centroMCliMRestFRestCidSSPanel.add(mCliMRestFRestCidLabel);
        centroMCliMRestFRestCidSSPanel.add(mCliMRestFRestCidText);

        sulMCliMRestFRestCidSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFRestCidSubPanel.add(voltarMCliMRestFRestCidButton);
        sulMCliMRestFRestCidSubPanel.add(retornarMCliMRestFRestCidButton);
        sulMCliMRestFRestCidSubPanel.add(pesquisarMCliMRestFRestCidButton);

        retornarMCliMRestFRestCidButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));

        voltarMCliMRestFRestCidButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        //TODO verificar Tais
        pesquisarMCliMRestFRestCidButton.addActionListener(a -> {
            ArrayList<Restaurante> listasRestCid = sistema.consultarRestaurantePorCidade(mCliMRestFRestCidText.getText());
            if (listasRestCid != null && !listasRestCid.isEmpty()) {
                String[][] dadosMCliMRestFRestCidSSPanel = new String[listasRestCid.size()][2];
                int i = 0;
                for (Restaurante reste : listasRestCid) {
                    dadosMCliMRestFRestCidSSPanel[i][0] = reste.getNome();
                    dadosMCliMRestFRestCidSSPanel[i][1] = reste.getCidade();
                    i++;
                }

                String[] nomeColunasMCliMRestFRestCidSSPanel = new String[]{"RESTAURANTE", "CIDADE"};
                JTable tabelaMCliMComFCliSSPanel = new JTable(dadosMCliMRestFRestCidSSPanel, nomeColunasMCliMRestFRestCidSSPanel);
                JScrollPane jScrollMCliMRestFRestCid = new JScrollPane(tabelaMCliMComFCliSSPanel);
                tabelaMCliMComFCliSSPanel.setVisible(true);
                centroMCliMRestFRestCidResultadoSSPanel1.add(jScrollMCliMRestFRestCid, BorderLayout.CENTER);
            } else
                JOptionPane.showMessageDialog(null, "Sem restaurante registado!");

            mostrarJanela(MCLIMRESTFRESTCIDRESULTADO_CARD);
        });

    }

    //////MENU CLIENTE – RESTAURANTES – MENU FILTROS - CIDADE - RESULTADO//////////
    private void construirPanelMCliMRestFRestCidResultado (JPanel mCliMRestFRestCidResultadoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMRestFRestCidResultadoSubPanel = new JPanel();
        norteMCliMRestFRestCidResultadoSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMRestFRestCidResultadoSubPanel = new JPanel();
        JPanel sulMCliMRestFRestCidResultadoSubPanel = new JPanel();

        JLabel mCliMRestFRestCidResultadoLabel = new JLabel("MENU CLIENTE - PESQUISAR RESTAURANTES");
        JLabel cidadeMCliMRestFRestCidResultadoLabel = new JLabel("CIDADE");

        JTextField mCliMRestFRestCidResultadoText = new JTextField(15);

        JButton ptEnMCliMRestFRestCidResultadoButton = new JButton("PT/EN");
        JButton voltarMCliMRestFRestCidResultadoButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMRestFRestCidResultadoButton = new JButton("VOLTAR");

        mCliMRestFRestCidResultadoSuperPanel.add(norteMCliMRestFRestCidResultadoSubPanel, "North");
        mCliMRestFRestCidResultadoSuperPanel.add(centroMCliMRestFRestCidResultadoSubPanel, "Center");
        mCliMRestFRestCidResultadoSuperPanel.add(sulMCliMRestFRestCidResultadoSubPanel, "South");

        JPanel norteMCliMRestFRestCidResultadoSSPanel = new JPanel();
        norteMCliMRestFRestCidResultadoSSPanel.setLayout(new FlowLayout());
        norteMCliMRestFRestCidResultadoSSPanel.add(mCliMRestFRestCidResultadoLabel);
        norteMCliMRestFRestCidResultadoSubPanel.add(norteMCliMRestFRestCidResultadoSSPanel, BorderLayout.CENTER);
        norteMCliMRestFRestCidResultadoSubPanel.add(ptEnMCliMRestFRestCidResultadoButton, BorderLayout.EAST);

        JPanel centroMCliMRestFRestCidResultadoSSPanel = new JPanel();
        centroMCliMRestFRestCidResultadoSSPanel.setLayout(new FlowLayout());
        centroMCliMRestFRestCidResultadoSubPanel.add(centroMCliMRestFRestCidResultadoSSPanel);

        centroMCliMRestFRestCidResultadoSSPanel1 = new JPanel();
        centroMCliMRestFRestCidResultadoSubPanel.add(centroMCliMRestFRestCidResultadoSSPanel1, BorderLayout.CENTER);

        centroMCliMRestFRestCidResultadoSSPanel.add(cidadeMCliMRestFRestCidResultadoLabel);
        centroMCliMRestFRestCidResultadoSSPanel.add(mCliMRestFRestCidResultadoText);

        sulMCliMRestFRestCidResultadoSubPanel.setLayout(new FlowLayout());
        sulMCliMRestFRestCidResultadoSubPanel.add(voltarMCliMRestFRestCidResultadoButton);
        sulMCliMRestFRestCidResultadoSubPanel.add(retornarMCliMRestFRestCidResultadoButton);


        retornarMCliMRestFRestCidResultadoButton.addActionListener(a -> mostrarJanela(MCLIMRESTFORDRESTS_CARD));

        voltarMCliMRestFRestCidResultadoButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

//TODO ver como criar o apagar e editar comentário na seleção da tabela e ver a questão do OK
//////MENU CLIENTE – CONSULTAR COMENTÁRIOS MENU//////////

    private void construirPanelMCliMCom (JPanel mCliMComSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMComSubPanel = new JPanel();
        norteMCliMComSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMComSubPanel = new JPanel();
        JPanel sulMCliMComSubPanel = new JPanel();

        JLabel mCliMComLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS:");

        JRadioButton mCliMComFPPRButton = new JRadioButton("PRÓPRIOS");
        JRadioButton mCliMComFCliRButton = new JRadioButton("CLIENTE ESPECÍFICO");
        JRadioButton mCliMComFRestRButton = new JRadioButton("RESTAURANTE ESPECÍFICO");
        JRadioButton mCliMComFIDRButton = new JRadioButton("INTERVALO DE DATAS");

        ButtonGroup group = new ButtonGroup();
        group.add(mCliMComFPPRButton);
        group.add(mCliMComFCliRButton);
        group.add(mCliMComFRestRButton);
        group.add(mCliMComFIDRButton);

        JButton ptEnMCliMComButton = new JButton("PT/EN");
        JButton voltarMCliMComButton = new JButton("MENU CLIENTE");

        mCliMComSuperPanel.add(norteMCliMComSubPanel, "North");
        mCliMComSuperPanel.add(centroMCliMComSubPanel, "Center");
        mCliMComSuperPanel.add(sulMCliMComSubPanel, "South");

        JPanel norteMCliMComSSPanel = new JPanel();
        norteMCliMComSSPanel.setLayout(new FlowLayout());
        norteMCliMComSSPanel.add(mCliMComLabel);
        norteMCliMComSubPanel.add(norteMCliMComSSPanel, BorderLayout.CENTER);
        norteMCliMComSubPanel.add(ptEnMCliMComButton, BorderLayout.EAST);

        JPanel centroMCliMComSSPanel = new JPanel();
        centroMCliMComSSPanel.setLayout(new GridLayout(6, 1));
        centroMCliMComSubPanel.add(centroMCliMComSSPanel, BorderLayout.WEST);

        centroMCliMComSSPanel.add(mCliMComFPPRButton);
        centroMCliMComSSPanel.add(mCliMComFCliRButton);
        centroMCliMComSSPanel.add(mCliMComFRestRButton);
        centroMCliMComSSPanel.add(mCliMComFIDRButton);

        sulMCliMComSubPanel.setLayout(new FlowLayout());
        sulMCliMComSubPanel.add(voltarMCliMComButton);

        mCliMComFPPRButton.addActionListener(a -> {
            ArrayList<Comentario> listaComentarioClienteAtivo = sistema.consultarListaComentariosProprios(sistema.getClienteAtivo());
            if (listaComentarioClienteAtivo != null && !listaComentarioClienteAtivo.isEmpty()) {
                String[][] dadosMCliMComFPPSSPanel = new String[listaComentarioClienteAtivo.size()][4];
                int i = 0;
                DateLabelFormatter dateFormatterMCliMComFPP = new DateLabelFormatter();
                for (Comentario c : listaComentarioClienteAtivo) {
                    try {
                        dadosMCliMComFPPSSPanel[i][0] = dateFormatterMCliMComFPP.dateTimeToString(c.getDataComentario());
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    dadosMCliMComFPPSSPanel[i][1] = c.getRestaurante().getNome();
                    dadosMCliMComFPPSSPanel[i][2] = c.getOpiniao();
                    dadosMCliMComFPPSSPanel[i][3] = "" + c.getPontuacao();
                    i++;
                }
                String[] nomeColunasMCliMComFPPSSPanel = new String[]{"DATA", "RESTAURANTE", "COMENTÁRIO", "PONTUAÇÃO"};
                //Filipa
//                int col = 0;
//                DefaultTableModel tableModel = new DefaultTableModel(col, 0) {
//                    public Class<?> getColumnClass(int column) {
//                        return switch (column) {
//                            case 0 -> Boolean.class;
//                            case 1 -> CharSequence.class;
//                            case 2 -> CharSequence.class;
//                            case 3 -> CharSequence.class;
//                            case 4 -> CharSequence.class;
//                            default -> CharSequence.class;
//                        };
//                    }
//                };
//
//
//                JTable tabelaMCliMComFPPSSPanel = new JTable(tableModel);

                JTable tabelaMCliMComFPPSSPanel = new JTable(dadosMCliMComFPPSSPanel, nomeColunasMCliMComFPPSSPanel);
                JScrollPane jScrollMCliMComFPP = new JScrollPane(tabelaMCliMComFPPSSPanel);
                centroMCliMComFPPSSPanel.add(jScrollMCliMComFPP, BorderLayout.CENTER);
                mostrarJanela(MCLIMCOMFPP_CARD);
            } else {
                JOptionPane.showMessageDialog(null, "Não existem comentários!");
            }
        });

        mCliMComFCliRButton.addActionListener(a -> mostrarJanela(MCLIMCOMFCLI_CARD));

        mCliMComFRestRButton.addActionListener(a -> mostrarJanela(MCLIMCOMFREST_CARD));

        mCliMComFIDRButton.addActionListener(a -> mostrarJanela(MCLIMCOMFID_CARD));

        voltarMCliMComButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    ////MENU CLIENTE – CONSULTAR COMENTÁRIOS – COMENTÁRIOS PRÓPRIOS//////////
    private void construirPanelMCliMComFPP (JPanel mCliMComFPPSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMComFPPSubPanel = new JPanel();
        norteMCliMComFPPSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMComFPPSubPanel = new JPanel();
        JPanel sulMCliMComFPPSubPanel = new JPanel();

        JLabel mCliMComsFPPLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS:");

        JButton apagarMCliMComFPPButton = new JButton("APAGAR");
        JButton editarMCliMComFPPButton = new JButton("EDITAR");
        JButton ptEnMCliMComFPPButton = new JButton("PT/EN");
        JButton voltarMCliMComFPPButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMComFPPButton = new JButton("VOLTAR");

        mCliMComFPPSuperPanel.add(norteMCliMComFPPSubPanel, "North");
        mCliMComFPPSuperPanel.add(centroMCliMComFPPSubPanel, "Center");
        mCliMComFPPSuperPanel.add(sulMCliMComFPPSubPanel, "South");

        JPanel norteMCliMComFPPSSPanel = new JPanel();
        norteMCliMComFPPSSPanel.setLayout(new FlowLayout());
        norteMCliMComFPPSSPanel.add(mCliMComsFPPLabel);
        norteMCliMComFPPSubPanel.add(norteMCliMComFPPSSPanel, BorderLayout.CENTER);
        norteMCliMComFPPSubPanel.add(ptEnMCliMComFPPButton, BorderLayout.EAST);

        centroMCliMComFPPSSPanel = new JPanel();
        centroMCliMComFPPSSPanel.setLayout(new BorderLayout());
        centroMCliMComFPPSubPanel.add(centroMCliMComFPPSSPanel, BorderLayout.CENTER);

        JPanel centroMCliMComFPPSSPanel1 = new JPanel();
        centroMCliMComFPPSSPanel1.setLayout(new GridLayout());
        centroMCliMComFPPSubPanel.add(centroMCliMComFPPSSPanel1);


        sulMCliMComFPPSubPanel.setLayout(new FlowLayout());
        sulMCliMComFPPSubPanel.add(voltarMCliMComFPPButton);
        sulMCliMComFPPSubPanel.add(retornarMCliMComFPPButton);
        sulMCliMComFPPSubPanel.add(apagarMCliMComFPPButton);
        sulMCliMComFPPSubPanel.add(editarMCliMComFPPButton);

        editarMCliMComFPPButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        apagarMCliMComFPPButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        voltarMCliMComFPPButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliMComFPPButton.addActionListener(a -> mostrarJanela(MCLIMCOM_CARD));
    }

    //TODO ver como criar o apagar e editar comentário na seleção da tabela e ver a questão do OK
//////MENU CLIENTE – CONSULTAR COMENTÁRIOS – CLIENTE ESPECÍFICO//////////
    private void construirPanelMCliMComFCli (JPanel mCliMComFCliSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMComFCliSubPanel = new JPanel();
        norteMCliMComFCliSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMComFCliSubPanel = new JPanel();
        JPanel sulMCliMComFCliSubPanel = new JPanel();

        JLabel mCliMComFCliLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS:");
        JLabel nomeMCliMComFCliLabel = new JLabel("NOME DO CLIENTE");

        JTextField nomeMCliMComFCliText = new JTextField(20);

        JButton ptEnMCliMComFCliButton = new JButton("PT/EN");
        JButton voltarMCliMComFCliButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMComFCliButton = new JButton("VOLTAR");
        JButton pesquisarMCliMComFCliButton = new JButton("PESQUISAR");

        mCliMComFCliSuperPanel.add(norteMCliMComFCliSubPanel, "North");
        mCliMComFCliSuperPanel.add(centroMCliMComFCliSubPanel, "Center");
        mCliMComFCliSuperPanel.add(sulMCliMComFCliSubPanel, "South");

        JPanel norteMCliMComFClinSSPanel = new JPanel();
        norteMCliMComFClinSSPanel.setLayout(new FlowLayout());
        norteMCliMComFClinSSPanel.add(mCliMComFCliLabel);
        norteMCliMComFCliSubPanel.add(norteMCliMComFClinSSPanel, BorderLayout.CENTER);
        norteMCliMComFCliSubPanel.add(ptEnMCliMComFCliButton, BorderLayout.EAST);

        centroMCliMComFCliSSPanel = new JPanel();
        centroMCliMComFCliSSPanel.setLayout(new BorderLayout());
        centroMCliMComFCliSubPanel.add(centroMCliMComFCliSSPanel, BorderLayout.CENTER);

        JPanel centroMCliMComFClinSSPanel1 = new JPanel();
        centroMCliMComFClinSSPanel1.setLayout(new FlowLayout());
        centroMCliMComFCliSubPanel.add(centroMCliMComFClinSSPanel1, BorderLayout.WEST);

        centroMCliMComFClinSSPanel1.add(nomeMCliMComFCliLabel);
        centroMCliMComFClinSSPanel1.add(nomeMCliMComFCliText);

        sulMCliMComFCliSubPanel.setLayout(new FlowLayout());
        sulMCliMComFCliSubPanel.add(voltarMCliMComFCliButton);
        sulMCliMComFCliSubPanel.add(retornarMCliMComFCliButton);
        sulMCliMComFCliSubPanel.add(pesquisarMCliMComFCliButton);

        voltarMCliMComFCliButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliMComFCliButton.addActionListener(a -> mostrarJanela(MCLIMCOM_CARD));

        //TODO Tais revisar
        pesquisarMCliMComFCliButton.addActionListener(e -> {
            ArrayList<Comentario> listaComentarioCliente = sistema.consultarListaComentariosPorCliente(nomeMCliMComFCliText.getText());
            if (listaComentarioCliente != null && !listaComentarioCliente.isEmpty()) {
                String[][] dadosMCliMComFCliSSPanel = new String[listaComentarioCliente.size()][4];
                DateLabelFormatter dateFormatterMCliMComFCli = new DateLabelFormatter();
                int i = 0;
                for (Comentario co : listaComentarioCliente) {
                    try {
                        dadosMCliMComFCliSSPanel[i][0] = dateFormatterMCliMComFCli.dateTimeToString(co.getDataComentario());
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    dadosMCliMComFCliSSPanel[i][1] = co.getRestaurante().getNome(); //
                    dadosMCliMComFCliSSPanel[i][2] = co.getOpiniao();
                    dadosMCliMComFCliSSPanel[i][3] = "" + co.getPontuacao();
                    i++;
                }

                String[] nomeColunasMCliMComFCliSSPanel = new String[]{"DATA", "RESTAURANTE", "COMENTÁRIO", "PONTUAÇÃO"};
                JTable tabelaMCliMComFCliSSPanel = new JTable(dadosMCliMComFCliSSPanel, nomeColunasMCliMComFCliSSPanel);
                JScrollPane jScrollMCliMComFCli = new JScrollPane(tabelaMCliMComFCliSSPanel);
                centroMCliMComFCliResultadoSSPanel.add(jScrollMCliMComFCli, BorderLayout.CENTER);
                mostrarJanela(MCLIMCOMFCLIRESULTADO_CARD);
            } else
                JOptionPane.showMessageDialog(null, "Não existem comentários!");
        });
    }


    //////MENU CLIENTE – CONSULTAR COMENTÁRIOS – CLIENTE ESPECÍFICO - RESULTADO//////////
    private void construirPanelMCliMComFCliResultado (JPanel mCliMComFCliResultadoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMComFCliResultadoSubPanel = new JPanel();
        norteMCliMComFCliResultadoSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMComFCliResultadoSubPanel = new JPanel();
        JPanel sulMCliMComFCliResultadoSubPanel = new JPanel();

        JLabel mCliMComFCliResultadoLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS - CLIENTE:");

        JButton ptEnMCliMComFCliResultadoButton = new JButton("PT/EN");
        JButton voltarMCliMComFCliResultadoButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMComFCliResultadoButton = new JButton("VOLTAR");

        mCliMComFCliResultadoSuperPanel.add(norteMCliMComFCliResultadoSubPanel, "North");
        mCliMComFCliResultadoSuperPanel.add(centroMCliMComFCliResultadoSubPanel, "Center");
        mCliMComFCliResultadoSuperPanel.add(sulMCliMComFCliResultadoSubPanel, "South");

        JPanel norteMCliMComFCliResultadonSSPanel = new JPanel();
        norteMCliMComFCliResultadonSSPanel.add(mCliMComFCliResultadoLabel);
        norteMCliMComFCliResultadoSubPanel.add(norteMCliMComFCliResultadonSSPanel, BorderLayout.CENTER);
        norteMCliMComFCliResultadoSubPanel.add(ptEnMCliMComFCliResultadoButton, BorderLayout.EAST);

        centroMCliMComFCliResultadoSSPanel = new JPanel();
        centroMCliMComFCliResultadoSubPanel.add(centroMCliMComFCliResultadoSSPanel, BorderLayout.CENTER);

        sulMCliMComFCliResultadoSubPanel.setLayout(new FlowLayout());
        sulMCliMComFCliResultadoSubPanel.add(voltarMCliMComFCliResultadoButton);
        sulMCliMComFCliResultadoSubPanel.add(retornarMCliMComFCliResultadoButton);

        voltarMCliMComFCliResultadoButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliMComFCliResultadoButton.addActionListener(a -> mostrarJanela(MCLIMCOM_CARD));
    }

    //TODO ver como criar o apagar e editar comentário na seleção da tabela e ver a questão do OK
//////MENU CLIENTE – CONSULTAR COMENTÁRIOS - RESTAURANTES//////////
    private void construirPanelMCliMComFRest (JPanel mCliMComFRestSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMComFRestSubPanel = new JPanel();
        norteMCliMComFRestSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMComFRestSubPanel = new JPanel();
        JPanel sulMCliMComFRestSubPanel = new JPanel();

        JLabel mCliMComFRestLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS:");
        JLabel nomeRestMCliMComFRestLabel = new JLabel("NOME DO RESTAURANTE");

        JTextField nomeResMCliMComFRestText = new JTextField(20);

        JButton ptEnMCliMComFRestButton = new JButton("PT/EN");
        JButton voltarMCliMComFRestButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMComFRestButton = new JButton("VOLTAR");
        JButton pesquisarMCliMComFRestButton = new JButton("PESQUISAR");

        mCliMComFRestSuperPanel.add(norteMCliMComFRestSubPanel, "North");
        mCliMComFRestSuperPanel.add(centroMCliMComFRestSubPanel, "Center");
        mCliMComFRestSuperPanel.add(sulMCliMComFRestSubPanel, "South");

        JPanel norteMCliMComFRestSSPanel = new JPanel();
        norteMCliMComFRestSSPanel.setLayout(new FlowLayout());
        norteMCliMComFRestSSPanel.add(mCliMComFRestLabel);
        norteMCliMComFRestSubPanel.add(norteMCliMComFRestSSPanel, BorderLayout.CENTER);
        norteMCliMComFRestSubPanel.add(ptEnMCliMComFRestButton, BorderLayout.EAST);

        centroMCliMComFRestSSPanel = new JPanel();
        centroMCliMComFRestSubPanel.add(centroMCliMComFRestSSPanel, BorderLayout.CENTER);

        JPanel centroMCliMComFRestSSPanel1 = new JPanel();
        centroMCliMComFRestSSPanel1.setLayout(new FlowLayout());
        centroMCliMComFRestSubPanel.add(centroMCliMComFRestSSPanel1, BorderLayout.WEST);

        centroMCliMComFRestSSPanel1.add(nomeRestMCliMComFRestLabel);
        centroMCliMComFRestSSPanel1.add(nomeResMCliMComFRestText);

        sulMCliMComFRestSubPanel.setLayout(new FlowLayout());
        sulMCliMComFRestSubPanel.add(voltarMCliMComFRestButton);
        sulMCliMComFRestSubPanel.add(retornarMCliMComFRestButton);
        sulMCliMComFRestSubPanel.add(pesquisarMCliMComFRestButton);

        voltarMCliMComFRestButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliMComFRestButton.addActionListener(a -> mostrarJanela(MCLIMCOM_CARD));

        //TODO verificar Tais porque não aparece na tela
        pesquisarMCliMComFRestButton.addActionListener(e -> {
            ArrayList<Comentario> listaComentarioRest = sistema.consultarListaComentariosPorRestaurante(nomeResMCliMComFRestText.getText());
            if (listaComentarioRest != null && !listaComentarioRest.isEmpty()) {
                String[][] dadosMCliMComFRestSSPanel = new String[listaComentarioRest.size()][3];
                int i = 0;
                DateLabelFormatter dateFormatterMCliMComFRest = new DateLabelFormatter();
                for (Comentario com : listaComentarioRest) {
                    try {
                        dadosMCliMComFRestSSPanel[i][0] = dateFormatterMCliMComFRest.dateTimeToString(com.getDataComentario());
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    dadosMCliMComFRestSSPanel[i][1] = com.getOpiniao();
                    dadosMCliMComFRestSSPanel[i][2] = "" + com.getPontuacao();
                    i++;
                }
                String[] nomeColunasMCliMComFRestSSPanel = new String[]{"DATA", "COMENTÁRIO", "PONTUAÇÃO"};
                JTable tabelaMCliMComFRestSSPanel = new JTable(dadosMCliMComFRestSSPanel, nomeColunasMCliMComFRestSSPanel);
                JScrollPane jScrollMCliMComFRest = new JScrollPane(tabelaMCliMComFRestSSPanel);
                centroMCliMComFRestResultadoSSPanel.add(jScrollMCliMComFRest, BorderLayout.CENTER);
                mostrarJanela(MCLIMCOMFRESTRESULTADO_CARD);
            } else
                JOptionPane.showMessageDialog(null, "Não existem comentários!");
        });
    }

    //////MENU CLIENTE – CONSULTAR COMENTÁRIOS – RESTAURANTE - RESULTADO//////////
    private void construirPanelMCliMComFRestResultado (JPanel mCliMComFRestResultadoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMComFRestResultadoSubPanel = new JPanel();
        norteMCliMComFRestResultadoSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMComFRestResultadoSubPanel = new JPanel();
        JPanel sulMCliMComFRestResultadoSubPanel = new JPanel();

        JLabel mCliMComFRestResultadoLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS - RESTAURANTE:");

        JButton ptEnMCliMComFRestResultadoButton = new JButton("PT/EN");
        JButton voltarMCliMComFRestResultadoButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMComFRestResultadoButton = new JButton("VOLTAR");

        mCliMComFRestResultadoSuperPanel.add(norteMCliMComFRestResultadoSubPanel, "North");
        mCliMComFRestResultadoSuperPanel.add(centroMCliMComFRestResultadoSubPanel, "Center");
        mCliMComFRestResultadoSuperPanel.add(sulMCliMComFRestResultadoSubPanel, "South");

        JPanel norteMCliMComFRestResultadonSSPanel = new JPanel();
        norteMCliMComFRestResultadonSSPanel.add(mCliMComFRestResultadoLabel);
        norteMCliMComFRestResultadoSubPanel.add(norteMCliMComFRestResultadonSSPanel, BorderLayout.CENTER);
        norteMCliMComFRestResultadoSubPanel.add(ptEnMCliMComFRestResultadoButton, BorderLayout.EAST);

        centroMCliMComFRestResultadoSSPanel = new JPanel();
        centroMCliMComFRestResultadoSubPanel.add(centroMCliMComFRestResultadoSSPanel, BorderLayout.CENTER);

        sulMCliMComFRestResultadoSubPanel.setLayout(new FlowLayout());
        sulMCliMComFRestResultadoSubPanel.add(voltarMCliMComFRestResultadoButton);
        sulMCliMComFRestResultadoSubPanel.add(retornarMCliMComFRestResultadoButton);

        voltarMCliMComFRestResultadoButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliMComFRestResultadoButton.addActionListener(a -> mostrarJanela(MCLIMCOM_CARD));
    }


    //////MENU CLIENTE – CONSULTAR COMENTÁRIOS - INTERVALO DE DATAS//////////
    private void construirPanelMCliMComFID (JPanel mCliMComFIDSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMComFIDSubPanel = new JPanel();
        norteMCliMComFIDSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMComFIDSubPanel = new JPanel();
        JPanel sulMCliMComFIDSubPanel = new JPanel();

        JLabel mCliMComFIDLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS:");
        JLabel intervaloDatasMCliMComFIDLabel = new JLabel("INTERVALO DE DATAS");
        JLabel deMCliMComFIDLabel = new JLabel("De");
        JLabel ateMCliMComFIDLabel = new JLabel("Até");

        //Adição do calendário
        UtilDateModel modelMCliMComFID1 = new UtilDateModel();
        UtilDateModel modelMCliMComFID2 = new UtilDateModel();

        ResourceBundle b = ResourceBundle.getBundle("Text");

        Properties p = convertResourceBundleToProperties(b);
        JDatePanelImpl datePanelMCliMComFID1 = new JDatePanelImpl(modelMCliMComFID1, p);
        datePickerMCliMComFID1 = new JDatePickerImpl(datePanelMCliMComFID1, new DateLabelFormatter());

        JDatePanelImpl datePanelMCliMComFID2 = new JDatePanelImpl(modelMCliMComFID2, p);
        JDatePickerImpl datePickerMCliMComFID2 = new JDatePickerImpl(datePanelMCliMComFID2, new DateLabelFormatter());

        JButton ptEnMCliMComFIDButton = new JButton("PT/EN");
        JButton voltarMCliMComFIDButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMComFIDButton = new JButton("VOLTAR");
        JButton pesquisarMCliMComFIDButton = new JButton("PESQUISAR");

        mCliMComFIDSuperPanel.add(norteMCliMComFIDSubPanel, "North");
        mCliMComFIDSuperPanel.add(centroMCliMComFIDSubPanel, "Center");
        mCliMComFIDSuperPanel.add(sulMCliMComFIDSubPanel, "South");

        JPanel norteMCliMComFIDSSPanel = new JPanel();
        norteMCliMComFIDSSPanel.setLayout(new FlowLayout());
        norteMCliMComFIDSSPanel.add(mCliMComFIDLabel);
        norteMCliMComFIDSubPanel.add(norteMCliMComFIDSSPanel, BorderLayout.CENTER);
        norteMCliMComFIDSubPanel.add(ptEnMCliMComFIDButton, BorderLayout.EAST);

        JPanel centroMCliMComFIDSSPanel = new JPanel();
        centroMCliMComFIDSSPanel.setLayout(new FlowLayout());
        centroMCliMComFIDSubPanel.add(centroMCliMComFIDSSPanel, BorderLayout.WEST);

        JPanel centroMCliMComFIDSSPanel1 = new JPanel();
        centroMCliMComFIDSSPanel1.setLayout(new FlowLayout());
        centroMCliMComFIDSubPanel.add(centroMCliMComFIDSSPanel1, BorderLayout.WEST);

        JPanel centroMCliMComFIDSSPanel2 = new JPanel();
        centroMCliMComFIDSSPanel2.setLayout(new FlowLayout());
        centroMCliMComFIDSubPanel.add(centroMCliMComFIDSSPanel2, BorderLayout.WEST);

        centroMCliMComFIDSSPanel3 = new JPanel();
        centroMCliMComFIDSSPanel3.setLayout(new FlowLayout());
        centroMCliMComFIDSubPanel.add(centroMCliMComFIDSSPanel3, BorderLayout.WEST);

        centroMCliMComFIDSSPanel.add(intervaloDatasMCliMComFIDLabel);
        centroMCliMComFIDSSPanel1.add(deMCliMComFIDLabel);
        centroMCliMComFIDSSPanel1.add(datePickerMCliMComFID1);
        centroMCliMComFIDSSPanel2.add(ateMCliMComFIDLabel);
        centroMCliMComFIDSSPanel2.add(datePickerMCliMComFID2);

        sulMCliMComFIDSubPanel.setLayout(new FlowLayout());
        sulMCliMComFIDSubPanel.add(voltarMCliMComFIDButton);
        sulMCliMComFIDSubPanel.add(retornarMCliMComFIDButton);
        sulMCliMComFIDSubPanel.add(pesquisarMCliMComFIDButton);

        voltarMCliMComFIDButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliMComFIDButton.addActionListener(a -> mostrarJanela(MCLIMCOM_CARD));

        //TODO verificar porque sempre diz que não tem comentários se há comentários
        pesquisarMCliMComFIDButton.addActionListener(e -> {
            GregorianCalendar dataMCliMComFID1 = (GregorianCalendar) datePickerMCliMComFID1.getJFormattedTextField().getValue();
            GregorianCalendar dataMCliMComFID2 = (GregorianCalendar) datePickerMCliMComFID2.getJFormattedTextField().getValue();
            ArrayList<Comentario> listaComentarioID = sistema.consultarListaComentariosPorIntervaloDatas(dataMCliMComFID1, dataMCliMComFID2);

            if (dataMCliMComFID1 == null) {
                JOptionPane.showMessageDialog(((Component) e.getSource()).getParent(), "A data inicial deve ser preenchida");
                datePickerMCliMComFID1.requestFocus();
            }
            if (dataMCliMComFID2 == null) {
                JOptionPane.showMessageDialog(((Component) e.getSource()).getParent(), "A data final deve ser preenchida");
                datePickerMCliMComFID2.requestFocus();
            }
            if (listaComentarioID != null && !listaComentarioID.isEmpty()) {
                String[][] dadosMCliMComFIDSPanel = new String[listaComentarioID.size()][5];
                int i = 0;
                DateLabelFormatter dateFormatterMCliMComFID = new DateLabelFormatter();
                for (Comentario cID : listaComentarioID) {
                    try {
                        dadosMCliMComFIDSPanel[i][0] = dateFormatterMCliMComFID.dateTimeToString(cID.getDataComentario());
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    dadosMCliMComFIDSPanel[i][1] = cID.getCliente().getNome();
                    dadosMCliMComFIDSPanel[i][2] = cID.getRestaurante().getNome();
                    dadosMCliMComFIDSPanel[i][3] = cID.getOpiniao();
                    dadosMCliMComFIDSPanel[i][4] = "" + cID.getPontuacao();
                    i++;
                }
                String[] nomeColunasMCliMComFIDSSPanel = new String[]{"DATA", "CLIENTE", "RESTAURANTE", "COMENTÁRIO", "PONTUAÇÃO"};
                JTable tabelaMCliMComFIDSSPanel = new JTable(dadosMCliMComFIDSPanel, nomeColunasMCliMComFIDSSPanel);
                JScrollPane jscrollMCliMComFID = new JScrollPane(tabelaMCliMComFIDSSPanel);
                centroMCliMComFIDResultadoSSPanel.add(jscrollMCliMComFID, BorderLayout.CENTER);
                mostrarJanela(MCLIMCOMFIDRESULTADO_CARD);
            } else {
                JOptionPane.showMessageDialog(null, "Não existem comentários!");
            }
        });
    }

    //////MENU CLIENTE – CONSULTAR COMENTÁRIOS - INTERVALO DE DATAS - RESULTADO//////////
    private void construirPanelMCliMComFIDResultado (JPanel MCliMComFIDResultadoSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliMComFIDResultadoSubPanel = new JPanel();
        norteMCliMComFIDResultadoSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliMComFIDResultadoSubPanel = new JPanel();
        JPanel sulMCliMComFIDResultadoSubPanel = new JPanel();

        JLabel MCliMComFIDResultadoLabel = new JLabel("MENU CLIENTE - CONSULTAR COMENTÁRIOS:");
        JLabel intervaloDatasMCliMComFIDResultadoLabel = new JLabel("INTERVALO DE DATAS");

        JButton ptEnMCliMComFIDResultadoButton = new JButton("PT/EN");
        JButton voltarMCliMComFIDResultadoButton = new JButton("MENU CLIENTE");
        JButton retornarMCliMComFIDResultadoButton = new JButton("VOLTAR");
        JButton pesquisarMCliMComFIDResultadoButton = new JButton("PESQUISAR");

        MCliMComFIDResultadoSuperPanel.add(norteMCliMComFIDResultadoSubPanel, "North");
        MCliMComFIDResultadoSuperPanel.add(centroMCliMComFIDResultadoSubPanel, "Center");
        MCliMComFIDResultadoSuperPanel.add(sulMCliMComFIDResultadoSubPanel, "South");

        JPanel norteMCliMComFIDResultadoSSPanel = new JPanel();
        norteMCliMComFIDResultadoSSPanel.setLayout(new FlowLayout());
        norteMCliMComFIDResultadoSSPanel.add(MCliMComFIDResultadoLabel);
        norteMCliMComFIDResultadoSubPanel.add(norteMCliMComFIDResultadoSSPanel, BorderLayout.CENTER);
        norteMCliMComFIDResultadoSubPanel.add(ptEnMCliMComFIDResultadoButton, BorderLayout.EAST);

        centroMCliMComFIDResultadoSSPanel = new JPanel();
        centroMCliMComFIDResultadoSubPanel.add(centroMCliMComFIDResultadoSSPanel, BorderLayout.CENTER);

        sulMCliMComFIDResultadoSubPanel.setLayout(new FlowLayout());
        sulMCliMComFIDResultadoSubPanel.add(voltarMCliMComFIDResultadoButton);
        sulMCliMComFIDResultadoSubPanel.add(retornarMCliMComFIDResultadoButton);
        sulMCliMComFIDResultadoSubPanel.add(pesquisarMCliMComFIDResultadoButton);

        voltarMCliMComFIDResultadoButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliMComFIDResultadoButton.addActionListener(a -> mostrarJanela(MCLIMCOM_CARD));

    }

    ////////////////////MENU CLIENTE - ACTUALIZAR DADOS /////////////////////////
    private void construirPanelMCliAtDados (JPanel mCliAtDadosSuperPanel){

        passwordValido = false;
        confirmarPasswordValido = false;

        /////SUBPAINEIS//////
        JPanel norteAtDadosMCliSubPanel = new JPanel();
        norteAtDadosMCliSubPanel.setLayout(new BorderLayout());
        JPanel centroAtDadosMCliSubPanel = new JPanel();
        JPanel sulAtDadosMCliSubPanel = new JPanel();

        JLabel atDadosMCliLabel = new JLabel("ACTUALIZAR DADOS");
        atDadosMCliLabel.setForeground(Color.BLUE);
        JLabel nomeAtualizarMCliMCliLabel = new JLabel("Nome");
        JLabel emailAtualizarMCliMCliLabel = new JLabel("E-mail");
        JLabel moradaAtualizarMCliMCliLabel = new JLabel("Morada");
        JLabel telemovelAtualizarMCliMCliLabel = new JLabel("Telemóvel");
        JLabel usernameAtualizarMCliMCliLabel = new JLabel("Username");
        JLabel passwordAtualizarMCliMCliLabel = new JLabel("Password");
        JLabel novaPasswordAtualizarMCliMCliLabel = new JLabel("Nova Password");
        JLabel confirmarPasswordAtualizarMCliMCliLabel = new JLabel("Confirmar Nova Password");

        JTextField nomeCliMCliText = new JTextField(sistema.getClienteAtivo().getNome(), 20);
        nomeCliMCliText.setMargin(new Insets(3, 3, 3, 3));
        JTextField emailCliMCliText = new JTextField(sistema.getClienteAtivo().getEmail(), 20);
        JTextField moradaCliMCliText = new JTextField(sistema.getClienteAtivo().getMorada(), 20);
        JTextField telemovelCliMCliText = new JTextField(sistema.getClienteAtivo().getTelefone(), 10);
        //JTextField telemovelCliMCliText = new JFormattedTextField(mascaraTelemovel);
        //telemovelCliMCliText.setColumns(20);
        JTextField usernameCliMCliText = new JTextField(sistema.getClienteAtivo().getUsername(), 20);

        JPasswordField passwordCliMCliField = new JPasswordField(sistema.getClienteAtivo().getPassword(), 20);
        passwordCliMCliField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordValido = true;
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordCliMCliField.getPassword().length < 6) {
                    passwordValido = false;
                }

            }
        });
        //TODO confirmar se deu certo
        JPasswordField novaPasswordCliMCliField = new JPasswordField(20);
        novaPasswordCliMCliField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                passwordValido = true;
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordCliMCliField.getPassword().length < 6) {
                    passwordValido = false;
                }

            }
        });

        JPasswordField confirmarNovaPassawordCliMCliField = new JPasswordField(20);
        confirmarNovaPassawordCliMCliField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                confirmarPasswordValido = true;
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (!passwordCliMCliField.getPassword().equals(confirmarNovaPassawordCliMCliField.getPassword())) {
                    confirmarPasswordValido = false;
                }
            }
        });

        JButton ptEnAtDadosMCliButton = new JButton("PT/EN");
        JButton voltarCliMCliButton = new JButton("MENU CLIENTE");
        JButton actualizarCliMCliButton = new JButton("ACTUALIZAR");

        mCliAtDadosSuperPanel.add(norteAtDadosMCliSubPanel, "North");
        mCliAtDadosSuperPanel.add(centroAtDadosMCliSubPanel, "Center");
        mCliAtDadosSuperPanel.add(sulAtDadosMCliSubPanel, "South");

        JPanel norteAtDadosMCliSSPanel = new JPanel();
        norteAtDadosMCliSSPanel.setLayout(new FlowLayout());
        norteAtDadosMCliSSPanel.add(atDadosMCliLabel);
        norteAtDadosMCliSubPanel.add(norteAtDadosMCliSSPanel, BorderLayout.CENTER);
        norteAtDadosMCliSubPanel.add(ptEnAtDadosMCliButton, BorderLayout.EAST);

        JPanel centroAtDadosMCliSSPanel = new JPanel();
        centroAtDadosMCliSSPanel.setLayout(new GridLayout(8, 2));
        centroAtDadosMCliSubPanel.add(centroAtDadosMCliSSPanel);
        centroAtDadosMCliSSPanel.add(nomeAtualizarMCliMCliLabel);
        centroAtDadosMCliSSPanel.add(nomeCliMCliText);
        centroAtDadosMCliSSPanel.add(emailAtualizarMCliMCliLabel);
        centroAtDadosMCliSSPanel.add(emailCliMCliText);
        centroAtDadosMCliSSPanel.add(moradaAtualizarMCliMCliLabel);
        centroAtDadosMCliSSPanel.add(moradaCliMCliText);
        centroAtDadosMCliSSPanel.add(telemovelAtualizarMCliMCliLabel);
        centroAtDadosMCliSSPanel.add(telemovelCliMCliText);
        centroAtDadosMCliSSPanel.add(usernameAtualizarMCliMCliLabel);
        centroAtDadosMCliSSPanel.add(usernameCliMCliText);
        centroAtDadosMCliSSPanel.add(passwordAtualizarMCliMCliLabel);
        centroAtDadosMCliSSPanel.add(passwordCliMCliField);
        centroAtDadosMCliSSPanel.add(novaPasswordAtualizarMCliMCliLabel);
        centroAtDadosMCliSSPanel.add(novaPasswordCliMCliField);
        centroAtDadosMCliSSPanel.add(confirmarPasswordAtualizarMCliMCliLabel);
        centroAtDadosMCliSSPanel.add(confirmarNovaPassawordCliMCliField);

        sulAtDadosMCliSubPanel.setLayout(new FlowLayout());
        sulAtDadosMCliSubPanel.add(voltarCliMCliButton);
        sulAtDadosMCliSubPanel.add(actualizarCliMCliButton);

        actualizarCliMCliButton.addActionListener(a -> {
//            if (!passwordValido) {
//                JOptionPane.showMessageDialog(((Component) a.getSource()).getParent(), "Password Inválido: deve conter o mínimo de 6 caracteres!");
//                passwordCliMCliField.requestFocus();
//                return;
            //}
            if (!passwordValido) {
                JOptionPane.showMessageDialog(((Component) a.getSource()).getParent(), "Password Inválido: deve conter o mínimo de 6 caracteres!");
                passwordCliMCliField.requestFocus();
                return;
            }
            if (!confirmarPasswordValido) {
                JOptionPane.showMessageDialog(((Component) a.getSource()).getParent(), "Password Inválido: deve ser igual password!");
                confirmarNovaPassawordCliMCliField.requestFocus();
                return;
            }
            //TODO faz-se necessário atualizar  método atualizarDados Cliente, retirando o password e criar um novo metodo para atualização de password
            sistema.atualizarDadosCliente(nomeCliMCliText.getText(),
                    moradaCliMCliText.getText(),
                    telemovelCliMCliText.getText(),
                    emailCliMCliText.getText(),
                    passwordCliMCliField.getPassword().toString(),
//                    novaPasswordCliMCliField.getPassword().toString(),
//                    confirmarNovaPassawordCliMCliField.getPassword().toString());
                    new String(novaPasswordCliMCliField.getPassword()),
                    new String(confirmarNovaPassawordCliMCliField.getPassword()));
        });
        voltarCliMCliButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }


    // todo verificar os botões editar e apagar que estão em conflito com visualizar
//////MENU CLIENTE – RESERVAS ACTIVAS//////////
    private void construirPanelMCliResAct (JPanel mCliResActSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliResActSubPanel = new JPanel();
        norteMCliResActSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliResActSubPanel = new JPanel();
        JPanel sulMCliResActSubPanel = new JPanel();

        JLabel mCliTitHistResActLabel = new JLabel("MENU CLIENTE - RESERVAS ACTIVAS");


        JButton ptEnMCliRestButton = new JButton("PT/EN");
        JButton voltarMCliResActButton = new JButton("MENU CLIENTE");
        JButton visualizarMCliResActButton = new JButton("VISUALIZAR");
        JButton retonarMCliResActButton = new JButton("RETORNAR");

        JRadioButton editarMCliResActButton = new JRadioButton("EDITAR");
        JRadioButton apagarMCliResActButton = new JRadioButton("APAGAR");

        ButtonGroup group = new ButtonGroup();
        group.add(editarMCliResActButton);
        group.add(apagarMCliResActButton);
//            ArrayList<Reserva> listaReseAct = sistema.consultarReservasAtivas();
//                    if (listaReseAct != null && !listaReseAct.isEmpty()) {
//                        String[][] dadosMCliResActSSPanel = new String[listaReseAct()][2];
//                        DateLabelFormatter dateFormatterMCliResAct = new DateLabelFormatter();
//                        int i = 0;
//                        for (Reserva resv : listaReseAct) {
//                            try {
//                                dadosMCliResActSSPanel[i][0] = dateFormatterMCliResAct.dateTimeToString(resv.getData());//Deveria ser da reserva
//                            } catch (ParseException parseException) {
//                                parseException.printStackTrace();
//                            }
//                            dadosMCliResActSSPanel[i][1] = resv.getRestaurante().getNome();
//                            i++;
//                        }
//                        String[] nomeColunasMCliResActSSPanel = new String[]{"DATA","RESTAURANTE"};
//                        JTable tabelaMCliResActSSPanel = new JTable(dadosMCliResActSSPanel, nomeColunasMCliResActSSPanel);
//                        JScrollPane jScrollMCliResAct = new JScrollPane(tabelaMCliResActSSPanel);
//                        tabelaMCliResActSSPanel.setVisible(true);
//                        panel.add(jScrollMCliResAct, BorderLayout.CENTER);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Não existem reservas!");
//                        mostrarJanela(MCLIHISRES_CARD);
//                }

        mCliResActSuperPanel.add(norteMCliResActSubPanel, "North");
        mCliResActSuperPanel.add(centroMCliResActSubPanel, "Center");
        mCliResActSuperPanel.add(sulMCliResActSubPanel, "South");

        JPanel norteMCliResActSSPanel = new JPanel();
        norteMCliResActSSPanel.setLayout(new FlowLayout());
        norteMCliResActSSPanel.add(mCliTitHistResActLabel);
        norteMCliResActSubPanel.add(norteMCliResActSSPanel, BorderLayout.CENTER);
        norteMCliResActSubPanel.add(ptEnMCliRestButton, BorderLayout.EAST);

        JPanel centroMCliResActSSPanel = new JPanel();
        centroMCliResActSSPanel.setLayout(new FlowLayout());
        centroMCliResActSubPanel.add(centroMCliResActSSPanel, BorderLayout.WEST);

        JPanel centroMCliResActSSPanel1 = new JPanel();
        centroMCliResActSSPanel1.setLayout(new FlowLayout());
        centroMCliResActSubPanel.add(centroMCliResActSSPanel1, BorderLayout.WEST);

        JPanel centroMCliResActSSPanel2 = new JPanel();
        centroMCliResActSSPanel2.setLayout(new FlowLayout());
        centroMCliResActSubPanel.add(centroMCliResActSSPanel2, BorderLayout.WEST);

        centroMCliResActSSPanel2.add(editarMCliResActButton);
        centroMCliResActSSPanel2.add(apagarMCliResActButton);

        sulMCliResActSubPanel.setLayout(new FlowLayout());
        sulMCliResActSubPanel.add(voltarMCliResActButton);
        sulMCliResActSubPanel.add(retonarMCliResActButton);
        sulMCliResActSubPanel.add(visualizarMCliResActButton);

        visualizarMCliResActButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        editarMCliResActButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        apagarMCliResActButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retonarMCliResActButton.addActionListener(a -> mostrarJanela(MCLIRESERVAS_CARD));

        voltarMCliResActButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }

    //////MENU CLIENTE – FAZER RESERVAS//////////
    private void construirPanelMCliFazerRes (JPanel mCliFazerResSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliFResSubPanel = new JPanel();
        norteMCliFResSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliFResSubPanel = new JPanel();
        JPanel sulMCliFResSubPanel = new JPanel();

        JLabel mCliTitFResLabel = new JLabel("MENU CLIENTE - FAZER RESERVAS");
        JLabel tipoResMCliFResLabel = new JLabel("TIPO DE RESERVA:");
        JLabel nomeResMCliFResLabel = new JLabel("RESTAURANTE:");

        restaurantesResMCliFResCBox = new JComboBox();

        JRadioButton presencialMCliFResRButton = new JRadioButton("PRESENCIAL");
        JRadioButton takeAwayMCliFResRButton = new JRadioButton("TAKE-AWAY");

        ButtonGroup group = new ButtonGroup();
        group.add(presencialMCliFResRButton);
        group.add(takeAwayMCliFResRButton);

        JButton ptEnMCliFResButton = new JButton("PT/EN");
        JButton voltarMCliFResButton = new JButton("MENU CLIENTE");
        JButton retornarMCliFResButton = new JButton("VOLTAR");

        mCliFazerResSuperPanel.add(norteMCliFResSubPanel, "North");
        mCliFazerResSuperPanel.add(centroMCliFResSubPanel, "Center");
        mCliFazerResSuperPanel.add(sulMCliFResSubPanel, "South");

        JPanel norteMCliFResSSPanel = new JPanel();
        norteMCliFResSSPanel.setLayout(new FlowLayout());
        norteMCliFResSSPanel.add(mCliTitFResLabel);
        norteMCliFResSubPanel.add(norteMCliFResSSPanel, BorderLayout.CENTER);
        norteMCliFResSubPanel.add(ptEnMCliFResButton, BorderLayout.EAST);

        JPanel centroMCliFResSSPanel = new JPanel();
        centroMCliFResSSPanel.setLayout(new FlowLayout());
        centroMCliFResSubPanel.add(centroMCliFResSSPanel, BorderLayout.WEST);

        JPanel centroMCliFResSSPanel1 = new JPanel();
        centroMCliFResSSPanel1.setLayout(new FlowLayout());
        centroMCliFResSubPanel.add(centroMCliFResSSPanel1, BorderLayout.WEST);

        JPanel centroMCliFResSSPanel2 = new JPanel();
        centroMCliFResSSPanel2.setLayout(new FlowLayout());
        centroMCliFResSubPanel.add(centroMCliFResSSPanel2, BorderLayout.WEST);

        JPanel centroMCliFResSSPanel3 = new JPanel();
        centroMCliFResSSPanel3.setLayout(new GridLayout(1, 1));
        centroMCliFResSubPanel.add(centroMCliFResSSPanel3, BorderLayout.WEST);

        //TODO ver como listar o restaurantes
        centroMCliFResSSPanel1.add(nomeResMCliFResLabel);
        centroMCliFResSSPanel1.add(restaurantesResMCliFResCBox);
        centroMCliFResSSPanel2.add(tipoResMCliFResLabel);
        centroMCliFResSSPanel3.add(presencialMCliFResRButton);
        centroMCliFResSSPanel3.add(takeAwayMCliFResRButton);

        sulMCliFResSubPanel.setLayout(new FlowLayout());
        sulMCliFResSubPanel.add(voltarMCliFResButton);
        sulMCliFResSubPanel.add(retornarMCliFResButton);

        presencialMCliFResRButton.addActionListener(a -> mostrarJanela(MCLIFAZERRESP_CARD));

        takeAwayMCliFResRButton.addActionListener(a -> mostrarJanela(MCLIFAZERRESTA_CARD));

        retornarMCliFResButton.addActionListener(a -> mostrarJanela(MCLIRESERVAS_CARD));

        voltarMCliFResButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));
    }


    //////MENU CLIENTE – FAZER RESERVA PRESENCIAL//////////
    private void construirPanelMCliFazerResP (JPanel mCliFazerResPSuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliFResPSubPanel = new JPanel();
        norteMCliFResPSubPanel.setLayout(new BorderLayout());
        JPanel centroMCliFResPSubPanel = new JPanel();
        JPanel sulMCliFResPSubPanel = new JPanel();

        JLabel mCliTitFResPLabel = new JLabel("FAZER RESERVAS PRESENCIAL");
        JLabel diaMCliFResPLabel = new JLabel("DIA");
        JLabel horaMCliFResPLabel = new JLabel("HORA");
        JLabel qtdePessoasMCliFResPLabel = new JLabel("QUANTIDADE DE PESSOAS");

        JTextField horaMCliFResText = new JTextField(5);
        JTextField qtdePessoasMCliFResText = new JTextField(1);

        JButton ptEnMCliFResPButton = new JButton("PT/EN");
        JButton voltarMCliFResPButton = new JButton("MENU CLIENTE");
        JButton confirmarMCliFResPButton = new JButton("CONFIRMAR");
        JButton retornarMCliFResPButton = new JButton("VOLTAR");

        //Adição do calendário
        UtilDateModel model6 = new UtilDateModel();

        ResourceBundle b = ResourceBundle.getBundle("Text");

        Properties p = convertResourceBundleToProperties(b);
        JDatePanelImpl datePanel5 = new JDatePanelImpl(model6, p);
        JDatePickerImpl datePicker6 = new JDatePickerImpl(datePanel5, new DateLabelFormatter());

        mCliFazerResPSuperPanel.add(norteMCliFResPSubPanel, "North");
        mCliFazerResPSuperPanel.add(centroMCliFResPSubPanel, "Center");
        mCliFazerResPSuperPanel.add(sulMCliFResPSubPanel, "South");

        JPanel norteMCliFResSPPSSPanel = new JPanel();
        norteMCliFResSPPSSPanel.setLayout(new FlowLayout());
        norteMCliFResSPPSSPanel.add(mCliTitFResPLabel);
        norteMCliFResPSubPanel.add(norteMCliFResSPPSSPanel, BorderLayout.CENTER);
        norteMCliFResPSubPanel.add(ptEnMCliFResPButton, BorderLayout.EAST);

        JPanel centroMCliFResPSSPanel = new JPanel();
        centroMCliFResPSSPanel.setLayout(new FlowLayout());
        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel, BorderLayout.WEST);

        JPanel centroMCliFResPSSPanel1 = new JPanel();
        centroMCliFResPSSPanel1.setLayout(new FlowLayout());
        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel1, BorderLayout.WEST);

        JPanel centroMCliFResPSSPanel2 = new JPanel();
        centroMCliFResPSSPanel2.setLayout(new FlowLayout());
        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel2, BorderLayout.WEST);

        JPanel centroMCliFResPSSPanel3 = new JPanel();
        centroMCliFResPSSPanel3.setLayout(new GridLayout(1, 1));
        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel3, BorderLayout.WEST);

        JPanel centroMCliFResPSSPanel4 = new JPanel();
        centroMCliFResPSSPanel4.setLayout(new FlowLayout());
        centroMCliFResPSubPanel.add(centroMCliFResPSSPanel4, BorderLayout.WEST);

        centroMCliFResPSSPanel.add(diaMCliFResPLabel);
        centroMCliFResPSSPanel.add(datePicker6);
        centroMCliFResPSSPanel1.add(horaMCliFResPLabel);
        centroMCliFResPSSPanel2.add(horaMCliFResText);

        centroMCliFResPSSPanel3.add(qtdePessoasMCliFResPLabel);
        centroMCliFResPSSPanel3.add(qtdePessoasMCliFResText);

        sulMCliFResPSubPanel.setLayout(new FlowLayout());
        sulMCliFResPSubPanel.add(voltarMCliFResPButton);
        sulMCliFResPSubPanel.add(retornarMCliFResPButton);
        sulMCliFResPSubPanel.add(confirmarMCliFResPButton);

        voltarMCliFResPButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliFResPButton.addActionListener(a -> mostrarJanela(MCLIFAZERRES_CARD));

        //todo ver os encaminhamentos
        confirmarMCliFResPButton.addActionListener(e -> {
            try {
                Optional<Restaurante> res = sistema.getListaRestaurantes().stream().filter(r -> r.getNome().equals(restaurantesResMCliFResCBox.getSelectedItem())).findFirst();
                sistema.adicionarReserva(sistema.getClienteAtivo(), res.get(), (GregorianCalendar) datePicker6.getJFormattedTextField().getValue(), LocalTime.now(), Presencial.class, 1, 1);
                JOptionPane.showMessageDialog(this, "Reserva confirmada com sucesso!");
                mostrarJanela(MENUCLIENTE_CARD);
            } catch (Exception e2) {
                e2.printStackTrace();
                JOptionPane.showMessageDialog(this, "Não foi possivel confirmar a reserva!");
            }
        });

    }

    //////MENU CLIENTE – FAZER RESERVA TAKE-AWAY//////////
    private void construirPanelMCliFazerResTA (JPanel mCliFazerResTASuperPanel){

        /////SUBPAINEIS//////
        JPanel norteMCliFResTASubPanel = new JPanel();
        norteMCliFResTASubPanel.setLayout(new BorderLayout());
        JPanel centroMCliFResTASubPanel = new JPanel();
        JPanel sulMCliFResTASubPanel = new JPanel();

        JLabel mCliTitFResTALabel = new JLabel("FAZER RESERVAS TAKE-AWAY");
        JLabel horaMCliFResTALabel = new JLabel("HORA");
        JLabel qtdePratosMCliFResTALabel = new JLabel("QUANTIDADE");
        JLabel pratosMCliFResTALabel = new JLabel("PRATOS");

        JTextField horaMCliFResTAText = new JTextField(5);
        JTextField qtdePratosMCliFResTAText = new JTextField(5);

        JButton ptEnMCliFResTAButton = new JButton("PT/EN");
        JButton voltarMCliFResTAButton = new JButton("MENU CLIENTE");
        JButton adicionarMCliFResTAButton = new JButton("ADICIONAR");
        JButton retornarMCliFResButton = new JButton("VOLTAR");
        JButton finalizarMCliFResTAButton = new JButton("FINALIZAR");

        mCliFazerResTASuperPanel.add(norteMCliFResTASubPanel, "North");
        mCliFazerResTASuperPanel.add(centroMCliFResTASubPanel, "Center");
        mCliFazerResTASuperPanel.add(sulMCliFResTASubPanel, "South");

        JPanel norteMCliFResTASSPanel = new JPanel();
        norteMCliFResTASSPanel.setLayout(new FlowLayout());
        norteMCliFResTASSPanel.add(mCliTitFResTALabel);
        norteMCliFResTASubPanel.add(norteMCliFResTASSPanel, BorderLayout.CENTER);
        norteMCliFResTASubPanel.add(ptEnMCliFResTAButton, BorderLayout.EAST);

        JPanel centroMCliFResTASSPanel = new JPanel();
        centroMCliFResTASSPanel.setLayout(new FlowLayout());
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel, BorderLayout.WEST);

        JPanel centroMCliFResTASSPanel1 = new JPanel();
        centroMCliFResTASSPanel1.setLayout(new FlowLayout());
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel1, BorderLayout.WEST);

        JPanel centroMCliFResTASSPanel2 = new JPanel();
        centroMCliFResTASSPanel2.setLayout(new FlowLayout());
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel2, BorderLayout.WEST);

        JPanel centroMCliFResTASSPanel3 = new JPanel();
        centroMCliFResTASSPanel3.setLayout(new FlowLayout());
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel3, BorderLayout.CENTER);

        JPanel centroMCliFResTASSPanel4 = new JPanel();
        centroMCliFResTASSPanel4.setLayout(new FlowLayout());
        centroMCliFResTASubPanel.add(centroMCliFResTASSPanel4, BorderLayout.WEST);

        centroMCliFResTASSPanel.add(horaMCliFResTALabel);
        centroMCliFResTASSPanel1.add(horaMCliFResTAText);
        centroMCliFResTASSPanel3.add(pratosMCliFResTALabel);
        //TODO fazer aparecer a lista de pratos

        centroMCliFResTASSPanel4.add(qtdePratosMCliFResTALabel);
        centroMCliFResTASSPanel4.add(qtdePratosMCliFResTAText);

        sulMCliFResTASubPanel.setLayout(new FlowLayout());
        sulMCliFResTASubPanel.add(voltarMCliFResTAButton);
        sulMCliFResTASubPanel.add(retornarMCliFResButton);
        sulMCliFResTASubPanel.add(adicionarMCliFResTAButton);
        sulMCliFResTASubPanel.add(finalizarMCliFResTAButton);

        voltarMCliFResTAButton.addActionListener(a -> mostrarJanela(MENUCLIENTE_CARD));

        retornarMCliFResButton.addActionListener(a -> mostrarJanela(MCLIFAZERRES_CARD));

        //TODO fazer nova página com valor final (botoes de finalizar, editar e remover com quantidade)
        finalizarMCliFResTAButton.addActionListener(a -> mostrarJanela(MCLIFAZERRES_CARD));

        //TODO ver os encaminhamentos
        adicionarMCliFResTAButton.addActionListener(e -> mostrarJanela(MCLIFAZERRES_CARD));
        this.setVisible(true);
    }
}