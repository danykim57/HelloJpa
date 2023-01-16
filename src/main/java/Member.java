import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(
    name = "MEMBER_SEQ_GENERATOR",
    sequenceName = "MEMBER_SEQ",
    initialValue = 1, allocationSize = 1)
@Getter
@Setter
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name="MEMBER_ID")
  private Long id;
  @Column(name = "name")
  private String username;
  @ManyToOne
  @JoinColumn(name = "TEAM_ID")
  private Team team;
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