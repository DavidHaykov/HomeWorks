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
        programmers.put(programmer.getId(), programmer);
        return true;
    }

    @Override
    public boolean removeProgrammer(int id) {
        if(!programmers.containsKey(id)){
            return false;
        }else {
            programmers.remove(id);
            return true;
        }
    }

    @Override
    public Programmer getProgrammerData(int id) {
        return programmers.get(id);
    }

    @Override
    public boolean addNewTechnology(int id, String technology) {
        if(!programmers.containsKey(id)){
            return false;
        }
        programmers.get(id).getTechnologies().add(technology);
        return true;
    }

    @Override
    public boolean removeTechnology(int id, String technology) {
        if(!programmers.containsKey(id) || !programmers.get(id).getTechnologies().contains(technology)) {
            return false;
        }
        programmers.get(id).getTechnologies().remove(technology);
        return true;
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
