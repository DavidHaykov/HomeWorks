package telran.employees.service;

import telran.employees.dto.Programmer;

import java.util.*;

public class ProgrammersMaps implements IProgrammer{
    protected HashMap<Integer, Programmer> programmers;

    public ProgrammersMaps() {
        programmers = new HashMap<>();
    }


    @Override
    public boolean addProgrammer(Programmer programmer) {
        if (programmers.containsKey(programmer.getId())) {
            return false;
        }
        programmers.putIfAbsent(programmer.getId(), programmer);
        return true;
    }

    @Override
    public boolean removeProgrammer(int id) {
        return programmers.remove(id) != null;
    }

    @Override
    public Programmer getProgrammerData(int id) {
        return programmers.get(id);
    }

    @Override
    public boolean addNewTechnology(int id, String technology) {
        Programmer programmer = programmers.get(id);
        if(technology == null || technology.equals("")){
            return false;
        }
        return programmer != null && programmer.getTechnologies().add(technology);
    }

    @Override
    public boolean removeTechnology(int id, String technology) {
        Programmer programmer = programmers.get(id);
        if(technology == null || technology.equals("") || !programmer.getTechnologies().contains(technology)){
            return false;
        }
        return programmer.getTechnologies().remove(technology);

    }

    @Override
    public List<Programmer> getProgrammersWithTechnology(String technology) {
        List<Programmer> programmersWithTechnologies = new ArrayList<>();
        for (Programmer e:
             programmers.values()) {
            if(e.getTechnologies().contains(technology)) {
                programmersWithTechnologies.add(e);
            }
        }
        return programmersWithTechnologies;
    }

    @Override
    public List<Programmer> getProgrammerWithSalaries(int salaryFrom, int salaryTo) {
        List<Programmer> programmersInSalaryRange = new ArrayList<>();
        for (Programmer e : programmers.values()){
            if(e.getSalary()>=salaryFrom && e.getSalary()<salaryTo){
                programmersInSalaryRange.add(e);
            }
        }
        return programmersInSalaryRange;
    }

    @Override
    public boolean updateSalary(int id, int salary) throws Exception {
        if(!programmers.containsKey(id) || programmers.get(id).getSalary() == salary) {
            return false;
        }
        programmers.get(id).setSalary(salary);
        return true;
    }

    @Override
    public String toString() {
        return "ProgrammersMaps{\n" +
                "programmers=\n" + programmers +
                '}';
    }
}
