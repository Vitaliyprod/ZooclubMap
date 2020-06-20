import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ZooClub zooClub = new ZooClub(new HashMap<>());
        System.out.print("  Введіть 1: Додати учасника клубу.\n"  //+
                + "  Введіть 2: Додати тваринку до учасника клубу.\n" //+
                + "  Введіть 3: Видалити тваринку з учасника клубу.\n" // +
                + "  Введіть 4: Видалити учасника з клубу.\n" //-
                + "  Введіть 5: Видалити конкретну тваринку зі всіх власників.\n" //+
                + "  Введіть 6: Вивести на екран зооклуб.\n" //-
                + "  Введіть 0: Щоб вийти.\n");
        Line();
        for (; ; ) {
            Scanner intscan = new Scanner(System.in);
            int choiseNumber = intscan.nextInt();
            switch (choiseNumber) {
                case 1:
                    zooClub.addNewMember();
                    Line();
                    break;

                case 2:
                    zooClub.addNewPetToMember();
                    Line();
                    break;

                case 3:
                    zooClub.deletePetFromMember();
                    Line();
                    break;

                case 4:
                    zooClub.deleteMember();
                    Line();
                    break;

                case 5:
                    zooClub.deleteAnimalType();
                    Line();
                    break;

                case 6:
                    zooClub.showAllClub();
                    Line();
                    break;

                case 0:
                    System.exit(0);
                default:
                    System.out.println("Такої кнопки немає. ");
            }
        }
    }


    private static void Line() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
