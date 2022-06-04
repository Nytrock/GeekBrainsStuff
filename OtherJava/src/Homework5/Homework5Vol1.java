package Homework5;

public class Homework5Vol1 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Kotya", 20, 70);
        Cat cat2 = new Cat("Tema", 35, 100);
        Dog dog1 = new Dog("Recks");
        cat1.eat();
        cat2.eat();
        cat1.eat();
    }

    public static class Animal {
        protected String name;
        protected int appetit;
        protected int Volume;
        public int razm;
        private int run;
        private int swim;
        private int jump;
        public int MaxRun;
        public int MaxSwim;
        public float MaxJump;
        public void run(int run){
            if(run <= MaxRun){
                System.out.print(name + " run:true\n");
            }
            else{
                System.out.print(name + " run:false\n");
            }
        }
        public void swim(int swim){
            if(swim <= MaxSwim){
                System.out.print(name + " swim:true\n");
            }
            else{
                System.out.print(name + " swim:false\n");
            }
        }
        public void jump(float jump){
            if(jump <= MaxJump){
                System.out.print(name + " jump:true\n");
            }
            else{
                System.out.print(name + " jump:false\n");
            }
        }
    }

    public static class Cat extends Animal {
        int i;
        public Cat(String name, int appetit, int Volume){
            this.name = name;
            MaxJump = 2;
            MaxRun = 200;
            this.appetit = appetit;
            this.Volume = Volume;
            this.razm = Volume;
        }
        public void eat(){
            if (appetit > Volume){
                System.out.println(name + " satiety = false;" + " аппетит: " + appetit + "; еды осталось " + Volume + ", к следующей кормёжке она заполнится; миска принажлежит только ему, её размер " + razm + "; раз покушал: " + i);
                Volume = razm;
            }
            else {
                Volume -= appetit;
                i++;
                System.out.println(name + " satiety = true;" + " аппетит: " + appetit + "; еды осталось " + Volume  + "; миска принажлежит только ему, её размер " + razm + "; раз покушал: " + i);
            }
        }
        public void swim(int swim){
            System.out.print(name + " swim:false\n");
        }
    }

    public static class Dog extends Animal {
        public Dog(String name){
            this.name = name;
            MaxJump = 0.5f;
            MaxRun = 500;
            MaxSwim = 10;
        }
    }
}