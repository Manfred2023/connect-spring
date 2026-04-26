package net.campus.connect.clientDto;

public class StudentTimeTable {
    private   Integer studentId;

    public StudentTimeTable(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}
