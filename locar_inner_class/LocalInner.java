package locar_inner_class;

public class LocalInner {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();
    }

}

class Math {
    public void getResult(){
        class Delenine{
            private int delimoe;
            private int delitel;

            public int getDelimoe() {
                return delimoe;
            }

            public void setDelimoe(int delimoe) {
                this.delimoe = delimoe;
            }

            public int getDelitel() {
                return delitel;
            }

            public void setDelitel(int delitel) {
                this.delitel = delitel;
            }

            public int getChastnoe() {
                return delimoe/delitel;
            }

        }

        Delenine delenine = new Delenine();
        delenine.setDelimoe(21);
        delenine.setDelitel(4);
        System.out.println("Delimoe = " + delenine.getDelimoe());
        System.out.println("Delitel = " + delenine.getDelitel());
        System.out.println("Chastnoe = " + delenine.getChastnoe());
    }
}