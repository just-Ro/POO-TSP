package main;

import graph.*;
/* Como compilar o projeto
 * 
 * Entrar na pasta certa:
 * cd src
 * 
 * Compilar tudo:
 * javac main/*.java ant_colony_optimization/*.java discrete_stochastic_simulation/*.java graph/*.java
 * 
 * Criar o executável:
 * jar cmf manif.txt project.jar main/* ant_colony_optimization/* discrete_stochastic_simulation/* graph/*
 * 
 * Correr o executável:
 * java -jar project.jar
 */

public class Main{
    public static void main(String[] args) throws Exception {
        clearScreen();
        System.out.println("Program started");
        
        // debug without command line arguments
        String[] customArgs = initCustomArgs();

        Args params = new Args(customArgs);   // Parse command line arguments
        
        if(params.readMode()){
            // Read mode
            System.out.println("modo -r");
            MatrixGraph graph = new MatrixGraph(params.nodes, params.maxEdgeWeight);
            System.out.print(graph);

        }else if(params.fileMode()){
            // File mode
            MatrixGraph graph = new MatrixGraph(params.nodes);
            graph.readGraph(params.file);
        
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static String[] initCustomArgs(){
        String[] customArgs = new String[12];
        customArgs[0] = new String("-r");
        customArgs[1] = new String("5");
        customArgs[2] = new String("1");
        customArgs[3] = new String("1");
        customArgs[4] = new String("1");
        customArgs[5] = new String("1");
        customArgs[6] = new String("1");
        customArgs[7] = new String("1");
        customArgs[8] = new String("1");
        customArgs[9] = new String("1");
        customArgs[10] = new String("1");
        customArgs[11] = new String("1");
        return customArgs;
    }
    
}



//tava a mostrar o segredo ao miragem
//ahhhhhhh
//olha o que sao estas coisas nesta parte do codigo?
//nem sei bem, copiei da net e estava agora a analisar
//aaahhhh okok
//nas supostamente é uma classe genérica para grafos
//eu acho q n e preciso algo assim tao avancado, nao basta so ter os get? para ir buscar as cenas importantes do grafo que temos
//a cena é que é
//idk
//eu acho q sim. o stor n ta no sdeec? ta
//nao queres ir perguntar? eu ate ia mas estou um pouco longe
// e pergunto oq
//se esta parte é suposto ser assim ou algo mais simples mesmo so com os get
//eu entrei la ha bocado e o stor tava a explicar ao um gajo que ele tinha que ter uns metodos no grafo para retornar o length do grafo
//n sei mt bem o contexto mas talvez tenha a ver com isto
//talvezz 
//falhei miseravelmente
//                                                 _____
//   											 _/ _ _ \_  
//   											(o / | \ o)
//   											 || o|o ||
//   											 | \_|_/ |
//   											 |  ___  |
//   											 | (___) |
//   											 |\_____/|
//   											 | \___/ |
//   											 \       /
//   											  \__ __/
//conversa bem épica mas agr vamos apagar
// naoooooo deixa aqui, daqui a 3 dias apagamos
//eu se calhar apago o ficheiro inteiro daqui a 3 minutos
//ent calma
//diz adeus
//adeus