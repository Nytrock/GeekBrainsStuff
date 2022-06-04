package Homework4;

public class Homework4Vol1 {
    static Person[] persArray = new Person[5];
    public static void main(String[] args) {
        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        persArray[1] = new Person("Danilin Aleksandr", "Gypsy", "DanAlex@gmail.com", "88005553535", 10000, 44);
        persArray[2] = new Person("Zhezhera Eva", "Oldest profession", "SuperGirl_2000@mail.ru", "89107776969", 50000, 21);
        persArray[3] = new Person("Gorin Genady", "Blogger", "GenGorin@mailbox.com", "89323342654", 20000, 59);
        persArray[4] = new Person("Savva Zhirnov", "Freelancer", "savva.zhirnov@mail.ru", "89103313456", 35000, 26);
        System.out.println();
        System.out.println("Сотрудники больше 40:");
        for(int i = 0; i < 5; i++){
            if(persArray[i].age > 40){
                System.out.println("Name: " + persArray[i].name + ", job: " + persArray[i].job + ", email: " + persArray[i].email
                + ", phone: " + persArray[i].phone  + ", pay: " + persArray[i].pay + ", age: " + persArray[i].age);
            }
        }
    }

    public static class Person {
        private String name;
        private String job;
        private String email;
        private String phone;
        private int pay;
        private int age;
        public Person(String name, String job, String email, String phone, int pay, int age){
            this.name = name;
            this.job = job;
            this.email = email;
            this.phone = phone;
            this.pay = pay;
            this.age = age;
            System.out.println("Написано методом. Name: " + name + ", job: " + job + ", email: " + email + ", phone: " + phone  + ", pay: " + pay + ", age: " + age);
        }
    }
}
