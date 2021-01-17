public class GNSStudent {
    private String studentName, streetAddress, city, state;
    private int zip, studentID;
    private int averageExamScore, averageExamScoreAlt;

    public GNSStudent() {
        studentName = "";
        streetAddress = "";
        city = "";
        state = "";
        zip = 0;
        studentID = 0;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        studentName = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String address) {
        streetAddress = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String cityName) {
        city = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String stateName) {
        state = stateName;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zipNum) {
        zip = zipNum;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentIDNum) {
        studentID = studentIDNum;
    }

    public int calculateStudentAverage(int exam1, int exam2, int exam3, int exam4, int finalExam, int hwAndParticipation) {
        averageExamScore += (exam1 + exam2 + exam3 + exam4 + finalExam + finalExam) * 0.8;
        averageExamScore += hwAndParticipation * 0.2;
        return averageExamScore;
    }
    public int calculateStudentAverageAlt(int exam1, int exam2, int exam3, int finalExam, int programmingProjects,
                                          int hwAndParticipation) {
        averageExamScoreAlt += (exam1 + exam2 + exam3 + finalExam + finalExam) * 0.5;
        averageExamScoreAlt += programmingProjects * 0.3;
        averageExamScoreAlt += hwAndParticipation * 0.2;
        return averageExamScoreAlt;
    }

    public int qualityPoints(int averageExam) {
        if(averageExam >= 90 && averageExam <= 100) {
            return 4;
        }
        if(averageExam >= 80 && averageExam <= 89) {
            return 3;
        }
        if(averageExam >= 70 && averageExam <= 79) {
            return 2;
        }
        if(averageExam >= 65 && averageExam <= 69) {
            return 1;
        }
        if(averageExam < 60) {
            return 0;
        }
        return -1;
    }

    public String toString() {
        String studentInfo = "";
        studentInfo += "Student Name: " + studentName + "\n";
        studentInfo += "Student Street Address: " + streetAddress + "\n";
        studentInfo += "Student City: " + city + "\n";
        studentInfo += "Student Zip: " + zip + "\n";
        studentInfo += "StudentID:" + studentID + "\n";

        return studentInfo;
    }

}

