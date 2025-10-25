## Difference between Spring Date JPA vs JPA vs Hibernate vs JDBC
* All types helps spring to interact with Database with different approach.
    
    ## JDBC
    * This is the main and legacy approach to interact with database.
        #
            @Entity 
            public class Employee {
                private int id;
                private String name;
                private String gender;
                //getters and setters
            }
            
            @Repository
            public class EmployeeDao {

                private final JdbcTemplate jdbcTemplate;

                public EmployeeDao(JdbcTemplate jdbcTemplate) {
                    this.jdbcTemplate = jdbcTemplate;
                }

                public List<Employee> findByNameAndGender(String name, String gender) {
                    String sql = "SELECT * FROM employee WHERE name = ? AND gender = ?";
                    return jdbcTemplate.query(sql, new EmployeeMapper(), name, gender);
                }   
            }
            
            public class EmployeeMapper implements RowMapper<Employee> {

                @Override
                public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Employee emp = new Employee();
                    emp.setId(rs.getInt("id"));
                    emp.setName(rs.getString("name"));
                    emp.setGender(rs.getString("gender"));
                    return emp;
                }
            }
    * JdbcTemplate drawback, Since it's not an ORM tool, it can't map resultset directly to the class. An external mapper implements `RowMapper<Employee>` needs to map to the specified class
    * Here `EmployeeMapper` is mapper class which is helping jdbcTemplate to map the resultset each rows to `Employee` class.
  
    ## Hibernate
    * `Hibernate` is `ORM` tool (Object Relational Mapping) which helps to map a Java classes and fields with DB tables and columns.
    * `Hibernate` is an implementation of `JPA`.
        #
            @Entity
            @Table(name = "employee")
            public class Employee {
                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @Column(name = "id")
                private int id;
                @column(name = "name")
                private String name;
                @column(name = "gender")
                private String gender;
                //getters and setters
            }
        * `@Entity`, `@column`, `@Table`, `@Id`* are the `JPA` annotations, Hibernate use them to map with DB table and column.
        #
            @Repository
            public class EmployeeDao {

                @Autowired
                private final SessionFactory factory;

                public List<Employee> findByNameAndGender(String name, String gender) {
                    try (Session session = sessionFactory.openSession()) {
                    
                    String hql = "FROM Employee WHERE name = :name AND gender = :gender";
                    
                    //we can write like this also
                    String hql = "SELECT e FROM Employee e WHERE e.name = :name AND e.gender = :gender";
                    
                    Query<Employee> query = session.createQuery(hql, Employee.class);
                    query.setParameter("name", name);
                    query.setParameter("gender", gender);
                    return query.list(); // Returns a list of employees
                }
            }
        * In query `Hibernate` allows us to use directly class_name and attribute_name instead of database table_name and column_name, since this mapping is done through adding `@Column` and `@Table`.
    * Hibernate drawback, It is an ORM tool like that we were having other tools like `EclipseLink`, all of them having their own implementations to interact with database, therefore it was difficult to switch between them
    
    # JPA (EntityManager (Interface))
    * JPA is a specification above `Hibernate` and other `ORM` tools. It defines standard set of methods that are implemented by other `ORM` tools
    * In `Hibernate` case `SessionImpl` class implements the `EntityManager` methods.
    * `JPA (EntityManager)` is an abstraction layer over all ORM tools like `Hibernate`, etc..
        #
            @Repository
            public class EmployeeDao {

                @PersistenceContext
                private final EntityManager em;

                public List<Employee> findByNameAndGender(String name, String gender) {
                    try (Session session = sessionFactory.openSession()) {
                    
                    String hql = "FROM Employee WHERE name = :name AND gender = :gender";
                    
                    //we can write like this also
                    String hql = "SELECT e FROM Employee e WHERE e.name = :name AND e.gender = :gender";
                    
                    return em.createQuery(hql, Employee.class)
                        .setParameter("name", name)
                        .setParameter("gender", gender)
                        .getResultSet()
                }
            }
        * `EntityManager` itself is a `JPA` which can help `Hibernate` to interact with database like it helps to other `ORM` tools.
    
    # Spring Data JPA
    * Spring Data JPA is a module that it is a Spring Boot project which was introduced to reduce even more boilerplate.
    * `Spring Data JPA` is an abstraction layer over `JPA`, provides different methods to persist, fetch, etc. data.
        #
            @Repository
            public interface EmployeeDao extends JpaRepository<Employee, Integer> {
                List<Employee> findByNameAndGender(String name, String gender);
            }
        * `JpaRepository` interface belongs to `Spring Boot JPA` it is not belongs to JPA
        * Its implementation like `SimpleJpaRepository` use `EntityManager` to interact with database.
        * Here **findByNameAndGender** is a **Derived** queries in `Spring Data JPA` auto-generate SQL from method names.
        #
            findByNameAndGender -> "FROM Employee WHERE name = :name and gender = :gender".
        