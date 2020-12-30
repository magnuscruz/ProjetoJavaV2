package com.company;
// ESTA CLASSE SÓ VAI SERVIR PARA GUARDAR CODIGO QUE PODE VIR A SER PRECISO MAIS TARDE!

public class AuxiliarGuardarCodigo {
}
//ERROS PEDIR AJUDA//
//1 ERRO//
/*
        sistema.getListaClientes().get(0).criarReservaPresencial(sistema.getListaRestaurantes().get(0),
                new GregorianCalendar(2020,0,10), LocalTime.of(13,30),
                1,5);

 */
//2 ERRO//
/*



 */




///////////// NO MAIN, A PARTE DE GUARDAR OBJECTOS! COM O SWITCH, PARA NAO GUARDAR SEMPRE////

/*
FicheiroDeObjectos ficheiroOb = new FicheiroDeObjectos();

//sistema.listaComentarios.add(new Comentario ("MB", 4, (Cliente)sistema.listaUtilizadores.get(0), (Restaurante)sistema.listaUtilizadores.get(1), 12, 12, 2020));
//sistema.listaUtilizadores.add(new Cliente ("Adriano", "rua x", "444545", "eeer@ggfg", "erd"));


        try {
                if (ficheiroOb.abreLeitura("FicheiroProjeto.dat")) {
                sistema = (Sistema) ficheiroOb.leObjecto();
                }
                } catch (Exception e) {
                System.out.println("EXCEPCAO: " + e.getMessage());
                }

                boolean a = true;
                do {
                System.out.println("1) ESCREVER OBJECTOS (LISTAS ETC) ");
                System.out.println("2) GRAVAR OBJECTOS");
                System.out.println("0) SAIR ");
                String opcao = sc.nextLine();
                switch (opcao) {
                ////COLOCAR AQUI TODAS OS ARRAYS LISTS////
                case "1":
                //sistema.listaComentarios.add(new Comentario("Excelente", 5, (Cliente) sistema.listaUtilizadores.get(2), (Restaurante)sistema.listaUtilizadores.get(1), 01,2, 2020 ));
                //sistema.listaUtilizadores.add(new Restaurante ("Xpto", "rua t", "4455555", "eee@hhh", "aaa","ert", 20, 10, 20, 11, 30, 15, 00, 17, 00, 23, 00));
                //sistema.listaUtilizadores.add(new Cliente("Xico","Rua", "966", "ze@a.pt", "Zezeze", "111111"));
                // sistema.utilizador.listaReservas.add(new TakeAway("Zeca", "Tacho", 2020, 7, 5, 18, 30, 5));

                break;
                case "2":
                try {
                ficheiroOb.abreEscrita("FicheiroProjeto.dat");
                ficheiroOb.escreveObjecto(sistema);
                ficheiroOb.fechaEscrita();
                ficheiroOb.fechaLeitura();
                } catch (Exception e) {
                }
                break;
                case "0":
                a = false;
                break;
                }
                }

                while (a);
 */

///////////////FIM 1 /////////////////////////////////////////////////////////
////////////////IMPRIMIR RESTAURANTES OU COMENTARIOS SO COM STATUS TRUE//////
// Modo é arquaico, encontrei uma maneira mais pratica e eficaz de o fazer, ver nos metodos getRestaurante
//e getCliente
/*
    System.out.println("LISTA UTILIZADORES C STATUS TRUE");
            sistema.getListaUtilizadores().get(1).setStatus(false);
            sistema.getListaUtilizadores().get(4).setStatus(false);
   */
