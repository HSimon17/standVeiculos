import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    /* Função inserir novo Utilizador */
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
        Utilizador utilizador = new Utilizador(nome, apelido, email, password, nif, telemovel, cidade, tipoUser);
        return utilizador;
    }

    /* Função Login */
    public static Utilizador login(ArrayList<Utilizador> utilizadores) {
        Scanner ler = new Scanner(System.in);
        Utilizador utilizador = null;
        System.out.println("Email: ");
        String email = ler.nextLine();
        System.out.println("Password: ");
        String password = ler.nextLine();

        /* Verifica se email e password são iguais */
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

        utilizadores.add( new Utilizador("Sofia", "Amorim", "ss", "ss", 123, 123, "Braga", "admin"));
        utilizadores.add( new Utilizador("Hugo", "Simoes", "hugo", "123", 12345, 926, "Barcelos", "cliente"));
        utilizadores.add( new Utilizador("Filipa", "Feerz", "ff", "ff", 231, 921, "Braga", "userManager"));
        utilizadores.add( new Utilizador("Marta", "Barbosa", "mm", "mm", 221, 932, "Barcelos", "cliente"));
        automoveis.add(new Automovel("TS-43-NT", "Ford", "Fiesta", "Preto", 2004, 357523, 2100));
        automoveis.add(new Automovel("HS-17-HS", "Audi", "R8", "Branco", 2022, 20, 30000));
        automoveis.add(new Automovel("75-ZT-71", "Citroen", "C3", "Vermelho", 2015, 75000, 14500));
        automoveis.add(new Automovel("ET-86-WE", "Citroen", "C3", "Preto", 2013, 35565, 9010));
        automoveis.add(new Automovel("YJ-75-SF", "Audi", "A1", "Branco", 2015, 64532, 13100));
        automoveis.add(new Automovel("65-ZH-02", "Smart", "44", "Preto", 2021, 53232, 9500));

        Utilizador utilizador, utilizadorNovo = null, utilizadorCriado;
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
                    /* Inserir novo Utilizador */
                    utilizador = adicionarUtilizador();
                    if (utilizador != null) {
                        /* Verifica se o NIF já existe */
                        existe = false;
                    }
                    for (Utilizador user : utilizadores){
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
                    indiceUtilizador = -1;
                    /* Login Utilizador */
                    utilizador = login(utilizadores);
                    if (utilizador == null) {
                        System.out.println("Login Inválido!");
                    } else {
                        for (Utilizador user : utilizadores){
                            if (user.getNif() == utilizador.getNif()) {
                                indiceUtilizador = utilizadores.indexOf(user);
                            }
                        }
                        /* Menu Para cada tipo de User */
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
                                System.out.println("***** 0 - Logout                          *****");
                                System.out.println("\n***********************************************");
                                System.out.print("Insira a Opção que deseja: ");
                                menu2 = ler.nextInt();
                                switch (menu2) {
                                    case 1:
                                        /* Registar Automóvel */
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
                                                /* Verifica se a matrícula já existe */
                                                existe = true;
                                            }
                                        }
                                        if (existe == true) {
                                            System.out.println("Automóvel com essa Matrícula já se encontra registado!\n");
                                        } else {
                                            System.out.println("Automóvel Registado com Sucesso!\n");
                                            automoveis.add(automovel);
                                        }
                                        break;

                                    case 2:
                                        /* Editar Automóvel */
                                        for (Automovel auto : automoveis) {
                                            System.out.println(auto.matriculas());
                                        }
                                        System.out.println("Insira a matrícula: ");
                                        matricula = ler.next();

                                        for (Automovel auto: automoveis){
                                            if (auto.getMatricula().equals(matricula)){
                                                System.out.println(auto.toString());
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
                                        System.out.println("\n\n*****     Desativar Automóvel      *****");

                                        for(Automovel auto : automoveis){
                                            if(!auto.getEstado().equals(Automovel.Estado.DESATIVO)){
                                                System.out.println(auto.matriculas());
                                            }
                                        }

                                        System.out.println("Insira a matrícula: ");
                                        matricula = ler.next();

                                        for (Automovel auto: automoveis) {
                                            if (auto.getMatricula().equals(matricula)) {
                                                auto.setEstado(Automovel.Estado.DESATIVO);
                                                System.out.println("Automóvel Desativado com Sucesso!!");
                                            }
                                        }
                                        break;
                                    case 4:
                                        /* Listar Automóveis com filtros */
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
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Escolha o Modelo: ");
                                                    modelo = ler.next();
                                                    for(Automovel auto : automoveis) {
                                                        if (auto.getModelo().equals(modelo)) {
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Escolha o Ano: ");
                                                    ano = Integer.parseInt(ler.next());
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getAno() == ano){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Escolha o Preço Máximo: ");
                                                    preco = ler.nextFloat();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getPreco() <= preco){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    int menu11;
                                                    do {
                                                        System.out.println("\n\n*****     Listar Veículos      *****");
                                                        System.out.println("\n*************************************");
                                                        System.out.println("**** 1 - Listar por Disponíveis          ****");
                                                        System.out.println("**** 2 - Listar por Reservados         ****");
                                                        System.out.println("**** 3 - Listar por Vendidos            ****");
                                                        System.out.println("**** 4 - Listar por Desativos          ****");
                                                        System.out.println("**** 0 - Sair                      ****");
                                                        System.out.println("\n*************************************");
                                                        System.out.print("\nInsira a opção que deseja: ");
                                                        menu11 = ler.nextInt();
                                                        switch (menu11){
                                                            case 0:
                                                                break;
                                                            case 1:
                                                                for (Automovel auto : automoveis) {
                                                                    if (auto.getEstado().equals(Automovel.Estado.DISPONIVEL)) {
                                                                        System.out.println(auto.toString());
                                                                    }
                                                                }
                                                                break;
                                                            case 2:
                                                                for (Automovel auto : automoveis) {
                                                                    if (auto.getEstado().equals(Automovel.Estado.RESERVADO)) {
                                                                        System.out.println(auto.toString());
                                                                    }
                                                                }
                                                                break;
                                                            case 3:
                                                                for (Automovel auto : automoveis) {
                                                                    if (auto.getEstado().equals(Automovel.Estado.VENDIDO)) {
                                                                        System.out.println(auto.toString());
                                                                    }
                                                                }
                                                                break;
                                                            case 4:
                                                                for (Automovel auto : automoveis) {
                                                                    if (auto.getEstado().equals(Automovel.Estado.DESATIVO)) {
                                                                        System.out.println(auto.toString());
                                                                    }
                                                                }
                                                                break;
                                                        }
                                                    } while(menu11 != 0);
                                                    break;
                                                case 6:
                                                    for (Automovel auto : automoveis) {
                                                        System.out.println(auto.toString());
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                        } while(menu6 != 0);
                                        break;
                                    case 5:
                                        /* Vender Automóvel */
                                        System.out.println("\n\n*****     Registar Compra      *****");
                                        for (Utilizador user : utilizadores) {
                                            if(user.getTipoUser().equals("cliente")) {
                                                System.out.println(user.nifs());
                                            }
                                        }
                                        System.out.println("Escolha o Cliente pelo seu nif: ");
                                        nif = Integer.parseInt(ler.next());

                                        for(Automovel auto : automoveis){
                                            if(auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                System.out.println(auto.matriculas());
                                            }
                                        }
                                        System.out.println("Escolha o Veículo pela sua Matrícula: ");
                                        matricula = ler.next();

                                        for (Automovel auto: automoveis){
                                            for (Utilizador user : utilizadores){
                                                if(auto.getMatricula().equals(matricula) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL) && user.getNif() == nif) {
                                                    System.out.println("Insira a data: ");
                                                    data = ler.next();
                                                    user.venderAutomovel(nif, matricula, data);
                                                    auto.setEstado(Automovel.Estado.VENDIDO);
                                                    System.out.println("Compra efetuada com sucesso!!");
                                                }
                                            }
                                        }
                                        break;
                                    case 6:
                                        /* Validar Reservas */
                                        System.out.println("\n\n*****     Validar Reservas      *****");

                                        for (Utilizador user : utilizadores){
                                            reservas = user.getReservas();
                                            for (Reserva reserva : reservas) {
                                                if (reserva.getEstado().equals(Reserva.Estado.POR_VALIDAR))
                                                    System.out.println(reserva.reservasEfetuadas());
                                            }
                                        }

                                        System.out.println("Insira a matrícula para validar  a reserva: ");
                                        matricula = ler.next();

                                        for (Utilizador user : utilizadores){
                                            reservas = user.getReservas();
                                            for (Reserva reserva: reservas){
                                                for (Automovel auto: automoveis){
                                                    if (reserva.getMatricula().equals(matricula) && reserva.getEstado().equals(Reserva.Estado.POR_VALIDAR) && auto.getMatricula().equals(reserva.getMatricula())){
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
                                        /* Cancelar Reserva */
                                        System.out.println("\n\n*****     Cancelar Reservas      *****");
                                        for (Automovel auto : automoveis) {
                                            if (auto.getEstado().equals(Automovel.Estado.RESERVADO)){
                                                System.out.println(auto.matriculas());
                                            }
                                        }
                                        System.out.println("Insira a matrícula: ");
                                        matricula = ler.next();

                                        for (Utilizador user : utilizadores){
                                            reservas = user.getReservas();
                                            for (Reserva reserva : reservas){
                                                for (Automovel auto: automoveis){
                                                    if(auto.getMatricula().equals(matricula) && auto.getEstado().equals(Automovel.Estado.RESERVADO)) {
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
                                                if(reserva.getEstado().equals(Reserva.Estado.POR_VALIDAR)){
                                                    System.out.println("\nMatricula: " + reserva.getMatricula());
                                                    System.out.println("\nNif cliente: " + reserva.getNif());
                                                    System.out.println("\nData reserva: " + reserva.getData());
                                                    System.out.println("\n*************************************");
                                                }
                                            }
                                        }
                                        break;
                                    case 9:
                                        /* Pesquisar Clientes */
                                        for (Utilizador user : utilizadores) {
                                            if(user.getTipoUser().equals("cliente")) {
                                                System.out.println(user.nifs());
                                            }
                                        }
                                        System.out.println("Escolha o Cliente pelo seu nif: ");
                                        nif = Integer.parseInt(ler.next());
                                        for (Utilizador use: utilizadores){
                                            if(use.getNif() == nif){
                                                System.out.println(use.toString());
                                            }
                                        }
                                        break;
                                    case 10:
                                        /* Ver informacoes do Perfil */
                                        System.out.println(utilizador.toString());
                                        break;
                                    case 11:
                                        System.out.println(utilizador.toString());

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
                                    case 0:
                                        break;
                                    default:
                                        System.out.println("Opcao Inválida!\n\n");
                                }
                            } while (menu2 != 0);
                        } else if (utilizador.getTipoUser().equals("cliente")) {
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
                                    case 1:
                                        System.out.println(utilizador.toString());
                                        break;
                                    case 2:
                                        System.out.println(utilizador.toString());

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
                                    case 3:
                                        int menu6;
                                        do {
                                            System.out.println("\n\n*****     Listar Veículos      *****");
                                            System.out.println("\n*************************************");
                                            System.out.println("**** 1 - Listar por marca          ****");
                                            System.out.println("**** 2 - Listar por modelo         ****");
                                            System.out.println("**** 3 - Listar por ano            ****");
                                            System.out.println("**** 4 - Listar por preço          ****");
                                            System.out.println("**** 5 - Listar todos os Veículos  ****");
                                            System.out.println("**** 0 - Sair                      ****");
                                            System.out.println("\n*************************************");
                                            System.out.print("\nInsira a opção que deseja: ");
                                            menu6 = ler.nextInt();
                                            switch (menu6){
                                                case 0: break;
                                                case 1:
                                                    System.out.println("Escolha a Marca: ");
                                                    marca = ler.next();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getMarca().equals(marca) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Escolha o Modelo: ");
                                                    modelo = ler.next();
                                                    for(Automovel auto : automoveis) {
                                                        if (auto.getModelo().equals(modelo) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)) {
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Escolha o Ano: ");
                                                    ano = Integer.parseInt(ler.next());
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getAno() == ano && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Escolha o Preço Máximo: ");
                                                    preco = ler.nextFloat();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getPreco() <= preco && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    for (Automovel auto : automoveis) {
                                                        if (auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                        } while(menu6 != 0);
                                        break;
                                    case 4:
                                        /* Informação de um Automóvel */
                                        for(Automovel auto : automoveis){
                                            if(auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                System.out.println(auto.matriculas());
                                            }
                                        }
                                        System.out.println("Escolha o Veículo pela sua Matrícula: ");
                                        matricula = ler.next();
                                        for (Automovel auto: automoveis){
                                            if(auto.getMatricula().equals(matricula) && auto.getEstado().equals(Automovel.Estado.DISPONIVEL)){
                                                System.out.println(auto.toString());
                                            }
                                        }
                                        break;
                                    case 5:
                                        /* Reservar Automóvel */
                                        System.out.println("\n\n*****       Reservar Automóvel       *****");

                                        for (Automovel auto : automoveis) {
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
                                                utilizador.reservarAutomovel(matricula, data);
                                                /* Alterar estados do Automóvel */
                                                auto.setEstado(Automovel.Estado.RESERVADO);
                                                System.out.println("Reserva efetuada com sucesso!!");
                                            }
                                        }
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
                                                    for (Vendas venda : vendas){
                                                        System.out.println(venda.vendasEfetuadas());
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("\n\n*****      Histórico de Reservas       *****");
                                                    reservas = utilizador.getReservas();
                                                    for (Reserva reserva : reservas) {
                                                        System.out.println(reserva.reservasEfetuadas());
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                        } while (menu7 != 0);
                                        break;
                                }
                            } while (menu4 != 0);
                        } else if(utilizador.getTipoUser().equals("userManager")){
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
                                    System.out.println(utilizador.toString());
                                    break;
                                    case 2:
                                    System.out.println(utilizador.toString());

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
                                    case 3:
                                        /* Criar um Novo Utilizador */
                                        utilizadorCriado = adicionarUtilizador();
                                        if (utilizadorCriado != null) {
                                            existe = false;
                                        }
                                        for (Utilizador user : utilizadores){
                                            if (utilizadorCriado.getNif() == user.getNif()) {
                                                existe = true;
                                            }
                                        }
                                        if (existe) {
                                            System.out.println("NIF já existente!\n");
                                        } else {
                                            System.out.println("Utilizador Registado com Sucesso!\n");
                                            utilizadores.add(utilizadorCriado);
                                        }
                                        break;
                                    case 4:
                                        /* Editar Perfil de um Utilizador que não o que está Logado */
                                        for (Utilizador user : utilizadores) {
                                                System.out.println(user.nifs());
                                        }
                                        System.out.println("Escolha o Utilizador pelo seu nif: ");
                                        nif = Integer.parseInt(ler.next());
                                        for (Utilizador use: utilizadores){
                                            if(use.getNif() == nif){
                                                System.out.println(use.toString());
                                            }
                                        }
                                        for (Utilizador user : utilizadores){
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
                                        int menu6;
                                        do {
                                            System.out.println("\n\n*****     Listar Veículos      *****");
                                            System.out.println("\n*************************************");
                                            System.out.println("**** 1 - Listar por marca          ****");
                                            System.out.println("**** 2 - Listar por modelo         ****");
                                            System.out.println("**** 3 - Listar por ano            ****");
                                            System.out.println("**** 4 - Listar por preço          ****");
                                            System.out.println("**** 5 - Listar todos os Veículos  ****");
                                            System.out.println("**** 0 - Sair                      ****");
                                            System.out.println("\n*************************************");
                                            System.out.print("\nInsira a opção que deseja: ");
                                            menu6 = ler.nextInt();
                                            switch (menu6){
                                                case 0: break;
                                                case 1:
                                                    System.out.println("Escolha a Marca: ");
                                                    marca = ler.next();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getMarca().equals(marca)){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Escolha o Modelo: ");
                                                    modelo = ler.next();
                                                    for(Automovel auto : automoveis) {
                                                        if (auto.getModelo().equals(modelo)) {
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Escolha o Ano: ");
                                                    ano = Integer.parseInt(ler.next());
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getAno() == ano){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    System.out.println("Escolha o Preço Máximo: ");
                                                    preco = ler.nextFloat();
                                                    for(Automovel auto : automoveis){
                                                        if(auto.getPreco() <= preco){
                                                            System.out.println(auto.toString());
                                                        }
                                                    }
                                                    break;
                                                case 5:
                                                    for (Automovel auto : automoveis) {
                                                        System.out.println(auto.toString());
                                                    }
                                                    break;
                                                default:
                                                    System.out.println("Opcao Inválida!\n\n");
                                            }
                                        } while(menu6 != 0);
                                        break;
                                    case 6:
                                        /* Listar utilizadores com filtros */
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
                                                        System.out.println(user.toString());
                                                    }
                                                }
                                                break;
                                            case 2:
                                                for (Utilizador user : utilizadores) {
                                                    System.out.println(user.nifs());
                                                }
                                                System.out.println("Escolha o Cliente pelo seu NIF: ");
                                                nif = Integer.parseInt(ler.next());
                                                for (Utilizador use: utilizadores){
                                                    if(use.getNif() == nif){
                                                        System.out.println(use.toString());
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
                                                        System.out.println(user.toString());
                                                    }
                                                }
                                                break;
                                            case 4:
                                                for (Utilizador user : utilizadores) {
                                                    System.out.println(user.toString());
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