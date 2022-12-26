import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static Utilizador adicionarUtilizador() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = ler.nextLine();
        System.out.println("Apelido: ");
        String apelido = ler.nextLine();
        System.out.println("Email: ");
        String email = ler.nextLine();
        System.out.println("Password: ");
        String password = ler.nextLine();
        System.out.println("Cidade: ");
        String cidade = ler.nextLine();
        System.out.println("Tipo de User(cliente/admin): ");
        String tipoUser = ler.nextLine();
        System.out.println("Telemóvel: ");
        int telemovel = ler.nextInt();
        System.out.println("NIF: ");
        int nif = ler.nextInt();
        Utilizador utilizador = new Utilizador(nome, apelido, email, password, nif, telemovel, cidade, tipoUser);
        return utilizador;
    }

    public static Utilizador login(ArrayList<Utilizador> utilizadores) {
        Scanner ler = new Scanner(System.in);
        Utilizador utilizador = null;
        System.out.println("Email: ");
        String email = ler.nextLine();
        System.out.println("Password: ");
        String password = ler.nextLine();
        Iterator var5 = utilizadores.iterator();

        while(var5.hasNext()) {
            Utilizador user = (Utilizador)var5.next();
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                utilizador = user;
            }
        }

        return utilizador;
    }

    public static void main(String[] args) {
        ArrayList<Utilizador> utilizadores = new ArrayList();
        ArrayList<Automovel> automoveis = new ArrayList<>();

        Utilizador utilizadorNovo = null;
        Automovel automovel;
        boolean existe = false;
        Scanner ler = new Scanner(System.in);

        int menu1;
        do {
            System.out.println("\n\n***** Stand Automóvel  *****");
            System.out.println("\n\n***** Stand Automóvel  *****");
            System.out.println("\n*******************************");
            System.out.println("**** 1 - Registar Utilizador ****");
            System.out.println("**** 2 - Login               ****");
            System.out.println("**** 0 - Sair                ****");
            System.out.println("\n*******************************");
            System.out.print("\nInsira a Opcao que deseja: ");
            menu1 = ler.nextInt();
            Utilizador utilizador;
            Iterator var18;
            Utilizador user;
            switch(menu1) {
                case 0:
                    break;
                case 1:
                    utilizador = adicionarUtilizador();
                    if (utilizador != null) {
                        existe = false;
                    }

                    var18 = utilizadores.iterator();

                    while(var18.hasNext()) {
                        user = (Utilizador)var18.next();
                        if (utilizador.getNif() == user.getNif()) {
                            existe = true;
                        }
                    }

                    if (existe) {
                        System.out.println("NIF já existente!\n");
                    } else {
                        System.out.println("Utilizador Registado com Sucesso!\n");
                        utilizadores.add(utilizador);
                    }
                    break;
                case 2:
                    int indiceUtilizador = -1;
                    utilizador = login(utilizadores);
                    if (utilizador == null) {
                        System.out.println("Login Inválido!");
                    } else {
                        var18 = utilizadores.iterator();

                        while(var18.hasNext()) {
                            user = (Utilizador)var18.next();
                            if (user.getNif() == utilizador.getNif()) {
                                indiceUtilizador = utilizadores.indexOf(user);
                            }
                        }

                        if (!utilizador.getTipoUser().equals("cliente")) {
                            if (utilizador.getTipoUser().equals("admin")) {
                                int menu6;
                                do {
                                    System.out.println(utilizador.ola());
                                    System.out.println("\n\n**********       Menu Admin          **********");
                                    System.out.println("\n***********************************************");
                                    System.out.println("***** 1 - Adicionar Automóvel               *****");
                                    System.out.println("***** 2 - Alterar Automóvel                 *****");
                                    System.out.println("***** 3 - Desativar Automóvel               *****");
                                    System.out.println("***** 4 - Listar Automóveis                 *****");
                                    System.out.println("***** 5 - Registar Venda                  *****");
                                    System.out.println("***** 6 - Validar Reserva                 *****");
                                    System.out.println("***** 7 - Cancelar Reserva                *****");
                                    System.out.println("***** 8 - Listar Próximos Clientes        *****");
                                    System.out.println("***** 9 - Informações de um Cliente       *****");
                                    System.out.println("***** 0 - Logout                          *****");
                                    System.out.println("\n***********************************************");
                                    System.out.print("Insira a Opção que deseja: ");
                                    menu6 = ler.nextInt();
                                    switch (menu6) {
                                        case 1:
                                            System.out.println("\n\n**********     Registar Automóvel        **********");

                                            System.out.println("Insira a matrícula do automóvel: ");
                                            String matricula = ler.next();

                                           /* if (automoveis.contains(matricula)) {
                                                System.out.println("Matrícula já registada! Insira uma diferente!");
                                                continue;
                                            } */

                                            System.out.println("Insira a marca do automóvel: ");
                                            String marca = ler.next();

                                            System.out.println("Insira o modelo do automóvel: ");
                                            String modelo = ler.next();

                                            System.out.println("Insira a cor do automóvel: ");
                                            String cor = ler.next();

                                            System.out.println("Insira o ano do automóvel: ");
                                            int ano = ler.nextInt();

                                            System.out.println("Insira os KMS do automóvel: ");
                                            float kms = ler.nextFloat();

                                            System.out.println("Insira o preço do automóvel: ");
                                            float preco = ler.nextFloat();

                                            automovel = new Automovel(matricula, marca, modelo, cor, ano, kms, preco);

                                            for (Automovel auto: automoveis){
                                                if (automovel.getMatricula().equals(auto.getMatricula())){
                                                    existe = true;
                                                }
                                            }
                                            if (existe == true){
                                                System.out.println("Automóvel com essa Matrícula já se encontra registado!\n");
                                            }else {
                                                System.out.println("Automóvel Registado com Sucesso!\n");
                                                automoveis.add(automovel);
                                            }

                                        case 2:
                                            System.out.println("NAO DEVIA APARECER");
                                        case 3:
                                            System.out.println("NAO DEVIA APARECER");
                                        case 4:
                                            System.out.println("\n\n*****      Automóveis Listados      *****");
                                            System.out.println("\n*************************************************");

                                            for (Automovel auto : automoveis) {
                                                System.out.println(auto.toString());
                                            }
                                        case 5:
                                        case 6:
                                        case 7:
                                        case 8:
                                        case 9:
                                        case 0:
                                            break;
                                    }
                                } while (menu6 != 0);
                            }
                        } else {
                            int menu2;
                            do{
                                System.out.println(utilizador.ola());
                                System.out.println("\n\n*****       Menu cliente          *****");
                                System.out.println("\n*****************************************");
                                System.out.println("**** 1 - Visualizar Perfil             ****");
                                System.out.println("**** 2 - Editar Perfil                 ****");
                                System.out.println("**** 3 - Listar Veiculos               ****");
                                System.out.println("**** 4 - Informacao de um veiculo      ****");
                                System.out.println("**** 5 - Reservar veiculo              ****");
                                System.out.println("**** 6 - Consultar Histórico           ****");
                                System.out.println("**** 0 - Logout                        ****");
                                System.out.println("\n*****************************************");
                                System.out.print("Insira a Opção que deseja: ");
                                menu2 = ler.nextInt();
                                switch(menu2) {
                                    case 1:
                                        System.out.println(utilizador.toString());
                                        break;
                                    case 2:
                                        System.out.println(utilizador.toString());

                                        int menu3;
                                        do {
                                            System.out.println("\n\n*****       Editar Perfil          *****");
                                            System.out.println("\n*****************************************");
                                            System.out.println("**** 1 - Nome                          *****");
                                            System.out.println("**** 2 - Apelido                       *****");
                                            System.out.println("**** 3 - Username                      *****");
                                            System.out.println("**** 4 - Password                      *****");
                                            System.out.println("**** 5 - Cidade                        *****");
                                            System.out.println("**** 6 - Telemóvel                     *****");
                                            System.out.println("**** 0 - Sair                          *****");
                                            System.out.println("\n*****************************************");
                                            System.out.print("Insira a Informação que deseja Editar: ");
                                            menu3 = ler.nextInt();
                                            switch(menu3) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Nome: ");
                                                    String nome = ler.next();
                                                    utilizador.setNome(nome);
                                                    break;
                                                case 2:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Apelido: ");
                                                    String apelido = ler.next();
                                                    utilizador.setApelido(apelido);
                                                    break;
                                                case 3:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Email: ");
                                                    String email = ler.next();
                                                    utilizador.setEmail(email);
                                                    break;
                                                case 4:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere a Password: ");
                                                    String password = ler.next();
                                                    utilizador.setPassword(password);
                                                    break;
                                                case 5:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere a Cidade: ");
                                                    String cidade = ler.next();
                                                    utilizador.setCidade(cidade);
                                                    break;
                                                case 6:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Telemóvel: ");
                                                    int telemovel = Integer.parseInt(ler.next());
                                                    utilizador.setTelemovel(telemovel);
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }

                                            utilizadores.set(indiceUtilizador, utilizadorNovo);
                                            utilizador = utilizadorNovo;
                                        } while(menu3 != 0);
                                    case 3:
                                        int menu4;
                                        do {
                                            System.out.println("\n\n*****     Listar Veículos      *****");
                                            System.out.println("\n*************************************");
                                            System.out.println("**** 1 - Listar por marca         ****");
                                            System.out.println("**** 2 - Listar por modelo        ****");
                                            System.out.println("**** 3 - Listar por ano           ****");
                                            System.out.println("**** 4 - Listar por preço         ****");
                                            System.out.println("**** 0 - Sair                     ****");
                                            System.out.println("\n*************************************");
                                            System.out.print("\nInsira a opção que deseja: ");
                                            menu4 = ler.nextInt();
                                            switch (menu4){
                                                case 0: break;
                                                case 1:
                                                case 2:
                                                case 3:
                                                case 4:
                                            }
                                        } while(menu4 != 0);
                                    case 4:
                                    case 5:
                                    case 6:
                                        int menu5;
                                        do {
                                            System.out.println("\n\n*****       Consultar Histórico       *****");
                                            System.out.println("\n**********************************************");
                                            System.out.println("**** 1 - Consultar Histórico de Compras    ****");
                                            System.out.println("**** 2 - Consultar Histórico de Reservas   ****");
                                            System.out.println("**** 3 - Consultar Histórico de Ações      ****");
                                            System.out.println("**** 0 - Sair                              ****");
                                            System.out.println("\n**********************************************");
                                            System.out.print("\nInsira a opção que deseja: ");
                                            menu5 = ler.nextInt();
                                            switch (menu5){
                                                case 0: break;
                                                case 1:
                                                case 2:
                                                case 3:
                                            }
                                        } while(menu5 != 0);
                                }
                            }while (menu2 != 0);
                        }
                    }
                    break;
                default:
                    System.out.println("Opcao Inválida!\n\n");
            }
        } while(menu1 != 0);

    }
}
