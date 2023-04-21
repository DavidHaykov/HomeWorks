package telran.employees.service;

import telran.employees.dto.Programmer;

import java.util.HashMap;
import java.util.List;

public class ProgrammersMaps implements IProgrammer{
    protected HashMap<Integer, Programmer> programmers;

    public ProgrammersMaps(HashMap<Integer, Programmer> programmers) {
        this.programmers = programmers;
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

        return false;
    }

    @Override
    public boolean removeTechnology(int id, String technology) {
        return false;
    }

    @Override
    public List<Programmer> getProgrammersWithTechnology(String technology) {
        return null;
    }

    @Override
    public List<Programmer> getProgrammerWithSalaries(int salaryFrom, int salaryTo) {
        return null;
    }

    @Override
    public boolean updateSalary(int id, int salary) {
        return false;
    }
}
