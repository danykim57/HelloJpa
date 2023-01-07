import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MBR")
@Getter
@Setter
public class Member {
  @Id
  long id;
  String name;
}
