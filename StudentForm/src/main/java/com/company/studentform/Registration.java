/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.studentform;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;



import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Server
 */

@Named
//@ViewScoped
@ManagedBean
@SessionScoped
public class Registration implements Serializable {
    
    private Map<String, Map<String,String>> listFaculty=new HashMap<String,Map<String,String>>();
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String faculty;
    private String program;
    private Map<String,String> faculties;
    private Map<String,String> programs;
    private ArrayList<Registration> registrationList;
    
    //setter & getter
    
    public ArrayList<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(ArrayList<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    public Map<String, Map<String, String>> getListCountry() {
        return listFaculty;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getProgram() {
        return program;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public Map<String, String> getFaculties() {
        return faculties;
    }

    public void setFaculties(Map<String, String> faculties) {
        this.faculties = faculties;
    }

    public Map<String, String> getPrograms() {
        return programs;
    }

    public void setPrograms(Map<String, String> programs) {
        this.programs = programs;
    }
 //Constructor Registration
public Registration(){
    registrationList=new ArrayList<>();
    faculties =new HashMap<String,String>();
    faculties.put("Management","Management");
    faculties.put("Science & Technology","Science & Technology");
    Map<String,String> map=new HashMap<String,String>();
    map.put("BBA", "BBA");
    map.put("BBS", "BBS");
    listFaculty.put("Management", map);
    
    Map<String,String> map2=new HashMap<String,String>();
    map2.put("BE. Comp", "BE. Comp");
    map2.put("BCA","BCA");
    listFaculty.put("Science & Technology",map2);   
}
 
 public void onFacultyChange(){
     if(faculty !=null && !faculty.equals(""))
        programs=listFaculty.get(faculty);
     else
         programs=new HashMap<String,String>();
 }
 
 //method for submit value to display in datatable
 public void submitRegistrationForm(){
     Registration rs=new Registration();
     
     rs.setFirstName(FirstName);
     rs.setMiddleName(MiddleName);
     rs.setLastName(LastName);
     rs.setFaculty(faculty);
     rs.setProgram(program);
     
      registrationList.add(rs);

     this.FirstName=null;
     this.MiddleName=null;
     this.LastName=null;
     this.faculty=null;
     this.program=null;
 }
 
 //Delete method
 public void deleteRow(Registration r){
  registrationList.remove(r);
 }
 //For edit method
 public void editRow(Registration r){
     FirstName=r.FirstName;
     MiddleName=r.MiddleName;
     LastName=r.LastName;
     faculty=r.faculty;
     program=r.program;
     deleteRow(r);
 }
    
}
