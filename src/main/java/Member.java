import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
  private List<MemberProduct> memberProductList = new ArrayList<>();
  private String createBy;
  private LocalDateTime createDate;
  private String lastModifiedBy;
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;
  @Lob
  private String description;

}