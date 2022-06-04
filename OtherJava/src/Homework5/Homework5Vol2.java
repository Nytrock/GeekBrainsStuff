package Homework5;

public class Homework5Vol2 {
    static Cat[] cats = new Cat[3];
    public static void main(String[] args) {
        cats[0] = new Cat("Kotya", 20);
        cats[1] = new Cat("Tema", 35);
        cats[2] = new Cat("Kesha", 25);
        int Volume = 100;
        int razm = Volume;
        for (int i = 0; i < 3; i++){
            if (cats[i].appetit > Volume){
                System.out.println(cats[i].name + " satiety = false;" +  " аппетит: " + cats[i].appetit + "; еды осталось " + Volume + ", её не хватает для этого кота; миска общая, её размер " + razm);
            }
            else {
                Volume -= cats[i].appetit;
                System.out.println(cats[i].name + " satiety = true;"  +  " аппетит: " + cats[i].appetit + "; еды осталось " + Volume  + "; миска общая, её размер " + razm);
            }
        }
    }

    public static class Animal {
        protected String name;
        protected int appetit;
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
        public Cat(String name, int appetit){
            this.name = name;
            MaxJump = 2;
            MaxRun = 200;
            this.appetit = appetit;
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