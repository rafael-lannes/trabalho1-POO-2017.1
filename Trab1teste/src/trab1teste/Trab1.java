// Trabalho 01 PROGRAMAÇÃO ORIENTADA A OBJETO
// ALUNO: RAFAEL DE FARIAS LANNES
// PROFESSOR : LEONARDO CRUZ DA COSTA
// DATA DE ENTREGA 31/03/2017
//OBS: O programa lê o arquivo com nome "pessoas.txt" que deve se encontrar na pasta raiz do projeto!
package trab1teste;
//Todas Importações Usadas:
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Inicio do código:
public class Trab1 {
    //Método Principal:
    public static void main(String[] args) {
        //Declarações:
        List lista = new ArrayList();                                           //Cria Array List para armazenar todos os nomes.
        int opc = 4;                                                            //Variável da opção do Menu.
        while (opc != 9) {
            System.out.println("-=Bem vindo ao Trabalho =-");                   // Menu Principal
            System.out.println("0- Carregar Arquivo");
            System.out.println("1- Inserir Nome");
            System.out.println("2- Exibir Nomes");
            System.out.println("3- Gravar Nomes");
            System.out.println("9- Sair");
            System.out.print("Digite a Opção a seguir:");
            Scanner teclado = new Scanner(System.in);                           // Criando o objeto teclado
            opc = teclado.nextInt();                                            // opc recebe entrada do teclado.
            switch (opc) {
                case 0://Carregar a lista de nome de pessoas:
                    System.out.println("Carregar lista de nomes:");
                    String fileName = "pessoas.txt";                            //fileName recebe nome do arquivo.
                    String line = null;
                    try {
                        FileReader fileReader = new FileReader(fileName);       //Lê o arquivo com nome em fileName
                        BufferedReader bufferedReader = new BufferedReader(fileReader); // Novo objeto que lê o texto no arquivo em fileName
                        while ((line = bufferedReader.readLine()) != null) {    //Enquanto a linha for != de NULL 
                            lista.add(line);                                    //Adiciona o nome que está na linha (line) a lista.
                        }
                        String[] strings = (String[]) lista.toArray(new String[0]); //Converte a lista para um array , assim posso manipular seus elementos por índice.
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println("Nome carregado na posição " + i + " : " + strings[i]);
                        }
                        bufferedReader.close();                                 //Fecha o Arquivo (Aqui , tanto fechando ou não , o arquivo no final é sobscrito evitando assim quaisquer erros.
                    } 
                    //Tratamento de erro:
                    catch (FileNotFoundException ex) {
                        System.out.println("Não foi possível abrir '"+ fileName + "'Por favor, coloque um arquivo com o mesmo nome na pasta raiz do projeto.");
                    } 
                    catch (IOException ex) {
                        System.out.println("Erro ao ler o arquivo '" + fileName + "'");
                    }
                        break;
                case 1://Inserir um nome de pessoa na lista:
                    System.out.println("Inserir Nome");
                    lista.add(Ler_nome());                                      //Chamada do método Ler_Nome
                    String[] strings = (String[]) lista.toArray(new String[0]); //Converte lista em array.
                    for (int i = 0; i < lista.size(); i++) {                    //Exibe a Lista (Para conferir se está tudo ok)
                        System.out.println("Nome na posição " + i + " : " + strings[i]);
                        }
                    break;
                case 2:                                                         //Exibe os nomes atualmente na lista.
                    System.out.println("Exibindo Nomes:");
                    Exibir_nome(lista);                                         //Chamada do método Exibir_nome.
                    break;
                case 3://Gravar Lista de nomes de Pessoas no arquivo.
                    System.out.println("Gravando Nomes...");                        
                    Gravar_lista(lista);                                        //Chamada do método Gravar_lista.
                    break;
                default:
                    System.out.println("Entrada Errada");

            }
        //System.out.print("Digite a Opção a seguir:");                           //Para receber o próximo comando.
        //opc = teclado.nextInt();
        }
        System.out.println("FIM");                                              //Mensagem que encerra o programa.
    }
    
    public static void Exibir_nome(List lista) {                                //Método Exibir_nome recebe como parâmetro a lista que foi copiada do arquivo.
        String[] strings = (String[]) lista.toArray(new String[0]);             //Converte a lista em array.
        for (int i = 0; i < lista.size(); i++) {                                //Imprime na tela elemento a elemento do array.
            System.out.println("Nome na posição " + i + " : " + strings[i]);
        }
    }                                                                           //Fim do método Exibir_nome
    
    public static String Ler_nome(){                                            //Método Ler_Nome não possui parâmetro porém retorna uma string com o nome inserido.
        String nome_lido;                                                       //Declaração da variável que armazenará a String com o Nome.
        Scanner teclado = new Scanner(System.in);                               //Declara o objeto teclado como entrada
        System.out.println("Digite o nome que deseja inserir:");                
        nome_lido = teclado.nextLine();                                         //Recebe Nome do teclado.
        return nome_lido;                                                       //Retorna o Nome recebido.
    }                                                                           //Fim do Método Ler_nome
    
    public static void Gravar_lista(List lista) {                               //Método gravar lista recebe como parâmetro a lista com os nomes e sobscreve o arquivo texto.
        String fileName = "pessoas.txt";                                        //String com o nome do arquivo.
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false));    //O parâmetro em false se refere ao Append. False ele sobscreve o arquivo.
            String[] strings = (String[]) lista.toArray(new String[0]);         //Converte a lista em Array.
            for (int i = 0; i < lista.size(); i++) {                            //Laço For percorre o array.
                if(i!=0)
                            bufferedWriter.newLine();                           //Pula uma Linha se não for a primeira
                bufferedWriter.write(strings[i]);                               //Grava os elementos da lista no arquivo pessoas.txt
            }
            bufferedWriter.close();                                             //Fecha o arquivo lido.
        } 
        catch (IOException ex) {                                                //Tratamento de erro de leitura.
            System.out.println("Erro ao gravar o arquivo: '" + fileName + "'");
        }
        System.out.println("Gravado com Sucesso!");
    }
}
//Fim do código
// Trabalho 01 PROGRAMAÇÃO ORIENTADA A OBJETO
// ALUNO: RAFAEL DE FARIAS LANNES
// PROFESSOR : LEONARDO CRUZ DA COSTA
// DATA DE ENTREGA 31/03/2017