import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    // Método inserir novo Utilizador
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
        System.out.println("Tipo de User(cliente/admin/userManager): ");
        String tipoUser = ler.nextLine();
        System.out.println("Telemóvel: ");
        int telemovel = ler.nextInt();
        System.out.println("NIF: ");
        int nif = ler.nextInt();
        // adiciona o utilizador registado ao array do Utilizador
        Utilizador utilizador = new Utilizador(nome, apelido, email, password, nif, telemovel, cidade, tipoUser); // adiciona o utilizador ao array de utilizadores
        return utilizador;
    }

    // Método Login
    public static Utilizador login(ArrayList<Utilizador> utilizadores) {
        Scanner ler = new Scanner(System.in);
        Utilizador utilizador = null;
        System.out.println("Email: ");
        String email = ler.nextLine();
        System.out.println("Password: ");
        String password = ler.nextLine();

        // Verifica se email e password são iguais
        for (Utilizador user : utilizadores){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                utilizador = user;
            }
        }
        return utilizador;
    }

    public static void main(String[] args) {
        ArrayList<Utilizador> utilizadores = new ArrayList<>();
        ArrayList<Automovel> automoveis = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();
        ArrayList<Vendas> vendas = new ArrayList<>();
        ArrayList<Acao> acoes = new ArrayList<>();

        // Introduzir utilizadores e carros nas respetivas arrays
        utilizadores.add( new Utilizador("Sofia", "Amorim", "ss", "ss", 123, 123, "Braga", "admin"));
        utilizadores.add( new Utilizador("Hugo", "Simoes", "hugo", "123", 12345, 926, "Barcelos", "cliente"));
        utilizadores.add( new Utilizador("Filipa", "Feerz", "ff", "ff", 231, 921, "Braga", "userManager"));
        utilizadores.add( new Utilizador("Marta", "Barbosa", "mm", "mm", 221, 932, "Barcelos", "cliente"));
        utilizadores.add( new Utilizador("João", "Carlos", "jj", "jj", 223, 9214, "Viana", "cliente"));
        automoveis.add(new Automovel("TS-43-NT", "Ford", "Fiesta", "Preto", 2004, 357523, 2100));
        automoveis.add(new Automovel("HS-17-HS", "Audi", "R8", "Branco", 2022, 20, 30000));
        automoveis.add(new Automovel("75-ZT-71", "Citroen", "C3", "Vermelho", 2015, 75000, 14500));
        automoveis.add(new Automovel("ET-86-WE", "Citroen", "C3", "Preto", 2013, 35565, 9010));
        automoveis.add(new Automovel("YJ-75-SF", "Audi", "A1", "Branco", 2015, 64532, 13100));
        automoveis.add(new Automovel("65-ZH-02", "Smart", "44", "Preto", 2021, 53232, 9500));

        Utilizador utilizador = null, utilizadorNovo = null, utilizadorCriado;
        Automovel automovel = null, automovelNovo = null;

        int nif, telemovel,  ano, indiceUtilizador, indiceAutomovel;
        String nome, apelido, email, password, cidade, tipoUser, matricula, marca, modelo, cor, data;
        Float kms, preco;
        boolean existe = false;


        Scanner ler = new Scanner(System.in);

        int menu1;
        do {
            System.out.println("\n\n****** Stand Automóvel  ******");
            System.out.println("\n*********************************");
            System.out.println("**** 1 - Registar Utilizador ****");
            System.out.println("**** 2 - Login               ****");
            System.out.println("**** 0 - Sair                ****");
            System.out.println("\n*********************************");
            System.out.print("\nInsira a Opcao que deseja: ");
            menu1 = ler.nextInt();
            switch (menu1) {
                case 0:
                    break;
                case 1:
                    // Inserir novo Utilizador
                    utilizador = adicionarUtilizador();
                    if (utilizador != null) {
                        // Verifica se o NIF já existe
                        existe = false;
                    }
                    for (Utilizador user : utilizadores){
                        if (utilizador.getNif() == user.getNif()) {
                            existe = true;
                        }
                    }
                    if (existe) { // se existe igual true mostra mensagem de erro
                        System.out.println("NIF já existente!\n");
                    } else { // se existe igual false adiciona o utilizador ao array
                        System.out.println("Utilizador Registado com Sucesso!\n");
                        utilizadores.add(utilizador);
                        // invoca o método acoesRealizadas e adiciona uma acao ao utilizador
                        utilizador.acoesRealizadas(utilizador.getNif(), "Utilizador Registou-se ");
                    }
                    break;
                case 2:
                    // Login Utilizador
                    indiceUtilizador = -1;
                    utilizador = login(utilizadores);
                    if (utilizador == null) { // se utilizador igual a null mostra mensagem de erro
                        System.out.println("Login Inválido!");
                    } else { // realiza o login e imprime para o ecrã o menu de acordo com o tipo de User
                        // invoca o método acoesRealizadas e adiciona uma acao ao utilizador
                        utilizador.acoesRealizadas(utilizador.getNif(), "Utilizador Fez Login ");
                        for (Utilizador user : utilizadores){
                            if (user.getNif() == utilizador.getNif()) {
                                indiceUtilizador = utilizadores.indexOf(user);
                            }
                        }
                        // Menu Admin
                        if (utilizador.getTipoUser().equals("admin")) {
                            int menu2;
                            do {
                                System.out.println(utilizador.ola());
                                System.out.println("\n\n**********       Menu Admin          **********");
                                System.out.println("\n***********************************************");
                                System.out.println("***** 1 - Adicionar Automóvel             *****");
                                System.out.println("***** 2 - Alterar Automóvel               *****");
                                System.out.println("***** 3 - Desativar Automóvel             *****");
                                System.out.println("***** 4 - Listar Automóveis               *****");
                                System.out.println("***** 5 - Registar Venda                  *****");
                                System.out.println("***** 6 - Validar Reserva                 *****");
                                System.out.println("***** 7 - Cancelar Reserva                *****");
                                System.out.println("***** 8 - Listar Próximos Clientes        *****");
                                System.out.println("***** 9 - Informações de um Cliente       *****");
                                System.out.println("**** 10 - Visualizar Perfil               *****");
                                System.out.println("**** 11 - Editar Perfil                   *****");
                                System.out.println("**** 12 - Histórico de Ações              *****");
                                System.out.println("***** 0 - Logout                          *****");
                                System.out.println("\n***********************************************");
                                System.out.print("Insira a Opção que deseja: ");
                                menu2 = ler.nextInt();
                                switch (menu2) {
                                    case 1:
                                        // Registar Automóvel
                                        System.out.println("\n\n**********     Registar Automóvel        **********");

                                        System.out.println("Insira a matrícula do automóvel: ");
                                        matricula = ler.next();

                                        System.out.println("Insira a marca do automóvel: ");
                                        marca = ler.next();

                                        System.out.println("Insira o modelo do automóvel: ");
                                        modelo = ler.next();

                                        System.out.println("Insira a cor do automóvel: ");
                                        cor = ler.next();

                                        System.out.println("Insira o ano do automóvel: ");
                                        ano = ler.nextInt();

                                        System.out.println("Insira os KMS do automóvel: ");
                                        kms = ler.nextFloat();

                                        System.out.println("Insira o preço do automóvel: ");
                                        preco = ler.nextFloat();

                                        automovel = new Automovel(matricula, marca, modelo, cor, ano, kms, preco);

                                        for (Automovel auto : automoveis) {
                                            if (automovel.getMatricula().equals(auto.getMatricula())) {
                                                // Verifica se a matrícula já existe
                                                existe = true;
                                            }
                                        }
                                        if (existe) { // se existe igual a true mostra mensagem de erro
                                            System.out.println("Automóvel com essa Matrícula já se encontra registado!\n");
                                        } else { // se existe igual a false adiciona automóvel ao array
                                            System.out.println("Automóvel Registado com Sucesso!\n");
                                            automoveis.add(automovel);
                                        }
                                        break;

                                    case 2:
                                        // Editar Automóvel
                                        for (Automovel auto : automoveis) {
                                            System.out.println(auto.matriculas()); // imprime para o ecrã as matrículas dos automóveis
                                        }
                                        System.out.println("Insira a matrícula: ");
                                        matricula = ler.next();

                                        for (Automovel auto: automoveis){
                                            if (auto.getMatricula().equals(matricula)){
                                                System.out.println(auto.toString()); // imprime para o ecrã a informação do automóvel selecionado
                                                int menu3;
                                                do {
                                                    System.out.println("\n\n*****        Editar Automóvel         *****");
                                                    System.out.println("\n********************************************");
                                                    System.out.println("**** 1 - Marca                          *****");
                                                    System.out.println("**** 2 - Modelo                         *****");
                                                    System.out.println("**** 3 - Cor                            *****");
                                                    System.out.println("**** 4 - Ano                            *****");
                                                    System.out.println("**** 5 - Kms                            *****");
                                                    System.out.println("**** 6 - Preço                          *****");
                                                    System.out.println("**** 0 - Sair                           *****");
                                                    System.out.println("\n********************************************");
                                                    System.out.print("Insira a Informação que deseja Editar: ");
                                                    menu3 = ler.nextInt();
                                                    // possibilidade de o Admin editar um automóvel selecionando uma das opções
                                                    switch (menu3) {
                                                        case 0:
                                                            break;
                                                        case 1:
                                                            automovelNovo = auto;
                                                            System.out.println("Altere a Marca: ");
                                                            marca = ler.next();
                                                            auto.setMarca(marca);
                                                            break;
                                                        case 2:
                                                            automovelNovo = auto;
                                                            System.out.println("Altere o Modelo: ");
                                                            modelo = ler.next();
                                                            auto.setModelo(modelo);
                                                            break;
                                                        case 3:
                                                            automovelNovo = auto;
                                                            System.out.println("Altere a Cor: ");
                                                            cor = ler.next();
                                                            auto.setCor(cor);
                                                            break;
                                                        case 4:
                                                            automovelNovo = auto;
                                                            System.out.println("Altere o Ano: ");
                                                            ano = ler.nextInt();
                                                            auto.setAno(ano);
                                                            break;
                                                        case 5:
                                                            automovelNovo = auto;
                                                            System.out.println("Altere os Kms: ");
                                                            kms = ler.nextFloat();
                                                            auto.setKms(kms);
                                                            break;
                                                        case 6:
                                                            automovelNovo = auto;
                                                            System.out.println("Altere o Preço: ");
                                                            preco = ler.nextFloat();
                                                            auto.setPreco(preco);
                                                            break;
                                                        default:
                                                            System.out.println("Opcao Inválida!\n\n");
                                                    }
                                                    indiceAutomovel = automoveis.indexOf(auto);
                                                    automoveis.set(indiceAutomovel, automovelNovo);
                                                    auto = automovelNovo;
                                                } while (menu3 != 0);
                                            }
                                        }
                                        break;
                                    case 3:
                                        // Desativar um Automóvel
                                        System.out.println("\n\n*****     Desativar Automóvel      *****");

                                        for(Automovel auto : automoveis){
                                            if(!auto.getEstado().equals(Automovel.Estado.DESATIVO)){
                                                System.out.println(auto.matriculas()); // imprime as matrículas dos automóveis não desativos para o ecrã
                                            }
                                        }

                                        System.out.println("Insira a matrícula: ");
                                        matricula = ler.next();

                                        for (Automovel auto: automoveis) {
                                            if (auto.getMatricula().equals(matricula)) {
                                                auto.setEstado(Automovel.Estado.DESATIVO); // altera o estado do automóvel selecionado para DESATIVO
                                                System.out.println("Automóvel Desativado com Sucesso!!");
                                            }
                                        }
                                        break;
                                    case 4:
                                        // Listar Automóveis com filtros
                                        int menu6;
                                        do {
                                            System.out.println("\n\n*****     Listar Automóvel        *****");
                                            System.out.println("\n**************************************");
                                            System.out.println("**** 1 - Listar por marca            ****");
                                            System.out.println("**** 2 - Listar por modelo           ****");
                                            System.out.println("**** 3 - Listar por ano              ****");
                                            System.out.println("**** 4 - Listar por preço            ****");
                                            System.out.println("**** 5 - Listar por Estado           ****");
                                            System.out.println("**** 6 - Listar todos os Automóveis  ****");
                                            System.out.println("**** 0 - Sair                        ****");
                                            System.out.println("\n**************************************");
                                            System.out.print("\nInsira a opção que deseja: ");
                                            menu6 = ler.nextInt();
                                            switch (menu6){
                                                case 0: break;
                                                case 1:
                                                    System.out.println("Escolha a Marca: ");
                                                    marca = ler.next();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getMarca().equals(marca)){
                                                            System.out.println(auto.toString()); //imprime para o ecrã os automoveis com a marca selecionada
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Escolha o Modelo: ");
                                                    modelo = ler.next();
                                                    for(Automovel auto : automoveis) {
                                                        if (auto.getModelo().equals(modelo)) {
                                                            System.out.println(auto.toString());//imprime para o ecrã os automoveis com o modelo selecionado
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Escolha o Ano: ");
                                                    ano = Integer.parseInt(ler.next());
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getAno() == ano){
                                                            System.out.println(auto.toString()); //imprime para o ecrã os automoveis com o ano selecionado
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Escolha o Preço Máximo: ");
                                                    preco = ler.nextFloat();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getPreco() <= preco){
                                                            System.out.println(auto.toString()); //imprime para o ecrã os automoveis com preço abaixo do selecionado
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    int menu11;
                                                    do {
                                                        System.out.println("\n\n*****      Listar Automóveis      *******");
                                                        System.out.println("\n******************************************");
                                                        System.out.println("**** 1 - Listar por Disponíveis        ****");
                                                        System.out.println("**** 2 - Listar por Reservados         ****");
                                                        System.out.println("**** 3 - Listar por Vendidos           ****");
                                                        System.out.println("**** 4 - Listar por Desativos          ****");
                                                        System.out.println("**** 0 - Sair                          ****");
                                                        System.out.println("\n******************************************");
                                                        System.out.print("\nInsira a opção que deseja: ");
                                                        menu11 = ler.nextInt();
                                                        switch (menu11){
                                                            case 0:
                                                                break;
                                                            case 1:
                                                                for (Automovel auto : automoveis) {
                                                                    if (auto.getEstado().equals(Automovel.Estado.DISPONIVEL)) {
                                                                        System.out.println(auto.toString()); //imprime para o ecrã os automoveis com o estado DISPONIVEL
                                                                    }
                                                                }
                                                                break;
                                                            case 2:
                                                                for (Automovel auto : automoveis) {
                                                                    if (auto.getEstado().equals(Automovel.Estado.RESERVADO)) {
                                                                        System.out.println(auto.toString()); //imprime para o ecrã os automoveis com o estado RESERVADO
                                                                    }
                                                                }
                                                                break;
                                                            case 3:
                                                                for (Automovel auto : automoveis) {
                                                                    if (auto.getEstado().equals(Automovel.Estado.VENDIDO)) {
                                                                        System.out.println(auto.toString()); //imprime para o ecrã os automoveis com o estado VENDIDO
                                                                    }
                                                                }
                                                                break;
                                                            case 4:
                                                                for (Automovel auto : automoveis) {
                                                                    if (auto.getEstado().equals(Automovel.Estado.DESATIVO)) {
                                                                        System.out.println(auto.toString()); //imprime para o ecrã os automoveis com o estado DESATIVO
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } while(menu11 != 0);
                                                    break;
                                                case 6:
                                                    for (Automovel auto : automoveis) {
                                                        System.out.println(auto.toString()); //imprime para o ecrã todos os automoveis
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                        } while(menu6 != 0);
                                        break;
                                    case 5:
                                        // Vender Automóvel
                                        System.out.println("\n\n*****     Registar Compra      *****");
                                        for (Utilizador user : utilizadores) {
                                            if(user.getTipoUser().equals("cliente")) { //se o tipo de user for cliente imprime para ecrã uma lista dos nifs
                                                System.out.println(user.nifs());
                                            }
                                        }
                                        System.out.println("Escolha o Cliente pelo seu nif: ");
                                        nif = Integer.parseInt(ler.next()); // admin escreve um dos nifs

                                        for(Automovel auto : automoveis){
                                            if(auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){ // se o estado do automovrl for Disponivel imprime para ecrã uma lista das matriculas
                                                System.out.println(auto.matriculas());
                                            }
                                        }
                                        System.out.println("Escolha o Veículo pela sua Matrícula: ");
                                        matricula = ler.next(); // admin escreve uma matricula

                                        for (Automovel auto: automoveis){
                                            for (Utilizador user : utilizadores){
                                                if(auto.getMatricula().equals(matricula) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL) && user.getNif() == nif) { // se a matricula existir, o carro estiver disponivel e o nif escolhido tambem existir
                                                    System.out.println("Insira a data: ");
                                                    data = ler.next(); // a admin insere a data de compra
                                                    user.venderAutomovel(nif, matricula, data); // adiciona a venda ao user escolhido
                                                    auto.setEstado(Automovel.Estado.VENDIDO); // o estado do automovel passa para vendido
                                                    System.out.println("Compra efetuada com sucesso!!");
                                                }
                                            }
                                        }
                                        break;
                                    case 6:
                                        // Validar Reservas
                                        System.out.println("\n\n*****     Validar Reservas      *****");

                                        for (Utilizador user : utilizadores){
                                            reservas = user.getReservas();
                                            for (Reserva reserva : reservas) {
                                                if (reserva.getEstado().equals(Reserva.Estado.POR_VALIDAR)) //se o estado da reserva estiver por validar imprime para o ecrã lista das reservas
                                                    System.out.println(reserva.reservasEfetuadas());
                                            }
                                        }

                                        System.out.println("Insira a matrícula para validar  a reserva: ");
                                        matricula = ler.next();

                                        for (Utilizador user : utilizadores){
                                            reservas = user.getReservas();
                                            for (Reserva reserva: reservas){
                                                for (Automovel auto: automoveis){
                                                    if (reserva.getMatricula().equals(matricula) && reserva.getEstado().equals(Reserva.Estado.POR_VALIDAR) && auto.getMatricula().equals(reserva.getMatricula())){ // se a matricula existir, o estado da reserva estiver por validar e a matricula estiver numa reserva
                                                            /* Alterar estados do Automóvel e da Reserva */
                                                            auto.setEstado(Automovel.Estado.VENDIDO);
                                                            reserva.setEstado(Reserva.Estado.CONCLUIDA);
                                                            System.out.println("Reserva Validada Com Sucesso!!");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 7:
                                        // Cancelar Reserva
                                        System.out.println("\n\n*****     Cancelar Reservas      *****");
                                        for (Automovel auto : automoveis) {
                                            if (auto.getEstado().equals(Automovel.Estado.RESERVADO)){  // se um automovel estiver no estado reservado
                                                System.out.println(auto.matriculas());// imprime para o ecra uma lista das matriculas
                                            }
                                        }
                                        System.out.println("Insira a matrícula: ");
                                        matricula = ler.next();

                                        for (Utilizador user : utilizadores){
                                            reservas = user.getReservas();
                                            for (Reserva reserva : reservas){
                                                for (Automovel auto: automoveis){
                                                    if(auto.getMatricula().equals(matricula) && auto.getEstado().equals(Automovel.Estado.RESERVADO)) { //  se a matricula existir e o estado da reserva desse automovel estiver em reservado
                                                        /* Alterar estados do Automóvel e da Reserva */
                                                        auto.setEstado(Automovel.Estado.DISPONIVEL);
                                                        reserva.setEstado(Reserva.Estado.CANCELADA);
                                                        System.out.println("Reserva Cancelada!!");
                                                    }
                                                }
                                            }
                                        }
                                        break;
                                    case 8:
                                        System.out.println("Lista dos Próximos Clientes:\n\n ");

                                        for(Utilizador user: utilizadores){
                                            reservas = user.getReservas();
                                            for(Reserva reserva: reservas){
                                                if(reserva.getEstado().equals(Reserva.Estado.POR_VALIDAR)){ // lista todas as informações de uma reserva que esteja por validar
                                                    System.out.println("\nMatricula: " + reserva.getMatricula());
                                                    System.out.println("\nNif cliente: " + reserva.getNif());
                                                    System.out.println("\nData reserva: " + reserva.getData());
                                                    System.out.println("\n*************************************");
                                                }
                                            }
                                        }
                                        break;
                                    case 9:
                                        // Pesquisar Clientes
                                        for (Utilizador user : utilizadores) {
                                            if(user.getTipoUser().equals("cliente")) { // se o user for do tipo cliente imprime para o ecrã uma lista dos nifs
                                                System.out.println(user.nifs());
                                            }
                                        }
                                        System.out.println("Escolha o Cliente pelo seu nif: ");
                                        nif = Integer.parseInt(ler.next()); // o admin escreve um nif
                                        for (Utilizador use: utilizadores){
                                            if(use.getNif() == nif){ // se esse nif existir imorime para o ecrã as suas informaçoes
                                                System.out.println(use.toString());
                                            }
                                        }
                                        break;
                                    case 10:
                                        // Ver informacoes do Perfil
                                        System.out.println(utilizador.toString());
                                        break;
                                    case 11:
                                        System.out.println(utilizador.toString()); //imprime as informações do admin logado
                                        // imrpime o menu para o user escolher o quer editar, dependeo da variavel escolhida, essa é alterada e atualizada
                                        int menu5;
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
                                            menu5 = ler.nextInt();
                                            switch (menu5) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Nome: ");
                                                    nome = ler.next();
                                                    utilizador.setNome(nome);
                                                    break;
                                                case 2:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Apelido: ");
                                                    apelido = ler.next();
                                                    utilizador.setApelido(apelido);
                                                    break;
                                                case 3:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Email: ");
                                                    email = ler.next();
                                                    utilizador.setEmail(email);
                                                    break;
                                                case 4:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere a Password: ");
                                                    password = ler.next();
                                                    utilizador.setPassword(password);
                                                    break;
                                                case 5:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere a Cidade: ");
                                                    cidade = ler.next();
                                                    utilizador.setCidade(cidade);
                                                    break;
                                                case 6:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Telemóvel: ");
                                                    telemovel = ler.nextInt();
                                                    utilizador.setTelemovel(telemovel);
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                            utilizadores.set(indiceUtilizador, utilizadorNovo);
                                            utilizador = utilizadorNovo;
                                        } while (menu5 != 0);
                                        break;
                                    case 12:
                                        System.out.println("*****        Histórico de Ações          *****");
                                        for (Utilizador user : utilizadores){
                                            acoes = user.getAcoes();
                                            for (Acao acao : acoes){ // imprime para o ecrã as ações guardadas no array acoes (todas as acoes independentemente do user)
                                                System.out.println("NIF: " + acao.getNif() + " - " + acao.getNomeAcao() + " - " + acao.getDataHora());
                                            }
                                        }
                                        break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opcao Inválida!\n\n");
                                }
                            } while (menu2 != 0);
                        } else if (utilizador.getTipoUser().equals("cliente")) { // imprime para o ecrã o menu Cliente se o tipo de User for cliente
                            int menu4;
                            do {
                                System.out.println(utilizador.ola());
                                System.out.println("\n\n*****       Menu cliente          *****");
                                System.out.println("\n*****************************************");
                                System.out.println("**** 1 - Visualizar Perfil             ****");
                                System.out.println("**** 2 - Editar Perfil                 ****");
                                System.out.println("**** 3 - Listar Veiculos               ****");
                                System.out.println("**** 4 - Informacao de um Automóvel    ****");
                                System.out.println("**** 5 - Reservar veiculo              ****");
                                System.out.println("**** 6 - Consultar Histórico           ****");
                                System.out.println("**** 0 - Logout                        ****");
                                System.out.println("\n*****************************************");
                                System.out.print("Insira a Opção que deseja: ");
                                menu4 = ler.nextInt();
                                switch (menu4) {
                                    case 0:
                                        // caso o Cliente faça logout é invocado o método acoesRealizadas que adiciona uma acao ao cliente
                                        utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Fez Logout ");
                                        break;
                                    case 1:
                                        System.out.println(utilizador.toString()); // Imprime para o ecrã as informações do perfil logado
                                        // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                        utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Visualizou o seu Perfil ");
                                        break;
                                    case 2:
                                        System.out.println(utilizador.toString()); //imprime as informações do cliente logado

                                        int menu5;
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
                                            menu5 = ler.nextInt();
                                            // possibilidade do cliente editar as suas informações optando pelo opção que escolher
                                            switch (menu5) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Nome: ");
                                                    nome = ler.next();
                                                    utilizador.setNome(nome);
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Editou o seu Nome: " +nome);
                                                    break;
                                                case 2:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Apelido: ");
                                                    apelido = ler.next();
                                                    utilizador.setApelido(apelido);
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Editou o seu Apelido: " +apelido);
                                                    break;
                                                case 3:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Email: ");
                                                    email = ler.next();
                                                    utilizador.setEmail(email);
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Editou o seu Email: " +email);
                                                    break;
                                                case 4:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere a Password: ");
                                                    password = ler.next();
                                                    utilizador.setPassword(password);
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Editou a sua Password: " +password);
                                                    break;
                                                case 5:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere a Cidade: ");
                                                    cidade = ler.next();
                                                    utilizador.setCidade(cidade);
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Editou a sua Cidade: " +cidade);
                                                    break;
                                                case 6:
                                                    utilizadorNovo = utilizador;
                                                    System.out.println("Altere o Telemóvel: ");
                                                    telemovel = ler.nextInt();
                                                    utilizador.setTelemovel(telemovel);
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Editou o seu Telemóvel: " +telemovel);
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                            utilizadores.set(indiceUtilizador, utilizadorNovo);
                                            utilizador = utilizadorNovo;
                                        } while (menu5 != 0);
                                        break;
                                    case 3:
                                        int menu6;
                                        do {
                                            System.out.println("\n\n*****      Listar Veículos        *****");
                                            System.out.println("\n****************************************");
                                            System.out.println("**** 1 - Listar por marca            ****");
                                            System.out.println("**** 2 - Listar por modelo           ****");
                                            System.out.println("**** 3 - Listar por ano              ****");
                                            System.out.println("**** 4 - Listar por preço            ****");
                                            System.out.println("**** 5 - Listar todos os Automóveis  ****");
                                            System.out.println("**** 0 - Sair                        ****");
                                            System.out.println("\n****************************************");
                                            System.out.print("\nInsira a opção que deseja: ");
                                            menu6 = ler.nextInt();
                                            switch (menu6){
                                                case 0:
                                                    break;
                                                case 1:
                                                    System.out.println("Escolha a Marca: ");
                                                    marca = ler.next();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getMarca().equals(marca) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                            System.out.println(auto.toString()); //imprime para o ecrã todos os automóveis disponíveis da marca escolhida
                                                        }
                                                    }
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Listou os Automóveis por Marca: " +marca);
                                                    break;
                                                case 2:
                                                    System.out.println("Escolha o Modelo: ");
                                                    modelo = ler.next();
                                                    for(Automovel auto : automoveis) {
                                                        if (auto.getModelo().equals(modelo) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)) {
                                                            System.out.println(auto.toString()); //imprime para o ecrã todos os automóveis disponíveis do modelo escolhido
                                                        }
                                                    }
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Listou os Automóveis por Modelo: " +modelo);
                                                    break;
                                                case 3:
                                                    System.out.println("Escolha o Ano: ");
                                                    ano = Integer.parseInt(ler.next());
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getAno() == ano && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                            System.out.println(auto.toString()); //imprime para o ecrã todos os automóveis disponíveis do ano escolhido
                                                        }
                                                    }
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Listou os Automóveis por Ano: " +ano);
                                                    break;
                                                case 4:
                                                    System.out.println("Escolha o Preço Máximo: ");
                                                    preco = ler.nextFloat();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getPreco() <= preco && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                            System.out.println(auto.toString()); //imprime para o ecrã todos os automóveis disponíveis abaixo do preço escolhido
                                                        }
                                                    }
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Listou os Automóveis por Preço: " +preco);
                                                    break;
                                                case 5:
                                                    for (Automovel auto : automoveis) {
                                                        if (auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                            System.out.println(auto.toString()); //imprime para o ecrã todos os automóveis disponíveis
                                                        }
                                                    }
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Listou Todos os Automóveis Disponíveis ");
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                        } while(menu6 != 0);
                                        break;
                                    case 4:
                                        // Informação de um Automóvel
                                        for(Automovel auto : automoveis){ // imprime para o ecrã as matrículas dos automóveis disponíveis
                                            if(auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                System.out.println(auto.matriculas());
                                            }
                                        }
                                        System.out.println("Escolha o Veículo pela sua Matrícula: ");
                                        matricula = ler.next();
                                        for (Automovel auto: automoveis){
                                            if(auto.getMatricula().equals(matricula) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                System.out.println(auto.toString()); //imprime para o ecrã a informação do automóvel escolhido pelo cliente
                                            }
                                        }
                                        // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                        utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Viu A Informação do Automóvel com Matrícula: " +matricula);
                                        break;
                                    case 5:
                                        // Reservar Automóvel
                                        System.out.println("\n\n*****       Reservar Automóvel       *****");

                                        for (Automovel auto : automoveis) { // imprime para o ecrã os automóveis disponíveis
                                            if (auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                System.out.println(auto.matriculas());
                                            }
                                        }

                                        System.out.println("Insira a matrícula: ");
                                        matricula = ler.next();

                                        for (Automovel auto: automoveis){
                                            if(auto.getMatricula().equals(matricula) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)) {
                                                System.out.println("Insira a data: ");
                                                data = ler.next();
                                                utilizador.reservarAutomovel(matricula, data); // invoca o método reservarAutomóvel para criar uma reserva para o cliente logado
                                                // Alterar estados do Automóvel
                                                auto.setEstado(Automovel.Estado.RESERVADO);
                                                System.out.println("Reserva efetuada com sucesso!!");
                                            }
                                        }
                                        // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                        utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Reservou o Automóvel com Matrícula: " +matricula);
                                        break;
                                    case 6:
                                        int menu7;
                                        do {
                                            System.out.println("\n\n*****       Consultar Histórico       *****");
                                            System.out.println("\n**********************************************");
                                            System.out.println("**** 1 - Consultar Histórico de Compras    ****");
                                            System.out.println("**** 2 - Consultar Histórico de Reservas   ****");
                                            System.out.println("**** 3 - Consultar Histórico de Ações      ****");
                                            System.out.println("**** 0 - Sair                              ****");
                                            System.out.println("\n**********************************************");
                                            System.out.print("\nInsira a opção que deseja: ");
                                            menu7 = ler.nextInt();
                                            switch (menu7) {
                                                case 0:
                                                    break;
                                                case 1:
                                                    System.out.println("\n\n*****      Histórico de Compras      *****");
                                                    vendas = utilizador.getVendas();
                                                    for (Vendas venda : vendas){ // imprime para o ecrã as compras feitas pelo cliente logado
                                                        System.out.println(venda.vendasEfetuadas());
                                                    }
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Consultou o Seu Histórico de Compras ");
                                                    break;
                                                case 2:
                                                    System.out.println("\n\n*****      Histórico de Reservas       *****");
                                                    reservas = utilizador.getReservas();
                                                    for (Reserva reserva : reservas) { // imprime para o ecrã as reservas feitas pelo cliente logado
                                                        System.out.println(reserva.reservasEfetuadas());
                                                    }
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Consultou o Seu Histórico de Reservas ");
                                                    break;
                                                case 3:
                                                    System.out.println("\n\n*****      Histórico de Ações       *****");
                                                    // É invocado o método acoesRealizadas e adiciona uma acao ao Cliente
                                                    utilizador.acoesRealizadas(utilizador.getNif(), "Cliente Consultou o Seu Histórico de Ações ");
                                                    acoes = utilizador.getAcoes();
                                                    for (Acao acao: acoes){ // imprime para o ecrã as ações realizadas por o cliente logado
                                                        System.out.println("NIF: " + acao.getNif() + " - " + acao.getNomeAcao() + " - " + acao.getDataHora());
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                        } while (menu7 != 0);
                                        break;
                                }
                            } while (menu4 != 0);
                        } else if(utilizador.getTipoUser().equals("userManager")){ // se o tipo de Utilizador for "userManager" imprime para o ecrã o ecrã seguinte
                            int menu8;
                            do {
                                System.out.println(utilizador.ola());
                                System.out.println("\n\n**********         Menu UserManager          **********");
                                System.out.println("\n********************************************************");
                                System.out.println("***** 1 - Visualizar Perfil                         *****");
                                System.out.println("***** 2 - Editar Perfil                             *****");
                                System.out.println("***** 3 - Criar Utilizador                          *****");
                                System.out.println("***** 4 - Editar Utilizador                         *****");
                                System.out.println("***** 5 - Listar Veiculos                           *****");
                                System.out.println("***** 6 - Listar Utilizadores                       *****");
                                System.out.println("***** 0 - Logout                                    *****");
                                System.out.println("\n********************************************************");
                                System.out.print("Insira a Opção que deseja: ");
                                menu8 = ler.nextInt();
                                switch (menu8){
                                    case 1:
                                    System.out.println(utilizador.toString()); // imprime para o ecrã o perfil do utilizador logado
                                    break;
                                    case 2:
                                    System.out.println(utilizador.toString()); // imprime para o ecrã o perfil do utilizador logado

                                    int menu5;
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
                                        menu5 = ler.nextInt();
                                        // possibilidade do UserManager editar o seu Perfil optando por editar uma das opções
                                        switch (menu5) {
                                            case 0:
                                                break;
                                            case 1:
                                                utilizadorNovo = utilizador;
                                                System.out.println("Altere o Nome: ");
                                                nome = ler.next();
                                                utilizador.setNome(nome);
                                                break;
                                            case 2:
                                                utilizadorNovo = utilizador;
                                                System.out.println("Altere o Apelido: ");
                                                apelido = ler.next();
                                                utilizador.setApelido(apelido);
                                                break;
                                            case 3:
                                                utilizadorNovo = utilizador;
                                                System.out.println("Altere o Email: ");
                                                email = ler.next();
                                                utilizador.setEmail(email);
                                                break;
                                            case 4:
                                                utilizadorNovo = utilizador;
                                                System.out.println("Altere a Password: ");
                                                password = ler.next();
                                                utilizador.setPassword(password);
                                                break;
                                            case 5:
                                                utilizadorNovo = utilizador;
                                                System.out.println("Altere a Cidade: ");
                                                cidade = ler.next();
                                                utilizador.setCidade(cidade);
                                                break;
                                            case 6:
                                                utilizadorNovo = utilizador;
                                                System.out.println("Altere o Telemóvel: ");
                                                telemovel = ler.nextInt();
                                                utilizador.setTelemovel(telemovel);
                                                break;
                                            default:
                                                System.out.println("Opcao Inválida!\n\n");
                                        }
                                        utilizadores.set(indiceUtilizador, utilizadorNovo);
                                        utilizador = utilizadorNovo;
                                    } while (menu5 != 0);
                                    break;
                                    case 3:
                                        // Criar um Novo Utilizador
                                        utilizadorCriado = adicionarUtilizador();
                                        if (utilizadorCriado != null) {
                                            existe = false;
                                        }
                                        for (Utilizador user : utilizadores){
                                            if (utilizadorCriado.getNif() == user.getNif()) { // compara se o nif do utilizador Criado já existe
                                                existe = true; // se sim existe passa para true
                                            }
                                        }
                                        if (existe) { // se já existir dá erro
                                            System.out.println("NIF já existente!\n");
                                        } else { // se existe for false adiciona o utilizador
                                            System.out.println("Utilizador Registado com Sucesso!\n");
                                            utilizadores.add(utilizadorCriado);
                                        }
                                        break;
                                    case 4:
                                        // Editar Perfil de um Utilizador que não o que está Logado
                                        for (Utilizador user : utilizadores) { // imprime para o ecrã os nifs existentes
                                                System.out.println(user.nifs());
                                        }
                                        System.out.println("Escolha o Utilizador pelo seu nif: ");
                                        nif = Integer.parseInt(ler.next());
                                        for (Utilizador user: utilizadores){ // se o nif for um que já existe imprime para o ecrã a informação desse utilizador
                                            if(user.getNif() == nif){
                                                System.out.println(user.toString());
                                            }
                                        }
                                        for (Utilizador user : utilizadores){ //imprime para o ecrã a informação do utilizador escolhido pelo UserManager
                                            if (user.getNif() == nif){
                                                System.out.println(user.toString());

                                                int menu3;
                                                do {
                                                    System.out.println("\n\n*****        Editar Utilizador         *****");
                                                    System.out.println("\n*********************************************");
                                                    System.out.println("**** 1 - Nome                            *****");
                                                    System.out.println("**** 2 - Apelido                         *****");
                                                    System.out.println("**** 3 - Email                           *****");
                                                    System.out.println("**** 4 - Password                        *****");
                                                    System.out.println("**** 5 - Cidade                          *****");
                                                    System.out.println("**** 6 - Telemóvel                       *****");
                                                    System.out.println("**** 7 - Tipo de Utilizador              *****");
                                                    System.out.println("**** 0 - Sair                            *****");
                                                    System.out.println("\n*********************************************");
                                                    System.out.print("Insira a Informação que deseja Editar: ");
                                                    menu3 = ler.nextInt();
                                                    // possibilidade de o UserManager editar as informações de um cliente
                                                    switch (menu3) {
                                                        case 0:
                                                            break;
                                                        case 1:
                                                            utilizadorNovo = user;
                                                            System.out.println("Altere o Nome: ");
                                                            nome = ler.next();
                                                            user.setNome(nome);
                                                            break;
                                                        case 2:
                                                            utilizadorNovo = user;
                                                            System.out.println("Altere o Apelido: ");
                                                            apelido = ler.next();
                                                            user.setApelido(apelido);
                                                            break;
                                                        case 3:
                                                            utilizadorNovo = user;
                                                            System.out.println("Altere o Email: ");
                                                            email = ler.next();
                                                            user.setEmail(email);
                                                            break;
                                                        case 4:
                                                            utilizadorNovo = user;
                                                            System.out.println("Altere a Password: ");
                                                            password = ler.next();
                                                            user.setPassword(password);
                                                            break;
                                                        case 5:
                                                            utilizadorNovo = user;
                                                            System.out.println("Altere a Cidade: ");
                                                            cidade = ler.next();
                                                            user.setCidade(cidade);
                                                            break;
                                                        case 6:
                                                            utilizadorNovo = user;
                                                            System.out.println("Altere o Telemóvel: ");
                                                            telemovel = Integer.parseInt(ler.next());
                                                            user.setTelemovel(telemovel);
                                                            break;
                                                        case 7:
                                                            utilizadorNovo = user;
                                                            System.out.println("Altere o Tipo de User (cliente/userManager/admin): ");
                                                            tipoUser = ler.next();
                                                            user.setTipoUser(tipoUser);
                                                            break;
                                                        default:
                                                            System.out.println("Opcao Inválida!\n\n");
                                                    }
                                                    indiceUtilizador = utilizadores.indexOf(user);
                                                    utilizadores.set(indiceUtilizador, utilizadorNovo);
                                                    user = utilizadorNovo;
                                                } while (menu3 != 0);
                                            }
                                        }
                                        break;
                                    case 5:
                                        // Listar Automóveis por Filtros
                                        int menu6;
                                        do {
                                            System.out.println("\n\n*****      Listar Automóveis      *****");
                                            System.out.println("\n****************************************");
                                            System.out.println("**** 1 - Listar por marca            ****");
                                            System.out.println("**** 2 - Listar por modelo           ****");
                                            System.out.println("**** 3 - Listar por ano              ****");
                                            System.out.println("**** 4 - Listar por preço            ****");
                                            System.out.println("**** 5 - Listar todos os Automóveis  ****");
                                            System.out.println("**** 0 - Sair                        ****");
                                            System.out.println("\n****************************************");
                                            System.out.print("\nInsira a opção que deseja: ");
                                            menu6 = ler.nextInt();
                                            switch (menu6){
                                                case 0: break;
                                                case 1:
                                                    System.out.println("Escolha a Marca: ");
                                                    marca = ler.next();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getMarca().equals(marca)){
                                                            System.out.println(auto.toString()); //imprime para o ecrã os automóveis com a marca selecionada
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Escolha o Modelo: ");
                                                    modelo = ler.next();
                                                    for(Automovel auto : automoveis) {
                                                        if (auto.getModelo().equals(modelo)) {
                                                            System.out.println(auto.toString()); //imprime para o ecrã os automóveis com o modelo selecionado
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Escolha o Ano: ");
                                                    ano = Integer.parseInt(ler.next());
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getAno() == ano){
                                                            System.out.println(auto.toString()); //imprime para o ecrã os automóveis com o ano selecionado
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Escolha o Preço Máximo: ");
                                                    preco = ler.nextFloat();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getPreco() <= preco){
                                                            System.out.println(auto.toString()); //imprime para o ecrã os automóveis com o preço abaixo do selecionado
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    for (Automovel auto : automoveis) {
                                                        System.out.println(auto.toString()); //imprime para o ecrã todos os automóveis
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                        } while(menu6 != 0);
                                        break;
                                    case 6:
                                        // Listar utilizadores com filtros
                                    int menu9;
                                    do {
                                        System.out.println("\n\n*****     Listar Utilizadores          *****");
                                        System.out.println("\n*********************************************");
                                        System.out.println("**** 1 - Listar por Cidade                ****");
                                        System.out.println("**** 2 - Listar por NIF                   ****");
                                        System.out.println("**** 3 - Listar por Tipo                  ****");
                                        System.out.println("**** 4 - Listar Todos os Utilizadores     ****");
                                        System.out.println("**** 0 - Sair                             ****");
                                        System.out.println("\n*********************************************");
                                        System.out.print("\nInsira a opção que deseja: ");
                                        menu9 = ler.nextInt();
                                        switch (menu9){
                                            case 1:
                                                System.out.println("Insira uma Cidade: ");
                                                cidade = ler.next();
                                                for (Utilizador user: utilizadores){
                                                    if(user.getCidade().equals(cidade)){
                                                        System.out.println(user.toString()); //imprime para o ecrã os utilizadores da cidade selecionada
                                                    }
                                                }
                                                break;
                                            case 2:
                                                for (Utilizador user : utilizadores) {
                                                    System.out.println(user.nifs());
                                                }
                                                System.out.println("Escolha o Cliente pelo seu NIF: ");
                                                nif = Integer.parseInt(ler.next());
                                                for (Utilizador user: utilizadores){
                                                    if(user.getNif() == nif){
                                                        System.out.println(user.toString()); //imprime para o ecrã o utilizadore com o NIF selecionado
                                                    }
                                                }
                                                break;
                                            case 3:
                                                System.out.println("\nTipos de Utilizador: ");
                                                System.out.println("admin");
                                                System.out.println("userManager");
                                                System.out.println("cliente");
                                                System.out.println("\nInsira um Tipo de Utilizador: ");
                                                tipoUser = ler.next();
                                                for (Utilizador user: utilizadores){
                                                    if(user.getTipoUser().equals(tipoUser)){
                                                        System.out.println(user.toString()); //imprime para o ecrã os utilizadores do tipo selecionado
                                                    }
                                                }
                                                break;
                                            case 4:
                                                for (Utilizador user : utilizadores) {
                                                    System.out.println(user.toString()); //imprime para o ecrã todos os utilizadores
                                                }
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Opcao Inválida!\n\n");
                                        }
                                    }while(menu9 != 0);
                                    break;
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opcao Inválida!\n\n");
                                }
                            }while (menu8 != 0);

                        }
                    }
                    break;
                default:
                    System.out.println("Opcao Inválida!\n\n");
            }
        } while (menu1 != 0);

    }
}