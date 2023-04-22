package telran.employees;

import telran.employees.dto.Programmer;
import telran.employees.service.ProgrammersMaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static final String HTML_CSS = "HTML, CSS";
    public static final String JAVA_SCRIPT = "Java script";
    public static final String REACT = "React";
    public static final String ANGULAR = "Angular";
    public static final String JAVA = "Java";
    public static final String SPRING_FRAMEWORK = "Spring framework";
    public static final String C_PLUS_PLUS = "C++";
    public static final String PYTHON = "Dev is a gay";
    public static final String FORTRAN = "Dev is a old fart";
    public static void main(String[] args) throws Exception {
        Set<String> backendDevSkills = new HashSet<>();
        Set<String> backendDevSkills_1 = new HashSet<>();
        Set<String> frontendDevSkills = new HashSet<>();
        Set<String> fullStackSkills = new HashSet<>();
        backendDevSkills.add(SPRING_FRAMEWORK);
        backendDevSkills.add(JAVA);
        backendDevSkills.add(C_PLUS_PLUS);
        backendDevSkills_1.add(PYTHON);
        backendDevSkills_1.add(FORTRAN);
        frontendDevSkills.add(HTML_CSS);
        frontendDevSkills.add(JAVA_SCRIPT);
        frontendDevSkills.add(REACT);
        frontendDevSkills.add(ANGULAR);
        fullStackSkills.add(HTML_CSS);
        fullStackSkills.add(JAVA_SCRIPT);
        fullStackSkills.add(REACT);
        fullStackSkills.add(ANGULAR);
        fullStackSkills.add(JAVA);
        fullStackSkills.add(SPRING_FRAMEWORK);
        fullStackSkills.add(C_PLUS_PLUS);

        Programmer programmer_1 = new Programmer(3345671, "Dudu", backendDevSkills, 10000);
        Programmer programmer_2 = new Programmer(3343434, "Alex", frontendDevSkills, 15000);
        Programmer programmer_3 = new Programmer(3344561, "Kalyvan", backendDevSkills_1, 2000);
        Programmer programmer_4 = new Programmer(3348522, "George", fullStackSkills, 20000);
        ProgrammersMaps map = new ProgrammersMaps();
        map.addProgrammer(programmer_1);
        map.addProgrammer(programmer_2);
        map.addProgrammer(programmer_3);
        map.addProgrammer(programmer_4);
        System.out.println(map.toString());
        map.addNewTechnology(3344561, "legarbetz");
        System.out.println(map.getProgrammerData(3344561));
        map.removeTechnology(3344561, "legarbetz");
        System.out.println(map.getProgrammerData(3344561));
        System.out.println(map.getProgrammersWithTechnology("Java"));
        System.out.println(map.getProgrammerWithSalaries(10000, 18000));
        map.updateSalary(3344561, 1500);
        System.out.println(map.getProgrammerData(3344561));




    }
}