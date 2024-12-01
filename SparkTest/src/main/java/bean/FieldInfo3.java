package bean;


import lombok.AllArgsConstructor;
import lombok.Data;

public class FieldInfo3 {
     private String name;
     private Integer age;
     private Boolean isStu;

     public FieldInfo3(String name, Integer age, Boolean isStu) {
          this.name = name;
          this.age = age;
          this.isStu = isStu;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public Integer getAge() {
          return age;
     }

     public void setAge(Integer age) {
          this.age = age;
     }

     public Boolean getStu() {
          return isStu;
     }

     public void setStu(Boolean stu) {
          isStu = stu;
     }
}
