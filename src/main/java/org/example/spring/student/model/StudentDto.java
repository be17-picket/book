import org.example.spring.student.model.StudentEntity;

public class StudentDto {
    public static class Student {
        private Integer idx;
        private String name;
        private Integer age;

        public static StudentDto.Student from(StudentEntity entity) {
            StudentDto.Student dto  = new StudentDto.Student();
            dto.setIdx(entity.getIdx());
            dto.setName(entity.getName());
            dto.setAge(entity.getAge());

            return dto;
        }

        public Integer getIdx() {
            return idx;
        }

        public void setIdx(Integer idx) {
            this.idx = idx;
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
    }


    public static class Register {
        private String name;
        private Integer age;

        public StudentEntity toEntity() {
            StudentEntity entity = new StudentEntity();
            entity.setName(name);
            entity.setAge(age);
            return entity;
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
    }
}
