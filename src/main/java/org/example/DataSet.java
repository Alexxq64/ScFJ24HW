package org.example;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "dataSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataSet {

    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    private List<Student> studentList;

    @XmlElementWrapper(name = "universities")
    @XmlElement(name = "university")
    private List<University> universityList;

    @XmlElementWrapper(name = "statisticalData")
    @XmlElement(name = "statistics")
    private List<Statistics> statisticsList;

    @XmlElement(name = "execDate")
    private Date execDate;

    public DataSet() {
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public DataSet setStudentList(List<Student> studentList) {
        this.studentList = studentList;
        return this;
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public DataSet setUniversityList(List<University> universityList) {
        this.universityList = universityList;
        return this;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public DataSet setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
        return this;
    }

    public Date getExecDate() {
        return execDate;
    }

    public DataSet setExecDate(Date execDate) {
        this.execDate = execDate;
        return this;
    }
}