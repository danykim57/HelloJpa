import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@TableGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    table = "MY_SEQUENES",
    pkColumnValue = "MEMBER_SEQ", allocationSize = 1)
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column(name = "name")
  private String username;

  private Integer age;
  @Enumerated(EnumType.STRING)
  private RoleType roleType;
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;
  @Lob
  private String description;
}