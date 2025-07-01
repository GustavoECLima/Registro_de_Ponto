import java.util.Scanner;
import java.util.ArrayList;

public class TrabalhoKarize2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        ArrayList<String> nome = new ArrayList<>();
        ArrayList<Integer> entrada = new ArrayList<>();
        ArrayList<Integer> saida = new ArrayList<>();
        ArrayList<Integer> entradaREAL = new ArrayList<>();
        ArrayList<Integer> saidaREAL = new ArrayList<>();
        ArrayList<Integer> limite = new ArrayList<>();
        ArrayList<Integer> CPF = new ArrayList<>();
        ArrayList<Integer> horasfaltando = new ArrayList<>();
        ArrayList<Boolean> extras = new ArrayList<>();
        boolean encontrado = false;
        int horas = 0;
        int minutos = 0;

        int Fcadastrados = 0;

        while (true) {
            System.out.println("\nFuncionário ou RH? (F/R ou S para sair): ");
            char opcao = teclado.next().toUpperCase().charAt(0);
            teclado.nextLine();

            if (opcao == 'R') {
                System.out.println("\nCadastrar, Alterar horarios ou ver Historico de Funcionarios?(C/A/H)");
                char opcao2 = teclado.next().toUpperCase().charAt(0);
                teclado.nextLine();
                if(opcao2 == 'H'){
                    if (Fcadastrados == 0) {
                    System.out.println("\nNao ha funcionarios cadastrados");
                    }else{
                        for(int id = 0; id < Fcadastrados; id++){

                            funcionarios(id, nome, entrada, saida, entradaREAL, saidaREAL, limite, CPF, horasfaltando, extras);
                            // System.out.println("=============================================================================================");
                            // System.out.println("\nFUNCIONARIO "+nome.get(id).toUpperCase());
                            // System.out.println("CPF: "+CPF.get(id));
                            // System.out.println("Horario Inicio de expediente: "+entrada.get(id));
                            // System.out.println("Horario Fim de expediente: "+saida.get(id));
                            // System.out.println("Em falta: "+horasfaltando.get(id)+" minutos");
                            // System.out.println("Horas extras: "+extras.get(id));
                            // System.out.println("\nUltima entrada: "+entradaREAL.get(id));
                            // System.out.println("Ultima saida: "+saidaREAL.get(id)+"\n");

                        }
                    }
                }else if(opcao2 == 'A'){
                    if (Fcadastrados == 0) {
                        System.out.println("\nNão há funcionários cadastrados.");
                    }else{
                        System.out.println("Deseja alterar horario de saida ou de entrada?(S/E)");
                        char escolhahr = teclado.next().toUpperCase().charAt(0);
                        
                            if(escolhahr == 'S'){
                                System.out.println("Insira o CPF que deseja alterar.");
                                int cpfreg = teclado.nextInt(); 
                            
                                for(int id = 0; id < Fcadastrados; id++){
                                    if(cpfreg == CPF.get(id)){
                                        System.out.println("Ola "+nome.get(id)+", insira o horario correto.");
                                        int horarionovo = teclado.nextInt();

                                        saidaREAL.set(id, horarionovo);

                                            extras.set(id,false);

                                        atualizar(id, entrada, saida, entradaREAL, saidaREAL, limite, horasfaltando, extras);

                                            // if(horasfaltando.get(id) != 0){
                                            //     int entradaPrevistaMin = (entrada.get(id) / 100) * 60 + (entrada.get(id) % 100);
                                            //     int saidaPrevistaMin = (saida.get(id) / 100) * 60 + (saida.get(id) % 100);
                                            //     int entradaRealMin = (entradaREAL.get(id) / 100) * 60 + (entradaREAL.get(id) % 100);
                                            //     int saidaRealMin = (saidaREAL.get(id) / 100) * 60 + (saidaREAL.get(id) % 100);

                                            //     int tempoPrevisto = saidaPrevistaMin - entradaPrevistaMin;
                                            //     int tempoTrabalhado = saidaRealMin - entradaRealMin;
                                            //     int limiteExtra = limite.get(id);

                                            // if (tempoTrabalhado < tempoPrevisto) {
                                            //         horasfaltando.set(id, tempoPrevisto - tempoTrabalhado);
                                            //         extras.set(id,false);
                                            // } else if (tempoTrabalhado == tempoPrevisto) {
                                            //         horasfaltando.set(id, 0);
                                            //         extras.set(id,false);
                                            // } else if (tempoTrabalhado <= (tempoPrevisto + limiteExtra)) {
                                            //         horasfaltando.set(id, 0);
                                            //         extras.set(id,true);
                                            // } else {
                                            //         horasfaltando.set(id, 0);
                                            //         extras.set(id,false);
                                            // }
                                    }
                                } 
                            
                            }else if(escolhahr == 'E'){
                                System.out.println("Insira o CPF que deseja alterar.");
                                int cpfreg = teclado.nextInt(); 
                            
                                for(int id = 0; id < Fcadastrados; id++){
                                    if(cpfreg == CPF.get(id)){
                                        System.out.println("Ola "+nome.get(id)+", insira o horario correto.");
                                        int horarionovo = teclado.nextInt();

                                        entradaREAL.set(id, horarionovo);
                                        
                                        if(horasfaltando.get(id) != 0){

                                            atualizar(id, entrada, saida, entradaREAL, saidaREAL, limite, horasfaltando, extras);

                                                // int entradaPrevistaMin = (entrada.get(id) / 100) * 60 + (entrada.get(id) % 100);
                                                // int saidaPrevistaMin = (saida.get(id) / 100) * 60 + (saida.get(id) % 100);
                                                // int entradaRealMin = (entradaREAL.get(id) / 100) * 60 + (entradaREAL.get(id) % 100);
                                                // int saidaRealMin = (saidaREAL.get(id) / 100) * 60 + (saidaREAL.get(id) % 100);

                                                // int tempoPrevisto = saidaPrevistaMin - entradaPrevistaMin;
                                                // int tempoTrabalhado = saidaRealMin - entradaRealMin;
                                                // int limiteExtra = limite.get(id);

                                                // if (tempoTrabalhado < tempoPrevisto) {
                                                //     horasfaltando.set(id, tempoPrevisto - tempoTrabalhado);
                                                //     extras.set(id,false);
                                                // } else if (tempoTrabalhado == tempoPrevisto) {
                                                //     horasfaltando.set(id, 0);
                                                //     extras.set(id,false);
                                                // } else if (tempoTrabalhado <= (tempoPrevisto + limiteExtra)) {
                                                //     horasfaltando.set(id, 0);
                                                //     extras.set(id,true);
                                                // } else {
                                                //     horasfaltando.set(id, 0);
                                                //     extras.set(id,false);
                                                // }
                                        }

                                    } 
                                }
                            }else{
                                System.out.println("opcao invalida");
                            }
                        }
                        }else{

                        System.out.println("\nQuantos funcionários deseja cadastrar?: ");
                        int numcad = teclado.nextInt();
                        teclado.nextLine();

                        for (int i = 0; i < numcad; i++) {

                            System.out.println("\nInsira o nome do funcionário: ");
                            nome.add(teclado.nextLine());

                            System.out.println("Insira o CPF do funcionário: ");
                            CPF.add(teclado.nextInt());

                            entradaREAL.add(0);
                            saidaREAL.add(0);
                            horasfaltando.add(0);
                            extras.add(false);

/**=============================================================================================================================================================================================*/

                            int entradaH = lerHorarioValido(teclado, "Insira o horário de entrada do expediente (ex: 800 = 08:00): ");

                            entrada.add(entradaH);

/**=============================================================================================================================================================================================*/

                            int saidaH = lerHorarioValido(teclado, "Insira o horário de saída do expediente (ex: 1700 = 17:00): ");

                            saida.add(saidaH);

 /**=============================================================================================================================================================================================*/

                            System.out.println("Insira o limite de hora extra do funcionário:");
                            int limiteH = teclado.nextInt();
                            limite.add(limiteH * 100);
                                
                            teclado.nextLine();
                            Fcadastrados++;
                        }
                    }

            } else if (opcao == 'F') {
                if (Fcadastrados == 0) {
                    System.out.println("\nNão há funcionários cadastrados.");
                    break;
                }

                System.out.println("\nInsira seu CPF: ");
                int CPFdigitado = teclado.nextInt();

                for (int id = 0; id < Fcadastrados; id++) {
                    if (CPF.get(id) == CPFdigitado){
                        encontrado = true;

                        int entradaR = lerHorarioValido(teclado, "Insira seu horário de entrada: ");

                        entradaREAL.set(id, entradaR);

                        int saidaR = lerHorarioValido(teclado, "Insira seu horário de saída: ");

                        saidaREAL.set(id, saidaR);
                        
                        int entradaPrevistaMin = (entrada.get(id) / 100) * 60 + (entrada.get(id) % 100);
                        int saidaPrevistaMin = (saida.get(id) / 100) * 60 + (saida.get(id) % 100);
                        int entradaRealMin = (entradaREAL.get(id) / 100) * 60 + (entradaREAL.get(id) % 100);
                        int saidaRealMin = (saidaREAL.get(id) / 100) * 60 + (saidaREAL.get(id) % 100);

                        int tempoPrevisto = saidaPrevistaMin - entradaPrevistaMin;
                        int tempoTrabalhado = saidaRealMin - entradaRealMin;
                        int limiteExtra = limite.get(id);

                        // System.out.println("=============================================================================================");
                        // System.out.println("\nFUNCIONARIO " + nome.get(id) .toUpperCase());
                        // System.out.println("CPF: " + CPF.get(id) );
                        // System.out.println("Início do expediente: " + entrada.get(id) );
                        // System.out.println("Fim do expediente: " + saida.get(id) );
                        // System.out.println("Chegada: " + entradaREAL.get(id) );
                        // System.out.println("Saída: " + saidaREAL.get(id) );

                        funcionarios(id, nome, entrada, saida, entradaREAL, saidaREAL, limite, CPF, horasfaltando, extras);

                        if (tempoTrabalhado < tempoPrevisto) {
                            horasfaltando.set(id, tempoPrevisto - tempoTrabalhado);
                            extras.set(id,false);
                            System.out.println("Horas faltando: " + (tempoPrevisto - tempoTrabalhado) + " minutos");
                        } else if (tempoTrabalhado == tempoPrevisto) {
                            horasfaltando.set(id, 0);
                            extras.set(id,false);
                            System.out.println("Cumpriu as horas normalmente.");
                        } else if (tempoTrabalhado <= (tempoPrevisto + limiteExtra)) {
                            horasfaltando.set(id, 0);
                            extras.set(id,true);
                            System.out.println("Trabalhou horas extras.");
                        } else {
                            horasfaltando.set(id, 0);
                            extras.set(id,false);
                            System.out.println("Trabalhou além do limite. Contatar o RH.");
                        }
                        break;
                    }
                }

                if (!encontrado){
                    System.out.println("Funcionário não encontrado.");
                }
            }else if (opcao == 'S') {
                System.out.println("Encerrando o sistema...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        teclado.close();
    }

public static int lerHorarioValido(Scanner teclado, String mensagem) {
    int horas, minutos, horario;

    while (true) {
        System.out.println(mensagem);
        horario = teclado.nextInt();
        horas = horario / 100;
        minutos = horario % 100;

        if (horas >= 0 && horas < 24 && minutos >= 0 && minutos < 60) {
            return horario;
        } else {
            System.out.println("Horário inválido. Tente novamente.");
        }
    }
}

public static void atualizar(int id,
        ArrayList<Integer> entrada,
        ArrayList<Integer> saida,
        ArrayList<Integer> entradaREAL,
        ArrayList<Integer> saidaREAL,
        ArrayList<Integer> limite,
        ArrayList<Integer> horasfaltando,
        ArrayList<Boolean> extras) {

    int entradaPrevistaMin = (entrada.get(id) / 100) * 60 + (entrada.get(id) % 100);
    int saidaPrevistaMin = (saida.get(id) / 100) * 60 + (saida.get(id) % 100);
    int entradaRealMin = (entradaREAL.get(id) / 100) * 60 + (entradaREAL.get(id) % 100);
    int saidaRealMin = (saidaREAL.get(id) / 100) * 60 + (saidaREAL.get(id) % 100);

    int tempoPrevisto = saidaPrevistaMin - entradaPrevistaMin;
    int tempoTrabalhado = saidaRealMin - entradaRealMin;
    int limiteExtra = limite.get(id);

    if (tempoTrabalhado < tempoPrevisto) {
        horasfaltando.set(id, tempoPrevisto - tempoTrabalhado);
        extras.set(id, false);
    } else if (tempoTrabalhado == tempoPrevisto) {
        horasfaltando.set(id, 0);
        extras.set(id, false);
    } else if (tempoTrabalhado <= (tempoPrevisto + limiteExtra)) {
        horasfaltando.set(id, 0);
        extras.set(id, true);
    } else {
        horasfaltando.set(id, 0);
        extras.set(id, false);
    }
}


public static void funcionarios(int id,        
        ArrayList<String> nome,
        ArrayList<Integer> entrada,
        ArrayList<Integer> saida,
        ArrayList<Integer> entradaREAL,
        ArrayList<Integer> saidaREAL,
        ArrayList<Integer> limite,
        ArrayList<Integer> CPF,
        ArrayList<Integer> horasfaltando,
        ArrayList<Boolean> extras){

        atualizar(id, entrada, saida, entradaREAL, saidaREAL, limite, horasfaltando, extras);
                            System.out.println("=============================================================================================");
                            System.out.println("\nFUNCIONARIO "+nome.get(id).toUpperCase());
                            System.out.println("CPF: "+CPF.get(id));
                            System.out.println("Horario Inicio de expediente: "+entrada.get(id));
                            System.out.println("Horario Fim de expediente: "+saida.get(id));
                            System.out.println("Em falta: "+horasfaltando.get(id)+" minutos");
                            System.out.println("Horas extras: "+extras.get(id));
                            System.out.println("\nUltima entrada: "+entradaREAL.get(id));
                            System.out.println("Ultima saida: "+saidaREAL.get(id)+"\n");
}

}
