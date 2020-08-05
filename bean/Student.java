package version2.bean;

public class Student {
    private int id;
    private String name;
    private int age;
    private int pyhton;
    private int java;
    private int linux;
    private int sql;
    private int avg;
    private int sum;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPyhton() {
        return pyhton;
    }

    public void setPyhton(int pyhton) {
        this.pyhton = pyhton;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getLinux() {
        return linux;
    }

    public void setLinux(int linux) {
        this.linux = linux;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name +"'"+
                ", age=" + age +
                ", pyhton=" + pyhton +
                ", java=" + java +
                ", linux=" + linux +
                ", sql=" + sql +
                ", avg=" + avg +
                ", sum=" + sum +
                '}';
    }
}
