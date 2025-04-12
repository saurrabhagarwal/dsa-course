package dsa.javaCourse;


enum Department {
    CS("Head1", "Loc1"), IT("Head2", "Loc2"), CIVIL("Head3", "Loc3"), EE("Head4", "Loc4");

    final String head;
    final String loc;

    Department(String head, String loc) {
        this.head = head;
        this.loc = loc;
    }

    public void display() {
        System.out.println(this.name() + "  " + this.ordinal());
        System.out.println(this.head + "  " + this.loc);
    }

    @Override
    public String toString() {
        return "Department{" +
                ", name='" + this.name() + '\'' +
                ", ordinal='" + this.ordinal() + '\'' +
                "head='" + head + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}

public class EnumLearn {
    public static void main(String[] args) {
        Department[] departments = Department.values();
        for (Department department : departments) {
            System.out.println(department);
        }
        System.out.println(Department.valueOf("IT").ordinal());
        Department.valueOf("IT").display();
    }
}
