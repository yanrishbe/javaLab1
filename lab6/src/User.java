//когда метод возвращает объект и нам не нужно
// его куда-то сохранить(в переменную) то необязательно присваивать
// его какой-то переменной и тогда можно вызывать таким способом

public class User {
    public static void main(String[] args) {
        Reader shop = new Reader ("Grocery store supply registration");
        shop.setVisible(true);
        shop.setResizable(false);
        shop.setLocationRelativeTo(null);
    }
}

