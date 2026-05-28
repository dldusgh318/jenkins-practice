package teacher;

public class Teacher {

    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    public String teach(String topic) {
        return name + " 선생님이 " + topic + "을(를) 가르칩니다.";
    }

    public static void main(String[] args) {
        Teacher t = new Teacher("김선생");
        System.out.println(t.teach("자바"));
    }

}
