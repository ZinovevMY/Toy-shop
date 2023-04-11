package view;

import java.util.Scanner;

public class UserInterface {

    public void startMenu(){
        System.out.println("_______________");
        System.out.println("Автомат игрушек");
        System.out.println("---------------");
        System.out.println("Доступные команды: ADD_TOY, REMOVE_TOY," +
                           "VIEW_TOYS, HELP, WIN_TOY, EXIT");
        System.out.println("Для справки введите HELP!");
    }

    public void run(){
        Commands com = Commands.NONE;
        while (true){
            startMenu();
            String command = prompt("-> ");
            try{
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT){
                    return;
                }
                switch (com){
                    case ADD_TOY:
                        System.out.println("ADD_TOYS");
                        break;
                    case REMOVE_TOY:
                        System.out.println("REMOVE_TOY");
                        break;
                    case VIEW_TOYS:
                        System.out.println("VIEW_TOYS");
                        break;
                    case WIN_TOY:
                        System.out.println("WIN_TOY");
                        break;
                    case HELP:
                        printHelp();
                }

            }catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void printHelp(){
        for (Commands com: Commands.values()){
            System.out.println(com.getTitle());
        }
    }

}
