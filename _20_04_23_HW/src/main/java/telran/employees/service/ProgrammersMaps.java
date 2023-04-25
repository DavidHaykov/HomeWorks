package telran.employees.service;

import telran.employees.dto.Programmer;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class ProgrammersMaps implements IProgrammer{
    protected HashMap<Integer, Programmer> programmers;
    protected HashMap<String, List<Programmer>> techProgrammers;
    protected TreeMap<Integer, List<Programmer>> salaryProgrammers;
    public ProgrammersMaps() {
        programmers = new HashMap<>();
        techProgrammers = new HashMap<>();
        salaryProgrammers = new TreeMap<>();
    }


    @Override
    public boolean addProgrammer(Programmer programmer) {
        if (programmers.containsKey(programmer.getId())) {
            return false;
        }
        programmers.putIfAbsent(programmer.getId(), programmer);
        for( String technology  : programmer.getTechnologies()){
            techProgrammers.computeIfAbsent(technology, new Function<String, List<Programmer>>() {
                        @Override
                        public List<Programmer> apply(String s) {
                            return new ArrayList<>();
                        }
                    });
            techProgrammers.get(technology).add(programmer);
            int salary = programmer.getSalary();
            salaryProgrammers.computeIfAbsent(salary, new Function<Integer, List<Programmer>>() {
                @Override
                public List<Programmer> apply(Integer integer) {
                    return new ArrayList<>();
                }
            });
            salaryProgrammers.get(salary).add(programmer);
        }
        return true;

    }

    @Override
    public boolean removeProgrammer(int id) {
        Programmer programmer = programmers.get(id);
        if(programmer == null ){
            return false;
        }
        for( String technology : programmer.getTechnologies()){
            List<Programmer> programmerList = techProgrammers.get(technology);
            if(programmerList!= null){
                programmerList.remove(programmer);
                if(programmerList.isEmpty()){
                    techProgrammers.remove(technology);
                }
            }
        }
        int salary = programmer.getSalary();
        List<Programmer> programmerList = salaryProgrammers.get(salary);
        if(programmerList!=null){
            programmerList.remove(programmer);
            if(programmerList.isEmpty()){
                salaryProgrammers.remove(salary);
            }
        }


        return true;
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
        programmer.getTechnologies().add(technology);
        if(!techProgrammers.containsKey(technology)){
            techProgrammers.put(technology, new ArrayList<>());
        }
        List<Programmer> programmerList = techProgrammers.get(technology);
//        if(programmerList==null){
//            techProgrammers.put(technology, new ArrayList<>());
//        }
        programmerList.add(programmer);
        return true;
    }

    @Override
    public boolean removeTechnology(int id, String technology) {
        Programmer programmer = programmers.get(id);
        if(technology == null || technology.equals("") || !programmer.getTechnologies().contains(technology)){
            return false;
        }
        programmer.getTechnologies().remove(technology);
        List<Programmer> programmerList = techProgrammers.get(technology);
        if(programmerList!= null){
            programmerList.remove(programmer);
            if(programmerList.isEmpty()){
                techProgrammers.remove(technology);
            }
        }

        return true;

    }

    @Override
    public List<Programmer> getProgrammersWithTechnology(String technology) {
        return techProgrammers.get(technology);
    }

    @Override
    public List<Programmer> getProgrammerWithSalaries(int salaryFrom, int salaryTo) {
        List<Programmer> res = new ArrayList<>();
        for(List<Programmer> programmersList : salaryProgrammers.subMap(salaryFrom, salaryTo).values()){
            res.addAll(programmersList);
        }
        return res;
    }

    @Override
    public boolean updateSalary(int id, int salary) throws Exception {
        if(!programmers.containsKey(id) || programmers.get(id).getSalary() == salary) {
            return false;
        }
        Programmer programmer = programmers.get(id);
        int oldSalary = programmer.getSalary();
        List<Programmer> programmerList = salaryProgrammers.get(oldSalary);
        programmerList.remove(programmer);
        if(!salaryProgrammers.containsKey(salary)){
            salaryProgrammers.put(salary, new ArrayList<>());
        }
        salaryProgrammers.get(salary).add(programmer);
        programmers.get(id).setSalary(salary);
        return true;
    }

    @Override
    public String toString() {
        return "ProgrammersMaps{" +
                "\nPROGRAMMERS MAP" + programmers +
                ", \n\nTECH PROGRAMMERS MAP" + techProgrammers +
                ", \n\nSALARY PROGRAMMERS MAP" + salaryProgrammers +
                '}';
    }
}
