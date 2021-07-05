public class PersonBuilder implements Builder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder() {
    }

    public PersonBuilder(String surname, String address) {
        this.surname = surname;
        this.address = address;
    }

    @Override
    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilder setSurname(String surname) {
        if (surname == null) {
            throw new IllegalStateException("Вы должны запонить поле 'фамилия'!");
        } else {
            this.surname = surname;
            return this;
        }
    }

    @Override
    public PersonBuilder setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным!");
        } else {
            this.age = age;
            return this;
        }
    }

    @Override
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (name == null && surname == null){
            throw new IllegalStateException("Заполните обязательные поля 'имя' и 'фамилия'!");
        } else return new Person(name, surname, age, address);
    }
}
