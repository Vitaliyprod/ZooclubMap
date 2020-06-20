import java.util.*;

public class ZooClub {
    Map<Person, List<Pet>> map;

     ZooClub(Map<Person, List<Pet>> map) {
        this.map = map;
    }

    private Map<Person, List<Pet>> getMap() {
        return map;
    }

    public void setMap(Map<Person, List<Pet>> map) {
        this.map = map;
    }

    private Person printPerson(){
        Scanner intscan = new Scanner(System.in);
        Scanner strscan = new Scanner(System.in);
        System.out.println("Введіть імя учасника: ");
        String name = strscan.nextLine();
        System.out.println("Введіть вік учасника: ");
        int age = intscan.nextInt();
        return new Person(name, age);
    }

    private Pet printPet(){
        Scanner strscan = new Scanner(System.in);
        System.out.println("Введіть тип улюбленця: ");
        String type = strscan.nextLine();
        System.out.println("Введіть імя улюбленця: ");
        String petName = strscan.nextLine();
        return new Pet(type, petName);
    }

    void addNewMember(){
        Person person = printPerson();
        if(map.containsKey(person)){
            System.out.println("Дана особа вже є учасником клубу. ");
        }
        else{
            map.put(person, new ArrayList<>());
            System.out.println("Учасника успішно додано. ");
        }
    }

    void addNewPetToMember(){
        Person person = printPerson();
        if(map.containsKey(person)){
            map.get(person).add(printPet());
            System.out.println("Улюбленця успішно додано. ");
        }else {
            System.out.println("Такого учасника немає. ");
        }
    }

    void deletePetFromMember(){
        Person person = printPerson();
        if(map.containsKey(person)){
            Pet pet = printPet();
            if(map.containsValue(pet)){
                map.get(person).remove(pet);
                System.out.println("Улюбленця видалено. ");
            }else{
                System.out.println("Такого улюбленця немає. ");
            }
        } else {
            System.out.println("Такої людини немає. ");
        }
    }

    void deleteMember(){
        Person person = printPerson();
        if(map.containsKey(person)){
            map.remove(person);
            System.out.println("Учасника видалено. ");
        }
        else{
            System.out.println("Такого учасника немає. ");
        }
    }

    void deleteAnimalType(){
        Scanner strscan = new Scanner(System.in);
        System.out.println("Введіть тип улюбленця для видалення: ");
        String type = strscan.next();
        Set<Person> keySet = map.keySet();
        for (Person key : keySet) {
            ListIterator<Pet> iter = map.get(key).listIterator();
            while (iter.hasNext()) {
                Pet pet = (Pet) iter.next();
                if (pet.getType().equals(type)) {
                    iter.remove();
                }
            }
        }
    }

    void showAllClub(){
        for (Map.Entry<Person, List<Pet>> map: map.entrySet()) {
            System.out.println("Імя власниика: " + map.getKey().getName());
            System.out.println("Вік: " + map.getKey().getAge());
            String str = map.getValue().toString().replace(']', ' ')
                    .replace('[', ' ').replaceAll(",", "");
            System.out.println("Улюбленці: \n" + str);
        }
    }
}
