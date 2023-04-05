import java.util.Scanner;

public class BichinhoVirtual {

    private String name;
    private String classe;
    private String family;
    private int age;
    private boolean alive;
    private int calories;
    private int force;

    public BichinhoVirtual(String name, String classe, String family) {
        this.name = name;
        this.classe = classe;
        this.family = family;
        this.age = 0;
        this.alive = true;
        this.calories = 10;
        this.force = 10;
    }

    public void die() {
        if (alive) {
            alive = false;
            force = 0;
            System.out.println("O animal morreu!");
        } else {
            System.out.println("O animal já está morto.");
        }
    }

    public void eat() {
        if (alive && calories < 100) {
            calories += 10;
            force = Math.max(force - 2, 0);
            System.out.println("O animal comeu e agora sua força é " + force + " e suas calorias são " + calories);
        } else if (alive) {
            System.out.println("O animal não pode comer mais.");
        } else {
            System.out.println("O animal está morto.");
        }
    }

    public void run() {
        if (alive && calories > 0) {
            calories -= 5;
            force -= 5;
            System.out
                    .println("O animal está correndo! Agora sua força é " + force + " e suas calorias são " + calories);
        } else if (alive) {
            System.out.println("O animal não pode correr mais.");
        } else {
            System.out.println("O animal está morto.");
        }
    }

    public void sleep() {
        if (alive) {
            force += 10;
            calories -= 2;
            System.out.println(
                    "O animal está dormindo! Sua força aumentou para " + force + " e suas calorias são " + calories);
        } else {
            System.out.println("O animal está morto.");
        }
    }

    public void state() {
        System.out.println("Nome: " + name);
        System.out.println("Classe: " + classe);
        System.out.println("Família: " + family);
        System.out.println("Idade: " + age);
        System.out.println("Vivo: " + alive);
        System.out.println("Calorias: " + calories);
        System.out.println("Força: " + force);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o name do bichinho: ");
        String name = scanner.nextLine();
        System.out.print("Digite o name da classe do bichinho: ");
        String classe = scanner.nextLine();
        System.out.print("Digite a família do bichinho: ");
        String family = scanner.nextLine();

        BichinhoVirtual bichinho = new BichinhoVirtual(name, classe, family);

        System.out.println("Bem-vindo ao seu bichinho virtual!");
        System.out.println("Comandos disponíveis: ");
        System.out.println("1 - Comer");
        System.out.println("2 - Correr");
        System.out.println("3 - Dormir");
        System.out.println("4 - Mostrar estado");
        System.out.println("5 - Matar");
        System.out.println("0 - Sair");

        int option;

        do {
            System.out.print("Digite uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    bichinho.eat();
                    break;
                case 2:
                    bichinho.run();
                    break;
                case 3:
                    bichinho.sleep();
                    break;
                case 4:
                    bichinho.state();
                    break;
                case 5:
                    bichinho.die();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (option != 0);

        scanner.close();
    }
}
