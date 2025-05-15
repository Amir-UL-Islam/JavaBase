import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Company {

    public static List<Department> departments;

    public Company() {
    }

    public Company(List<Department> dts) {
        departments = dts;
    }

    public static Map<DepartmentCode, BigDecimal> costPerDepartment() {
        Map<DepartmentCode, BigDecimal> costPerDepartment = new HashMap<>();
        departments.forEach(department -> {
            DepartmentCode departmentCode = department.getCode();
            BigDecimal employeesCost = department.getDivisions().stream()
                    .map(Division::getTeams).flatMap(List::stream)
                    .map(Team::getMembers).flatMap(List::stream)
                    .map(Member::getCost).reduce(BigDecimal.ZERO, BigDecimal::add);
            costPerDepartment.put(departmentCode, employeesCost);
        });
        return costPerDepartment;
    }

    public static void main(String[] args) {
        Department hr = new Department(
                new DepartmentCode("HR"),
                List.of(
                        new Division(List.of(
                                new Team(List.of(
                                        new Member(new BigDecimal("50000")),
                                        new Member(new BigDecimal("55000"))))))));

        Department engineeringDepartment = new Department(
                new DepartmentCode("ENG"),
                List.of(
                        new Division(List.of(
                                new Team(List.of(
                                        new Member(new BigDecimal("50000")),
                                        new Member(new BigDecimal("55000"))))))));

        Company company = new Company(List.of(hr, engineeringDepartment));

        Map<DepartmentCode, BigDecimal> costs = company.costPerDepartment();
        for (Map.Entry<DepartmentCode, BigDecimal> entry : costs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

class Department {
    private DepartmentCode code;
    private List<Division> divisions;

    // Constructor, getters, and setters
    public Department(DepartmentCode code, List<Division> divisions) {
        this.code = code;
        this.divisions = divisions;
    }

    public DepartmentCode getCode() {
        return code;
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    @Override
    public String toString() {
        return "Department [code=" + code + ", divisions=" + divisions + "]";
    }

}

class Division {
    private List<Team> teams;

    public Division(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public String toString() {
        return "Division [teams=" + teams + "]";
    }

}

class DepartmentCode {
    private String code;

    public DepartmentCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "DepartmentCode [code=" + code + "]";
    }

}

class Team {
    private List<Member> members;

    public Team(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return members;
    }
}

class Member {
    private BigDecimal cost;

    public Member(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
