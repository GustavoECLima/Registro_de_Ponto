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

                                            if(horasfaltando.get(id) != 0){
                                                int entradaPrevistaMin = (entrada.get(id) / 100) * 60 + (entrada.get(id) % 100);
                                                int saidaPrevistaMin = (saida.get(id) / 100) * 60 + (saida.get(id) % 100);
                                                int entradaRealMin = (entradaREAL.get(id) / 100) * 60 + (entradaREAL.get(id) % 100);
                                                int saidaRealMin = (saidaREAL.get(id) / 100) * 60 + (saidaREAL.get(id) % 100);

                                                int tempoPrevisto = saidaPrevistaMin - entradaPrevistaMin;
                                                int tempoTrabalhado = saidaRealMin - entradaRealMin;
                                                int limiteExtra = limite.get(id);

                                            if (tempoTrabalhado < tempoPrevisto) {
                                                    horasfaltando.set(id, tempoPrevisto - tempoTrabalhado);
                                                    extras.set(id,false);
                                            } else if (tempoTrabalhado == tempoPrevisto) {
                                                    horasfaltando.set(id, 0);
                                                    extras.set(id,false);
                                            } else if (tempoTrabalhado <= (tempoPrevisto + limiteExtra)) {
                                                    horasfaltando.set(id, 0);
                                                    extras.set(id,true);
                                            } else {
                                                    horasfaltando.set(id, 0);
                                                    extras.set(id,false);
                                            }
                                        }
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
                                            

                                                int entradaPrevistaMin = (entrada.get(id) / 100) * 60 + (entrada.get(id) % 100);
                                                int saidaPrevistaMin = (saida.get(id) / 100) * 60 + (saida.get(id) % 100);
                                                int entradaRealMin = (entradaREAL.get(id) / 100) * 60 + (entradaREAL.get(id) % 100);
                                                int saidaRealMin = (saidaREAL.get(id) / 100) * 60 + (saidaREAL.get(id) % 100);

                                                int tempoPrevisto = saidaPrevistaMin - entradaPrevistaMin;
                                                int tempoTrabalhado = saidaRealMin - entradaRealMin;
                                                int limiteExtra = limite.get(id);

                                                if (tempoTrabalhado < tempoPrevisto) {
                                                    horasfaltando.set(id, tempoPrevisto - tempoTrabalhado);
                                                    extras.set(id,false);
                                                } else if (tempoTrabalhado == tempoPrevisto) {
                                                    horasfaltando.set(id, 0);
                                                    extras.set(id,false);
                                                } else if (tempoTrabalhado <= (tempoPrevisto + limiteExtra)) {
                                                    horasfaltando.set(id, 0);
                                                    extras.set(id,true);
                                                } else {
                                                    horasfaltando.set(id, 0);
                                                    extras.set(id,false);
                                                }
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

                            System.out.println("Insira o horário de entrada do expediente (ex: 800 = 08:00): ");
                            int entradaH = teclado.nextInt();
                            
                            horas = entradaH / 100;
                            minutos = entradaH % 100;

                            while ((horas < 0 || horas >= 24) || (minutos < 0 || minutos >= 60)) {
                                System.out.println("Horário inválido. Tente novamente.");
                                System.out.println("Insira o horário de entrada do expediente (ex: 800 = 08:00): ");
                                entradaH = teclado.nextInt();

                                horas = entradaH / 100;
                                minutos = entradaH % 100;

                            }

                            entrada.add(entradaH);

/**=============================================================================================================================================================================================*/

                            System.out.println("Insira o horário de saída do expediente (ex: 1700 = 17:00): ");
                            int saidaH = teclado.nextInt();
                            
                            horas = saidaH / 100;
                            minutos = saidaH % 100;

                            while ((horas < 0 || horas >= 24) || (minutos < 0 || minutos >= 60)) {
                                System.out.println("Horário inválido. Tente novamente.");
                                System.out.println("Insira o horário de entrada do expediente (ex: 800 = 08:00): ");
                                saidaH = teclado.nextInt();

                                horas = saidaH / 100;
                                minutos = saidaH % 100;
                            }

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

                        System.out.println("\nInsira seu horário de entrada: ");
                        int entradaR = teclado.nextInt();
                    
                        horas = entradaR / 100;
                        minutos = entradaR % 100;

                        while ((horas < 0 || horas >= 24) || (minutos < 0 || minutos >= 60)) {
                            System.out.println("Horário inválido. Tente novamente.");
                            System.out.println("Insira o horário de entrada do expediente (ex: 800 = 08:00): ");
                            entradaR = teclado.nextInt();

                            horas = entradaR / 100;
                            minutos = entradaR % 100;
                        }

                        entradaREAL.set(id, entradaR);

                        System.out.println("Insira seu horário de saída: ");
                        int saidaR = teclado.nextInt();
                    
                        horas = saidaR / 100;
                        minutos = saidaR % 100;

                        while ((horas < 0 || horas >= 24) || (minutos < 0 || minutos >= 60)) {
                            System.out.println("Horário inválido. Tente novamente.");
                            System.out.println("Insira o horário de saída do expediente (ex: 800 = 08:00): ");
                            saidaR = teclado.nextInt();

                            horas = saidaR / 100;
                            minutos = saidaR % 100;
                        }

                        saidaREAL.set(id, saidaR);
                        
                        int entradaPrevistaMin = (entrada.get(id) / 100) * 60 + (entrada.get(id) % 100);
                        int saidaPrevistaMin = (saida.get(id) / 100) * 60 + (saida.get(id) % 100);
                        int entradaRealMin = (entradaREAL.get(id) / 100) * 60 + (entradaREAL.get(id) % 100);
                        int saidaRealMin = (saidaREAL.get(id) / 100) * 60 + (saidaREAL.get(id) % 100);

                        int tempoPrevisto = saidaPrevistaMin - entradaPrevistaMin;
                        int tempoTrabalhado = saidaRealMin - entradaRealMin;
                        int limiteExtra = limite.get(id);

                        System.out.println("=============================================================================================");
                        System.out.println("\nFUNCIONARIO " + nome.get(id) .toUpperCase());
                        System.out.println("CPF: " + CPF.get(id) );
                        System.out.println("Início do expediente: " + entrada.get(id) );
                        System.out.println("Fim do expediente: " + saida.get(id) );
                        System.out.println("Chegada: " + entradaREAL.get(id) );
                        System.out.println("Saída: " + saidaREAL.get(id) );

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

                if (encontrado == false){
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
}
