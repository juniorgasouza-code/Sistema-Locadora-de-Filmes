import java.util.HashMap;
import java.util.Scanner;

public class SIstemaLocadoraFilmes {
    static Scanner SC = new Scanner(System.in);
    static HashMap<String, String> filmes = new HashMap<>();
    static HashMap<String, String> clientes = new HashMap<>();
    static HashMap<String, String> emprestimo = new HashMap<>();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        while (true) {
            System.out.println(
                    "1-Cadastrar Filme\n2-Cadastrar Cliente\n3-Realizar Operações\n4-Listar locações de um cliente\n5-Sair\n>");
            int escolhaMostrarMenu = SC.nextInt();
            switch (escolhaMostrarMenu) {
                case 1:
                    // Cadastrar filmes
                    cadastrarfilmes();
                    break;
                case 2:
                    // Cadastro Clientes
                    cadastroClientes();
                    break;
                case 3:
                    // Realizar Operção
                    realizarOperacoes();
                    break;
                case 4:
                    listarLocacoesCliente();
                    break;
                case 5:
                    System.out.println("Saindo do sistema!");
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    public static void cadastrarfilmes() {
        System.out.println("Digite o codigo do filme\n>");
        String codigo = SC.next();
        if (filmes.containsKey(codigo)) {
            System.out.println("Filme ja cadastrado! voltando ao menu principal...");
            return;
        } else {
            System.out.println("Insira o nome do filme\n>");
            String nome = SC.next();
            filmes.put(codigo, nome);
            System.out.println("Cadastro de filme realizado com sucesso!");
        }
    }

    public static void cadastroClientes() {
        System.out.println("Insira o cpf do cliente\n>");
        String cpf = SC.next();
        if (clientes.containsKey(cpf)) {
            System.out.println("Cliente ja cadastrado! voltando ao menu principal");
            return;
        } else {
            System.out.println("Insira o nome do cliente\n>");
            String nome = SC.next();
            clientes.put(cpf, nome);
            System.out.println("Cadastro de cliente realizado com sucesso!");
        }
    }

    public static void realizarOperacoes(){
        System.out.println("Informe seu cpf\n>");
        String cpf = SC.next();
        if(!clientes.containsKey(cpf)){
            System.out.println("CPF não cadastrado!");
        }else{
            System.out.println("Filmes disponiveis");
            for (String  codigos : filmes.keySet()) {
                String titulos = filmes.get(codigos);
                System.out.println("Codigo: " + codigos + " Titulos: " + titulos);
            }
            System.out.println("Insira o id do filme\n>");
            String idFilme = SC.next();
            if(!filmes.containsKey(idFilme)){
                System.out.println("Filme não existente retornando ao menu...");
                return;
            }else{
                emprestimo.put(cpf, idFilme);
            }
            }
        }
        public static void listarLocacoesCliente(){
            System.out.println("Todos os IDS de filmes alugados e os seus respectivos CPFs");
            for (String cpf : emprestimo.keySet()) {
                String nomeCliente = emprestimo.get(cpf);
                String idFilme = emprestimo.get(cpf);
                String tituloFilmes = emprestimo.get(cpf);
                System.out.println("Cliente: "  + nomeCliente + "CPF: " + cpf + " Filme alugado: " + tituloFilmes + " Id do filme: " + idFilme);
            }
        }
    }

