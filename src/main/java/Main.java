import controllers.Menu;

public class Main {

    static Menu menu = new Menu(); //одно меню, поэтому static (STATIC - только один оригинал)

    public static void main(String[] args) {

//    Main app = new Main();  эти строки нужны если Menu menu = new Menu(); не статик
//    app.menu.showHomeScreen();

        menu.showHomeScreen();

    }
}
