package model;

/**
 * @Description TODO
 * @Author hq
 * @Date 2022/7/26 18:22
 * @Version 1.0
 */
public class EmployeeExtend extends Employee {
    private Status status;

    public EmployeeExtend(String name, Integer age, Double salary, Status status) {
        super(name, age, salary);
        this.status = status;
    }

    public EmployeeExtend() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public enum Status{
      WORKING,
      SLEEPING,
      VOCATION
   }
}
