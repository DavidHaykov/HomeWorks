package telran.employees.service;

import telran.employees.dto.Programmer;

import java.util.List;

public interface IProgrammer {
    boolean addProgrammer(Programmer programmer);
    boolean removeProgrammer(int id);
    Programmer getProgrammerData(int id);
    boolean addNewTechnology(int id, String technology);
    boolean removeTechnology(int id, String technology);
    List<Programmer> getProgrammersWithTechnology(String technology);
    List<Programmer> getProgrammerWithSalaries(int salaryFrom, int salaryTo);
    boolean updateSalary(int id, int salary) throws Exception;
}
